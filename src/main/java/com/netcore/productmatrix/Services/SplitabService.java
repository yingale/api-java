package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Splitabtesting;

import com.netcore.productmatrix.repositories.Splitabrepository;

@Service
public class SplitabService {
	
	@Autowired
	private Splitabrepository splitabrepository;
	
	public Iterable<Splitabtesting> getABtestingReportByDateAndClient (String startDate, String endDate, String panelname) {
	    return this.splitabrepository.findSplitabReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public Iterable<Splitabtesting> getABtestingReportByDateAndClient (String startDate, String endDate) {
	    return this.splitabrepository.findSplitabReportAllByDate(startDate, endDate);
	}
}
