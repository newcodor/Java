<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理查询</title>
</head>
<body>
    <c:if test="${requestScope.admin!=null}">
       ${requestScope.admin}
    </c:if>
    <c:if test="${requestScope.categorys !=null }">
       <c:forEach  items="${requestScope.categorys}"  var="category">
          ${category}<br>
       </c:forEach>
    </c:if>
</body>
</html>