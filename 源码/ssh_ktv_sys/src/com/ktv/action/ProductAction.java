package com.ktv.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Category;
import com.ktv.model.CategorySec;
import com.ktv.model.Comment;
import com.ktv.model.Product;
import com.ktv.service.CategorySecService;
import com.ktv.service.CategoryService;
import com.ktv.service.CommentService;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	private Product product;

	private Integer cid;

	private Integer scid;
	
	private Integer flag;
	

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public Product getModel() {
		if (product == null)
			product = new Product();
		return product;
	}

	@Autowired
	private ProductService productService;

	@Autowired
	private CategorySecService categorySecService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	/**
	 * 列表
	 */
	public String product() {
		Pager<Category> pager = categoryService.listAll();
		ActionContext.getContext().put("pager", pager);
		Pager<Product> pagers = productService.findPager(product);
		ActionContext.getContext().put("pagers", pagers);
		return "index";
	}

	/**
	 * 根据商品的ID进行查询商品:执行方法
	 */
	public String findByPid() {
		String hql = "from Category where 1=1 and  isDelete=0 order by id desc";
		List<Category> categoryList = categoryService.getByHQL(hql, null);
		ActionContext.getContext().put("categoryList", categoryList);
		String hql2 = "from Comment  where product.id = :pId and isDelete=0 order by id desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		 alias.put("pId", product.getId());
	    List<Comment> commentList =commentService.getByHQL(hql2, alias);
		ActionContext.getContext().put("commentList", commentList);
		String hql1 = "from CategorySec where 1=1 and  isDelete=0 order by id desc";
		List<CategorySec> categorySecList = categorySecService.getByHQL(hql1,
				null);
		ActionContext.getContext().put("categorySecList", categorySecList);
		Product p =new Product();
		Product p1 = productService.getById(product.getId());
		CategorySec cs= categorySecService.getById(p1.getCategorySec().getId());
    	Category c = categoryService.getById(cs.getCategory().getId());
    	if(c.getId()==6){
	    		 p = productService.getById(product.getId());
	 		    ActionContext.getContext().put("product", p);
	 			HttpSession session = ServletActionContext.getRequest().getSession();
	 			session.setAttribute("categoryList", categoryList);
	 			session.setAttribute("categorySecList", categorySecList);
	 			return "findByPid1";
		}else{
			 p = productService.getById(product.getId());
			ActionContext.getContext().put("product", p);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("categorySecList", categorySecList);
			return "findByPid";
		}
	}

	/**
	 * 根据分类的id查询商品:
	 */
	public String findByCid() {
		Pager<Product> pagers = productService.findByCid(cid);// 根据一级分类查询商品,带分页查询
		ActionContext.getContext().put("pagers", pagers);
		String hql = "from Category where 1=1 and  isDelete=0 order by id desc";
		List<Category> categoryList = categoryService.getByHQL(hql, null); 
		ActionContext.getContext().put("categoryList", categoryList);
		String hql1 = "from CategorySec where 1=1 and  isDelete=0 order by id desc";
		List<CategorySec> categorySecList = categorySecService.getByHQL(hql1,
				null);
		ActionContext.getContext().put("categorySecList", categorySecList);
		Product p = productService.getById(product.getId());
		ActionContext.getContext().put("product", p);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("categorySecList", categorySecList);
		return "findByCid";
	}

	/**
	 * 根据二级分类id查询商品
	 */
	public String findByScid() {
		// 根据二级分类查询商品
		Pager<Product> pagers = productService.findByCsid(scid);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("scid", scid);
		return "findByCsid";
	}

}
