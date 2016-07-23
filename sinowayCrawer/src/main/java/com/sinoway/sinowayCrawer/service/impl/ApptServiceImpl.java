package com.sinoway.sinowayCrawer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.CreditOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.reportAppt;
import com.sinoway.sinowayCrawer.mapper.CreditNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.CreditOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.HousingNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.HousingOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.LoanNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.LoanOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.institutionQueryDetailsMapper;
import com.sinoway.sinowayCrawer.mapper.personalQueryDetailsMapper;
import com.sinoway.sinowayCrawer.mapper.reportApptMapper;
import com.sinoway.sinowayCrawer.service.ApptService;
@Service
public class ApptServiceImpl implements ApptService {

	@Autowired
	private reportApptMapper apptmapper;
	@Autowired
	private HousingNoOverdueAccountDetailMapper HNmapper;
	@Autowired
	private HousingOverdueAccountDetailMappr Hmapper;
	@Autowired
	private CreditNoOverdueAccountDetailMapper CNmapper;
	@Autowired
	private CreditOverdueAccountDetailMappr Cmapper;
	@Autowired
	private LoanNoOverdueAccountDetailMapper LNmapper;
	@Autowired
	private LoanOverdueAccountDetailMappr Lmapper;
	@Autowired
	private personalQueryDetailsMapper PQmapper;
	@Autowired
	private institutionQueryDetailsMapper IQmapper;
	
	
	
	
	public List<reportAppt> getList(String queried_number) {
		// TODO Auto-generated method stub
		System.out.println("search.action,getlist");
		List<reportAppt> apptlist=apptmapper.selectallbyqueried_number(queried_number);
		return apptlist;
	}
	 
	public List<HousingNoOverdueAccountDetail> gethousingNo(String report_id) {
		// TODO Auto-generated method stub
		List<HousingNoOverdueAccountDetail> listhn=HNmapper.selectallbyreportid(report_id);
		return listhn;
	}
	
	 
	public List<HousingOverdueAccountDetail> gethousing(String report_id) {
		// TODO Auto-generated method stub
		List<HousingOverdueAccountDetail> listhn=Hmapper.selectallbyreportid(report_id);
		return listhn;
	}
	 
	public List<CreditNoOverdueAccountDetail> getcreditNo(String report_id) {
		// TODO Auto-generated method stub
		List<CreditNoOverdueAccountDetail> listhn=CNmapper.selectallbyreportid(report_id);
		return listhn;
	}
	 
	public List<CreditOverdueAccountDetail> getcredit(String report_id) {
		// TODO Auto-generated method stub
		List<CreditOverdueAccountDetail> listc=Cmapper.selectallbyreportid(report_id);
		return listc;
	}
	 
	public List<LoanOverdueAccountDetail> getloan(String report_id) {
		// TODO Auto-generated method stub
		List<LoanOverdueAccountDetail> listl=Lmapper.selectallbyreportid(report_id);
		return listl;
	}
	 
	public List<LoanNoOverdueAccountDetail> getloanNo(String report_id) {
		// TODO Auto-generated method stub
		List<LoanNoOverdueAccountDetail> listln=LNmapper.selectallbyreportid(report_id);
		return listln;
		
	}
	 
	public List<personalQueryDetails> getpersonQ(String report_id) {
		// TODO Auto-generated method stub
		List<personalQueryDetails> listhn=PQmapper.selectallbyreportid(report_id);
		return listhn;
	}
	 
	public List<institutionQueryDetails> getinstituteQ(String report_id) {
		// TODO Auto-generated method stub
		List<institutionQueryDetails> listhn=IQmapper.selectallbyreportid(report_id);
		return listhn;
	}
	 
	public List<reportAppt> selectallbyReportId(String reportId) {
		// TODO Auto-generated method stub
		List<reportAppt> apptlist=apptmapper.selectallbyReportId(reportId);
		return apptlist;
	}

}
