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
				<div>
					<ul id="collapsing-tabs" class="menu vertical tabs">						
						<li class="tab-title is-active"><a
							href="${path}com/servlet/ShowFAdmin"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">增加管理员</span>
						</a></li>
						<!-- <li class="tab-title"><a href="#"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">库存信息</span>
						</a></li> -->
						<li class="tab-title"><a href="${path}com/servlet/FcompFinish"> <i
								class="large fa fa-hourglass"></i><span
								class="app-dashboard-sidebar-text">已完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/FcompUnGo"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未发货订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/FcompUnFinish"> <i
								class="large fa fa-industry"></i><span
								class="app-dashboard-sidebar-text">未完成订单</span>
						</a></li>
						<li class="tab-title"><a href="${path}com/servlet/FcompUnAccept"> <i
								class="large fa fa-hourglass"></i><span
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
				<div class="tabs-panel content is-active">
					<c:forEach items="${list}" var="admin">
						<div class="card-info primary">

							<div class="card-info-content">
								<h3 class="lead">管理员帐号： ${admin.sname}</h3>
								<p>管理员密码：${admin.spassword}</p>
								<p>分公司地址：${admin.saddress}</p>
								<p>管理员姓名：${admin.srname}</p>
								<p>管理员手机：${admin.sphone}</p>
								<p>管理员性别：${admin.sgender}</p>							
							</div>
						</div>
					</c:forEach>
					<button type="button" class="button" id="add_admin">添加管理员</button>
					<div id="admininfo" style="display:none">
					<form action="${path}com/servlet/AddFAdmin" method="post">
					<input type="text" name="sname" placeholder="请输入用户名">
					<input type="text" name="spassword" placeholder="请输入密码">
					<input type="text" name="srname" placeholder="请输入真实姓名">
					<input type="text" name="saddress" placeholder="请输入分公司地址">
					<input type="text" name="sphone" placeholder="请输入管理员联系号码">
					 <h4>管理员性别</h4>
					<label ><input type="radio" value="man" name="sgender" >man</label>
				    <label ><input type="radio" value="woman" name="sgender" >woman</label> 
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