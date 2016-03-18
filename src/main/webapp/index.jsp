<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
	<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
	<title>第一个JQUREY</title>
    <script language="javascript" type="text/javascript" src="script/jquery-1.12.2.min.js"></script>
</head>
<body>
<script type=”text/javascript” >
    $("#btnShow").click( function() { alert('我被点了') });
    $(“#btnShow”).bind(“click”, function(event) { $(“#divMsg”).show(); }); 
    $(“#btnHide”).bind(“click”, function(event) { $(“#divMsg”).hide(); });
    $(“#btnChange”).bind(“click”, function(event) { $(“#divMsg”).html(“Hello World, too!”); });
</script>

<div id=”divMsg”>Hello World!</div>
<button id=”btnShow” type=”button” width="200">显示</button>
<button id=”btnHide” type=”button”>隐藏</button>
<button id=”btnChange” type=”button” >修改</button>
</body>

</html>
