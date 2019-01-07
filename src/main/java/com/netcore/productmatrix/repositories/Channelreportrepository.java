package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Channelreport;

@Repository
public interface Channelreportrepository extends CrudRepository<Channelreport, String> {

	String ALLDATE_QUERY = "SELECT chr.reportdate, SUM(chr.emailmsg) AS emailmsg, SUM(chr.smsmsg) AS smsmsg, "
			+ "SUM(chr.bpnmsg) AS bpnmsg, SUM(chr.apnmsg) AS apnmsg, SUM(chr.email) AS email, SUM(chr.sms) AS sms, "
			+ "SUM(chr.apn) AS apn, SUM(chr.bpn) AS bpn "
			+ "FROM channelreport chr WHERE chr.reportdate >= ?1 AND chr.reportdate <= ?2 GROUP BY chr.reportdate "
			+ "ORDER BY chr.reportdate DESC";

	@Query(value = ALLDATE_QUERY, nativeQuery = true)
	List<Channelreport> findReportAllBydate(String startDate, String endDate);

	String ALLDATEANDCLIENT_QUERY = "SELECT chr.reportdate, SUM(chr.emailmsg) AS emailmsg, SUM(chr.smsmsg) AS smsmsg, "
			+ "SUM(chr.bpnmsg) AS bpnmsg, SUM(chr.apnmsg) AS apnmsg, SUM(chr.email) AS email, SUM(chr.sms) AS sms, "
			+ "SUM(chr.apn) AS apn, SUM(chr.bpn) AS bpn "
			+ "FROM channelreport chr WHERE chr.reportdate >= ?1 AND chr.reportdate <= ?2 AND chr.panelname = ?3 "
			+ "GROUP BY chr.reportdate ORDER BY chr.reportdate DESC";

	@Query(value = ALLDATEANDCLIENT_QUERY, nativeQuery = true)
	List<Channelreport> findReportAllByClientAndDate(String startDate, String endDate, String panelname);

	String ALLDATE_QUERY_AUTO = "SELECT chr.reportdate, SUM(chr.emailmsg) AS emailmsg, SUM(chr.smsmsg) AS smsmsg, "
			+ "SUM(chr.bpnmsg) AS bpnmsg, SUM(chr.apnmsg) AS apnmsg, SUM(chr.email) AS email, SUM(chr.sms) AS sms, "
			+ "SUM(chr.apn) AS apn, SUM(chr.bpn) AS bpn "
			+ "FROM channelreportauto chr WHERE chr.reportdate >= ?1 AND chr.reportdate <= ?2 GROUP BY chr.reportdate "
			+ "ORDER BY chr.reportdate DESC";
	
	@Query(value = ALLDATE_QUERY_AUTO, nativeQuery = true)
	List<Channelreport> findAutoReportAllBydate(String startDate, String endDate);

	String ALLDATEANDCLIENT_QUERY_AUTO = "SELECT chr.reportdate, SUM(chr.emailmsg) AS emailmsg, SUM(chr.smsmsg) AS smsmsg, "
			+ "SUM(chr.bpnmsg) AS bpnmsg, SUM(chr.apnmsg) AS apnmsg, SUM(chr.email) AS email, SUM(chr.sms) AS sms, "
			+ "SUM(chr.apn) AS apn, SUM(chr.bpn) AS bpn "
			+ "FROM channelreportauto chr WHERE chr.reportdate >= ?1 AND chr.reportdate <= ?2 AND chr.panelname = ?3 "
			+ "GROUP BY chr.reportdate ORDER BY chr.reportdate DESC";

	@Query(value = ALLDATEANDCLIENT_QUERY_AUTO, nativeQuery = true)
	List<Channelreport> findAutoReportAllByClientAndDate(String startDate, String endDate, String panelname);
}
