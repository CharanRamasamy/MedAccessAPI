package com.MedAccess.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.DoctorNotification;
import com.MedAccess.service.IDisplayNotificationService;







@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class DisplayNotificationController {
	
	
	 AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(DisplayNotificationController.class);

	
	@Autowired
	private IDisplayNotificationService doctorNotificationService;
	
	
	@RequestMapping(value = "/appointmentnotification/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DoctorNotification>> getDoctorAppointment(@PathVariable("id") String id) {

		loggerChain.logMessage(AbstractLogger.INFO, "DisplayNotificationController - Appointment Controller calling appointment record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DisplayNotificationController debug - Appointment Controller calling appointment record by Id");
		//loggerChain.logMessage(AbstractLogger.ERROR, "DisplayNotificationController error - Appointment Controller calling appointment record by Id");
		
		//logger.info("Appointment Controller calling appointment record by Id");
		List<DoctorNotification> list = doctorNotificationService.getDoctorAppointment(id);
		
		return new ResponseEntity<List<DoctorNotification>>(list, HttpStatus.OK);

	}
	
	
}
