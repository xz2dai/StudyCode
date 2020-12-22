<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="content/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="content/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="content/assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="content/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="content/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="content/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="content/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img src="content/assets/img/logo-dark.png" alt="Klorofil Logo"></div>
								<p class="lead">登陆到账户</p>
							</div>
							<form class="form-auth-small" action="LoginServlet">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">账户</label>
									<input type="email" class="form-control" id="signin-email" value="" placeholder="Email">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">密码</label>
									<input type="password" class="form-control" id="signin-password" value="" placeholder="Password">
								</div>
								<div class="form-group clearfix">
									<label class="fancy-checkbox element-left">
										<input type="checkbox">
										<span>记住我</span>
									</label>
								</div>
								<button type="submit" class="btn btn-primary btn-lg btn-block">登陆</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a href="#">忘记密码?</a></span>
								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="content text">
							<h1 class="heading">干净、实惠的食物</h1>
							<p>by 删库跑路</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
