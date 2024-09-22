package com.ktv.action;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ktv.model.Admin;
import com.ktv.model.Comment;
import com.ktv.model.Order;
import com.ktv.service.CommentService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	//===========依赖注入end==================
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	private  int itemId;
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
	 * 列表
	 * @return
	 */
	public String comment(){
		Pager<Comment> pagers = commentService.findPager(comment);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("comment", comment);
		return SUCCESS;
		}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String reply(){
		Comment c = commentService.getById(comment.getId());
		ActionContext.getContext().put("comment", c);
		return SUCCESS;
	}
    
	/**
	 * 执行修改（回复）
	 * @return
	 */
	public String exUpdate(){
		Comment c = commentService.getById(comment.getId());
	     c.setReply(comment.getReply());
	     c.setReplyTime(new Date());
		commentService.update(c);
		ActionContext.getContext().put("url", "/comment_comment.do");
		return "redirect";
	}	
	
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Comment c = commentService.getById(comment.getId());
			c.setIsDelete(1);
			commentService.update(c);
			ActionContext.getContext().put("url", "/comment_comment.do");
			return "redirect";
		}
		
		
//		
//		/**
//		 * 新增评论
//		 * @throws IOException 
//		 */
//		public void exAdd() throws IOException{
//			 HttpServletResponse resp = ServletActionContext.getResponse();
//	         resp.setContentType("application/json;charset=UTF-8");
//	         PrintWriter out = null;
//	         JSONObject json  = new JSONObject();
//	         Order o=orderService.getById(orderId);
//	         Comment c=new Comment();
//	         c.setContent(comment.getContent());
//	         c.setCreateTime(new Date());
//	         c.setIsDelete(2);
//	         c.setProduct(product);
//	         c.setUser(o.getUser());
//	         commentService.save(c);
// 			 json.put("result", 1);//评论成功
//		    out = resp.getWriter();
//	        out.write(json.toString());
//		}
		
		
}
