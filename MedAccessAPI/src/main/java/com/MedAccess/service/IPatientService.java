package com.MedAccess.service;

import java.util.List;

import com.MedAccess.Models.Patient;

public interface IPatientService {

	List<Patient> getAllPatients();
    Patient getPatientById(String patientId);
    Patient getPatientByMail(String patientMail);
    boolean addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(String patientId);
    
}
