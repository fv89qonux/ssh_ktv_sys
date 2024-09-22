package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktv.dao.CategoryDao;
import com.ktv.model.Category;
import com.ktv.service.CategoryService;
import com.ktv.utils.Pager;


@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
    
     @Autowired
	 private CategoryDao categoryDao;

	@Override
	public Pager<Category> findPager(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.findPager(category);
	}


     
}