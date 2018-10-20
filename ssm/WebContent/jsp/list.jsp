<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://itcast.cn/common/" prefix="itcast" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
</head>
<body>
<div>
<table>
<c:choose>
<c:when test="${requestScope.customer!=null }">
      <tr>
        <td>${requestScope.customer.custId}</td>
        <td>${requestScope.customer.custName}</td>
        <td>${requestScope.customer.custLevel}</td>
      </tr>
<%--    <c:forEach  items="${requestScope.customers}" var="cs"  varStatus="s">
      <tr>
        <td>${s.index}</td>
        <td>${cs.custId}</td>
        <td>${cs.custName}</td>
        <td>${cs.custLevel}</td>
      </tr>
   </c:forEach> --%>
</c:when>
<c:otherwise>
     <tr>
       <td colspan="3">暂无数据</td>
     </tr>
</c:otherwise>
</c:choose>
</table>
</div>

<itcast:page url=""></itcast:page>
</body>
</html>