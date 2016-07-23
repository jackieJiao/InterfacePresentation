<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
    <script src="/sinowayCrawer/js/pagetool.js"></script>
    <script src="/sinowayCrawer/js/search.js"></script>
     <script src="/sinowayCrawer/js/search2.js"></script>
     <link rel="stylesheet" href="../css/download.css"/>
     <link rel="stylesheet" type="text/css" href="../css/mystyle.css">
<script>
			$(function(){  
				  //判断浏览器是否支持placeholder属性
				  supportPlaceholder='placeholder'in document.createElement('input'),
				 
				  placeholder=function(input){
				 
				    var text = input.attr('placeholder'),
				    defaultValue = input.defaultValue;
				 
				    if(!defaultValue){
				 
				      input.val(text).addClass("phcolor");
				    }
				 
				    input.focus(function(){
				 
				      if(input.val() == text){
				   
				        $(this).val("");
				      }
				    });
				    input.blur(function(){
				 
				      if(input.val() == ""){
				       
				        $(this).val(text).addClass("phcolor");
				      }
				    });
				 
				    //输入的字符不为灰色
				    input.keydown(function(){
				  
				      $(this).removeClass("phcolor");
				    });
				  };
				 
				  //当浏览器不支持placeholder属性时，调用placeholder函数
				  if(!supportPlaceholder){
					  console.log(1111111111);
				    $('input').each(function(){
				 
				      text = $(this).attr("placeholder");
				 
				      if($(this).attr("type") == "text"){
				 
				        placeholder($(this));
				      }
				    });
				  }
				 
				});
</script>
</head>
<body>
<div class="box clearfix" >
    <!--left-search-bar-->
    
    <div class="c_left fl" id="c_left" style="width:25%;">
        <div id="loginform">
            <div id="mainlogin">
            <button type="button" id="btn1" > 所有人三类时间统计表</i></button>
                 <div class="c_left_box">
            
                    <!--  <input id="name" name="name"  type="text" placeholder="姓名" value="" required/><br/> -->
                     <input id="age" name="age"  type="text" placeholder="身份证号" value="" required/><br/>
                    <button type="button" id="btn" ><i class="fa fa-arrow-right">查找</i></button>
                   
                    
                    
                 </div>
                  
            </div><br>	
            <div>
            
        </div></div>
    </div>
    <!--right-show-->
    <div id="c_right" class="c_right p_r fl clearfix"  style="width:70%;">
       	 <div id="showlist" >
            <div  align='center' class='divcenter' >
                
                <table id='listTable' class='listTable'  style="width:500px;" border="0" cellspacing="0" cellpadding="0"  >
                    <thead id="btn_c_thead">
                    <tr>
						<!-- <th>序号</th> -->
                        <th>姓名</th>
                        <th>身份证</th>
                        <th>报告编号</th>
						<th>报告时间</th>
						<th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="list"></tbody>
                </table>
                <div id="pagecount" ></div>
            </div>
            
        </div>
        
    </div>
  </div>




</body>
</html>