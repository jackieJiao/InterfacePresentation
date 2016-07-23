package com.sinoway.sinowayCrawer.service;

import java.util.List;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.CreditOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.reportAppt;

public interface ApptService {
	/*
	 * 查询appt,返回list
	 */
	List<reportAppt> getList(String queried_number);
	List<reportAppt> selectallbyReportId(String reportId);
	List<HousingNoOverdueAccountDetail> gethousingNo(String report_id);
	List<HousingOverdueAccountDetail> gethousing(String report_id);
	List<CreditNoOverdueAccountDetail> getcreditNo(String report_id);
	List<CreditOverdueAccountDetail> getcredit(String report_id);
	List<LoanOverdueAccountDetail> getloan(String report_id);
	List<LoanNoOverdueAccountDetail> getloanNo(String report_id);
	List<personalQueryDetails> getpersonQ(String report_id);
	List<institutionQueryDetails> getinstituteQ(String report_id);
}
