package com.flipkart.model;

/**
 * @author ciphereck
 * @category Model
 *
 */
public class Course {
	String courseId;
	String courseName;
	int fees;
	double credit;
	String catalogueId;
	
	/**
	 * @param courseId
	 * @param courseName
	 * @param fees
	 * @param credit
	 * @param catalogueId
	 */
	public Course(String courseId, String courseName, int fees, double credit, String catalogueId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fees = fees;
		this.credit = credit;
		this.catalogueId = catalogueId;
	}
	
	/**
	 * 
	 */
	public Course() {
		super();
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}

	/**
	 * @return the credit
	 */
	public double getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(double credit) {
		this.credit = credit;
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

	@Override
	public String toString() {
		return "Course [" + (courseId != null ? "courseId=" + courseId + ", " : "")
				+ (courseName != null ? "courseName=" + courseName + ", " : "") + "fees=" + fees + ", credit=" + credit
				+ ", " + (catalogueId != null ? "catalogueId=" + catalogueId : "") + "]";
	}
}
