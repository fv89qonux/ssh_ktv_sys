<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/resource/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${ctx}/resource/css/stylesheet.css" rel="stylesheet">
    <link href="icon/font-awesome.css" rel="stylesheet">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.html">
    <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.html">
    <style type="text/css">
    .input{ width:40px;
	text-align:center;}
	.daohanglink{
		height:40px; line-height:40px; vertical-align:middle; width:100%;
		background-color:rgb(248,248,248);
		margin-bottom:15px;
		}
	.daohanglink span{
		margin-left:5px;}
	.daohang{
	float: left;
	height: 15px;
	width: 5px;
	border-left-width: 5px;
	border-left-style: solid;
	border-left-color: #036;
	margin-top:12px;
	margin-left:15px;
		}
    </style>
<script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
<script src="js/jquery-1.10.2.js"></script>
    <script src="${ctx}/resource/js/jquery-ui-1.10.3.js"></script>
    <script src="${ctx}/resource/js/bootstrap.js"></script>
    <script src="${ctx}/resource/js/flatpoint_core.js"></script>
    <script src="${ctx}/resource/js/datatables.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
 <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                      <form  action="user_user.do" method="post">  
                         <div  class="daohanglink"style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                           <span>系统管理</span><span>></span>
                           <span>用户管理</span>
                           <span style="margin-left: 80px"> 用户名：</span>
					    <input type="text" name="loginName" id="loginName"  value="${user.loginName}">&nbsp;&nbsp;  
					    <button type="submit" class="label label-warning" style="margin-left: 50px">查询</button>
					      <a href="${ctx}/user_add.do" class="label label-warning" style="float:right; margin:8px;">添加</a> 
                         </div>
                         </form>
                        <div class="well brown">
                            <div class="well-content" style="border:0px;">
                                <table class="table table-striped table-bordered table-hover datatable">
                                    <thead>
                                        <tr>
                                            <th width="15%">序号</th>
                                            <th width="15%">登录账号</th>
                                            <th width="15%">用户姓名</th>
                                            <th width="10%">性別</th>
                                            <th width="15%">手机号</th>
                                            <th width="10%">联系地址</th>
                                            <th width="10%">状态</th>
                                            <th width="15%">管理操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach items="${pagers.datas}" var="user" varStatus="l">
                                        <tr>
                                            <td align="center">${l.index+1}</td>
                                            <td>${user.loginName}</td>
                                            <td>${user.userName}</td>
                                            <td>
                                             <c:if test="${user.sex == 1 }">
								                                               男
								               </c:if>
								               <c:if test="${user.sex == 2 }">
								                                               女
								               </c:if>
                                            </td>
                                            <td>${user.phone}</td>
                                            <td>${user.address}</td>
                                            <td>
                                             <c:if test="${user.isDelete == 0 }">
								                                                 未刪除
								               </c:if>
								               <c:if test="${user.isDelete == 1 }">
								                                             刪除
								               </c:if>
                                             </td>
                                            <td>
                                            <a class="btn" href="${ctx}/user_update.do?id=${user.id}" title="修改"><i class="icon-inbox"></i></a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn"  href="${ctx}/user_delete.do?id=${user.id}" title="删除" onclick= "if(confirm( '是否删除！ ')==false)return   false; "><i class="icon-trash"></i></a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                
                                 <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/user_user.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
			<pg:param name="userName" value="${user.loginName}"/>
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>