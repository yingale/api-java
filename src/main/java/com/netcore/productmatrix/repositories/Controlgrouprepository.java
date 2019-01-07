package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Controlgroup;

@Repository
public interface Controlgrouprepository extends CrudRepository<Controlgroup, String>{
	String DATEANDCLIENT_QUERY = "SELECT mc.reportdate, mc.inappmsg, mc.webmsg "
            + "FROM channelreportcontrolgroup mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 AND mc.panelname = ?3 "
            + "ORDER BY mc.reportdate DESC";

	@Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
	List<Controlgroup> findControlReportAllByClientAndDate(String startDate, String endDate, String panelname);

	String DATE_QUERY = "SELECT mc.reportdate, mc.inappmsg, mc.webmsg "
			+ "FROM channelreportcontrolgroup mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 "
			+ "ORDER BY mc.reportdate DESC";

	@Query(value = DATE_QUERY, nativeQuery = true)
	List<Controlgroup> findControlReportAllByDate(String startDate, String endDate);
}
