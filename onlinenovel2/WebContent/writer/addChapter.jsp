<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="../common/static/js/trumbowyg/design/css/trumbowyg.css">
<title>发表章节</title>
</head>
<script src="../common/static/js/jquery-3.2.1.min.js"></script>  
<script src="../common/static/js/trumbowyg/trumbowyg.js"></script>  
<script src="../common/static/js/bootstrap.min.js"></script>
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
<left><button style="margin-left:5px" onclick="window.history.back()"  class="btn btn-primary">返回</button></left>
<div style="padding: 100px 100px 10px;">
<form id="form1" class="bs-example bs-example-form" action="../chapterServlet"  method="POST"  onsubmit="return checkData()">
<div class="input-group">
<span class="input-group-addon">章节名: </span>
<input class="form-control" type="text"  id="title" name="title" >
</div>
<br>
<input type="hidden"  name="bid" value="${param.bid}">
<input type="hidden"  name="action" value="add">
<center>
<textarea class="form-control"  rows=50 cols=150  id="contents" name='contents'></textarea></center><br>
<button class='btn btn-lg btn-primary btn-block' id="submit" data-loading-text='发表中.....'   type='submit' onsubmit="return check()">发表</button>

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

			  
			  $("#addVote").click(function(){
				  
				  $.post("voteServlet",{
					  bid:$("#bid").text()
				  },
				  function(data,Status){
			            if(data=="success"){
			            	alert("投票成功!");
			            	var vote=$("#vote").text();
			            	vote=parseInt(vote)+1;
			            	$("#vote").text(vote);
			            	}else if(data=="exist"){
			            	alert("您已对此书投票!");
			            	}else if(data=="fail"){
			            	  alert("投票失败!");
			            	}else if(data=="nologin"){
				              alert("您尚未登录,请登录后投票!");
			            	}
				  });
		  
		});		   
});

</script>
</body>
</html>