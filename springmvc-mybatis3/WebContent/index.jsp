<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
  <a target="_blank" href="${pageContext.request.contextPath}/product/product.action" >商品列表</a>
  <a target="_top" href="${pageContext.request.contextPath}/login.jsp" >登录</a>
  <a target="_top" href="${pageContext.request.contextPath}/logout.action" >注销</a>
</body>
</html>