<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理页</title>
</head>
<style type="text/css">
	a img{
		height: 30px;
		width:30px;
		border-radius:15px;
	    vertical-align: middle;
	}

</style>
<body>
<a href="/hypermarket/goods/toMainPage">返回主页</a><br>
<div style="text-align:center;">
	<form action="/hypermarket/goods/toGoodsPage">
		<input name="g_name" value="${goods.g_name }"><input type="submit">	
		<c:forEach items="${typeList }" var="item">
			<!-- 这句话是什么意思?  -->
			<input type="checkbox" value="${item.id }"
			 
			<c:forEach var="type_id" items="${goods.typeIds}">
				<c:if test="${item.id==type_id}">checked="checked"</c:if>
			</c:forEach>
			name="typeIds"> ${item.type_name }
		</c:forEach>
	</form>
</div>
<a href="/hypermarket/goods/toAddGoodsPage">添加商品</a>
<div style="text-align: center;" id="list">
	<table align="center" border="1">
	<tr>
		<td>商品名称</td>
		<td>商品类别</td>
		<td>添加人</td>
		<td>商品价格</td>
		<td>商品数量</td>
		<td>商品状态</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var ="item">
	<tr>
		<td>${item.g_name }</td>
		<td>${item.type_name }</td>
		<td>${item.real_name }</td>
		<td>${item.price }</td>
		<td>${item.num }</td>
		<td>
			<c:if test="${item.status==0 }">下架</c:if>
			<c:if test="${item.status==1 }">上架</c:if> &nbsp;&nbsp;
			
			<c:if test="${item.status==0 }">
				<a href="/hypermarket/goods/updateGoodsStatus?status=1&id=${item.id }">上架</a>
			</c:if>
			<c:if test="${item.status==1 }">
				<a href="/hypermarket/goods/updateGoodsStatus?status=0&id=${item.id }">下架</a>
			</c:if>
		</td>
		<td>
			<a href="/hypermarket/goods/toAddGoodsPage?id=${item.id}" >修改</a>
			<a href="/hypermarket/goods/deleteGoods?id=${item.id}">删除</a>
		</td>
	</tr>
	
	</c:forEach>
	</table>
	</div>
	<div>
	${paging }
	</div>
</body>
</html>