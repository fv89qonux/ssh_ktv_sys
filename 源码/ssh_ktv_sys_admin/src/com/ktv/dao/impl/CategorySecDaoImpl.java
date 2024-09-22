package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.CategorySecDao;
import com.ktv.model.CategorySec;
import com.ktv.utils.Pager;



@Repository("categorySecDao")
@SuppressWarnings("unchecked")
public class CategorySecDaoImpl extends BaseDaoImpl<CategorySec> implements CategorySecDao{

	@Override
	public Pager<CategorySec> findPager(CategorySec categorySec) {
		if(categorySec.getScname() !=null && !"".equals(categorySec.getScname())){
	    	   String hql = "from CategorySec where scname like :scname and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("scname", "%" +categorySec.getScname()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from CategorySec where 1=1 and isDelete=0 order by id desc";
				return findByAlias(hql, null);
	       }
	}




}
