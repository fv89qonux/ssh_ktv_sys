package com.ktv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktv.dao.AdminDao;
import com.ktv.model.Admin;
import com.ktv.service.AdminService;
import com.ktv.utils.Pager;


@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    
     @Autowired
	 private AdminDao adminDao;

     
   	public Admin login(Admin admin) {
		 Admin ad = new Admin();
		 ad.setAdminName(admin.getAdminName());
		 ad.setPassWord(admin.getPassWord());
		return adminDao.login(ad);
	}
   	
   	
//	public Pager<Admin> list(Admin admin) {
//		if(admin.getAdminName()!=null && !"".equals(admin.getAdminName())){
//			return adminDao.listBy(admin.getAdminName());
//		}else{
//			return adminDao.list();
//		}
		 
//	}
//	public void updateInfo(Admin manage) {
//		manageDao.update(manage);
//	}
//	public void deleteInfo(int id) {
//		manageDao.delete(id);
//	}

//}


	@Override
	public Pager<Admin> findPager(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findPager(admin);
	}

}