
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的分页标签</title>
<link href="../css/styles1.css" rel="stylesheet" type="text/css"></link>

<script type="text/javascript" src="../js/pagetool1.js"></script>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/mystyle.css">
	<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../js/common.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/excellentexport.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/getAllsmry.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/searchby.js" charset="UTF-8"></script>
	
</script>
</head>
<body >
   
  <div align='center' class='divcenter'>
<!-- this is search block-->
    <div id="searchDiv" style="height:100px;">
    	<form id="form_search" action="../test/searchBy" method="post">
						<input id="input1" name="timeItem" class="easyui-combobox" />
						<td class="table-title">开始时间:</td>
						<input id="input2" name="startTime" type="text" class="easyui-datebox" >
						<td class="table-title">结束时间:</td>
						<input id="input3" name="stopTime" type="text" class="easyui-datebox" ><br><br>
						<input id="input4" name="optionItem" class="easyui-combobox" />
						<input id="input5" name="optionValue" type="text"> 操作状态：<input id="input6" name="status" class="easyui-combobox" /><br />
						
			</form>
				<tr>
					<td align="center">
						<a id="btn1" class="easyui-linkbutton mRL10" data-options="iconCls:'icon-search'">查询</a>
						<!-- <a id="reset" href="#" class="easyui-linkbutton mRL10" onClick="search_reset();" data-options="iconCls:'icon-undo'">重置</a> -->
					</td>
				</tr>
    </div> 
    <!-- this is show block -->
    <div id="getdatadiv">
	<table id="querytable" class='queryTable'>
		<tr>
			<td align='left'>
			<input type="button" onClick="loadData();" value="获取全部数据">
			<input type="button" onClick="getExcel();" value="下载全部数据">
			
<!-- 			<a style="text-decoration: none;" download="somedata.xls" href="#" onclick="return ExcellentExport.excel(this, 'listTable', 'Sheet Name Here');"><input type="button" value="导出当前页的数据"></a>
 -->			</td>
	    </tr>
	</table>
	</div>
	
	
	<table id='listTable' class='listTable'>
	<thead>
	
		<tr>
			<th>订单号</th>
			<th style="width:6%;">姓    名</th>
			<th>证件号码</th>
			<th>手机号</th>
			<th>订单访问</th>
			<th>平台登录</th>
			<th>系统登录</th>
			<th>信息申请</th>
			<th>信息生成</th>
			<th>操作状态</th>
		</tr>
	</thead>
	<tbody id="list"></tbody>
	</table>
	<div id="pagecount" ></div>

</body>
</html>