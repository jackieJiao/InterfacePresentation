var a_s_f = 0;
var e_s_f = 0;
//新增用户信息
function openAdd() {
	a_s_f = 0;
	$("#add_userName").val('');
	$("#add_userPsw").val('');
	$("#add_ruserPsw").val('');
	$('#add_empId').combobox({
		url : 'getEmpJson.action?_=' + new Date(),
		valueField : 'id',
		textField : 'name'
	});
	$('#add_roleId').combobox({
		url : 'getRoleJson.action?_=' + new Date(),
		valueField : 'id',
		textField : 'roleName'
	});
	$("#add_empId").combobox('select', '');
	$("#add_roleId").combobox('select', '');
	$("#add_telphone").val('');
	$("#add_email").val('');
	$("#add_remark").val('');
	$('#user_add').window('open');
}

function add_ok() {
	$("#add_ok").linkbutton('disable');
	var flag = check('add');
	if (flag) {
		if(a_s_f == 0){
			a_s_f++;
			var add_data = $('#form_add').serializeArray();
			$.ajax({
				type : 'POST',
				url : 'addUser.action',
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
	}
	$("#add_ok").linkbutton('enable');
}
function add_reset() {
	$.messager.confirm('提示', '是否取消当前新增?', function(r) {
		if (r) {
			$('#user_add').window('close');
		}
	});
}

// 修改用户信息
function openEdit(id) {
	e_s_f = 0;
	$.ajax({
		type:'POST',
		url : "getUser.action",
		data : {"id" : id},
		dataType:'json',
		cache : false,
		success : function(d) {
			data =d.data;
			$("#edit_id").val(data.id);
			$("#edit_userName").val(data.userName);
			$('#edit_empId').combobox({
				url : 'getEmpJson.action?_=' + new Date(),
				valueField : 'id',
				textField : 'name'
			});
			$('#edit_roleId').combobox({
				url : 'getRoleJson.action?_=' + new Date(),
				valueField : 'id',
				textField : 'roleName'
			});
			$("#edit_empId").combobox('select', data.empId);
			$("#edit_roleId").combobox('select', data.roleId);
			$("#edit_telphone").val(data.telphone);
			$("#edit_email").val(data.email);
			$("#edit_statuFlag").combobox('setValue',data.statuFlag);
			$("#edit_remark").val(data.remark);
			$('#user_edit').window('open');
		}
	});
}

function edit_ok() {
	$("#edit_ok").linkbutton('disable');
	var flag = check('edit');
	if (flag) {
		if(e_s_f == 0){
			e_s_f++;
			var edit_data = $('#form_edit').serializeArray();
			$.ajax({
				type : 'POST',
				url : 'editUser.action',
				data : edit_data,
				dataType : 'json',
				success : function(data) {
					if (data.msg == "success") {
						$.messager.alert("提示", "保存成功",null,function(){
							$('#user_edit').window('close');
							$('#user_list').datagrid('reload');
						});
					} else if (data.msg == "nologin") {
						$.messager.alert("提示", "当前登录以过期，请重新登录");
					} else if (data.msg == "exist") {
						$.messager.alert("提示", "当前用户名已存在");
						e_s_f = 0;
					} else {
						$.messager.alert("提示", "保存失败");
						e_s_f = 0;
					}
				}
			});
		}
	}
	$("#edit_ok").linkbutton('enable');
}
function edit_reset() {
	$.messager.confirm('提示', '是否取消当前修改?', function(r) {
		if (r) {
			$('#user_edit').window('close');
		}
	});
}
// 注销用户
function delUser(id, name, c_stat) {
	if(c_stat == 1){
		$.messager.alert('提示','用户已经是注销状态，不允许重复注销！');
	}else{
		$.messager.confirm('提示', '你确定要注销用户  ' + name + ' 吗?', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : "delUser.action",
					data : {'id' : id},
					dataType:'json',
					cache : false,
					success : function(data) {
						if (data.msg == "success") {
							$.messager.alert('提示', '注销成功！');
							$('#user_list').datagrid('reload');
						}
					}
				});
			}
		});
	}
}

