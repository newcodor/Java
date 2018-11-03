<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="common/static/css/bootstrap.min.css" rel="stylesheet">
<link href="common/static/css/style.css" rel="stylesheet">
<title>分类管理</title>
</head>
<style type="text/css">
   .bg{
      background-color:#FFFFFF ;
      font-family:"微软雅黑", sans-serif;
     }
    .main-text-wrap{
               background-color:#EEEEEE;
               margin-left:10%;
               margin-right:10%;
               margin-bottom:5%;
               padding:5%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
}
</style>
<body class="bg">
 <div class="main-text-wrap">
<div  class="text-center">
<strong class="h2">分类管理</strong>
</div>
<br>
<br>
<form  action="novelCategoryServlet"  method="post">
<div class="form-inline">
    <lable>分类: </lable >
    <input      class="form-control"  type="text" name="categoryname">
    <input type="hidden"  name="action" value="add"> 
     <input   class="btn btn-primary"  type="submit" value="添加">
</div>
</form>
<br>
<table  class="table   table-bordered  table-hover  table-condensed"  style="border:1px  solid   #555555">
    <thead>
        <th><center>ID</centert></th>
        <th><center>分类</centert></th>
     <%--    <th><center>创建时间</centert></th> --%>
       <th><center>操作</center></th>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${null!=requestScope.categorys}">
       <c:forEach  items="${requestScope.categorys}" var="category"  varStatus="status">
         <tr>
         	<td><center>${status.index+1}</center></td>
         	<td><center>${category.categoryname}</center></td>
         	<td><center><a href="novelCategoryServlet?cid=${category.cid}&action=del">删除</a></center></td>
         </tr>
       </c:forEach>
    </c:when>
    <c:otherwise>
     <tr>
  	<td colspan="3"  style="text-align: left">暂无分类信息!</td>
  </tr>
    </c:otherwise>
    </c:choose>

    </tbody>
   </table>
   </div>
<script   type="text/javascript"> 
function check(category) { 
 if (confirm("确认要删除分类  "+category+"  吗?")){ 
  return true; 
 }
else
  return false; 
} 
</script>
</body>
</html>
