package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.UserDao;
import com.ktv.model.User;
import com.ktv.service.UserService;
import com.ktv.utils.Pager;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    
     @Autowired
	 private UserDao userDao;

	@Override
	public Pager<User> findPager(User user) {
		// TODO Auto-generated method stub
		return userDao.findPager(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

     
}