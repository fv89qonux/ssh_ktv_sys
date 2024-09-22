package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Order;
import com.ktv.utils.Pager;


public interface OrderDao extends BaseDao<Order>{

	Pager<Order> findByUserId(Integer userId);



}
