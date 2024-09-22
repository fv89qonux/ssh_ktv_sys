package com.ktv.dao.impl;

import org.springframework.stereotype.Repository;

import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.CommentDao;
import com.ktv.model.Comment;
import com.ktv.utils.Pager;
@Repository
@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDaoImpl<Comment>  implements CommentDao {

	@Override
	public Pager<Comment> findPager(Comment comment) {
//		if(comment.getUid() !=null && !"".equals(order.getUid() )){
//	    	   String hql = "from Order where Uid like :Uid and isDelete=0 order by id desc";
//	    	   Map<String,Object> alias = new HashMap<String,Object>();
//	   		   alias.put("Uid", "%" +order.getUid()+ "%" );
//	   		  return findByAlias(hql, alias);
//	       }else{
	    	   String hql = "from Comment where 1=1 and isDelete=0 order by id desc ";
				return findByAlias(hql, null);
//	       }
	}

}
