package com.netcore.productmatrix.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Template;

import com.netcore.productmatrix.repositories.Templaterepository;

@Service
public class TemplateService {
	@Autowired
	private Templaterepository templaterepository;
	
	public Iterable<Template> getTemplateReportByDateAndClient (String startDate, String endDate, String panelname) {
	    return this.templaterepository.findTemplateReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public Iterable<Template> getTemplateReportByDateAndClient (String startDate, String endDate) {
	    return this.templaterepository.findTemplateReportAllByDate(startDate, endDate);
	}
}
