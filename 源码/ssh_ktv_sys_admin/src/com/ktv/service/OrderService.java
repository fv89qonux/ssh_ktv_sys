package com.ktv.service;

import com.ktv.model.Comment;
import com.ktv.model.Order;
import com.ktv.utils.Pager;

public interface OrderService  extends BaseService<Order>{

	Pager<Order> findPager(Order order);



}
