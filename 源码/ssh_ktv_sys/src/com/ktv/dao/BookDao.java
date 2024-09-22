package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Book;
import com.ktv.utils.Pager;


public interface BookDao extends BaseDao<Book>{

	Pager<Book> findByUserId(Integer userId);




}
