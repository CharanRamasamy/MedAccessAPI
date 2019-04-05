package com.MedAccess.Models;

public class Feedback {
	private String feedback_id;
	private String doctor_id;
	private String patient_id;
	private String email;
	private String patient_name;
	private String doctor_name;
	private String description;
	private String posteddate;
	
	public Feedback() {
		
	}

	public Feedback(String feedback_id, String doctor_id, String patient_id, String email,
			String patient_name, String doctor_name, String description, String posteddate) {
		super();
		this.feedback_id = feedback_id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.email = email;
		this.patient_name = patient_name;
		this.doctor_name = doctor_name;
		this.description = description;
		this.posteddate = posteddate;
	}

	
	public String getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(String feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	
	
}
