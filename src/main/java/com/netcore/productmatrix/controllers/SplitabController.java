package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Splitabtesting;
import com.netcore.productmatrix.Services.SplitabService;

@RestController
public class SplitabController {
	@Autowired
	private SplitabService splitabService;
	
	@RequestMapping(
            value = "/splitabtesting",
            params = { "startDate", "endDate", "panelname" }
    )
    public Iterable<Splitabtesting> getABtestingReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate,
                    @RequestParam("panelname") String panelname) {
            return this.splitabService.getABtestingReportByDateAndClient(startDate, endDate, panelname);
    }
	
	@RequestMapping(
            value = "/splitabtesting",
            params = { "startDate", "endDate"}
    )
    public Iterable<Splitabtesting> getABtestingReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate) {
            return this.splitabService.getABtestingReportByDateAndClient(startDate, endDate);
    }
}
