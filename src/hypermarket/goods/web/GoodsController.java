package hypermarket.goods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hypermarket.goods.bean.Goods;
import hypermarket.goods.bean.TypeBean;
import hypermarket.goods.service.GoodsService;
import hypermarket.goods.service.TypeService;
import hypermarket.user.bean.Users;
import hypermarket.utils.Pagetion;
import hypermarket.utils.ResponseMsg;


@Controller
@RequestMapping("/goods/")
public class GoodsController {
	private GoodsService goodsService = new GoodsService();
	private TypeService typeService=new TypeService();

	@RequestMapping("toGoodsPage")
	public String toGoodsPage(Goods goods,HttpSession session ,HttpServletRequest req) {
		Users u = (Users)session.getAttribute("login");
		if (u != null) {
			
			int count = goodsService.getCount(goods);
			String paging = Pagetion.paging(goods, count, "/hypermarket/goods/toGoodsPage", req.getParameterMap());
			req.setAttribute("paging", paging);
			// 获取所有商品
			List<Goods> list = goodsService.getList(goods);
			req.setAttribute("list", list);
			// 查出所有分类
			List<TypeBean> typeList = typeService.getListAll();
			req.setAttribute("typeList", typeList);

			req.setAttribute("goods", goods);
			return "goods";
		} else {
			return "login";
		}

	}
	
	@ResponseBody
	@RequestMapping("updateGoods")
	public ResponseMsg updateGoods(Goods goods,HttpSession session ,HttpServletRequest req) {
		Users u = (Users)session.getAttribute("login");
		ResponseMsg msg=new ResponseMsg();
		if (u != null) {
			
			goods.setUser_id(u.getId());
			boolean flg=goodsService.updateGoods(goods);
			if(flg) {
				msg.setCode(1);
				msg.setMessage("操作成功");
			}else {
				msg.setCode(-1);
				msg.setMessage("操作失败");
			}
			
		}else {
			msg.setCode(3);
			msg.setMessage("对不起, 未登录");
		}
		return msg;

	}
	@RequestMapping("updateGoodsStatus")
	public String updateGoodsStatus(Goods goods,HttpSession session ,HttpServletRequest req) {
		Users u = (Users)session.getAttribute("login");
		if (u != null) {
			
			goods.setUser_id(u.getId());
			goodsService.updateStatus(goods);
			return "goods";
		} else {
			return "login";
		}

	}
	
	@RequestMapping("deleteGoods")
	public String deleteGoods(Goods goods,HttpSession session ,HttpServletRequest req) {
		Users u = (Users)session.getAttribute("login");
		if (u != null) {
			
			long id=goods.getId();
			goodsService.deleteById(id);
			return "goods";
		} else {
			return "login";
		}

	}
	@RequestMapping("toAddGoodsPage")
	public String toAddGoodsPage(Goods good,HttpSession session ,HttpServletRequest req) {
		Users u = (Users)session.getAttribute("login");
		if (u != null) {
			
			List<TypeBean> list =typeService.getListAll();
			req.setAttribute("types", list);
			
			//如果客户端传来的商品id ,我们认为,用户是要修改某个商品
			
			if(good.getId()>0) {
				long id =good.getId();
				//从数据库中查找这个id对应商品的信息
				Goods goods=goodsService.getById(id);
				req.setAttribute("goods", goods);
			}
			return "addGoods";
		} else {
			return "login";
		}

	}

}
