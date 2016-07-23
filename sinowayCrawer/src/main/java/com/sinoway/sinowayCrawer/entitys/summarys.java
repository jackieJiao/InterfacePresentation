package com.sinoway.sinowayCrawer.entitys;

public class summarys {
    private Integer id;

    private String reportId;

    private Integer guaranteeNumber;

    private Integer noSettleAccountNumber;

    private Integer accountNumber;

    private String type;

    private Integer overdueAccountNum;

    private Integer overdue90AccountNum;

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

    public Integer getGuaranteeNumber() {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(Integer guaranteeNumber) {
        this.guaranteeNumber = guaranteeNumber;
    }

    public Integer getNoSettleAccountNumber() {
        return noSettleAccountNumber;
    }

    public void setNoSettleAccountNumber(Integer noSettleAccountNumber) {
        this.noSettleAccountNumber = noSettleAccountNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOverdueAccountNum() {
        return overdueAccountNum;
    }

    public void setOverdueAccountNum(Integer overdueAccountNum) {
        this.overdueAccountNum = overdueAccountNum;
    }

    public Integer getOverdue90AccountNum() {
        return overdue90AccountNum;
    }

    public void setOverdue90AccountNum(Integer overdue90AccountNum) {
        this.overdue90AccountNum = overdue90AccountNum;
    }
}