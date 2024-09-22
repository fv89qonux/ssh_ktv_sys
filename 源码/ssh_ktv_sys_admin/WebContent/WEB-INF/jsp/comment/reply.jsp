<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/resource/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${ctx}/resource/css/stylesheet.css" rel="stylesheet">
    <link href="${ctx}/resource/css/index.css" rel="stylesheet">
    <link href="icon/font-awesome.css" rel="stylesheet">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.html">
                    <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.html">
<script src="${ctx}/resource/js/jquery-1.10.2.js"></script>
<script src="${ctx}/resource/js/jquery-ui-1.10.3.js"></script>
<script src="${ctx}/resource/js/bootstrap.js"></script>
<script src="${ctx}/resource/js/flatpoint_core.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复评论</title>
</head>
<body>
 <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                         <div  class="daohanglink"style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                           <span>评价管理</span><span>></span>
                           <span>回复评价</span>
                         </div>
                        <div class="well brown">
                         <form action="comment_exUpdate.do"  method="post">
                            <div class="form_list"><label class="lable_title">商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;品</label>
                            <input class="form_input" name="user.userName" type="text" value="${comment.product.name}" readonly="readonly"/></div>
                            <input type="hidden" name="id"  value="${comment.id}"/>
                            <div class="form_list"><label class="lable_title">评价内容</label>
                            <input class="form_input" type="text" name="content" value="${comment.content}" readonly="readonly"/></div>
                            <div class="form_list"><label class="lable_title">评价时间</label>
                            <input class="form_input" name="createTime" type="text" readonly="readonly" value="<fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></div>
                             <div class="form_list"><label class="lable_title">用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户</label>
                             <input class="form_input" name="user.userName" type="text" value="${comment.user.userName}" readonly="readonly"/></div>
                           
                            <div class="form_list"><label class="lable_title">回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;复&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <textarea rows="3" cols="45" name="reply" id="reply">
                             ${comment.reply}
                             </textarea> 
                            </div>
                            
                            <div class="form_list"><input type="submit" class="submit" style="margin-top: 40px"value="&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;"></div>
                         </form>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>