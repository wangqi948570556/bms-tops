<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
	<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
	<title>第一个JQUREY</title>
	<script type="text/javascript" language="javascript" src="jquery-1.8.3.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=contextPath%>/script/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/Jscript/jquery-1.12.2.min.js"></script>
    <style type="text/css">

</style>
</head>
<body>
<div class="indexCont">
	<div class="headerCont">
	<span class="header"><em class="m20">您好，欢迎来到木兰县公安局综合考评工作信息网！您还未登陆，请<b><a href="javascript:;" >【登录】</a></b></em></span>
	<img src="images/1.jpg" width="1000" height="180"/>
	<div class="menu_nav clearfix">
        <ul class="nav_content">
            <li style="margin-left: -20px;"><a href="index.jsp">网站首页</a></li>
            <li><a href="gzdt.jsp">工作动态</a></li>
        </ul>
	    <div class="menu_nav_right"></div>
        
        <div class="search">
        	<input class="s_txt" type="text"/>
            <input class="s_sc" type="button" value=""/>
        </div>
	</div>   
</div>
<div>
    <!--thr_3-end-->
    <div class="footer">
        <div class="f_line_top"></div>
        <span class="f_txt">
        	<p>版权所有 木兰县公安局 Copyright© 2014 All Rights Reserved 制作维护：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
        	<p>地址:黑龙江省哈尔滨市木兰县通江路45号　　电话:0451-57082347</p>
        </span>
    </div>
</div>
</body>

</html>
