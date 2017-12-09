<%@page import="com.timor.factory.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.timor.vo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>个人信息</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Toddler Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/slider.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/flexslider.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">
body {
	background:url(images/5.jpg) no-repeat center;
	background-size: cover;
	border:0;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
    User pre_userinfo = (User)request.getAttribute("pre_userinfo");
    if(pre_userinfo != null){
%>

     <!-- main -->
	<div class="container">
		<div class="main-info">
			<div class="main-row"><!-- main-row-one -->
				<div class="profile-grid logo wthree">
					<%String path="images/"+pre_userinfo.getImg_addr();
					%>
					<img src="headerimg/<%=pre_userinfo.getImg_addr() %>" width="125px" height="125px"/>
					<h2 style="color: #eac128;"><%=pre_userinfo.getNickname() %></h2>
				</div>
				<h3 class="title">基本信息</h3>
                <div class="left-w3ls">
					<ul class="address">
						<li>
							<ul >
								<li>学号：<%=pre_userinfo.getUno() %></li>
							</ul>
						</li>
						<li>
							<ul >
								<li>姓名：<%=pre_userinfo.getUname() %></li>
							</ul>
						</li>
						<li>
							<ul >
								<li>性别：<%=pre_userinfo.getSex() %></li>
							</ul>
						</li>
						<li>
							<ul >
								<li>电话：<%=pre_userinfo.getPhone() %></li>
							</ul>
						</li>
						<li>
							<ul >
								<li>邮箱：<%=pre_userinfo.getEmail() %></li>
							</ul>
						</li>
						<li>
							<ul >
								<li>注册日期：<%=pre_userinfo.getRegister_date() %></li>
							</ul>
						</li>
					</ul>
                </div>
                
				<!--bar-js
				<script src="js/bars.js"></script>
				<div class="clearfix"> </div>
				<input id="send" type="button" value="修改信息" onclick="window.location='person_info_modify.jsp'">-->
				<div class="clearfix"> </div>
			</div>	
		</div>	
	</div>	


<%
    }
%>

<!-- here starts scrolling icon -->
		<script type="text/javascript">
			$(document).ready(function() {
				/*
					var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
					};
				*/
										
				$().UItoTop({ easingType: 'easeOutQuart' });
									
				});
		</script>
		
		<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
		<!-- /ends-smoth-scrolling -->
	<!-- //here ends scrolling icon -->


 </body>
</html>
