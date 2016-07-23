package com.sinoway.sinowayCrawer.entitys;

public class reportAppt {
    private Integer id;

    private String token;

    private String version;

    private String dataSource;

    private String updateTime;

    private String reportTime;

    private String requestTime;

    private String queriedNumber;

    private String queriedPapers;

    private String queryMarriage;

    private String queriedName;

    private String reportId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime == null ? null : reportTime.trim();
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime == null ? null : requestTime.trim();
    }

    public String getQueriedNumber() {
        return queriedNumber;
    }

    public void setQueriedNumber(String queriedNumber) {
        this.queriedNumber = queriedNumber == null ? null : queriedNumber.trim();
    }

    public String getQueriedPapers() {
        return queriedPapers;
    }

    public void setQueriedPapers(String queriedPapers) {
        this.queriedPapers = queriedPapers == null ? null : queriedPapers.trim();
    }

    public String getQueryMarriage() {
        return queryMarriage;
    }

    public void setQueryMarriage(String queryMarriage) {
        this.queryMarriage = queryMarriage == null ? null : queryMarriage.trim();
    }

    public String getQueriedName() {
        return queriedName;
    }

    public void setQueriedName(String queriedName) {
        this.queriedName = queriedName == null ? null : queriedName.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

	@Override
	public String toString() {
		return "reportAppt [id=" + id + ", token=" + token + ", version="
				+ version + ", dataSource=" + dataSource + ", updateTime="
				+ updateTime + ", reportTime=" + reportTime + ", requestTime="
				+ requestTime + ", queriedNumber=" + queriedNumber
				+ ", queriedPapers=" + queriedPapers + ", queryMarriage="
				+ queryMarriage + ", queriedName=" + queriedName
				+ ", reportId=" + reportId + "]";
	}
    
    
}