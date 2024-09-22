package com.ktv.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.dto.Cart;
import com.ktv.dto.CartItem;
import com.ktv.model.Order;
import com.ktv.model.OrderItem;
import com.ktv.model.User;
import com.ktv.service.OrderItemService;
import com.ktv.service.OrderService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	// 模型驱动使用的对象
	private Order order = new Order();

	public Order getModel() {
		return order;
	}


	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;


	// 生成订单的执行的方法:
	public String saveOrder() {
		// 调用Service完成数据库插入的操作:
		// Order order = new Order();
		// 设置订单的总金额:订单的总金额应该是购物车中总金额:
		// 购物车在session中,从session总获得购物车信息.
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("亲!您还没有购物!");
			return "msg";
		}
		 Calendar calendar = Calendar.getInstance();
		 //订单号
        order.setUid("1000000"+calendar.getTime().getTime());
		order.setTotal(cart.getTotal());
		// 设置订单的状态
		order.setStatus(0); // 0:未付款.
		// 设置订单时间
		order.setOrderTime(new Date());
		// 设置订单关联的客户:
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if (existUser == null) {
			this.addActionMessage("亲!您还没有登录!");
			return "msg";
		}
		order.setUser(existUser);
		
		orderService.save(order);
		List<OrderItem> orderItemList=new ArrayList<>();
		// 设置订单项集合:
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的.
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			orderItemService.save(orderItem);
//			order.getOrderItems().add(orderItem);
			orderItemList.add(orderItem);
		}
		
		// 清空购物车:
		cart.clearCart();

		// 页面需要回显订单信息:
		// 使用模型驱动了 所有可以不使用值栈保存了
		// ActionContext.getContext().getValueStack().set("order", order);
		ActionContext.getContext().put("order", order);
		ActionContext.getContext().put("orderItemList", orderItemList);
		return "saveOrder";
	}

	
    	// 点击付款生成订单的执行的方法:
		public String saveOrder1() {
		    Order o =orderService.getById(order.getId());
			ActionContext.getContext().put("order", o);
			String hql = "from OrderItem oi  where oi.order.id = :id and oi.order.isDelete=0";
				Map<String,Object> alias = new HashMap<String,Object>();
				 alias.put("id", order.getId());
	     	List<OrderItem> orderItemList=orderItemService.getByHQL(hql,alias);
			ActionContext.getContext().put("orderItemList", orderItemList);
			return "saveOrder";
		}
	
	
	// 查询我的订单:
	public String findByUserId() {
		// 获得用户的id.
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		// 获得用户的id
		Integer userId = existUser.getId();
		// 根据用户的id查询订单:
		Pager<Order> pagers = orderService.findByUserId(userId);
		Pager<OrderItem> orderItemList=orderItemService.findByUserId(userId);
		// 将PageBean数据带到页面上.
		//ActionContext.getContext().getValueStack().set("myOrder", myOrder);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("orderItemList", orderItemList);
		return "findByUid";
	}

	// 修改订单的状态:付款
	public String payOrder(){
		Order currOrder = orderService.getById(order.getId());
		currOrder.setStatus(1);
		orderService.update(currOrder);
		ActionContext.getContext().put("url", "/order_findByUserId.do");
		return "redirect";
	}
	
	// 根据订单id查询订单:
//	public String findByOid() {
//		order = orderService.getById(order.getId());
//		return "findByOid";
//	}

	
	// 修改订单的状态:确认收货
//	public String confirmStatus(){
//		Order currOrder = orderService.getById(order.getId());
//		currOrder.setStatus(3);
//		orderService.update(currOrder);
//		ActionContext.getContext().put("url", "/order_findByUserId.do");
//		return "redirect";
//	}
	
	// 修改订单的状态:取消订单
		public String cancelOrder(){
			Order currOrder = orderService.getById(order.getId());
			currOrder.setStatus(3);
			orderService.update(currOrder);
			ActionContext.getContext().put("url", "/order_findByUserId.do");
			return "redirect";
		}
}
