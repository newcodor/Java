<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="../common/static/css/bootstrap-theme.min.css">
<title>登录</title></head>
<body>
<div class="container">
<form name="form1" class="form-signin" method="post" action="../adminLoginServlet" onsubmit="return check()">
<div class="panel panel-default">
<div class="panel-heading"><center><strong>网站管理登录</strong></center></div>
<div class="panel-body">
<div class="form-group">
<div class="input-group">
<span class="input-group-addon">
<strong>用户名:</strong>
</span>
<input class="form-control ng-pristine ng-invalid ng-invalid-required valid" type="text"  name="userName">
<iframe id="tmp_downloadhelper_iframe" style="display: none;"></iframe>
 </div>
 </div>
<div class="form-group">
<div class="input-group">
<span class="input-group-addon">
<strong>密码:&nbsp;&nbsp;&nbsp;&nbsp;</strong>
</span>
   <input class="form-control ng-pristine ng-invalid ng-invalid-required valid" type="password" name="password">
   <iframe id="tmp_downloadhelper_iframe" style="display: none;"></iframe>
   </div>
   </div>
 <button class="btn btn-lg btn-primary btn-block" data-loading-text="登录中....." type="submit">登录</button>
 </div>
</div>
</form>
</div>
<script>

 function check(){
 if(document.form1.id.value==""||document.form1.password.value==""){
   alert("用户名或密码不可为空!");
   return false;
   }
 else
   return true;

 }
</script>
</html>