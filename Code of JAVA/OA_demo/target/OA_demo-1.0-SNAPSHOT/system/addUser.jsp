<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" />
	<style type="text/css">
		.inputText{width: 430px !important;}
		.rowDiv{margin-bottom: 15px;}
		.form-lavel{width: 80px;text-align: right;}
	</style>
	<title>用户信息</title>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
	<div class="row clearfix">
		<div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
			<form action="${pageContext.request.contextPath}/AddUserServlet" method="post" id="userForm" role="form" class="form-inline" style="margin-bottom: 10px;">
				<div class="form" style="padding:5px;">
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="account">账号：</label>
								<input type="text" class="form-control inputText" id="account" name="account" placeholder="账号">
								<span style="color: red;">*</span>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="realName">姓名：</label>
								<input type="text" class="form-control inputText" id="realName" name="realName" placeholder="姓名">
								<span style="color: red;">*</span>
							</div>
						</div>
					</div>
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="account">性别：</label>
								<input type="radio" name="gender" value="0">男&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" value="1">女&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" value="2" checked="checked">未知
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="realName">年龄：</label>
								<input type="text" class="form-control inputText" id="age" name="age" placeholder="年龄">
								<span style="color: red;">*</span>
							</div>
						</div>
					</div>
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="mobile">手机号：</label>
								<input type="text" class="form-control inputText" id="mobile" name="mobile" placeholder="手机号">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="email">邮箱：</label>
								<input type="text" class="form-control inputText" id="email" name="email" placeholder="邮箱">
							</div>
						</div>
					</div>
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="birthday">生日：</label>
								<input type="text" class="form-control inputText" id="birthday" name="birthday" placeholder="生日,如：01-12">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="identity">身份证：</label>
								<input type="text" class="form-control inputText" id="identity" name="identity" placeholder="身份证">
							</div>
						</div>
					</div>
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="birthday">所属职位：</label>
								<select class="form-control" id="roleId" name="roleId">
									<option value="0">总经理</option>
									<option value="1">部门经理</option>
									<option value="2">普通职员</option>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel">头像：</label>
								<input type="file" name="file" style="display: inline-block;">
							</div>
						</div>
					</div>
					<div class="row rowDiv">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="entryTime">入职日期：</label>
								<input type="text" class="form-control inputText" id="entryTime" name="entryTimeStr" placeholder="入职日期，如：2017-01-01">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="form-lavel" for="status">员工状态：</label>
								<select class="form-control" id="status" name="status">
									<option value="0">试用期</option>
									<option value="1">转正</option>
									<option value="2">离职</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<input type="submit" class="btn btn-primary btn-sm" value="提交"/>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user-info.js"></script>
</html>