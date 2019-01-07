package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Makercheckerreport {
	@Id
    private String reportdate;
	
	private Integer email_makerchecker;
	
	private Integer sms_makerchecker;
	
    public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public Integer getEmail_makerchecker() {
		return email_makerchecker;
	}
	public void setEmail_makerchecker(Integer email_makerchecker) {
		this.email_makerchecker = email_makerchecker;
	}
	public Integer getSms_makerchecker() {
		return sms_makerchecker;
	}
	public void setSms_makerchecker(Integer sms_makerchecker) {
		this.sms_makerchecker = sms_makerchecker;
	}
	@Override
	public String toString() {
		return "Makercheckerreport [reportdate=" + reportdate + ", email_makerchecker=" + email_makerchecker
				+ ", sms_makerchecker=" + sms_makerchecker + "]";
	}
}
