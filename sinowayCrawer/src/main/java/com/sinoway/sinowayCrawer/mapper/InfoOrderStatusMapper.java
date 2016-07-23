package com.sinoway.sinowayCrawer.mapper;

import java.util.Date;
import java.util.List;

public interface InfoOrderStatusMapper {
	List<String> selectAllOrdercode();
	List<String> getStatustypeByOrdercode(String ordercode);
	String getDateByOrdercodeAndType(String ordercode,String type);
	String getUseraccountByOrdercodeAndType(String ordercode, String type);
	String getNameByUseraccount(String useraccount);
	String getCardidByUseraccount(String useraccount);
}
