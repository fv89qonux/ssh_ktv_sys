package com.ktv.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.User;
import com.ktv.service.UserService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

   private User user;
   

@Override
   public User getModel() {
       if(user==null) user = new User();
     return user;
   }
    @Autowired
   private UserService userService;
    
    
	     /**
		 * 列表
		 */
		public String user(){
		Pager<User> pagers = userService.findPager(user);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("user", user);
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
			userService.save(user);
			ActionContext.getContext().put("url", "/user_user.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			User u = userService.getById(user.getId());
			ActionContext.getContext().put("user", u);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			userService.update(user);
			ActionContext.getContext().put("url", "/user_user.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			User u = userService.getById(user.getId());
			u.setIsDelete(1);
			userService.update(u);
			ActionContext.getContext().put("url", "/user_user.do");
			return "redirect";
		}
	
	
	
	
}
