<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/head.css">
<title>用户登录</title>


</head>
<script type="text/javascript">
  function checkLoginInfo(){
	 // changeButtonColor();
	  var userName = document.getElementById("userName").value;
	  var password = document.getElementById("password").value;
	  if(userName==""){
		  alert("用户名不可为空!");
		  return false;
	  }else if(password==""){
		  alert("密码不可为空!");
		  return false;
	  }else
		  return true;
		  
  }
  function changeButtonColor(){
	  document.getElementsByName("submit").setAttribute("style","background-color: red");
  }
</script>
<body>
<div class="head">
<div>
 <h1  align="left"><a  href="index.jsp" target="_top">求小说</a></h1>
 <ul style="list-style: none">
</ul>
<form action="" method="get" accept-charset="utf-8" class="navbar-form navbar-left" target="_blank" >
	      <div class="form-group">
		       <input type="text" class="form-control" name="keyword" placeholder="输入关键字回车">
		     </div>
		</form>
		<br>
 <p align="right">
 <c:if test="${sessionScope.user!= null}">
 <a href="user/user.jsp" title="个人中心" target="mainFrame">个人中心</a> |
 <a href="bookself.jsp" title="我的书架" target="mainFrame">我的书架 </a>|
  <a href="bookmark.jsp" title="我的书签" target="mainFrame">我的书签</a> |
 </c:if>
 <c:choose>
   <c:when test="${sessionScope.user == null}">
<a href="${pageContext.request.contextPath}/login.jsp" target="mainFrame">登录</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/register.jsp" target="mainFrame">注册</a>
   </c:when>
   <c:otherwise>
  欢迎您,用户: ${sessionScope.user.username}
  &nbsp;&nbsp;
  <a target="mainFrame" href="${pageContext.request.contextPath}/logout">注销</a>
   </c:otherwise>
 </c:choose>
 </p>
</div>
<div>
<hr color="#00BFFF" size="20px">
</div>
</div>
<br>

<div class="container" >
<form action="${pageContext.request.contextPath}/login" method="post"  onsubmit="return checkLoginInfo()">


<div class="row" >
  <div class="form-group">
    <label for="username" class="col-sm-4 control-label"  style="text-align: right">用户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="userName"  name="userName" placeholder="请输入用户名">
    </div>
  </div>
  </div>
  <br/>
  <div class="row" >
  <div class="form-group">
    <label for="password" class="col-sm-4 control-label"  style="text-align: right">密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="password"  name="password" placeholder="请输入密码">
    </div>
  </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-4 col-sm-4">
      <div class="checkbox">
        <label>
          <input type="checkbox">请记住我
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-4 col-sm-8">
      <button type="submit" class="btn btn-info">登录</button>
    </div>
  </div>

</form>
</div>
</body>
</html>