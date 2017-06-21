<%@ page language="java" import="java.util.*" pageEncoding="UtF-8"%>

<html lang="en" class="no-js">
<head>

<title>批量导入学生信息</title>

<!-- start: META -->
<meta charset="utf-8" />
<link rel="stylesheet"
	href="assets/plugins/dropzone/downloads/css/dropzone.css">
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
<link rel="shortcut icon" href="favicon.ico" />

</head>

<body>

	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a href="./${sessionScope.pathCode}/home.do">
						主页 </a>
				</li>
				<li class="active">批量导入学生信息</li>

			</ol>
			<br>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<!-- end: PAGE HEADER -->
	<!-- start: PAGE CONTENT -->

	<%--<form action="manage/uploadDevice.do" method="post" enctype="multipart/form-data">  
					<input type="file" name="file" /> <input type="submit" value="Submit" />
				</form>  
				--%>
	<div class="col-sm-12">
		<!-- start: DROPZONE PANEL -->

		<div class="panel-body">
			<div class="alert alert-warning">
				请选择要上传的学生信息文档，仅支持符合模板格式的.xls文件</a>
			</div>
			<form action="./admin/uploadStudent.do" class="dropzone"
				id="my-awesome-dropzone" method="post" enctype="multipart/form-data">

			</form>
		</div>

		<!-- end: DROPZONE PANEL -->
	</div>
	<!-- end: PAGE CONTENT-->
	</div>

	<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script src="assets/plugins/dropzone/downloads/dropzone.min.js"></script>
	<script src="assets/js/form-dropzone.js"></script>
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script>
			jQuery(document).ready(function() {
			//	Index.init();
				Dropzone.init();
			});
	


</script>

</body>
</html>
