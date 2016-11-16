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
                            Basic Form Elements
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="teacherAddForm">
                                     <div class="form-group col-lg-6">
                                           <label>登录账号</label>
                                            <input class="form-control" name="loginName">
                                        </div>
                                         <div class="form-group col-lg-6">
                                           <label>密码</label>
                                            <input type="password" class="form-control" name="password">
                                        </div>
                                     <div class="form-group col-lg-6">
                                           <label>身份</label>
                                           <select id="disabledSelect" class="form-control"  name="identity">
                                                <option value="4">机构教师</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>姓名</label>
                                            <input class="form-control" name="name">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>性别</label>
                                            <div class="form-control">
                                             <label class="radio-inline">
                                                <input type="radio" name="sex" id="optionsRadiosInline1" value="1"
                                               checked>男
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="sex" id="optionsRadiosInline2" value="2"
                                                 >女
                                            </label>
                                            </div>
                                        </div>
                                        <div   class="form-group col-lg-6">
                                            <label>联系电话</label>
                                            <input class="form-control" name="linkPhone">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>邮箱</label>
                                            <input type="email" class="form-control" name="email" >
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>年龄</label>
                                            <input class="form-control" name="age">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>教师类型</label>
                                           <div class="form-control">
                                             <label class="radio-inline">
                                                <input type="radio" name="identity" id="optionsRadiosInline1" value="1" checked>机构教师
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="identity" id="optionsRadiosInline2" value="2">家教教师
                                            </label>
                                            </div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>所属机构（机构教师不能为空）</label>
                                            <input class="form-control" name="organizationId">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>是否愿意家教</label>
                                               <div class="form-control">
	                                             <label class="radio-inline">
	                                                <input type="radio" name="ispublic" id="optionsRadiosInline1" value="1" checked>是
	                                            </label>
	                                            <label class="radio-inline">
	                                                <input type="radio" name="ispublic" id="optionsRadiosInline2" value="2">否
	                                            </label>
	                                           </div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>学历</label>
                                            <input class="form-control" name="education">
                                        </div>
                                        <div class="form-group col-lg-6">
                                        <div  id="form-teachingTimes"  class="form-group col-lg-6">
                                            <label>毕业学校</label>
                                            <input class="form-control" name="school">
                                        </div>
                                         <div  id="form-teachingTimes"  class="form-group col-lg-6">
                                            <label>专业</label>
                                            <input class="form-control" name="professional">
                                        </div>
                                        </div>
                                         <div class="form-group col-lg-6">
                                            <label>个人介绍</label>
                                            <textarea class="form-control" rows="3"  name="introduce" ></textarea>
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
                        <button id="teacherAddBtn" type="button" class="btn btn-success">添加</button>
                        <div id="addTeacherMsg"></div>
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