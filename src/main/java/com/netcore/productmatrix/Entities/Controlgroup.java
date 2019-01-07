package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Controlgroup {
	
	@Id
    private String reportdate;
	
	private Integer inappmsg;
	
	private Integer webmsg;

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public Integer getInappmsg() {
		return inappmsg;
	}

	public void setInappmsg(Integer inappmsg) {
		this.inappmsg = inappmsg;
	}

	public Integer getWebmsg() {
		return webmsg;
	}

	public void setWebmsg(Integer webmsg) {
		this.webmsg = webmsg;
	}

	@Override
	public String toString() {
		return "Controlgroup [reportdate=" + reportdate + ", inappmsg=" + inappmsg + ", webmsg=" + webmsg + "]";
	}
}
