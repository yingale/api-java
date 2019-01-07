package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Controlgroup;
import com.netcore.productmatrix.repositories.Controlgrouprepository;

@Service
public class ControlgroupService {
	@Autowired
	private Controlgrouprepository controlgrouprepository;
	
	public Iterable<Controlgroup> getControlGroupReportByDateAndClient(String startDate, String endDate, String panelname) {
	    return this.controlgrouprepository.findControlReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public Iterable<Controlgroup> getControlGroupReportByDateAndClient(String startDate, String endDate) {
	    return this.controlgrouprepository.findControlReportAllByDate(startDate, endDate);
	}
}
