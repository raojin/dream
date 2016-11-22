/*!
 * Start Bootstrap - SB Admin 2 v3.3.7+1 (http://startbootstrap.com/template-overviews/sb-admin-2)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */
$(function() {
	$('#side-menu').metisMenu();
});

// Loads the correct sidebar on window load,
// collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
	$(window)
			.bind(
					"load resize",
					function() {
						var topOffset = 50;
						var width = (this.window.innerWidth > 0) ? this.window.innerWidth
								: this.screen.width;
						if (width < 768) {
							$('div.navbar-collapse').addClass('collapse');
							topOffset = 100; // 2-row-menu
						} else {
							$('div.navbar-collapse').removeClass('collapse');
						}

						var height = ((this.window.innerHeight > 0) ? this.window.innerHeight
								: this.screen.height) - 1;
						height = height - topOffset;
						if (height < 1)
							height = 1;
						if (height > topOffset) {
							$("#page-wrapper").css("min-height",
									(height) + "px");
						}
					});

	var url = window.location;
	// var element = $('ul.nav a').filter(function() {
	// return this.href == url;
	// }).addClass('active').parent().parent().addClass('in').parent();
	var element = $('ul.nav a').filter(function() {
		return this.href == url;
	}).addClass('active').parent();

	while (true) {
		if (element.is('li')) {
			element = element.parent().addClass('in').parent();
		} else {
			break;
		}
	}
});

// 提交提示
function sumbit_sure(val) {
	var gnl = confirm(val);
	if (gnl == true) {
		return true;
	} else {
		return false;
	}
};

$("#loginBtn").click(function() {
	$("#loginForm").submit();
});

$("#courseAddBtn").click(function() {
	$("#courseAddBtn").attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'addCourse',
		data : $("#courseAddForm").serialize(),
		success : function(data) {
			if (data) {
				$("#addMsg").html("添加成功");
			} else {
				$("#addMsg").html("添加失败");
			}
		}
	});
});

$("#courseUpdateBtn").click(function() {
	var su=sumbit_sure("确定修改");
	if(!su){
		return;
	}
	$("#courseUpdateBtn").attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'updateCourse',
		data : $("#courseUpdateForm").serialize(),
		success : function(data) {
			if (data) {
				$("#updateMsg").html("修改成功");
			} else {
				$("#updateMsg").html("修改失败");
			}
		}
	});
});


$(".delBtn").click(function() {
	var id = $(this).data("id");
	var su=sumbit_sure("确定删除？");
	if(!su){
		return;
	}
	$("#delBtn" + id).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'delCourse',
		data :{"courseId":id}, 
		success : function(data) {
			if (data) {
				window.location.reload();
			} else {
				alert("删除失败");
			}
		}
	});
});


$("#teacherAddBtn").click(function(){
	$(this).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'addTeacher',
		data :$("#teacherAddForm").serialize(),
		success : function(data) {
			if(data){
				$("#addTeacherMsg").html("添加成功");
			} else {
				$("#addTeacherMsg").html("添加失败");
			}
		}
	});
});

$("input").click(function(){
	$("#teacherAddBtn").removeAttr({
		"disabled" : "disabled"
	});
});

$(".form-control").focus(function(){
	$(".btn").attr("disabled", false);
	$(".updateMsg").html("");
});


$("#teacherUpdateBtn").click(function(){
	$(this).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'updateTeacher',
		data :$("#teacherUpdateForm").serialize(),
		success : function(data) {
			if(data){
				$("#updateTeacherMsg").html("修改成功");
			} else {
				$("#updateTeacherMsg").html("修改失败");
			}
		}
	});
});

$("#orgUpdateBtn").click(function(){
	$(this).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'updateOrg',
		data :$("#orgUpdateForm").serialize(),
		success : function(data) {
			if(data){
				$("#updateOrgMsg").html("修改成功");
			} else {
				$("#updateOrgMsg").html("修改失败");
			}
		}
	});
});


$("#articleAddBtn").click(function(){
	$(this).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'addArticle',
		data :$("#articleAddForm").serialize(),
		success : function(data) {
			if(data){
				$("#addArticleMsg").html("修改成功");
			} else {
				$("#addArticleMsg").html("修改失败");
			}
		}
	});
});


$(".delArticleBtn").click(function() {
	var id = $(this).data("delId");
	var su=sumbit_sure("确定删除？");
	if(!su){
		return;
	}
	$("#delBtn" + id).attr({
		"disabled" : "disabled"
	});
	$.ajax({
		type : 'post',
		url : 'delArticle',
		data :{"articleId":id}, 
		success : function(data) {
			if (data) {
				alert("删除成功");
				window.location.reload();
			} else {
				alert("删除失败");
			}
		}
	});
});


