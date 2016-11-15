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
                                    <form id="courseUpdateForm" method="post" action="addCourse">
                                    <input class="hidden" name="courseId" value="${Bean.date.courseId}">
                                        <div class="form-group col-lg-6">
                                            <label>辅导课程</label>
                                            <input class="form-control" name="courseIds" value="${Bean.date.courseIds}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>课程类型</label>
                                            <input class="form-control" name="courseType"  value="${Bean.date.courseType}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>授课方式</label>
                                            <input class="form-control" name="teachingWay"  value="${Bean.date.teachingWay}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>授课区域（家教教师时不能为空）</label>
                                            <input class="form-control" name="teachingAddre"  value="${Bean.date.teachingAddre}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>价钱</label>
                                            <input class="form-control" name="price"  value="${Bean.date.price}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                           <!--  <label>时间类型</label>
                                            <input class="form-control" name="timeType"> -->
                                        <div  id="form-teachingTimes"  class="form-group col-lg-6">
                                            <label>授课时间</label>
                                            <input class="form-control" name="teachingTimes"  value="${Bean.date.teachingTimes}">
                                        </div>
                                           <div id="form-timeType" class="form-group col-lg-6">
                                                <label for="disabledSelect">时间类型</label>
                                                <select id="disabledSelect" class="form-control"  name="timeType" >
                                                 	<option value="${Bean.date.timeType}"> <c:choose>
													   <c:when test="${Bean.date.timeType == '1'}">  
													        	时      
													   </c:when>
													    <c:when test="${Bean.date.timeType == '2'}">  
													        	天      
													   </c:when>
													     <c:when test="${Bean.date.timeType == '3'}">  
													        	周     
													   </c:when>
													   <c:otherwise>
													    		月
													   </c:otherwise>
													</c:choose>
													</option>
                                                    <option value="1">时</option>
                                                    <option value="2">天</option>
                                                    <option value="3">周</option>
                                                    <option value="4">月</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>排序（值越大越靠前）</label>
                                            <input class="form-control" name="sort"  value="${Bean.date.sort}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>标题</label>
                                            <input class="form-control" name="title"  value="${Bean.date.title}">
                                        </div>
                                        <div class="form-group col-lg-6">
                                            <label>课程介绍（目录）</label>
                                             <textarea class="form-control" rows="3"  name="introduce"  >${Bean.date.introduce}</textarea>
                                        </div>
                                         <div class="form-group col-lg-6">
                                            <label>状态</label>
                                            <div class="form-control">
                                             <label class="radio-inline">
                                                <input type="radio" name="status" id="beanStatus1" value="1"<c:if test="${Bean.date.status=='1'}"> checked</c:if> />正常
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="status" id="beanStatus2" value="2" <c:if test="${Bean.date.status=='2'}"> checked</c:if>>隐藏
                                            </label>
                                             <label class="radio-inline">
                                                <input type="radio" name="status" id="beanStatus3" value="3"<c:if test="${Bean.date.status=='3'}"> checked</c:if>>已经预约
                                            </label>
                                            </div>
                                           <!--  <input class="form-control" name="status"> -->
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
                        <button id="courseUpdateBtn" type="button" class="btn btn-success">确定</button>
                        <div id="updateMsg"></div>
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