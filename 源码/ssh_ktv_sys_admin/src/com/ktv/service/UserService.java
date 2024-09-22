package com.ktv.service;

import com.ktv.model.User;
import com.ktv.utils.Pager;

public interface UserService  extends BaseService<User>{

	Pager<User> findPager(User user);


}
