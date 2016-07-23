package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.NoOverdueAccountDetail;

public interface LoanNoOverdueAccountDetailMapper {

	int insert(LoanNoOverdueAccountDetail d);

	List<LoanNoOverdueAccountDetail> selectallbyreportid(String reportid);
}
