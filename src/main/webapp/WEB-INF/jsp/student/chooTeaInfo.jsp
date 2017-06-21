<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>选报信息</title>
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
				<li><a
					href="./${sessionScope.pathCode}/chooTea.do">导师选报</a>
				</li>
				<li><a
					href="./${sessionScope.pathCode}/chooTeaInfo.do">选报信息</a>
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
						<th>状态</th>
						<th>操作</th>
						<th></th>
					</tr>
				</thead>
					<tbody>						
							<tr>
								<td class="hidden-xs">${teacher.teaTeacherId}</td>
								<td class="hidden-xs">${teacher.teaName}</td>
							    <c:choose>
                                        <c:when test="${teacher.teaSex eq false }">
                                             <td>
                                             <small>男</small>
                                             </td>
                                        </c:when>
                            			<c:when test="${teacher.teaSex eq true }">
                                				<td>
                                   				 <small>女</small>
                                				</td>
                            			</c:when>
                          		 </c:choose>
                          		 <c:choose>
                          		 	<c:when test="${teacher.teaQualifications==1}">
                          		 		<td><small>助教</small></td>
                          		 	</c:when>
                          		 	<c:when test="${teacher.teaQualifications==2}">
                          		 		<td><small>讲师</small></td>
                          		 	</c:when>
                          		 	<c:when test="${teacher.teaQualifications==3}">
                          		 		<td><small>副教授</small></td>
                          		 	</c:when>
                          		 	<c:when test="${teacher.teaQualifications==4}">
                          		 		<td><small>教授</small></td>
                          		 	</c:when>
                          		 </c:choose>
								 <td class="hidden-xs">${teacher.teaTell }</td>
								 <td class="hidden-xs">${teacher.teaEmail }</td>
								 <c:choose>
								 	<c:when test="${sessionScope.user.stuStatus==1}">
								 		<td><small>待审核</small></td>
								 	</c:when>
								 	<c:when test="${sessionScope.user.stuStatus==2}">
								 		<td><small>成功</small></td>
								 	</c:when>
								 	<c:when test="${sessionScope.user.stuStatus==3}">
								 		<td><small>失败</small></td>
								 	</c:when>
								 </c:choose>
								 <c:choose>
								 	<c:when test="${sessionScope.user.stuStatus==1}">
								 		 <td class="hidden-xs"><a href="./student/giveUpChoose.do">取消选报</a>
								 		 </td>
								 	</c:when>
								 </c:choose>
								
						</tr>
				</tbody>
			</table>
		</div>
		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>
</body>
</html>
