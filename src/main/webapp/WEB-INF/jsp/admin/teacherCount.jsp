      <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="page" uri="/WEB-INF/pager.tld"%>
<html>
<head>
<title>教师人数设定</title>
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
				<li class="active">教师人数设定</li>
			</ol>
			<div class="page-header">
				<h3>教师人数设定</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>

	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">

				<table class=" table table-hover">
					<thead>
						<tr>
							<th><small>职称</small>
							</th>
							<th width="20%"><small>人数</small></th>
							<th><small>操作</small></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${list}" var="tecount">
							<tr>
								<c:choose>
									<c:when test="${tecount.teaRoleId eq 1 }">
										<td><small>教授</small></td>
										<td><small>${tecount.stuCount}</small></td>
									</c:when>
									<c:when test="${tecount.teaRoleId eq 2 }">
										<td><small>副教授</small></td>
										<td><small>${tecount.stuCount}</small></td>
									</c:when>
									<c:when test="${tecount.teaRoleId eq 3 }">
										<td><small>讲师</small></td>
										<td><small>${tecount.stuCount}</small></td>
									</c:when>
									<c:when test="${tecount.teaRoleId eq 4 }">
										<td><small>助教</small></td>
										<td><small>${tecount.stuCount}</small></td>
									</c:when>
								</c:choose>
								<td><a href="" data-toggle="modal" data-target="#Update" onclick="who(${tecount.teaRoleId})">
										<i class="fa fa-info-circle"></i> <small>设置</small> </a>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</div>


		</div>

	</div>
	<!-- end: TABLE WITH IMAGES PANEL -->

	<!-- Modal -->
	<div class="modal fade" id="Update" tabindex="-1" role="dialog"
		aria-labelledby="pwdT">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="pwdT">设置人数</h4>
				</div>
				<form id="form1" action="./${sessionScope.pathCode}/upteacount.do"
					method="post">
					<div class="modal-body">
					<input type="hidden" name="teaRoleId" id="teaRoleIdVal" value="${tecount.teaRoleId}">
						人数选择： <select name="stuCount" id="stuCount" form="form1">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>

					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="formCount()">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	     function who(teaRoleId){
	         
	         $("#teaRoleIdVal").val(teaRoleId);
	     }
         function formCount(){
             window.location.href="./admin/upteacount.do?teaRoleId="+ $("#teaRoleIdVal").val()+"&stuCount="+$("#stuCount").val();
           }	
	</script>
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
</script>
</body>
</html>
