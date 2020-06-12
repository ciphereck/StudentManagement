package com.flipkart.service;

import com.flipkart.DAO.CatalogueDAOImpl;

public interface Service {
	CatalogueDAOImpl catalogueDAO = new CatalogueDAOImpl();
	public default void printCatalogue() {
		catalogueDAO.printCatalogue();
	}
}
