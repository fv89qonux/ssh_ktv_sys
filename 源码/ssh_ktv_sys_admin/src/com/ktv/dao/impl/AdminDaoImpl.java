package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.AdminDao;
import com.ktv.model.Admin;
import com.ktv.utils.Pager;



@Repository("adminDao")
@SuppressWarnings("unchecked")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{


	public Admin login(Admin admin) {
		String hql = "from Admin bean where bean.adminName =:adminName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("adminName", admin.getAdminName());
		q.setParameter("passWord", admin.getPassWord());
		return (Admin)q.uniqueResult();
	}
//======================================================================================================
//	public Pager<Admin> list() {
//		String hql = "from admin where type = 2 ";
//		return findByAlias(hql, null);
//	}
//	public Pager<Admin> listBy(String name) {
//		String hql = "from admin  where  type = 2 and realName = :name ";
//		Map<String,Object> alias = new HashMap<String,Object>();
//		alias.put("name", name);
//		return findByAlias(hql, alias);
//	}
	//================================================================================
/*	private int id;
	private String name;
	private String passWord;
	private String realName;//真实名
	private int type;//管理员类型 1 是超级管理员 2 是普通管理员也就是班主任
	private int isDelete;//1是 2否
	private ClassRoom classRoom;*/
//	@Override
//	public Pager<Admin> findPager(Admin admin) {
//		 if(admin.getRealName() !=null && !"".equals(admin.getRealName() )){
//	    	   String hql = "from admin where isDelete = 2 and realName = :realName and type = 2";
//	    	   Map<String,Object> alias = new HashMap<String,Object>();
//	   		   alias.put("realName", admin.getRealName() );
//	   		  return findByAlias(hql, alias);
//	       }else{
//	    	   String hql = "from admin where isDelete = 2  and type = 2";
//				return findByAlias(hql, null);
//	       }
//	}

//	@Override
//	public Pager<Admin> listBy(String adminName) {
//		String hql = "from admin  where  adminName = :adminName ";
//		Map<String,Object> alias = new HashMap<String,Object>();
//		alias.put("adminName", adminName);
//		return findByAlias(hql, alias);
//	}
//
//	@Override
//	public Pager<Admin> list() {
//		String hql = "from Admin where 1=1 ";
//		return findByAlias(hql, null);
//	}

	@Override
	public Pager<Admin> findPager(Admin admin) {
		if(admin.getAdminName() !=null && !"".equals(admin.getAdminName() )){
	    	   String hql = "from Admin where adminName like :adminName and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("adminName", "%" +admin.getAdminName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Admin where 1=1 and isDelete=0 order by id desc";
				return findByAlias(hql, null);
	       }
	}

}
