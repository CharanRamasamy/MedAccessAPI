package com.MedAccess.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedAccess.Dao.IPatientDAO;
import com.MedAccess.Dao.PatientDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Patient;

@Service
public class PatientService implements IPatientService {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(PatientDAO.class);

	@Autowired
	private IPatientDAO patientDAO;

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> list = new ArrayList<Patient>();
		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService calling all Patient records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService calling all Patient records");
		
		//logger.info("PatientService calling all Patient records");
		list = patientDAO.getAllPatients();

		return list;
	}

	@Override
	public Patient getPatientById(String patientId) {

		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService calling Patient record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService calling Patient record by Id");
		
		//logger.info("PatientService calling Patient record by Id");
		Patient obj = patientDAO.getPatientById(patientId);

		return obj;
	}

	@Override
	public Patient getPatientByMail(String patientMail) {

		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService calling Patient record by Mails");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService calling Patient record by Mails");
		
		//logger.info("PatientService calling Patient record by Mail");
		Patient obj = patientDAO.getPatientByMail(patientMail);

		return obj;
	}
	
	@Override
	public synchronized boolean addPatient(Patient patient) {

		//if (patientDAO.articleExists(patient.getTitle(), article.getCategory())) {
		//      return false;
		//  } else {
		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService adding Patient record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService adding Patient record");
		
		//logger.info("PatientService adding Patient record");
		patientDAO.addPatient(patient);
		//      return true;
		//  }

		return false;
	}

	@Override
	public void updatePatient(Patient patient) {

		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService deleting Patient record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService deleting Patient record");
		
		//logger.info("v");
		patientDAO.updatePatient(patient);

	}

	@Override
	public void deletePatient(String patientId) {

		loggerChain.logMessage(AbstractLogger.INFO, "PatientService - PatientService deleting Patient record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientService - PatientService deleting Patient record");
		
		//logger.info("PatientService deleting Patient record");
		patientDAO.deletePatient(patientId);

	}
}
