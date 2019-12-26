package hypermarket.goods.Dao;

import java.util.List;

import hypermarket.goods.bean.TypeBean;

public interface TypeMapper {
	// 查询出所有的分类(id和分类名),多选
	 List<TypeBean> getListAll();
	// 查询所有的商品分类详情,分页
	 List<TypeBean> getList(TypeBean bean);
	// 根据条件查询总条数
	 int  getCount(TypeBean bean);
	//根据分类的id删除分类
	 int deleteById(long id);
	//根据id 获取一个分类
	 TypeBean getById(long id);
	//修改分类
	 int updateById(TypeBean bean);
	//添加分类
	 int saveType(TypeBean bean);
}
