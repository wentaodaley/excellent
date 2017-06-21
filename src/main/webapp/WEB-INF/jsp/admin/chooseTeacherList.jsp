<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="page" uri="/WEB-INF/pager.tld"%>

<html>
<head>
<title>教师基本信息</title>
<link rel="stylesheet" href="assets/plugins/select2/select2.css">
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
				<li class="active">教师基本信息</li>
			</ol>
			<div class="page-header">
				<h3>教师基本信息</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<sf:form id="condition"
		action="./${sessionScope.pathCode}/allTeaList.do" method="post"
		commandName="teacher">
		<div class="form-group">
			<div class="col-sm-1">
				<label class="control-label"> 教师姓名 </label>
			</div>
			<div class="col-sm-3">
			<!-- 	<sf:select cssClass="form-control search-select" path="teaTeacherId">
					<sf:option value="" label="全部" />
					<sf:options items="${teaList}" itemValue="teaTeacherId"
						itemLabel="teaName" /> -->
						<sf:input path="teaName" cssClass="form-control"/>
				</sf:select>
			</div>

			<div class="col-sm-1" style="text-align: right;">
				<button type="submit" class="btn btn-primary">检索</button>
			</div>
			<div class="col-sm-1 ">
				<a class="btn btn-primary"
					href="./${sessionScope.pathCode}/addTeacher.do"> <span><i
						class=" clip-plus-circle "></i> 添加教师</span> </a>
			</div>
		</div>

	</sf:form>

	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<table class="table  table-hover">
					<thead>
						<tr>
							<th><small>编号</small></th>
							<th><small>教师工号</small></th>
							<th><small>姓名</small></th>
							<th><small>性别</small></th>
							<th><small>教师职称</small></th>
							<th><small>联系方式</small></th>
							<th><small>操作</small></th>
						</tr>
					</thead>
					<c:forEach items="${teaList}" var="teacher" varStatus="status">
						<tbody>

							<tr>
								<small class="hidden" name="teaTeacherId">${teacher.teaTeacherId}</small>
								<td>${status.count}</td>
								<td><small>${teacher.teaTeacherId}</small>
								<td><small>${teacher.teaName}</small></td>
								<c:choose>
									<c:when test="${teacher.teaSex eq false}">
										<td><small>男</small></td>
									</c:when>
									<c:when test="${teacher.teaSex eq true}">
										<td><small>女</small></td>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${teacher.teaQualifications eq 0}">
										<td><small>无</small></td>
									</c:when>
									<c:when test="${teacher.teaQualifications eq 1}">
										<td><small>助教</small></td>
									</c:when>
									<c:when test="${teacher.teaQualifications eq 2}">
										<td><small>讲师</small></td>
									</c:when>
									<c:when test="${teacher.teaQualifications eq 3}">
										<td><small>副教授</small></td>
									</c:when>
									<c:when test="${teacher.teaQualifications eq 4}">
										<td><small>教授</small></td>
									</c:when>
								</c:choose>
								<td><small>${teacher.teaTell }</small></td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs">
									<a href="./${sessionScope.pathCode}/chooseTeacher.do?id=${teacher.teaTeacherId}">
											<i class="fa fa-info-circle"></i> <small>取消选择</small> </a> 
										<a href="./${sessionScope.pathCode}/UpdateTeacher.do?id=${teacher.teaTeacherId}">
											<i class="fa fa-info-circle"></i> <small>修改</small> </a> 
										<a
											href="javaScript:void(0);" data-toggle="modal"
											data-target="#pwdM"> <i class="fa fa-info-circle"></i> 
											<small>重置密码</small> </a>
									</div>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="form-group">
					<label class="col-sm-8 "> </label>
					<div class="col-sm-4" style="text-align: right; height: 40px">
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}"
							totalCount="${totalCount}" curPage="${pageNum}"
							formId="condition" />
					</div>


				</div>

			</div>

		</div>
		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>


	<!-- Modal -->
	<div class="modal fade" id="pwdM" tabindex="-1" role="dialog"
		aria-labelledby="pwdT">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="pwdT">重置密码</h4>
				</div>
				<div class="modal-body">
					初始密码:123456<br />
					<p></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>

	</div>

	</div>
	<!-- 添加教师信息 -->
	<!--
	<div class="modal fade" id="JoinStuGroupModal" tabindex="-1"
		 role="dialog" aria-labelledby="alterModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h5 class="modal-title" id="alterModalLabel">添加新教师</h5>
				</div>
				<div class="modal-body">
					<form class="form-horizontal"
						  action="./${sessionScope.pathCode}/AddTeacher.do" method="post">

						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">工号</label>

							<div class="col-sm-8">
								<input placeholder="工号" class="form-control" id="teaTeacherId"
									   name="teaTeacherId">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">姓名</label>

							<div class="col-sm-8">
								<input placeholder="姓名" class="form-control" id="teaName"
									   name="teaName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">性别</label>

							<div class="col-sm-8">
								<select class="form-control" id="teaSex" name="teaSex">
									<option value="false">男</option>
									<option value="true">女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">职称</label>

							<div class="col-sm-8">
								<select class="form-control" id="teaQualifications"
										name="teaQualifications">
									<option value="4">教授</option>
									<option value="3">副教授</option>
									<option value="2">讲师</option>
									<option value="1">助教</option>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">联系方式</label>

							<div class="col-sm-8">
								<input placeholder="手机号" class="form-control" id="teaTell"
									   name="teaTell">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">办公电话</label>

							<div class="col-sm-8">
								<input placeholder="办公电话" class="form-control"
									   id="teaOfficeTell" name="teaOfficeTell">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">电子邮箱</label>

							<div class="col-sm-8">
								<input placeholder="Email" class="form-control" id="teaEmail"
									   name="teaEmail">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-offset-1 control-label">QQ</label>

							<div class="col-sm-8">
								<input placeholder="QQ" class="form-control" id="teaQQ"
									   name="teaQQ">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
				</form>
			</div>
		</div>
	</div> -->
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
    jQuery(document).ready(function () {
        FormElements.init();
    });

    $('#pwdM').on('show.bs.modal', function (e) {
        var $p = $(e.relatedTarget).parent().parent().parent().parent().parent().parent();
        var $stu = $p.find(".teaTeacherId").html();
        alert($stu+"*****************************");
        var modal = $(this);
        $.ajax({
            type: "post",
            url: "./${sessionScope.pathCode}/restartPwd.do",
            data: {
                stuStudentId: $stu
                
            },
            success: function (data) {
                modal.find(".modal-body p").html(data.mag);
            }
        })
    });

</script>
</body>
</html>

