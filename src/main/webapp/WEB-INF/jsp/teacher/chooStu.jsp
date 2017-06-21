<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生选报</title>
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
				<li class="active">对接学生信息</li>
				<li class="active">学生选报</li>
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
		<form role="form" class="form-horizontal" action="./${sessionScope.pathCode}/chooStubyName.do" method="post">
		<div class="row">

			<div class="form-group col-sm-4" style="text-align:left;">
				<label class="control-label col-sm-5" for="form-field-1">
					姓名： </label>
				<div class="input-group col-sm-7">

					<input type="text" placeholder="支持模糊查询" id="form-field-1"
						class="form-control " name="stuName">
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
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>班级</th>
						<th>联系方式</th>
						<th>操作</th>
						<th></th>
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${stuList}" var="student">						
							<tr>
								<td class="hidden-xs">${student.stuStudentId}</td>
								<td class="hidden-xs">${student.stuName}</td>
							    <c:choose>
                                        <c:when test="${student.stuSex eq false }">
                                             <td>
                                             <small>男</small>
                                             </td>
                                        </c:when>
                            			<c:when test="${student.stuSex eq true }">
                                				<td>
                                   				 <small>女</small>
                                				</td>
                            			</c:when>
                          		 </c:choose>
								 <td class="hidden-xs">${student.stuClass }</td>
								 <td class="hidden-xs">${student.stuTell }</td>
								 <c:choose>
								 	<c:when test="${student.stuStatus==1}">
								 		<td class="hidden-xs">
											<a href="./teacher/toOperateStu.do?stuStudentId=${student.stuStudentId}&choo=2">同意</a>
											<a href="./${sessionScope.pathCode}/toOperateStu.do?stuStudentId=${student.stuStudentId}&choo=3">取消</a>	
										</td>
								 	</c:when>
								 	<c:when test="${student.stuStatus==2}">
								 		<td class="hidden-xs">
								 			<small>已选</small>
								 		</td>
								 	</c:when>
								 	<c:when test="${student.stuStatus==3}">
								 		<td class="hidden-xs">
								 			<a href="./${sessionScope.pathCode}/toOperateStu.do?stuStudentId=${student.stuStudentId}&choo=1">重置</a>
								 		</td>
								 	</c:when>
								 
								 </c:choose>
								
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>
	
</body>
</html>