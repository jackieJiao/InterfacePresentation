function search_search(){
	$('#billchanged').datagrid('load',
			{
			 ordersId : $("#search_ordersId").val()/*,
			 operatorname : $("#search_billAmount").val()*/
			});
}
function search_reset(){
	$("#form_search")[0].reset();
}