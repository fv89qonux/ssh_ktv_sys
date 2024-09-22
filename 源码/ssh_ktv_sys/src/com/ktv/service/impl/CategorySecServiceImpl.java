package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.CategorySecDao;
import com.ktv.model.CategorySec;
import com.ktv.service.CategorySecService;
import com.ktv.utils.Pager;


@Service("categorySecService")
public class CategorySecServiceImpl extends BaseServiceImpl<CategorySec> implements CategorySecService {
    
     @Autowired
	 private CategorySecDao categorySecDao;

	@Override
	public Pager<CategorySec> findPager(CategorySec categorySec) {
		// TODO Auto-generated method stub
		return categorySecDao.findPager(categorySec);
	}


     
}