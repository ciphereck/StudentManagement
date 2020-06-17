package com.flipkart.model;

public class Catalogue {
	String catalogueId;
	String catalogueName;
	String catalogueDescription;
	
	/**
	 * @param catalogueId
	 * @param catalogueName
	 * @param catalogueDescription
	 */
	public Catalogue(String catalogueId, String catalogueName, String catalogueDescription) {
		super();
		this.catalogueId = catalogueId;
		this.catalogueName = catalogueName;
		this.catalogueDescription = catalogueDescription;
	}

	/**
	 * 
	 */
	public Catalogue() {
		super();
	}

	/**
	 * @return the catalogueId
	 */
	public String getCatalogueId() {
		return catalogueId;
	}

	/**
	 * @param catalogueId the catalogueId to set
	 */
	public void setCatalogueId(String catalogueId) {
		this.catalogueId = catalogueId;
	}

	/**
	 * @return the catalogueName
	 */
	public String getCatalogueName() {
		return catalogueName;
	}

	/**
	 * @param catalogueName the catalogueName to set
	 */
	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	/**
	 * @return the catalogueDescription
	 */
	public String getCatalogueDescription() {
		return catalogueDescription;
	}

	/**
	 * @param catalogueDescription the catalogueDescription to set
	 */
	public void setCatalogueDescription(String catalogueDescription) {
		this.catalogueDescription = catalogueDescription;
	}

	@Override
	public String toString() {
		return "Catalogue [" + (catalogueId != null ? "catalogueId=" + catalogueId + ", " : "")
				+ (catalogueName != null ? "catalogueName=" + catalogueName + ", " : "")
				+ (catalogueDescription != null ? "catalogueDescription=" + catalogueDescription : "") + "]";
	}
}
