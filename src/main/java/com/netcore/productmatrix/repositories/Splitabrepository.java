package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Splitabtesting;

@Repository
public interface Splitabrepository extends CrudRepository<Splitabtesting, String>{
	String DATEANDCLIENT_QUERY = "SELECT mc.reportdate, SUM(mc.split_emailcount) AS split_emailcount, SUM(mc.split_apncount) AS split_apncount "
            + "FROM splitabtesting mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 AND mc.panelname = ?3 "
            + "GROUP BY mc.reportdate ORDER BY mc.reportdate DESC";

	@Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
	List<Splitabtesting> findSplitabReportAllByClientAndDate(String startDate, String endDate, String panelname);

	String DATE_QUERY = "SELECT mc.reportdate, SUM(mc.split_emailcount) AS split_emailcount, SUM(mc.split_apncount) AS split_apncount "
			+ "FROM splitabtesting mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 "
			+ "GROUP BY mc.reportdate ORDER BY mc.reportdate DESC";

	@Query(value = DATE_QUERY, nativeQuery = true)
	List<Splitabtesting> findSplitabReportAllByDate(String startDate, String endDate);

}
