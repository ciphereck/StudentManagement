package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.CatalogueDAOImpl;
import com.flipkart.model.Catalogue;

public interface Service {
	CatalogueDAOImpl catalogueDAO = new CatalogueDAOImpl();
	public default List<Catalogue> printCatalogue() {
		return catalogueDAO.printCatalogue();
	}
}
