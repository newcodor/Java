<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/common/static/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style type="text/css">
   .bg{
      background-color: #2c343f;
      font-family:"微软雅黑";
     }
   .bg  a{
    color:#1E90FF;
    }

</style>
<body  class="bg text-center" >
<ul  class="nav" >
<li >
	<a href="${pageContext.request.contextPath}/index.jsp" title="首页" target="_blank">首页</a>
 </li>
 <li >
	<a href="updateAdmin.jsp" title="修改密码" target="mainFrame">修改密码</a>
 </li>

<li>
         <div class="treeshow"  >
             <span  style="color:#1E90FF">小说管理</span>
             <table style="display:none;margin-left:45%;">
                 <tr><td><a href="${pageContext.request.contextPath}/novel/manageall" title="管理小说" target="mainFrame">管理小说</a><td></tr>
                 <tr><td><a href="${pageContext.request.contextPath}/novel/apply/queryall" title="审核作者申请" target="mainFrame">审核作者申请</a><td></tr>
             </table>
         </div>
</li>

<li>
         <div class="treeshow" >
             <span  style="color:#1E90FF">用户管理</span>
             <table style="display:none;margin-left:45%;">
                 <tr ><td><a href="${pageContext.request.contextPath}/user/queryall" title="管理用户" target="mainFrame">管理用户</a><td></tr>
                 <tr ><td><a href="addMember.jsp" title="添加用户" target="mainFrame">添加用户</a><td></tr>
             </table>
         </div>
</li>
<li >
    <a href="${pageContext.request.contextPath}/category/list?&fromPage=admin/category" title="管理分类" target="mainFrame">分类管理</a>
</li>
<li>
<a href="main.jsp" title="系统配置信息" target="mainFrame">系统配置信息</a>
</li>

<li>
<a href="${pageContext.request.contextPath}/logout"  title="重新登录" target="_parent" onclick="return logout()">重新登录</a>
</li>
</ul>
<script src="${pageContext.request.contextPath}/common/static/js/jquery-3.2.1.min.js"></script>
 <script src="${pageContext.request.contextPath}/common/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
        $(".treeshow").on("click",function(){
            if($(this).find("table").css("display")=="none") {
                $(this).find("table").css("display","block");
            } else {
                $(this).find("table").css("display","none");
            }
        });

       // $(".test2").on("click",function(){
       //     $(this).find("table").toggleClass("showClass");
      //  });
    });
    function  logout(){
       if(confirm("确定要重新登录吗?")){
        return true;
       }
       else
        return false;


    }
</script>
</body>
</html>