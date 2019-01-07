package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Channelreportpull {
	@Id
    private String reportdate;

    private Integer iamcreated;
    private Integer iamrunning;
    private Integer iamexpired;
    
    private Integer wmcreated;
    private Integer wmrunning;
    private Integer wmexpired;
    
    private Integer autocreated;
    private Integer autorunning;
    private Integer autoexpired;
    
    public String getReportdate() {
            return reportdate;
    }

    public void setReportdate(String reportdate) {
            this.reportdate = reportdate;
    }
    //
    public Integer getIamcreated() {
            return iamcreated;
    }

    public void setIamcreated(Integer iamcreated) {
            this.iamcreated = iamcreated;
    }
    
    public Integer getIamrunning() {
            return iamrunning;
    }

    public void setIamrunning(Integer iamrunning) {
            this.iamrunning = iamrunning;
    }
    public Integer getIamexpired() {
            return iamexpired;
    }

    public void setIamexpired(Integer iamexpired) {
            this.iamexpired = iamexpired;
    }

    public Integer getWmcreated() {
            return wmcreated;
    }

    public void setWmcreated(Integer wmcreated) {
            this.wmcreated = wmcreated;
    }
    
    public Integer getWmrunning() {
            return wmrunning;
    }

    public void setWmrunning(Integer wmrunning) {
            this.wmrunning = wmrunning;
    }
    public Integer getWmexpired() {
            return wmexpired;
    }

    public void setWmexpired(Integer wmexpired) {
            this.wmexpired = wmexpired;
    }

    public Integer getAutocreated() {
            return autocreated;
    }

    public void setAutocreated(Integer autocreated) {
            this.autocreated = autocreated;
    }
    
    public Integer getAutorunning() {
            return autorunning;
    }

    public void setAutorunning(Integer autorunning) {
            this.autorunning = autorunning;
    }
    public Integer getAutoexpired() {
            return autoexpired;
    }

    public void setAutoexpired(Integer autoexpired) {
            this.autoexpired = autoexpired;
    }
    
    @Override
    public String toString() {
            return "Channelreportpull [reportdate=" + reportdate + ", iamcreated=" + iamcreated 
                            + ", iamrunning=" + iamrunning + ", iamexpired=" + iamexpired 
                            + ", wmcreated=" + wmcreated + ", wmrunning=" + wmrunning + ", wmexpired=" + wmexpired 
                            + ", autocreated=" + autocreated + ", autorunning=" + autorunning
                            + ", autoexpired=" + autoexpired+ "]";
    }
}
