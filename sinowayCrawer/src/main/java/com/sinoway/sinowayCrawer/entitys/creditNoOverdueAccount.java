package com.sinoway.sinowayCrawer.entitys;

public class creditNoOverdueAccount {
    private Integer id;

    private String reportId;

    private String status;

    private Float overdraftBalance;

    private String deadlineTime;

    private Float creditLimit;

    private String grantTime;

    private String grantAccountType;

    private String grantName;

    private String grantCompany;

    private Float usedQuotas;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Float getOverdraftBalance() {
        return overdraftBalance;
    }

    public void setOverdraftBalance(Float overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime == null ? null : deadlineTime.trim();
    }

    public Float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime == null ? null : grantTime.trim();
    }

    public String getGrantAccountType() {
        return grantAccountType;
    }

    public void setGrantAccountType(String grantAccountType) {
        this.grantAccountType = grantAccountType == null ? null : grantAccountType.trim();
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

    public Float getUsedQuotas() {
        return usedQuotas;
    }

    public void setUsedQuotas(Float usedQuotas) {
        this.usedQuotas = usedQuotas;
    }
}