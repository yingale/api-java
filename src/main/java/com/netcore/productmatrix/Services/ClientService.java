package com.netcore.productmatrix.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcore.productmatrix.Entities.Client;
import com.netcore.productmatrix.repositories.Clientrepository;

@Service
public class ClientService {

	@Autowired
	private Clientrepository clientrepository;

	public List<Client> getChannelClients() {
		return this.clientrepository.getAllClients();
	}
}
