package com.flipkart.DAO;

import java.util.List;

import com.flipkart.model.Catalogue;

public interface CatalogueDAO {
	public List<Catalogue> printCatalogue();
	public List<Catalogue> printCatalogueByStudentUsername(String username);
	public List<Catalogue> printCatalogueByProfessorUsername(String username);
	
	public int addCatalogue(Catalogue catalogue);
	public int editCatalogue(Catalogue catalogue);
	public int deleteCatalogue(String catalogue);
}