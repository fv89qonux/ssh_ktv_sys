package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.OrderDao;
import com.ktv.model.Order;
import com.ktv.service.OrderService;
import com.ktv.utils.Pager;


@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    
     @Autowired
	 private OrderDao orderDao;

	@Override
	public Pager<Order> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderDao.findByUserId(userId);
	}


     
}