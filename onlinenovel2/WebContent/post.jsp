<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖</title>
<style type="text/css">
 body{
 font-family: Microsoft Yahei;
 }
 #post td{
   text-align: left;
 }

  input[type="text"],textarea{
  overflow:hidden;
  border: 1px solid #CDCDB4;
  border-radius:3px;
  }
</style>
</head>
<body>
<center>
<div class="main_wrap">
<c:if test="${sessionScope.user ==null}">
<span style="display: block;background-color: #428bca">本论坛发表留言需要登录&nbsp;&nbsp;|&nbsp; <a href="login.jsp">登录</a> &nbsp;|&nbsp; <a href="register.jsp">新用户注册</a>
</span>
</c:if>
<pre></pre>
<form action="messageAddServlet" method="post">
<table style="display: block;border:0px" id="post">
<tr>
	<td>标题:</td>
	<td><input type="text" name="msgtopic" size="80"><td>
</tr>
<tr>
	<td style="text-align: top">内容:</td>
	<td><textarea rows="10" cols="80"  name="msgcontents"></textarea></td>
</tr>
<tr>
 <td align="left" colspan="2"><input type="submit"  value="发表留言"></td>
</tr>
</table>
</form>
</div>
</center>
</body>
</html>