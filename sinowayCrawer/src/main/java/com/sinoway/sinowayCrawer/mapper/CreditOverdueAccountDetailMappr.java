package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.CreditOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.OverdueAccountDetail;

public interface CreditOverdueAccountDetailMappr {
	
	
int insert(CreditOverdueAccountDetail d);
List<CreditOverdueAccountDetail> selectallbyreportid(String reportid);
}
