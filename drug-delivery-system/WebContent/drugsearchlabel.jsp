<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%> 

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
<title></title>
</head>
<body>
<%-- <form action="${path}com/servlet/ComstomSearchDrugByClass" method="post"> --%>
<select name="firstclass" id="firstclass">
<option value="化学药品和生物制品" >化学药品和生物制品</option>
<option value="中成药">中成药</option>
<option value="民族药">民族药</option>
</select>
<select name="secondclass" id="secondclass">
</select>
<!-- <button class="button" type="submit">查找</button>
</form>
 -->
<script type="text/javascript">

$("#firstclass").click(function(){
	var classvalue = this.value;

	 $.post(
	"${pageContext.request.contextPath}/com/servlet/SearchForSecondClass",
	{"firstclass" : classvalue},
	function(data){
		$("#secondclass").empty();
		$.each(data,function(i){
			$("#secondclass").append("<option>"+data[i].secondclass+"/"+data[i].thirdclass+"</option>");
			/* value=\"data[i].secondclass\" */
		})
	},
	"json"
	 ) 
})

</script>
</body>
</html>