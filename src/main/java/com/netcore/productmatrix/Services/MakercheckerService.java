package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Makercheckerreport;
import com.netcore.productmatrix.repositories.Makercheckerrepository;

@Service
public class MakercheckerService {
	@Autowired
	private Makercheckerrepository makercheckerrepository;
	
	public Iterable<Makercheckerreport> getMakercheckerReportByDateAndClient(String startDate, String endDate, String panelname) {
	    return this.makercheckerrepository.findMakerReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public Iterable<Makercheckerreport> getMakercheckerReportByDateAndClient(String startDate, String endDate) {
	    return this.makercheckerrepository.findMakerReportAllByDate(startDate, endDate);
	}
}
