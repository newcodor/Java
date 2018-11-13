<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<title>发表新书</title>
</head>
<style>
    .apply-main-text-wrap{
               background-color:#EEEEEE;
               margin-top:5%;
               margin-left:7%;
               margin-right:7%;
               margin-bottom:5%;
               padding:5%;
               border:1px  solid   #D7D7D7;
               border-radius:5px
              
}
</style>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function checkApplyInfo(){
	if($("#bookname").val()==""){
		alert("书名不可为空!");
		return false;
	}
	else if($("#bookintroduction").val()==""){
		alert("简介不可为空!");
		return false;
	}
	else
		return true;
}
</script>
<body>
<center>
<div class="apply-main-text-wrap">
<h3><strong>发布新书</strong></h3>
<br>
<form action="${pageContext.request.contextPath}/novel/add" method="post" onsubmit="return checkApplyInfo()">
  <table class="table" >
  <tbody>
   <tr>
   		<td>书名</td>
   		<td><input type="text" class="form-control" id="bookname" name="bookname"></td>
   </tr>
   <tr  style="text-align:right">
   <td colspan="2" style="text-align:right">
    <select    class="form-control"   style="background-color:#F7F7F7;width:110px"   name="cid" >
<option value="1"  selected>选择分类</option>
<option value="1"  >玄幻魔法</option>
<option value="2"  >武侠修真</option>
<option value="3"  >科幻穿越</option>
<option value="4"  >历史架空</option>
<option value="6"  >都市言情</option>
</select>
    </td>
    </tr>
      <tr>
   		<td>简介</td>
   		<td><textarea rows="7" cols="20" class="form-control" id="bookintroduction" name="bookintroduction" placeholder="100字以内..."></textarea>
   </tr>
   <tr  >
     <td style="text-align:center" colspan="2"><input type="submit"  class="btn btn-primary" value="提交">    
     <input type="reset" class="btn btn-primary"  value="重置"></td>
   </tr>
  </tbody>
  </table>
</form>
</div>
</center>
</html>