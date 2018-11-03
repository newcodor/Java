<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复</title>
<style type="text/css">
 body{
 font-family: Microsoft Yahei;
 }
 #post td{
   text-align: left;
 }
a{
color: #FFFFFF;
}
  input[type="submit"],textarea{
  overflow:hidden;
  border: 1px solid #CDCDB4;
  border-radius:3px;
  }
</style>
<script type="text/javascript">


</script>
</head>
<body>
<center>
<div class="main_wrap">
<c:if test="${sessionScope.user ==null}">
<br>
<span style="display: block;background-color: #428bca">本站评论需要登录&nbsp;&nbsp;|&nbsp; <a href="login.jsp"  target="_top">登录</a> &nbsp;|&nbsp; <a href="register.jsp" target="mainFrame">新用户注册</a>
</span>
<br>
</c:if>
<form action="replyAddServlet" method="post" >
<table style="display: block;border:0px solid #fff;border-spacing:0px;border-color:#fff" id="post">
<tr>
    <td style="disply:none;border:0px solid #fff"><input type="hidden" name="bid" id="bid" value="<c:choose><c:when test='${null!=novelVo}'>${novelVo.bid}</c:when><c:otherwise>0</c:otherwise></c:choose>"></td>
	<td style="text-align: top;border:0px solid #fff">内容:</td>
	<td ><textarea id="reply" rows="8" cols="80"  name="replycontents"></textarea></td>
</tr>
<c:if test=""></c:if>
<tr>
 <td  style="border:0px solid #fff" align="left" colspan="2"><input type="submit"  value="发表评论" ></td>
</tr>
</table>
</form>
</div>
</center>
</body>
</html>