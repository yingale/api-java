package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Splitabtesting {
	@Id
	private String reportdate;
	
	private Integer split_emailcount;
	
	private Integer split_apncount;

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public Integer getSplit_emailcount() {
		return split_emailcount;
	}

	public void setSplit_emailcount(Integer split_emailcount) {
		this.split_emailcount = split_emailcount;
	}

	public Integer getSplit_apncount() {
		return split_apncount;
	}

	public void setSplit_apncount(Integer split_apncount) {
		this.split_apncount = split_apncount;
	}

	@Override
	public String toString() {
		return "splitabtesting [reportdate=" + reportdate + ", split_emailcount=" + split_emailcount
				+ ", split_apncount=" + split_apncount + "]";
	}
	
}
