<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<title>修改密码</title>
</head>
<style type="text/css">
	.red_error_icon{display:inline-block;*display:inline;*zoom:1;background:url(../imag/check_error.gif) no-repeat;}
        .red_error_icon{width:18px;height:18px;margin:0 5px -5px;background-position:center center;}
        .yellow_right_icon{display:inline-block;*display:inline;*zoom:1;background:url(../imag/check_right.gif) no-repeat;}
         .yellow_right_icon{width:18px;height:18px;margin:0 5px -5px;background-position:center center;}
	
</style>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>  
 <script src="${pageContext.request.contextPath}/common/static/js/bootstrap.min.js"></script>
<script>
function checkid(){
var id=document.form1.id.value;
$.post("checkAdminInfo.jsp", { checkid: username } ,function(msg){
     $('#checkid').empty();
          var data='';
          if(msg!=''){
            data = eval("("+msg+")");    //将返回的json数据进行解析，并赋给data
          }
        if(data.checkinfo=="ok"){
          $('#checkid').html("<em class='yellow_right_icon'></em>");
        }
      else if(data.checkinfo=="error"){
          $('#checkid').html("<em class='red_error_icon'></em> <font face='黑体,宋体' color='#FF0000'>用户名已存在</font>"); 
        // $('#checkid').html(<em class="red_error_icon">ddd</em>); 
        }
         // $('#checkid').html(data.checkinfo); 
        //alert("data.checkinfo:"+data.checkinfo);

   //document.getElementById("checkid").innerHTML=data;
   });
}
 function check(){
 if(document.form1.password2.value==""||document.form1.password.value==""){
   alert("密码或确认密码不可为空!");
   return false;
   }
  else if(document.form1.password2.value!=document.form1.password.value){
  alert("两次密码输入不一致!");
   return false;
  }
 else if(document.form1.email.value==""){
    alert("邮箱不可为空!");
	return false;
   }
 else{
     var btn = $("#btn_jump");
     btn.button('loading');
   return true;
 }

 }
 </script>
<body>
<div class="container">
<form name="form1"  class="form-signin" method="post" action="${pageContext.request.contextPath}/admin/updatepass" onsubmit="return check()">
<div class="panel panel-default">
<div class="panel-body"> 
  <div class="form-group">
<div class="input-group">
<span class="input-group-addon">
<div class="text-center">
  <strong>&nbsp;&nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;&nbsp;&nbsp;</strong> 
  </div>
  </span>
  <input  class="form-control ng-pristine ng-invalid ng-invalid-required valid" type="password" name="password">
  </div>
  </div>
  <div class="form-group">
<div class="input-group">
<span class="input-group-addon">
<div class="text-center">
<strong>确认密码:</strong>
</div>
</span>
 <input  class="form-control ng-pristine ng-invalid ng-invalid-required valid" type="password" name="password2">
</div>
</div>
<br>
 <button class="btn btn-lg btn-primary btn-block"  id="btn_jump" data-loading-text="更新中....." type="submit">更新</button>
</div>
</div>                       
</form>
</div>
</body>
</html>