<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
	<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
	<title>第一个JQUREY</title>
	<script type="text/javascript" src="script/jquery-1.8.3.min.js"></script>
    <style type="text/css">

     </style>
</head>
<script type="text/javascript">
    function testjquery(){
	    var user_name=$("#textValue").attr("value");
	    alert(user_name);
// 	    $("#tetextValuest").hide();
    }
    function logout(){
 	    parent.window.location.href='imagRotation.jsp';
    }
    function test(){
    	$.ajax({ 
    		//要用post方式 
    		type: "GET", 
    		//方法所在页面和方法名 
    		url: "getInfo", 
    		contentType: "application/json; charset=utf-8", 
    		dataType: "json",
    		data:{scope:"王奇"},
    		success: function(data) { 
    			alert(data.name);
    		}, 
    		error: function(err) { 
    		alert(err); 
    		}
    	});
    }
    function getInfo(){
    	var xmlhttp;
    	if (window.XMLHttpRequest)
    	  {// code for IE7+, Firefox, Chrome, Opera, Safari
    	  xmlhttp=new XMLHttpRequest();
    	  }
    	else
    	  {// code for IE6, IE5
    	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    	  }
    	xmlhttp.open("GET","getInfo?scope="+"王奇",true);
    	xmlhttp.send();
    	xmlhttp.onreadystatechange=function(){
    	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
    	    document.getElementById("txtHint").innerHTML=xmlhttp.response;
    	    }
    	  }
    }
  </script>
<body>
    <img src="images/1.jpg">
    <input id="textValue" value="jquery">
    <a href="test">调用后台跳转页面</a>
    <input type="button" value="click me!" onclick="testjquery();">
    <input id="b01" type="button" value="后台方法" onclick="getInfo()">
    <input type="button" value="图片轮换" onclick="logout();"><br/>
    <p>建议：<span id="txtHint"></span></p> 
     <div>
	    <c:forEach var="item" items="${modes}">
	       <p><span>${item.obj}</span></p>
	    </c:forEach>
     </div>
</body>

</html>
