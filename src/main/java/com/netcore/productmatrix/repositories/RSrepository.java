package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.ReportScheduling;

@Repository
public interface RSrepository  extends CrudRepository<ReportScheduling, String>{
	String DATEANDCLIENTRS_QUERY = "SELECT rs.reportdate, rs.reportscount "
            + "FROM reportscheduling rs WHERE rs.reportdate > ?1 AND rs.reportdate < ?2 AND rs.panelname = ?3 "
            + "ORDER BY rs.reportdate DESC";

	@Query(value = DATEANDCLIENTRS_QUERY, nativeQuery = true)
	List<ReportScheduling> findRSReportByDateAndClient(String startDate, String endDate, String panelname);

	String DATERS_QUERY = "SELECT rs.reportdate, rs.reportscount "
			+ "FROM reportscheduling rs WHERE rs.reportdate > ?1 AND rs.reportdate < ?2 "
			+ "ORDER BY rs.reportdate DESC";

	@Query(value = DATERS_QUERY, nativeQuery = true)
	List<ReportScheduling> findRSReportByDate(String startDate, String endDate);

}
