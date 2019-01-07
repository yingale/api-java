package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Conversion;
import com.netcore.productmatrix.repositories.ConversionRepository;

@Service
public class ConversionRepostService {

    @Autowired
    private ConversionRepository conversionRepository;

    public Iterable<Conversion> getConversionReportByDateAndClient(String startDate, String endDate, String panelname) {
        return this.conversionRepository.findConversionReportAllByClientAndDate(startDate, endDate, panelname);
    }

    public Iterable<Conversion> getConversionReportByDate(String startDate, String endDate) {
        return this.conversionRepository.findConversionReportAllBydate(startDate, endDate);
    }
}
