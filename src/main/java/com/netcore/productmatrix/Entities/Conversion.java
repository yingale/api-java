package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conversion {

    @Id
    private String reportdate;

    private Integer emailmsg;
    private Integer smsmsg;
    private Integer bpnmsg;
    private Integer apnmsg;
    private Integer voicemsg;

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

    public Integer getVoicemsg() {
        return voicemsg;
    }

    public void setVoicemsg(Integer voicemsg) {
        this.voicemsg = voicemsg;
    }

    @Override
    public String toString() {
        return "Conversionreport [reportdate=" + reportdate + ", emailmsg=" + emailmsg + ", smsmsg=" + smsmsg
                        + ", bpnmsg=" + bpnmsg + ", apnmsg=" + apnmsg + ", voicemsg=" + voicemsg + "]";
    }

}
