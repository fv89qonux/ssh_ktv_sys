package com.ktv.action;

import java.util.Calendar;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Book;
import com.ktv.model.Order;
import com.ktv.model.OrderItem;
import com.ktv.model.Product;
import com.ktv.model.User;
import com.ktv.service.BookService;
import com.ktv.service.ProductService;
import com.ktv.service.UserService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book> {

	private Book book;
	
	// 接收pid
    private Integer pid;


	@Override
	public Book getModel() {
		if (book == null)
			book = new Book();
		return book;
	}

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ProductService productService;


	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}



	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		// 根据pid进行查询商品:
		Product product = productService.getById(pid);
		if (existUser == null) {
			return "login";
		} else {
		   Calendar calendar = Calendar.getInstance();
			book.setUid("2000000"+calendar.getTime().getTime());
			book.setBookTime(new Date());
			book.setIsDelete(0);
			book.setProduct(product);
			book.setUser(existUser);
			bookService.save(book);
			ActionContext.getContext().put("url", "/login_index.do");
			return "redirect";
		}
	
	}
	// 查询我的订单:
		public String findByUserId() {
			// 获得用户的id.
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("user");
			// 获得用户的id
			Integer userId = existUser.getId();
			// 根据用户的id查询订单:
			Pager<Book> pagers = bookService.findByUserId(userId);
			// 将PageBean数据带到页面上.
			ActionContext.getContext().put("pagers", pagers);
			return "findByUserId";
		}

		
		
}
