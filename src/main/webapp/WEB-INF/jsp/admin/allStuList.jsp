<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="page" uri="/WEB-INF/pager.tld"%>
<html>
<head>
<title>学生基本信息</title>
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
				<li class="active">学生基本信息</li>
			</ol>
			<div class="page-header">
				<h3>学生基本信息</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<sf:form id="condition"
		action="./${sessionScope.pathCode}/allStulist.do" method="post"
		commandName="student">
		<div class="form-group">
			<div class="col-sm-1">
				<label class="control-label"> 学生姓名 </label>
			</div>
			<div class="col-sm-3">
						<sf:input path="stuName" cssClass="form-control"/>
			</div>

			<div class="col-sm-1" style="text-align: right;">
				<button type="submit" class="btn btn-primary">检索</button>
			</div>
			<div class="col-sm-1 ">
				<a class="btn btn-primary"
					href="./${sessionScope.pathCode}/addStu.do"> <span><i
						class=" clip-plus-circle "></i> 添加学生</span> </a>
			</div>
		</div>

	</sf:form>
	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">

				<table class=" table table-hover">
					<thead>
						<tr>
							<th><small>编号</small></th>
							<th width="20%"><small>学号</small></th>
							<th><small>姓名</small></th>
							<th><small>性别</small></th>
							<th><small>班级</small></th>
							<th><small>操作</small></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stuList}" var="student" varStatus="status">

							<tr>
								<td>${status.count}</td>
								<td><small class="stuId">${student.stuStudentId}</small></td>
								<td><small>${student.stuName}</small></td>
								<c:choose>
									<c:when test="${student.stuSex eq false }">
										<td><small>男</small></td>
									</c:when>
									<c:when test="${student.stuSex eq true }">
										<td><small>女</small></td>
									</c:when>
								</c:choose>
								<td><small class="stuClass">${student.stuClass}</small></td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs">
										<a
											href="./${sessionScope.pathCode}/UpdateStudent.do?id=${student.stuStudentId}">
											<i class="fa fa-info-circle"></i> <small>修改</small>
										</a>
										<!-- <a href="javaScript:void(0);" data-toggle="modal" data-target="#pwdM">
                                    <i class="fa fa-info-circle"></i>
                                    <small>重置密码</small>
                                </a> -->
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<div class="center" style="text-align: right; height: 40px">
					<page:createPager pageSize="${pageSize}" totalPage="${totalPage}"
						totalCount="${totalCount}" curPage="${pageNum}" formId="condition" />
				</div>
			</div>


		</div>

	</div>
	<!-- end: TABLE WITH IMAGES PANEL -->

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
         var $p = $(e.relatedTarget).parent().parent().parent().parent().parent();
        var $stu = $p.find(".stuId").html();
        var modal = $(this);
        $.ajax({
            type: "post",
            url: "./${sessionScope.pathCode}/restartPwd.do",
            data: {
                stuId: $stu
            },
            success: function (data) {
                modal.find(".modal-body p").html(data.mag);
            }
        })
    });
</script>
</body>
</html>
