package com.MedAccess.Controller;

import com.MedAccess.Dao.AppointmentDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Appointment;
import com.MedAccess.service.IAppointmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class AppointmentController {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
    final static Logger logger = Logger.getLogger(AppointmentDAO.class);

    @Autowired
    public IAppointmentService appointmentService;

    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> getAppointmentbyId(@PathVariable("id") String id) {

    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentController - Appointment Controller calling Appointment record by Id");
        Appointment appointment = appointmentService.getAppointmentByID(id);
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }

    @RequestMapping(value = "/appointmentbypatient/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getAppointmentbyPatientID(@PathVariable("id") String id) {

    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentController - Appointment Controller calling Appointment record by patient Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentController debug - Appointment Controller calling Appointment record by patient Id");
        List<Appointment> list  = appointmentService.getAppointmentbypatientId(id);
        return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);

    }

    @GetMapping("appointment")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentController - Appointment Controller calling all appointment records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentController debug - Appointment Controller calling all appointment records");
		
       // logger.info("Appointment Controller calling all appointment records");
        List<Appointment> list = appointmentService.getAllAppointments();
        return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "appointment", method = RequestMethod.POST)
    public ResponseEntity<Void> addAppointment(@RequestBody Appointment appointment) {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentController - Appointment Controller calling appointment record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentController - Appointment Controller calling appointment record by Id");
		
       // logger.info("Appointment controller adding appointment record");
        appointmentService.addAppointment(appointment);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteappointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") String id) {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "AppointmentController - Appointment controller deleting appointment record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentController - Appointment controller deleting appointment record");
       appointmentService.deleteAppointment(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

