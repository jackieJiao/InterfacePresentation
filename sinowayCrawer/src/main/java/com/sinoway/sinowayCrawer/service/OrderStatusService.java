package com.sinoway.sinowayCrawer.service;

import java.util.Date;
import java.util.List;

import com.sinoway.sinowayCrawer.entitys.InfoOrderStatusSummary;
import com.sinoway.sinowayCrawer.entitys.SCondition;
import com.sinoway.sinowayCrawer.entitys.Time3;

public interface OrderStatusService {
	
	List<String> getAllOrdercode();
	List<String> getStatustypeByOrdercode(String ordercode);
	String getDateByOrdercodeAndType(String ordercode,String type);
	String getUseraccountByOrdercodeAndType(String ordercode,String type);
	String getNameByUseraccount(String useraccount);
	String getCardidByUseraccount(String useraccount);
	List<InfoOrderStatusSummary> getAllSummary();
	List<InfoOrderStatusSummary> getAllBySCondition(SCondition scondition);
	List<Time3> get3timetable();
	String getFinishNumber();
	String getFinishReg();
	
	
}
