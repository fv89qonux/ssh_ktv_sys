package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.CategoryDao;
import com.ktv.model.Category;
import com.ktv.utils.Pager;



@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	@Override
	public Pager<Category> findPager(Category category) {
		if(category.getCname() !=null && !"".equals(category.getCname())){
	    	   String hql = "from Category where cname like :cname and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("cname", "%" +category.getCname()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Category where 1=1 and isDelete=0 order by id desc";
				return findByAlias(hql, null);
	       }
	}

	@Override
	public Pager<Category> listAll() {
		 String hql = "from Category where 1=1 and isDelete=0 order by id desc";
		  return findByAlias(hql, null);
	}




}
