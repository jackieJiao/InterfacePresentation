package com.sinoway.sinowayCrawer.entitys;

public class loanOverdueAccount {
    private Integer id;

    private String reportId;

    private Integer monthOfFiveYear90;

    private Integer monthOfFiveYear;

    private String grantAmountType;

    private Float overdueAmount;

    private String clearTime;

    private String grantTime;

    private Float grantAmount;

    private String grantName;

    private String grantCompany;

    private Float balance;

    private String expirationTime;

    private String deadlineTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public Integer getMonthOfFiveYear90() {
        return monthOfFiveYear90;
    }

    public void setMonthOfFiveYear90(Integer monthOfFiveYear90) {
        this.monthOfFiveYear90 = monthOfFiveYear90;
    }

    public Integer getMonthOfFiveYear() {
        return monthOfFiveYear;
    }

    public void setMonthOfFiveYear(Integer monthOfFiveYear) {
        this.monthOfFiveYear = monthOfFiveYear;
    }

    public String getGrantAmountType() {
        return grantAmountType;
    }

    public void setGrantAmountType(String grantAmountType) {
        this.grantAmountType = grantAmountType == null ? null : grantAmountType.trim();
    }

    public Float getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Float overdueAmount) {
        this.overdueAmount = overdueAmount;
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

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime == null ? null : expirationTime.trim();
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime == null ? null : deadlineTime.trim();
    }
}