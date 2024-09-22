package com.ktv.dao;

import com.ktv.base.dao.BaseDao;
import com.ktv.model.Admin;
import com.ktv.utils.Pager;


public interface AdminDao extends BaseDao<Admin>{

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param ad
     * @return
     */
    Admin login(Admin ad);

//	Pager<Admin> listBy(String adminName);
//
//	Pager<Admin> list();

	Pager<Admin> findPager(Admin admin);


}
