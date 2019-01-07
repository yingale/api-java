package com.netcore.productmatrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Template;
import com.netcore.productmatrix.Services.TemplateService;

@RestController
public class TemplateController {
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(
            value = "/template",
            params = { "startDate", "endDate", "panelname" }
    )
    public Iterable<Template> getTemplateReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate,
                    @RequestParam("panelname") String panelname) {
            return this.templateService.getTemplateReportByDateAndClient(startDate, endDate, panelname);
    }
	
	@RequestMapping(
            value = "/template",
            params = { "startDate", "endDate"}
    )
    public Iterable<Template> getTemplateReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate) {
            return this.templateService.getTemplateReportByDateAndClient(startDate, endDate);
    }
}
