<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>侧边栏</title>
<style type="text/css">
  .bgcolor{
  	background-color: #EEEEEE;
  }
  
</style>
</head>
<body class="bgcolor">
 <c:if test="${\"forward\"!=origin}">
  <jsp:forward page="/user/query?fromPage=user/left"></jsp:forward>
</c:if>
<ul  class="nav" >
<li >
	<a href="${pageContext.request.contextPath}/index.jsp" title="首页" target="_blank">首页</a>
 </li>
  <li >
	<a href="${pageContext.request.contextPath}/user/userInfo.jsp" title="个人资料管理" target="userMainFrame">个人资料管理</a>
 </li>
 <li >
	<a href="${pageContext.request.contextPath}/user/updatepass.jsp" title="修改密码" target="userMainFrame">修改密码</a>
 </li>
 <c:if test="${requestScope.currentUser.role==\"reader\"}">
  <li >
	<a href="${pageContext.request.contextPath}/user/applyWriter.jsp" title="申请成为作者" target="userMainFrame">申请成为作者</a>
 </li>
 </c:if>
  <c:if test="${requestScope.currentUser.role==\"author\"}">
   <li >
	<a target="userMainFrame"  href="${pageContext.request.contextPath}/writer/myNovel.jsp" title="我的作品" >我的作品</a>
 </li>
    <li >
	<a target="userMainFrame"  href="${pageContext.request.contextPath}/writer/addNovel.jsp" title="发布作品" >发布作品</a>
 </li>
 </c:if>
 </ul>
</body>
</html>