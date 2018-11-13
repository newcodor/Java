<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap-theme.min.css">
<title>求小说网顶边栏</title>
</head>
<body>
<%--     <c:if test="${origin!=\"forward\"}">
        <jsp:forward page="novelCategoryServlet?action=queryAll&fromPage=head"></jsp:forward>
    </c:if> --%>
   <c:if test="${origin!=\"forward\"}">
        <jsp:forward page="/category/list"></jsp:forward>
    </c:if>
<div class="head">
<div>
 <h1  align="left"><a  href="${pageContext.request.contextPath}/index.jsp" target="_top">求小说</a></h1>
 <ul style="list-style: none">
</ul>
<form action="${pageContext.request.contextPath}/novel/search" method="get" accept-charset="utf-8" class="navbar-form navbar-left" target="mainFrame">
	      <div class="form-group">
		       <input type="text" class="form-control" name="keyword" placeholder="输入书名或作者回车">
		       <input type="hidden"  name="fromPage" value="search">
		     </div>
		</form>
		
<c:choose>
<c:when test="${null!=categorys}">
<ul class="nav navbar-nav">
<c:forEach items="${requestScope.categorys}" var="category">
<li>
<a href="${pageContext.request.contextPath}/novel/category/query?cid=${category.cid}&categoryname=${category.categoryname}&fromPage=category" target="mainFrame">${category.categoryname}</a>

</li>
</c:forEach>
</ul>
</c:when>
<c:otherwise>
暂无分类
</c:otherwise>
</c:choose>
		<br>
 <p align="right">
 <c:if test="${sessionScope.user != null}">
 <a href="user/user.jsp" title="个人中心" target="mainFrame">个人中心</a> |
 <a href="${pageContext.request.contextPath}/user/bookself/list" title="我的书架" target="mainFrame">我的书架 </a>|
  <a href="${pageContext.request.contextPath}/user/bookmark/list" title="我的书签" target="mainFrame">我的书签</a> |
 </c:if>
 <c:choose>
   <c:when test="${sessionScope.user == null}">
<a href="${pageContext.request.contextPath}/login.jsp" target="_top">登录</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/register.jsp" target="mainFrame">注册</a>
   </c:when>
   <c:otherwise>
  欢迎您,用户: ${sessionScope.user.username}
  &nbsp;&nbsp;
  <a target="_top" href="${pageContext.request.contextPath}/logout">注销</a>
   </c:otherwise>
 </c:choose>
 </p>
</div>
<div>
<hr color="#00BFFF" size="20px">
</div>
</div>
<br>
</body>
</html>