package com.netcore.productmatrix.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Entities.Channelreportall;
import com.netcore.productmatrix.Entities.Channelreport;
import com.netcore.productmatrix.Entities.Client;
import com.netcore.productmatrix.Entities.Channelreportpull;

import com.netcore.productmatrix.Services.ChannelService;
import com.netcore.productmatrix.Services.ClientService;

@RestController
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@Autowired
	private ClientService clientService;

	@RequestMapping(
		value = "/channelreport",
		params = { "startDate", "endDate", "type" }
	)
	public Iterable<Channelreport> getReportByDate(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("type") String type) {
		return this.channelService.getReportByDate(startDate, endDate, type);
	}

	@RequestMapping(
			value = "/channelreport",
			params = {"startDate", "endDate", "panelname", "type"}
		)
	public Iterable<Channelreport> getReportByDateAndClient(

			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("panelname") String panelname,
			@RequestParam("type") String type) {
		return this.channelService.getReportByDateAndClient(startDate, endDate, panelname, type);
	}
	
	@RequestMapping(
			value = "/channelreportall",
			params = {"startDate", "endDate", "type"}
		)
		public Iterable<Channelreportall> getAllReportByDate(
				@RequestParam("startDate") String startDate,
				@RequestParam("endDate") String endDate,
				@RequestParam("type") String type
		) {
			return this.channelService.getAllReportByDate(startDate, endDate,type);
		}
		
		@RequestMapping(
				value = "/channelreportall",
				params = {"startDate", "endDate", "panelname", "type"}
			)
		public Iterable<Channelreportall> getAllReportByDateAndClient(
				@RequestParam("startDate") String startDate,
				@RequestParam("endDate") String endDate,
				@RequestParam("panelname") String panelname,
				@RequestParam("type") String type
		) {
			return this.channelService.getAllReportByDateAndClient(startDate, endDate, panelname, type);
		}
	@RequestMapping("/channelclients")
	public Iterable<Client> getAllclients() {
		return this.clientService.getChannelClients();
	}

	
	@RequestMapping(
			value = "/downloadchannelreport", 
			params = { "startDate", "endDate", "type" })
	public void downloadReportByType(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("type") String type, 
			HttpServletResponse response
	) throws IOException {
		String csvFileName = this.channelService.getReportName(type, startDate, endDate);
		Iterable<Channelreport> reportRows = this.channelService.getReportByDate(startDate, endDate, type);
		this.channelService.generatecsvReport(response, reportRows, csvFileName);
		

	}

	@RequestMapping(
		value = "/downloadchannelreport", 
		params = { "startDate", "endDate", "panelname", "type" }
	)
	public void downloadReportByDateAndClient(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("panelname") String panelname,
			@RequestParam("type") String type,
			HttpServletResponse response
	) throws IOException {
		String csvFileName = this.channelService.getReportName(type, startDate, endDate, panelname);
		Iterable<Channelreport> reportRows = this.channelService.getReportByDateAndClient(startDate, endDate, panelname, type);
		this.channelService.generatecsvReport(response, reportRows, csvFileName);
	}
	
	@RequestMapping(
            value = "/channelreportpull",
            params = { "startDate", "endDate", "panelname" }
    )
    public Iterable<Channelreportpull> getPullReportByDateAndClient(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate,
                    @RequestParam("panelname") String panelname) {
            return this.channelService.getPullReportByDateAndClient(startDate, endDate, panelname);
    }
	
	@RequestMapping(
            value = "/channelreportpull",
            params = { "startDate", "endDate"}
    )
    public Iterable<Channelreportpull> getPullReportByDate(
                    @RequestParam("startDate") String startDate,
                    @RequestParam("endDate") String endDate) {
            return this.channelService.getPullReportByDateAndClient(startDate, endDate);
    }
	
}
