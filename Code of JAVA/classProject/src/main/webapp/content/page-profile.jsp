<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <title>个人信息</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!--  模态框插件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/css/http_cdn.staticfile.org_twitter-bootstrap_3.3.7_css_bootstrap.css">
    <script src="${pageContext.request.contextPath}/content/assets/scripts/http_cdn.staticfile.org_jquery_2.1.1_jquery.js"></script>
    <script src="${pageContext.request.contextPath}/content/assets/scripts/http_cdn.staticfile.org_twitter-bootstrap_3.3.7_js_bootstrap.js"></script>
    <!-- VENDOR CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/content/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76"
          href="${pageContext.request.contextPath}/content/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96"
          href="${pageContext.request.contextPath}/content/assets/img/favicon.png">
</head>

<body>

<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand" style="padding: 1px">
            <a href="${pageContext.request.contextPath}/Logout"><img
                    src="${pageContext.request.contextPath}/content/assets/img/logo-main.png" class="logo"
                    style="height: 60px;padding-top: 15px" alt="主页"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <form action="<c:url value="/OrdersSearch"/>" method="post" class="navbar-form navbar-left">
                <div class="input-group">
                    <input type="text" name="input" required="" class="form-control" placeholder="搜索订单号...">
                    <span class="input-group-btn"><input type="submit" class="btn btn-primary" value="go"></span>
                </div>
            </form>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>仓库剩余空间不足</a>
                            </li>
                            <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>9个订单未处理</a>
                            </li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>月度总结可用</a>
                            </li>
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-warning"></span>每周总结将在1小时内开始</a></li>
                            <li><a href="#" class="more">查看所有信息</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="lnr lnr-question-circle"></i> <span>Help</span> <i
                                class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">基本使用</a></li>
                            <li><a href="#">店铺相关</a></li>
                            <li><a href="#">店铺证书</a></li>
                            <li><a href="#">我有意见</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img
                                src="${pageContext.request.contextPath}/content/assets/img/user.png"
                                class="img-circle" alt="Avatar">
                            <span>${user_info.userName}</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/userProfileServlet?userID=${user_info.userID}"><i class="lnr lnr-user"></i>
                                <span>个人主页</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>消息</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>设置</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/Logout"><i class="lnr lnr-exit"></i> <span>登出</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="${pageContext.request.contextPath}/content/makeorder.jsp" class=""><i
                            class="lnr lnr-home"></i> <span>点单</span></a></li>
                    <li><a href="<c:url value="/OrdersList"/>" class=""><i
                            class="lnr lnr-code"></i> <span>查看订单</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/content/income.jsp" class=""><i
                            class="lnr lnr-chart-bars"></i> <span>收支统计</span></a></li>
                    <li><a href="<c:url value="/clientListServlet"/>" class=""><i
                            class="lnr lnr-cog"></i> <span>客户管理</span></a></li>
                    <li><a href="<c:url value="/GoodList"/>" class=""><i
                            class="lnr lnr-database"></i> <span>查看商品</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/employeeListServlet" class=""><i
                            class="lnr lnr-alarm"></i><span>员工管理</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <div class="panel panel-profile">
                    <div class="clearfix">
                        <!-- LEFT COLUMN -->
                        <div class="profile-left ">
                            <!-- PROFILE HEADER -->
                            <div class="profile-header ">
                                <div class="overlay"></div>
                                <div class="profile-main">
                                    <img src="${pageContext.request.contextPath}/content/assets/img/user-medium.png"
                                         class="img-circle" alt="Avatar">
                                    <h3 class="name">${userInfo.userName}</h3>
                                  <span class="online-status status-available"></span>
                                </div>
                                <div class="profile-stat">
                                    <div class="row">
                                        <div class="col-md-4 stat-item">
                                            ${userInfo.grade} <span>等级</span>
                                        </div>
                                        <div class="col-md-4 stat-item">
                                            <c:if test="${userInfo.grand==0}" >会员</c:if>
                                            <c:if test="${userInfo.grand==1}" >非会员</c:if>
                                            <span>用户类型</span>
                                        </div>
                                        <div class="col-md-4 stat-item">
                                            ${userInfo.creatTime} <span>账号创建时间</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PROFILE HEADER -->
                            <!-- PROFILE DETAIL -->

                            <div class="profile-detail">
                                <div class="profile-info">
                                    <h4 class="heading">基本信息</h4>
                                    <ul class="list-unstyled list-justify">
                                        <li>钱包余额 <span> ${userInfo.money}</span></li>
                                        <li>性别 <c:if test="${userInfo.sex==0}"><span>男</span></c:if>
                                                 <c:if test="${userInfo.sex==1}"><span>女</span></c:if>
                                        </li>
                                        <li>电话 <span>${userInfo.phoneNum}</span></li>
                                        <li>邮箱 <span>${userInfo.email}</span></li>
                                        <li>用户年龄<span><a href="#"></a>${userInfo.age}</span></li>
                                    </ul>
                                </div>
                                <div class="profile-info">
                                    <h4 class="heading">社交</h4>
                                    <ul class="list-inline social-icons">
                                        <li><a class="facebook-bg"><i class="fa fa-facebook"></i></a></li>
                                        <li><a class="twitter-bg"><i class="fa fa-twitter"></i></a></li>
                                        <li><a class="google-plus-bg"><i class="fa fa-google-plus"></i></a></li>
                                        <li><a class="github-bg"><i class="fa fa-github"></i></a></li>
                                    </ul>
                                </div>
                                <div class="profile-info">
                                    <h4 class="heading">个性签名</h4>
                                    <p>${userInfo.selfIntro}</p>
                                </div>
                                <div class="text-center">
                                    <div class="top-big-link">
                                        <a class="btn btn-primary" data-toggle="modal" href="#modal-register">编辑信息</a>
                                    </div>
                                </div>
                            </div>
                            <!-- END PROFILE DETAIL -->
                        </div>
                        <!-- END LEFT COLUMN -->
                        <!-- RIGHT COLUMN -->
                        <div class="profile-right">
                            <h4 class="heading">吃货勋章墙</h4>
                            <!-- AWARDS -->
                            <div class="awards">
                                <div class="row">
                                    <div class="col-md-3 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-sun award-icon"></span>
                                            </div>
                                            <span>Most Bright Idea</span>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-clock award-icon"></span>
                                            </div>
                                            <span>Most On-Time</span>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-magic-wand award-icon"></span>
                                            </div>
                                            <span>Problem Solver</span>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-heart award-icon"></span>
                                            </div>
                                            <span>Most Loved</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center"><a href="#" class="btn btn-default">查看所有勋章</a></div>
                            </div>
                            <!-- END AWARDS -->
                            <!-- TABBED CONTENT -->
                            <div class="custom-tabs-line tabs-line-bottom left-aligned">
                                <ul class="nav" role="tablist">
                                    <li class="active"><a href="#tab-bottom-left1" role="tab"
                                                          data-toggle="tab">最近订单<span class="badge">7</span></a></li>
                                    <li><a href="#tab-bottom-left2" role="tab" data-toggle="tab">消费排行榜 </a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-bottom-left1">
                                    <ul class="list-unstyled activity-timeline">
                                            <c:forEach items="${list}" var="orders" varStatus="loop">
                                        <li>

                                            <c:if test="${orders.orderStatus==0}"><i  class="fa fa-comment activity-icon"></i></c:if>
                                            <c:if test="${orders.orderStatus==1}"><i  class="fa fa-check activity-icon"></i></c:if>
                                            <p><a>订单号:${orders.orderID}号,购买套餐为[${lists[loop.count-1].goodName}]</a> <span class="timestamp">
                                                <c:if test="${orders.orderStatus==0}">正在火速派送中.....</c:if>
                                                <c:if test="${orders.orderStatus==1}">订单已完成！！！</c:if>
                                            </span>
                                            </p>
                                        </li>
                                            </c:forEach>
                                        <body>
                                        <br /><br /><br /><br /><br /><br />
                                        <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
                                        </body>
                                    </ul>

                                </div>
                                <div class="tab-pane fade" id="tab-bottom-left2">
                                    <div class="table-responsive">
                                        <table class="table project-table">
                                            <thead>
                                            <tr>
                                                <th>菜品名</th>
                                                <th>购买统计</th>
                                                <th>最后一次购买时间</th>
                                                <th>状态</th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td><a href="#">小炒时蔬</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                                            <span>60% Complete</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td> <a href="#">2018-08-09</a></td>
                                                <td><span class="label label-success">ACTIVE</span></td>
                                            </tr>
                                            <tr>
                                                <td><a href="#">紫菜蛋汤</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="33"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: 33%;">
                                                            <span>33% Complete</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td><a href="#" style="align-self: auto">2018-08-09</a></td>
                                                <td><span class="label label-warning">PENDING</span></td>
                                            </tr>
                                            <tr>
                                                <td><a href="#">黄焖鸡</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="68"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: 68%;">
                                                            <span>68% Complete</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td> <a href="#">2018-08-09</a></td>
                                                <td><span class="label label-success">ACTIVE</span></td>
                                            </tr>
                                            <tr>
                                                <td><a href="#">巴西烤肉</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar" role="progressbar" aria-valuenow="75"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
                                                            <span>75%</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td> <a href="#">2018-08-09</a></td>
                                                <td><span class="label label-success">ACTIVE</span></td>
                                            </tr>
                                            <tr>
                                                <td><a href="#">红烧肉</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-success"
                                                             role="progressbar" aria-valuenow="100" aria-valuemin="0"
                                                             aria-valuemax="100" style="width: 100%;">
                                                            <span>100%</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td> <a href="#">2018-08-09</a></td>
                                                <td><span class="label label-default">CLOSED</span></td>
                                            </tr>
                                            <tr>
                                                <td><a href="#">米饭</a></td>
                                                <td>
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-success"
                                                             role="progressbar" aria-valuenow="100" aria-valuemin="0"
                                                             aria-valuemax="100" style="width: 100%;">
                                                            <span>100%</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td> <a href="#">2018-08-09</a></td>
                                                <td><span class="label label-default">CLOSED</span></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- END TABBED CONTENT -->
                        </div>
                        <!-- END RIGHT COLUMN -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MAIN CONTENT -->
