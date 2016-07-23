package com.sinoway.sinowayCrawer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.sinowayCrawer.entitys.CreditNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.CreditOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.Fubiao;
import com.sinoway.sinowayCrawer.entitys.HousingNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.HousingloanNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.HousingloanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.LoanNoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.LoanloanNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.LoanloanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.NoOverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.OverdueAccountDetail;
import com.sinoway.sinowayCrawer.entitys.Requestargs;
import com.sinoway.sinowayCrawer.entitys.creditNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.creditOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.loanNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.loanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.query;
import com.sinoway.sinowayCrawer.entitys.reportAppt;
import com.sinoway.sinowayCrawer.entitys.summarys;
import com.sinoway.sinowayCrawer.mapper.CreditNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.CreditOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.FubiaoMapper;
import com.sinoway.sinowayCrawer.mapper.HousingNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.HousingOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.HousingloanNoOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.HousingloanOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.LoanNoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.LoanOverdueAccountDetailMappr;
import com.sinoway.sinowayCrawer.mapper.LoanloanNoOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.LoanloanOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.NoOverdueAccountDetailMapper;
import com.sinoway.sinowayCrawer.mapper.OverdueAccountDetailMapp;
import com.sinoway.sinowayCrawer.mapper.RequestargsMapper;
import com.sinoway.sinowayCrawer.mapper.creditNoOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.creditOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.institutionQueryDetailsMapper;
import com.sinoway.sinowayCrawer.mapper.loanNoOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.loanOverdueAccountMapper;
import com.sinoway.sinowayCrawer.mapper.personalQueryDetailsMapper;
import com.sinoway.sinowayCrawer.mapper.queryMapper;
import com.sinoway.sinowayCrawer.mapper.reportApptMapper;
import com.sinoway.sinowayCrawer.mapper.summarysMapper;
import com.sinoway.sinowayCrawer.service.TotalService;
@Service
public class TotalServiceImpl implements TotalService{

	private reportApptMapper reportApptMappers;
	
	private loanNoOverdueAccountMapper loanNoOverdueAccountMappers;
	
	private loanOverdueAccountMapper loanOverdueAccountMappers;
	
	private creditNoOverdueAccountMapper creditNoOverdueAccountMappers;
	
	private creditOverdueAccountMapper accountMapper;
	
	private summarysMapper summarysMappers;
	
	private queryMapper queryMappers;
	
	private OverdueAccountDetailMapp overdueAccountDetailMapps;
	
	private NoOverdueAccountDetailMapper noOverdueAccountDetailMappers;
	
	private personalQueryDetailsMapper personalQueryDetailsMappers;
	
	private FubiaoMapper fubiaoMapper;
	
	private RequestargsMapper requestargsMapper;
	
	private institutionQueryDetailsMapper institutionQueryDetailsMappers;
	private HousingNoOverdueAccountDetailMapper housingNoOverdueAccountDetailMapper;
	private HousingOverdueAccountDetailMappr housingOverdueAccountDetailMappr;
	
