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
                <div class="col-lg-10">
                    <h1 class="page-header">Forms</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                          	 职业信息修改
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="teacherUpdateForm">
                                    <input class="hidden" name="teacherId" value="${Bean.date.teacherId}">
                                        <div class="form-group col-lg-6">
                                           <label>教师类型</label>
                                           <div class="form-control">
                                             <label class="radio-inline">
                                                <input type="radio" name="identity" id="optionsRadiosInline1" value="1" <c:if test="${Bean.date.identity =='1'}">checked</c:if> >机构教师
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="identity" id="optionsRadiosInline2" value="2" <c:if test="${Bean.date.identity =='2'}">checked</c:if>>家教教师
                                            </label>
                                            </div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>所属机构（机构教师不能为空）</label>
                                            <input class="form-control" name="organizationId" value="${Bean.date.organizationId}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>是否愿意家教</label>
                                               <div class="form-control">
	                                             <label class="radio-inline">
	                                                <input type="radio" name="ispublic" id="optionsRadiosInline1" value="1" <c:if test="${Bean.date.ispublic =='1'}">checked</c:if> >是
	                                            </label>
	                                            <label class="radio-inline">
	                                                <input type="radio" name="ispublic" id="optionsRadiosInline2" value="2" <c:if test="${Bean.date.ispublic =='2'}">checked</c:if> >否
	                                            </label>
	                                           </div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>学历</label>
                                            <input class="form-control" name="education" value="${Bean.date.education}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                        <div  id="form-teachingTimes"  class="form-group col-lg-6">
                                            <label>毕业学校</label>
                                            <input class="form-control" name="school" value="${Bean.date.school}">
                                        </div>
                                         <div  id="form-teachingTimes"  class="form-group col-lg-6">
                                            <label>专业</label>
                                            <input class="form-control" name="professional" value="${Bean.date.professional}">
                                        </div>
                                        </div>
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
                        <button id="teacherUpdateBtn" type="button" class="btn btn-success">修改</button>
                        <div id="updateTeacherMsg"></div>
                     </div>
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