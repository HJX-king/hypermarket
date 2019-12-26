<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分类管理页</title>
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
<a href="/hypermarket/goods/toMainPage">返回主页</a>
<br>
<a onclick="editShow()" href="javascript:void(0)">添加分类</a>

<div>
<form action="/hypermarket/goods/toTypesPage">
	<input name="type_name" value="${bean.type_name }" > <input type="submit">
</form>

</div>
<div style="text-align: center;" id="list">
	<table align="center" border="1">
		<tr>
			<td>分类名称</td>
			<td>分类描述</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach var="item" items="${typeList }">
			<tr>
				<td>${item.type_name }</td>
				<td>${item.content }</td>
				<td>${item.real_name }</td>
				<td>
					<a href="javascript:void(0)" onclick="editShow(${item.id})">修改</a>
					<a href="/hypermarket/goods/deleteType?id=${item.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		${paging }
	</div>
</div>

<div id="content" style="display: none">
	分类名称 : <input id="type_name"> 					<br>
	分类描述: <textarea rows="" cols="" id="type_content">			
		</textarea>						<br>
	<button onclick="submit()">提交</button><button onclick="cancel()">取消</button>
</div>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

	function submit(){
		var type_name = $("#type_name").val();
		var type_content = $("#type_content").val();
		
		$.ajax({
			url:"/hypermarket/goods/updateType",
			type:"post",
			data:{"id":typeId,"type_name":type_name,"content":type_content},
			dataType:"json",
			success:function(data){
				if(data.code==1){
					location.reload();
				}else if(data.code==3){
					location.href="/hypermarket/user/toLogin";
				}else{
					alert(data.message)
				}
			}
		})
	}
	
	//当要修改某条记录是,当前变量用来记住这条记录的id的值
	var typeId ;
	function editShow(id){
		$("#list").slideUp(500);
		$("#content").slideDown(500);
		
		
		//将输入框中的值先清除掉
		$("#type_name").val("");
		$("#type_content").val("");
		typeId = 0;
		if(id!=undefined){
			typeId = id;
			//根据分类的id获取数据
			$.ajax({
				url:"/hypermarket/goods/getTypeById",
				type:"post",
				data:{"id":id},
				dataType:"json",
				success:function(data){
					if(data.erron=="erron"){
						location.href="/hypermarket/user/toLogin";
						return;
					}else{
					$("#type_name").val(data.type_name);
					$("#type_content").val(data.content); 
						
					}
				}
			})
		}
	}
	
	function cancel(){
		$("#content").slideUp(500);
		$("#list").slideDown(500);
	}
</script>
</html>