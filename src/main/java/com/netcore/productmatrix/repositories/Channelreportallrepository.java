package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Channelreportall;

@Repository
public interface Channelreportallrepository extends CrudRepository<Channelreportall, String> {
	
	String ALLDATE_QUERY_ALL = "select reportdate,sum(t.emailmsg) as emailmsg ,sum(t.smsmsg) as smsmsg ,sum(t.bpnmsg) as bpnmsg ,sum(t.apnmsg) as apnmsg,sum(t.email) as email,sum(t.sms) as sms,sum(t.bpn) as bpn,sum(t.apn) as apn, sum(t.app)as app, sum(t.web) as web from  \n" + 
			"(Select reportdate,sum(a.emailmsg) as emailmsg, sum(a.smsmsg) as smsmsg, sum(a.bpnmsg) as bpnmsg, sum(a.apnmsg) as apnmsg, sum(a.email) as email,sum(a.sms) as sms,sum(a.bpn) as bpn,sum(a.apn) as apn,sum(a.app) as app,sum(a.web) as web  \n" + 
			"from channelreport a  \n" + 
			"WHERE a.reportdate >= ?1 AND a.reportdate <= ?2 GROUP BY a.reportdate \n" + 
			"UNION  \n" + 
			"Select reportdate, sum(b.emailmsg) as emailmsg, sum(b.smsmsg) as smsmsg, sum(b.bpnmsg) as bpnmsg, sum(b.apnmsg) as apnmsg, sum(b.email) as email,sum(b.sms) as sms,sum(b.bpn) as bpn,sum(b.apn) as apn,sum(b.app) as app,sum(b.web) as web  \n" + 
			"from channelreportauto b \n" + 
			"WHERE b.reportdate >= ?1 AND b.reportdate <= ?2 GROUP BY b.reportdate) \n" + 
			"t group by t.reportdate ORDER BY t.reportdate DESC ;\n";
	
	@Query(value = ALLDATE_QUERY_ALL, nativeQuery = true)
	List<Channelreportall> findAllReportAllBydate(String startDate,String endDate);
	
	String ALLDATEANDCLIENT_QUERY_ALL = "select reportdate,sum(t.emailmsg) as emailmsg,sum(t.smsmsg) as smsmsg,sum(t.bpnmsg) as bpnmsg,sum(t.apnmsg) as apnmsg,sum(t.email) as email,sum(t.sms) as sms,sum(t.bpn) as bpn,sum(t.apn) as apn , sum(t.app)as app, sum(t.web) as web from\n" + 
			"(Select reportdate, sum(a.emailmsg) as emailmsg, sum(a.smsmsg) as smsmsg, sum(a.bpnmsg) as bpnmsg, sum(a.apnmsg) as apnmsg, sum(a.email) as email,sum(a.sms) as sms,sum(a.bpn) as bpn,sum(a.apn) as apn,sum(a.app) as app,sum(a.web) as web  \n" + 
			"from channelreport a  \n" + 
			"WHERE a.reportdate >= ?1 AND a.reportdate <= ?2  AND a.panelname = ?3 GROUP BY a.reportdate \n" + 
			"UNION  \n" + 
			"Select reportdate,sum(b.emailmsg) as emailmsg, sum(b.smsmsg) as smsmsg, sum(b.bpnmsg) as bpnmsg, sum(b.apnmsg) as apnmsg, sum(b.email) as email,sum(b.sms) as sms,sum(b.bpn) as bpn,sum(b.apn) as apn,sum(b.app) as app,sum(b.web) as web  \n" + 
			"from channelreportauto b \n" + 
			"WHERE b.reportdate >= ?1 AND b.reportdate <= ?2  AND b.panelname = ?3 GROUP BY b.reportdate) \n" + 
			"t group by t.reportdate ORDER BY t.reportdate DESC";

	@Query(value = ALLDATEANDCLIENT_QUERY_ALL, nativeQuery = true)
	List<Channelreportall> findAllReportAllByClientAndDate(String startDate, String endDate, String panelname);

}