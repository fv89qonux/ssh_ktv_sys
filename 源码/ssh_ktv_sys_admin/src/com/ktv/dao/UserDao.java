package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.User;
import com.ktv.utils.Pager;


public interface UserDao extends BaseDao<User>{

	Pager<User> findPager(User user);



}
