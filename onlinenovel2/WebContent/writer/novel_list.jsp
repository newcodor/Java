<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap-theme.min.css">
<title>小说列表</title>
<style>
    .main-list{
               margin-top:5%;
               margin-left:7%;
               margin-right:7%;
               margin-bottom:5%;
               padding:5%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
              
}
</style>
</head>
<body>
<c:if test="${origin!=\"forward\"}">
  <jsp:forward page="/novel/query?currentPage=${param.currentPage}&bid=${param.bid}&fromPage=writer/novel_list"></jsp:forward>
</c:if>
<br>
<left><button style="margin-left:5px" onclick="window.history.back()"  class="btn btn-primary">返回</button></left>
<center>
<div class="main-list">
<table  class="table">
 <thead>
 	<tr>
 	  <th width="100px" colspan="4" style="text-align: center">章节列表</th>
 	</tr>
 </thead>
 <tbody>
  <c:choose>
  <c:when test="${requestScope.page.list.size()>0}">
  <c:forEach items="${requestScope.page.list}"  var="chapter" varStatus="status">
  <tr>
  	<td style="text-align: left"><a href="${pageContext.request.contextPath}/chapter/read/${chapter.bid}/${chapter.chaid}.html" target="_blank">${chapter.title}</a></td>
  	<td><fmt:formatDate value="${chapter.posttime }"  pattern="yyyy-MM-dd HH:mm"/></td>
  	<td><a href="${pageContext.request.contextPath}/chapter/query/${chapter.bid}/${chapter.chaid}?fromPage=writer/editChapter">修改</a></td>
  	<td><a href="${pageContext.request.contextPath}/chapter/delete?currentPage=${page.currentPage}&bid=${chapter.bid}&chaid=${chapter.chaid}&fromPage=writer/novel_list">删除</a></td>
  </tr>
  </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="5"  style="text-align: center"><h4>暂无章节信息</h4></td>
  </tr>
  </c:otherwise>
  </c:choose>
 </tbody>
 <tfoot>
 	   <c:if test="${page.list.size()>0 }">
    <tr style="border:1px,0px,1px">
    	<td colspan="5">
    	<center>
    	<c:choose>
    	<c:when test="${page.currentPage==1}">
    	 首页
    	</c:when>
    	<c:otherwise>
    	<a href="novel_list.jsp?currentPage=1&bid=${requestScope.bid}&fromPage=writer/novel_list">首页</a>
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.hasPrePage}">
    	<a href="novel_list.jsp?currentPage=${page.currentPage-1}&bid=${requestScope.bid}&fromPage=writer/novel_list">上一页</a>
    	</c:when>
    	<c:otherwise>
    	上一页
    	</c:otherwise>
    	</c:choose>
    	<c:if test="${page.currentPage!=null}">
    	 第 ${page.currentPage} 页
    	</c:if>
    	<c:choose>
    	<c:when test="${page.hasNextPage}">
    	<a href="novel_list.jsp?currentPage=${page.currentPage+1}&bid=${requestScope.bid}&fromPage=writer/novel_list">下一页</a>
    	</c:when>
    	<c:otherwise>
    	下一页
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.currentPage==page.totalPage}">
    	末页
    	</c:when>
    	<c:otherwise>
    	<a href="novel_list.jsp?currentPage=${page.totalPage}&bid=${requestScope.bid}&fromPage=writer/novel_list">末页</a>
    	</c:otherwise>
    	</c:choose>
    	</center>
    	</td>
    </tr>
  </c:if>
 </tfoot>
</table>	
</div>	
</center>

</body>
</html>