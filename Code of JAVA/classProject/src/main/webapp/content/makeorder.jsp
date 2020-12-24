<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.c611.classProject.bean.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.c611.classProject.service.impl.GoodsServiceImpl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.mysql.cj.util.StringUtils" %>
<%@ page import="com.c611.classProject.bean.GoodsPageBean" %>
<%@ page import="javax.print.attribute.standard.NumberUp" %>
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
    //循环遍历下标
    int goodListIndex = 1;
    int selectListIndex = 1;
    //获取商品表
    int totalPage = 1;
    //先检查缓存里有没有
    List<Goods> goodsList = (List<Goods>) request.getSession().getAttribute("goodsList");
    //当前商品表页数
    String wantgoodsListPage = request.getParameter("page");
    int NowGoodsListPage;
    GoodsPageBean goodsPageBean = null;
    int size = 10;
    if (!StringUtils.isNullOrEmpty(wantgoodsListPage)) {    //判断有无切换页面请求
        NowGoodsListPage = Integer.parseInt(wantgoodsListPage);
        try {
            goodsPageBean = new GoodsServiceImpl().getGoodsPageBean(NowGoodsListPage,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    } else {
        NowGoodsListPage = 1;
    }
    if(goodsPageBean==null){
        try {
            goodsPageBean = new GoodsServiceImpl().getGoodsPageBean(NowGoodsListPage,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            goodsPageBean = new GoodsPageBean();
            goodsPageBean.setTotalPageCount(1);
        }
    }else {
        goodsList = goodsPageBean.getGoodsList();
        totalPage = goodsPageBean.getTotalPageCount();
        NowGoodsListPage = goodsPageBean.getCurrentPage();
    }
    if (goodsList == null || goodsList.size() == 0) {       //缓存里没有就从数据库里查询
        List<Goods> m_goodsList = null;
        try {
            m_goodsList = new GoodsServiceImpl().findGoodsList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (m_goodsList != null) goodsList = m_goodsList;
        request.getSession().setAttribute("goodsList", goodsList);
    } else if (goodsList == null || goodsList.size() == 0) {    //数据库没有数据就创建测试数据
        goodsList = new ArrayList<>();
        //测试数据，默认id都是100
        goodsList.add(new Goods("糖醋排骨", 24d));
        goodsList.add(new Goods("红烧肉", 17d));
        goodsList.add(new Goods("黄焖鸡", 22d));
        goodsList.add(new Goods("米饭", 3d));
        goodsList.add(new Goods("小炒时蔬", 7d));
        goodsList.add(new Goods("紫菜蛋汤", 6d));
    }
    goodsList.stream().distinct().collect(Collectors.toList()); //去重

    //获取购物车
    List<Goods> selectList = (List<Goods>) request.getSession().getAttribute("selectList");
    if (selectList == null) {
        selectList = new ArrayList<>();
        selectList.add(new Goods("米饭", 3d));
    }
    //判断购物车操作

    //添加商品
    String index = request.getParameter("index");
    if (index != null && !index.equals("")) {
        selectList.add(goodsList.get(Integer.parseInt(index) - 1));
        request.getSession().setAttribute("selectList", selectList);
    }
    //删除商品
    String delete = request.getParameter("delete");
    if (delete != null && !delete.equals("")) {
        selectList.remove(Integer.parseInt(delete) - 1);
        request.getSession().setAttribute("selectList", selectList);
    }
    //得出商品总价值
    double count = 0d;
    for (Goods goods : selectList) {
        count += goods.getGoodPrice();
    }
    //获取提交订单后的反馈信息
    String infoType = request.getParameter("info");
    String infoMsg = request.getParameter("infoMsg");
    int info = 0;
    if (infoType != null) {
        info = Integer.parseInt(infoType);
    }
%>
<script type="text/javascript">
    onload = function () {
        var info =
        <%=info%>
        var infoMsg =
        <%=infoMsg%>
        if (info === 1) {
            success_alert(infoMsg)
        } else if (info === 2) {
            error_alert(infoMsg)
        }
    }

    function success_alert(Msg) {
        var success_btn = document.getElementById("success_btn")
        if (Msg != null) success_btn.setAttribute("data-message", Msg)
        success_btn.click()
    }

    function error_alert(Msg) {
        var error_btn = document.getElementById("error_btn")
        if (Msg != null) error_btn.setAttribute("data-message", Msg)
        error_btn.click()
    }

    function postList() {
        var userid = document.getElementById("UserID")
        if(userid.value === null || userid.value==="") {
            error_alert("用户不能为空！")
            return false
        }
        var userAdress = document.getElementById("UserAdress")
        if(userAdress.value === null || userAdress.value===""){
            error_alert("用户地址不能为空！")
            return false
        }
        <%request.getSession().setAttribute("selectList", selectList); %>
        return true
    }
</script>
<html>
<head>
    <title>创建订单</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/content/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/vendor/toastr/toastr.min.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/content/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="${pageContext.request.contextPath}/content/assets/css/front.css" rel="stylesheet">
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
                <div class="row" style="padding-bottom: 20px">
                    <p class="demo-button">
                        <%--        添加订单按钮行            --%>
                    <div class="col-md-6">
                        <a href="<c:url value="/OrdersList"/>">
                            <button type="button" class="btn btn-default">查看所有订单</button>
                        </a>
                    </div>

                    <div class="col-md-6">
                        <button type="button" class="btn btn-primary btn-block text-right" style="visibility: hidden">
                            创建订单
                        </button>
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
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>名称</th>
                                        <th>价格</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        if (goodsList != null) {
                                            for (Goods goods : goodsList) {
                                    %>
                                    <tr>
                                        <td><%=goodListIndex%>
                                        </td>
                                        <td><%=goods.getGoodName()%>
                                        </td>
                                        <td><%=goods.getGoodPrice()%>
                                        </td>
                                        <td style="text-align: center">
                                            <a href="${pageContext.request.contextPath}/content/makeorder.jsp?index=<%=goodListIndex%>">
                                                <button class="btn btn-default" type="button">
                                                    <i class="fa fa-plus-square"></i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                    <%
                                                goodListIndex++;
                                            }
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                            <div>
                                <div class="row">
                                    <%
                                        if(NowGoodsListPage > 1){
                                    %>
                                    <div class="col-md-6 text-left">
                                        <a href="${pageContext.request.contextPath}/content/makeorder.jsp?page=<%=NowGoodsListPage-1%>"><button type="button" class="btn btn-primary text-left">
                                            <
                                        </button></a>
                                    </div>
                                    <%
                                        }else{
                                    %>
                                    <div class="col-md-6 text-left">
                                        <button type="button" class="btn btn-primary text-left" onclick="error_alert('没有前一页了')">
                                            <
                                        </button>
                                    </div>
                                    <%
                                        }
                                        if(NowGoodsListPage<goodsPageBean.getTotalPageCount()){
                                    %>
                                    <div class="col-md-6 text-right">
                                        <a href="${pageContext.request.contextPath}/content/makeorder.jsp?page=<%=NowGoodsListPage+1%>"><button type="button" class="btn btn-primary text-right">
                                            >
                                        </button></a>
                                    </div>
                                    <%
                                    }else{
                                    %>
                                    <div class="col-md-6 text-right">
                                        <button type="button" class="btn btn-primary text-right" onclick="error_alert('没有下一页了')">
                                            >
                                        </button>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
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
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>名称</th>
                                        <th>价格</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        if (selectList != null && selectList.size() >= 0) {
                                            for (Goods goods : selectList) {
                                    %>
                                    <tr>
                                        <td><%=selectListIndex%>
                                        </td>
                                        <td><%=goods.getGoodName()%>
                                        </td>
                                        <td><%=goods.getGoodPrice()%>
                                        </td>
                                        <td style="text-align: center">
                                            <a href="${pageContext.request.contextPath}/content/makeorder.jsp?delete=<%=selectListIndex%>">
                                                <button type="button" class="btn btn-danger">
                                                    <i class="fa fa-trash-o"></i>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                    <%
                                                selectListIndex++;
                                            }
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- END BORDERED TABLE -->
                    </div>
                </div>
                <form action="<%=path%>/MakeOrderServlet" method="post" onsubmit="return postList()">
                    <div class="row">

                        <%--        订单信息填入行            --%>
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">输入订单信息</h3>
                            </div>
                            <div class="panel-body">
                                <input type="number" id="UserID" class="form-control" placeholder="用户ID" name="UserName">
                                <br>
                                <input type="text" id="UserAdress" class="form-control" placeholder="用户地址" name="Adress">
                                <br>
                                <input class="form-control" placeholder="备注" rows="1" name="Info" value=" ">
                                <br>
                                <label class="fancy-checkbox">
                                    <input type="radio" name="PayWay" value="1" checked>
                                    <span>支付宝</span>
                                </label>
                                <label class="fancy-checkbox">
                                    <input type="radio" name="PayWay" value="2">
                                    <span>微信</span>
                                </label>
                                <label class="fancy-checkbox">
                                    <input type="radio" name="PayWay" value="3">
                                    <span>到付</span>
                                </label>
                                <br>
                                <label class="fancy-radio">
                                    <input name="BuyWay" value="1" type="radio" checked>
                                    <span><i></i>外卖</span>
                                </label>
                                <label class="fancy-radio">
                                    <input name="BuyWay" value="2" type="radio">
                                    <span><i></i>到店</span>
                                </label>
                                <h3 class="panel-title" style="padding-top: 30px">订单总额：<%=count%>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <%--        订单结束行            --%>
                        <p class="demo-button ">
                        <div class="col-md-6">
                            <button type="button" class="btn btn-danger">取消</button>
                        </div>
                        <div class="col-md-6" hidden>
                            <button type="button" class="btn btn-primary" onclick="success_alert('wuhu')">测试</button>
                        </div>
                        <div class="col-md-6 text-right">
                            <input type="submit" class="btn btn-success btn-block" value="提交订单">
                        </div>
                </form>

            </div>
        </div>
        <div id="toastr-demo" hidden>
            <button type="button" id="success_btn" class="btn btn-success btn-toastr" data-context="success"
                    data-message="下单成功！" data-position="top-center">Success Info
            </button>
            <button type="button" id="error_btn" class="btn btn-warning btn-toastr" data-context="warning"
                    data-message="下单失败！" data-position="top-center">Warning Info
            </button>
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
    <li class="col-md-2 col-sm-4 col-xs-6" style="visibility: visible">
        <span class="lnr lnr-rocket"></span>
    </li>
    <button id="1" class="btn btn-primary"><a href="#last" style="color: #F8F8F8">我选好了</a></button>
</div>
<a id='last'> </a>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/vendor/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/content/assets/scripts/klorofil-common.js"></script>
</body>
</html>
