package com.sinoway.sinowayCrawer.service.impl;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import com.sinoway.sinowayCrawer.entitys.creditRecord;
import com.sinoway.sinowayCrawer.entitys.institutionQueryDetails;
import com.sinoway.sinowayCrawer.entitys.loanNoOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.loanOverdueAccount;
import com.sinoway.sinowayCrawer.entitys.personalQueryDetails;
import com.sinoway.sinowayCrawer.entitys.query;
import com.sinoway.sinowayCrawer.entitys.reportAppt;
import com.sinoway.sinowayCrawer.entitys.summarys;
import com.sinoway.sinowayCrawer.service.JsonDecService;
import com.sinoway.sinowayCrawer.service.TotalService;

@Service
public class JsonDecServiceImpl implements JsonDecService {

	private TotalService totalService;
	private String reportid;

	public TotalService getTotalService() {
		return totalService;
	}

	@Autowired
	public void setTotalService(TotalService totalService) {
		this.totalService = totalService;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	@Override
	public boolean dec(String data) {
		try{
		
		reportAppt reportAppts = new reportAppt();
		Fubiao fubiao = new Fubiao();

		Requestargs requestargs = new Requestargs();

		
		HousingNoOverdueAccountDetail housingNoOverdueAccountDetails = new HousingNoOverdueAccountDetail();
		HousingOverdueAccountDetail housingOverdueAccountDetails = new HousingOverdueAccountDetail();
		CreditNoOverdueAccountDetail creditNoOverdueAccountDetails = new CreditNoOverdueAccountDetail();
		CreditOverdueAccountDetail creditOverdueAccountDetails = new CreditOverdueAccountDetail();
		LoanNoOverdueAccountDetail loanNoOverdueAccountDetails = new LoanNoOverdueAccountDetail();
		LoanOverdueAccountDetail loanOverdueAccountDetails = new LoanOverdueAccountDetail();
		
		
		
		HousingloanNoOverdueAccount housingloanNoOverdueAccounts = new HousingloanNoOverdueAccount();
		HousingloanOverdueAccount housingloanOverdueAccounts = new HousingloanOverdueAccount();
		LoanloanNoOverdueAccount loanloanNoOverdueAccount = new LoanloanNoOverdueAccount();
		LoanloanOverdueAccount loanloanOverdueAccount = new LoanloanOverdueAccount();
		
		
		
		creditOverdueAccount creditOverdueAccounts = new creditOverdueAccount();
		loanNoOverdueAccount loanNoOverdueAccounts = new loanNoOverdueAccount();
		creditNoOverdueAccount creditNoOverdueAccounts = new creditNoOverdueAccount();
		creditRecord creditRecords = new creditRecord();
		institutionQueryDetails institutionQueryDetailss = new institutionQueryDetails();
		loanOverdueAccount loanOverdueAccounts = new loanOverdueAccount();
		personalQueryDetails personalQueryDetailss = new personalQueryDetails();

		NoOverdueAccountDetail noOverdueAccountDetail = new NoOverdueAccountDetail();

		OverdueAccountDetail overdueAccountDetail = new OverdueAccountDetail();
		query querys = new query();
		summarys summaryss = new summarys();

		StringBuilder status = new StringBuilder();
		Gson gson = new Gson();
		/* req.getInputStream() */
		JsonObject obj = gson.fromJson(data, JsonObject.class);
		String transactions = "";

		if (obj.has("data_info")) {
			JsonElement jsonElementX = obj.get("data_info");
			if(!jsonElementX.isJsonNull()){
				JsonObject asJsonObjects = jsonElementX.getAsJsonObject();
				if(asJsonObjects.has("transactions")){
				
			JsonElement jsonElemen = asJsonObjects.get("transactions");
           if(!jsonElemen.isJsonNull()){
			JsonArray transactionsss = jsonElemen.getAsJsonArray();
			for (int i = 0; i < transactionsss.size(); i++) {
				JsonElement jsonEl = transactionsss.get(i);
				if(!jsonEl.isJsonNull()){
				JsonObject transactionss = jsonEl.getAsJsonObject();
				if (!transactionss.isJsonNull()) {
					// transactions = transactionss.getAsString();
					JsonObject asJsonObject = transactionss.getAsJsonObject();
//					if (asJsonObject.has("report_id")) {
//						String report_id = asJsonObject.get("report_id")
//								.getAsString();
//						reportid = report_id;
//						reportAppts.setReportId(report_id);
//
//					}
					if (asJsonObject.has("report_id")) {
						String report_id = asJsonObject.get("report_id")
								.getAsString();
						reportid = report_id;
						reportAppts.setReportId(report_id);
						if (totalService.selectByReportID(report_id) > 0){
							System.out.println("Already exist...");
							return true;
						}
					}
					
					
					
					
					
					if (asJsonObject.has("report_time")) {
						JsonElement jsonElement = asJsonObject.get("report_time");
						if(!jsonElement.isJsonNull()){
						String report_time = jsonElement
								.getAsString();
						reportAppts.setReportTime(report_time);
						// System.out.println(jsonElement);
						}

					}
					if (asJsonObject.has("update_time")) {
						JsonElement jsonElement = asJsonObject.get("update_time");
						if(!jsonElement.isJsonNull()){
						String update_time = jsonElement
								.getAsString();
						reportAppts.setUpdateTime(update_time);
						}
					}
					if (asJsonObject.has("data_source")) {
						JsonElement jsonElement = asJsonObject.get("data_source");
						if(!jsonElement.isJsonNull()){
						String data_source = jsonElement
								.getAsString();
						reportAppts.setDataSource(data_source);
						}

					}
					if (asJsonObject.has("credit_record")) {
						JsonElement jsonElement = asJsonObject
								.get("credit_record");
						JsonObject credit_record = jsonElement
								.getAsJsonObject();
						if (credit_record.has("housing_loan_info")
								&& !jsonElement.isJsonNull()) {
							JsonElement si=	credit_record.get(
									"housing_loan_info");
							if(!si.isJsonNull()){
							JsonObject housing_loan_info = credit_record.get(
									"housing_loan_info").getAsJsonObject();
							JsonElement JsonElements = credit_record
									.get("housing_loan_info");
							if (housing_loan_info
									.has("no_overdue_account_detail")) {
								JsonArray asJsonArray = housing_loan_info.get(
										"no_overdue_account_detail").getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									String string = asJsonArray.get(j).getAsString();
									housingNoOverdueAccountDetails.setReportid(reportid);
									housingNoOverdueAccountDetails.setDetail(string);
									int insert = totalService
											.insert(housingNoOverdueAccountDetails);
									System.out.println(insert);
								}
								

							}
							if (housing_loan_info
									.has("loan_no_overdue_account")) {
								JsonElement jsonElemens = housing_loan_info
										.get("loan_no_overdue_account");

								JsonArray housing_loan_infos = jsonElemens
										.getAsJsonArray();
								for (int z = 0; z < housing_loan_infos.size(); z++) {
									JsonElement jsonEls = housing_loan_infos
											.get(z);
									JsonObject loan_no_overdue_account = jsonEls
											.getAsJsonObject();

									if (loan_no_overdue_account
											.has("deadline_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("deadline_time");
										if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										housingloanNoOverdueAccounts
												.setDeadlineTime(deadline_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_amount_type")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_amount_type");
										if(!jsonElement2.isJsonNull()){
										String grant_amount_type = jsonElement2
												.getAsString();
										housingloanNoOverdueAccounts
												.setGrantAmountType(grant_amount_type);
										}
									}
									if (loan_no_overdue_account
											.has("clear_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("clear_time");
										if(!jsonElement2.isJsonNull()){
										String clear_time = jsonElement2.getAsString();
										housingloanNoOverdueAccounts
												.setClearTime(clear_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_time");
										if(!jsonElement2.isJsonNull()){
										String grant_time = jsonElement2.getAsString();
										housingloanNoOverdueAccounts
												.setGrantTime(grant_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_amount")) {
										String grant_amount = loan_no_overdue_account
												.get("grant_amount").getAsString();
										if (!grant_amount.equals("")
												&& !grant_amount.equals("null")) {
											float parseFloat = Float
													.parseFloat(grant_amount);
											housingloanNoOverdueAccounts
													.setGrantAmount(parseFloat);
										}
									}
									if (loan_no_overdue_account
											.has("grant_name")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_name");
										if(!jsonElement2.isJsonNull()){
										String grant_name = jsonElement2.getAsString();

										housingloanNoOverdueAccounts
												.setGrantName(grant_name);
										}
									}
									if (loan_no_overdue_account
											.has("grant_company")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_company");
										if(!jsonElement2.isJsonNull()){
										String grant_company = jsonElement2
												.getAsString();

										housingloanNoOverdueAccounts
												.setGrantCompany(grant_company);
										}
									}
									if (loan_no_overdue_account.has("balance")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("balance ");
										if(!jsonElement2.isJsonNull()){
										String balance = jsonElement2.getAsString();
										if (!balance.equals("")
												&& !balance.equals("null")) {
											float balances = Float
													.parseFloat(balance);

											housingloanNoOverdueAccounts
													.setBalance(balances);
										}
										}
									}
									if (loan_no_overdue_account
											.has("expiration_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("expiration_time");
										if(!jsonElement2.isJsonNull()){
										String expiration_time = jsonElement2
												.getAsString();

										housingloanNoOverdueAccounts
												.setExpiration_time(expiration_time);
										}
										}

									housingloanNoOverdueAccounts.setReportId(reportid);
									int insert = totalService
											.insert(housingloanNoOverdueAccounts);

									System.out.println(insert);

								}
								// JsonObject loan_no_overdue_account =
								// housing_loan_info.get("loan_no_overdue_account").getAsJsonObject();

							}
							if (housing_loan_info.has("overdue_account_detail")) {
								JsonArray asJsonArray = housing_loan_info.get(
										"overdue_account_detail").getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									String string = asJsonArray.get(j).getAsString();
									housingOverdueAccountDetails.setReportid(reportid);
									housingOverdueAccountDetails.setDetail(string);
									int insert = totalService
											.insert(housingOverdueAccountDetails);
									System.out.println(insert);
									
								}
								

							}
							if (housing_loan_info.has("loan_overdue_account")) {

								JsonElement jsonElemenss = housing_loan_info
										.get("loan_overdue_account");

								JsonArray loan_overdue_accounts = jsonElemenss
										.getAsJsonArray();
								for (int z = 0; z < loan_overdue_accounts
										.size(); z++) {
									JsonElement jsonEls = loan_overdue_accounts
											.get(z);
									JsonObject loan_overdue_account = jsonEls
											.getAsJsonObject();

									if (loan_overdue_account
											.has("month_of_five_year_90")) {
										String month_of_five_year_90 = loan_overdue_account
												.get("month_of_five_year_90")
												.getAsString();
										int month_of_five_year_90s = Integer
												.parseInt(month_of_five_year_90);
										housingloanOverdueAccounts
												.setMonthOfFiveYear90(month_of_five_year_90s);
									}
									if (loan_overdue_account
											.has("month_of_five_year")) {
										String month_of_five_year = loan_overdue_account
												.get("month_of_five_year")
												.getAsString();
										int month_of_five_years = Integer
												.parseInt(month_of_five_year);
										housingloanOverdueAccounts
												.setMonthOfFiveYear(month_of_five_years);
									}
									if (loan_overdue_account
											.has("grant_amount_type")) {
										String grant_amount_type = loan_overdue_account
												.get("grant_amount_type")
												.getAsString();
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										housingloanOverdueAccounts
												.setGrantAmountType(grant_amount_type);
									}
									if (loan_overdue_account
											.has("overdue_amount")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("overdue_amount");
										if(!jsonElement2.isJsonNull()){
										String overdue_amount = jsonElement2
												.getAsString();
										if (!overdue_amount.equals("")
												&& !overdue_amount
														.equals("null")) {
											float overdue_amounts = Float
													.parseFloat(overdue_amount);
											housingloanOverdueAccounts
													.setOverdueAmount(overdue_amounts);
										}
										}
									}
									if (loan_overdue_account.has("clear_time")) {
										String clear_time = loan_overdue_account
												.get("clear_time").getAsString();
										// float overdue_amounts =
										// Float.parseFloat(clear_time);
										housingloanOverdueAccounts
												.setClearTime(clear_time);
									}
									if (loan_overdue_account.has("grant_time")) {
										String grant_time = loan_overdue_account
												.get("grant_time").getAsString();
										// float overdue_amounts =
										// Float.parseFloat(clear_time);
										housingloanOverdueAccounts
												.setGrantTime(grant_time);
									}
									if (loan_overdue_account
											.has("grant_amount")) {
										String grant_amount = loan_overdue_account
												.get("grant_amount").getAsString();
										if (!grant_amount.equals("")
												&& !grant_amount.equals("null")) {
											float grant_amounts = Float
													.parseFloat(grant_amount);
											housingloanOverdueAccounts
													.setGrantAmount(grant_amounts);
										}
									}
									if (loan_overdue_account.has("grant_name")) {
										String grant_name = loan_overdue_account
												.get("grant_name").getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										housingloanOverdueAccounts
												.setGrantName(grant_name);
									}
									if (loan_overdue_account
											.has("grant_company")) {
										String grant_company = loan_overdue_account
												.get("grant_company")
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										housingloanOverdueAccounts
												.setGrantCompany(grant_company);
									}
									if (loan_overdue_account.has("balance")) {
										String balance = loan_overdue_account
												.get("balance").getAsString();
										if (!balance.equals("")
												&& !balance.equals("null")) {
											float balances = Float
													.parseFloat(balance);
											housingloanOverdueAccounts
													.setBalance(balances);
										}
									}
									if (loan_overdue_account
											.has("expiration_time")) {
										JsonElement jsonElement2 = loan_overdue_account
												.get("expiration_time");
										if(!jsonElement2.isJsonNull()){
										String expiration_time = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										housingloanOverdueAccounts
												.setExpirationTime(expiration_time);
									}}
									if (loan_overdue_account
											.has("deadline_time")) {
									JsonElement jsonElement2 = loan_overdue_account
												.get("deadline_time");
									if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										housingloanOverdueAccounts
												.setDeadlineTime(deadline_time);
									}
									}
									housingloanOverdueAccounts.setReportId(reportid);
									int insert = totalService
											.insert(housingloanOverdueAccounts);
									System.out.println(insert);
								}

								// JsonObject loan_overdue_account =
								// housing_loan_info.get("loan_overdue_account").getAsJsonObject();

							}
						}
					}
						if (credit_record.has("credit_info")) {
							JsonElement jsonElementx = credit_record.get(
									"credit_info");
							if(!jsonElementx.isJsonNull()){
							JsonObject credit_info = jsonElementx.getAsJsonObject();
							if (credit_info.has("no_overdue_account_detail")
									&& !credit_info.get(
											"no_overdue_account_detail")
											.isJsonNull()) {
								JsonElement jsonElement2 = credit_info.get(
										"no_overdue_account_detail");
								JsonArray asJsonArray = jsonElement2.getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									if(!jsonElement2.isJsonNull()){
										String string = asJsonArray.get(j).getAsString();
										creditNoOverdueAccountDetails.setReportid(reportid);

										creditNoOverdueAccountDetails.setDetail(string);
										}
										int is = totalService
												.insert(creditNoOverdueAccountDetails);

										System.out.println(is);
								}
								
							}
							if (credit_info.has("credit_no_overdue_account")) {

								JsonElement credit_no_overdue_accountd = credit_info
										.get("credit_no_overdue_account");
								if(!credit_no_overdue_accountd.isJsonNull()){

								JsonArray credit_no_overdue_accounts = credit_no_overdue_accountd
										.getAsJsonArray();
								for (int f = 0; f < credit_no_overdue_accounts
										.size(); f++) {
									JsonElement jsonEls = credit_no_overdue_accounts
											.get(f);
									JsonObject credit_no_overdue_account = jsonEls
											.getAsJsonObject();

									if (credit_no_overdue_account.has("status")) {
										
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("status");
										if(!jsonElement2.isJsonNull()){
										String statuss = jsonElement2.getAsString();
										creditNoOverdueAccounts
												.setStatus(statuss);
										}
									}
									if (credit_no_overdue_account
											.has("overdraft_balance")) {
										
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("overdraft_balance");
										if(!jsonElement2.isJsonNull()){
										String overdraft_balance = jsonElement2
												.getAsString();
										if (!overdraft_balance.equals("")
												&& !overdraft_balance
														.equals("null")) {
											float overdraft_balances = Float
													.parseFloat(overdraft_balance);
											creditNoOverdueAccounts
													.setOverdraftBalance(overdraft_balances);
										}
										}
									}
									if (credit_no_overdue_account
											.has("deadline_time")) {
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("deadline_time");
										if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										// float overdraft_balances =
										// Float.parseFloat(overdraft_balance);
										creditNoOverdueAccounts
												.setDeadlineTime(deadline_time);
										}
									}
									if (credit_no_overdue_account
											.has("grant_time")) {
										
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("grant_time");
										if(!jsonElement2.isJsonNull()){
										String grant_time = jsonElement2.getAsString();
										// float overdraft_balances =
										// Float.parseFloat(overdraft_balance);
										creditNoOverdueAccounts
												.setGrantTime(grant_time);
										}
									}
									if (credit_no_overdue_account
											.has("credit_limit")) {
										JsonElement s	=credit_no_overdue_account
										.get("credit_limit");
										if(!s.isJsonNull()){
										String credit_limit = s
												.getAsString();
										if (!credit_limit.equals("")
												&& !credit_limit.equals("null")) {
											float credit_limits = Float
													.parseFloat(credit_limit);
											creditNoOverdueAccounts
													.setCreditLimit(credit_limits);
										}
										}
									}
									if (credit_no_overdue_account
											.has("credit_limit")) {
										JsonElement ss =  credit_no_overdue_account
											.get("credit_limit");
										if(!ss.isJsonNull()){
										String credit_limit = ss
												.getAsString();
										if (!credit_limit.equals("")
												&& !credit_limit.equals("null")) {
											float credit_limits = Float
													.parseFloat(credit_limit);
											creditNoOverdueAccounts
													.setCreditLimit(credit_limits);
										}
										}
									}
									if (credit_no_overdue_account
											.has("grant_name")) {
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("grant_name");
										if(!jsonElement2.isJsonNull()){
										String grant_name = jsonElement2.getAsString();
										// float credit_limits =
										// Float.parseFloat(credit_limit);
										creditNoOverdueAccounts
												.setGrantName(grant_name);
										}
									}
									if (credit_no_overdue_account
											.has("grant_account_type")) {
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("grant_account_type");
										if(!jsonElement2.isJsonNull()){
										String grant_account_type = jsonElement2
												.getAsString();
										// float credit_limits =
										// Float.parseFloat(credit_limit);
										creditNoOverdueAccounts
												.setGrantAccountType(grant_account_type);
										}
									}
									if (credit_no_overdue_account
											.has("grant_company")) {
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("grant_company");
										if(!jsonElement2.isJsonNull()){
										String grant_company = jsonElement2
												.getAsString();
										// float credit_limits =
										// Float.parseFloat(credit_limit);
										creditNoOverdueAccounts
												.setGrantCompany(grant_company);
										}
									}
									if (credit_no_overdue_account
											.has("used_quotas")) {
										JsonElement jsonElement2 = credit_no_overdue_account
										.get("used_quotas");
										if(!jsonElement2.isJsonNull()){
										String used_quotas = jsonElement2.getAsString();
										if (!used_quotas.equals("")
												&& !used_quotas.equals("null")) {
											float used_quotass = Float
													.parseFloat(used_quotas);
											creditNoOverdueAccounts
													.setUsedQuotas(used_quotass);
										}
										}
									}
									creditNoOverdueAccounts
											.setReportId(reportid);
									int insert = totalService
											.insert(creditNoOverdueAccounts);
									System.out.println(insert);
								}

								// JsonObject credit_no_overdue_account =
								// credit_info.get("credit_no_overdue_account").getAsJsonObject();
							}
							}
							if (credit_info.has("credit_overdue_account")) {

								JsonElement credit_overdue_accountd = credit_info
										.get("credit_overdue_account");

								JsonArray credit_overdue_accounts = credit_overdue_accountd
										.getAsJsonArray();
								for (int k = 0; k < credit_overdue_accounts
										.size(); k++) {
									JsonElement jsonEls = credit_overdue_accounts
											.get(k);
									JsonObject credit_overdue_account = jsonEls
											.getAsJsonObject();

									if (credit_overdue_account.has("status")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("status");
										if(!jsonElement2.isJsonNull()){
										String statuss = jsonElement2.getAsString();
										creditOverdueAccounts
												.setStatus(statuss);
										}
									}
									if (credit_overdue_account
											.has("month_of_five_year_90")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("month_of_five_year_90");
										if(!jsonElement2.isJsonNull()){
										String month_of_five_year_90 = jsonElement2
												.getAsString();
										int month_of_five_year_90s = Integer
												.parseInt(month_of_five_year_90);
										creditOverdueAccounts
												.setMonthOfFiveYear90(month_of_five_year_90s);}
									}
									if (credit_overdue_account
											.has("credit_limit")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("credit_limit");
										if(!jsonElement2.isJsonNull()){
										String credit_limit = jsonElement2.getAsString();
										if (!credit_limit.equals("")
												&& !credit_limit.equals("null")) {
											float credit_limits = Float
													.parseFloat(credit_limit);
											creditOverdueAccounts
													.setCreditLimit(credit_limits);
										}
										}
									}
									if (credit_overdue_account
											.has("month_of_five_year")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("month_of_five_year");
										if(!jsonElement2.isJsonNull()){
										String month_of_five_year = jsonElement2
												.getAsString();
										int month_of_five_years = Integer
												.parseInt(month_of_five_year);
										creditOverdueAccounts
												.setMonthOfFiveYear(month_of_five_years);
										}
									}
									if (credit_overdue_account
											.has("overdue_amount")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("overdue_amount");
										if(!jsonElement2.isJsonNull()){
										String overdue_amount = jsonElement2
												.getAsString();
										if (!overdue_amount.equals("")
												&& !overdue_amount
														.equals("null")) {
											float overdue_amounts = Float
													.parseFloat(overdue_amount);
											creditOverdueAccounts
													.setOverdueAmount(overdue_amounts);
										}
										}
									}
									if (credit_overdue_account
											.has("grant_account_type")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("grant_account_type");
										if(!jsonElement2.isJsonNull()){
										String grant_account_type = jsonElement2
												.getAsString();
										creditOverdueAccounts
												.setGrantAccountType(grant_account_type);
										}
									}
									if (credit_overdue_account
											.has("grant_name")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("grant_name");
										if(!jsonElement2.isJsonNull()){
										String grant_name = jsonElement2.getAsString();
										creditOverdueAccounts
												.setGrantName(grant_name);
										}
									}
									if (credit_overdue_account
											.has("grant_company")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("grant_company");
										if(!jsonElement2.isJsonNull()){
										String grant_company = jsonElement2
												.getAsString();
										creditOverdueAccounts
												.setGrantCompany(grant_company);
										}
									}
									if (credit_overdue_account
											.has("grant_time")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("grant_time");
										if(!jsonElement2.isJsonNull()){
										String grant_time = jsonElement2.getAsString();
										creditOverdueAccounts
												.setGrantTime(grant_time);
										}
									}
									if (credit_overdue_account
											.has("used_quotas")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("used_quotas");
										if(!jsonElement2.isJsonNull()){
										String used_quotas = jsonElement2.getAsString();
										if (!used_quotas.equals("")
												&& !used_quotas.equals("null")) {
											float used_quotass = Float
													.parseFloat(used_quotas);
											creditOverdueAccounts
													.setUsedQuotas(used_quotass);
										}
										}
									}
									if (credit_overdue_account
											.has("deadline_time")) {
										JsonElement jsonElement2 = credit_overdue_account
										.get("deadline_time");
										if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										// float used_quotass =
										// Float.parseFloat(used_quotas);
										creditOverdueAccounts
												.setDeadlineTime(deadline_time);
										}
									}
									
										

								}

								// JsonObject credit_overdue_account =
								// credit_info.get("credit_overdue_account").getAsJsonObject();

							}
							/*if(credit_info.has("overdue_account_detail")){
								JsonArray asJsonArray = credit_info.get("overdue_account_detail").getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									String asString = asJsonArray.get(j).getAsString();
									overdueAccountDetail.setReportid(reportid);
									overdueAccountDetail.setDetail(asString);
								int s=	totalService.insert(overdueAccountDetail);
								System.out.println(s);
									
									
								}*/
							if (credit_info
									.has("overdue_account_detail")) {
								JsonElement jsonElement2 = credit_info
								.get("overdue_account_detail");
								JsonArray asJsonArray = jsonElement2.getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									String deadline_time = asJsonArray.get(j).getAsString();
									
										
										creditOverdueAccountDetails
												.setDetail(deadline_time);
										creditOverdueAccountDetails
												.setReportid(reportid);
										int iss = totalService
												.insert(creditOverdueAccountDetails);
										System.out.println(iss);
										
									}
									creditOverdueAccounts.setReportId(reportid);
									int insert = totalService
											.insert(creditOverdueAccounts);
									System.out.println(insert);
								}
								
							
						}
						}
						if (credit_record.has("summarys")) {

							JsonElement jsonElement2 = credit_record
									.get("summarys");
							if(!jsonElement2.isJsonNull()){
							JsonArray summarysx = jsonElement2.getAsJsonArray();
							// String string = summarys.getAsString();
							for (int l = 0; l < summarysx.size(); l++) {
								JsonElement jsonElement3 = summarysx.get(l);
								JsonObject summarys = jsonElement3
										.getAsJsonObject();

								if (summarys.has("guarantee_number")) {
									JsonElement jsonElement4 = summarys.get(
											"guarantee_number");
									if(!jsonElement4.isJsonNull()){
									String guarantee_number = jsonElement4.getAsString();
									int guarantee_numbers = Integer
											.parseInt(guarantee_number);
									summaryss
											.setGuaranteeNumber(guarantee_numbers);
									}
								}
								if (summarys.has("no_settle_account_number")) {
									JsonElement jsonElement4 = summarys
									.get("no_settle_account_number");
									if(!jsonElement4.isJsonNull()){
									String no_settle_account_number = jsonElement4
											.getAsString();
									int no_settle_account_numbers = Integer
											.parseInt(no_settle_account_number);
									summaryss
											.setNoSettleAccountNumber(no_settle_account_numbers);
									}
								}
								if (summarys.has("account_number")) {
									JsonElement jsonElement4 = summarys.get(
											"account_number");
									if(!jsonElement4.isJsonNull()){
									String account_number = jsonElement4.getAsString();
									int account_numbers = Integer
											.parseInt(account_number);
									summaryss.setAccountNumber(account_numbers);
									}
								}
								if (summarys.has("type")) {
									JsonElement jsonElement4 = summarys.get("type");
									if(!jsonElement4.isJsonNull()){
									String type = jsonElement4
											.getAsString();
									// int account_numbers =
									// Integer.parseInt(account_number);
									summaryss.setType(type);
									}
								}
								if (summarys.has("overdue_account_num")) {
									JsonElement jsonElement4 = summarys.get(
											"overdue_account_num");
									if(!jsonElement4.isJsonNull()){
									String overdue_account_num = jsonElement4.getAsString();
									int overdue_account_nums = Integer
											.parseInt(overdue_account_num);
									summaryss
											.setGuaranteeNumber(overdue_account_nums);
									}
								}
								if (summarys.has("overdue90_account_num")) {
									JsonElement jsonElement4 = summarys
									.get("overdue90_account_num");
									if(!jsonElement4.isJsonNull()){
									String overdue90_account_num = jsonElement4
											.getAsString();
									int overdue90_account_nums = Integer
											.parseInt(overdue90_account_num);
									summaryss
											.setGuaranteeNumber(overdue90_account_nums);
									}
								}
								summaryss.setReportId(reportid);
								int insert = totalService.insert(summaryss);
								System.out.println("haha");

							}
						}
						}
						if (credit_record.has("loan_info")) {
							JsonElement jsonElement33 = credit_record.get(
									"loan_info");
							if(!jsonElement33.isJsonNull()){
							JsonObject loan_info = jsonElement33.getAsJsonObject();
							if (loan_info.has("no_overdue_account_detail")) {
								JsonElement jsonElement2 = loan_info
								.get("no_overdue_account_detail");
								JsonArray asJsonArray = loan_info
								.get("no_overdue_account_detail").getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									String string = asJsonArray.get(j).getAsString();
									loanNoOverdueAccountDetails.setReportid(reportid);
									loanNoOverdueAccountDetails.setDetail(string);
									totalService.insert(loanNoOverdueAccountDetails);
								}
								
							}
							if (loan_info.has("loan_no_overdue_account")) {

								JsonElement loan_no_overdue_account2 = loan_info
										.get("loan_no_overdue_account");

								JsonArray loan_no_overdue_accountx = loan_no_overdue_account2
										.getAsJsonArray();
								// String string = summarys.getAsString();
								for (int l = 0; l < loan_no_overdue_accountx
										.size(); l++) {
									JsonElement loan_no_overdue_accountx3 = loan_no_overdue_accountx
											.get(l);
									JsonObject loan_no_overdue_account = loan_no_overdue_accountx3
											.getAsJsonObject();

									if (loan_no_overdue_account
											.has("deadline_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("deadline_time");
										if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										// int overdue90_account_nums =
										// Integer.parseInt(overdue90_account_num);
										loanloanNoOverdueAccount
												.setDeadlineTime(deadline_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_amount_type")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_amount_type");
										if(!jsonElement2.isJsonNull()){
										String grant_amount_type = jsonElement2
												.getAsString();
										// int overdue90_account_nums =
										// Integer.parseInt(overdue90_account_num);
										loanloanNoOverdueAccount
												.setGrantAmountType(grant_amount_type);
										}
									}
									if (loan_no_overdue_account
											.has("clear_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("clear_time");
										if(!jsonElement2.isJsonNull()){
										String clear_time = jsonElement2.getAsString();
										// int overdue90_account_nums =
										// Integer.parseInt(overdue90_account_num);
										loanloanNoOverdueAccount
												.setClearTime(clear_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_time");
										if(!jsonElement2.isJsonNull()){
										String grant_time = jsonElement2.getAsString();
										// int overdue90_account_nums =
										// Integer.parseInt(overdue90_account_num);
										loanloanNoOverdueAccount
												.setGrantTime(grant_time);
										}
									}
									if (loan_no_overdue_account
											.has("grant_amount")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_amount");
										if(!jsonElement2.isJsonNull()){
										String grant_amount = jsonElement2.getAsString();
										if (!grant_amount.equals("")
												&& !grant_amount.equals("null")) {
											float grant_amounts = Float
													.parseFloat(grant_amount);
											loanloanNoOverdueAccount
													.setGrantAmount(grant_amounts);
										}
										}
									}
									if (loan_no_overdue_account
											.has("grant_name")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_name");
										if(!jsonElement2.isJsonNull()){
										String grant_name = jsonElement2.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										loanloanNoOverdueAccount
												.setGrantName(grant_name);
										}
									}
									if (loan_no_overdue_account
											.has("grant_company")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("grant_company");
										if(!jsonElement2.isJsonNull()){
										String grant_company = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										loanloanNoOverdueAccount
												.setGrantCompany(grant_company);
										}
									}
									if (loan_no_overdue_account.has("balance")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("balance");
										if(!jsonElement2.isJsonNull()){
										String balance = jsonElement2.getAsString();
										if (!balance.equals("")
												&& !balance.equals("null")) {
											float balances = Float
													.parseFloat(balance);
											loanloanNoOverdueAccount
													.setBalance(balances);
										}
										}
									}
									if (loan_no_overdue_account
											.has("expiration_time")) {
										JsonElement jsonElement2 = loan_no_overdue_account
										.get("expiration_time");
										if(!jsonElement2.isJsonNull()){
										String expiration_time = jsonElement2
												.getAsString();
										loanloanNoOverdueAccount.setExpiration_time(expiration_time);
										
										}
										// float balances =
										// Float.parseFloat(balance);
										// loanNoOverdueAccounts.sete
									}

								}
								loanloanNoOverdueAccount.setReportId(reportid);
								int s = totalService
										.insert(loanloanNoOverdueAccount);
								System.out.println(s);
							}
							if (loan_info.has("overdue_account_detail")) {
								
								JsonElement jsonElement2 = loan_info.get(
										"overdue_account_detail");
								JsonArray asJsonArray = jsonElement2.getAsJsonArray();
								for (int j = 0; j < asJsonArray.size(); j++) {
									
								
								if(!jsonElement2.isJsonNull()){
								String string = asJsonArray.get(j).getAsString();
								loanOverdueAccountDetails.setReportid(reportid);
								loanOverdueAccountDetails.setDetail(string);
								
								}
								int ss = totalService
										.insert(loanOverdueAccountDetails);
								System.out.println(ss);
								}
							}
							if (loan_info.has("loan_overdue_account")) {

								JsonElement loan_overdue_account2 = loan_info
										.get("loan_overdue_account");

								JsonArray loan_overdue_accountx = loan_overdue_account2
										.getAsJsonArray();
								// String string = summarys.getAsString();
								for (int l = 0; l < loan_overdue_accountx
										.size(); l++) {
									JsonElement loan_overdue_accountx3 = loan_overdue_accountx
											.get(l);
									JsonObject loan_overdue_account = loan_overdue_accountx3
											.getAsJsonObject();

									if (loan_overdue_account
											.has("month_of_five_year_90")) {
										
										JsonElement jsonElement2 = loan_overdue_account
										.get("month_of_five_year_90");
										if(!jsonElement2.isJsonNull()){
										String month_of_five_year_90 = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										int month_of_five_year_90s = Integer
												.parseInt(month_of_five_year_90);
										loanloanOverdueAccount
												.setMonthOfFiveYear90(month_of_five_year_90s);
										}
									}

									if (loan_overdue_account
											.has("month_of_five_year")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("month_of_five_year");
										if(!jsonElement2.isJsonNull()){
										String month_of_five_year = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										int month_of_five_years = Integer
												.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setMonthOfFiveYear(month_of_five_years);
										}
									}
									if (loan_overdue_account
											.has("grant_amount_type")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("grant_amount_type");
										if(!jsonElement2.isJsonNull()){
										String grant_amount_type = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setGrantAmountType(grant_amount_type);}
									}
									if (loan_overdue_account
											.has("overdue_amount")) {
										 JsonElement jsonElement2 = loan_overdue_account
											.get("overdue_amount");
										 if(!jsonElement2.isJsonNull()){
										String overdue_amount = jsonElement2
												.getAsString();

										if (!overdue_amount.equals("")
												&& !overdue_amount
														.equals("null")) {
											float overdue_amounts = Float
													.parseFloat(overdue_amount);
											// int month_of_five_years =
											// Integer.parseInt(month_of_five_year);
											loanloanOverdueAccount
													.setOverdueAmount(overdue_amounts);
										}
										 }
									}
									if (loan_overdue_account.has("clear_time")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("clear_time");
										if(!jsonElement2.isJsonNull()){
										String clear_time = jsonElement2.getAsString();
										// float overdue_amounts =
										// Float.parseFloat(clear_time);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setClearTime(clear_time);
										}
									}
									if (loan_overdue_account.has("grant_time")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("grant_time");
										if(!jsonElement2.isJsonNull()){
										String grant_time = jsonElement2.getAsString();
										// float overdue_amounts =
										// Float.parseFloat(clear_time);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setGrantTime(grant_time);
										}
									}
									if (loan_overdue_account
											.has("grant_amount")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("grant_amount");
										if(!jsonElement2.isJsonNull()){
										String grant_amount = jsonElement2.getAsString();
										if (!grant_amount.equals("")
												&& !grant_amount.equals("null")) {
											float grant_amounts = Float
													.parseFloat(grant_amount);
											// int month_of_five_years =
											// Integer.parseInt(month_of_five_year);
											loanloanOverdueAccount
													.setGrantAmount(grant_amounts);
										}
									}
									}
									if (loan_overdue_account.has("grant_name")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("grant_name");
										if(!jsonElement2.isJsonNull()){
										String grant_name = jsonElement2.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setGrantName(grant_name);
										}
									}
									if (loan_overdue_account
											.has("grant_company")) {
										 JsonElement jsonElement2 = loan_overdue_account
											.get("grant_company");
										 if(!jsonElement2.isJsonNull()){
										String grant_company = jsonElement2
												.getAsString();
										// float grant_amounts =
										// Float.parseFloat(grant_amount);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setGrantCompany(grant_company);
										 }
									}
									if (loan_overdue_account.has("balance")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("balance");
										if(!jsonElement2.isJsonNull()){
										String balance = jsonElement2.getAsString();
										if (!balance.equals("")
												&& !balance.equals("null")) {
											float balances = Float
													.parseFloat(balance);
											// int month_of_five_years =
											// Integer.parseInt(month_of_five_year);
											loanloanOverdueAccount
													.setBalance(balances);
										}
										}
									}
									if (loan_overdue_account
											.has("expiration_time")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("expiration_time");
										if(!jsonElement2.isJsonNull()){
										String expiration_time = jsonElement2
												.getAsString();
										// float balances =
										// Float.parseFloat(balance);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setExpirationTime(expiration_time);
										}
									}
									if (loan_overdue_account
											.has("deadline_time")) {
										JsonElement jsonElement2 = loan_overdue_account
										.get("deadline_time");
										if(!jsonElement2.isJsonNull()){
										String deadline_time = jsonElement2
												.getAsString();
										// float balances =
										// Float.parseFloat(balance);
										// int month_of_five_years =
										// Integer.parseInt(month_of_five_year);
										loanloanOverdueAccount
												.setDeadlineTime(deadline_time);
										}
									}
									loanloanOverdueAccount.setReportId(reportid);
									int ss = totalService
											.insert(loanloanOverdueAccount);
									System.out.println(ss);

								}
							}
						}
						}

					}
					if (asJsonObject.has("query")) {
						JsonElement jsonElementq = asJsonObject.get("query");
						if(!jsonElementq.isJsonNull()){
						JsonObject query = jsonElementq
								.getAsJsonObject();
						if (query.has("personal_query_details")) {
							JsonElement personal_query_details2 = query
									.get("personal_query_details");

							JsonArray personal_query_details2x = personal_query_details2
									.getAsJsonArray();
							// String string = summarys.getAsString();
							for (int l = 0; l < personal_query_details2x.size(); l++) {
								JsonElement personal_query_details2x3 = personal_query_details2x
										.get(l);
								JsonObject personal_query_details = personal_query_details2x3
										.getAsJsonObject();
								if (personal_query_details.has("query_time")) {
									JsonElement jsonElement = personal_query_details
									.get("query_time");
									if(!jsonElement.isJsonNull()){
									String query_time = jsonElement.getAsString();
									personalQueryDetailss
											.setQueryTime(query_time);
									}
								}
								if (personal_query_details.has("query_reason")) {
									JsonElement jsonElement = personal_query_details
									.get("query_reason");
									if(!jsonElement.isJsonNull()){
									String query_reason = jsonElement.getAsString();
									personalQueryDetailss
											.setQueryReason(query_reason);
									}
								}
								if (personal_query_details
										.has("query_operator")) {
									 JsonElement jsonElement = personal_query_details
										.get("query_operator");
									 if(!jsonElement.isJsonNull()){
									String query_operator = jsonElement.getAsString();
									personalQueryDetailss
											.setQueryOperator(query_operator);
									 }
								}
								personalQueryDetailss.setReportId(reportid);
								totalService.insert(personalQueryDetailss);
							}
							// JsonObject personal_query_details =
							// asJsonObject.get("personal_query_details").getAsJsonObject();

						}
						if (query.has("institution_query_details")) {
							JsonElement institution_query_details2 = query
									.get("institution_query_details");

							JsonArray institution_query_details2x = institution_query_details2
									.getAsJsonArray();
							// String string = summarys.getAsString();
							for (int l = 0; l < institution_query_details2x.size(); l++) {
								JsonElement institution_query_details2x3 = institution_query_details2x
										.get(l);
								JsonObject institution_query_details = institution_query_details2x3
										.getAsJsonObject();
								if (institution_query_details.has("query_time")) {
									JsonElement jsonElement = institution_query_details
									.get("query_time");
									if(!jsonElement.isJsonNull()){
									String query_time = jsonElement.getAsString();
									institutionQueryDetailss.setQueryTime(query_time);
									}
								}
								if (institution_query_details.has("query_reason")) {
									JsonElement jsonElement = institution_query_details
									.get("query_reason");
									if(!jsonElement.isJsonNull()){
									String query_reason = jsonElement.getAsString();
									institutionQueryDetailss.setQueryReason(query_reason);
									}
								}
								if (institution_query_details
										.has("query_operator")) {
									 JsonElement jsonElement = institution_query_details
										.get("query_operator");
									 if(!jsonElement.isJsonNull()){
									String query_operator = jsonElement.getAsString();
									institutionQueryDetailss.setQueryOperator(query_operator);
									 }
								}
								institutionQueryDetailss.setReportId(reportid);
								totalService.insert(institutionQueryDetailss);
								
							
						}
						}
					}
					}
					if (asJsonObject.has("request_time")) {
						JsonElement jsonElement = asJsonObject.get("request_time");
						if(!jsonElement.isJsonNull()){
						String request_time = jsonElement
								.getAsString();
						reportAppts.setRequestTime(request_time);
						}
					}
					if (asJsonObject.has("queried_number")) {
						JsonElement jsonElement = asJsonObject.get(
								"queried_number");
						if(!jsonElement.isJsonNull()){
						String queried_number = jsonElement.getAsString();
						reportAppts.setQueriedNumber(queried_number);
						}
					}
					if (asJsonObject.has("queried_papers")) {
						JsonElement jsonElement = asJsonObject.get(
								"queried_papers");
						if(!jsonElement.isJsonNull()){
						String queried_papers = jsonElement.getAsString();
						reportAppts.setQueriedPapers(queried_papers);
						}

					}
					if (asJsonObject.has("query_marriage")) {
						JsonElement jsonElement = asJsonObject.get(
								"query_marriage");
						if(!jsonElement.isJsonNull()){
						String query_marriage = jsonElement.getAsString();
						reportAppts.setQueryMarriage(query_marriage);
						}

					}
					if (asJsonObject.has("token")) {
						JsonElement jsonElement = asJsonObject.get("token");
						if(!jsonElement.isJsonNull()){
						String token = jsonElement.getAsString();
						reportAppts.setToken(token);
						}

					}
					if (asJsonObject.has("queried_name")) {
						JsonElement jsonElement = asJsonObject.get("queried_name");
						if(!jsonElement.isJsonNull()){
						String queried_name = jsonElement
								.getAsString();
						reportAppts.setQueriedName(queried_name);
						}

					}
					if (asJsonObject.has("version")) {
						JsonElement jsonElement = asJsonObject.get("version");
						if(!jsonElement.isJsonNull()){
						String version = jsonElement.getAsString();
						reportAppts.setVersion(version);
						}

					}

				}
			}
			}
			// JsonElement transactionss = obj.get("transactions");
		}
		}
	}
		if (obj.has("status")) {
			JsonElement jsonElement = obj.get("status");
			if(!jsonElement.isJsonNull()){
			String statuss1 = jsonElement.getAsString();

			fubiao.setStatus(statuss1);
			}
		}
		if (obj.has("update_time")) {
			JsonElement jsonElement = obj.get("update_time");
			if(!jsonElement.isJsonNull()){
			String update_times = jsonElement.getAsString();

			fubiao.setUpdatetime(update_times);
			}

		}
		if (obj.has("error_code")) {
			JsonElement jsonElement = obj.get("error_code");
			if(!jsonElement.isJsonNull()){
			String error_codes = jsonElement.getAsString();

			int error_codess = Integer.parseInt(error_codes);
			fubiao.setError_code(error_codess);
			}
		}
		
		if (obj.has("error_msg")) {
			JsonElement jsonElement = obj.get("error_msg");
			if(!jsonElement.isJsonNull()){
			String error_msgs = jsonElement.getAsString();

			// int errors_msgs = Integer.parseInt(error_msgs);
			fubiao.setErrormsg(error_msgs);
			}

		}
		if (obj.has("request_args")) {
			JsonElement jsonElements2 = obj.get("request_args");

			JsonArray request_argsx = jsonElements2.getAsJsonArray();
			// String string = summarys.getAsString();
			for (int l = 0; l < request_argsx.size(); l++) {
				JsonElement request_argsx3 = request_argsx.get(l);
				JsonObject asJsonObjects = request_argsx3.getAsJsonObject();
				if (asJsonObjects.has("token")) {
					JsonElement jsonElement = asJsonObjects.get("token");
					if(!jsonElement.isJsonNull()){
					String token = jsonElement.getAsString();
					requestargs.setToken(token);
					}
				}
				if (asJsonObjects.has("env")) {
					JsonElement jsonElement = asJsonObjects.get("env");
					if(!jsonElement.isJsonNull()){
					String env = jsonElement.getAsString();
					requestargs.setEnv(env);
					}
				}
			}
			// JsonObject asJsonObjects =
			// obj.get("request_args").getAsJsonObject();

		}
		requestargs.setReportId(reportid);
		fubiao.setReportId(reportid);

		int insert = totalService.insert(fubiao);
		int insert2 = totalService.insert(requestargs);
		System.out.println(insert);
		System.out.println(insert2);
		reportAppts.setReportId(reportid);
		int cont1 = totalService.insert(reportAppts);
		System.out.println(cont1);

		System.out.println(reportAppts);
		}
		
		return true;
		}catch(Exception e){
			return false;
		}
		 
	}
	
}
