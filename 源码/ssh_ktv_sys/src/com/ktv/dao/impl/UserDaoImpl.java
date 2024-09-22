package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.UserDao;
import com.ktv.model.User;
import com.ktv.utils.Pager;



@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public Pager<User> findPager(User user) {
		if(user.getLoginName() !=null && !"".equals(user.getLoginName() )){
	    	   String hql = "from User where loginName like :loginName and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("loginName", "%" +user.getLoginName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from User where 1=1 and isDelete=0 order by id desc ";
				return findByAlias(hql, null);
	       }
	}

	@Override
	public User login(User user) {
		String hql = "from User bean where bean.loginName =:loginName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("loginName", user.getLoginName());
		q.setParameter("passWord", user.getPassWord());
		return (User)q.uniqueResult();
	}



}