	private CreditNoOverdueAccountDetailMapper creditNoOverdueAccountDetailMapper;
	private CreditOverdueAccountDetailMappr creditOverdueAccountDetailMappr;
	private LoanNoOverdueAccountDetailMapper loanNoOverdueAccountDetailMapper;
	private LoanOverdueAccountDetailMappr loanOverdueAccountDetailMappr;
	
	
	private HousingloanNoOverdueAccountMapper housingloanNoOverdueAccountMapper;
	private HousingloanOverdueAccountMapper housingloanOverdueAccountMapper;
	private LoanloanNoOverdueAccountMapper loanloanNoOverdueAccountMapper;
	private LoanloanOverdueAccountMapper loanloanOverdueAccountMapper;
	
	
	
	
	
	
	public HousingloanNoOverdueAccountMapper getHousingloanNoOverdueAccountMapper() {
		return housingloanNoOverdueAccountMapper;
	}
	@Autowired
	public void setHousingloanNoOverdueAccountMapper(
			HousingloanNoOverdueAccountMapper housingloanNoOverdueAccountMapper) {
		this.housingloanNoOverdueAccountMapper = housingloanNoOverdueAccountMapper;
	}
	public HousingloanOverdueAccountMapper getHousingloanOverdueAccountMapper() {
		return housingloanOverdueAccountMapper;
	}
	@Autowired
	public void setHousingloanOverdueAccountMapper(
			HousingloanOverdueAccountMapper housingloanOverdueAccountMapper) {
		this.housingloanOverdueAccountMapper = housingloanOverdueAccountMapper;
	}
	public LoanloanNoOverdueAccountMapper getLoanloanNoOverdueAccountMapper() {
		return loanloanNoOverdueAccountMapper;
	}
	@Autowired
	public void setLoanloanNoOverdueAccountMapper(
			LoanloanNoOverdueAccountMapper loanloanNoOverdueAccountMapper) {
		this.loanloanNoOverdueAccountMapper = loanloanNoOverdueAccountMapper;
	}
	public LoanloanOverdueAccountMapper getLoanloanOverdueAccountMapper() {
		return loanloanOverdueAccountMapper;
	}
	@Autowired
	public void setLoanloanOverdueAccountMapper(
			LoanloanOverdueAccountMapper loanloanOverdueAccountMapper) {
		this.loanloanOverdueAccountMapper = loanloanOverdueAccountMapper;
	}
	public HousingNoOverdueAccountDetailMapper getHousingNoOverdueAccountDetailMapper() {
		return housingNoOverdueAccountDetailMapper;
	}
	@Autowired
	public void setHousingNoOverdueAccountDetailMapper(
			HousingNoOverdueAccountDetailMapper housingNoOverdueAccountDetailMapper) {
		this.housingNoOverdueAccountDetailMapper = housingNoOverdueAccountDetailMapper;
	}
	public HousingOverdueAccountDetailMappr getHousingOverdueAccountDetailMappr() {
		return housingOverdueAccountDetailMappr;
	}
	@Autowired
	public void setHousingOverdueAccountDetailMappr(
			HousingOverdueAccountDetailMappr housingOverdueAccountDetailMappr) {
		this.housingOverdueAccountDetailMappr = housingOverdueAccountDetailMappr;
	}
	public CreditNoOverdueAccountDetailMapper getCreditNoOverdueAccountDetailMapper() {
		return creditNoOverdueAccountDetailMapper;
	}
	@Autowired
	public void setCreditNoOverdueAccountDetailMapper(
			CreditNoOverdueAccountDetailMapper creditNoOverdueAccountDetailMapper) {
		this.creditNoOverdueAccountDetailMapper = creditNoOverdueAccountDetailMapper;
	}
	public CreditOverdueAccountDetailMappr getCreditOverdueAccountDetailMappr() {
		return creditOverdueAccountDetailMappr;
	}
	@Autowired
	public void setCreditOverdueAccountDetailMappr(
			CreditOverdueAccountDetailMappr creditOverdueAccountDetailMappr) {
		this.creditOverdueAccountDetailMappr = creditOverdueAccountDetailMappr;
	}
	public LoanNoOverdueAccountDetailMapper getLoanNoOverdueAccountDetailMapper() {
		return loanNoOverdueAccountDetailMapper;
	}
	@Autowired
	public void setLoanNoOverdueAccountDetailMapper(
			LoanNoOverdueAccountDetailMapper loanNoOverdueAccountDetailMapper) {
		this.loanNoOverdueAccountDetailMapper = loanNoOverdueAccountDetailMapper;
	}
	public LoanOverdueAccountDetailMappr getLoanOverdueAccountDetailMappr() {
		return loanOverdueAccountDetailMappr;
	}
	@Autowired
	public void setLoanOverdueAccountDetailMappr(
			LoanOverdueAccountDetailMappr loanOverdueAccountDetailMappr) {
		this.loanOverdueAccountDetailMappr = loanOverdueAccountDetailMappr;
	}
	public institutionQueryDetailsMapper getInstitutionQueryDetailsMappers() {
		return institutionQueryDetailsMappers;
	}
	@Autowired
	public void setInstitutionQueryDetailsMappers(
			institutionQueryDetailsMapper institutionQueryDetailsMappers) {
		this.institutionQueryDetailsMappers = institutionQueryDetailsMappers;
	}
	public RequestargsMapper getRequestargsMapper() {
		return requestargsMapper;
	}
	@Autowired
	public void setRequestargsMapper(RequestargsMapper requestargsMapper) {
		this.requestargsMapper = requestargsMapper;
	}
	public FubiaoMapper getFubiaoMapper() {
		return fubiaoMapper;
	}
	@Autowired
	public void setFubiaoMapper(FubiaoMapper fubiaoMapper) {
		this.fubiaoMapper = fubiaoMapper;
	}
	public personalQueryDetailsMapper getPersonalQueryDetailsMappers() {
		return personalQueryDetailsMappers;
	}
	@Autowired
	public void setPersonalQueryDetailsMappers(
			personalQueryDetailsMapper personalQueryDetailsMappers) {
		this.personalQueryDetailsMappers = personalQueryDetailsMappers;
	}
	
	
	
