package hypermarket.goods.web;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hypermarket.goods.bean.TypeBean;
import hypermarket.goods.service.TypeService;
import hypermarket.user.bean.Users;
import hypermarket.utils.Pagetion;
import hypermarket.utils.ResponseMsg;

@Controller
@RequestMapping("/goods/")
public class TypeController {
	private TypeService typeService=new TypeService();
	//type
	//
	@RequestMapping("toMainPage")
	public String toMainPage(HttpSession session) {
		Users user =(Users)session.getAttribute("login");
		
		if(user!=null) {
			return "main";
		}else {
			return "login";
		}
	}
	@RequestMapping("deleteType")
	public String deleteType(TypeBean bean ,HttpSession session) {
		Users user =(Users)session.getAttribute("login");
		
		if(user!=null) {
			long id=bean.getId();
			typeService.deleteById(id);
			return "forward:/goods/toTypesPage";
		}else {
			return "login";
		}
	}
	@RequestMapping("toTypesPage")
	public String toTypesPage(TypeBean bean ,HttpSession session,HttpServletRequest req) {
		Users user =(Users)session.getAttribute("login");
		
		if(user!=null) {
			int count =typeService.getCount(bean);
			//设置分页
			String paging =Pagetion.paging(bean, count,"/hypermarket/goods/toTypesPage", req.getParameterMap());
			req.setAttribute("paging", paging);
			//在真正查数据之前, 一定要先去看看总共有多少条数据
			List<TypeBean> list=typeService.getList(bean);
			req.setAttribute("typeList", list);
			req.setAttribute("bean", bean);
//			return "forward:/WEB-INF/pages/types.jsp";
			return "types";
		}else {
			return "login";
		}
	}
	@ResponseBody
	@RequestMapping("updateType")
	public ResponseMsg updateType(TypeBean typeBean ,HttpSession session,HttpServletRequest req) {
		Users u =(Users)session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if(u!=null) {
			typeBean.setCreate_time(System.currentTimeMillis());
			typeBean.setUser_id(u.getId());
			
			boolean flg = typeService.updateType(typeBean);
			if(flg) {
				msg.setCode(1);
			}else {
				msg.setCode(-1);
				msg.setMessage("对不起, 操作失败");
			}
 			return msg;
		}else {
			msg.setCode(3);
			return msg;
		}
	}
	@ResponseBody
	@RequestMapping("getTypeById")
	public TypeBean getTypeById(TypeBean bean ,HttpSession session,HttpServletRequest req) {
		Users user =(Users)session.getAttribute("login");
		
		if(user!=null) {
			
 			TypeBean b=typeService.getById(bean.getId());
			
 			b.setId(bean.getId());
 			
 			return b;
		}else {
			bean.setErron("erron");
			return bean;
		}
	}
	

}
