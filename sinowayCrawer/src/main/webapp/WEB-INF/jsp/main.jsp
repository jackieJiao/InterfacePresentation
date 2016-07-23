<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<title>华道征信业务系统</title>
<link rel="stylesheet" type="text/css"
	href="../css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css"
	href="../css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/mystyle.css">
<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
<script type="text/javascript" src="../js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/zTree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/common.js" charset="UTF-8"></script>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/main.ztree.js"
	charset="UTF-8"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/alsc.js"></script> --%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#upload").click(
						function() {
							$("#mainPanle").load("states",
									function(responseTxt, statusTxt, xhr) {
										if (xhr.status == 403) {
											alert("您的权限不够！");
										}
									});
						})
				$("#download").click(
						function() {
							$("#mainPanle").load("download",
									function(responseTxt, statusTxt, xhr) {
										if (xhr.status == 403) {
											alert("您的权限不够！");
										}
									});
						})
			});
	function createFrame(url) {
		var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		return s;
	}
	function logout() {
		$.messager.confirm('提示', '你确定要退出吗?', function(r) {
			if (r) {
				window.location = "logout.action";
			}
		});
	}
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" fit="true" border="true">
		<div data-options="region:'north'" class="topLine">
			<!-- <div class="topLineL">工&nbsp;资&nbsp;管&nbsp;理</div> -->
			<%-- <div class="topLineR">
				当前用户：${sessionScope["user"].account}
				<a href="#" onclick="logout();">退出</a>
			</div> --%>
		</div>
		<div region="south" split="true"
			style="height: 30px; background: #D2E0F2;">
			<div class="footer">征信业务系统&copy;华道征信</div>
		</div>
		<div region="west" hide="true" split="true" title="导航菜单"
			style="width: 210px; background:url(../img/menublue.jpg)  center center no-repeat; background-size:cover;" id="west">
			<!-- <div id="menu" class="ztree"></div> -->
		
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
		<div id="mainPanle" region="center"
			style="background: #eee; overflow-y: hidden"></div>
		<div data-options="region:'east',split:true,collapsed:true"
			title="小工具" style="width: 200px;">
			<div class="easyui-layout" fit="true" border="false">
				<div data-options="region:'north'" style="height: 240px;"
					border="false">
					<div class="easyui-panel" title="日历" border="true"
						iconCls="icon-calendar" fit="true">
						<div id="cc" class="easyui-calendar" border="false" fit="true"></div>
					</div>
				</div>
				<div data-options="region:'center'" style="height: 240px;"
					border="false"></div>
			</div>
		</div>
	</div>
</body>
</html>