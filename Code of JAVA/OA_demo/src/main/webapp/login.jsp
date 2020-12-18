<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <style type="text/css">
        .myDiv {
            width: 336px;
            height: 290px;
            margin-top: 402px;
            margin-left: 806px;
            position: absolute;
            border-radius: 5px;
        }

        .inputText {
            border: 0px;
            border-bottom: 1px solid #8ad2a3;
            font-size: 18px;
            line-height: 50px;
            width: 100%;
            outline: none;
        }

        .inputBtn {
            margin-top: 30px;
            font-size: 24px;
            -moz-box-shadow: 0px 20px 30px #4de5a4; /* 老的 Firefox */
            box-shadow: 0px 20px 30px #4de5a4;
            background: linear-gradient(to right, #4de5a4, #15a54d);
        }
    </style>
</head>
<body style="background: url('img/login.png') no-repeat;">
<div class="myDiv">
    <form method="post" action="${pageContext.request.contextPath}/LoginServlet" onsubmit='return checkempty()'>
        <input type="text" class="inputText" name="account" id="account" placeholder="请输入账号" autofocus
               style="margin-top: 30px;"/><br>
        <input type="password" class="inputText" name="password" id="pwd" placeholder="请输入密码"
               style="margin-top: 60px;"/><br>
        <span style="color: red;">${login_error}</span><br>
        <input type="submit" class="btn btn-success btn-lg btn-block inputBtn" value="登录"/>
    </form>
</div>
</body>
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</html>