package com.MedAccess.Models;

public class Patient {
	private String patient_id;
	private String patient_firstname;
	private String patient_lastname;
	private String patient_password;
	private String patient_email;
	private String patient_phone;
	private String patient_suite;
	private String patient_street;
	private String patient_city;
	private String patient_state;
	private String patient_country;
	private String patient_zip;

	public Patient() {  }



	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public Patient(String patient_id, String patient_firstname, String patient_lastname, String patient_password,
			String patient_email, String patient_phone, String patient_suite, String patient_street,
			String patient_city, String patient_state, String patient_country, String patient_zip) {
		super();
		this.patient_id = patient_id;
		this.patient_firstname = patient_firstname;
		this.patient_lastname = patient_lastname;
		this.patient_password = patient_password;
		this.patient_email = patient_email;
		this.patient_phone = patient_phone;
		this.patient_suite = patient_suite;
		this.patient_street = patient_street;
		this.patient_city = patient_city;
		this.patient_state = patient_state;
		this.patient_country = patient_country;
		this.patient_zip = patient_zip;
	}



	public String getPatient_firstname() {
		return patient_firstname;
	}

	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}

	public String getPatient_lastname() {
		return patient_lastname;
	}


	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}
	public String getPatient_password() {
		return patient_password;
	}

	public void setPatient_password(String patient_password) {
		this.patient_password = patient_password;
	}

	public String getPatient_email() {
		return patient_email;
	}

	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}

	public String getPatient_phone() {
		return patient_phone;
	}


	public void setPatient_phone(String patient_phone) {
		this.patient_phone = patient_phone;
	}
	public String getPatient_suite() {
		return patient_suite;
	}

	public void setPatient_suite(String patient_suite) {
		this.patient_suite = patient_suite;
	}

	public String getPatient_street() {
		return patient_street;
	}

	public void setPatient_street(String patient_street) {
		this.patient_street = patient_street;
	}

	public String getPatient_city() {
		return patient_city;
	}


	public void setPatient_city(String patient_city) {
		this.patient_city = patient_city;
	}



	public String getPatient_state() {
		return patient_state;
	}


	public void setPatient_state(String patient_state) {
		this.patient_state = patient_state;
	}


	public String getPatient_country() {
		return patient_country;
	}


	public void setPatient_country(String patient_country) {
		this.patient_country = patient_country;
	}

	public String getPatient_zip() {
		return patient_zip;
	}


	public void setPatient_zip(String patient_zip) {
		this.patient_zip = patient_zip;
	}
}

