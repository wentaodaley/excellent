<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生信息</title>
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
				<li class="active">学生选报信息</li>
				<li class="active">学生信息</li>
			</ol>
			<div class="page-header">
				<h3>
					学生信息 
				</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
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
					</tr>
				</thead>
					<tbody>
 						<c:forEach items="${stuList}" var="stu">						
							<tr>
								<td class="hidden-xs">${stu.stuStudentId}</td>
								<td class="hidden-xs">${stu.stuName}</td>
							    <c:choose>
                                        <c:when test="${stu.stuSex eq false }">
                                             <td>
                                             <small>男</small>
                                             </td>
                                        </c:when>
                            			<c:when test="${stu.stuSex eq true }">
                                				<td>
                                   				 <small>女</small>
                                				</td>
                            			</c:when>
                          		 </c:choose>
								 <td class="hidden-xs">${stu.stuClass }</td>
								 <td class="hidden-xs">${stu.stuTell }</td>
							</tr>
					 </c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>