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
<title>新增管理员</title>
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
                           <span>系统管理</span><span>></span>
                           <span>管理员管理</span><span>></span>
                           <span>添加管理员</span>
                         </div>
                        <div class="well brown">
                         <form action="admin_exAdd.do"  method="post">
                            <div class="form_list"><label class="lable_title">账号名称</label><input class="form_input" name="name" type="text"/></div>
                             <div class="form_list"><label class="lable_title">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                             <input class="form_input" name="passWord" type="password"/></div>
                            <div class="form_list"><label class="lable_title">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="sex" value="1">&nbsp;&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="2">&nbsp;&nbsp;女</div>
                            <div class="form_list"><label class="lable_title">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
                            <input class="form_input" type="text" name="phone"/></div>
                            <div class="form_list"><input type="submit" class="submit" value="&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;"></div>
                         </form>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>