</div>
<!-- END MAIN -->
<div class="clearfix"></div>
<footer>
    <div class="container-fluid">
        <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.</p>
    </div>
</footer>

<!-- MODAL -->
<div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-header" >
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>

            </button>
            <h3 class="modal-title" id="modal-register-label">编辑个人信息</h3>
            <p>请勿将个人信息泄露给陌生人！</p>
        </div>

        <div class="modal-body">

            <form role="form" action="${pageContext.request.contextPath}/userEditServlet" method="post" class="registration-form">
            <div class="form-group" >
                <input type="hidden"   name="userID" value="${userInfo.userID}" >

                <label class="" for="userName">名字</label>
                <input type="text" name="userName" placeholder="名字....." value="${userInfo.userName}"
                       class="form-name form-control" id="userName">
            </div>
            <div class="form-group">
                <label class="form-lavel" for="account" id="account">性别：</label>
                <input type="radio" name="sex" value="0" ${userInfo.sex==0?"checked":""}>男&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="sex" value="1" ${userInfo.sex==1?"checked":""}>女&nbsp;
            </div>
            <div class="form-group">
                <label class="" for="phoneNum">电话</label>
                <input type="text" name="phoneNum" placeholder="电话..." value="${userInfo.phoneNum}"
                       class="form-phone form-control" id="phoneNum">
            </div>
            <div class="form-group">
                <label class="" for="email">邮箱</label>
                <input type="text" name="email" placeholder="邮箱..." value="${userInfo.email}"
                       class="form-email form-control" id="email">
            </div>
            <div class="form-group">
                <label class="" for="age">年龄</label>
                <input type="" name="age" placeholder="年龄..." value="${userInfo.age}"
                       class="form-age form-control" id="age">
            </div>
            <div class="form-group">
                <label class="" for="selfIntro">自我介绍</label>
                <textarea name="selfIntro" placeholder="自我介绍..."
                          class="form-about-yourself form-control" id="selfIntro" > </textarea>
            </div>
                <input type="submit" href=""  class="btn" value="保存"/>
                <script>document.getElementById("selfIntro").value="${userInfo.selfIntro}"</script>
            </form>
        </div>
    </div>
</div>
</div>



<!-- Javascript -->
<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/scripts/klorofil-common.js"></script>

</body>

</html>
