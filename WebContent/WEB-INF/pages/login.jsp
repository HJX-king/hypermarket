<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页</title>
</head>
<body>
	<div>
		<div id="mesg"></div>
		用户名:<input id="userName" >						<br>
		密码: <input id="password" type="password">		<br>
		<button onclick="login()">登录</button>
	</div>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	


	function login(){
		var userName = $("#userName").val();
		if(userName==undefined||userName.trim()==""){
			$("#mesg").text("对不起,用户名不能为空");
			return;
		}
		
		var password = $("#password").val();
		if(password==undefined||password.trim()==""){
			$("#mesg").text("对不起,密码不能为空");
			return;
		}

		$.ajax({
			url:"/hypermarket/user/login",
			type:"post",
			data:{"userName":userName,"password":password},
			dataType:"json",
			success:function(data){
				if(data.code==-1){
					$("#mesg").text(data.message);
				}else{
					location.href="/hypermarket/goods/toMainPage"
				}
			}
		})
	}

</script>
</html>