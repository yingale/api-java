package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Controlgroup;
import com.netcore.productmatrix.Services.ControlgroupService;

@RestController
public class ControlgroupController {
	@Autowired
	private ControlgroupService controlgroupService;
	
	@RequestMapping(
            value = "/controlgroup",
            params = { "startDate", "endDate", "panelname" }
    )
    public Iterable<Controlgroup> getControlGroupReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate,
                    @RequestParam("panelname") String panelname) {
            return this.controlgroupService.getControlGroupReportByDateAndClient(startDate, endDate, panelname);
    }
	
	@RequestMapping(
            value = "/controlgroup",
            params = { "startDate", "endDate"}
    )
    public Iterable<Controlgroup> getControlGroupReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate) {
            return this.controlgroupService.getControlGroupReportByDateAndClient(startDate, endDate);
    }

}
