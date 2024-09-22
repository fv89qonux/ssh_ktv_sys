package com.ktv.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Category;
import com.ktv.model.Product;
import com.ktv.model.User;
import com.ktv.service.CategoryService;
import com.ktv.service.ProductService;
import com.ktv.service.UserService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user;

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;


	
	// 注册
	public String register() {
		String hql = "from User bean where bean.loginName =:loginName and bean.isDelete=0";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("loginName", user.getLoginName());
		List<User> userList = userService.getByHQL(hql, alias);
		if (userList.size() == 0) {
			userService.save(user);
			return "login";
		} else {
			return "register";
		}
	}

	// 登录
	public String login() {
		User u = userService.login(user);
		if (u == null) {
			return "register";
		} else {
//			Pager<Category> pager = categoryService.listAll();
//			ActionContext.getContext().put("pager", pager);
//			Pager<Product> pagers = productService.findPager(product);
//			ActionContext.getContext().put("pagers", pagers);
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("loginName", u.getLoginName());
			session.setAttribute("userId", u.getId());
			session.setAttribute("user", u);
			ActionContext.getContext().put("url", "/login_index.do");
			return "redirect";
//			return "index";
		}

	}

	/**
	 * 查看个人信息
	 * 
	 * @return
	 */
	public String findUserInfo() {
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		ActionContext.getContext().put("user", existUser);
		return "findUserInfo";
	}

	/**
	 * 执行修改
	 * 
	 * @return
	 */
	public String exUpdate() {
		userService.update(user);
		Pager<Category> pager = categoryService.listAll();
		ActionContext.getContext().put("pager", pager);
		Pager<Product> pagers = productService.findPager(product);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext ac = ActionContext.getContext();
		Map session1 = ac.getSession();
		session1.remove("loginName");
		session1.remove("userId");
		session1.remove("user");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("loginName", user.getLoginName());
		session.setAttribute("userId", user.getId());
		session.setAttribute("user", user);
		return "index";
	}


}
