<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglibs.jsp"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		<c:if test="${session.loginName==null }">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/login_login.do">用户登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ctx}/login_register.do">用户注册</a>|
			</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a target="_blank" href="../ssh_ktv_sys_admin">后台管理</a>|
			</li>
    </c:if>
           <c:if test="${session.loginName!=null }">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
                    ${session.loginName}
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/user_findUserInfo.do">个人信息</a>
			|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/book_findByUserId.do">我的预定</a>
			|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ctx}/order_findByUserId.do">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ctx}/login_tuichu.do">退出</a>
			</li>
   </c:if>
		
		</ul>
	</div>
	<div class="cart" style="margin-left: 198px;">
		<a href="${ctx}/cart_myCart.do">购物车</a>
	</div>
<!-- 	<div class="phone" style="margin-left: 180px; float:none;"> -->
<!-- 		客服热线: <strong>96008/53277764</strong> -->
<!-- 	</div> -->
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ctx}/login_index.do">首页</a> |</li>
		  <c:forEach items="${session.pager.datas}" var="category" varStatus="l">
		<%-- 	<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a> |</li> --%>
			<li><a style="margin: 0px 52px" href="${ctx}/product_findByCid.do?cid=${category.id}" />${category.cname}</a>|</li>
		  </c:forEach>

	</ul>
</div>