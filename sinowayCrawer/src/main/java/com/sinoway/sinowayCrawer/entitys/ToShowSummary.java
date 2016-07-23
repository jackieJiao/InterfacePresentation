package com.sinoway.sinowayCrawer.entitys;

import java.util.Date;

public class ToShowSummary {
	
	
	//订单号	姓名	身份证号码 手机号
	//访问时间（最早）	平台登录 系统登录 申请完成时间（最近）	生成报告时间	流程完成时间
	
	private String order_code;
	private String name;
	private String cardid;
	private String phoneNumber;
	private String clicktime;
	private String sinoSign;
	private String centerSign;//系统登陆：包括两种状态
	private String answerYN;
	private String getCode;
	private String isDone;
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getClicktime() {
		return clicktime;
	}
	public void setClicktime(String clicktime) {
		this.clicktime = clicktime;
	}
	public String getSinoSign() {
		return sinoSign;
	}
	public void setSinoSign(String sinoSign) {
		this.sinoSign = sinoSign;
	}
	public String getCenterSign() {
		return centerSign;
	}
	public void setCenterSign(String centerSign) {
		this.centerSign = centerSign;
	}
	public String getAnswerYN() {
		return answerYN;
	}
	public void setAnswerYN(String answerYN) {
		this.answerYN = answerYN;
	}
	public String getGetCode() {
		return getCode;
	}
	public void setGetCode(String getCode) {
		this.getCode = getCode;
	}
	public String getIsDone() {
		return isDone;
	}
	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}
	
	
	
	
}
