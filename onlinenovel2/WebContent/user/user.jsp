<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<title>个人中心</title>
</head>
	 <frameset cols="15%,*"  framespacing="1"  frameborder="no" border="1"  >
	    <frame src="left.jsp"    name="leftFrame"    scrolling="no"   noresize="noresize"   id="leftFrame"/>
	    <frame src="userInfo.jsp"    name="userMainFrame"    scrolling="yes"   noresize="noresize"   id="userMainFrame"/>
	</frameset>

 <noframes>
<body>
    很抱歉，您使用的浏览器不支持框架功能，请尝试使用其他浏览器！
</body>
</noframes>
</html>