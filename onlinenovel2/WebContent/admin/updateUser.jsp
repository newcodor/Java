<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<title>个人资料</title>
<style type="text/css">
   .bg{
      background-color:#FFFFFF ;
      font-family:"微软雅黑", sans-serif;
     }
    .main-text-wrap{
               background-color:#EEEEEE;
               margin-top:5%;
               margin-left:7%;
               margin-right:7%;
               margin-bottom:5%;
               padding:5%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
}
</style>
</head>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/common/static/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/common/static/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/common/static/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
$(document).ready(
		   function(){

$("#birthday").datetimepicker({
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    todayHighlight: true,
    showMeridian: true,
    pickerPosition: "bottom-left",
    language: 'zh-CN',//中文，需要引用zh-CN.js包
     startView: 2,//月视图
     minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
 });
		   });
</script>
<body class="bg">
<c:if test="${origin!=\"forward\"}">
  <jsp:forward page="/user/query?userid=${param.userid}&fromPage=admin/updateUser"></jsp:forward>
</c:if>
<br>
<left><button style="margin-left:5px" onclick="window.history.go(-1)"  class="btn btn-primary">返回</button></left>
<div class="main-text-wrap">
<center>
<div class="form-inline">
<form action="${pageContext.request.contextPath}/user/update"  method="post">
<table class="table" >
	<thead >
		<tr >
			<th  colspan="2" align="center"><h2><strong><center>个人资料</center></strong></h2></th>
		</tr>
		<tr><td></td></tr>
	</thead>
	<tbody>
	<tr>
		<td>用户名:</td>
		<td>
		 <c:if test="${null!=requestScope.currentUser}">
		    ${requestScope.currentUser.username }
		 </c:if>
		</td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
		<input type="radio" name="sex" value="male" <c:if test="${'男'==requestScope.currentUser.sex}">checked='checked'</c:if>>男  
		<input type="radio"   name="sex" value="female" <c:if test="${'女'==requestScope.currentUser.sex}">checked='checked'</c:if>>女</td>
	</tr>
	<tr>
		<td>个人爱好:</td>
		<td>
		<input type="checkbox"  name="hobbys" value="文学"  checked='checked'> 文学
		<input type="checkbox"  name="hobbys" value="影视" > 影视
		<input type="checkbox"  name="hobbys" value="音乐" checked='checked'> 音乐
		<input type="checkbox"  name="hobbys" value="体育" checked='checked'> 体育
		</td>
	</tr>
	<tr>
		<td>出生日期:</td>
		<td><input type="text" class="form-control"  id="birthday" name="birthday" value="<c:if test='${null!=requestScope.currentUser}'>${requestScope.currentUser.birthday}</c:if>"></td>
	</tr>
	<tr>
		<td>所在城市:</td>
		<td align="left">
		<select name="city" class="form-control">
			<option value="济南" <c:if test="${'济南'==requestScope.currentUser.city}">selected='selected'</c:if>>济南</option>
			<option value="武汉" <c:if test="${'武汉'==requestScope.currentUser.city}">selected='selected'</c:if>>武汉</option>
			<option value="北京" <c:if test="${'北京'==requestScope.currentUser.city}">selected='selected'</c:if>>北京</option>
			<option value="上海" <c:if test="${'上海'==requestScope.currentUser.city}">selected='selected'</c:if>>上海</option>
			<option value="深圳" <c:if test="${'深圳'==requestScope.currentUser.city}">selected='selected'</c:if>>深圳</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>电子邮件:</td>
		<td><input type="text" class="form-control"  name="email" value='<c:if test="${null!=requestScope.currentUser}">${requestScope.currentUser.email }</c:if>'></td>
	</tr>
	<tr>
		<td>QQ:</td>
		<td><input type="text" class="form-control" name="qq" value='<c:if test="${null!=requestScope.currentUser}">${requestScope.currentUser.qq}</c:if>'></td>
	</tr>
	<tr >
		<td colspan="2"><input type="submit"  class="btn btn-primary" value="更新"></td>
	</tr>
	</tbody>
</table>
<input type="hidden" name="userid" value="${requestScope.currentUser.userid}">
<input type="hidden" name="fromPage" value="admin/updateUser">
</form>
</div>
</center>
</div>
</body>
</html>