package com.blog.model;

import java.util.Date;
import java.util.Set;

/**
 * Article model 发表的文章
 * 
 * @since 2016年1月29日 16:33:39
 * @author sylar
 *
 */
public class Article {

	private Long id;

	private String title;

	private String content;

	private Date postTime;

	private Set<Reply> replies;

	private User author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", content=" + content + ", postTime=" + postTime + ", replies=" + replies + ", author=" + author + "]";
	}

}
