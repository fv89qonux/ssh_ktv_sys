package com.ktv.dao;

import java.util.List;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.OrderItem;
import com.ktv.utils.Pager;


public interface OrderItemDao extends BaseDao<OrderItem>{

	Pager<OrderItem> findByUserId(Integer userId);



}
