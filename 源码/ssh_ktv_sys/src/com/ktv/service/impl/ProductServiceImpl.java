package com.ktv.service.impl;

import java.util.List;

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
	public Pager<Product> findPager(Integer categoryId) {
		// TODO Auto-generated method stub
		return productDao.findPager(categoryId);
	}

	@Override
	public Pager<Product> findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return productDao.findByCid(cid);
	}

	@Override
	public Pager<Product> findByCsid(Integer scid) {
		// TODO Auto-generated method stub
		return productDao.findByCsid(scid);
	}

	@Override
	public Pager<Product> findPager1(Product product) {
		// TODO Auto-generated method stub
		return productDao.findPager1(product);
	}

	@Override
	public List<Product> findInfo(Integer categoryId) {
		// TODO Auto-generated method stub
		return productDao.findInfo(categoryId);
	}

	@Override
	public Pager<Product> findPager(Product product) {
		// TODO Auto-generated method stub
		return productDao.findPager(product);
	}


     
}