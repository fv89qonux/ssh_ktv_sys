package com.ktv.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Category;
import com.ktv.model.CategorySec;
import com.ktv.model.Product;
import com.ktv.service.CategorySecService;
import com.ktv.service.CategoryService;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categorySecAction")
@Scope("prototype")
public class CategorySecAction extends ActionSupport implements ModelDriven<CategorySec>{

   private CategorySec categorySec;
   

@Override
   public CategorySec getModel() {
       if(categorySec==null) categorySec = new CategorySec();
     return categorySec;
   }
    @Autowired
   private CategorySecService categorySecService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
	     /**
		 * 列表
		 */
		public String categorySec(){
		Pager<CategorySec> pagers = categorySecService.findPager(categorySec);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("categorySec", categorySec);
		return SUCCESS;
		}
		
		
		/**
		 * 跳转到添加页面
		 * @return
		 */
		public String add(){
		   String hql="from Category where 1=1 and  isDelete=0";
		   List<Category> categoryList=categoryService.getByHQL(hql, null);
		   ActionContext.getContext().put("categoryList", categoryList);
			return SUCCESS;
		}
		
		/**
		 * 执行添加
		 * @return
		 */
		public String exAdd(){
			categorySecService.save(categorySec);
			ActionContext.getContext().put("url", "/categorySec_categorySec.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			CategorySec c = categorySecService.getById(categorySec.getId());
			ActionContext.getContext().put("categorySec", c);
		   String hql="from Category where 1=1 and  isDelete=0";
		   List<Category> categoryList=categoryService.getByHQL(hql, null);
		   ActionContext.getContext().put("categoryList", categoryList);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			categorySecService.update(categorySec);
			ActionContext.getContext().put("url", "/categorySec_categorySec.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			CategorySec c = categorySecService.getById(categorySec.getId());
			Integer id=categorySec.getId();
			 String hql="from Product p where 1=1  and p.categorySec.id = :id and  p.categorySec.isDelete=0";
			 Map<String,Object> alias = new HashMap<String,Object>();
			 alias.put("id", id);
			 List<Product> productList=productService.getByHQL(hql, alias);
			for (Product product : productList) {
				//删除商品和二级关联的数据
				productService.delete(product.getId());
			}
			//删除二级分类表
		 	c.setIsDelete(1);
			categorySecService.update(c);
			ActionContext.getContext().put("url", "/categorySec_categorySec.do");
			return "redirect";
		}
	
	
	
	
}
