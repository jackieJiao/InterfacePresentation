package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.InfoOrderStatusSummary;
import com.sinoway.sinowayCrawer.entitys.SCondition;
import com.sinoway.sinowayCrawer.entitys.Time3;

public interface InfoOrderStatusSummaryMapper {
	List<InfoOrderStatusSummary> getAll();
	List<InfoOrderStatusSummary> getAllBySCondition(SCondition scondition);
	List<Time3> getTime3();
	String getFinishNuber();
	String getFinishReg();
	
}


