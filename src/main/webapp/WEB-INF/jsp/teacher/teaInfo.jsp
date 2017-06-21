<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个人信息</title>
<link rel="stylesheet" href="assets/plugins/select2/select2.css">
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">个人信息</li>
				</li>
			</ol>
			<div class="page-header">
				<h3>
					个人信息 <small>首次登录必须完善信息后才可执行其他操作!</small>
				</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<c:choose>
		<c:when test="${mag ne null}">
			<div class="alert alert-info"></div>
		</c:when>
	</c:choose>
	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<div class="row">
					<form id="updateTeaInfo" role="form" class="form-horizontal"
						action="./${sessionScope.pathCode}/upteaInfo.do" method="post">
						<input type="hidden" value="${teacher.teaTeacherId}" id="teaTeacherId"
							name="teaTeacherId">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaTeacherId">
								教师工号 </label>
							<div class="col-sm-5">
								<input value="${teacher.teaTeacherId }" type="text" placeholder="教师工号"
									id="teaTeacherId" name="teaTeacherId" class="form-control" readonly="readonly">
							</div>
							<span class="help-inline col-sm-2"> <i
								class="fa fa-info-circle"></i> 不可修改 </span>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaName"> 教师姓名
							</label>
							<div class="col-sm-5">
								<input value="${teacher.teaName }" type="text" id="teaName"
									name="teaName" class="form-control" readonly="readonly">
							</div>
							<span class="help-inline col-sm-2"> <i
								class="fa fa-info-circle"></i> 不可修改 </span>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaSex"> 性别 </label>
							<div class="col-sm-5">
								<select class="form-control search-select" id=""teaSex""
									name=""teaSex"">
									<option value= "false"
										<c:if test="${teacher.teaSex eq false}">
										 selected="selected"</c:if>>男</option>
									<option value= "true"
										<c:if test="${teacher.teaSex eq true}">
										 selected="selected"</c:if>>女</option>
								</select>
							</div>

						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaQualifications">
								教师职称 </label>
							<div class="col-sm-5">
								<select class="form-control search-select" id="teaQualifications"
									name="teaQualifications">

									<option value="4"
										<c:if test="${teacher.teaQualifications == 4}"> selected="selected"</c:if>>教授</option>
									<option value="3"
										<c:if test="${teacher.teaQualifications == 3}"> selected="selected"</c:if>>副教授</option>
									<option value="2"
										<c:if test="${teacher.teaQualifications == 2}"> selected="selected"</c:if>>讲师</option>
									<option value="1"
										<c:if test="${teacher.teaQualifications == 1}"> selected="selected"</c:if>>助教</option>
								</select>
							</div>

						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaQQ"> QQ
							</label>
							<div class="col-sm-5">
								<input value="${teacher.teaQQ }" type="text" id="teaQQ"
									name="teaQQ" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaTell"> 联系方式
							</label>
							<div class="col-sm-5">
								<input value="${teacher.teaTell }" type="text" id="teaTell"
									name="teaTell" class="form-control">
							</div>
							<span class="help-inline col-sm-4"> <i
								class="fa fa-info-circle"></i> 此项为必填项 此项为空将不能执行任何操作 </span>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaEmail">
								电子邮箱 </label>
							<div class="col-sm-5">
								<input type="text" value="${teacher.teaEmail }" id="teaEmail"
									name="teaEmail" class="form-control">
							</div>

						</div>
						<div class="from-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-2" style="text-align:right;">
								<button type="submit" class="btn btn-blue btn-block">
									<i class="clip-checkmark-2"></i> 确认
								</button>
							</div>
							<div class="col-sm-2" style="text-align:right;">
								<button type="reset" class="btn btn-blue btn-block"
									onclick="javascript:history.go(-1);">
									<i class="clip-arrow-right-2 "></i> 返回
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script
		src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script>
	<!-- 3 -->
	<script src="assets/plugins/autosize/jquery.autosize.min.js"></script>
	<!-- 1 -->
	<script src="assets/plugins/select2/select2.min.js"></script>
	<!-- 2 -->
	<script src="assets/js/form-elements.js"></script>
	<!-- 4 -->
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script>
		jQuery(document).ready(function() {
			FormElements.init();
		});
	</script>
</body>
</html>

