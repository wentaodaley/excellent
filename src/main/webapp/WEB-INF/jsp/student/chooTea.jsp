<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" uri="/WEB-INF/pager.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>导师选报</title>
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
				<li class="active">导师选报</li>
				<li class="active">导师基本信息</li>
				</li>
			</ol>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<c:choose>
		<c:when test="${mag ne null}">
			<div class="alert alert-info"></div>
		</c:when>
	</c:choose>
	<div class="page-header">
	  <h3>
		<form role="form" class="form-horizontal" action="./${sessionScope.pathCode}/chooTeaByName.do" method="post">
		<div class="row">

			<div class="form-group col-sm-4" style="text-align:left;">
				<label class="control-label col-sm-5" for="form-field-1">
					姓名： </label>
				<div class="input-group col-sm-7">

					<input type="text" placeholder="支持模糊查询" id="form-field-1"
						class="form-control " name="teaName">
				</div>
			</div>
			<div class="form-group col-sm-2"><input type="submit" value="查询" class="btn btn-primary" /></div>
		</div>
	    </form>
	  </h3>
	</div>
	<div class="row">
		<div class="col-md-12">
			<!-- start: TABLE WITH IMAGES PANEL -->


			<table class="table table-hover" id="sample-table-1">
				<thead>
					<tr>
						<th>教师工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>教师职称</th>
						<th>联系方式</th>
						<th>电子邮箱</th>
						<th>选报状态</th>
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
                                        <c:when test="${tea.key.teaSex eq false }">
                                             <td>
                                             <small>男</small>
                                             </td>
                                        </c:when>
                            			<c:when test="${tea.key.teaSex eq true }">
                                				<td>
                                   				 <small>女</small>
                                				</td>
                            			</c:when>
                          		 </c:choose>
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
								 <td class="hidden-xs">${tea.key.teaEmail }</td>
								 <c:choose>
								 	<c:when test="${tea.value.stuCount>tea.value.nowStuCount}">
								 		<td><small>未满</small></td>
								 	</c:when>
								 	<c:otherwise>
								 		<td><small>已满</small></td>
								 	</c:otherwise>
								 </c:choose>
                          		<c:choose>
                          			<c:when test="${sessionScope.user.stuStatus==3 ||sessionScope.user.stuStatus==0}">
                          			<c:choose>
								 		<c:when test="${tea.value.stuCount>tea.value.nowStuCount}">
								 		<td class="hidden-xs">
											<a href="./${sessionScope.pathCode}/makeTea.do?teaTeacherId=${tea.key.teaTeacherId}">选报</a>
										</td>
								 		</c:when>
								 		<c:otherwise>
								 			<td><small>不能选报</small></td>
								 		</c:otherwise>
								 	</c:choose>
								 	</c:when>
								 	<c:otherwise>
								 		<td><small>不能进行操作</small></td>
								 	</c:otherwise>
								 </c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>