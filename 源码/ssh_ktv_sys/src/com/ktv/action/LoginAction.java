package com.ktv.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ktv.model.Category;
import com.ktv.model.CategorySec;
import com.ktv.model.Product;
import com.ktv.service.CategoryService;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
	private Category category;
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	private Integer categoryId;
	
	private String name;
	
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//首页
	public String index() {
		Pager<Category> pager = categoryService.listAll();
		ActionContext.getContext().put("pager", pager);
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("pager", pager);
		List<Category> categoryList =new ArrayList<>();
//		if(categoryId!=null){
//			String hql = "from Category where 1=1 and  isDelete=0  and id = :categoryId order by id desc";
//			Map<String,Object> alias = new HashMap<String,Object>();
//			 alias.put("categoryId", categoryId);
//			 categoryList = categoryService.getByHQL(hql, alias);
//		}else{
			String hql = "from Category where 1=1 and  isDelete=0 order by id desc";
			categoryList = categoryService.getByHQL(hql, null);
//		}
		ActionContext.getContext().put("categoryList", categoryList);
		//普通商品
		Pager<Product> pagers = productService.findPager(categoryId);
		ActionContext.getContext().put("pagers", pagers);
		//ktv
		   List<Product> productList=new ArrayList<>();
	   List<Product> productList1=productService.findInfo(categoryId);
		   if(productList1.size()>0){
			   if (productList1.size()>=10) {
				   for(int i=0;i<10;i++){
						  productList.add(productList1.get(i));
					  }  
			}else{
				  for(int i=0;i<productList1.size();i++){
					  productList.add(productList1.get(i));
				  }  
			}
		   }
		ActionContext.getContext().put("productList", productList);
		ActionContext.getContext().put("categoryId", categoryId);
//	   ActionContext.getContext().put("categorySecList", categorySecList);
//		Pager<Product> pagers1 = productService.findPager1(product);
//		ActionContext.getContext().put("pagers1", pagers1);
		
		return "success";
	}
	//登陆页面
	public String login() {
		return "success";
	}
   //注册页面
	public String register() {
		return "success";
	}
	
	   //退出
		public String tuichu() {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("loginName");
			session.remove("userId");
			session.remove("user");
			return "login";
		}
}
