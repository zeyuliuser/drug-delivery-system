<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet"
	href="com_js_css/foundation-6.4.2-complete/css/app.css">
<link type="text/css" rel="stylesheet"
	href="com_js_css/foundation-6.4.2-complete/css/foundation.css">
<link type="text/css" rel="stylesheet"
	href="com_js_css/foundation-6.4.2-complete/css/foundation.min.css">
<link type="text/css" rel="stylesheet" href="com_js_css/inital.css">
<link type="text/css" rel="stylesheet"
	href="customview_css_js/customview.css">
<script type="text/javascript"
	src="com_js_css/foundation-6.4.2-complete/js/app.js"></script>
<script type="text/javascript"
	src="com_js_css/foundation-6.4.2-complete/js/vendor/foundation.js"></script>
<script type="text/javascript"
	src="com_js_css/foundation-6.4.2-complete/js/vendor/foundation.min.js"></script>
<script type="text/javascript"
	src="com_js_css/foundation-6.4.2-complete/js/vendor/jquery.js"></script>
<script type="text/javascript"
	src="com_js_css/foundation-6.4.2-complete/js/vendor/what-input.js"></script>
<script type="text/javascript" src="customview_css_js/costomview.js"></script>

<title>分公司界面</title>
</head>
<body>
	<div class="app-dashboard shrink-medium">
		<div class="row expanded app-dashboard-top-nav-bar">
			<div class="columns show-for-medium">
				
			</div>
			<div class="columns shrink app-dashboard-top-bar-actions">
				
			</div>
		</div>


		<div class="app-dashboard-body off-canvas-wrapper">
			<div id="app-dashboard-sidebar"
				class="app-dashboard-sidebar position-left off-canvas off-canvas-absolute reveal-for-medium">
				<div class="app-dashboard-sidebar-title-area">
					<div class="app-dashboard-close-sidebar">
						<h3 class="app-dashboard-sidebar-block-title">分公司管理员</h3>
			
					</div>
				
				</div>
				<div >
					<ul id="collapsing-tabs"  class="menu vertical tabs">																
						<li class="tab-title"><a href="com/servlet/ShowFAdmin"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">增加管理员</span>
						</a></li>
						<!-- <li class="tab-title"><a href="#"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">库存信息</span>
						</a></li> -->
						<li class="tab-title"><a href="com/servlet/FcompFinish"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title"><a href="com/servlet/FcompUnGo"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未发货订单</span>
						</a></li>
						<li class="tab-title"><a href="com/servlet/FcompUnFinish"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未完成订单</span>
						</a></li>
						<li class="tab-title"><a href="com/servlet/FcompUnAccept"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">拒收订单</span>
						</a></li>
						<li class="tab-title"><a href="com/servlet/ExitServlet"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">退出系统</span>
						</a></li>
					</ul>
				</div>
			</div>

			<div class="app-dashboard-body-content off-canvas-content tabs-content">
				 <!-- data-tabs-content="collapsing-tabs" -->
				 <!-- data-off-canvas-content -->
				 <div class="tabs-panel content is-active">
					<jsp:include page="drug_table.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>