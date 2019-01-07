package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrequencyCapping {

    @Id
    private String reportdate;

    /**
     * @return the reportdate
     */
    public String getReportdate() {
        return reportdate;
    }

    /**
     * @param reportdate
     *            the reportdate to set
     */
    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    /**
     * @return the email
     */
    public Integer getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(Integer email) {
        this.email = email;
    }

    /**
     * @return the sms
     */
    public Integer getSms() {
        return sms;
    }

    /**
     * @param sms
     *            the sms to set
     */
    public void setSms(Integer sms) {
        this.sms = sms;
    }

    /**
     * @return the bpn
     */
    public Integer getBpn() {
        return bpn;
    }

    /**
     * @param bpn
     *            the bpn to set
     */
    public void setBpn(Integer bpn) {
        this.bpn = bpn;
    }

    /**
     * @return the apn
     */
    public Integer getApn() {
        return apn;
    }

    /**
     * @param apn
     *            the apn to set
     */
    public void setApn(Integer apn) {
        this.apn = apn;
    }

    /**
     * @return the voice
     */
    public Integer getVoice() {
        return voice;
    }

    /**
     * @param voice
     *            the voice to set
     */
    public void setVoice(Integer voice) {
        this.voice = voice;
    }

    private Integer email;
    private Integer sms;
    private Integer bpn;
    private Integer apn;
    private Integer voice;

}
