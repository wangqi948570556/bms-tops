<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
	<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
	<title>第一个JQUREY</title>
	<script type="text/javascript" language="javascript" src="script/jquery-1.8.3.min.js"></script>
<!-- 	<script type="text/javascript" language="javascript" src="http://code.jquery.com/jquery-1.12.2.min.js"></script> -->
    <style type="text/css">

     </style>
</head>
<script type="text/javascript">
   function testjquery()
   {
    var user_name=$("#test").attr("value");
    alert(user_name);
    }
  </script>
<body>
    <img src="images/1.jpg">
    <input id="test" value="jquery">
    <input type="button" value="click me!" onclick="testjquery();">
</body>

</html>
