package com.netcore.productmatrix.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	private String panelname;

	public String getPanelname() {
		return panelname;
	}

	public void setPanelname(String panelname) {
		this.panelname = panelname;
	}

}
