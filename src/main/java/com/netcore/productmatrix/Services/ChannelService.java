package com.netcore.productmatrix.Services;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.netcore.productmatrix.Entities.Channelreport;
import com.netcore.productmatrix.Entities.Channelreportall;
import com.netcore.productmatrix.Entities.Channelreportpull;
import com.netcore.productmatrix.repositories.Channelreportallrepository;
import com.netcore.productmatrix.repositories.Channelreportpullrepository;
import com.netcore.productmatrix.repositories.Channelreportrepository;
@Service
public class ChannelService {

	@Autowired
	private Channelreportrepository channelreportrepository;
	@Autowired
	private Channelreportallrepository channelreportallrepository;
	@Autowired
	private Channelreportpullrepository channelreportpullrepository;

	public Iterable<Channelreport> getReportByDate(String startDate, String endDate, String type) {
		if(type.equals("automation")) {
			return this.channelreportrepository.findAutoReportAllBydate(startDate, endDate);
		}
		return this.channelreportrepository.findReportAllBydate(startDate, endDate);
	}

	public Iterable<Channelreport> getReportByDateAndClient(String startDate, String endDate, String panelname, String type) {
		if(type.equals("automation")) {
			return this.channelreportrepository.findAutoReportAllByClientAndDate(startDate, endDate, panelname);
		}
		return this.channelreportrepository.findReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public String getReportName(String type, String startDate, String endDate) {
		String csvFileName = type + "_channel_report_" + startDate + "_" + endDate + ".csv";
		return csvFileName;
	}
	
	public String getReportName(String type, String startDate, String endDate, String panelname) {
		String csvFileName = type + "_channel_report_" + startDate + "_" + endDate + "_" + panelname + ".csv";
		return csvFileName;
	}
	
	public void generatecsvReport(HttpServletResponse response, Iterable<Channelreport> reportRows, String csvFileName) 
			throws IOException {
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "ReportDate", "EMAILMSG", "SMSMSG", "BPNMSG", "APNMSG", "EMAIL", "SMS", "BPN", "APN" };
		csvWriter.writeHeader(header);
		for (Channelreport row : reportRows) {
			csvWriter.write(row, header);
		}
		csvWriter.close();
	}
	public Iterable<Channelreportall> getAllReportByDate(String startDate, String endDate, String type) {
			return this.channelreportallrepository.findAllReportAllBydate(startDate, endDate);
	}
	
	public Iterable<Channelreportall> getAllReportByDateAndClient(String startDate, String endDate, String panelname, String type) {
		return this.channelreportallrepository.findAllReportAllByClientAndDate(startDate, endDate, panelname); 
	}
	
	public Iterable<Channelreportpull> getPullReportByDateAndClient(String startDate, String endDate, String panelname) {
	    return this.channelreportpullrepository.findPullReportAllByClientAndDate(startDate, endDate, panelname);
	}
	
	public Iterable<Channelreportpull> getPullReportByDateAndClient(String startDate, String endDate) {
	    return this.channelreportpullrepository.findPullReportAllByDate(startDate, endDate);
	}


}
