package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.CommentDao;
import com.ktv.model.Comment;
import com.ktv.service.CommentService;
import com.ktv.utils.Pager;
@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{
	
	//============依赖注入start================
	@Autowired
	private CommentDao commentDao;//评论
  //===========依赖注入end==================

	@Override
	public Pager<Comment> findPager(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.findPager(comment);
	}

}
