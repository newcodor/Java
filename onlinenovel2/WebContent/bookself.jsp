<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<title>我的书架</title>
</head>
<style>
   .main-text-wrap{
               background-color:#F8F3E9;
               margin-left:10%;
               margin-right:10%;
               margin-bottom:7%;
               padding:5%;
               border-radius:5px
}

</style>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function  checkSelectedData(){
	var cs = document.getElementsByName("selecedNovel");
	if (cs != null) {
		for (var i = 0; i < cs.length; i++) {
			if (cs[i].checked == true) {
				return  true;
			}
		}
	return false;
     }
	return false;
}
function remove2(name) {
	var cs = document.getElementsByName(name);
	var aids = new Array();
	if (cs != null) {
		for (var i = 0; i < cs.length; i++) {
			if (cs[i].checked == true) {
				aids.push(cs[i].value);
			}
		}
		if (aids.length > 0) {
			rl(aids.join(","));
		}
	}
}
function rl(aid) {
	var params = new Object();
	params.id = aid;
	var ajax = new Ajax("bookSelfServlet?action=del", params, rlcb, "post");
	ajax.doRequest();
}


</script>
<body>
<c:if test="${origin!=\"forward\"}">
  <jsp:forward page="${pageContext.request.contextPath}/user/bookself/list"></jsp:forward>
</c:if>
<div>
<form action="bookSelfServlet?action=del" method="post" onsubmit="return checkSelectedData()">
  <div class="main-text-wrap">
  <p>下面是您收藏的小说</p>
  <center>
  <table class="table">
  <thead>
    <tr >
       <th>小说名称</th>
       <th>最新章节</th>
       <th>作者</th>
       <th>更新时间</th>
    </tr>
  </thead>
  <tbody>
  <c:choose>
  <c:when test="${null!=requestScope.bookSelfVos}">
     <c:forEach items="${requestScope.bookSelfVos}"  var="bookSelfVo" >
        <tr>
        	<td><input type="checkbox" name="selecedNovel" value="${bookSelfVo.bid}">&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/novel/query?bid=${bookSelfVo.bid}&fromPage=detail" target="_blank">${bookSelfVo.bookname}</a></td>
        	<td><a href="${pageContext.request.contextPath}/chapter/read/${bookSelfVo.bid}/${bookSelfVo.chaid}.html" target="_blank">${bookSelfVo.title}</a></td>
        	<td>${bookSelfVo.username}</td>
        	<td>${bookSelfVo.posttime}</td>
        </tr>
     </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="4">暂无收藏的书目!</td>
  </tr>
  </c:otherwise>
  </c:choose>
  </tbody>
  </table>
  </center>
  </div>
  <center><button type="submit" class="btn btn-danger" >移除</button></center>
  </form>
  </div>
    <hr>
  <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>