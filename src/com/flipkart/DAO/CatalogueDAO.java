package com.flipkart.DAO;

import java.util.List;

import com.flipkart.model.Course;

public interface CatalogueDAO {
	public List<Course> printCatalogue();
	public List<Course> printCatalogueByStudentUsername(String username);
	public List<Course> printCatalogueByProfessorUsername(String username);
	
	public int addCatalogue(Course course);
	public int editCatalogue(Course course);
	public int deleteCatalogue(String catalogue);
}
