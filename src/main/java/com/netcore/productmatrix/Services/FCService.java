package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.FrequencyCapping;
import com.netcore.productmatrix.repositories.FCrepository;

@Service
public class FCService {

	@Autowired
	private FCrepository fcrepository;
	
	
	 public Iterable<FrequencyCapping> getFrequencyCappingReportByDateAndClient(String startDate, String endDate, String panelname) {
		    return this.fcrepository.findFCReportAllByClientAndDate(startDate, endDate, panelname);
		}
		
	public Iterable<FrequencyCapping> getFrequencyCappingReportByDateAndClient(String startDate, String endDate) {
		    return this.fcrepository.findFCReportAllByDate(startDate, endDate);
	}
}
