package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.CategorySec;
import com.ktv.utils.Pager;


public interface CategorySecDao extends BaseDao<CategorySec>{

	Pager<CategorySec> findPager(CategorySec categorySec);




}
