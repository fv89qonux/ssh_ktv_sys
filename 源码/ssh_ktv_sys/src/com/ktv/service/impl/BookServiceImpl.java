package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.BookDao;
import com.ktv.model.Book;
import com.ktv.service.BookService;
import com.ktv.utils.Pager;


@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {
    
     @Autowired
	 private BookDao bookcDao;

	@Override
	public Pager<Book> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return bookcDao.findByUserId(userId);
	}



     
}