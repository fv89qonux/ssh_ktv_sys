package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Product;
import com.ktv.utils.Pager;


public interface ProductDao extends BaseDao<Product>{

	Pager<Product> findPager(Product product);




}
