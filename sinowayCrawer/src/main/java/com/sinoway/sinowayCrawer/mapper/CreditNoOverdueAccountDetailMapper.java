package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.NoOverdueAccountDetail;

public interface CreditNoOverdueAccountDetailMapper {

	int insert(CreditNoOverdueAccountDetail d);
	List<CreditNoOverdueAccountDetail> selectallbyreportid(String reportid);
}
