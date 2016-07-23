package com.sinoway.sinowayCrawer.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="info_order_status")
public class InfoOrderStatusSummary implements Serializable {

	private String id;
	private String order_code;
	private String name;
	private String cardid;
	private String phoneNumber;
	private String clicktime;
	private String sinoSign;
	private String centerSign;
	private String centerReg;
	private String answerSucc;
	private String centerNoSucc;
	private String getCode;
	private String isDone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCenterReg() {
		return centerReg;
	}
	public void setCenterReg(String centerReg) {
		this.centerReg = centerReg;
	}
	public String getAnswerSucc() {
		return answerSucc;
	}
	public void setAnswerSucc(String answerSucc) {
		this.answerSucc = answerSucc;
	}
	public String getCenterNoSucc() {
		return centerNoSucc;
	}
	public void setCenterNoSucc(String centerNoSucc) {
		this.centerNoSucc = centerNoSucc;
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
