$(function(){
	listdatagrid1 = $('#billall').datagrid({
		url:"getBillCompareSamData.action?_="+new Date(),
		pagination : true,
		pageSize : 30,
		pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
		rownumbers : true,
		
		fitColumns : false, // 自适应列宽
		singleSelect : true, // 是否单选
		idField : 'sn',
		toolbar : [
		{
		   	iconCls : 'icon-print',
   			text : '打印',
   			handler : function(){
				CreateFormPage(
						"print",
						listdatagrid1,
						"getBillAllCompareSamData.action"
						);
   			}
		}, '-' ],
		loadFilter : function(data) {
			return data.data;
		},
		columns:[[
					/* {field:'opt',title:'操作',width:100,align:'center' }, */	    
	                {title:'对账',colspan:1},
	                {title:' ',colspan:10}
	               
	            ],[
		          /* {field:'opt',title:'操作',width:100,align:'center',  
		        	  /* formatter:function(value,rec,index){  
	                        var delete = '<a href="#" mce_href="#" onclick="del(\''+ index +'\')">删除</a> ';  
	                        return delete ;  
	                    }   
	      }, */
			
	      	{   title:'旧手机号',
				field:'basePhonenumber',
				width:'100',
			},{
				title:'新手机号',
				field:'newnumber',
				width:'100'
			},{
				title:'订单号',
				field:'ordersId',
				width:'100'
			},{
				title:'运营商',
				field:'operatorname',
				width:'100'
			},{
				title:'券商',
				field:'brokerName',
				width:'100'
			},{
				title:'当前订单状态',
				field:'curStatus',
				width:'100',
				formatter:function(value){
					 if(value=="0"){return "新增";}
					 if(value=="2"){return "订单";}
					 if(value=="3"){return "取消";}
					 if(value=="4"){return "异常停机";}
					 if(value=="5"){return "销户";}
					 
					 else{return "恢复"}
				 }
			},{
				title:'每月资费',
				field:'monthlypaymentamount',
				width:'100'
			},{
				title:'办理时间',
				field:'curTime',
				width:'100'
			},{
				title:'结算金额',
				field:'billAmount',
				width:'100'
			},{
				title:'赔付金额',
				field:'compenAmount',
				width:'100'
			},{
				title:'结算类型',
				field:'billType',
				width:'100',
				formatter:function(value){
					 if(value=="0"){return "正常结算";}
					 if(value=="1"){return "赔偿结算";}
					 if(value=="2"){return "不结算";}
					 if(value=="3"){return "补充结算";}
					 else{return "订单状态有误"}
				 }
			}
		]]
	
	});
/*});

$(function(){*/
  listdatagrid2 = $('#summary').datagrid({
//	url:"getBillCompareSamSumData.action?_="+new Date(),
	  url:"getBillCompareSamSumData.action",
	pagination : false,
	pageSize : 30,
	pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
	rownumbers : true,
	fitColumns : false, // 自适应列宽
	singleSelect : true, // 是否单选
	idField : 'sn',
	toolbar : [
	{
	   	iconCls : 'icon-print',
  			text : '打印',
  			handler : function(){
				CreateFormPage(
						"print",
						listdatagrid2,
						"getBillAllCompareSamSumData.action"
						);
  			}
	}, '-',{
	   	iconCls : 'icon-print',
			text : '导出为excel',
			handler : function(){
				console.info("this is daochu")
				exportPage(
						"print",
						listdatagrid2,
						"getBillAllCompareSamSumData.action"
						);
  			
			}
}
	],
//	loadFilter : function(data) {
//		return data.data;
//	},
	columns:[[
				/* {field:'opt',title:'操作',width:100,align:'center' }, */	    
                {title:'浙江电信',colspan:1},
                {title:' ',colspan:3}
               
            ],[
		
      	{
			title:'结算类型',
			field:'jslx',
			width:'100'
		},{
			title:'结算数量',
			field:'jssl',
			width:'100'
		},{
			title:'结算金额',
			field:'jsje',
			width:'100'
		},{
			title:'赔付金额',
			field:'pfje',
			width:'100'
		}
	]]
   });
/*});


$(function(){*/
	listdatagrid3 = $('#summaryBroker').datagrid({
		url:"getBillCompareSamBrokerSumData.action?_="+new Date(),
		pagination : false,
		pageSize : 30,
		pageList : [ 30, 40, 50, 60, 70, 80, 90, 100 ],
		rownumbers : true,
		fitColumns : false, // 自适应列宽
		singleSelect : true, // 是否单选
		idField : 'sn',
		toolbar : [
		{
		   	iconCls : 'icon-print',
	  			text : '打印',
	  			handler : function(){
					CreateFormPage(
							"print",
							listdatagrid3,
							"getBillAllCompareSamBrokerSumData.action"
							);
	  			}
		}, '-' ],
		loadFilter : function(data) {
			return data.data;
		},
		columns:[[
					/* {field:'opt',title:'操作',width:100,align:'center' }, */	    
	                {title:'HTTX0002',colspan:1},
	                {title:' ',colspan:3}
	               
	            ],[
			
	      	{
	      		title:'结算类型',
				field:'jslx',
				width:'100'
			},{
				title:'结算数量',
				field:'jssl',
				width:'100'
			},{
				title:'结算金额',
				field:'jsje',
				width:'100'
			},{
				title:'赔付金额',
				field:'pfje',
				width:'100'
			}
		]]
	});
});