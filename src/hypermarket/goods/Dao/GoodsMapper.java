package hypermarket.goods.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hypermarket.goods.bean.Goods;

public interface GoodsMapper {
	// 获取所有商品
	List<Goods> getList(Goods goods);

	// 根据条件查询数据的总量
	int getCount(Goods goods);
	// 根据分类的id删除商品

	int deleteById(@Param("id")long id);

	// 根据分类的id查询本条记录
	Goods getById(@Param("id")long id);

	// 修改商品详情
	int updateById(Goods bean);

	// 添加商品
	int saveGoods(Goods bean);

	// 商品上下架
	int updateStatus(Goods bean);

}
