package com.MedAccess.Models;

public class Appointment {

        private String appointment_id;
        private String doctor_id;
        private String patient_id;
        private String app_date;
        private String app_time;
        private String doctor_firstname;
        private String doctor_phone;



    public Appointment() {}

    public Appointment(String appointment_id, String doctor_id, String patient_id, String app_date, String app_time) {
        this.appointment_id = appointment_id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.app_date = app_date;
        this.app_time = app_time;
    }

    public Appointment(String appointment_id, String patient_id, String doctor_firstname, String app_date, String app_time, String doctor_phone) {
        super();
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.doctor_firstname = doctor_firstname;
        this.app_date = app_date;
        this.app_time = app_time;
        this.doctor_phone = doctor_phone;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
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

    public String getDoctor_firstname() {
        return doctor_firstname;
    }

    public void setDoctor_firstname(String doctor_firstname) {
        this.doctor_firstname = doctor_firstname;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }
}
