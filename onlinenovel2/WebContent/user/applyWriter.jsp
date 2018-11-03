<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../common/static/css/bootstrap.min.css" rel="stylesheet">
<title>作家申请</title>
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
<script src="../common/static/js/jquery-3.2.1.min.js"></script>
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
	else if($("#bookSampleDraft").val()==""){
		alert("样稿不可为空!");
		return false;
	}
	else
		return true;
}
</script>
<body>
<center>
<div class="apply-main-text-wrap">
<p>
申请成为作家并发布作品需要提供发布的作品信息及供审核所用的样稿(500字以内)
</p>
<form action="../novelApplyServlet" method="post" onsubmit="return checkApplyInfo()">
  <table class="table" >
  <tbody>
   <tr>
   		<td>书名</td>
   		<td><input type="text" class="form-control" id="bookname" name="bookname"></td>
   </tr>
   <tr>
   <td colspan="2">
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
         <tr>
   		<td>样稿(500以内)</td>
   		<td><textarea rows="10" cols="20" class="form-control" id="bookSampleDraft" name="bookSampleDraft"  placeholder="500字以内..."></textarea>
   </tr>
   <tr  >
     <td style="text-align:center" colspan="2"><input type="submit"  class="btn btn-primary" value="提交">    
     <input type="reset" class="btn btn-primary"  value="重置"></td>
   </tr>
  </tbody>
  </table>
  <input type="hidden"  name="action"  value="apply">
</form>
</div>
</center>
</body>
</html>