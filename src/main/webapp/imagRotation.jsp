<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String contextPath = request.getContextPath();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片轮换</title>
<script type="text/javascript" language="javascript" src="script/jquery-1.8.3.min.js"></script>
<style type="text/css">
    * {
        padding: 0px;
        margin: 0px;
    }
    a {
        text-decoration: none;
    }
    .slider, .slider-panel img, .slider-extra { 
	  width: 650px; 
	  height: 413px; 
	 }
	 .slider{
	    text-align: center;
	    margin: 30px auto;
	    position: relative;
	 }
    /*  布局 */
	 .slider-panel, .slider-nav, .slider-pre, .slider-next { 
		  position: absolute;  
		  z-index: 8; 
		 }
			 .slider-nav { 
			  margin-left: -51px; 
			  position: absolute; 
			  left: 50%; 
			  bottom: 4px; 
			 }
		.slider-nav li { 
			  background: #3e3e3e; 
			  border-radius: 50%; 
			  color: #fff; 
			  cursor: pointer; 
			  text-align: center; 
			  display: inline-block; 
			  line-height: 18px; 
			  width: 18px; 
			 } 
/* 			 选中变蓝色 */
			 .slider-nav .slider-item-selected { 
			  background: blue; 
			 } 
			 .slider-page a{
			  background: rgba(0, 0, 0, 0.2); 
			  color: #fff; 
			  text-align: center; 
			  display: block; 
			  font-size: 22px; 
			  width: 28px; 
			  line-height: 62px; 
			  margin-top: -31px; 
			  position: absolute; 
			  top: 50%; 
			 } 
			 .slider-next { 
			  left: 100%; 
			  margin-left: -28px; 
			 } 
</style>
<script type="text/javascript">
alert('${name}');
$(document).ready(function() { 
	  var length, 
	   currentIndex = 0, 
	   interval, 
	   hasStarted = false, //是否已经开始轮播 
	   t = 3000; //轮播时间间隔 
	  length = $('.slider-panel').length; 
	  //将除了第一张图片隐藏 
	  $('.slider-panel:not(:first)').hide(); 
	  //将第一个slider-item设为激活状态 
	  $('.slider-item:first').addClass('slider-item-selected'); 
	  //隐藏向前、向后翻按钮 
	  $('.slider-page').hide(); 
	  //鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动 
	  $('.slider-panel, .slider-pre, .slider-next').hover(function() {
	   stop(); 
	   $('.slider-page').show(); 
	  }, function() {
	   $('.slider-page').hide(); 
	   start(); 
	  }); 
	  $('.slider-item').hover(function(e) { 
	   stop(); 
	   var preIndex = $(".slider-item").filter(".slider-item-selected").index(); 
	   currentIndex = $(this).index(); 
	   play(preIndex, currentIndex); 
	  }, function() { 
	   start(); 
	  }); 
	  $('.slider-pre').unbind('click'); 
	  $('.slider-pre').bind('click', function() { 
	   pre(); 
	  }); 
	  $('.slider-next').unbind('click'); 
	  $('.slider-next').bind('click', function() { 
	   next(); 
	  }); 
	  /** 
	   * 向前翻页 
	   */
	  function pre() { 
	   var preIndex = currentIndex; 
	   currentIndex = (--currentIndex + length) % length; 
	   play(preIndex, currentIndex); 
	  } 
	  /** 
	   * 向后翻页 
	   */
	  function next() { 
	   var preIndex = currentIndex; 
	   currentIndex = ++currentIndex % length; 
	   play(preIndex, currentIndex); 
	  } 
	  /** 
	   * 从preIndex页翻到currentIndex页 
	   * preIndex 整数，翻页的起始页 
	   * currentIndex 整数，翻到的那页 
	   */
	  function play(preIndex, currentIndex) { 
	   $('.slider-panel').eq(preIndex).fadeOut(500) 
	    .parent().children().eq(currentIndex).fadeIn(1000); 
	   $('.slider-item').removeClass('slider-item-selected'); 
	   $('.slider-item').eq(currentIndex).addClass('slider-item-selected'); 
	  } 
	  /** 
	   * 开始轮播 
	   */
	  function start() { 
	   if(!hasStarted) { 
	    hasStarted = true; 
	    interval = setInterval(next, t); 
	   } 
	  } 
	  /** 
	   * 停止轮播 
	   */
	  function stop() {
	   clearInterval(interval); 
	   hasStarted = false; 
	  } 
	  //开始轮播 
	  start(); 
	 });
</script>
</head>
<body> 
 <div class="slider"> 
  <ul class="slider-main"> 
   <li class="slider-panel"> 
    <a href="http://www.jb51.net" target="_blank"><img alt="关注脚本之家" title="关注脚本之家" src="images/1.jpg"></a> 
   </li> 
   <li class="slider-panel"> 
    <a href="http://www.jb51.net" target="_blank"><img alt="关注脚本之家" title="关注脚本之家" src="images/2.jpg"></a> 
   </li> 
   <li class="slider-panel"> 
    <a href="http://www.jb51.net" target="_blank"><img alt="关注脚本之家" title="关注脚本之家" src="images/3.jpg"></a> 
   </li> 
   <li class="slider-panel"> 
    <a href="http://www.jb51.net" target="_blank"><img alt="关注脚本之家" title="关注脚本之家" src="images/4.jpg"></a> 
   </li> 
  </ul> 
  <div class="slider-extra"> 
   <ul class="slider-nav"> 
    <li class="slider-item">1</li> 
    <li class="slider-item">2</li> 
    <li class="slider-item">3</li> 
    <li class="slider-item">4</li> 
   </ul> 
   <div class="slider-page"> 
    <a class="slider-pre" href="javascript:;;"> < </a> 
    <a class="slider-next" href="javascript:;;"> > </a> 
   </div> 
  </div> 
 </div> 
</body>
</html>