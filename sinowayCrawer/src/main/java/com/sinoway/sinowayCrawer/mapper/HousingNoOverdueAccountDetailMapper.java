package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.reportAppt;

public interface HousingNoOverdueAccountDetailMapper {

	int insert(HousingNoOverdueAccountDetail d);
	List<HousingNoOverdueAccountDetail> selectallbyreportid(String reportid);
}
