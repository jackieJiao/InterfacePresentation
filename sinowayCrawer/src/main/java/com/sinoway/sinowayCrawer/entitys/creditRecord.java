package com.sinoway.sinowayCrawer.entitys;

public class creditRecord {
    private Integer id;

    private String reportId;

    private String housingLoanInfo;

    private String creditInfo;

    private String loanInfo;

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

    public String getHousingLoanInfo() {
        return housingLoanInfo;
    }

    public void setHousingLoanInfo(String housingLoanInfo) {
        this.housingLoanInfo = housingLoanInfo == null ? null : housingLoanInfo.trim();
    }

    public String getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(String creditInfo) {
        this.creditInfo = creditInfo == null ? null : creditInfo.trim();
    }

    public String getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(String loanInfo) {
        this.loanInfo = loanInfo == null ? null : loanInfo.trim();
    }
}