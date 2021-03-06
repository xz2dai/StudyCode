<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
	<title>收支统计</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/content/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/content/assets/img/favicon.png">
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
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">每周概要</h3>
							<p class="panel-subtitle">Period: Oct 14, 2016 - Oct 21, 2016</p>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-download"></i></span>
										<p>
											<span class="number" name="num">1,252</span>
											<span class="title" >下载</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-shopping-bag"></i></span>
										<p>
											<span class="number" id="num">$132,735</span>
											<span class="title">销售</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-eye"></i></span>
										<p>
											<span class="number" name="num">274,678</span>
											<span class="title">访问</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-bar-chart"></i></span>
										<p>
											<span class="number" name="nochange">35%</span>
											<span class="title">转换</span>
										</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-9">
									<div id="headline-chart" class="ct-chart"></div>
								</div>
								<div class="col-md-3">
									<div class="weekly-summary text-right">
										<span class="number">￥2,315</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 12%</span>
										<span class="info-label">总销售额</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">￥5,758</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 23%</span>
										<span class="info-label">月收入</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">￥65,938</span> <span class="percentage"><i class="fa fa-caret-down text-danger"></i> 8%</span>
										<span class="info-label">总收入</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
					<div class="row">
						<div class="col-md-6">
							<!-- RECENT PURCHASES -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">最近购买</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body no-padding">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>订单号</th>
												<th>名字</th>
												<th>量</th>
												<th>日期和时间</th>
												<th>地位</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a href="#">763648</a></td>
												<td>袁铨</td>
												<td>￥122</td>
												<td>2020年12月25号</td>
												<td><span class="label label-success">完成</span></td>
											</tr>
											<tr>
												<td><a href="#">763649</a></td>
												<td>张昆熠</td>
												<td>￥62</td>
												<td>2020年12月25号</td>
												<td><span class="label label-warning">等待</span></td>
											</tr>
											<tr>
												<td><a href="#">763650</a></td>
												<td>刘良振</td>
												<td>￥34</td>
												<td>2020年12月25号</td>
												<td><span class="label label-danger">失败</span></td>
											</tr>
											<tr>
												<td><a href="#">763651</a></td>
												<td>扈世彬</td>
												<td>￥186</td>
												<td>2020年12月25号</td>
												<td><span class="label label-success">成功</span></td>
											</tr>
											<tr>
												<td><a href="#">763652</a></td>
												<td>杨佳洛</td>
												<td>￥362</td>
												<td>2020年12月25号</td>
												<td><span class="label label-success">成功</span></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-md-6"><span class="panel-note"><i class="fa fa-clock-o"></i> 过去24小时</span></div>
										<div class="col-md-6 text-right"><a href="${pageContext.request.contextPath}/OrdersList" class="btn btn-primary">查看所有购买</a></div>
									</div>
								</div>
							</div>
							<!-- END RECENT PURCHASES -->
						</div>
						<div class="col-md-6">
							<!-- MULTI CHARTS -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">业绩图</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<div id="visits-trends-chart" class="ct-chart"></div>
								</div>
							</div>
							<!-- END MULTI CHARTS -->
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<!-- TASKS -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">剩余库存</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<ul class="list-unstyled task-list">
										<li>
											<p>蔬菜 <span class="label-percent">23%</span></p>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="23" aria-valuemin="0" aria-valuemax="100" style="width:23%">
													<span class="sr-only">23% Complete</span>
												</div>
											</div>
										</li>
										<li>
											<p>大米 <span class="label-percent">80%</span></p>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
													<span class="sr-only">80% Complete</span>
												</div>
											</div>
										</li>
										<li>
											<p>猪肉 <span class="label-percent">100%</span></p>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
													<span class="sr-only">Success</span>
												</div>
											</div>
										</li>
										<li>
											<p>调料 <span class="label-percent">45%</span></p>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
													<span class="sr-only">45% Complete</span>
												</div>
											</div>
										</li>
										<li>
											<p>牛肉 <span class="label-percent">10%</span></p>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width: 10%">
													<span class="sr-only">10% Complete</span>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<!-- END TASKS -->
						</div>
						<div class="col-md-4">
							<!-- VISIT CHART -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">网站访问</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<div id="visits-chart" class="ct-chart"></div>
								</div>
							</div>
							<!-- END VISIT CHART -->
						</div>
						<div class="col-md-4">
							<!-- REALTIME CHART -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">后厨忙碌度</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
										<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<div id="system-load" class="easy-pie-chart" data-percent="70">
										<span class="percent">70</span>
									</div>
									<h4>后厨任务量</h4>
									<ul class="list-unstyled list-justify">
										<li>高: <span>95%</span></li>
										<li>平均: <span>87%</span></li>
										<li>低: <span>20%</span></li>
										<li>完成量: <span>996</span></li>
										<li>待完成量: <span>259</span></li>
									</ul>
								</div>
							</div>
							<!-- END REALTIME CHART -->
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
	<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/content/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/content/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="${pageContext.request.contextPath}/content/assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="${pageContext.request.contextPath}/content/assets/scripts/klorofil-common.js"></script>
	<script>
	$(function() {
		bianli();
		function bianli(){
			$("span[class='number']").each(function (){
				var num = randomNum();
				if($(this).attr("name")=="num"){
					$(this).html(num);
				}else if($(this).attr("name")=="nochange"){

				}else{
					$(this).html("￥"+num);
				}


			})
		}
		// randomNum();
		var data, options;
		function randomNum(){
			var x =100000;
			var y = 0;
			var num = parseInt(Math.random()*(x-y+1)+y);
			var newstr = '', newarr = [], finalarr = []
			//因为是从右边添加，所以要reverse()
			newarr = String(num).split('').reverse()
			//每添加三个元素后，添加一个逗号
			//因为数组的索引是从0开始的，要计算每三位元素，就应该使用i+1
			for(let i = 0; i < newarr.length; i++) {
				if((i + 1)% 3  == 0) {
					finalarr.unshift(newarr[i])
					finalarr.unshift(',')
				}else {
					finalarr.unshift(newarr[i])
				}
			}
			//清除头部出现的逗号，当数字长度是3的倍数时，头部会多添加一个逗号
			if(finalarr[0] == ',') {
				finalarr.shift()
			}
			//添加小数点后两位和价格符号
			newstr = finalarr.join('')
			console.log("newstr======"+newstr);

			var endNum =newstr;
			console.log("num====="+num);
			// $("#num").html(endNum);
			return endNum;
		}

		// headline charts
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[23, 29, 24, 40, 25, 24, 35],
				[14, 25, 18, 34, 29, 38, 44],
			]
		};

		options = {
			height: 300,
			showArea: true,
			showLine: false,
			showPoint: false,
			fullWidth: true,
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
		};

		new Chartist.Line('#headline-chart', data, options);


		// visits trend charts
		data = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			series: [{
				name: 'series-real',
				data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
			}, {
				name: 'series-projection',
				data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
			}]
		};

		options = {
			fullWidth: true,
			lineSmooth: false,
			height: "270px",
			low: 0,
			high: 'auto',
			series: {
				'series-projection': {
					showArea: true,
					showPoint: false,
					showLine: false
				},
			},
			axisX: {
				showGrid: false,

			},
			axisY: {
				showGrid: false,
				onlyInteger: true,
				offset: 0,
			},
			chartPadding: {
				left: 20,
				right: 20
			}
		};

		new Chartist.Line('#visits-trends-chart', data, options);


		// visits chart
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[6384, 6342, 5437, 2764, 3958, 5068, 7654]
			]
		};

		options = {
			height: 300,
			axisX: {
				showGrid: false
			},
		};

		new Chartist.Bar('#visits-chart', data, options);


		// real-time pie chart
		var sysLoad = $('#system-load').easyPieChart({
			size: 130,
			barColor: function(percent) {
				return "rgb(" + Math.round(200 * percent / 100) + ", " + Math.round(200 * (1.1 - percent / 100)) + ", 0)";
			},
			trackColor: 'rgba(245, 245, 245, 0.8)',
			scaleColor: false,
			lineWidth: 5,
			lineCap: "square",
			animate: 800
		});

		var updateInterval = 3000; // in milliseconds

		setInterval(function() {
			var randomVal;
			randomVal = getRandomInt(0, 100);

			sysLoad.data('easyPieChart').update(randomVal);
			sysLoad.find('.percent').text(randomVal);
		}, updateInterval);

		function getRandomInt(min, max) {
			return Math.floor(Math.random() * (max - min + 1)) + min;
		}

	});
	</script>
</body>

</html>
