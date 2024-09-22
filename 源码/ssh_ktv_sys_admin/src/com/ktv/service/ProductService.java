package com.ktv.service;

import com.ktv.model.Product;
import com.ktv.utils.Pager;

public interface ProductService  extends BaseService<Product>{


	Pager<Product> findPager(Product product);



}
