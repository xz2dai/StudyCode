<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<link href="${pageContext.request.contextPath}/content/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/content/assets/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/content/assets/img/2.jpg)">
<div class="signupform">
	<div class="container">
		
		<div class="agile_info">
			<div class="w3l_form">
				<div class="left_grid_info">
					<h3>对过眼神，你是爱美食的人 !</h3>
					<h4>我劝天公重抖擞，饭饭烤鱼配啤酒。</h4>
					<p> 开心的时候，吃好吃的庆祝一下，难过的时候，吃好吃的安慰一下，无聊的时候，吃好吃的消遣一下，愤怒的时候，吃好吃的发泄一下。</p>
					<ul class="social_section_1info">
						<li><a href="#" class="w3_facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" class="w3_twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" class="w3_instagram"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#" class="w3_google"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#" class="w3_pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" class="w3_vimeo"><i class="fa fa-vimeo"></i></a></li>
					</ul>
				</div>
			</div>
			
			<div class="w3_info">
				<h2>创建账号</h2>
				<p>快马加鞭，吃货永远在寻找美食的路上一直旅行</p>
						<form  action="${pageContext.request.contextPath}/userRegisterServlet" method="post">
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="text" name="userName"  placeholder="用户名" required=""> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-user" aria-hidden="true"></i></span>
							<input type="password" name="password" placeholder="密码" required="">
						</div>
						<div class="input-group">
							<span><i class="fa fa-envelope" aria-hidden="true"></i></span>
							<input type="email" name=email placeholder="邮箱" required=""> 
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="text" name="phoneNum" placeholder="电话" required="">
						</div>
						<div class="input-group">
							<span><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input type="text" name="age" placeholder="年龄" required="">
						</div>
							<input type="checkbox" value="remember-me" required oninvalid="setCustomValidity('请确认信息')" oninput="setCustomValidity('')"/> <h4>确认信息 </h4>
							<button class="btn btn-danger btn-block" type="submit">注册</button >
					</form>
			</div>
			<div class="clear"></div>
			</div>
			
		</div>
		<div class="footer">

 <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" ></a></p>
 </div>
	</div>
	</body>
</html>