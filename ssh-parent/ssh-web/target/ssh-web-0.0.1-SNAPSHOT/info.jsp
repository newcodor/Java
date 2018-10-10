<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<%-- 	<s:iterator value="#requestScope.customer">
	  <s:property value="custName"></s:property>
	</s:iterator> --%>
	
	  <s:property value="#request.customer.custName"></s:property>
</body>
</html>