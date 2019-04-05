package com.MedAccess.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MedAccess.Dao.IDisplayNotificationDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.DoctorNotification;


@Service
public class DisplayNotificationService implements IDisplayNotificationService{
	
	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(DisplayNotificationService.class);

	@Autowired
	private IDisplayNotificationDAO doctorNotificationDAO;


	@Override
	public List<DoctorNotification> getDoctorAppointment(String doctorId) {
		List<DoctorNotification> list = new ArrayList<DoctorNotification>();
		
		loggerChain.logMessage(AbstractLogger.INFO, "DisplayNotificationService - DoctorAppointmentNotification service calling Appointment record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DisplayNotificationService - DoctorAppointmentNotification service calling Appointment record by Id");
		
		//logger.info("DoctorAppointmentNotification service calling Appointment record by Id");
		list = doctorNotificationDAO.getDoctorAppointment(doctorId);


		return list;

	}

}
