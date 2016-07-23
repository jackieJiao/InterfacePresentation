package com.sinoway.sinowayCrawer.entitys;

public class institutionQueryDetails {
    private Integer id;

    private String reportId;

    private String queryTime;

    private String queryReason;

    private String queryOperator;

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

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime == null ? null : queryTime.trim();
    }

    public String getQueryReason() {
        return queryReason;
    }

    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason == null ? null : queryReason.trim();
    }

    public String getQueryOperator() {
        return queryOperator;
    }

    public void setQueryOperator(String queryOperator) {
        this.queryOperator = queryOperator == null ? null : queryOperator.trim();
    }
}