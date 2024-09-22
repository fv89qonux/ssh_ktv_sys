package com.ktv.service;

import com.ktv.model.Comment;
import com.ktv.utils.Pager;

public interface CommentService extends BaseService<Comment>{

	Pager<Comment> findPager(Comment comment);

}
