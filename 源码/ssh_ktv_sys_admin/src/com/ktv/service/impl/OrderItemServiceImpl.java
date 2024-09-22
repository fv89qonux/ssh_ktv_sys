package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.OrderItemDao;
import com.ktv.model.OrderItem;
import com.ktv.service.OrderItemService;


@Service("orderItemService")
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {
    
     @Autowired
	 private OrderItemDao orderItemDao;



     
}