package com.blog.model;

import java.util.Date;

/**
 * Reply model 文章回复
 * 
 * @since 2016年1月29日 16:36:17
 * @author sylar
 *
 */
public class Reply {

	private Long id;

	private User author;

	private Date replyTime;

	private Long articleId;

	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Reply [author=" + author + ", replyTime=" + replyTime + ", articleId=" + articleId + ", content=" + content + "]";
	}
}
