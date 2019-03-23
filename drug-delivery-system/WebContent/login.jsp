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
<link type="text/css" rel="stylesheet" href="login_css/login.css">
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

<script type="text/javascript" src="login_js/login.js"></script>
<title>登录页面</title>
</head>
<body>
	<div class="hero-full-screen">
		<div class="middle-content-section">
			<!-- form列表 -->
			<div class="translucent-form-overlay">
				<form action="com/servlet/UserConfirmServlet" method="post">
					<h3>登录页面</h3>
					<div class="row columns">
						<label>登录名 <input type="text" name="username"
							placeholder="请输入登录名">
						</label>
					</div>
					<div class="row columns">
						<label>密码<input type="password" name="password"
							placeholder="请输入密码">
						</label>
					</div>
					<div class="row columns">
						<label>登录角色 
						<select name="choose">
								<option  value="custom">顾客</option>
								<option  value="zcomp">药房总公司</option>
								<option  value="fcomp">药房分公司</option>
								<option  value="logistic">配送中心</option>
						</select>
						</label>
					</div>
					<button type="submit" class="primary button expanded search-button">
						登录</button>
					<p class="form-registration-member-signin">
						顾客还没有注册？ <a href="customregister.jsp">马上注册</a>
					</p>
				</form>
			</div>
			<!--到这  -->
			<br>
			<h1>药物配送系统</h1>
		</div>
		
	</div>

</body>
</html>