package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktv.dao.ProductDao;
import com.ktv.model.Product;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;


@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    
     @Autowired
	 private ProductDao productDao;

	@Override
	public Pager<Product> findPager(Product product) {
		// TODO Auto-generated method stub
		return productDao.findPager(product);
	}


     
}