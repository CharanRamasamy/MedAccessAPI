package com.MedAccess.Dao;

import java.util.List;
import com.MedAccess.Models.Patient;

public interface IPatientDAO {
	List<Patient> getAllPatients();
	Patient getPatientById(String patient_id);
	Patient getPatientByMail(String patient_email);
	void addPatient(Patient patient);
	void updatePatient(Patient patient);
	void deletePatient(String patient_id);

}