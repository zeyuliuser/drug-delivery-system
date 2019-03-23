<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/app.css">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/foundation.css">
<link type="text/css" rel="stylesheet"
	href="${path}com_js_css/foundation-6.4.2-complete/css/foundation.min.css">
<link type="text/css" rel="stylesheet" href="${path}com_js_css/inital.css">
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
<script type="text/javascript" src="${path}customview_css_js/costomview.js"></script>

<title>总公司界面</title>
</head>
<body>
	<div class="app-dashboard shrink-medium">
		<form action="${path}com/servlet/ZcompSearchDrugByName" method="post">
			<div class="row expanded app-dashboard-top-nav-bar">

				<div class="columns show-for-medium">
					<div class="app-dashboard-search-bar-container">
						<input class="app-dashboard-search" type="text"
							placeholder="Search" name="dname"> <i
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
						<h3 class="app-dashboard-sidebar-block-title">管理员</h3>

					</div>

				</div>
				<div>
					<ul id="collapsing-tabs" class="menu vertical tabs">
						<li class="tab-title"><a href="${path}zcomp.jsp"> <i
								class="large fa fa-institution"></i> <span
								class="app-dashboard-sidebar-text">药物录入</span>
						</a></li>
						<li class="tab-title "><a href="${path}com/servlet/ZcompGetAllDrugServlet"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">药品列表</span>
						</a></li>
						<li class="tab-title"><a href="${path}zcompsearchorder.jsp"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">查询订单</span>
						</a></li>
						
						<li class="tab-title"><a href="${path}com/servlet/ZcompGetFinishtOrder"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title is-active"><a href="${path}com/servlet/GetAllUnFinishOrder"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/ShowZAdmin"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">增加管理员</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/GetUnAcceptOrder"> <i
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
				<!-- data-tabs-content="collapsing-tabs" -->
				<!-- data-off-canvas-content -->
				<div class="tabs-panel content is-active">
					 <c:forEach items="${list}" var="oinfo">
						<div class="card-info primary">						
							<div class="card-info-content">		
							    <input type="text" name="oid" value="${oinfo.oid}" style="display:none">					
								<h3>订单明细：${oinfo.odesc}</h3>								
								<p>收货人地址:${oinfo.address}</p>
								<p>寄件地址:${oinfo.saddress}</p>
								<p>总价:${oinfo.allamount}</p>
								<p>配送信息:${oinfo.logisticaddress}</p>							
							</div>					
						</div>
					</c:forEach>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>