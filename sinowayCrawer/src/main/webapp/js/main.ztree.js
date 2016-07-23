var setting = {
		data: {
			key:{
				name:"menuName"
			},
			simpleData: {
				enable: true,
				idKey:"id",
				pIdKey:"parentId"
			}
		},
		callback:{
			onClick:function(event,treeid,treeNode,clickFlag){
				if(!treeNode.isParent){
					$.ajax({
						type: "POST",
						url:'checkSession.action',
						cache: false,
						dataType:'json',
						success:function(data){
							if(data.msg=='success'){
								var subtitle = treeNode.menuName;
								if (!$('#tabs').tabs('exists', subtitle)) {
									$('#tabs').tabs('add', {
										title: subtitle,
										content: createFrame(treeNode.menuPath),
										closable: true,
									});
								} else {
									$('#tabs').tabs('select', subtitle);
								}
							}else{
								$.messager.alert("提示", "您好，您当前的登录已超时，请重新登录！", null, function(){
									window.location.href="login.jsp";
								});
							}
						}
					});
					
				}
			}
		}
		
	};
/*$(document).ready(function(){
	var data = {"data":[{"id":25,"parentId":1,"menuName":"对账总表","menuPath":"openBillJsp.action","remark":"","subMenuInfoList":[]},{"id":26,"parentId":1,"menuName":"华道有运营商没有的数据","menuPath":"openBillSinohasJsp.action","remark":"","subMenuInfoList":[]},{"id":27,"parentId":1,"menuName":"运营商有华道没有的数据","menuPath":"openBillSinoNotJsp.action","remark":"","subMenuInfoList":[]},{"id":28,"parentId":1,"menuName":"双方不匹配的数据","menuPath":"openBillCompareJsp.action","remark":"","subMenuInfoList":[]},{"id":29,"parentId":1,"menuName":"双方匹配数据汇总","menuPath":"openBillCompareSamJsp.action","remark":"","subMenuInfoList":[]},{"id":30,"parentId":1,"menuName":"对账表修改记录","menuPath":"openBillChangeJsp.action","remark":"","subMenuInfoList":[]}],"msg":"success"};
	var zNodes = data.data;
	$.fn.zTree.init($("#menu"), setting, zNodes);
	$.fn.zTree.getZTreeObj('menu').expandAll(true);
});*/
