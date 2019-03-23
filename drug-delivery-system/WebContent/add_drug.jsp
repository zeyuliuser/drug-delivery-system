<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="zcomp_css_js/zcomp.css">
<title></title>
</head>
<body>
	<div class="card-info primary">
	<div class="card-info-content">
	<h4>批量录入（请按规定上传.xls文件）</h4>
		<jsp:include page="fileupload.jsp"></jsp:include>
	</div>
	</div>

	<form action="com/servlet/AddDrugServlet" method="post">
		<div class="form-icons">
			<h4>单个药品录入</h4>
			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-user"></i>
				</span> <input class="input-group-field" type="text" placeholder="药品名称"
					name="dname">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="输入长度/cm"
					name="sizelength">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="输入宽度/cm"
					name="sizewidth">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="输入高度/cm"
					name="sizehigh">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="输入重量/g"
					name="weight">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="药品图片"
					name="dpic">
			</div>

			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-envelope"></i>
				</span> <input class="input-group-field" type="text" placeholder="药品描述"
					name="ddesc">
			</div>


			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-key"></i>
				</span> <input class="input-group-field" type="text" placeholder="药品价格"
					name="price">
			</div>
			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-key"></i>
				</span> <input class="input-group-field" type="text" placeholder="一级分类"
					name="firstclass">
			</div>
			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-key"></i>
				</span> <input class="input-group-field" type="text" placeholder="二级分类"
					name="secondclass">
			</div>
			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-key"></i>
				</span> <input class="input-group-field" type="text" placeholder="三级分类"
					name="thirdclass">
			</div>
			
			<div class="input-group">
				<span class="input-group-label"> <i class="fa fa-key"></i>
				</span> <input class="input-group-field" type="text" placeholder="是否为处方药（TRUE OR FALSE）"
					name="isrx">
			</div>
		</div>

		<button class="button expanded" type="submit">录入</button>
	</form>

</body>
</html>