<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>导师对接学生信息</title>
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
				<li class="active">导师管理</li>
				<li class="active">导师对接学生信息</li>
			</ol>
			<div class="page-header">
				<h3>导师对接学生信息</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<c:choose>
		<c:when test="${mag ne null}">
			<div class="alert alert-info"></div>
		</c:when>
	</c:choose>
			<sf:form id="condition"
				action="./${sessionScope.pathCode}/teaAndstuList.do" method="post"
				commandName="teacher">
				<div class="form-group">
					<div class="col-sm-1">
						<label class="control-label"> <small>教师姓名 </small> </label>
					</div>
					<div class="col-sm-3">
						<sf:input path="teaName" cssClass="form-control"/>
					</div>
					<div class="col-sm-1" style="text-align: right;">
						<button type="submit" class="btn btn-primary">检索</button>
					</div>
				</div>
			</sf:form>
			<br>
	<div class="row">
		<div class="col-md-12">
			<!-- start: TABLE WITH IMAGES PANEL -->


			<table class="table table-hover" id="sample-table-1">
				<thead>
					<tr>
						<th>教师工号</th>
						<th>姓名</th>
						<th>教师职称</th>
						<th>联系方式</th>
						<th>人数</th>
						<th>操作</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${teaMap}" var="tea">
						<tr>
							<td class="hidden-xs">${tea.key.teaTeacherId}</td>
							<td class="hidden-xs">${tea.key.teaName}</td>
							<c:choose>
								<c:when test="${tea.key.teaQualifications==1}">
									<td><small>助教</small></td>
								</c:when>
								<c:when test="${tea.key.teaQualifications==2}">
									<td><small>讲师</small></td>
								</c:when>
								<c:when test="${tea.key.teaQualifications==3}">
									<td><small>副教授</small></td>
								</c:when>
								<c:when test="${tea.key.teaQualifications==4}">
									<td><small>教授</small></td>
								</c:when>
							</c:choose>
							<td class="hidden-xs">${tea.key.teaTell }</td>
							<td class="hidden-xs">${tea.value.nowStuCount}</td>
							<td>
								<div class="visible-md visible-lg hidden-sm hidden-xs">
									<a href="./${sessionScope.pathCode}/stuInfo.do?teaId=${tea.key.teaTeacherId}"> <i
										class="fa fa-info-circle"></i> <small>学生信息</small> </a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>