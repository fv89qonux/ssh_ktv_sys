package com.ktv.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ktv.model.Book;
import com.ktv.model.Comment;
import com.ktv.model.Order;
import com.ktv.model.OrderItem;
import com.ktv.model.Product;
import com.ktv.model.User;
import com.ktv.service.BookService;
import com.ktv.service.CommentService;
import com.ktv.service.ProductService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
/**
 * 评论
 * @author
 *
 */
@Controller("commentAction")
@Scope("prototype")
public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
    private Comment comment;
	@Override
	public Comment getModel() {
		if(comment==null) comment = new Comment();
		return comment;	
	}
	//============依赖注入start================
	@Autowired
	private CommentService commentService;//评论
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private  BookService  bookService;
	//===========依赖注入end==================
	
	private Integer ppId;
	//-------------------------华丽分割线---------------------------------------------
	
	
	//============自定义参数start=============
	private  int itemId;
	public Integer getPpId() {
		return ppId;
	}
	public void setPpId(Integer ppId) {
		this.ppId = ppId;
	}
	private int orderId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	//============自定义参数end=============
	
	//-------------------------华丽分割线---------------------------------------------

	//============文件上传start=============
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	//============文件上传end=============
	
	//-------------------------华丽分割线---------------------------------------------
	/**
	 * 新增评论
	 * @throws IOException 
	 */
	public void exAdd() throws IOException{
		 HttpServletResponse resp = ServletActionContext.getResponse();
         resp.setContentType("application/json;charset=UTF-8");
         PrintWriter out = null;
         JSONObject json  = new JSONObject();
     	// 获得用户的id.
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		// 获得用户的id
		Integer userId = existUser.getId();
		String hql = "from Book  where user.id = :userId and isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		 alias.put("userId", userId);
 	    List<Book> bookList=bookService.getByHQL(hql,alias);
 	    if(bookList.size()>0){
 	    	  Product product=productService.getById(ppId);
 	         Comment c=new Comment();
 	         c.setContent(comment.getContent());
 	         c.setCreateTime(new Date());
 	         c.setIsDelete(0);
 	         c.setProduct(product);
 	         c.setUser(existUser);
 	         commentService.save(c);
 			json.put("result", 1);//评论成功
 	    }else{
 			json.put("result", 2);//评论失败
 	    }
	    out = resp.getWriter();
        out.write(json.toString());
	}
		
		
}
