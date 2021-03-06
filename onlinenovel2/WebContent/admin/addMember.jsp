<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<title>添加用户</title>
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
<div class="main-text-wrap">
<center>
<div class="form-inline">
<form action="${pageContext.request.contextPath}/user/add"  method="post">
<table class="table" >
	<thead >
		<tr >
			<th  colspan="2" align="center"><h2><strong><center>用户添加</center></strong></h2></th>
		</tr>
		<tr><td></td></tr>
	</thead>
	<tbody>
	<tr>
		<td>用户名:</td>
		<td><input type="text" class="form-control" name="userName"></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" class="form-control" name="password"></td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td><input type="password" class="form-control" name="password2"></td>
	</tr>
	<tr>
		<td>性别:</td>
		<td><input type="radio" name="sex" value="male" checked="checked">男  <input type="radio"   name="sex" value="female">女</td>
	</tr>
	<tr>
		<td>个人爱好:</td>
		<td>
		<input type="checkbox"  name="hobbys" value="文学" > 文学
		<input type="checkbox"  name="hobbys" value="影视" > 影视
		<input type="checkbox"  name="hobbys" value="音乐" > 音乐
		<input type="checkbox"  name="hobbys" value="体育" > 体育
		</td>
	</tr>
	<tr>
		<td>生日:</td>
		<td><input type="text" class="form-control" id="birthday" name="birthday"></td>
	</tr>
	<tr>
		<td>所在城市:</td>
		<td align="left">
		<select name="city" class="form-control">
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
		<td><input type="text" class="form-control"  name="email"></td>
	</tr>
	<tr>
		<td>QQ:</td>
		<td><input type="text" class="form-control" name="qq"></td>
	</tr>
	<tr >
		<td colspan="2"><input type="submit"  class="btn btn-primary" value="添加">       <input type="reset" class="btn btn-primary"  value="重置"></td>
	</tr>
	</tbody>
</table>
</form>
</div>
</center>
</div>
</body>
</html>