<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="${path}customview_css_js/customview.css">
<script type="text/javascript" src="${path}com_js_css/foundation-6.4.2-complete/js/vendor/jquery.js"></script>
<title></title>
</head>
<body>
	<c:forEach items="${list}" var="drug">
		<div class="card-info primary">
		<form action="${path}com/servlet/AddDrugCart" method="post">
			<div class="card-info-content">
			<input type="text" name="drugid" style="display:none" value="${drug.did}">
				<h3 class="lead">${drug.dname}</h3>
				<p>${drug.ddesc}</p>
				<img src="${path}${drug.dpic}">
				<p>价格:${drug.price}</p>
					<input class="input-group-field" id="quantity" type="number"  name="quantity" value="0">					
				<button type="submit" class="button" >加入购物车</button>
			</div>
		</form>
		</div>
	</c:forEach>
</body>
</html>