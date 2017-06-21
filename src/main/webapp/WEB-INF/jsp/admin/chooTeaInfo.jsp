<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
					href="./${sessionScope.pathCode}/chooTeaInfo.do">学生选报信息</a>
				</li>
			</ol>
			<div class="page-header">
            <h3>学生选报信息</h3>
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
						<th>联系方式</th>
						<th>选报状态</th>
						<th>选报导师</th>
						<!--<th>操作</th>-->
					</tr>
				</thead>
				
				<c:forEach items="${stuList}" var="stu" varStatus="status">
                    <tbody>
                    <tr>
                        <td>
                            <small class="stuId">${stu.stuStudentId}</small>
                        </td>
                        <td>
                            <small>${stu.stuName}</small>
                        </td>
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
                         <td>
                            <small class="stuClass">${stu.stuTell}</small>
                        </td>
                        <c:choose>
                        	<c:when test="${stu.stuStatus==0}">
                        		<td>
                                    <small>未选报</small>
                                </td>
                        	</c:when>
                        	<c:when test="${stu.stuStatus==1}">
                        		<td>
                                    <small>待审核</small>
                                </td>
                        	</c:when>
                        	<c:when test="${stu.stuStatus==2}">
                        		<td>
                                    <small>选报成功</small>
                                </td>
                        	</c:when>
                        	<c:when test="${stu.stuStatus==3}">
                        		<td>
                                    <small>选报失败</small>
                                </td>
                        	</c:when>
                        </c:choose>
                        <td>
                            <small>${stu.teacher.teaName}</small>
                         </td>
                         <!-- <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs">
										<a href="./${sessionScope.pathCode}/#.do?id=${student.stuStudentId}">
                                    <i class="fa fa-info-circle"></i>
                                    <small>分配</small>
								</div>
					     </td> -->
                    </tr>
                    </tbody>
                </c:forEach>
			</table>
		</div>
		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>
</body>
</html>
