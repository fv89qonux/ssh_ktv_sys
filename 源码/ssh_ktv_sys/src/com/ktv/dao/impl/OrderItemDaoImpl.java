package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.OrderItemDao;
import com.ktv.model.OrderItem;
import com.ktv.utils.Pager;

@Repository("orderItemDao")
@SuppressWarnings("unchecked")
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{

	@Override
	public Pager<OrderItem> findByUserId(Integer userId) {
		String hql = "from OrderItem oi  where oi.order.user.id = :userId and oi.order.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		   alias.put("userId", userId );
		return findByAlias(hql, alias);
	}





}
