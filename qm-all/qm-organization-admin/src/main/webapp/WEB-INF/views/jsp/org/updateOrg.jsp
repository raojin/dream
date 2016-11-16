<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>全民督教</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.css" rel="stylesheet"
	type="text/css">

<!-- <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
	<!-- 头部 s -->
	<jsp:include page="/util/indexheader.jsp"></jsp:include>
	<!-- 头部 e -->
	<div class="ch-container col-lg-11">
		<div class="row">
			<!-- 菜单 s -->
			<jsp:include page="/util/indexleft.jsp"></jsp:include>
			<!-- 菜单 e -->
			<div id="wrapper" class="col-lg-10">
				<div id="page-wrapper" class="col-lg-9">
					<div class="row">
						<div class="col-lg-10">
							<h1 class="page-header">Forms</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">机构信息修改</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-lg-12">
											<form id="orgUpdateForm">
											<input class="hidden" name="organizationId" value="${Bean.date.organizationId}">
												<div class="form-group col-lg-6">
													<label>首图</label> <img src="${Bean.date.image}"
														class="img-thumbnail" alt="Responsive image">
												</div>
												<div class="form-group col-lg-6">
													<label>机构名称</label> <input class="form-control" name="name"
														value="${Bean.date.name}">
												</div>
												<div class="form-group col-lg-6">
													<label>机构详细地址</label> <input class="form-control"
														name="addrName" value="${Bean.date.addrName}">
												</div>
												<div class="form-group col-lg-6">
													<label>排序</label> <input class="form-control" name="sort"
														value="${Bean.date.sort}">
												</div>
												<div class="form-group col-lg-6">
													<label>联系电话</label> <input class="form-control"
														name="phone" value="${Bean.date.phone}">
												</div>
												<div class="form-group col-lg-6">
													<label>负责人姓名</label> <input class="form-control"
														value="${Bean.date.userName}" disabled>
												</div>
												<div class="form-group col-lg-6">
													<label>标题</label> <input class="form-control"
														value="${Bean.date.title}">
												</div>
												<div class="form-group col-lg-6">
													<label>机构介绍</label>
													<textarea class="form-control" rows="3" name="detail">${Bean.date.detail}</textarea>
												</div>
												<div class="form-group col-lg-6">
													<label>标签</label> <input class="form-control"
														value="<c:if test="${Bean.date.tags =='1' }">精品</c:if><c:if test="${Bean.date.tags =='2' }">普通</c:if> "
														disabled>
												</div>
												<c:if test="${Bean.date.status =='2' }">
													<div class="form-group col-lg-6">
														<label>状态</label>
														<div style="color: red">审核通过</div>
													</div>
												</c:if>
											</form>
										</div>
										<!-- /.col-lg-6 (nested) -->
									</div>
									<!-- /.row (nested) -->
								</div>
								<!-- /.panel-body -->
							</div>
							<!-- /.panel -->
							<div class="form-group col-lg-6">
								<button id="orgUpdateBtn" type="button" class="btn btn-success">修改</button>
								<div id="updateOrgMsg" class="updateMsg"></div>
							</div>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /#page-wrapper -->
			</div>
			<!-- content ends -->
		</div>
		<!--/#content.col-md-0-->
	</div>
	<!--/fluid-row-->
	<hr>
	<!-- 头部 s -->
	<div class="col-lg-10">
		<jsp:include page="/util/footer.jsp"></jsp:include>
	</div>
	<!-- 头部 e -->


	<!-- jQuery -->
	<script src="vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="vendor/raphael/raphael.min.js"></script>
	<script src="vendor/morrisjs/morris.min.js"></script>
	<script src="data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="dist/js/sb-admin-2.js"></script>


</body>
</html>