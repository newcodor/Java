<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Properties,java.util.Date,java.text.SimpleDateFormat" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/static/css/bootstrap.min.css">
<title>主页</title>
</head>
<style type="text/css">
   .bg{
      background-color: #EEEEEE;
      font-family:"微软雅黑", sans-serif;
     }
    .main-text-wrap{
               background-color: #FFFFF9;
               margin-top:5%;
               margin-left:5%;
               margin-right:5%;
               margin-bottom:2%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
}
</style>
<body>
<%Properties props=System.getProperties(); %>
<div class="main-text-wrap">
<h4 class="text-center"><strong>系统配置</strong></h4>
<table class="table   table-bordered    table-condensed text-center" >
<tbody>
<tr>
	<td>服务器系统版本</td>
	<td><%=props.getProperty("os.name")%></td>
</tr>
<tr>
    <td>JDK版本</td>
	<td><%=props.getProperty("java.version")%></td>
</tr>
<tr>
	<td>服务器时间</td>
	<td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%></td>
</tr>
<tr>
	<td>您的ip</td>
	<td>
	<c:choose>
		<c:when test="${pageContext.request.remoteAddr!='0:0:0:0:0:0:0:1'}">
		${pageContext.request.remoteAddr }
		</c:when>
		<c:otherwise>
		  127.0.0.1
		</c:otherwise>
	</c:choose>
</tr>
<tr>
	<td>网站域名</td>
	<td><%=request.getServerName()%></td>
</tr>
<tr>
	<td>网站根目录</td>
	<td><%=request.getSession().getServletContext().getRealPath("/")%></td>
</tr>
</tbody>
</table>
</div>
</body>
</html>