	public OverdueAccountDetailMapp getOverdueAccountDetailMapps() {
		return overdueAccountDetailMapps;
	}
	@Autowired
	public void setOverdueAccountDetailMapps(
			OverdueAccountDetailMapp overdueAccountDetailMapps) {
		this.overdueAccountDetailMapps = overdueAccountDetailMapps;
	}
	public NoOverdueAccountDetailMapper getNoOverdueAccountDetailMappers() {
		return noOverdueAccountDetailMappers;
	}
	@Autowired
	public void setNoOverdueAccountDetailMappers(
			NoOverdueAccountDetailMapper noOverdueAccountDetailMappers) {
		this.noOverdueAccountDetailMappers = noOverdueAccountDetailMappers;
	}
	public queryMapper getQueryMappers() {
		return queryMappers;
	}
	@Autowired
	public void setQueryMappers(queryMapper queryMappers) {
		this.queryMappers = queryMappers;
	}
	public summarysMapper getSummarysMappers() {
		return summarysMappers;
	}
	@Autowired
	public void setSummarysMappers(summarysMapper summarysMappers) {
		this.summarysMappers = summarysMappers;
	}
	public creditOverdueAccountMapper getAccountMapper() {
		return accountMapper;
	}
@Autowired
	public void setAccountMapper(creditOverdueAccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public creditNoOverdueAccountMapper getCreditNoOverdueAccountMappers() {
		return creditNoOverdueAccountMappers;
	}

@Autowired
	public void setCreditNoOverdueAccountMappers(
			creditNoOverdueAccountMapper creditNoOverdueAccountMappers) {
		this.creditNoOverdueAccountMappers = creditNoOverdueAccountMappers;
	}


	public reportApptMapper getReportApptMappers() {
		return reportApptMappers;
	}


    @Autowired
	public void setReportApptMappers(reportApptMapper reportApptMappers) {
		this.reportApptMappers = reportApptMappers;
	}



	public loanOverdueAccountMapper getLoanOverdueAccountMappers() {
		return loanOverdueAccountMappers;
	}

@Autowired
	public void setLoanOverdueAccountMappers(
			loanOverdueAccountMapper loanOverdueAccountMappers) {
		this.loanOverdueAccountMappers = loanOverdueAccountMappers;
	}


	public loanNoOverdueAccountMapper getLoanNoOverdueAccountMappers() {
		return loanNoOverdueAccountMappers;
	}

@Autowired
	public void setLoanNoOverdueAccountMappers(
			loanNoOverdueAccountMapper loanNoOverdueAccountMappers) {
		this.loanNoOverdueAccountMappers = loanNoOverdueAccountMappers;
	}


	 
	public int insert(reportAppt record) {
		int insert = reportApptMappers.insert(record);
		return insert;
	}


	 
	public int insert(loanNoOverdueAccount record) {
		int insert = loanNoOverdueAccountMappers.insert(record);
		return insert;
	}


	 
	public int insert(loanOverdueAccount record) {
		int insert = loanOverdueAccountMappers.insert(record);
		return insert;
	}


	 
	public int insert(creditNoOverdueAccount record) {
		int insert = creditNoOverdueAccountMappers.insert(record);
		return insert;
	}

	 
	public int insert(creditOverdueAccount record) {
		int insert = accountMapper.insert(record);
		return insert;
	}
	 
	public int insert(summarys record) {
		int insert = summarysMappers.insert(record);
		return insert;
	}
	 
	public int insert(query record) {
		int insert = queryMappers.insert(record);
		return insert;
	}
	 
	public int insert(personalQueryDetails record) {
		int insert = personalQueryDetailsMappers.insert(record);
		return insert;
	}
	 
	public int insert(OverdueAccountDetail record) {
		int insert = overdueAccountDetailMapps.insert(record);
		
		return insert;
	}
	 
	public int insert(NoOverdueAccountDetail record) {
		int insert = noOverdueAccountDetailMappers.insert(record);
		return insert;
	}
	 
	public int insert(Fubiao f) {
		int insert = fubiaoMapper.insert(f);
		return insert;
	}
	 
	public int insert(Requestargs r) {
		int insert = requestargsMapper.insert(r);
		return insert;
	}
	 
	public int insert(HousingNoOverdueAccountDetail record) {
		int insert = housingNoOverdueAccountDetailMapper.insert(record);
		return insert;
	}
	 
	public int insert(HousingOverdueAccountDetail record) {
		// TODO Auto-generated method stub
		int insert = housingOverdueAccountDetailMappr.insert(record);
		return insert;
	}
	 
	public int insert(CreditNoOverdueAccountDetail record) {
		// TODO Auto-generated method stub
		int insert = creditNoOverdueAccountDetailMapper.insert(record);
		return insert;
	}
	 
	public int insert(CreditOverdueAccountDetail record) {
		// TODO Auto-generated method stub
		int insert = creditOverdueAccountDetailMappr.insert(record);
		return insert;
	}
	 
	public int insert(LoanNoOverdueAccountDetail record) {
		// TODO Auto-generated method stub
		int insert = loanNoOverdueAccountDetailMapper.insert(record);
		return insert;
	}
	 
	public int insert(LoanOverdueAccountDetail record) {
		// TODO Auto-generated method stub
		int insert = loanOverdueAccountDetailMappr.insert(record);
		return insert;
	}
	 
	public int insert(institutionQueryDetails record) {
		int insert = institutionQueryDetailsMappers.insert(record);
		return insert;
	}
	 
	public int insert(HousingloanNoOverdueAccount record) {
		// TODO Auto-generated method stub
		int insert = housingloanNoOverdueAccountMapper.insert(record);
		return insert;
	}
	 
	public int insert(HousingloanOverdueAccount record) {
		// TODO Auto-generated method stub
		int insert = housingloanOverdueAccountMapper.insert(record);
		return insert;
	}
	 
	public int insert(LoanloanNoOverdueAccount record) {
		// TODO Auto-generated method stub
		int insert = loanloanNoOverdueAccountMapper.insert(record);
		return insert;
	}
	 
	public int insert(LoanloanOverdueAccount record) {
		// TODO Auto-generated method stub
		int insert = loanloanOverdueAccountMapper.insert(record);
		return insert;
	}
	 
	public int selectByReportID(String reportId) {
		// TODO Auto-generated method stub
		int insert = reportApptMappers.selectByReportID(reportId);
		return insert;
	}

}
