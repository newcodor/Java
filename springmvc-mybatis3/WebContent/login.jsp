<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
   .login{
   border: 1px
   
   }
</style>

</head>
<body>
    <center>
	<div class="login">
	
	<form action="${pageContext.request.contextPath}/login.action"  method="post">
		<input type="text"  name="pass">
		<input type="submit"  value="登录">
	
	</form>
	</div>
    </center>
</body>
</html>