package com.MedAccess.Models;

public class Doctor {


	private String doctor_id;
	private String doctor_firstname;
	private String doctor_lastname;
	private String doctor_password;
	private String doctor_email;
	private String doctor_phone;
	private String doctor_suite;
	private String doctor_street;
	private String doctor_city;
	private String doctor_state;
	private String doctor_country;
	private String doctor_zip;
	private String doctor_reg_id;
	private String doctor_speciality;



	public Doctor() {}


	public Doctor(String doctor_id, String doctor_firstname, String doctor_lastname, String doctor_password,
			String doctor_email, String doctor_phone, String doctor_suite, String doctor_street, String doctor_city,
			String doctor_state, String doctor_country, String doctor_zip, String doctor_reg_id, String doctor_speciality) {

		super();
		this.doctor_id = doctor_id;
		this.doctor_firstname = doctor_firstname;
		this.doctor_lastname = doctor_lastname;
		this.doctor_password = doctor_password;
		this.doctor_email = doctor_email;
		this.doctor_phone = doctor_phone;
		this.doctor_suite = doctor_suite;
		this.doctor_street = doctor_street;
		this.doctor_city = doctor_city;
		this.doctor_state = doctor_state;
		this.doctor_country = doctor_country;
		this.doctor_zip = doctor_zip;
		this.doctor_reg_id = doctor_reg_id;
		this.doctor_speciality = doctor_speciality;

	}


	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_firstname() {
		return doctor_firstname;
	}
	public void setDoctor_firstname(String doctor_firstname) {
		this.doctor_firstname = doctor_firstname;
	}
	public String getDoctor_lastname() {
		return doctor_lastname;
	}
	public void setDoctor_lastname(String doctor_lastname) {
		this.doctor_lastname = doctor_lastname;
	}
	public String getDoctor_password() {
		return doctor_password;
	}
	public void setDoctor_password(String doctor_password) {
		this.doctor_password = doctor_password;
	}
	public String getDoctor_email() {
		return doctor_email;
	}
	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}
	public String getDoctor_phone() {
		return doctor_phone;
	}
	public void setDoctor_phone(String doctor_phone) {
		this.doctor_phone = doctor_phone;
	}
	public String getDoctor_suite() {
		return doctor_suite;
	}
	public void setDoctor_suite(String doctor_suite) {
		this.doctor_suite = doctor_suite;
	}
	public String getDoctor_street() {
		return doctor_street;
	}
	public void setDoctor_street(String doctor_street) {
		this.doctor_street = doctor_street;
	}
	public String getDoctor_city() {
		return doctor_city;
	}
	public void setDoctor_city(String doctor_city) {
		this.doctor_city = doctor_city;
	}
	public String getDoctor_state() {
		return doctor_state;
	}
	public void setDoctor_state(String doctor_state) {
		this.doctor_state = doctor_state;
	}
	public String getDoctor_country() {
		return doctor_country;
	}
	public void setDoctor_country(String doctor_country) {
		this.doctor_country = doctor_country;
	}
	public String getDoctor_zip() {
		return doctor_zip;
	}
	public void setDoctor_zip(String doctor_zip) {
		this.doctor_zip = doctor_zip;
	}

	public String getDoctor_reg_id() {
		return doctor_reg_id;
	}
	public void setDoctor_reg_id(String doctor_reg_id) {
		this.doctor_reg_id = doctor_reg_id;
	}
	public String getDoctor_speciality() {
		return doctor_speciality;
	}
	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}






}
