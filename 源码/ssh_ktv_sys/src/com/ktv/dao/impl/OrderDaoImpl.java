package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.OrderDao;
import com.ktv.model.Order;
import com.ktv.utils.Pager;

@Repository("orderDao")
@SuppressWarnings("unchecked")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

	@Override
	public Pager<Order> findByUserId(Integer userId) {
		String hql = "from Order o  where o.user.id = :userId and o.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		   alias.put("userId", userId );
		return findByAlias(hql, alias);
	}




}
