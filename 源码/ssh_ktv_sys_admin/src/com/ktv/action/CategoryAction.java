package com.ktv.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Category;
import com.ktv.model.CategorySec;
import com.ktv.service.CategorySecService;
import com.ktv.service.CategoryService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport implements ModelDriven<Category>{

   private Category category;
   

@Override
   public Category getModel() {
       if(category==null) category = new Category();
     return category;
   }
    @Autowired
   private CategoryService categoryService;
    
    @Autowired
   private CategorySecService categorySecService;
	     /**
		 * 列表
		 */
		public String category(){
		Pager<Category> pagers = categoryService.findPager(category);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("category", category);
		return SUCCESS;
		}
		
		
		/**
		 * 跳转到添加页面
		 * @return
		 */
		public String add(){
			return SUCCESS;
		}
		
		/**
		 * 执行添加
		 * @return
		 */
		public String exAdd(){
			categoryService.save(category);
			ActionContext.getContext().put("url", "/category_category.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			Category c = categoryService.getById(category.getId());
			ActionContext.getContext().put("category", c);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			categoryService.update(category);
			ActionContext.getContext().put("url", "/category_category.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Category c = categoryService.getById(category.getId());
			Integer id=category.getId();
			 String hql="from CategorySec c where 1=1  and c.category.id = :id and  c.category.isDelete=0";
			 Map<String,Object> alias = new HashMap<String,Object>();
			 alias.put("id", id);
			 List<CategorySec> categorySecList=categorySecService.getByHQL(hql, alias);
			 for (CategorySec categorySec : categorySecList) {
				 //删除二级分类和一级关联的数据
				 categorySecService.delete(categorySec.getId());
			}
			 //删除一级分类
		 	c.setIsDelete(1);
			categoryService.update(c);
			ActionContext.getContext().put("url", "/category_category.do");
			return "redirect";
		}
	
	
	
	
}
