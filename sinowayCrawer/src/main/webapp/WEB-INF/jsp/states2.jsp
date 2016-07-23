
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的分页标签</title>
<link href="../css/styles1.css" rel="stylesheet" type="text/css"></link>

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/mystyle.css">
	<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../js/common.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/excellentexport.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/states2.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/pagetool1.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/download.js" charset="UTF-8"></script>
</script>
</head>
<body >
   

<!-- this is search block-->
    
    <!-- this is show block -->
	
	<input type="button" onClick="loadData2();" value="获取全部数据">
	<input type="button" onClick="getExcel2();" value="下载全部数据">
	  <div align='center' >	
	<table id='listTable1' class='listTable'>
	<thead>
		<tr>
			<th>手机号</th>
			<th style="width:6%;">姓    名</th>
			<th>证件号码</th>
			<th>平台登录时间</th>
			<th>更新时间</th>
			<th>报告生成时间</th>
			<th>请求时间</th>
			
		</tr>
	</thead>
	<tbody id="list1"></tbody>
	</table>
	<div id="pagecount" ></div>
	</div>
</body>
</html>