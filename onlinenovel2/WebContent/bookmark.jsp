<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的书签</title>
</head>
<style>
   .main-text-wrap{
               background-color:#F8F3E9;
               margin-left:10%;
               margin-right:10%;
               margin-bottom:7%;
               padding:5%;
               border-radius:5px
}

</style>
<script src="common/static/js/jquery-3.2.1.min.js"></script>
<body>
<c:if test="${fromPage!=\"bookMarkServlet\"}">
  <jsp:forward page="bookMarkServlet?action=query"></jsp:forward>
</c:if>
<div>
<form action="bookMarkServlet?action=del" method="post" onsubmit="return checkSelectedData()">
  <div class="main-text-wrap">
  <p>下面是您添加的书签</p>
  <center>
  <table class="table">
  <thead>
    <tr >
       <th>小说名称</th>
       <th>书签章节</th>
       <th>作者</th>
       <th>添加时间</th>
    </tr>
  </thead>
  <tbody>
  <c:choose>
  <c:when test="${null!=requestScope.bookMarkVos}">
     <c:forEach items="${requestScope.bookMarkVos}"  var="bookMarkVo" >
        <tr>
        	<td><input type="checkbox" name="selecedNovel" value="${bookMarkVo.bid}">&nbsp;&nbsp;&nbsp;<a href="detail.jsp?bid=${bookMarkVo.bid}&fromPage=detail" target="_blank">${bookMarkVo.bookname}</a></td>
        	<td><a href="chapter.jsp?bid=${bookMarkVo.bid}&chaid=${bookMarkVo.chaid}&fromPage=chapter" target="_blank">${bookMarkVo.title}</a></td>
        	<td>${bookMarkVo.username}</td>
        	<td>${bookMarkVo.addTime}</td>
        </tr>
     </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="4">暂无添加的书签!</td>
  </tr>
  </c:otherwise>
  </c:choose>
  </tbody>
  </table>
  </center>
  </div>
    <center><button type="submit" class="btn btn-danger" >删除</button></center>
  </form>
  </div>
    <hr>
  <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>