package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.netcore.productmatrix.Entities.Conversion;

@Repository
public interface ConversionRepository extends CrudRepository<Conversion, String>{
	String ALLDATE_QUERY = "SELECT con.reportdate, con.email AS emailmsg, con.sms AS smsmsg, "
			+ "con.bpn AS bpnmsg, con.apn AS apnmsg, con.voice AS voicemsg "
			+ "FROM channelreportconversion con WHERE con.reportdate >= ?1 AND con.reportdate <= ?2 GROUP BY con.reportdate "
			+ "ORDER BY con.reportdate DESC";

	@Query(value = ALLDATE_QUERY, nativeQuery = true)
	List<Conversion> findConversionReportAllBydate(String startDate, String endDate);
	
	String ALLDATEANDCLIENT_QUERY = "SELECT con.reportdate, con.email AS emailmsg, con.sms AS smsmsg, "
			+ "con.bpn AS bpnmsg, con.apn AS apnmsg, con.voice AS voicemsg "
			+ "FROM channelreportconversion con WHERE con.reportdate >= ?1 AND con.reportdate <= ?2 AND con.panelname = ?3 "
			+ "GROUP BY con.reportdate ORDER BY con.reportdate DESC";

	@Query(value = ALLDATEANDCLIENT_QUERY, nativeQuery = true)
	List<Conversion> findConversionReportAllByClientAndDate(String startDate, String endDate, String panelname);
	

}
