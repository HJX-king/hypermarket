package hypermarket.goods.service;

import java.util.List;
import hypermarket.goods.Dao.GoodsMapper;
import hypermarket.goods.bean.Goods;
import hypermarket.utils.SqlUtils2;

public class GoodsService {
	GoodsMapper goodsMapper= null;

	
	/* private GoodsDao goodsDao =new GoodsDao(); */
	
	//查询所有商品分类
	
	public List<Goods> getList(Goods bean){
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		List<Goods> list=goodsMapper.getList(bean);
		SqlUtils2.release();
		return list;
	}
	
	//根据条件查询数据的总量
	public int getCount(Goods goods) {
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		int num=goodsMapper.getCount(goods);
		SqlUtils2.release();
		return num;
	}
	
	//根据分类的id删除分类
	
	public boolean deleteById(long id) {
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		int num=goodsMapper.deleteById(id);
		SqlUtils2.release();
		return num>0;
		
	}
	//根据分类id查询记录
	public  Goods getById(long id) {
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		Goods goods=goodsMapper.getById(id);
		SqlUtils2.release();
		return goods;
	}
	//修改分类详情
	public boolean updateGoods(Goods bean) {
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		
		int num=0;
		if(bean.getId()>0) {//已存在,修改
			num=goodsMapper.updateById(bean);
		}else {//不存在,添加
			bean.setCreate_time(System.currentTimeMillis());
			num=goodsMapper.saveGoods(bean);
		}
		SqlUtils2.release();
		return num>0;
	}
	//上下架
	public boolean updateStatus(Goods goods) {
		goodsMapper= SqlUtils2.getMapper(GoodsMapper.class);
		int num =goodsMapper.updateStatus(goods);
		SqlUtils2.release();
		return num>0;
	}

}
