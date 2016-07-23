package com.sinoway.sinowayCrawer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
/*
 * jvxinli 调此接口
 */
@RequestMapping("/JXLRecallService")
public class JXLRecallController {
	@Autowired
	private com.sinoway.sinowayCrawer.service.JsonDecService JsonDecService;
	@Autowired
	private com.sinoway.sinowayCrawer.service.JXLPostService JXLPostService;
	
	@RequestMapping(value = "/recall.action", method = RequestMethod.POST)
	@ResponseBody
	public String JXLRecallRequest(
			@RequestParam(value = "data") String data,
			HttpServletRequest req, HttpServletResponse res
	)  {
//		return "{\"code\":200,\"note\":\"成功\"}";
		System.out.println("recall.action data= " + data);
		boolean ret = JsonDecService.dec(data);
		System.out.println("JXLRecallRequest= " + ret);
		if ( ret ){
			return "{\"code\":200,\"note\":\"success\"}";
		} else{
			return "{\"code\":400,\"note\":\"failed\"}";
		}
	}
	/*
	 * 刘欢前端程序--->startCommit
	 * 在此获得用户信息json
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/startCommit.action", method = RequestMethod.POST, produces="text/html;charset=UTF-8;" )
	@ResponseBody
	public String JXLstartCommitRequest(
			@RequestParam(value = "data") String data,
			HttpServletRequest req, HttpServletResponse res
	)  
	{
		System.out.println("data=" + data);
//		return "{\"code\":200,\"note\":\"success\"}";
		String name = null;
        String cell_phone_num = null;
        String id_card_num = null;
        String account = null;
        String password = null;
        String captcha = null;
        int parOK = 0;
        
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(data, JsonObject.class);
		System.out.println("现在判断刘欢传入数据完整性");
		if (obj.has("name")) {
			JsonElement jsonElemen = obj.get("name");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				name = jsonElemen.getAsString();
				parOK++;
			}
		}
		if (obj.has("cell_phone_num")) {
			JsonElement jsonElemen = obj.get("cell_phone_num");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				cell_phone_num = jsonElemen.getAsString();
				parOK++;
			}
		}
		if (obj.has("id_card_num")) {
			JsonElement jsonElemen = obj.get("id_card_num");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				id_card_num = jsonElemen.getAsString();
				parOK++;
			}
		}
		if (obj.has("account")) {
			JsonElement jsonElemen = obj.get("account");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				account = jsonElemen.getAsString();
				parOK++;
			}
		}
		if (obj.has("password")) {
			JsonElement jsonElemen = obj.get("password");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				password = jsonElemen.getAsString();
				parOK++;
			}
		}
		if (obj.has("captcha")) {
			JsonElement jsonElemen = obj.get("captcha");
			if (!jsonElemen.isJsonNull()) {
//				System.out.println(jsonElemen.getAsString());
				captcha = jsonElemen.getAsString();
				parOK++;
			}
		}
		
//		System.out.println("parOK=" + parOK);
//		System.out.println( name + cell_phone_num + id_card_num + account + password + captcha);
		boolean ret = false;
		if ( 6 == parOK ){
			System.out.println("判断完成：数据完整！");
			String retStr = null;
			try {
				retStr = JXLPostService.sendCreditRequest(
					name, 
					cell_phone_num, 
					id_card_num, 
					account, 
					password, 
					captcha);
			ret = (retStr == null?false:
				(retStr.equals("10008")?true:false)
				);
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				if ( ret ){
					return "Success";//"{\"code\":200,\"note\":\"success\"}";
				} else{
					return "Failed:"+retStr;//"{\"code\":400,\"note\":\"failed\"}";
				}
			}
		}
		if ( ret ){
			return "Success";//"{\"code\":200,\"note\":\"success\"}";
		} else{
			return "Failed:用户信息不全";//"{\"code\":400,\"note\":\"failed\"}";
		}
	}
}
