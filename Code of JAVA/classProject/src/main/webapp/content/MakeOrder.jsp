<%--
  下单界面
  Author: yq
  Date: 2020/12/16
  Time: 20:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Tables</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="./assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="./assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="./assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="./assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="./assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand" style="padding: 1px">
            <a href="http://localhost:8080/classProject/index.jsp"><img src="${pageContext.request.contextPath}/content/assets/img/logo-main.png" class="logo" style="height: 60px;padding-top: 15px" alt="Logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <form class="navbar-form navbar-left">
                <div class="input-group">
                    <input type="text" value="" class="form-control" placeholder="Search dashboard...">
                    <span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
                </div>
            </form>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                            <span class="badge bgger">5</span>
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
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="lnr lnr-question-circle"></i> <span>Help</span> <i
                                class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Basic Use</a></li>
                            <li><a href="#">Working With Data</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Troubleshooting</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="./assets/img/user.png"
                                                                                        class="img-circle" alt="Avatar">
                            <span>管理员</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>个人主页</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>消息</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>设置</span></a></li>
                            <li><a href="#"><i class="lnr lnr-exit"></i> <span>登出</span></a></li>
                        </ul>
                    </li>
                    <!-- <li>
                        <a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
                    </li> -->
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
                    <li><a href="${pageContext.request.contextPath}/content/MakeOrder.jsp" class=""><i class="lnr lnr-home"></i> <span>点单</span></a></li>
                    <li><a href="elements.html" class=""><i class="lnr lnr-code"></i> <span>查看订单</span></a></li>
                    <li><a href="charts.html" class=""><i class="lnr lnr-chart-bars"></i> <span>收支统计</span></a></li>
                    <li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>客户管理</span></a></li>
                    <li><a href="notifications.html" class=""><i class="lnr lnr-alarm"></i><span>员工管理</span></a></li>
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
                <div class="row" style="padding-bottom: 20px">
                    <p class="demo-button">
                        <%--        添加订单按钮行            --%>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-default">查看所有订单</button>
                    </div>

                    <div class="col-md-6">
                        <button type="button" class="btn btn-primary btn-block text-right">创建订单</button>
                    </div>
                    </p>
                </div>
                <div class="row">
                    <%--        商品选择行            --%>
                    <div class="col-md-6" id="WaitSelectTable">
                        <!-- BORDERED TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="row" style="overflow: hidden">
                                    <span class="lnr lnr-inbox"></span>
                                    <h3 class="panel-title">菜单</h3>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>名称</th>
                                        <th>价格</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>糖醋排骨</td>
                                        <td>24</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-default"><i
                                                    class="fa fa-plus-square"></i></button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>红烧肉</td>
                                        <td>17</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-default"><i
                                                    class="fa fa-plus-square"></i></button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>黄焖鸡</td>
                                        <td>22</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-default"><i
                                                    class="fa fa-plus-square"></i></button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END BORDERED TABLE -->
                    </div>
                    <div class="col-md-6" id="SelectedTable">
                        <!-- BORDERED TABLE -->
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="row" style="overflow: hidden">
                                    <span class="lnr lnr-cart"></span>
                                    <h3 class="panel-title">购物车</h3>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>名称</th>
                                        <th>价格</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>米饭</td>
                                        <td>3</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>小炒时蔬</td>
                                        <td>7</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>紫菜蛋汤</td>
                                        <td>6</td>
                                        <td style="text-align: center">
                                            <button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END BORDERED TABLE -->
                    </div>
                </div>
                <div class="row">
                    <%--        订单信息填入行            --%>
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">输入订单信息</h3>
                        </div>
                        <div class="panel-body">
                            <input type="text" class="form-control" placeholder="text field">
                            <br>
                            <input type="password" class="form-control" value="asecret">
                            <br>
                            <textarea class="form-control" placeholder="textarea" rows="4"></textarea>
                            <br>
                            <select class="form-control">
                                <option value="cheese">Cheese</option>
                                <option value="tomatoes">Tomatoes</option>
                                <option value="mozarella">Mozzarella</option>
                                <option value="mushrooms">Mushrooms</option>
                                <option value="pepperoni">Pepperoni</option>
                                <option value="onions">Onions</option>
                            </select>
                            <br>
                            <label class="fancy-checkbox">
                                <input type="checkbox">
                                <span>Fancy Checkbox 1</span>
                            </label>
                            <label class="fancy-checkbox">
                                <input type="checkbox">
                                <span>Fancy Checkbox 2</span>
                            </label>
                            <label class="fancy-checkbox">
                                <input type="checkbox">
                                <span>Fancy Checkbox 3</span>
                            </label>
                            <br>
                            <label class="fancy-radio">
                                <input name="gender" value="male" type="radio">
                                <span><i></i>Male</span>
                            </label>
                            <label class="fancy-radio">
                                <input name="gender" value="female" type="radio">
                                <span><i></i>Female</span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <%--        订单结束行            --%>
                    <p class="demo-button ">
                    <div class="col-md-6">
                        <button type="button" class="btn btn-danger">取消</button>
                    </div>
                    <div class="col-md-6 text-right">
                        <button type="button" class="btn btn-success btn-block">提交订单</button>
                    </div>

                    </p>
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
</div>
<div style="width:66px;position:fixed;bottom:180px;right:25px;font-size:0;line-height:0;z-index:100;">
    <%--    右下角浮动按钮--%>
    <li class="col-md-2 col-sm-4 col-xs-6">
        <span class="lnr lnr-rocket"></span>
    </li>
    <button class="btn btn-primary"><a href="#last" style="color: #F8F8F8">我选好了</a></button>
</div>
<a id='last'> </a>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="./assets/vendor/jquery/jquery.min.js"></script>
<script src="./assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="./assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="./assets/scripts/klorofil-common.js"></script>
</body>
</html>
