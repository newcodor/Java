<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submitUpdate").click(function(){
		
		var updateInfo='{"id":"'+$("#id").val()+'","name":"'+$("#name").val()+'","price":"'+$("#price").val()+'","name":"'+$("#name").val()+'","detail":"'+$("#detail").val()+'","pic":"'+$("#pic").val()+'"}';
		//alert(updateInfo);
	/* 	$.ajax({
			url : "${pageContext.request.contextPath}/json.action",
			data : updateInfo,
			contentType : "application/json;charset=UTF-8";
			type : "post",
			dataType : "json",
			success : function(data){
				alert(data.name+"修改成功!");
			}
			
		}); */
		$.ajax({
			url : "${pageContext.request.contextPath }/product/updateProduct.action",
			data : updateInfo,
			contentType : "application/json;charset=UTF-8",//发送数据的格式
			type : "post",
			dataType : "json",//回调
			success : function(data){
				alert(data.result);
			}
			
		});
		
		
	});
	
	
	
});
</script>
<body> 
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/product/updateProduct.action" method="post"  enctype="multipart/form-data"   >
		<input type="hidden" id="id" name="item.id" value="${item.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" id="name"  name="item.name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" id="price" name="item.price" value="${item.price }" /></td>
			</tr>
			
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" id="createtime"  name="item.createtime"
					value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
			 
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${item.pic !=null}">
						<img    src="${pageContext.request.contextPath}/upload/${item.pic}"   width=100 height=100/>
						<br/>
					</c:if>
					<input type="file"  name="pictureFile"  id="pic"/> 
				</td>
			</tr>
			<%--
			 --%>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" id="detail"  name="item.detail">${item.detail }</textarea>
				</td>
			</tr>
	<!-- 		<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr> -->
				<tr>
				<td colspan="2" align="center"><input type="button" id="submitUpdate"   value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>