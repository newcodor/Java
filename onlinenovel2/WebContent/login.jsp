<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/head.css">
<title>用户登录</title>
<style>
 .login{
  font-family: Microsoft Yahei, sans-serif;
  
  }
  .login input[type="text"],input[type="password"]{
  overflow:hidden;
  line-height: 20px;
  border: 1px solid #DBDBDB;
  border-radius:3px;
  }
  .login a{
  text-decoration: none;
  }
  .login .button{
  
  border: 1px solid;
  display: block;
  background-color: #337ab7;
  border-color: #2e6da4;
  color:#fff;
  border-radius: 6px;
  width: 75px;
  line-height: 30px;
  font-size: 20px;
  font-family: 'Microsoft YaHei';
  outline: none;
  
}
  
  .login .border{
  background-color:	#7AC5CD;
  border:solid thin #98F5FF;
  border-spacing:10px 30px;
  border-radius:6px;
  padding: 20px;
  text-align:center;
  }
  
</style>

</head>
<script type="text/javascript">
  function checkLoginInfo(){
	 // changeButtonColor();
	  var userName = document.getElementById("userName").value;
	  var password = document.getElementById("password").value;
	  if(userName==""){
		  alert("用户名不可为空!");
		  return false;
	  }else if(password==""){
		  alert("密码不可为空!");
		  return false;
	  }else
		  return true;
		  
  }
  function changeButtonColor(){
	  document.getElementsByName("submit").setAttribute("style","background-color: red");
  }
</script>
<body>
<div class="head">
<div>
 <h1  align="left"><a  href="index.jsp" target="_top">求小说</a></h1>
 <ul style="list-style: none">
</ul>
<form action="" method="get" accept-charset="utf-8" class="navbar-form navbar-left" target="_blank" >
	      <div class="form-group">
		       <input type="text" class="form-control" name="keyword" placeholder="输入关键字回车">
		     </div>
		</form>
		<br>
 <p align="right">
 <c:if test="${sessionScope.user!= null}">
 <a href="user/user.jsp" title="个人中心" target="mainFrame">个人中心</a> |
 <a href="bookself.jsp" title="我的书架" target="mainFrame">我的书架 </a>|
  <a href="bookmark.jsp" title="我的书签" target="mainFrame">我的书签</a> |
 </c:if>
 <c:choose>
   <c:when test="${sessionScope.user == null}">
<a href="${pageContext.request.contextPath}/login.jsp" target="mainFrame">登录</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/register.jsp" target="mainFrame">注册</a>
   </c:when>
   <c:otherwise>
  欢迎您,用户: ${sessionScope.user.username}
  &nbsp;&nbsp;
  <a target="mainFrame" href="${pageContext.request.contextPath}/logout">注销</a>
   </c:otherwise>
 </c:choose>
 </p>
</div>
<div>
<hr color="#00BFFF" size="20px">
</div>
</div>
<br>

<div class="login" style="text-align: center">
<form action="${pageContext.request.contextPath}/login" method="post"  onsubmit="return checkLoginInfo()">
<center>
<table   class="border">
	<thead>
		<tr>
		<th colspan="2"><h1><strong>用户登录</strong></h1></th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>用户名:</td>
		<td><input type="text" id="userName" name="userName" placeholder="请输入用户名" ></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" id="password" name="password"  placeholder="请输入密码"></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="登录"  class="button"  ></td>
		<td><a href="register.jsp"  target="_top">新用户注册</a></td>
	</tr>
	</tbody>
</table>
</center>
</form>
</div>
</body>
</html>