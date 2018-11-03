<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
  <frameset rows="20%,*" cols="*"  frameborder="yes"  border="1"  framespacing="1">
	 <frame src="head.jsp" name="topFrame"   scrolling="no" noresize="noresize" id="topFrame"/>
	 <frame src="novel.jsp" name="mainFrame"   scrolling="yes" noresize="noresize" id="mainFrame"/>
 </frameset>
 <noframes>
<body>
    很抱歉，您使用的浏览器不支持框架功能，请尝试使用其他浏览器！
</body>
</noframes>
</body>
</html>