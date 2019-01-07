package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.FrequencyCapping;
import com.netcore.productmatrix.Services.FCService;

@RestController
public class FcController {

	@Autowired
	private FCService fcService;
	
	@RequestMapping(
			value = "/frequencycapping",
			params = { "startDate", "endDate"}
	)
	
	public Iterable<FrequencyCapping> getFCReportByDate(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return this.fcService.getFrequencyCappingReportByDateAndClient(startDate, endDate);
	}
	
	
	@RequestMapping(
			value = "/frequencycapping",
			params = {"startDate", "endDate", "panelname"}
		)
	public Iterable<FrequencyCapping> getFCReportByDateAndClient(

			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("panelname") String panelname) {
		return this.fcService.getFrequencyCappingReportByDateAndClient(startDate, endDate, panelname);
	}
}
