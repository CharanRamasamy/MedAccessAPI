package com.MedAccess.Models;

public class DoctorNotification {
	
	
	private String appointment_id;
	private String patient_id;
	private String patient_firstname;
	private String patient_phone;
    private String app_date;
    private String app_time;
    
    
	


	public DoctorNotification(String appointment_id, String patient_id, String patient_firstname, String patient_phone,
			String app_date, String app_time) {
		super();
		this.appointment_id = appointment_id;
		this.patient_id = patient_id;
		this.patient_firstname = patient_firstname;
		this.patient_phone = patient_phone;
		this.app_date = app_date;
		this.app_time = app_time;
	}


	public DoctorNotification() {

	}


	public String getAppointment_id() {
		return appointment_id;
	}


	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}


	public String getPatient_firstname() {
		return patient_firstname;
	}


	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}


	public String getPatient_phone() {
		return patient_phone;
	}


	public void setPatient_phone(String patient_phone) {
		this.patient_phone = patient_phone;
	}


	public String getApp_date() {
		return app_date;
	}


	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}


	public String getApp_time() {
		return app_time;
	}


	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}


	public String getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
    
    
	
    
    

}
