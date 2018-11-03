<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/static/css/bootstrap.min.css">
<title>我的作品</title>
</head>
<style>
    .apply-main-text-wrap{
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
<script type="text/javascript">
function  finish(){
    if(confirm("确定要将此书完本吗?")){
     return true;
    }
    else
     return false;
 }
function  delNovel(){
    if(confirm("确定要将此书删除吗！")){
     return true;
    }
    else
     return false;
 }
</script>
<body>
<c:if test="${fromPage!=\"novelServlet\"}">
  <jsp:forward page="../novelServlet?action=queryAll"></jsp:forward>
</c:if>
 <div class="apply-main-text-wrap">
 <table class="table">
 <thead>
   <tr>
     <th>作品</th>
     <th>状态</th>
     <th colspan="3" style="width:30px"><center>操作</center></th>
   </tr>
 </thead>
   <tbody>
    <c:choose>
    <c:when test="${null!=novels}">
     <c:forEach items="${novels}" var="novel">
     <tr>
         <span id="bid" style="display:none">${novel.bid}</span>
     	<td><a   href="../detail.jsp?bid=${novel.bid}&action=query&fromPage=detail" target="mainFrame" >${novel.bookname}</a></td>
     	<td>${novel.status}</td>
     	<td><a  target="_self" href="novel_list.jsp?currentPage=1&bid=${novel.bid}">章节管理</a></td>
     	<td><a href="../novelServlet?bid=${novel.bid}&action=query&fromPage=writer/updateNovel"   >修改</a></td>
     	<td><a href="../novelServlet?bid=${novel.bid}&action=del"   onclick="return delNovel()">删除</a></td>
     	<c:if test="${'已完本'!=novel.status}">
     	<td><a  target="_self" href="../writer/addChapter.jsp?bid=${novel.bid}">发表章节</a></td>
     	</c:if>
     	<c:if test="${'已完本'!=novel.status}">
     	<td><a href="../novelServlet?bid=${novel.bid}&action=finish" onclick="return finish()">完本</a></td>
     	</c:if>
     </tr>
     </c:forEach>
    </c:when>
    <c:otherwise>
    暂无作品!
    </c:otherwise>
    </c:choose>
   </tbody>
 </table>
 </div>
</body>
</html>