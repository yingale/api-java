package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Makercheckerreport;

@Repository
public interface Makercheckerrepository extends CrudRepository<Makercheckerreport, String>{
	String DATEANDCLIENT_QUERY = "SELECT mc.reportdate, SUM(mc.email_makerchecker) AS email_makerchecker, SUM(mc.sms_makerchecker) AS sms_makerchecker "
            + "FROM makerchecker mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 AND mc.panelname = ?3 "
            + "GROUP BY mc.reportdate ORDER BY mc.reportdate DESC";

	@Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
	List<Makercheckerreport> findMakerReportAllByClientAndDate(String startDate, String endDate, String panelname);

	String DATE_QUERY = "SELECT mc.reportdate, SUM(mc.email_makerchecker) AS email_makerchecker, SUM(mc.sms_makerchecker) AS sms_makerchecker "
			+ "FROM makerchecker mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 "
			+ "GROUP BY mc.reportdate ORDER BY mc.reportdate DESC";

	@Query(value = DATE_QUERY, nativeQuery = true)
	List<Makercheckerreport> findMakerReportAllByDate(String startDate, String endDate);
}
