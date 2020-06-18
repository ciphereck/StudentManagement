package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class ProfessorCourse extends Course {
	String professourUsername;
	String timestamp;
	
	/**
	 * 
	 */
	public ProfessorCourse() {
		super();
	}

	/**
	 * @return the professourUsername
	 */
	public String getProfessourUsername() {
		return professourUsername;
	}

	/**
	 * @param professourUsername the professourUsername to set
	 */
	public void setProfessourUsername(String professourUsername) {
		this.professourUsername = professourUsername;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ProfessorCourse ["
				+ (courseId != null ? "courseId=" + courseId + ", " : "")
				+ (professourUsername != null ? "professourUsername=" + professourUsername + ", " : "")
				+ (courseName != null ? "courseName=" + courseName + ", " : "") 
				+ (timestamp != null ? "timestamp=" + timestamp + ", " : "")
				+ "fees=" + fees + ", credit=" + credit
				+ ", " + (catalogueId != null ? "catalogueId=" + catalogueId : "") + "]";
	}
}
