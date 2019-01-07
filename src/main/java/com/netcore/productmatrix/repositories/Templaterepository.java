package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Template;

@Repository
public interface Templaterepository extends CrudRepository<Template, String>{
	String DATEANDCLIENT_QUERY = "SELECT mc.reportdate, mc.emailtm_created, mc.smstm_created ,mc.bpntm_created,mc.apntm_created,"
			+ "mc.webmsgtm_created,mc.emailtm_used,mc.smstm_used,mc.bpntm_used,mc.apntm_used,mc.webmsgtm_used "
            + "FROM template mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 AND mc.panelname = ?3 "
            + "ORDER BY mc.reportdate DESC";

	@Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
	List<Template> findTemplateReportAllByClientAndDate(String startDate, String endDate, String panelname);

	String DATE_QUERY = "SELECT mc.reportdate, mc.emailtm_created, mc.smstm_created ,mc.bpntm_created,mc.apntm_created,"
			+ "mc.webmsgtm_created,mc.emailtm_used,mc.smstm_used,mc.bpntm_used,mc.apntm_used,mc.webmsgtm_used "
			+ "FROM template mc WHERE mc.reportdate >= ?1 AND mc.reportdate <= ?2 "
			+ "ORDER BY mc.reportdate DESC";

	@Query(value = DATE_QUERY, nativeQuery = true)
	List<Template> findTemplateReportAllByDate(String startDate, String endDate);
}
