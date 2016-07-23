$(function() {
	$('#user_list').datagrid({
		url : "getUserData.action?_="+new Date(),
		pagination : true,
		pageSize : 30,
		pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
		rownumbers : true,
		fit : true, // 自动大小
		fitColumns : false, // 自适应列宽
		singleSelect : true, // 是否单选
		idField : 'id',
		toolbar : [ {
			iconCls : 'icon-add',
			text : '新增',
			handler : function(){
				openAdd();
			}
		}, '-' ],
		loadFilter : function(data) {
			return data.data;
		},
		frozenColumns : [[ {
			title : '用户名',
			field : 'userName',
			align : 'center'
		} ]],
		columns : [ [ {
			title : 'id',
			field : 'id',
			hidden : 'true'
		}, {
			title : '员工名称',
			field : 'empInfo',
			align : 'center',
			formatter : function(value, row, index) {
				if (value != null) {
					return value.name;
				} else {
					return '';
				}
			}
		}, {
			title : '角色',
			field : 'roleInfo',
			align : 'center',
			formatter : function(value, row, index) {
				if (value != null) {
					return value.roleName;
				} else {
					return '';
				}
			}
		}, {
			title : '电话号码',
			field : 'telphone',
			align : 'center'
		}, {
			title : '电子邮件',
			field : 'email',
			align : 'center'
		}, {
			title : '最后登录时间',
			field : 'lastLoginTimeStr',
			align : 'center'
		},{
			title : '状态',
			field : 'statuFlag',
			align : 'center',
			formatter : function(value, row, index) {
				if (value == '0') {
					return '正常';
				} else if (value == '1') {
					return '注销';
				} else {
					return '-';
				}
			}
		}, {
			title : '操作',
			field : 'action',
			align : 'center',
			formatter : function(value, row, index) {
				var e = '<a href="#" onClick="openEdit('+row.id+');">编辑</a> ';
				var d = '<a href="#" onClick="delUser('+row.id+',\''+row.userName+'\',\''+row.statuFlag+'\');">注销</a> ';
				var f = '<a href="#" onClick="resetPsw('+row.id+',\''+row.userName+'\');">重置密码</a> ';
				return e + d + f;
			}
		} ] ]
	});
});
