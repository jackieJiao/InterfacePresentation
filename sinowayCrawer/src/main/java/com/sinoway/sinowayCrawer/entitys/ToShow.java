package com.sinoway.sinowayCrawer.entitys;

import java.util.Date;

public class ToShow {
	
	
	//订单号	姓名	身份证号码 访问时间（最早）	注册完成时间	申请完成时间（最近）	生成报告时间	流程完成时间
	String ordercode;
	String oname;
	String ocardid;
	String createtime;
	String registerfinishtime;
	String applytime;
	String getreporttime;
	String finishtime;
	
	
	
	public ToShow(String ordercode, String oname, String ocardid, String registerfinishtime, String applytime,
			String getreporttime, String finishtime) {
		
		this.ordercode = ordercode;
		this.oname = oname;
		this.ocardid = ocardid;
		//this.createtime = createtime;
		this.registerfinishtime = registerfinishtime;
		this.applytime = applytime;
		this.getreporttime = getreporttime;
		this.finishtime = finishtime;
	}
	
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOcardid() {
		return ocardid;
	}

	public void setOcardid(String ocardid) {
		this.ocardid = ocardid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String string) {
		this.createtime = string;
	}
	public String getRegisterfinishtime() {
		return registerfinishtime;
	}
	public void setRegisterfinishtime(String registerfinishtime) {
		this.registerfinishtime = registerfinishtime;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getGetreporttime() {
		return getreporttime;
	}
	public void setGetreporttime(String getreporttime) {
		this.getreporttime = getreporttime;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
}
