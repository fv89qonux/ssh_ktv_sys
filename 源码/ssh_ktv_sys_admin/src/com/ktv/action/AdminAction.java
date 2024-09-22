package com.ktv.action;


import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Admin;
import com.ktv.service.AdminService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

   private Admin admin;
   

@Override
   public Admin getModel() {
       if(admin==null) admin = new Admin();
     return admin;
   }
    @Autowired
   private AdminService adminService;
    
    /**
     * 登陆以后进入首页
     * @return
     */
    public String index(){
        Admin ad =  adminService.login(admin);
        if(ad == null){
            return "login";
        }
        HttpSession session =   ServletActionContext.getRequest().getSession();
        session.setAttribute("userName1", ad.getAdminName());
        session.setAttribute("userId", ad.getId());
        return "index";
    }
    
	     /**
		 * 列表
		 */
		public String admin(){
		Pager<Admin> pagers = adminService.findPager(admin);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("admin", admin);
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
			adminService.save(admin);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			Admin ad = adminService.getById(admin.getId());
			ActionContext.getContext().put("admin", ad);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			adminService.update(admin);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Admin c = adminService.getById(admin.getId());
			c.setIsDelete(1);
			adminService.update(c);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
	
	
	
	
}
