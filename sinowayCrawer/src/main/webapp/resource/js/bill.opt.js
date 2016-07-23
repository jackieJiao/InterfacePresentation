var a_s_f = 0;
var e_s_f = 0;
//新增用户信息
function openAdd() {
	a_s_f = 0;
	$("#add_basePhonenumber").val('');
	$("#add_newnumber").val('');
	$("#add_ordersId").val('');
	$("#add_operatorname").val('');
	$("#add_brokerName").val('');
	$("#add_curStatus").val('');
	$("#add_monthlypaymentamount").val('');
	$("#add_curTimeStr").val('');
	$("#add_billAmount").val('');
	$("#add_compenAmount").val('');
	$("#add_billType").val('');
	$('#bill_add').window('open');
}
function add_ok() {
	$("#add_ok").linkbutton('disable');
//	var flag = check('add');
//	if (flag) {
		if(a_s_f == 0){
			a_s_f++;
			var add_data = $('#form_add').serializeArray();
			$.ajax({
				type : 'POST',
				url : 'addBill.action',
				data : add_data,
				dataType : 'json',
				success : function(data) {
					if (data.msg == "success") {
						$.messager.alert("提示", "保存成功");
						$('#user_add').window('close');
						$('#user_list').datagrid('reload');
					} else if (data.msg == "exist") {
						$.messager.alert("提示", "当前用户名已存在");
						a_s_f = 0;
					} else {
						$.messager.alert("提示", "保存失败");
						a_s_f = 0;
					}
				}
			});
		}
//	}
	$("#add_ok").linkbutton('enable');
}
function add_reset() {
	$.messager.confirm('提示', '是否取消当前新增?', function(r) {
		if (r) {
			$('#bill_add').window('close');
		}
	});
}
function delBill(ordersId) {
	$.messager.confirm('提示', '你确定要删除吗?', function(r) {
		if (r) {
			$.ajax({
				type : 'POST',
				url : "delBill.action?_="+new Date(),
				data : {'ordersId' : ordersId},
				dataType:'json',
				cache : false,
				success : function(data) {
					if (data.msg == "success") {
						$.messager.alert('提示', '删除成功！');
						$('#bill_list').datagrid('reload');
					}
				}
			});
		}
	});
}
function search_search(){
	$('#bill_list').datagrid('load',
			{
		     basePhonenumber : $("#search_basePhonenumber").val(),
			 newnumber : $("#search_newnumber").val(),
			 ordersId : $("#search_ordersId").val(),
			 operatorname : $("#search_operatorname").val(),
			 brokerName : $("#search_brokerName").val()
			});
}
function search_reset(){
	$("#form_search")[0].reset();
}

function openEdit(id){
	e_s_f = 0;
	$.ajax({
		type: "POST",
		url: "getSingleBillData.action?_="+new Date(),
		cache: false,
		data:{"sn":id},
		dataType: "json",
		success:function(data){
			var d= data.data;
			$("#edit_sn").val(d.sn);
			$("#edit_basePhonenumber").val(d.basePhonenumber);
			$("#edit_newnumber").val(d.newnumber);
			$("#edit_ordersId").val(d.ordersId);
			$("#edit_operatorname").val(d.operatorname);
			$("#edit_brokerName").val(d.brokerName);
			$("#edit_curStatus").val(d.curStatus);
			$("#edit_monthlypaymentamount").val(d.monthlypaymentamount);
			$("#edit_curTimeStr").val(d.curTimeStr);
			$("#edit_billAmount").val(d.billAmount);
			$("#edit_compenAmount").val(d.compenAmount);
			$("#edit_billType").val(d.billType);
		},
		error:function(data){
			
		}
	});
	$('#bill_edit').window('open'); 
}

function edit_ok(){
	$("#edit_ok").linkbutton('disable');
	var flag = true;
	//保存信息
	if(flag){
		if(e_s_f == 0){
			e_s_f++;
			var form_edit = $("#form_edit").serializeArray();
			$.ajax({
				type: "POST",
				url: "updateBillData.action",
				cache: false,
				data:form_edit,
				dataType: "json",
				success:function(data){
					$.messager.alert("提示",data.data);
					$('#bill_list').datagrid('reload');
					edit_reset(); 
				}
			});
		}
	}
	$("#edit_ok").linkbutton('enable');
}
function edit_reset(){
/*	$('#form_edit')[0].reset();
	$("#edit_sex").combobox('clear');
	$("#edit_degree").combobox('setValue','请选择');
	$("#edit_entryDate").datebox('clear');
	$("#edit_positionLevel").combobox('setValue','请选择');
	$("#edit_jobLevel").combobox('setValue','请选择');
	$("#edit_enableFlag").combobox('setValue','请选择');*/
	$('#bill_edit').window('close'); 
}