package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Template {
	@Id
	private String reportdate;
	
	private Integer emailtm_created;
	
	private Integer smstm_created;
	
	private Integer bpntm_created;
	
	private Integer apntm_created;
	
	private Integer webmsgtm_created;
	
	private Integer emailtm_used;
	
	private Integer smstm_used;
	
	private Integer bpntm_used;
	
	private Integer apntm_used;
	
	private Integer webmsgtm_used;

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public Integer getEmailtm_created() {
		return emailtm_created;
	}

	public void setEmailtm_created(Integer emailtm_created) {
		this.emailtm_created = emailtm_created;
	}

	public Integer getSmstm_created() {
		return smstm_created;
	}

	public void setSmstm_created(Integer smstm_created) {
		this.smstm_created = smstm_created;
	}

	public Integer getBpntm_created() {
		return bpntm_created;
	}

	public void setBpntm_created(Integer bpntm_created) {
		this.bpntm_created = bpntm_created;
	}

	public Integer getApntm_created() {
		return apntm_created;
	}

	public void setApntm_created(Integer apntm_created) {
		this.apntm_created = apntm_created;
	}

	public Integer getWebmsgtm_created() {
		return webmsgtm_created;
	}

	public void setWebmsgtm_created(Integer webmsgtm_created) {
		this.webmsgtm_created = webmsgtm_created;
	}

	public Integer getEmailtm_used() {
		return emailtm_used;
	}

	public void setEmailtm_used(Integer emailtm_used) {
		this.emailtm_used = emailtm_used;
	}

	public Integer getSmstm_used() {
		return smstm_used;
	}

	public void setSmstm_used(Integer smstm_used) {
		this.smstm_used = smstm_used;
	}

	public Integer getBpntm_used() {
		return bpntm_used;
	}

	public void setBpntm_used(Integer bpntm_used) {
		this.bpntm_used = bpntm_used;
	}

	public Integer getApntm_used() {
		return apntm_used;
	}

	public void setApntm_used(Integer apntm_used) {
		this.apntm_used = apntm_used;
	}

	public Integer getWebmsgtm_used() {
		return webmsgtm_used;
	}

	public void setWebmsgtm_used(Integer webmsgtm_used) {
		this.webmsgtm_used = webmsgtm_used;
	}

	@Override
	public String toString() {
		return "Template [reportdate=" + reportdate + ", emailtm_created=" + emailtm_created + ", smstm_created="
				+ smstm_created + ", bpntm_created=" + bpntm_created + ", apntm_created=" + apntm_created
				+ ", webmsgtm_created=" + webmsgtm_created + ", emailtm_used=" + emailtm_used + ", smstm_used="
				+ smstm_used + ", bpntm_used=" + bpntm_used + ", apntm_used=" + apntm_used + ", webmsgtm_used="
				+ webmsgtm_used + "]";
	}
}
