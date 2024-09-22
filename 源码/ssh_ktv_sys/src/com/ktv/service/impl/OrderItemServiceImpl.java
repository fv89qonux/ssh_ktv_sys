package com.ktv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.OrderItemDao;
import com.ktv.model.OrderItem;
import com.ktv.service.OrderItemService;
import com.ktv.utils.Pager;


@Service("orderItemService")
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {
    
     @Autowired
	 private OrderItemDao orderItem;

	@Override
	public Pager<OrderItem> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderItem.findByUserId(userId);
	}


     
}