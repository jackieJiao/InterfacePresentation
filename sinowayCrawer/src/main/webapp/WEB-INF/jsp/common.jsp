<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>main</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>

<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/main.css" />
<script>

	$(document).ready(
			function() {
				$("#upload").click(
						function() {
							$("#container").load("states",
									function(responseTxt, statusTxt, xhr) {
										if (xhr.status == 403) {
											alert("您的权限不够！");
										}
									});
						})
				$("#download").click(
						function() {
							$("#container").load("download",
									function(responseTxt, statusTxt, xhr) {
										if (xhr.status == 403) {
											alert("您的权限不够！");
										}
									});
						})
			});
	
	

</script>

</head>

<body>
	<div id="bar">
		<img src="../img/logo.png" />
		<!-- <p>宝马公司自己的广告标语位置</p> -->
	</div>
	<!--menu -->
	<div id="menu">
	<div id="menu_select">功能列表</div>
		<div>
			<sec:authorize access="hasRole('ROLE_USER')">
					<a id="upload" class="m_upload" href="javascript:void(0);" style="text-decoration: none;"><div
							style="font-size: 20px; width:60%;margin:0 auto;margin-top:50px;background-color:#fff; box-shadow:1px 1px 1px 1px #95B8E7;;border-radius:15px;line-height:30px;text-align:center;" >查&nbsp;&nbsp;看</div></a>
				</sec:authorize>
		</div>
		<div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a id="download" class="m_upload" href="javascript:void(0);" style="text-decoration: none;"><div
							style="font-size: 20px; width:60%;margin:0 auto;margin-top:50px;background-color:#fff; box-shadow:1px 1px 1px 1px #95B8E7;;border-radius:15px;line-height:30px;text-align:center;" ">下&nbsp;&nbsp;载</div></a>
				</sec:authorize>
		</div>

	</div>
	<!--container -->
	<div id="container">
		<div>
			welcome user :
			<sec:authentication property="name" />
			!
		</div>
	</div>
	<div id="line"></div>
	<!--footer-->
	    <div id="foot">
	               <p id="hp1">北京华道征信有限公司 </p>		
		
	              <p id="hp2">地址：北京市朝阳区通惠河畔产业园1131号      电话：4000034020</p>
	
		            <p>©2014 华道征信京&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ICP备14051116号</p>
	
	    </div>
</body>
</html>