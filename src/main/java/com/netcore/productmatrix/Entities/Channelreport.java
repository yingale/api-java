package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Channelreport {

	@Id
	private String reportdate;

	private Integer emailmsg;
	private Integer smsmsg;
	private Integer bpnmsg;
	private Integer apnmsg;
	private Integer email;
	private Integer sms;
	private Integer bpn;
	private Integer apn;

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public Integer getEmailmsg() {
		return emailmsg;
	}

	public void setEmailmsg(Integer emailmsg) {
		this.emailmsg = emailmsg;
	}

	public Integer getSmsmsg() {
		return smsmsg;
	}

	public void setSmsmsg(Integer smsmsg) {
		this.smsmsg = smsmsg;
	}

	public Integer getBpnmsg() {
		return bpnmsg;
	}

	public void setBpnmsg(Integer bpnmsg) {
		this.bpnmsg = bpnmsg;
	}

	public Integer getApnmsg() {
		return apnmsg;
	}

	public void setApnmsg(Integer apnmsg) {
		this.apnmsg = apnmsg;
	}

	public Integer getEmail() {
		return email;
	}

	public void setEmail(Integer email) {
		this.email = email;
	}

	public Integer getSms() {
		return sms;
	}

	public void setSms(Integer sms) {
		this.sms = sms;
	}

	public Integer getBpn() {
		return bpn;
	}

	public void setBpn(Integer bpn) {
		this.bpn = bpn;
	}

	public Integer getApn() {
		return apn;
	}

	public void setApn(Integer apn) {
		this.apn = apn;
	}

	@Override
	public String toString() {
		return "Channelreport [reportdate=" + reportdate + ", emailmsg=" + emailmsg + ", smsmsg=" + smsmsg
				+ ", bpnmsg=" + bpnmsg + ", apnmsg=" + apnmsg + ", email="
				+ email + ", sms=" + sms + ", bpn=" + bpn + ", apn=" + apn
				+ "]";
	}

}
