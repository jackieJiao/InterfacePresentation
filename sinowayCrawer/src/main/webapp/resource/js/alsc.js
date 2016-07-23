	// 输入框
	var alscInputText = document.getElementById('alscText1');
	// 运算记录
	var logText = document.getElementById('logText');

	// 给文本框赋值
	function alscAddText(event) {
	    event = event || window.event;
	    var element = event.target || event.srcElement;
	    alscInputText.value += element.value;
	    // 设置焦点
	    alscInputText.focus();
	}

	// 计算文本框内的表达式
	function alscEv() {
	    var value = alscInputText.value;
	    if (value) {
	        try {
	            var result = eval(value);
	            // 显示结果
	            alscInputText.value = result;

	            // 记录结果
	            logText.value = value + '=' + result + '\n' + logText.value;
	        }
	        catch (e) {
	            alert(e.description);
	        }
	    }
	    // 设置焦点
	    alscInputText.focus();
	}

	//把文本框内的内容清空
	function alscClean() {
	    alscInputText.value = '';
	    // 设置焦点
	    alscInputText.focus();
	}

	//开根号
	function alscSQRT() {
	    alscInputText.value = Math.sqrt(alscInputText.value);
	    // 设置焦点
	    alscInputText.focus();
	}

	//平方
	function alscPow() {
	    alscInputText.value = Math.pow(alscInputText.value, 2);
	    // 设置焦点
	    alscInputText.focus();
	}

	//删除一位
	function alscDel() {
	    var value = alscInputText.value;
	    if (value) alscInputText.value = value.substring(0, value.length - 1);
	    // 设置焦点
	    alscInputText.focus();
	}

	// 添加事件
	(function() {
	    var elements = document.getElementsByTagName('input');
	    for (var i=0, len=elements.length; i<len; i++) {
	        var element = elements[i];
	        // 按钮, 点击事添加一个符号到输入框(有 onclick 事件的表示有自己独特的事件,这里不处理)
	        if (element.type == 'button' && !element.onclick) {
	            element.onclick = alscAddText;
	        }
	        // 输入框, 输入“=”号或者按回车, 则计算结果
	        else if (element.type == 'text') {
	            element.onkeydown = function(event) {
	                event = event || window.event;
	                var currentKey = event.keyCode || event.charCode;
	                // 13:回车键, “=”号在火狐是61,在IE是187
	                if (13==currentKey || (event.shiftKey === false && (61==currentKey || 187==currentKey))) {
	                    alscEv();
	                    return false;
	                }
	                return true;
	            }
	        }
	    }
	    // 设置焦点
	    alscInputText.focus();
	})();

	/**
	 * 这是错误调试程序
	 * 当页面发生错误时，提示错误讯息；仅测试环境里会提示，正式环境下不提示错误。
	 * 注意：仅IE、fiefox有效,w3c标准里面没有此定义, chrome、opera 和 safari 浏览器不支持此事件
	 */
	window.onerror = function(msg, url, sLine) {
	    var hostUrl = window.location.href;
	    // 判断网址,测试时可以提示出错信息;正式发布时不提示
	    if (hostUrl.indexOf("http://localhost") === 0 || hostUrl.indexOf("http://127.0.0.1") === 0 ||
	        hostUrl.indexOf("http://192.168.") === 0 || hostUrl.indexOf("file://") === 0) {
	        var errorMsg = "当前页面的javascript发生错误.\n\n";
	        errorMsg += "错误: " + msg + "\n";   // 出错信息
	        errorMsg += "URL: " + url + "\n";    // 出错文件的地址
	        errorMsg += "行: " + sLine + "\n\n"; // 发生错误的行
	        errorMsg += "点击“确定”以继续。\n\n";
	        window.alert( errorMsg );
	    }
	    // 返回true,会消去 IE下那个恼人的“网页上有错误”的提示
	    return true;
	};