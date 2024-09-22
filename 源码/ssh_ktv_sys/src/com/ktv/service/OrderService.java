package com.ktv.service;

import com.ktv.model.Order;
import com.ktv.utils.Pager;

public interface OrderService  extends BaseService<Order>{

	Pager<Order> findByUserId(Integer userId);



}
