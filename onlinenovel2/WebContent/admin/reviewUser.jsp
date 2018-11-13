<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
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
<script src="common/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(
		   function(){

$("#pass").click(function(){
	
	$("#reviewStatus").val("pass");
	$("#form1").submit();     
	  });
$("#nopass").click(function(){
	
	$("#reviewStatus").val("nopass");
	$("#form1").submit();    
	  });
});
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
<c:if test="${origin!=\"forward\"}">
  <jsp:forward page="${pageContext.request.contextPath}/novel/apply/query?rid=${param.rid}"></jsp:forward>
</c:if>
<center>
<div class="apply-main-text-wrap">
<h3><strong>审核申请</strong></h3>
<form id="form1" action="${pageContext.request.contextPath}/novel/apply/review" method="post" onsubmit="return checkApplyInfo()">
  <table class="table" >
  <tbody>
   <tr>
   		<td>书名</td>
   		<td><input type="text" class="form-control" id="bookname" readonly name="bookname" value='<c:if test="${null!=requestScope.reviewVo }">${requestScope.reviewVo.bookname}</c:if>'></td>
   </tr>
   <tr>
    <td>
    <input   type="hidden" class="form-control"   readonly name="cid" value='<c:if test="${null!=requestScope.reviewVo}">${requestScope.reviewVo.cid}</c:if>' >
    </td>
    </tr>
    <tr>
    <td>分类</td>
    <td><input   type="text" class="form-control"   readonly name="categoryname" value='<c:if test="${null!=requestScope.reviewVo}">${requestScope.reviewVo.categoryname}</c:if>' >
    </td>
    </tr>
      <tr>
   		<td>简介</td>
   		<td><textarea rows="7" cols="20" class="form-control"  readonly id="bookintroduction" name="bookintroduction" placeholder="100字以内..."><c:if test="${null!=requestScope.reviewVo }">${requestScope.reviewVo.bookintroduction}</c:if></textarea>
   </tr>
         <tr>
   		<td>样稿(500以内)</td>
   		<td><textarea rows="10" cols="20" class="form-control" readonly id="bookSampleDraft" name="bookSampleDraft"  placeholder="500字以内..."><c:if test="${null!=requestScope.reviewVo }">${requestScope.reviewVo.bookSampleDraft}</c:if></textarea>
   </tr>
   <tr  >
     <td style="text-align:center" colspan="2"><input type="button"  id="pass" class="btn btn-primary" value="审核通过">    
     <input type="button" class="btn btn-primary" id="nopass" value="审核不通过"></td>
   </tr>
  </tbody>
  </table>
  <input type="hidden"  name="rid"  id="rid" value="${requestScope.reviewVo.rid}">
  <input type="hidden"  name="userid"  id="userid" value="${requestScope.reviewVo.userid}">
  <input type="hidden"  name="reviewStatus"  id="reviewStatus">
</form>
</div>
</center>
</body>
</html>