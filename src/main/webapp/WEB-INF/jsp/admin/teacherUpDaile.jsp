<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a>
				</li>
				<li class="active">教师信息</li>
			</ol>
			<div class="page-header">
				<h3>
					教师信息 <small>请填写教师详细信息</small>
				</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<div class="row">
					<form class="form-horizontal"
						action="./${sessionScope.pathCode}/addTea.do" method="post">
						<!--   <input type="hidden" value="${teacher.teaTeacherId}" name="teaTeacherId"> -->
						<div class="form-group">
							<label class="col-sm-2 control-label">工号</label>

							<div class="col-sm-7">
								<input placeholder="工号" class="form-control" id="teaTeacherId"
									name="teaTeacherId" value="${teacher.teaTeacherId}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">姓名</label>

							<div class="col-sm-7">
								<input placeholder="姓名" class="form-control" id="teaName"
									name="teaName" value="${teacher.teaName}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>

							<div class="col-sm-7">
								<select class="form-control" id="teaSex" name="teaSex">
									<option value=false
										<c:if test="${teacher.teaSex}">selected="selected"</c:if>>男</option>
									<option value=true
										<c:if test="${teacher.teaSex}">selected="selected"</c:if>>女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职称</label>
							<div class="col-sm-7">
								<select class="form-control" id="teaQualifications" name="teaQualifications">
									<option value="4"
										<c:if test="${teacher.teaQualifications.index == 4}"> selected="selected"</c:if>>教授</option>
									<option value="3"
										<c:if test="${teacher.teaQualifications.index == 3}"> selected="selected"</c:if>>副教授</option>
									<option value="2"
										<c:if test="${teacher.teaQualifications.index == 2}"> selected="selected"</c:if>>讲师</option>
									<option value="1"
										<c:if test="${teacher.teaQualifications.index == 1}"> selected="selected"</c:if>>助教</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">联系方式</label>
							<div class="col-sm-7">
								<input placeholder="手机号" class="form-control" id="teaTell"
									name="teaTell" value="${teacher.teaTell}">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2  control-label">QQ</label>
							<div class="col-sm-7">
								<input placeholder=teaQQ  class="form-control" id="teaQQ"
									name="teaQQ" value="${teacher.teaQQ}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">电子邮箱</label>
							<div class="col-sm-7">
								<input placeholder=teaEmail class="form-control" id="teaEmail"
									name="teaEmail" value="${teacher.teaEmail}">
							</div>
						</div>
						<div class="form-group"></div>
						<div class="from-group">
							<label class="col-sm-3 control-label" for="form-field-1"></label>
							<div class="col-sm-4">
								<div class="col-sm-6">
									<button type="submit" class="btn btn-blue btn-block">
										<i class="clip-checkmark-2"></i> 保存
									</button>
								</div>
								<div class="col-sm-6">
									<button type="button" class="btn btn-blue btn-block"
										onclick="javascript:history.go(-1);">
										<i class="clip-arrow-right-2 "></i>返回
									</button>
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
			<!-- end: GENERAL PANEL -->
		</div>
	</div>
	</div>
</body>
</html>
