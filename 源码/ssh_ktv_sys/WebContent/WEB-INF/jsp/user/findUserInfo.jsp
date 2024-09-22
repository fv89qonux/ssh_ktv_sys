<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>KTV</title>
<link href="${ctx}/resource/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resource/css/index.css" rel="stylesheet" type="text/css"/>
 <link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet"/>
 <style type="text/css">
  .well {
    position: relative;
    min-height: 20px;
    padding: 0px;
    margin-bottom: 20px;
    -webkit-border-radius: 0;
    -moz-border-radius: 0;
    border-radius: 0;
}
.form_list {
    width: 100%;
    vertical-align: middle;
    font-size: 12px;
    height: 50px;
    line-height: 30px;
}
.lable_title {
    float: left;
    line-height: 30px;
    vertical-align: middle;
    font-size: 12px;
}
label {
    margin-bottom: 4px;
    display: inline-block;
}
    </style>
</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="./网上商城/index.htm">
				<img src="${ctx}/resource/image/r___________renleipic_01/60.jpg"  style="width: 189px; height: 50px;"alt="KTV"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
<%-- 	<img src="${ctx}/resource/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/> --%>
</div>	
</div>
	
	<%@ include file="/common/menu.jsp" %>

</div>	

<div class="container index">
                       <div class="well brown">
                         <form action="user_exUpdate.do"  method="post">
                              <div class="form_list"><label class="lable_title">登录账号</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="form_input" name="loginName" type="text" value="${user.loginName}" readonly="readonly"/></div>
                            <div class="form_list"><label class="lable_title">用户姓名</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="form_input" name="userName" type="text" value="${user.userName}"/></div>
                                <input type="hidden" name="id"  value="${user.id}"/>
                             <div class="form_list"><label class="lable_title">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>&nbsp;&nbsp;&nbsp;&nbsp;
                             <input class="form_input" name="passWord" type="password" value="${user.userName}"/></div>
                            <div class="form_list"><label class="lable_title">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  <input type="radio" name="sex" value="1" <c:if test="${user.sex == 1 }"> checked="checked" </c:if> >&nbsp;&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 <input type="radio" name="sex"  value="2"<c:if test="${user.sex == 2 }"> checked="checked"   </c:if>>&nbsp;&nbsp;女</div>
                            <div class="form_list"><label class="lable_title">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="form_input" type="text" name="phone" value="${user.phone}"/></div>
                            <div class="form_list"><label class="lable_title">联系地址</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="form_input" type="text" name="address" value="${user.address}"/></div>
                            <div class="form_list"><input type="submit" class="submit" value="&nbsp;&nbsp;修&nbsp;&nbsp;改&nbsp;&nbsp;" style="margin-left: 120px"></div>
                         </form>   
                        </div>
</div>
<div class="container footer">
<!-- 	<div class="span24"> -->
<!-- 		<div class="footerAd"> -->
<%-- 					<img src="${ctx}/resource/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"> --%>
<!-- </div>	</div> -->
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