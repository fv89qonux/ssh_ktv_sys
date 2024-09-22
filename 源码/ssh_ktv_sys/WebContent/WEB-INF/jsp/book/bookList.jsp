<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>预定页面</title>
<link href="${ctx}/resource/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="./网上商城/index.htm"> 
					<img src="${ctx}/resource/image/r___________renleipic_01/60.jpg"  style="width: 189px; height: 50px;"alt="KTV"/></a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
<%-- 				<img src="${ctx}/resource/image/header.jpg" --%>
<!-- 					width="320" height="50" alt="正品保障" title="正品保障" /> -->
			</div>
		</div>

	 <%@ include file="/common/menu.jsp" %>

	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>

					<li class="current"></li>
					<li style="margin-left: 170px;color: red;font-size: 26px;">我的预定</li>
				</ul>
			</div>


			<table>
				<tbody>
						<tr>
							<th>预定编号</th>
							<th>预定包间名</th>
							<th>包间编号</th>
							<th>包间价格</th>
							<th>预定时间</th>
							<th>预定人</th>
						</tr>	
                            <c:forEach items="${pagers.datas}" var="book" varStatus="l">
							<tr>
								<td>${book.uid}</td>
								<td>${book.product.name}</td>
								<td>${book.product.id}</td>
							    <td>${book.product.price}</td>
								<td><fmt:formatDate value="${book.bookTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${book.user.userName}</td>
							</tr>
							</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="panel-foot text-center" style="margin: 0 auto; width: 350px" >
      <pg:pager  url="${ctx}/book_findByUserId.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			<pg:param name="name" value="${product.name}"/>
		<pg:last>  
			共${pagers.total}记录,共${pageNumber}页,  
		</pg:last>  
			当前第${curPage}页 
  
        <pg:first>  
    		<a href="${pageUrl}">首页</a>  
		</pg:first>  
		<pg:prev>  
    		<a href="${pageUrl}">上一页</a>  
		</pg:prev>  
      
       	<pg:pages>  
        	<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">[${pageNumber }]</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">${pageNumber}</a>  
            	</c:otherwise>  
        	</c:choose>  
    	</pg:pages>
             
        <pg:next>  
    		<a href="${pageUrl}">下一页</a>  
		</pg:next>  
		<pg:last>  
			<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">尾页</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">尾页</a>  
            	</c:otherwise>  
        	</c:choose> 
    		  
		</pg:last>
	</pg:pager>
    </div>
	
	<div class="container footer">
<!-- 		<div class="span24"> -->
<!-- 			<div class="footerAd"> -->
<%-- 				<img src="${ctx}/resource/image\r___________renleipic_01/footer.jpg" alt="我们的优势" --%>
<!-- 					title="我们的优势" height="52" width="950"> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="span24">
		<ul class="bottomNav">
					<li>
						<a>关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
		<div class="span24">
			<div class="copyright">Copyright © 2020-2020KTV </div>
		</div>
	</div>
</body>
</html>