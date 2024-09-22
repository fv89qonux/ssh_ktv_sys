package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.ktv.base.dao.impl.BaseDaoImpl;
import com.ktv.dao.ProductDao;
import com.ktv.model.Product;
import com.ktv.utils.Pager;



@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	@Override
	public Pager<Product> findPager(Product product) {
		if(product.getName() !=null && !"".equals(product.getName() )){
	    	   String hql = "from Product where name like :name and isDelete=0 order by id desc";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("name", "%" +product.getName()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Product where 1=1 and isDelete=0 order by id desc";
				return findByAlias(hql, null);
	       }
	}




}
