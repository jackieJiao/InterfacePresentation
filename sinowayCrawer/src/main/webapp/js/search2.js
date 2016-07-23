
$(function(){
    $("#btn1").bind("click",function(){
    	$("#c_right").load("states2",
				function(responseTxt, statusTxt, xhr) {
					if (xhr.status == 403) {
						alert("您的权限不够！");
					}
				});
    });
    
    
})

/**
 * states2.jsp
 *
 */

var pagetool;
	var resultJson1;
	function loadData2(){
		$.ajax({ 
            type: 'POST',
            url: '../test/get3timetable',
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            success:function(json){
            	console.info("******loadData,status2*******")
            	console.info(json);
            	resultJson1=JSON.stringify(json.result);
                var data = json.result;
                var pama = ["phone","name","cardid","loginTime","updateTime","reportTime","requestTime"];
              
                pagetool = new Pageglobal(data,pama,"list1","pagecount");
                pagetool.init();
                console.info("finish pagegloble");
                console.info(resultJson1)
            },
            error: function (xhr) {alert("获取数据出错："+xhr.statusText);} 
        });
	}
	function getExcel2(){
		console.log("#####resultJson###########")
		/*console.log(reultJson);*/
		if(resultJson1==null){
			alert("没有要下载的数据.");
		}else{
		//window.location.href='../test/getExcel?data='+resultJson;		
			   
			     console.info("###getexcel2####",resultJson1)
			//调用方法 如      
		post('../test/getExcel1',resultJson1);
	}}
	function post(url, params) {
	    var temp = document.createElement("form");
	    temp.action = url;
	    temp.method = "post";
	    temp.setAttribute("accept-charset","UTF-8");
	    temp.Allow = "POST";
	   /* temp.style.display = "none";*/
	   
	        var opt = document.createElement("input");
	        opt.name = "data";
	        opt.value = params;
	        console.info("***this is params",params);
	        temp.appendChild(opt);
	   
	    document.body.appendChild(temp);
	    temp.submit();
	    return temp;
	}
	function setTableData(page){
		pagetool.setTableData(page);
	}