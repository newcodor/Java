<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="common/static/css/bootstrap.min.css" rel="stylesheet">
<title>用户管理</title>
</head>
<style type="text/css">
   .bg{
      background-color: #EEEEEE;
      font-family:"微软雅黑", sans-serif;
     }
    .main-text-wrap{
               background-color: #FFFFFF;
               margin-left:5%;
               margin-right:5%;
               margin-bottom:2%;
               border:1px  solid   #D7D7D7;
                border-radius:5px
}
</style>
<script type="text/javascript">
function  delUser(){
    if(confirm("确定要将此用户删除吗！")){
     return true;
    }
    else
     return false;
 }
</script>
<body class="bg">
<center><strong class="h2">会员管理</strong>
<div class="main-text-wrap">
<table  class="table   table-bordered  table-hover  table-condensed"  style="border:1px  solid   #555555">
    <thead>
    <tr>
        <th><center>ID</center></th>
        <th><center>用户名</center></th>
        <th><center>角色</center></th>
        <th><center>性别</center></th>
        <th><center>城市</center></th>
        <th><center>邮箱</center></th>
     <%--    <th><center>创建时间</center></th> --%>
       <th colspan="2"><center>操作</center></th>
       </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${null!=requestScope.users}">
       <c:forEach  items="${requestScope.users}" var="user"  varStatus="status">
         <tr>
         	<td><center>${status.index+1}</center></td>
         	<td><center>${user.username}</center></td>
         	<td><center>
         	<c:choose>
         	<c:when test="${'reader'==user.role}">读者
         	</c:when>
         	<c:otherwise>
         	<c:if test="${'author'==user.role}">作家</c:if>
         	</c:otherwise>
         	</c:choose>
         	</center></td>
         	<td><center>${user.sex}</center></td>
         	<td><center>${user.city}</center></td>
         	<td><center>${user.email}</center></td>
         	<td><center><a href="userServlet?userid=${user.userid}&action=query&fromPage=admin/updateUser">修改</a></center></td>
         	<td><center><a href="userServlet?userid=${user.userid}&role=${user.role}&action=del&fromPage=admin/member.jsp"  onclick="return delUser()">删除</a></center></td>
         </tr>
       </c:forEach>
    </c:when>
    <c:otherwise>
     <tr>
  	<td colspan="6"  style="text-align: left">暂无用户信息!</td>
  </tr>
    </c:otherwise>
    </c:choose>

    </tbody>
   </table>
</div>
</center>

</body>
</html>