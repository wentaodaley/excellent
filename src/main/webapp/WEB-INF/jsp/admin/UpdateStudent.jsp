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
				<li class="active">学生信息修改</li>
			</ol>
			<div class="page-header">
				<h3>
					学生信息 <small>请填写学生详细信息</small>
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
						action="./${sessionScope.pathCode}/studentUp.do" method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">学号</label>

							<div class="col-sm-7">
								<input placeholder="学号" class="form-control" id="stuStudentId"
									name="stuStudentId" value="${student.stuStudentId}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">姓名</label>

							<div class="col-sm-7">
								<input placeholder="姓名" class="form-control" id="stuName"
									name="stuName" value="${student.stuName}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">性别</label>
							<div class="col-sm-7">
								<select class="form-control" id="stuSex" name="stuSex">
									<option value=false
										<c:if test="${student.stuSex == false}">selected="selected"</c:if>>男</option>
									<option value=true
										<c:if test="${student.stuSex == true}">selected="selected"</c:if>>女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">班级</label>
							<div class="col-sm-7">
								<input placeholder="专业" class="form-control" id="stuClass"
									name="stuClass" value="${student.stuClass}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">联系方式</label>

							<div class="col-sm-7">
								<input placeholder="手机号" class="form-control" id="stuTell"
									name="stuTell" value="${student.stuTell}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">QQ</label>
							<div class="col-sm-7">
								<input placeholder="专业" class="form-control" id="stuQQ"
									name="stuQQ" value="${student.stuQQ}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2  control-label">电子邮箱</label>

							<div class="col-sm-7">
								<input placeholder="Email" class="form-control" id="stuEmail"
									name="stuEmail" value="${student.stuEmail}">
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
		</div>
	</div>
	</div>
</body>
</html>
