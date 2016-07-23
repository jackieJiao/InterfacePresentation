package com.sinoway.sinowayCrawer.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sinoway.sinowayCrawer.entitys.Fubiao;
import com.sinoway.sinowayCrawer.entitys.NoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.OverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.Requestargs;
import com.sinoway.sinowayCrawer.entitys.creditNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.creditOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.creditRecord;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.loanNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.loanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.query;
import com.sinoway.sinowayCrawer.entitys.reportAppt;
import com.sinoway.sinowayCrawer.entitys.summarys;
import com.sinoway.sinowayCrawer.mapper.loanOverdueAccountMapper;
import com.sinoway.sinowayCrawer.service.JsonDecService;
import com.sinoway.sinowayCrawer.service.TotalService;

@Controller
@RequestMapping("/valuesService")
public class ShutdownsController {
	private JsonDecService jsonDecService;
	
	


	public JsonDecService getJsonDecService() {
		return jsonDecService;
	}



@Autowired
	public void setJsonDecService(JsonDecService jsonDecService) {
		this.jsonDecService = jsonDecService;
	}




	@RequestMapping(value = "/values.action", method = RequestMethod.POST)
	@ResponseBody
	public String LdPayRequest(
			@RequestParam(value = "data") String data,
			HttpServletRequest req, HttpServletResponse res
			
	)  {
		boolean dec = jsonDecService.dec(data);

		return "OK";
		//return transactions;
		
	
	}

}
