package com.MedAccess.service;


import com.MedAccess.Dao.*;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Patient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
    final static Logger logger = Logger.getLogger(AppointmentService.class);

    @Autowired
    private IAppointmentDAO appointmentDAO;
    private IDoctorDao doctorDAO;
    private IPatientDAO patientDAO;


    @Override
    public List<Appointment> getAllAppointments() {
    	
        List<Appointment> list = new ArrayList<Appointment>();
        loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - AppointmentService calling all Appointment records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - AppointmentService calling all Appointment records");
		
        //logger.info("AppointmentService calling all Appointment records");
        list = appointmentDAO.getAllAppointments();
        return list;
    }

    @Override
    public Appointment getAppointmentByID(String appointmentId) {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService calling Appointment record by AppointmentID");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService calling Appointment record by AppointmentID");
		
        //logger.info("AppointmentService calling Appointment record by AppointmentID");
        Appointment obj = appointmentDAO.getAppointmentByID(appointmentId);
        return obj;
    }

    @Override
    public synchronized boolean addAppointment(Appointment appointment) {

    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - AppointmentService adding appointment record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - AppointmentService adding appointment record");
		
       // logger.info("AppointmentService adding appointment record");
        appointmentDAO.addAppointment(appointment);
        return false;
    }

    @Override
    public void deleteAppointment(String appointmentID) {

    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - AppointmentService deleting appointment record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - AppointmentService deleting appointment record");
		
        //logger.info("AppointmentService deleting appointment record");
        appointmentDAO.deleteAppointment(appointmentID );
    }

    @Override
    public Doctor getDoctorById(String doctorId) {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - DoctorService calling Doctor record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - DoctorService calling Doctor record by Id");
		
        //logger.info("DoctorService calling Doctor record by Id");
        Doctor obj = doctorDAO.getDoctorById(doctorId);
        return obj;
    }

    @Override
    public Patient getPatientById(String patientId) {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - PatientService calling Patient record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - PatientService calling Patient record by Id");
		
        //logger.info("PatientService calling Patient record by Id");
        Patient obj = patientDAO.getPatientById(patientId);
        return obj;
    }

    @Override
    public List<Appointment> getAppointmentbypatientId(String patientID) {
        List<Appointment> list = new ArrayList<Appointment>();

        loggerChain.logMessage(AbstractLogger.INFO, "AppointmentService - Appointment service calling Appointment record by Patient Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentService - Appointment service calling Appointment record by Patient Id");
		
        //logger.info("Appointment service calling Appointment record by Patient Id");
        list = appointmentDAO.getAppointmentbypatientId(patientID);


        return list;

    }
}
