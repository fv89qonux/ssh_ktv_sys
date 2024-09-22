package com.ktv.dao.impl;
import org.springframework.stereotype.Repository;

import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.CommentDao;
import com.ktv.model.Comment;
@Repository
@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDaoImpl<Comment>  implements CommentDao {

}
