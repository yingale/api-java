package com.netcore.productmatrix.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netcore.productmatrix.Entities.Client;

@Repository
public interface Clientrepository extends CrudRepository<Client, String> {
	
	String CLIENT_QUERY = "SELECT DISTINCT(chr.panelname) AS panelname from channelreport chr";
	
	@Query(value = CLIENT_QUERY, nativeQuery = true)
	List<Client> getAllClients();
}
