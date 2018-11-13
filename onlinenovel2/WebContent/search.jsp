<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap-theme.min.css">
<title>小说</title>
<style type="text/css">

 .main-text-wrap a{
 text-decoration: none;
 }
    .bgmain{
      background-color:#FFFFFF ;
      font-family:"微软雅黑", sans-serif;
     }
    .main-text-wrap{
              font-family: Microsoft Yahei sans-serif;
               background-color:#EEEEEE;
               margin-left:10%;
               margin-right:10%;
               margin-bottom:5%;
               padding:5%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
 }
 .main_wrap{
   text-align:center;
   width: 880px;
 }
 .post{
	border-bottom:3px solid #888888;
}
</style>

</head>
<body >
    <c:if test="${origin!=\"forward\"}">
    <%request.setCharacterEncoding("utf-8"); %>
        <jsp:forward page="${pageContext.request.contextPath}/novel/search?currentPage=1&fromPage=search&keyword=${keyword}"></jsp:forward>
    </c:if>
    
<div class="main-text-wrap,bgmain" style="text-align: center">
<center>
<c:if test="${null!=keyword }">
<span style="text-align: left"> 共找到  ${page.list.size()} 本包含 " ${keyword} " 的作品</span>
</c:if>
<table  class="table table-hover  table-condensed">
 <thead>
 	<tr>
 	  <th width="100px" >分类</th>
 	  <th width="400px" >最近更新</th>
 	  <th width="100px">作者</th>
 	  <th width="100px">访问</th>
 	  <th width="100px">投票</th>
 	  <th width="200px">发表日期</th>
 	</tr>
 </thead>
 <tbody>
  <c:choose>
  <c:when test="${requestScope.page.list!=null}">
  <c:forEach items="${requestScope.page.list}"  var="novelVo" varStatus="status">
  <tr>
  	<td >${novelVo.categoryname }</td>
  	<td style="text-align: left"><a href="${pageContext.request.contextPath}/novel/query?bid=${novelVo.bid}&fromPage=detail" target="mainFrame">${novelVo.bookname}</a></td>
  	<td >${novelVo.username }</td>
  	<td>${novelVo.accessCount}</td>
  	<td>${novelVo.voteCount}</td>
  	<td><fmt:formatDate value="${novelVo.posttime }"  pattern="yyyy-MM-dd"/></td>
  </tr>
  </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="5"  style="text-align: left">目前还没有作品信息</td>
  </tr>
  </c:otherwise>
  </c:choose>
 </tbody>
 <!--  
 <tfoot>
 	   <c:if test="${page.list!=null }">
    <tr style="border:1px,0px,1px">
    	<td colspan="5">
    	<center>
    	<c:choose>
    	<c:when test="${page.currentPage==1}">
    	 首页
    	</c:when>
    	<c:otherwise>
    	<a href="novelQueryPageServlet?currentPage=1&action=search&fromPage=search&keyword=${keyword}">首页</a>
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.hasPrePage}">
    	<a href="novelQueryPageServlet?currentPage=${page.currentPage-1}&action=search&fromPage=search&keyword=${keyword}">上一页</a>
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
    	<a href="novelQueryPageServlet?currentPage=${page.currentPage+1}&action=search&fromPage=search&keyword=${keyword}">下一页</a>
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
    	<a href="novelQueryPageServlet?currentPage=${page.totalPage}&action=search&fromPage=search&keyword=${keyword}
    	">末页</a>
    	</c:otherwise>
    	</c:choose>
    	</center>
    	</td>
    </tr>
  </c:if>
 </tfoot>
 -->
</table>
</center>
</div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>