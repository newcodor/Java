<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="common/static/css/bootstrap.min.css">
<link rel="stylesheet" href="common/static/css/style.css">
<title>${chapterVo.title}</title>
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
.view-content {
    font-family:"微软雅黑";
}
</style>
<script src="common/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
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
			   //添加书签
			  $("#addBookMark").click(function(){
				  
			  $.post("bookMarkServlet",{
				  action:"add",
				  bid:$("#bid").text(),
				  chaid:$("#chaid").text()
			  },
			  function(data,Status){
		            	//alert("111!");
		            if(data=="success"){
		            	alert("您已成功添加书签!");
		            	}else if(data=="exist"){
		            	alert("您已添加该书签!");
		            	}else if(data=="fail"){
		            	alert("添加书签失败!");
		            	}else if(data=="nologin"){
		            	alert("您尚未登录,请登录后添加书签!");
		            	}else {
		            	alert("网站出错!");
		            		
		            	}
		            
		            
			  });
	  
	});
			  //
	   
});

</script>
<body id="page-top" style="background-color:#FFFFFF;">

<c:if test="${fromPage!=\"chapterServlet\"}">
  <script>alert("chapterServlet?action=query&bid=${requestScope.bid}&chaid=${requestScope.chaid}");</script>
  <jsp:forward page="chapterServlet?bid=${param.bid}&chaid=${param.chaid}&action=query"></jsp:forward>
</c:if>
<div class="main-text-wrap">
<center>
<c:choose>
<c:when test="${null!=requestScope.chapterVo }">
  <h5  class="text-left"><a href="index.jsp" title="首页">求小说网</a> 
  / <a href="novelQueryPageServlet?cid=${chapterVo.cid}&categoryname=${chapterVo.categoryname}&action=category&fromPage=category" target="mainFrame">${chapterVo.categoryname}</a>
  / <a href="detail.jsp?bid=${chapterVo.bid}&action=query&fromPage=detail"  target="mainFrame" >${chapterVo.bookname}</a></h5>
  <h5  class="text-right"><a id="addBookMark" href="javascript:void(0)" title="添加书签">添加书签</a>
  / <a  href="bookmark.jsp" target="mainFrame" title="我的书签">我的书签</a> 
  / <a  href="bookself.jsp" target="mainFrame"  title="我的书架">我的书架</a>
  </h5>
<h4  class="view-title"><strong>${chapterVo.title}</strong></h4>
<div class="view-meta">作者:${chapterVo.username}&nbsp;&nbsp;&nbsp;<time>${chapterVo.posttime}</time></div>
<div  class="view-content" style="text-align:left">
${chapterVo.contents}
</div>
<br>
</c:when>
<c:otherwise>
<p>暂无作品信息!</p>
</c:otherwise>
</c:choose>
</center>
</div>
<center>
<span id="bid" style="display:none">${chapterVo.bid}</span>
<span id="chaid" style="display:none">${chapterVo.chaid}</span>
<a     href="chapter.jsp?bid=${chapterVo.bid}&chaid=${frontAndNextchapterIdInfo.get('frontChapterId')}&fromPage=chapter" title="上一章" class="btn btn-primary">上一章</a>
<span>
</span>
<a href='detail.jsp?bid=${chapterVo.bid}&action=query&fromPage=detail'  target="mainFrame" class="btn btn-primary">目录</a>
<span>        
</span><a href="chapter.jsp?bid=${chapterVo.bid}&chaid=${frontAndNextchapterIdInfo.get('nextChapterId')}&fromPage=chapter"   title="下一章"  class="btn btn-primary">下一章</a>
       </center>
       <br/>
  <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>