function resetPsw(id, name) {
	$.messager.confirm('提示', '是否要重置[' + name + ']的密码?', function(r) {
		if (r) {
			$.ajax({
				type:'POST',
				url : "resetPsw.action",
				data : {"id" : id},
				dataType:'json',
				cache : false,
				success : function(data) {
					if (data.msg == "success") {
						$.messager.alert('提示', '[' + name + ']的密码已被重置为12345678');
					}
				}
			});
		}
	});
}

function psw_ok() {
	var flag = psw_check();
	if (flag) {
		var psw_data = $('#psw_form').serializeArray();
		$.ajax({
			type : 'POST',
			url : 'editPsw.action',
			data : psw_data,
			dataType : 'json',
			success : function(data) {
				if (data.msg == "success") {
					$.messager.alert("提示", "保存成功");
					$('#old_userPsw').val('');
					$('#new_userPsw').val('');
					$('#rep_userPsw').val('');
				} else if (data.msg == "failed") {
					$.messager.alert("提示", "当前密码错误");
				} else {
					$.messager.alert("提示", "保存失败");
				}
			}
		});
	}
}
function psw_reset() {
	$.messager.confirm('提示', '是否取消当前修改?', function(r) {
		if (r) {
			$('#old_userPsw').val('');
			$('#new_userPsw').val('');
			$('#rep_userPsw').val('');
		}
	});
}

function check(prefix) {
	
	if ($("#" + prefix + "_userName").val().replace(/\s/g,'') == '') {
		$.messager.alert('提示', '请填写用户名');
		return false;
	}else if($("#" + prefix + "_userName").val().length > 25){
		$.messager.alert('提示', '用户名不能超出25个字符');
		return false;
	}else{
		$("#" + prefix + "_userName").val($("#" + prefix + "_userName").val().replace(/\\/g,'').replace(/\"/g,'').replace(/\'/g,''));
	}
	if (prefix == 'add') {
		if ($("#add_userPsw").val() == '') {
			$.messager.alert('提示', '请填写密码');
			return false;
		}else if($("#add_userPsw").val().length > 25){
			$.messager.alert('提示', '密码不能超出25个字符');
			return false;
		}
		if ($("#add_ruserPsw").val() == '') {
			$.messager.alert('提示', '请填写确认密码');
			return false;
		}else if($("#add_ruserPsw").val().length > 25){
			$.messager.alert('提示', '确认密码不能超出25个字符');
			return false;
		}
		if ($("#add_userPsw").val() != $("#add_ruserPsw").val()) {
			$.messager.alert('提示', '密码不一致');
			return false;
		}
	}
	if ($("#" + prefix + "_roleId").combobox('getValue') == '') {
		$.messager.alert('提示', '请选择角色');
		return false;
	}
	if ($("#" + prefix + "_telphone").val() != ''
			&& (!$.isNumeric($("#" + prefix + "_telphone").val()) || $(
					"#" + prefix + "_telphone").val().length > 11)) {
		$.messager.alert('提示', '电话号码格式错误');
		return false;
	}
	if ($("#" + prefix + "_email").val() != '') {
		var reg = /^([a-zA-Z0-9]+[_|\_\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_\_\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}([\.][a-zA-Z]{2})?$/;
		if (!reg.test($("#" + prefix + "_email").val())) {
			$.messager.alert('提示', '邮箱格式错误');
			return false;
		}
	}
	if ($("#" + prefix + "_remark").val() != '' && $("#" + prefix + "_remark").val().length > 100) {
		$.messager.alert('提示', '备注内容超出100个汉字！');
		return false;
	}
	return true;
}
function psw_check() {
	if ($("#old_userPsw").val() == '') {
		$.messager.alert('提示', '请填写当前密码');
		return false;
	}else if($("#old_userPsw").val().length > 25){
		$.messager.alert('提示', '前密码不能超出25个字符');
	}
	if ($("#new_userPsw").val() == '') {
		$.messager.alert('提示', '请填写新密码');
		return false;
	} else if ($("#new_userPsw").val().length > 25) {
		$.messager.alert('提示', '密码长度不能超过25个字符！');
		return false;
	}
	if ($("#rep_userPsw").val() == '') {
		$.messager.alert('提示', '请填写确认密码');
		return false;
	}
	if ($("#new_userPsw").val() != $("#rep_userPsw").val()) {
		$.messager.alert('提示', '密码不一致');
		return false;
	}
	return true;
}