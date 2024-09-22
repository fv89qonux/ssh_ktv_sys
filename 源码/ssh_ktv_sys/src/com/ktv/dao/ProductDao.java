package com.ktv.dao;

import java.util.List;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Product;
import com.ktv.utils.Pager;


public interface ProductDao extends BaseDao<Product>{

	Pager<Product> findPager(Integer categoryId);

	Pager<Product> findByCid(Integer cid);

	Pager<Product> findByCsid(Integer scid);

	Pager<Product> findPager1(Product product);

	List<Product> findInfo(Integer categoryId);

	Pager<Product> findPager(Product product);




}
