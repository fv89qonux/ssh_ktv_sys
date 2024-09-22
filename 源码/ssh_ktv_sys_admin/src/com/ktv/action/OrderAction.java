package com.ktv.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ktv.model.Order;
import com.ktv.model.OrderItem;
import com.ktv.service.OrderItemService;
import com.ktv.service.OrderService;
import com.ktv.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport implements ModelDriven<Order>{

   private Order order;
   

@Override
   public Order getModel() {
       if(order==null) order = new Order();
     return order;
   }
    @Autowired
   private OrderService orderService;
    
    @Autowired
    private OrderItemService orderItemService;
    
	     /**
		 * 列表
		 */
		public String order(){
		Pager<Order> pagers = orderService.findPager(order);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("order", order);
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
			orderService.save(order);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			Order o = orderService.getById(order.getId());
			ActionContext.getContext().put("order", o);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			orderService.update(order);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Order o = orderService.getById(order.getId());
			Integer id=order.getId();
			 String hql="from OrderItem o where 1=1  and o.order.id = :id and  o.order.isDelete=0";
			 Map<String,Object> alias = new HashMap<String,Object>();
			 alias.put("id", id);
			 List<OrderItem> orderItemList=orderItemService.getByHQL(hql, alias);
			 for (OrderItem orderItem : orderItemList) {
				//删除中间表
				 orderItemService.delete(orderItem.getId());
			}
			 //删除订单表
			o.setIsDelete(1);
			orderService.update(o);
			
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}
	
		/**
		 *  修改订单的状态:取消订单
		 * @return
		 */
		public String cancelOrder(){
			Order o = orderService.getById(order.getId());
			o.setStatus(3);
			orderService.update(o);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}

		/**
		 *  修改订单的状态:已经审核
		 * @return
		 */
		public String confirm(){
			Order o = orderService.getById(order.getId());
			o.setStatus(2);
			orderService.update(o);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}

		
	
}
