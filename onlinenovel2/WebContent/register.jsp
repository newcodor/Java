<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="common/static/css/bootstrap.min.css" rel="stylesheet">
<link href="common/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<title>用户注册</title>
<style type="text/css">

  body{
  font-family: Microsoft Yahei, sans-serif;
  
  }
  input[type="text"],input[type="password"]{
  overflow:hidden;
  border: 1px solid #DBDBDB;
  border-radius:3px;
  }
  select {
  border-radius:3px;
  outline:none;
  }
  select option{
  font-style:Microsoft Yahei;
  }
  input[type="submit"],input[type="reset"]{
    color:#fff;
    font-size:125%;
    background-color:#428bca;
    border: 1px solid transparent;
    width:75px;
    padding:4px;
    border-radius:10px;
    outline:none; /*去掉外边线框*/
  }
  table {
  border-spacing: 0;
  border-radius:5px;
  border-collapse: separate;
  border:2px solid #1E90FF;
  outline:none;
  }
  table th{
  padding:3px;
  background-color: #1E90FF;
  }
  table td{
  border:1px solid #1E90FF;
  padding:2px 10px 2px;
  text-align:left;
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
<body>
<br>
<div>
<center>
<form action="registerServlet"  method="post">
<table  >
	<thead >
		<tr >
			<th  colspan="2" align="center"><center><strong>求小说用户注册</strong></center></th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td><input type="password" name="password2"></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td><input type="radio" name="sex" value="male" checked="checked">男<input type="radio" name="sex" value="female">女</td>
	</tr>
	<tr>
		<td>个人爱好:</td>
		<td>
		<input type="checkbox" name="hobbys" value="文学" >文学
		<input type="checkbox" name="hobbys" value="影视" >影视
		<input type="checkbox" name="hobbys" value="音乐" >音乐
		<input type="checkbox" name="hobbys" value="体育" >体育
		</td>
	</tr>
	<tr>
		<td>生日:</td>
		<td><input type="text" id="birthday" name="birthday"></td>
	</tr>
	<tr>
		<td>所在城市:</td>
		<td align="left">
		<select name="city">
			<option value="济南" selected="selected">济南</option>
			<option value="武汉">武汉</option>
			<option value="北京">北京</option>
			<option value="上海">上海</option>
			<option value="深圳">深圳</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>电子邮件:</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>QQ:</td>
		<td><input type="text" name="qq"></td>
	</tr>
	<tr >
		<td colspan="2"><input type="submit" value="提交">       <input type="reset" value="重置"></td>
	</tr>
	</tbody>
</table>
</form>
</center>
</div>
</body>
</html>