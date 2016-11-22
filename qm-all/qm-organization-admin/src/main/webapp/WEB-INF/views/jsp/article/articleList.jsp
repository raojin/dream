<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>全民督教</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
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
    <link href="vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">

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
<div class="ch-container col-lg-10">
    <div class="row">
      <!-- 菜单 s -->
	  <jsp:include page="/util/indexleft.jsp"></jsp:include>
	  <!-- 菜单 e -->
       <div id="wrapper" class="col-lg-10">
	      <div id="page-wrapper" class="col-lg-9">
                      <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	动态列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>标题</th>
                                        <th>作者</th>
                                        <th>摘要</th>
                                        <th>状态</th>
                                        <th>内容</th>
                                        <th>排序</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${BeanList.date.data}" var="articleBO">
                                    <tr class="gradeU">
                                    	<td class="hidden">${articleBO.articleId}</td>
                                        <td>${articleBO.title}</td>
                                        <td>${articleBO.author}</td>
                                        <td>${articleBO.digest}</td>
                                        <td>${articleBO.status}</td>
                                        <td class="center">${articleBO.content}</td>
                                        <td class="center">${articleBO.sort}</td>
                                        <td class="center">${articleBO.gmtCreate}</td>
                                        <td class="center">
                                        <a href="toUpdateArticle?articleId=${articleBO.articleId}">更新</a>/
                                        <button type="button" class="delArticleBtn btn btn-danger" data-del-id="${articleBO.articleId}">删除
                                        </button>
                                        </td>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
		</div>
    	<!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->
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