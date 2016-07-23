package com.sinoway.sinowayCrawer.mapper;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.OverdueAccountDetail;

public interface HousingOverdueAccountDetailMappr {
	
	
int insert(HousingOverdueAccountDetail d);
List<HousingOverdueAccountDetail> selectallbyreportid(String reportid);
}
