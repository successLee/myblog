package com.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.base.BaseDao;
import com.blog.base.BaseServiceImpl;
import com.blog.dao.ArticleMapper;
import com.blog.model.Article;
import com.blog.service.ArticleService;

/**
 * ArticleService实现类
 * 
 * @since 2016年2月1日 18:49:37
 * @author sylar
 *
 */
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public BaseDao<Article> getDao() {
		return articleMapper;
	}

}
