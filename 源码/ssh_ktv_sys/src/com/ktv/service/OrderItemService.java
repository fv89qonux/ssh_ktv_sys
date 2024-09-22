package com.ktv.service;

import java.util.List;

import com.ktv.model.OrderItem;
import com.ktv.utils.Pager;

public interface OrderItemService  extends BaseService<OrderItem>{

	Pager<OrderItem> findByUserId(Integer userId);




}
