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
						<li class="tab-title"><a
							href="${path}com/servlet/ShowLogisticAdmin"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">增加管理员</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/CarManager"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">车辆管理</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/LogisticFinish"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title is-active"><a href="${path}com/servlet/LogisticUnDispatcher"> <i
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
				<c:forEach items="${list}" var="oinfo">
						<div class="card-info primary">	
						<form action="${path}com/servlet/LogisticDispatcherCar" method="post">					
							<div class="card-info-content">								
							    <input type="text" name="oid" value="${oinfo.oid}" style="display:none">					
								<h3>订单明细：${oinfo.odesc}</h3>								
								<p>收货人地址:${oinfo.address}</p>
								<p>寄件地址:${oinfo.saddress}</p>
								<p>总价:${oinfo.allamount}</p>
								<p>配送信息:${oinfo.logisticaddress}</p>
							    <input name="carid" placeholder="请输入分配车辆id">
								<button type="submit" class="button">分配车辆</button>						
							</div>	
						</form>				
						</div>
					</c:forEach>	
		
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>