package com.MedAccess.Dao;

import java.util.List;

import com.MedAccess.Models.Doctor;

public interface IDoctorDao {
	
	
	List<Doctor> getAllDoctors();
	Doctor getDoctorById(String doctor_id);
	Doctor getDoctorByMail(String doctor_email);
	List<Doctor> getDoctorByName(String doctor_name);
	void addDoctor(Doctor doctor);
	void updateDoctor(Doctor doctor);
	void deleteDoctor(String doctor_id);
	

}
