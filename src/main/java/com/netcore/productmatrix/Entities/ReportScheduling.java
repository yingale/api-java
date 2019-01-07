package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportScheduling {

    @Id
    private String reportdate;

    private Integer reportscount;

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public Integer getReportcount() {
        return reportscount;
    }

    public void setReportcount(Integer reportcount) {
        this.reportscount = reportcount;
    }

    @Override
    public String toString() {
        return "ReportScheduling [reportdate=" + reportdate + ", reportcount=" + reportscount + "]";
    }

}
