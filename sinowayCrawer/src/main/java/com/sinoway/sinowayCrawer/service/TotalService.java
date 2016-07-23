package com.sinoway.sinowayCrawer.service;

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

public interface TotalService {
	int insert(reportAppt record);
	int selectByReportID(String reportId);
	
    int insert(loanNoOverdueAccount record);
    
    int insert(loanOverdueAccount record);
    
    int insert(creditNoOverdueAccount record);
    
    int insert(creditOverdueAccount record);
    
    int insert(summarys record);
    
    //int insert(loanNoOverdueAccount record);
    int insert(query record);
    
    int insert(personalQueryDetails record);
    
    int insert(OverdueAccountDetail record);
    
    int insert(NoOverdueAccountDetail record);
    
    int insert(Fubiao f);
    
    int insert(Requestargs r);
    
    int insert(HousingNoOverdueAccountDetail record);
    
    int insert(HousingOverdueAccountDetail record);
    
    int insert(CreditNoOverdueAccountDetail record);
    
    int insert(CreditOverdueAccountDetail record);
    
    int insert(LoanNoOverdueAccountDetail record);
    
    int insert(LoanOverdueAccountDetail record);
    
   int  insert(institutionQueryDetails record);
   
   int  insert(HousingloanNoOverdueAccount record);
   int  insert(HousingloanOverdueAccount record);
   int  insert(LoanloanNoOverdueAccount record);
   int  insert(LoanloanOverdueAccount record);
   
   
}
