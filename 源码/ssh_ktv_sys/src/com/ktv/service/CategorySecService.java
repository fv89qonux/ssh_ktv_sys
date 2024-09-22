package com.ktv.service;

import com.ktv.model.CategorySec;
import com.ktv.utils.Pager;

public interface CategorySecService  extends BaseService<CategorySec>{

	Pager<CategorySec> findPager(CategorySec categorySec);



}
