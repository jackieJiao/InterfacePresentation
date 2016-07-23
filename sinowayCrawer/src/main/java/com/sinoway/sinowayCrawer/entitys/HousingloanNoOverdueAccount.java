package com.sinoway.sinowayCrawer.entitys;

public class HousingloanNoOverdueAccount {
    private Integer id;

    private String reportId;

    private String deadlineTime;

    private Float balance;

    private String grantAmountType;

    private String clearTime;

    private String grantTime;

    private Float grantAmount;

    private String grantName;

    private String grantCompany;

    private String expiration_time;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public String getExpiration_time() {
		return expiration_time;
	}

	public void setExpiration_time(String expiration_time) {
		this.expiration_time = expiration_time;
	}

	public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime == null ? null : deadlineTime.trim();
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getGrantAmountType() {
        return grantAmountType;
    }

    public void setGrantAmountType(String grantAmountType) {
        this.grantAmountType = grantAmountType == null ? null : grantAmountType.trim();
    }

    public String getClearTime() {
        return clearTime;
    }

    public void setClearTime(String clearTime) {
        this.clearTime = clearTime == null ? null : clearTime.trim();
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime == null ? null : grantTime.trim();
    }

    public Float getGrantAmount() {
        return grantAmount;
    }

    public void setGrantAmount(Float grantAmount) {
        this.grantAmount = grantAmount;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName == null ? null : grantName.trim();
    }

    public String getGrantCompany() {
        return grantCompany;
    }

    public void setGrantCompany(String grantCompany) {
        this.grantCompany = grantCompany == null ? null : grantCompany.trim();
    }
}