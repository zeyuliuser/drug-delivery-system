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
<title></title>
</head>
<body>
<form action="com/servlet/ChangeCustomInfo" method="post">
	<table class="responsive-card-table unstriped">
		<thead>
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>用户性别</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td data-label="First Name"><%=session.getAttribute("username") %><input type="text" id="edit1" name="username"></td>
				<td data-label="First Name"><%=session.getAttribute("password") %><input type="text" id="edit2" name="password"></td>
				<td data-label="First Name"><%=session.getAttribute("cgender") %>
				<label id="edit3"><input type="radio" value="man" name="cgender" >man</label>
				<label id="edit4"><input type="radio" value="woman" name="cgender" >woman</label>				
				</td>
			</tr>
			
		</tbody>
	</table>	
	<table class="responsive-card-table unstriped">
		<thead>
			<tr>
				<th>真实姓名</th>
				<th>电话</th>
				</tr>
		</thead>
		<tr>
				<td data-label="First Name" ><%=session.getAttribute("crname") %><input type="text" id="edit5" name="realname"></td>
				<td data-label="First Name" ><%=session.getAttribute("phone") %><input type="text" id="edit6" name="phone"></td>
		</tr>		
	</table>
	<div class="change">
	<button type="button" class="button" id="change">修改</button>
	<button type="submit" class="button"  >保存</button>
	
	</div>
</form>
<script type="text/javascript">
	$("#change").click(function(){
		$("#edit1").css({"display": "inline"});
		$("#edit2").css({"display": "inline"});
		$("#edit3").css({"display": "inline"});
		$("#edit4").css({"display": "inline"});
		$("#edit5").css({"display": "inline"});
		$("#edit6").css({"display": "inline"});
	})
</script>
</body>
</html>