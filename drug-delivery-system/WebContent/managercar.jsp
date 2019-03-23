<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", basePath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/app.css">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/foundation.css">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/foundation.min.css">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/inital.css">
<link type="text/css" rel="stylesheet"
	href="${path}customview_css_js/customview.css">
<script type="text/javascript"
	src="${path}com_js_css/foundation-6.4.2-complete/js/app.js"></script>
<script type="text/javascript"
	src="${path}com_js_css/foundation-6.4.2-complete/js/vendor/foundation.js"></script>
<script type="text/javascript"
	src="${path}com_js_css/foundation-6.4.2-complete/js/vendor/foundation.min.js"></script>
<script type="text/javascript"
	src="${path}com_js_css/foundation-6.4.2-complete/js/vendor/jquery.js"></script>
<script type="text/javascript"
	src="${path}com_js_css/foundation-6.4.2-complete/js/vendor/what-input.js"></script>
<script type="text/javascript"
	src="${path}customview_css_js/costomview.js"></script>

<title>配送中心页面</title>
</head>
<body>
	<div class="app-dashboard shrink-medium">
		<div class="row expanded app-dashboard-top-nav-bar">
			<div class="columns show-for-medium">
				<div class="app-dashboard-search-bar-container">
					
				</div>
			</div>
			<div class="columns shrink app-dashboard-top-bar-actions">
			
			</div>
		</div>

		<div class="app-dashboard-body off-canvas-wrapper">
			<div id="app-dashboard-sidebar"
				class="app-dashboard-sidebar position-left off-canvas off-canvas-absolute reveal-for-medium">
				<div class="app-dashboard-sidebar-title-area">
					<div class="app-dashboard-close-sidebar">
						<h3 class="app-dashboard-sidebar-block-title">配送管理员</h3>

					</div>

				</div>
				<div>
					<ul id="collapsing-tabs" class="menu vertical tabs">						
						<li class="tab-title "><a
							href="${path}com/servlet/ShowLogisticAdmin"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">增加管理员</span>
						</a></li>
						<li class="tab-title is-active"><a href="${path}com/servlet/CarManager"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">车辆管理</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/LogisticFinish"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/LogisticUnDispatcher"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未分配车辆订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/LogisticFinishing"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">正在进行</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/LogisticUnAccept"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">拒收订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/ExitServlet">
								<i class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">退出系统</span>
						</a></li>
					</ul>
				</div>
			</div>

			<div
				class="app-dashboard-body-content off-canvas-content tabs-content">
				<div class="tabs-panel content is-active">
					<c:forEach items="${list}" var="car">
						<div class="card-info primary">
						
							<div class="card-info-content">
							<form action="${path}com/servlet/RepairCar" method="post">
							<input type="text" name="carid" value="${car.carid}" style="display: none">
								<p>车牌号码：${car.carid}</p>
								<p>驾驶员姓名:${car.driver}</p>
								<p>车辆状态:${car.carstate}</p><h6 style="color:red">(*-1修理中  0空闲  1正在使用)</h6>
								<p>车辆地址：${car.caraddress}</p>	
								<button class="button warning" type="submit">维修</button>	
							</form>	
							<form action="${path}com/servlet/RepairedCar" method="post">
							<input type="text" name="carid" value="${car.carid}" style="display: none">	
							<button class="button" type="submit">已维修</button>	
							</form>	
							<form action="${path}com/servlet/CarFree" method="post">
							<input type="text" name="carid" value="${car.carid}" style="display: none">	
							<button class="button" type="submit">设为空闲</button>	
							</form>			
							</div>
						
						</div>
					</c:forEach>
					<button type="button" class="button" id="add_admin">添加车辆</button>
					<div id="admininfo" style="display: none">
						<form action="${path}com/servlet/AddCar" method="post">
					<input type="text" name="carid" placeholder="请输入车牌号码">
					<input type="text" name="driver" placeholder="请输入驾驶员名字">
					<input type="text" name="carstate" placeholder="请输入车辆状态">
					<input type="text" name="caraddress" placeholder="请输入车辆地址">					
					<button type="submit" class="button">保存</button>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$("#add_admin").click(function(){
		$("#admininfo").css({"display":"inline"});
	})
	</script>
</body>
</html>