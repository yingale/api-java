package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Makercheckerreport;
import com.netcore.productmatrix.Services.MakercheckerService;

@RestController
public class MakercheckerController {
	@Autowired
	private MakercheckerService makercheckerService;
	
	@RequestMapping(
            value = "/makercheckerreport",
            params = { "startDate", "endDate", "panelname" }
    )
    public Iterable<Makercheckerreport> getMakercheckerReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate,
                    @RequestParam("panelname") String panelname) {
            return this.makercheckerService.getMakercheckerReportByDateAndClient(startDate, endDate, panelname);
    }
	
	@RequestMapping(
            value = "/makercheckerreport",
            params = { "startDate", "endDate"}
    )
    public Iterable<Makercheckerreport> getMakercheckerReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate) {
            return this.makercheckerService.getMakercheckerReportByDateAndClient(startDate, endDate);
    }
}
