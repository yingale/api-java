package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.netcore.productmatrix.Entities.FrequencyCapping;

public interface FCrepository extends CrudRepository<FrequencyCapping, String> {

    String DATEANDCLIENT_QUERY = "SELECT fc.reportdate, SUM(fc.email) AS email, SUM(fc.sms) AS sms, SUM(fc.bpn) AS bpn, "
                    + "SUM(fc.apn) AS apn, SUM(fc.voice) AS voice "
                    + "FROM channelreportfcapping fc WHERE fc.reportdate >= ?1 AND fc.reportdate <= ?2 AND fc.panelname = ?3 "
                    + "GROUP BY fc.reportdate ORDER BY fc.reportdate DESC";

    @Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
    List<FrequencyCapping> findFCReportAllByClientAndDate(String startDate, String endDate, String panelname);

    String DATE_QUERY = "SELECT fc.reportdate, SUM(fc.email) AS email, SUM(fc.sms) AS sms, SUM(fc.bpn) AS bpn, "
                    + "SUM(fc.apn) AS apn, SUM(fc.voice) AS voice "
                    + "FROM channelreportfcapping fc WHERE fc.reportdate >= ?1 AND fc.reportdate <= ?2 "
                    + "GROUP BY fc.reportdate ORDER BY fc.reportdate DESC";

    @Query(value = DATE_QUERY, nativeQuery = true)
    List<FrequencyCapping> findFCReportAllByDate(String startDate, String endDate);

}
