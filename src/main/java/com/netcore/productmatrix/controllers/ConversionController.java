package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Conversion;
import com.netcore.productmatrix.Services.ConversionRepostService;


@RestController
public class ConversionController {
	
	@Autowired
	private ConversionRepostService conversionService;
	
	@RequestMapping(
			value = "/conversionreport",
			params = { "startDate", "endDate"}
	)
	
	public Iterable<Conversion> getConversionReportByDate(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return this.conversionService.getConversionReportByDate(startDate, endDate);
	}

	@RequestMapping(
			value = "/conversionreport",
			params = {"startDate", "endDate", "panelname"}
		)
	public Iterable<Conversion> getConversionReportByDateAndClient(

			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("panelname") String panelname) {
		return this.conversionService.getConversionReportByDateAndClient(startDate, endDate, panelname);
	}
	
	
	

}
