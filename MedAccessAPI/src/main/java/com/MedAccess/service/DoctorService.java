package com.MedAccess.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedAccess.Dao.DoctorDAO;
import com.MedAccess.Dao.IDoctorDao;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Doctor;


@Service
public class DoctorService implements IDoctorService {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(DoctorDAO.class);

	@Autowired
	private IDoctorDao doctorDAO;


	@Override
	public List<Doctor> getAllDoctors() {


		List<Doctor> list = new ArrayList<Doctor>();
		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService calling all Doctor records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService calling all Doctor records");
		
		//logger.info("DoctorService calling all Doctor records");
		list = doctorDAO.getAllDoctors();

		return list;


	}

	@Override
	public Doctor getDoctorById(String doctorId) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService calling Doctor record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService calling Doctor record by Id");
		
		//logger.info("DoctorService calling Doctor record by Id");
		Doctor obj = doctorDAO.getDoctorById(doctorId);


		return obj;

	}

	@Override
	public Doctor getDoctorByMail(String doctorMail) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService calling doctor record by Mail");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService calling doctor record by Mail");
		
		//logger.info("DoctorService calling doctor record by Mail");
		Doctor obj = doctorDAO.getDoctorByMail(doctorMail);

		return obj;
	}
	
	@Override
	public List<Doctor> getDoctorByName(String doctorName) {
		List<Doctor> list = new ArrayList<Doctor>();

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService calling Doctor record by Name");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService calling Doctor record by Name");
		
		//logger.info("DoctorService calling Doctor record by Name");
		list = doctorDAO.getDoctorByName(doctorName);


		return list;

	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService adding Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService adding Doctor record");
		
		//logger.info("DoctorService adding Doctor record");
		doctorDAO.addDoctor(doctor);
		
		return false;
	}

	@Override
	public void updateDoctor(Doctor doctor) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService updating Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService updating Doctor record");
		
		//logger.info("DoctorService updating Doctor record");
		doctorDAO.updateDoctor(doctor);

	}

	@Override
	public void deleteDoctor(String doctorId) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorService - DoctorService deleting Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorService - DoctorService deleting Doctor record");
		
		//logger.info("DoctorService deleting Doctor record");
		doctorDAO.deleteDoctor(doctorId);


	}


}
