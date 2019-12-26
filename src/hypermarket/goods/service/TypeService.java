package hypermarket.goods.service;

import java.util.List;
import hypermarket.goods.Dao.TypeMapper;
import hypermarket.goods.bean.TypeBean;
import hypermarket.utils.SqlUtils2;

public class TypeService {

	

	/**
	 * 查询所有的商品分类信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<TypeBean> getList(TypeBean bean) {
		TypeMapper typeMapper = SqlUtils2.getMapper(TypeMapper.class);
		List<TypeBean> list = typeMapper.getList(bean);
		SqlUtils2.release();
		return list;
	}

	public int getCount(TypeBean bean) {
		TypeMapper typeMappper = SqlUtils2.getMapper(TypeMapper.class);
		int num = typeMappper.getCount(bean);
		SqlUtils2.release();
		return num;
	}

	/**
	 * 根据id删除分类
	 */
	public boolean deleteById(long id) {
		TypeMapper typeMappper = SqlUtils2.getMapper(TypeMapper.class);
		int num = typeMappper.deleteById(id);
		SqlUtils2.release();
		return num > 0;
	}

	/**
	 * 根据id查询分类的详细信息
	 */
	public TypeBean getById(long id) {
		TypeMapper typeMappper = SqlUtils2.getMapper(TypeMapper.class);
		
		TypeBean bean = typeMappper.getById(id);
		SqlUtils2.release();
		return bean;
	}

	public boolean updateType(TypeBean bean) {
		TypeMapper typeMappper = SqlUtils2.getMapper(TypeMapper.class);
		int num = 0;
		if (bean.getId() > 0) {
			num = typeMappper.updateById(bean);

		} else {
			num = typeMappper.saveType(bean);
		}
		SqlUtils2.release();
		return num > 0;
	}

	public List<TypeBean> getListAll() {
		TypeMapper typeMapper = SqlUtils2.getMapper(TypeMapper.class);
		List<TypeBean> list = typeMapper.getListAll();
		SqlUtils2.release();
		return list;
	}

}
