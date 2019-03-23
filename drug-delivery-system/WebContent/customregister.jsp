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
<!-- <script type="text/javascript" src="com_js_css/foundation-6.4.2-complete/js/jquery-3.3.1.min.js"></script> -->

<script type="text/javascript" src="login_js/login.js"></script>

 <script>
  $(function(){
	  $("#username").blur(function(){
		  var usernameInput =this.value;
		  $.post(
			/* "${pageContext.request.contextPath}/checkUserServlet", */
			"${pageContext.request.contextPath}/com/servlet/CheckUserServlet",
			
		 	{"username":usernameInput},
		 	
			 function(data){			 	
				var usernameinfo;
				 if(data.isExist){
					usernameinfo ="该用户名已存在";	
				 	$("#usernameinfo").css({"color":"#FF0000"});  
				}else{
					
					usernameinfo ="该用户名可以使用";
			 	    $("#usernameinfo").css({"color":"#00FF00"});
			 	  
				} 
				$("#usernameinfo").html(usernameinfo);
			}, 
			
			"json" 
		  );
		  
	  });
	  
  })
</script>
<script type="text/javascript">
$(function(){
    $("#confirmpassword").blur(function(){
    	var confirminfo="";
    	if($("#password").val()==$("#confirmpassword").val()){
    		confirminfo ="确认密码正确";
    		$("#confirminfo").css({"color":"#00FF00"});
    	}else{
    		confirminfo ="上下密码不一致";
    		 $("#confirminfo").css({"color":"#FF0000"});
    	}
    	$("#confirminfo").html(confirminfo);
    });
   })
</script>

 
<title>注册页面</title>
</head>
<body>
	<div class="hero-full-screen">
		<div class="middle-content-section">
			<!-- form列表 -->
			<div class="translucent-form-overlay">
				<form action="com/servlet/AddCustomServlet" method="post">
					<h3>注册页面</h3>
					<div class="row columns">
						<label>用户名<input type="text" name="username" id="username"
							placeholder="请输入用户名">
							<span id="usernameinfo"></span>
						</label>
					
					</div>
					<div class="row columns">
						<label>密码<input type="password" name="password" id="password"
							placeholder="请输入密码">
						</label>
					</div>
					<div class="row columns">
						<label>确认密码<input type="password" name="confirmpassword" id="confirmpassword"
							placeholder="请确认密码">
							<span id="confirminfo"></span>
						</label>
					</div>
					<div class="row columns">
						<label>用户真实姓名<input type="text" name="realname"
							placeholder="输入真实姓名">
						</label>
					</div>
					<div class="row columns">
						<label>性别 <select name="cgender">
								<option value="man">男</option>
								<option value="woman">女</option>
						</select>
						</label>
					</div>
					
					<div class="row columns">
						<label>电话 <input type="text" name="phone"
							placeholder="请输入电话">
						</label>
					</div>
					<button type="submit" class="primary button expanded search-button">
						注册</button>
						<p class="form-registration-member-signin">
						已经注册用户？ <a href="login.jsp">马上登录</a>
				</form>
			</div>
			<h1>药物配送系统</h1>
		</div>
	</div>

</body>
</html>