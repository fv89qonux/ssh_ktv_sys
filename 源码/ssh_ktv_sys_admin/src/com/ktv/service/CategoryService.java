package com.ktv.service;

import com.ktv.model.Category;
import com.ktv.utils.Pager;

public interface CategoryService  extends BaseService<Category>{

	Pager<Category> findPager(Category category);



}
