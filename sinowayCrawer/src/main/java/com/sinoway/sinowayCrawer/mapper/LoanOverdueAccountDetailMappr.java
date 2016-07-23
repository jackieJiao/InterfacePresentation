package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.OverdueAccountDetail;

public interface LoanOverdueAccountDetailMappr {
	
	
int insert(LoanOverdueAccountDetail d);

List<LoanOverdueAccountDetail> selectallbyreportid(String reportid);

}
