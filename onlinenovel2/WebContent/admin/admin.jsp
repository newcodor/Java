<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<title>网站后台管理</title>
</head>
  <frameset rows="20%,*,10%" cols="*" frameborder="yes" border="1"  framespacing="1">
	 <frame src="top.jsp" name="topFrame"   scrolling="no" noresize="noresize" id="topFrame"/>
	 <frameset cols="15%,*"  framespacing="1"  frameborder="no" border="1" >
	    <frame src="left.jsp" name="leftFrame"   scrolling="no" noresize="noresize" id="leftFrame"/>
	    <frame src="main.jsp" name="mainFrame"   scrolling="yes" noresize="noresize" id="mainFrame"/>
	</frameset>
	 <frame src="foot.jsp" name="bottomFrame"  scrolling="yes" noresize="noresize" id="bottomFrame"/>
 </frameset>
<body>
<jsp:include page="session_check.jsp"></jsp:include>
 </body>
<noframes>
<body>
    很抱歉，您使用的浏览器不支持框架功能，请尝试使用其他浏览器！
</body>
</noframes>
</html>