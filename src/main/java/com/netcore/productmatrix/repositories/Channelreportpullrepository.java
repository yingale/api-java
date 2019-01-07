package com.netcore.productmatrix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcore.productmatrix.Entities.Channelreportpull;

@Repository
public interface Channelreportpullrepository extends CrudRepository<Channelreportpull, String> {
    String DATEANDCLIENT_QUERY = "SELECT pc.reportdate, SUM(pc.iamcreated) AS iamcreated, SUM(pc.iamrunning) AS iamrunning, "
                    + "SUM(pc.iamexpired) AS iamexpired, SUM(pc.wmcreated) AS wmcreated, SUM(pc.wmrunning) AS wmrunning, SUM(pc.wmexpired) AS wmexpired, "
                    + "SUM(pc.autocreated) AS autocreated, SUM(pc.autorunning) AS autorunning, SUM(pc.autoexpired) AS autoexpired "
                    + "FROM pullchannel pc WHERE pc.reportdate >= ?1 AND pc.reportdate <= ?2 AND pc.panelname = ?3 "
                    + "GROUP BY pc.reportdate ORDER BY pc.reportdate DESC";

    @Query(value = DATEANDCLIENT_QUERY, nativeQuery = true)
    List<Channelreportpull> findPullReportAllByClientAndDate(String startDate, String endDate, String panelname);

    String DATE_QUERY = "SELECT pc.reportdate, SUM(pc.iamcreated) AS iamcreated, SUM(pc.iamrunning) AS iamrunning, "
                    + "SUM(pc.iamexpired) AS iamexpired, SUM(pc.wmcreated) AS wmcreated, SUM(pc.wmrunning) AS wmrunning, SUM(pc.wmexpired) AS wmexpired, "
                    + "SUM(pc.autocreated) AS autocreated, SUM(pc.autorunning) AS autorunning, SUM(pc.autoexpired) AS autoexpired "
                    + "FROM pullchannel pc WHERE pc.reportdate >= ?1 AND pc.reportdate <= ?2 "
                    + "GROUP BY pc.reportdate ORDER BY pc.reportdate DESC";

    @Query(value = DATE_QUERY, nativeQuery = true)
    List<Channelreportpull> findPullReportAllByDate(String startDate, String endDate);

}
