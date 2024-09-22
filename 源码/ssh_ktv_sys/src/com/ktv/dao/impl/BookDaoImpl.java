package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.BookDao;
import com.ktv.model.Book;
import com.ktv.utils.Pager;



@Repository("bookDao")
@SuppressWarnings("unchecked")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao{

	@Override
	public Pager<Book> findByUserId(Integer userId) {
		String hql = "from Book b  where b.user.id = :userId and b.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		   alias.put("userId", userId );
		return findByAlias(hql, alias);
	}





}
