package com.sinoway.sinowayCrawer.entitys;

public class Requestargs {
	
	private Integer id;

    private String reportId;
	 private String token;
	    
	    private String env;
	    
	    public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getEnv() {
			return env;
		}

		public void setEnv(String env) {
			this.env = env;
		}

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
			this.reportId = reportId;
		}
		
		

}
