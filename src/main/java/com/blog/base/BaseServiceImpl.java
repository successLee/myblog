package com.blog.base;

import java.util.List;

/**
 * @since 2016年2月1日 11:57:10
 * @author sylar
 *
 * @param <Model>
 */
public abstract class BaseServiceImpl<Model> implements BaseService<Model> {

	public abstract BaseDao<Model> getDao();

	@Override
	public void save(Model model) {
		getDao().save(model);
	}

	@Override
	public void delete(Long id) {
		getDao().delete(id);
	}

	@Override
	public void update(Model model) {
		getDao().update(model);
	}

	@Override
	public Model getById(Long id) {
		return getDao().getById(id);
	}

	@Override
	public List<Model> getAll() {
		return getDao().getAll();
	}
}
