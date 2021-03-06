<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", basePath);
%>
<head>

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



<title>顾客界面</title>
</head>
<body>
	<div class="app-dashboard shrink-medium">
		<form action="${path}com/servlet/GetSpecialDrugServlet" method="post">
			<div class="row expanded app-dashboard-top-nav-bar">
				<div class="columns show-for-medium">
					<div class="app-dashboard-search-bar-container">
						<input class="app-dashboard-search" type="text"
							placeholder="Search" name="drug_name"> <i
							class="app-dashboard-search-icon fa fa-search"></i>
					</div>
				</div>
				<div class="columns shrink app-dashboard-top-bar-actions">
					<button type="submit" class="button hollow">药品查询</button>
				</div>
			</div>
		</form>

		<div class="app-dashboard-body off-canvas-wrapper">
			<div id="app-dashboard-sidebar"
				class="app-dashboard-sidebar position-left off-canvas off-canvas-absolute reveal-for-medium">
				<div class="app-dashboard-sidebar-title-area">
					<div class="app-dashboard-close-sidebar">
						<h3 class="app-dashboard-sidebar-block-title">顾客</h3>

					</div>

				</div>
				<div>
					<ul id="collapsing-tabs" class="menu vertical tabs">
						<li class="tab-title"><a href="${path}customview.jsp"> <i
								class="large fa fa-institution"></i> <span
								class="app-dashboard-sidebar-text">个人信息</span>
						</a></li>
						<li class="tab-title is-active"><a
							href="${path}com/servlet/GetAllDrugServlet"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">药品列表</span>
						</a></li>
						<li class="tab-title"><a
							href="${path}com/servlet/ShowCartServlet"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">购物车</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/ShowCustomFinish">
								<i class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/ShowCustomUnFinish">
								<i class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/ShowCustomOrder"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">待发货</span>
						</a></li>
						
						<li class="tab-title"><a href="${path}com/servlet/ShowCustomUnAccept"> <i
								class="large fa fa-institution"></i><span
								class="app-dashboard-sidebar-text">拒收订单</span>
						</a></li>
						<li class="tab-title"><a
							href="${path}com/servlet/ExitServlet"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">退出系统</span>
						</a></li>
					</ul>
				</div>
			</div>

			<div
				class="app-dashboard-body-content off-canvas-content tabs-content">
				<!-- data-tabs-content="collapsing-tabs" -->
				<!-- data-off-canvas-content -->
				<div class="tabs-panel content is-active" id="custom_info">
					<c:forEach items="${druglist}" var="drug">
						<div class="card-info primary">
							<form action="${path}com/servlet/AddDrugCart" method="post">
								<div class="card-info-content">
									<input type="text" name="drugid" style="display: none"
										value="${drug.did}">
									<h3 class="lead">${drug.dname}</h3>
									<p>${drug.ddesc}</p>
									<img src="${path}${drug.dpic}">
									<p>价格:${drug.price}</p>
									<input class="input-group-field" id="quantity" type="number"
										name="quantity" value="0">
									<button type="submit" class="button">加入购物车</button>
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