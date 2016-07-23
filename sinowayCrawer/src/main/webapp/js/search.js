
$(function(){
    $("#btn").bind("click",function(){
    var val=$("#btn").val();
    var name=$("#name").val();
    var cardid=$("#age").val();
        loadData(cardid);
    });
    
    
})


var pagetool;
function loadData(cardid){
    $.ajax({
    	
        type: 'POST',
        url: '../search.action',
        data: {
        	"cardid":cardid,
            /*actions:"list",*/
        },
        dataType:'json',
        success:function(json){
            var data = json.result;
            console.log(data);
            var pama = ["queriedName","queriedNumber","reportId","reportTime"];
            pagetool = new Pageglobal(data,pama,"list","pagecount");
            pagetool.init();
            $("#show_text").hide();
            $("#btn_c").bind("click",function() {
                /*window.location.reload();*/
                $("#container").load("download",
						function(responseTxt, statusTxt, xhr) {
							if (xhr.status == 403) {
								alert("您的权限不够！");
							}
						});
            })
        },
        error: function (xhr) {alert("获取数据出错："+xhr.statusText);}
    });
}
function setTableData(page){
    pagetool.setTableData(page);
}

