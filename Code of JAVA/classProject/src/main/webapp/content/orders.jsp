<%@ page import="com.c611.classProject.bean.Orders" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	List<Orders> list = (List<Orders>) request.getAttribute("list");
	int ListIndex=0;
%>

<html lang="en">

<head>
	<title>订单管理</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/content/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/content/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/content/assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/content/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/content/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath }/content/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath }/content/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand" style="padding: 1px">
				<a href="${pageContext.request.contextPath}/index.jsp"><img
						src="${pageContext.request.contextPath}/content/assets/img/logo-main.png" class="logo"
						style="height: 60px;padding-top: 15px" alt="Logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search Orders...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
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
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/content/assets/img/user.png"
																							class="img-circle" alt="Avatar">
								<span>管理员</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>个人主页</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>消息</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>设置</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>登出</span></a></li>
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
						<li><a href="<c:url value="/SerchByID"/>" class=""><i
								class="lnr lnr-code"></i> <span>查看订单</span></a></li>
						<li><a href="${pageContext.request.contextPath}/content/income.jsp" class=""><i
								class="lnr lnr-chart-bars"></i> <span>收支统计</span></a></li>
						<li><a href="<c:url value="/clientListServlet"/>" class=""><i
								class="lnr lnr-cog"></i> <span>客户管理</span></a></li>
						<li><a href="${pageContext.request.contextPath}/content/employee.jsp" class=""><i
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
					<h3 class="page-title">订单管理</h3>
					<div class="row">
						<div class="">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">订单列表</h3>
								</div>
								<form action="/SerchByID" method="post" class="navbar-form navbar-left">
									<div class="input-group">
										<input type="text" name="input" value="" class="form-control" placeholder="输入订单号...">
										<span class="input-group-btn"><button type="submit" class="btn btn-primary">搜索</button></span>
									</div>
								</form>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>#</th>
												<th>订单ID</th>
												<th>订单用户ID</th>
												<th>订单商品ID</th>
												<th>订单描述</th>
												<th>订单状态</th>

											</tr>
										</thead>
										<tbody>

										<%
											if(list!=null){
												for (Orders orders : list) {
										%>
										<tr>
											<td><%=ListIndex%>
											</td>
											<td><%=orders.getOrderID()%>
											</td>
											<td><%=orders.getOrderUserID()%>
											</td>
											<td><%=orders.getOrdergoodID()%>
											</td>
											<td><%=orders.getOrderDescribe()%>
											</td>
											<td><%=orders.getOrderStatus()%>
											</td>
											<th><button href="/logout" class="btn btn-primary">完成订单</button>
												<button href="/logout" class="btn btn-primary">删除订单</button>
											</th>
										</tr>
										<%
												ListIndex++;
											}}
										%>



<%--												<%--%>
<%--													if(true){--%>
<%--												%>--%>

<%--												<% }--%>

<%--												else {--%>
<%--												%>--%>

<%--												<tr>--%>
<%--													<td><%= request.getAttribute("OrderID")%></td>--%>
<%--													<td><%= request.getAttribute("OrderID")%></td>--%>
<%--													<td><%= request.getAttribute("OrderID")%>}</td>--%>
<%--													<td><%= request.getAttribute("OrderID")%></td>--%>
<%--													<td><%= request.getAttribute("OrderID")%></td>--%>
<%--													<th><button href="/logout" class="btn btn-primary">完成订单</button>--%>
<%--														<button href="/logout" class="btn btn-primary">删除订单</button>--%>
<%--														</th>--%>
<%--												</tr>--%>

<%--												<%} %>--%>


										</tbody>
									</table>
								</div>
							</div>
							<!-- END BASIC TABLE -->
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
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="${pageContext.request.contextPath }/content/assets/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/content/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/content/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath }/content/assets/scripts/klorofil-common.js"></script>
</body>

</html>
