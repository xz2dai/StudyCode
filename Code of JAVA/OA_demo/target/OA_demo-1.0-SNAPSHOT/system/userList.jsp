<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%-- 引入外部JSTL的标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" />
    <title>用户列表</title>
    <script type="text/javascript">
        // 条件查询
        function findUser(){
            var realName = $("#realName").val();
            var age = $("#age").val();
            var nz_number = /^\+?[1-9][0-9]*$/;
            if (age != '' && !nz_number.test(age)) {
                alert("年龄必须为非零正整数");
                return;
            }
            $("#userForm").submit();
        }

        // 分页查询
        function userPage(page) {
            $("#pageNo").val(page);
            findUser();
        }
    </script>
</head>
<body>
<div class="container" style="width: 100%;padding: 25px 15px;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 20px;">
            <div style="float: left;">
                <input type="button" class="btn btn-primary btn" value="添加" onclick="javascript:location.href='${pageContext.request.contextPath}/system/addUser.jsp'"/>
            </div>
            <form action="#" method="post" id="userForm" role="form" class="form-inline" style="float: right;margin-bottom: 10px;">
                <div class="form-group" style="margin-right: 20px;">
                    <label for="exampleInputEmail1" style="margin-right: 10px;">姓名</label><input type="text" class="form-control" id="realName" name="realName" placeholder="姓名"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" style="margin-right: 10px;">年龄</label><input type="text" class="form-control" id="age" name="age" placeholder="年龄"/>
                </div>
                <input type="hidden" id="pageNo" name="offset" value="">
                <button type="button" class="btn btn-primary btn" onclick="findUser()">查询</button>
            </form>
            <table class="table table-bordered" style="margin-top: 20px;">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th style="width: 100px;">年龄</th>
                    <th style="width: 100px;">性别</th>
                    <th>手机号</th>
                    <th>邮箱</th>
                    <th>生日</th>
                    <th>入职日期</th>
                    <th style="width: 100px;">状态</th>
                    <th style="width: 200px;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userInfoList}" var="userInfo">
                    <tr class="success">
                        <td>${userInfo.realName }</td>
                        <td>${userInfo.age }</td>
                        <td>${userInfo.gender}</td>
                        <td>${userInfo.mobile }</td>
                        <td>${userInfo.email }</td>
                        <td>${userInfo.birthday }</td>
                        <td>${userInfo.entryTime }</td>
                        <td>${userInfo.status}</td>
                        <td>
                            <a href="userInfo.jsp" class="btn btn-primary btn">详情</a>
                            <a href="userInfo.jsp" class="btn btn-primary btn">修改</a>
                            <a href="javascript:void(0);" onclick="userDel()" class="btn btn-primary btn">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span>1条记录 共1页 当前第1页</span>
            <!-- 分页 -->
            <ul class="pagination" style="float: right;margin: 0;">
                <li><a href="javascript:void(0)" onclick="">首页</a></li>
                <li class="disabled"><a href="javascript:void(0)">上一页</a></li>
                <li class="disabled"><a href="javascript:void(0)">下一页</a></li>
                <li><a href="javascript:void(0)" onclick="">尾页</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user-info.js"></script>
</html>