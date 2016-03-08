package com.blog.dao;

import java.util.List;

import com.blog.base.BaseDao;
import com.blog.model.Article;
import com.blog.model.Reply;

/**
 * ArticleDao
 * @since 2016年2月1日 16:42:32
 * @author sylar
 *
 */
public interface ArticleMapper extends BaseDao<Article> {

	/**
	 * 取出文章的所有回复
	 * @param articleId
	 * @return
	 */
	List<Reply> getReplies(Long articleId);
}
