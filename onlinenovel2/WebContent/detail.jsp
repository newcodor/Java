<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/common/static/css/bootstrap-theme.min.css">
<title>求小说</title>
<style>
 body{
 font-family: Microsoft Yahei;
 }
 table{
  width:800px;
  height:200px;
 border-collapse: separate;
 border-spacing:0px;
 outline:1px solid #1E90FF;
 }
 #bookinfo{
    text-align:left;
 width:800px;
 }
 #emptyInfo table {
  outline:1px solid #1E90FF;
 height:5px;
 text-align:left;
 width:800px;
 }
 table th{
 background-color: #428bca;
 padding: 3px;
 
 }
 table td{
  border: solid thin #AEEEEE;
  padding:3px 5px 3px;
  text-align: left;
 }
 .main_wrap{
   text-align:center;
   width: 800px;
 }
 .plun{
    text-align:left;
    font-size:20px;
    color:#000;
 }
</style>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
   function setBid(){
	   var bid1=document.getElementById("bid").value;
	   document.getElementById("bid").value;
   }
 
   window.alert = function (name) {
	   const iframe = document.createElement('IFRAME');
	   iframe.style.display = 'none';
	   iframe.setAttribute('src', 'data:text/plain,');
	   document.documentElement.appendChild(iframe);
	   window.frames[0].window.alert(name);
	   iframe.parentNode.removeChild(iframe);
	 };

    
   $(document).ready(
		   function(){

			  $("#addBookSelf").click(function(){
				  
			  $.post("${pageContext.request.contextPath}/user/bookself/add",{
				  bid:$("#bid").text()
			  },
			  function(data,Status){
		            if(data=="success"){
		            	alert("已成功加入书架!");
		            	//confirm("已成功加入书架!");
		            	}else if(data=="exist"){
		            	alert("书架中已存在该书籍!");
		            	}else if(data=="fail"){
		            	alert("加入书架失败!");
		            	}else if(data=="nologin"){
		            	alert("您尚未登录,请登录后收藏书籍!");
		            	}
		            
		            
			  });
	  
	});
			  
			  $("#addVote").click(function(){
				  
				  $.post("${pageContext.request.contextPath}/vote/add",{
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
</head>
<body id="page-top">

<%
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<c:if test="${requestScope.origin!='forward'}">
  <jsp:forward page="${pageContext.request.contextPath}/novel/query?bid=${param.bid}&fromPage=detail"></jsp:forward>
</c:if>
  <c:choose>
  	<c:when test="${null!=novelVo}">
 <div id="content" >
 <center>
    	<div class="post" id="bookinfo">
    		<h1 class="title">${novelVo.bookname}</h1>
    		<p class="byline">作者:${novelVo.username}</p>
    		<span id="bid" style="display:none">${novelVo.bid}</span>
    		<p class="byline">发表时间:${createTime}</p>
    		<p class="meta">状态：${novelVo.status}</p>
    		<div class="entry">
    			<p>${novelVo.bookintroduction}</p>
    		</div>
    		<p class="meta">分类：
    		<a href="${pageContext.request.contextPath}/novel/category/query?cid=${novelVo.cid}&categoryname=${novelVo.categoryname}&fromPage=category" target="mainFrame">${novelVo.categoryname}</a>
    		</p>
    		<p class="meta">投票总数：<span id="vote">${novelVo.voteCount}</span></p>
    		<button id="addBookSelf"  class="btn btn-info" >加入书架</button>
    		<button id="addVote"  class="btn btn-info" >投票推荐此书</button>
    		<br/>
    		<br/>
 <table  class="table table-hover  table-condensed">
 <thead>
 	<tr>
 	  <th width="100px" colspan="2" style="text-align: center">章节列表</th>
 	</tr>
 </thead>
 <tbody>
  <c:choose>
  <c:when test="${requestScope.page.list.size()>0}">
  <c:forEach items="${requestScope.page.list}"  var="chapter" varStatus="status">
  <tr>
  	<td style="text-align: left"><a href="${pageContext.request.contextPath}/chapter/read/${chapter.bid}/${chapter.chaid}.html" target="_blank">${chapter.title}</a></td>
  	<td><fmt:formatDate value="${chapter.posttime }"  pattern="yyyy-MM-dd HH:mm"/></td>
  </tr>
  </c:forEach>
  </c:when>
  <c:otherwise>
  <tr>
  	<td colspan="5"  style="text-align: center"><h4>暂无章节信息</h4></td>
  </tr>
  </c:otherwise>
  </c:choose>
 </tbody>
 <tfoot>
 	   <c:if test="${page.list.size()>0 }">
    <tr style="border:1px,0px,1px">
    	<td colspan="5">
    	<center>
    	<c:choose>
    	<c:when test="${page.currentPage==1}">
    	 首页
    	</c:when>
    	<c:otherwise>
    	<a href="${pageContext.request.contextPath}/novel/query?currentPage=1&bid=${requestScope.bid}&fromPage=detail">首页</a>
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.hasPrePage}">
    	<a href="${pageContext.request.contextPath}/novel/query?currentPage=${page.currentPage-1}&bid=${requestScope.bid}&fromPage=detail">上一页</a>
    	</c:when>
    	<c:otherwise>
    	上一页
    	</c:otherwise>
    	</c:choose>
    	<c:if test="${page.currentPage!=null}">
    	 第 ${page.currentPage} 页
    	</c:if>
    	<c:choose>
    	<c:when test="${page.hasNextPage}">
    	<a href="${pageContext.request.contextPath}/novel/query?currentPage=${page.currentPage+1}&bid=${requestScope.bid}&fromPage=detail">下一页</a>
    	</c:when>
    	<c:otherwise>
    	下一页
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${page.currentPage==page.totalPage}">
    	末页
    	</c:when>
    	<c:otherwise>
    	<a href="${pageContext.request.contextPath}/novel/query?currentPage=${page.totalPage}&bid=${requestScope.bid}&fromPage=detail">末页</a>
    	</c:otherwise>
    	</c:choose>
    	</center>
    	</td>
    </tr>
  </c:if>
 </tfoot>
</table>		
<hr>

  <p class="plun">评论区</p>
 </div>
 </center>
</div>
 

<c:choose>
 <c:when test="${rList.size()>0}">
 <center>
 <table id="reply" >
  <tbody>
    <c:forEach items="${requestScope.rList }"  var="ri" varStatus="status">
    <tr>
    <td width="15%"  rowspan="2"><p style="text-align: center" >
    ${ri.username}
    <br>
    ${ri.sex}
    <br>
    ${ri.city}
    </p>
    </td>
    <td  height="10%">评论时间: <fmt:formatDate value="${ri.replytime}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td align="right">#${status.index+1}楼</td>
    </tr>
    <tr>
    <td colspan="2"  height="100px">${ri.replycontents}</td>
    </tr>
<!--     <tr height="10%">
    	<td style="text-align: right" colspan="2"><a href="#reply">回复</a></td>
    </tr> -->
    </c:forEach>
  </tbody>
  </table>
  </center>
 </c:when>
 <c:otherwise>
     <center><h3>暂无评论</h3></center>
 </c:otherwise>
</c:choose>
<br>
<jsp:include page="reply.jsp"></jsp:include>
  	</c:when>
    <c:otherwise>
     <td colspan="3" align="left">无此作品!,<a target="_top" href="index.jsp">返回主页</a></td>
    </c:otherwise>
  </c:choose>
  <hr>
  <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>