package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Category;
import com.ktv.utils.Pager;


public interface CategoryDao extends BaseDao<Category>{

	Pager<Category> findPager(Category category);

	Pager<Category> listAll();




}
