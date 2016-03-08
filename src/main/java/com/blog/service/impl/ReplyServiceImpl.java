package com.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.base.BaseDao;
import com.blog.base.BaseServiceImpl;
import com.blog.dao.ReplyMapper;
import com.blog.model.Reply;
import com.blog.service.ReplyService;

/**
 * ReplyService实现类
 * 
 * @author sylar
 *
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {

	@Resource
	private ReplyMapper replyMapper;
	
	@Override
	public BaseDao<Reply> getDao() {
		return replyMapper;
	}

}
