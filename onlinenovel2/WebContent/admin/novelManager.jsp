<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<title>小说管理</title>
</head>
<style type="text/css">
   .bg{
      background-color: #EEEEEE;
      font-family:"微软雅黑", sans-serif;
     }
    .main-novelList-wrap{
               background-color: #FFFFFF;
               margin-left:5%;
               margin-right:5%;
               margin-bottom:2%;
               border:1px  solid   #D7D7D7;
                border-radius:5px
}
</style>
<script type="text/javascript">
function  delNovel(){
    if(confirm("确定要将该小说删除吗！")){
     return true;
    }
    else
     return false;
 }
</script>

<body class="bg">
<c:if test="${origin!=\"forward\"}">
   <jsp:forward page="/novel/manageall"></jsp:forward>
</c:if>
<center>
<strong class="h2">小说管理</strong>
<div class="main-novelList-wrap">
<center>
<table  class="table   table-bordered  table-hover  table-condensed"  style="border:1px  solid   #555555">
 <thead>
 	<tr>
 	  <th width="50px" >ID</th>
 	  <th width="200px" >最近更新</th>
 	  <th width="100px">作者</th>
 	  <th width="100px" >分类</th>
 	  <th width="100px" >操作</th>
 	  <th width="100px">访问</th>
 	  <th width="100px">投票</th>
 	  <th width="200px">发表日期</th>
 	</tr>
 </thead>
 <tbody>
  <c:choose>
  <c:when test="${requestScope.page.list.size()>0}">
  <c:forEach items="${requestScope.page.list}"  var="novelVo" varStatus="status">
  <tr>
     <td >${novelVo.bid }</td>
  	<td style="text-align: center"><a href="${pageContext.request.contextPath}/novel/query?bid=${novelVo.bid}&fromPage=detail" target="_blank">${novelVo.bookname}</a></td>
  	<td>${novelVo.username }</td>
  	<td>${novelVo.categoryname }</td>
  	<td>
  	<a href="${pageContext.request.contextPath}/novel/query?bid=${novelVo.bid}&fromPage=admin/updateNovel"  title="修改小说"  >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
  	<a href="${pageContext.request.contextPath}/novel/delete/${novelVo.bid}?fromPage=admin/novelManager" title="删除小说"  onclick="return delNovel()">删除</a>
  	</td>
  	<td>${novelVo.accessCount}</td>
  	<td>${novelVo.voteCount}</td>
  	<td><fmt:formatDate value="${novelVo.posttime }" pattern="yyyy-MM-dd"/></td>
  </tr>
  </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="8"  style="text-align: center">目前还没有作品信息</td>
  </tr>
  </c:otherwise>
  </c:choose>
 </tbody>
 <tfoot>
 	   <c:if test="${page.list.size()>0 }">
    <tr style="border:1px,0px,1px">
    	<td colspan="8">
    	<center>
    	<c:choose>
    	<c:when test="${page.currentPage==1}">
    	 首页
    	</c:when>
    	<c:otherwise>
    	<a href="${pageContext.request.contextPath}/novel/manageall?currentPage=1&from=admin">首页</a>
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.hasPrePage}">
    	<a href="${pageContext.request.contextPath}/novel/manageall?currentPage=${page.currentPage-1}&from=admin">上一页</a>
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
    	<a href="${pageContext.request.contextPath}/novel/manageall?currentPage=${page.currentPage+1}&from=admin">下一页</a>
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
    	<a href="${pageContext.request.contextPath}/novel/manageall?currentPage=${page.totalPage}">末页</a>
    	</c:otherwise>
    	</c:choose>
    	</center>
    	</td>
    </tr>
  </c:if>
 </tfoot>
</table>
</center>
</div>
</center>
</body>
</html>