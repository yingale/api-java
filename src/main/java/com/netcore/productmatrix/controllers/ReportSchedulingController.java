package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.netcore.productmatrix.Entities.ReportScheduling;

import com.netcore.productmatrix.Services.RSService;

@RestController
public class ReportSchedulingController {
	@Autowired
	private RSService rsService;
	
	
	@RequestMapping(
			value = "/reportscheduling",
			params = { "startDate", "endDate"}
	)
	
	public Iterable<ReportScheduling> getReportSchedulingReportByDateAndClient(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return this.rsService.findRSReportByDate(startDate, endDate);
	}

	@RequestMapping(
			value = "/reportscheduling",
			params = {"startDate", "endDate", "panelname"}
		)
	public Iterable<ReportScheduling> getReportSchedulingReportByDateAndClient(

			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("panelname") String panelname) {
		return this.rsService.findRSReportByDateAndClient(startDate, endDate, panelname);
	}
}
