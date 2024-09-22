package com.ktv.service;

import com.ktv.model.Admin;
import com.ktv.utils.Pager;

public interface AdminService  extends BaseService<Admin>{

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param admin
     * @return
     */
    Admin login(Admin admin);

	Pager<Admin> findPager(Admin admin);

//
//	void updateInfo(Admin admin);
//
//	void deleteInfo(int id);
//
//	Pager<Admin> findPager(Admin admin);

}
