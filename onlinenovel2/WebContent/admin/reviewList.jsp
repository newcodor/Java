<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="common/static/css/bootstrap.min.css">
<title>审核作者申请</title>
</head>
<style>
    .apply-list-wrap{
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
<body>
<c:if test="${fromPage!=\"novelApplyServlet\"}">
  <jsp:forward page="../novelApplyServlet?action=queryAll"></jsp:forward>
</c:if>
 <div class="apply-list-wrap">
 <table class="table">
 <thead>
   <tr>
     <th>序号</th>
     <th>申请用户</th>
     <th>申请作品</th>
     <th>审核</th>
     <th>审核状态</th>
     <th>申请时间</th>
   </tr>
 </thead>
   <tbody>
    <c:choose>
    <c:when test="${reviewVos.size()>0}">
     <c:forEach items="${reviewVos}" var="reviewVo" varStatus="status">
     <tr>
        <td>${status.index+1}</td>
     	<td>${reviewVo.username}</td>
     	<td>${reviewVo.bookname}</td>
     	<td><a  target="_self" href="novelApplyServlet?action=query&rid=${reviewVo.rid}">审核</a></td>
     	<td><c:choose>
     	<c:when test="${'waitpass'==reviewVo.reviewStatus}">
     	待审核
     	</c:when>
     	<c:otherwise>
     	<c:choose>
     	<c:when test="${'nopass'==reviewVo.reviewStatus}">
     	未通过
     	</c:when>
     	<c:otherwise>
     	<c:if test="${'pass'==reviewVo.reviewStatus}">
     	通过
     	</c:if>
     	</c:otherwise>
     	</c:choose>
     	</c:otherwise>
     	</c:choose></td>
     	<td>${reviewVo.applyTime}</td>
     </tr>
     </c:forEach>
    </c:when>
    <c:otherwise>
          <tr>
          <td colspan="6">
                      <center>暂无待审核申请!</center>
          </td>
          </tr>
    </c:otherwise>
    </c:choose>
   </tbody>
 </table>
 </div>
</body>
</html>