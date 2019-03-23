<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="zcomp_css_js/zcomp.css">
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
<title>订单信息</title>
</head>
<body>
	<form action="com/servlet/SubmitOrder" method="post"
		enctype="multipart/form-data">
		<h4>详细信息</h4>
		<div class="input-group">
			<span class="input-group-label"> <i class="fa fa-user"></i>
			</span> <input class="input-group-field" type="text" placeholder="输入地址"
				name="address">
		</div>
		<div class="input-group">
			<span class="input-group-label"> <i class="fa fa-envelope"></i>
			</span> <input class="input-group-field" type="text" placeholder="输入电话"
				name="phone">
		</div>
		<div style="display: none" id="uploadrx">
			<h4 style="color: red">系统检测到您的订单内有处方药，请上传医生药方并等待审核</h4>
			上传药方照片: <input type="file" name="upfile"><br /> <br />
		</div>

		<button class="button expanded" type="submit">提交</button>
		<a href="com/servlet/ShowCartServlet"><button
				class="button expanded" type="button" class="warning">取消</button></a>

	</form>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.post(
											"${pageContext.request.contextPath}/com/servlet/CheckUserIsrx",
											function(data) {
												if (data.isRxInCart) {
													$("#uploadrx").css({
														"display" : "inline"
													});
												}
											}, "json")
						})
	</script>
</body>
</html>