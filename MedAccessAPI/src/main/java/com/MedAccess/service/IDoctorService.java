package com.MedAccess.service;

import java.util.List;

import com.MedAccess.Models.Doctor;

public interface IDoctorService {

	
	List<Doctor> getAllDoctors();
	Doctor getDoctorById(String doctorId);
	Doctor getDoctorByMail(String doctorMail);
    List<Doctor> getDoctorByName(String doctorName);
    boolean addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(String doctorId);
    
    
}
