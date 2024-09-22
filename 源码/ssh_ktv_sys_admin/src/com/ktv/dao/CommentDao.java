package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Comment;
import com.ktv.utils.Pager;

public interface CommentDao extends BaseDao<Comment>{

	Pager<Comment> findPager(Comment comment);

}
