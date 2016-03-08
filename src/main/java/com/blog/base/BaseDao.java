package com.blog.base;

import java.util.List;

/**
 * BaseDao 所有dao的顶级接口
 * @since 2016年2月1日 10:48:36
 * @author sylar
 *
 */
public interface BaseDao<Model> {

	/**
	 * 保存model
	 */
	void save(Model model);
	
	/**
	 * 根据id删除model
	 */
	void delete(Long id);
	
	/**
	 * model更新
	 */
	void update(Model model);
	
	/**
	 * 根据id取model
	 */
	Model getById(Long id);
	
	/**
	 * 获取所有model
	 */
	List<Model> getAll();
	
}
