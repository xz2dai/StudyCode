<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" />
<title>新增用户</title>
<style type="text/css">
	.inputText{width: 430px !important;}
	.rowDiv{margin-bottom: 15px;}
	.form-lavel{width: 80px;text-align: right;}
</style>
</head>
<body>
	<div class="container" style="width: 100%;padding: 25px 15px;">
		<div class="row clearfix">
			<div class="col-md-12 column" style="padding: 20px;padding-top: 0px;">
				<form action="#" method="post" id="userForm" enctype="multipart/form-data" role="form" class="form-inline" style="margin-bottom: 10px;">
					<div id="userInfoDiv" class="form" style="padding:5px;">
						<div class="row rowDiv">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="account">账号：</label>
										<input type="hidden" name="id" value="${user.id }"/>
									<input type="text" class="form-control inputText" value="${userInfo.account }" disabled="disabled">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="realName">姓名：</label>
									<input type="text" class="form-control inputText" id="realName" name="realName" value="${userInfo.realName }">
									<span style="color: red;">*</span>
								</div>
							</div>
						</div>
						<div class="row rowDiv">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="account">性别：</label>
									<input type="radio" name="gender" value="0" ${userInfo.gender==0?"checked":""}/>男&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="gender" value="1" ${userInfo.gender==1?"checked":""}/>女&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="gender" value="2" ${userInfo.gender==2?"checked":""}/>未知
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="realName">年龄：</label>
									<input type="text" class="form-control inputText" id="age" name="age" value="${userInfo.age }">
									<span style="color: red;">*</span>
								</div>
							</div>
						</div>
						<div class="row rowDiv">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="mobile">手机号：</label>
									<input type="text" class="form-control inputText" id="mobile" name="mobile" value="${userInfo.mobile }">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="email">邮箱：</label>
									<input type="text" class="form-control inputText" id="email" name="email" value="${userInfo.email }">
								</div>
							</div>
						</div>
						<div class="row rowDiv">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="birthday">生日：</label>
									<input type="text" class="form-control inputText" id="birthday" name="birthday" value="${userInfo.birthdayStr }" placeholder="生日,如：01-12">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="identity">身份证：</label>
									<input type="text" class="form-control inputText" id="identity" name="identity" value="${userInfo.identity }">
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
										<img alt="" src="${headImg }" width="100" height="100">
								</div>
							</div>
						</div>
						<div class="row rowDiv">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="entryTime">入职日期：</label>
									<input type="text" class="form-control inputText" id="entryTime" name="entryTime" value="${userInfo.entryTimeStr }" placeholder="入职日期，如：2017-01-01">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label class="form-lavel" for="status">员工状态：</label>
									<select class="form-control" id="status" name="status">
										<option value="0" ${userInfo.status==0?"selected":""}>试用期</option>
										<option value="1" ${userInfo.status==1?"selected":""}>转正</option>
										<option value="2" ${userInfo.status==2?"selected":""}>离职</option>
									</select>
								</div>
							</div>
						</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<input type="button" class="btn btn-primary btn" value="提交" onclick="javascript:location.href='userList.html'"/>
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
<script type="text/javascript">
	$(function(){
		var method = '${method}';
		if (method != 'update') {// 展示用户详情时，文本框禁止编辑
			var texts = $("#userInfoDiv input[type='text']");
			var selects = $("#userInfoDiv select");
			$.each(texts, function(){
				$(this).attr("readonly", true);
			});
			$.each(selects, function(){
				$(this).attr("readonly", true);
			});
		}
		
	});
</script>
</html>