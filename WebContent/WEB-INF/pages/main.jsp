<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<style type="text/css">
	a img{
		height: 30px;
		width:30px;
		border-radius:15px;
	    vertical-align: middle;
	}

</style>
</head>
<body>

<div style="text-align: right;height: 40px;line-height: 40px">
	<c:if test="${login==null}">
		<a href="/hypermarket/user/toLogin">登录</a>	&nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${login!=null}">
		${login.real_name }	&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/hypermarket/user/logOut">退出</a>
	</c:if>
</div>

<div>
	<a href="/hypermarket/goods/toTypesPage">商品分类管理</a>
	<a href="/hypermarket/goods/toGoodsPage">商品管理</a>
</div>
</body>
</html>