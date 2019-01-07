package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.ReportScheduling;
import com.netcore.productmatrix.repositories.RSrepository;

@Service
public class RSService {

    @Autowired
    private RSrepository rsrepository;

    public Iterable<ReportScheduling> findRSReportByDateAndClient(String startDate, String endDate, String panelname) {
        return this.rsrepository.findRSReportByDateAndClient(startDate, endDate, panelname);
    }

    public Iterable<ReportScheduling> findRSReportByDate(String startDate, String endDate) {
        return this.rsrepository.findRSReportByDate(startDate, endDate);
    }

}
