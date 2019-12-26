<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<style type="text/css">
#incoImg {
	height: 100px;
	vertical-align: middle;
}
</style>
<body>
	<a href="/shopback/goods/toMainPage">返回主页</a>
	<br>
	<input type="hidden" value=${goods.id } id="id"> 商品名称:
	<input id="g_name" value="${goods.g_name }">
	<br> 商品类型:
	<select id="type_id">
		<c:forEach items="${types }" var="item">
			<!-- 在循环放置option的时候, 判断当前option的value中商品类型id和本次查询处的商品的类型id是否相同
								如果相同,说明当前商品就是这个类别的, 默认选中这个类别 -->
			<option value="${item.id}"
				<c:if test="${item.id==goods.type_id }">selected</c:if>>${item.type_name }</option>
		</c:forEach>
	</select>
	<br> 商品价格:
	<input type="number" id="price" value="${goods.price }">
	<br> 商品数量:
	<input type="number" id="num" value="${goods.num }">
	<br> 封面图:
	<img alt="封面图" src="${goods.inco }" onclick="openFile()" id="incoImg">
	<input type="file" id="f" style="display: none;"
		onchange="submitInco()">
	<input type="hidden" id="inco" value="${goods.inco }">
	<br> 商品描述:
	<div id="content">${goods.content }</div>
	<button onclick="submit()">提交</button>


</body>
<script type="text/javascript" src="/hypermarket/js/wangEditor.min.js"></script>
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	//上传封面图
	function openFile() {
		$("#f").click();
	}
	
	function submitInco(){
		var fd = new FormData();
		fd.append("file",$("#f")[0].files[0]);
		
		$.ajax({
			url:"http://localhost:8090/img/upload",
			type:"post",
			data:fd,
			contentType:false,
			processData:false,
			dataType:"json",
			success:function(data){
				$("#incoImg").attr("src",data.data[0])
				$("#inco").val(data.data[0]);
			}
		})
	}
	
	function submit(){
		var id = $("#id").val();
		var g_name = $("#g_name").val();
		var type_id = $("#type_id").val();
		var price = $("#price").val();
		var num = $("#num").val();
		var inco = $("#inco").val();
		var content = editor.txt.html();
		
		$.ajax({
			url:"/hypermarket/goods/updateGoods",
			type:"post",
			data:{"id":id,"g_name":g_name,"type_id":type_id,"price":price,"num":num,"inco":inco,"content":content},
			dataType:"json",
			success:function(data){
				if(data.code==3){
					location.href="/hypermarket/pages/login.jsp";
				}else if(data.code==1){
					location.href="/hypermarket/goods/toGoodsPage";
				}else{
					alert(data.message);
				}
				
			}
		})
	}
	var editor;
	$(function(){
		var E = window.wangEditor; //获取富文本操作项
		editor = new E('#content'); //制定设置的div
		editor.customConfig.uploadImgServer = 'http://localhost:8090/img/upload';  //指定本地文件的上传服务器地址
		editor.create();
		
		/* var content = "${goods.content}"; //在js代码中使用el表达式
		editor.txt.html(content); */
	})
</script>
</html>