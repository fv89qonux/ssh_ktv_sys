package com.ktv.dao.impl;

import java.util.HashMap;
import java.util.List;
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
	public Pager<Product> findPager(Integer categoryId) {
		if(categoryId!=null){
			if(categoryId !=null && !"".equals(categoryId )){
		    	   String hql = "from Product where category.id = :categoryId and isDelete=0 and category.id!=6 order by id desc";
		    	   Map<String,Object> alias = new HashMap<String,Object>();
		   		   alias.put("categoryId", categoryId);
		   		  return findByAlias(hql, alias);
		       }else{
		    	   String hql = "from Product where 1=1 and isDelete=0 and category.id!=6 order by id desc";
					return findByAlias(hql, null);
		       }
		}else{
			 String hql = "from Product where 1=1 and isDelete=0 and category.id!=6 order by id desc";
				return findByAlias(hql, null);
		}
		
	}

	@Override
	public Pager<Product> findByCid(Integer cid) {
		String hql = "from Product p  where p.categorySec.category.id = :cid  and p.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();					
		   alias.put("cid", cid );
		return findByAlias(hql, alias);
	}

	@Override
	public Pager<Product> findByCsid(Integer scid) {
		String hql = "from Product p  where p.categorySec.id = :scid and p.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		   alias.put("scid", scid );
		return findByAlias(hql, alias);
	}

	@Override
	public Pager<Product> findPager1(Product product) {
		if(product!=null){
			if(product.getName() !=null && !"".equals(product.getName() )){
		    	   String hql = "from Product where name like :name and isDelete=0 and category.id=6 order by id desc";
		    	   Map<String,Object> alias = new HashMap<String,Object>();
		   		   alias.put("name", "%" +product.getName()+ "%" );
		   		  return findByAlias(hql, alias);
		       }else{
		    	   String hql = "from Product where 1=1 and isDelete=0 and category.id=6 order by id desc";
					return findByAlias(hql, null);
		       }
		}else{
			 String hql = "from Product where 1=1 and isDelete=0 and category.id=6 order by id desc";
				return findByAlias(hql, null);
		}
	}

	@Override
	public List<Product> findInfo(Integer categoryId) {
		if(categoryId!=null){
			if(categoryId !=null && !"".equals(categoryId )){
		    	   String hql = "from Product where category.id = :categoryId and isDelete=0 and category.id=6 order by id desc";
		    	   Map<String,Object> alias = new HashMap<String,Object>();
		   		   alias.put("categoryId", categoryId);
		   		  return this.list(hql, null, alias);
		       }else{
		    	   String hql = "from Product where 1=1 and isDelete=0 and category.id=6 order by id desc";
					return this.list(hql, null, null);
		       }
		}else{
			 String hql = "from Product where 1=1 and isDelete=0 and category.id=6 order by id desc";
				return this.list(hql, null, null);
		}
	}

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
