<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>KTV</title>
<link href="${ctx}/resource/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/css/product.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="${ctx}/resource/css/tips.css" type="text/css"/>
<script src="${ctx}/resource/js/jquery-1.8.3.js"></script>
<script>
	function book(){
		document.getElementById("cartForm").submit();
	}
	
	//弹出框
	var pId=null;
	function showDialog(id){
		pId=id;
		$('#tip_newComment').show();
	}
	//取消弹出框
	function cancel(){
		 var comment= $("#comment").val('');
		$('#tip_newComment').hide();
	}

	//提交评论
	function addComment(){
		var content = $("#content").val();
		$.ajax({
	         url: ctx+'/comment_exAdd.do',
			type: 'POST',
			dataType: 'json',
		    data: {content:content,ppId:pId},
			async: false,
			success : function(data) {
				if(data.result == 1){
					  alert("评论成功,谢谢下次光临");
					  cancel();
					 window.location.href='${ctx}/login_index.do';
					}else{
						 alert("评论失败,请先预定包间");
						 cancel();
						 window.location.href='${ctx}/login_index.do';
					}
			},
				error : function() {
					alert("error");
				}
		});
	}
</script>

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${ctx}/resource/image/r___________renleipic_01/60.jpg"  style="width: 189px; height: 50px;"alt="KTV"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
<%-- 					<img src="${ctx}/resource/image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320"> --%>
</div>	</div>
	
		<%@ include file="/common/menu.jsp" %>

</div><div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
			
			<c:forEach items="${categoryList}" var="cs1" >
						            <dl>
						                  <dt>
						                  <a href="${ctx}/product_findByCid.do?cid=${cs1.id}"/>${cs1.cname}</a> 
						                  </dt>
									      <dt>
											<c:forEach items="${categorySecList}" var="cs" >
										          <c:if test="${cs.category.id == cs1.id}">
										           <dd>
														<a href="${ctx}/product_findByScid.do?scid=${cs.id}"/>${cs.scname}</a> 
													</dd>
										          </c:if>
									         </c:forEach>
									     </dt>
						         </dl>
			</c:forEach>
	                    	
			</div>

		</div>
		
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${ctx}/${product.image}"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name">${product.name}</div>
			<div class="sn">
				<div>编号：${product.id}</div>
			</div>
			<div class="info">
				<dl>
					<dt>价格:</dt>
					<dd>
						<strong>￥：${product.price} 元</strong>
<!-- 						参 考 价： -->
<!-- 							<del>￥1000000元</del> -->
					</dd>
				</dl>
					<dl>
						<dt style="margin-bottom: 20px;">促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
			<form id="cartForm" action="${ctx}/book_exAdd.do" method="post" >
				<input type="hidden" name="pid" value="${product.id }"/>
				<div class="action">
<!-- 						<dl class="quantity"> -->
<!-- 							<dt>购买数量:</dt> -->
<!-- 							<dd> -->
<!-- 								<input id="count" name="count" value="1" maxlength="4" onpaste="return false;" type="text"/> -->
<!-- 							</dd> -->
<!-- 							<dd> -->
<!-- 								件 -->
<!-- 							</dd> -->
<!-- 						</dl> -->
						
					<div class="buy">
							<input id="addCart" class="addCart" value="预定包间" type="button" onclick="book()"/>
					</div>
				</div>
			</form>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						 <c:if test="${session.loginName!=null }">
						<li id="introductionTab" style="margin-left: 50px;">
						<button type="button" id="btnCar" onclick="javascript:showDialog('${product.id}');"><span style="font-size:18px;cursor:pointer;">点击评价</span></button> 
						</li>
						</c:if>
						
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>${product.remark}</strong>
					</div>
					<div>
						<img src="${ctx}/${product.image}">
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">用户评价</a>
						</li>
						
				</ul>
			</div>
				<div style="background-color: #dddddd;">
				    <c:forEach items="${commentList}" var="comment" varStatus="l">
                    <span class="dy-icon-angle-right"></span>内容：${comment.content}
			        <span style="float:right;"><fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
			        <br/>
			        <span class="dy-icon-angle-right"></span>评价人：${comment.user.loginName}
			         <br/>
			       <span class="dy-icon-angle-right"></span> 回复：<c:if test="${comment.reply==null}"><span style="color:red;">未回复 </span></c:if>
			        <c:if test="${comment.reply!=null}">${comment.reply} </c:if>
			        <span style="float:right;"><fmt:formatDate value="${comment.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
			        </c:forEach>
				</div>	
				
				
		</div>
	</div>
		<!-- 弹框-新增评论-->
	<div class="tip_fix" id="tip_newComment">
		<div class="tip_frame">
			<div class="btn btn_close"></div>
			<div class="tip_box">
				<div class="tip_title">新增评论</div>
				<div class="tip_cnt_row">
					<div class="tip_cnt_l">
						<span class="tip_item_title">评论内容:</span> 
						<textarea rows="3" cols="20"
							class="tip_input1" id="content" name="content" style="width: 658px;height: 130px;"></textarea>
					</div>
				</div>
				<div class="tip_cnt_btn">
					<div class="btn1 btn_yes"  onclick="addComment()">确定</div>
					<div class="btn1 btn_no"  onclick="cancel()">取消</div>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
<!-- 		<div class="footerAd"> -->
<%-- 					<img src="${ctx}/resource/image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"> --%>
<!-- </div> -->
</div>
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
		<div class="copyright">Copyright © 2020 KTV </div>
	</div>
</div>
</body>
</html>