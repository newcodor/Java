<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="common/static/js/trumbowyg/design/css/trumbowyg.css">
<title>发表章节</title>
</head>
<script src="common/static/js/jquery-3.2.1.min.js"></script>  
<script src="common/static/js/trumbowyg/trumbowyg.js"></script>  
<script src="common/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(
		   function(){
$('#contents').trumbowyg();
		   });
</script>
<style type="text/css">
   .bg{
      background-color: #000000
      font-family:"微软雅黑", sans-serif;
     }
</style>
<body class="bg">
<br>
<left><button style="margin-left:5px" onclick="window.history.back(-2)"  class="btn btn-primary">返回</button></left>
<div style="padding: 100px 100px 10px;">
<form id="form1" class="bs-example bs-example-form" action="chapterServlet"  method="POST"  onsubmit="return checkData()">
<div class="input-group">
<span class="input-group-addon">章节名: </span>
<input class="form-control" type="text"  id="title" name="title" value="${chapterVo.title}">
</div>
<br>
<input type="hidden"  name="bid" value="${chapterVo.bid}">
<input type="hidden"  name="chaid" value="${chapterVo.chaid}">
<input type="hidden"  name="fromPage" value="writer/editChapter">
<input type="hidden"  name="action" value="update">
<center>
<textarea class="form-control"  rows=50 cols=150  id="contents" name='contents'>${chapterVo.contents}</textarea></center><br>
<button class='btn btn-lg btn-primary btn-block' id="submit" data-loading-text='修改中.....'   type='submit' onsubmit="return check()">提交修改</button>

</form>
</div>
<script type="text/javascript">
function checkData(){
	  if($("#title").val()==""){
		  alert("章节名不可为空");
		  return false;
	  }else{
		  return true;
	  }
}
$(document).ready(
		   function(){

});

</script>
</body>
</html>