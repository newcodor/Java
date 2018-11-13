<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap-theme.min.css">
<title>头部</title>
</head>
<style type="text/css">
   .bg{
      background-color: #5BC0EB;
     }
</style>
<body class="bg" >
<jsp:include page="session_check.jsp"></jsp:include>
<div class="collapse navbar-collapse">
     <dl class="class="nav navbar-nav navbar-right ng-scope"">
     <dd>
    <div  class="text-right">
    <strong>欢迎管理员:${sessionScope.admin.username}</strong> 
    <a href="${pageContext.request.contextPath}/logout" target="_parent"  wt-tracker="Header|Menu|Goto Apply"><strong>注销</strong></a>
    <h1 align="center" color="#F5DEB3">小 说 网 站 管 理 后 台</h1>
    </div>
    </dd>
    </dl>
</div>
</body>
</html>