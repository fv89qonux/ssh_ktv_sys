package com.ktv.service;

import com.ktv.model.Book;
import com.ktv.utils.Pager;

public interface BookService  extends BaseService<Book>{

	Pager<Book> findByUserId(Integer userId);




}
