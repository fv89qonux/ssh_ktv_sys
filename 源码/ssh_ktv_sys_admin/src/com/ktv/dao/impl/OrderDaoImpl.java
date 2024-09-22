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
	public Pager<Order> findPager(Order order) {
		if(order.getUid() !=null && !"".equals(order.getUid() )){
	    	   String hql = "from Order where Uid like :Uid and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("Uid", "%" +order.getUid()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Order where 1=1 and isDelete=0 order by id desc ";
				return findByAlias(hql, null);
	       }
	}




}
