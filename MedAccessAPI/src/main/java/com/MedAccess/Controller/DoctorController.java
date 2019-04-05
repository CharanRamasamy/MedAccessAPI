package com.MedAccess.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.MedAccess.Dao.DoctorDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Doctor;
import com.MedAccess.service.IDoctorService;


@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class DoctorController {

	
	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();

	final static Logger logger = Logger.getLogger(DoctorDAO.class);


	@Autowired
	private IDoctorService doctorService;


	@RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") String id) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController calling Doctor record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController calling Doctor record by Id");
		Doctor doctor = doctorService.getDoctorById(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/doctor/mail/{mail}", method = RequestMethod.GET)
	public ResponseEntity<Doctor> getDoctorByMail(@PathVariable("mail") String mail) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController calling doctor record by Email");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController calling doctor record by Email");
		Doctor doctor = doctorService.getDoctorByMail(mail);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@GetMapping("doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors() {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController calling all Doctor records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController calling all Doctor records");
		List<Doctor> list = doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/doctorsearch/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Doctor>> getDoctorByName(@PathVariable("name") String name) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController calling Doctor record by Name");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController calling Doctor record by Name");
		
		//logger.info("DoctorController calling Doctor record by Name");
		List<Doctor> list = doctorService.getDoctorByName(name);
		return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);

	}


	//@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "doctor", method = RequestMethod.POST)
	public ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController adding Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController adding Doctor record");
		
		//logger.info("DoctorController adding Doctor record");
		doctorService.addDoctor(doctor);

		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}


	@PutMapping("updatedoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor updatedoctor) {

		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController updating Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController updating Doctor record");
		
		//logger.info("DoctorController updating Doctor record");
		doctorService.updateDoctor(updatedoctor);
		return new ResponseEntity<Doctor>(updatedoctor, HttpStatus.OK);

	}


	@DeleteMapping("deletedoctor/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable("id") String id) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "DoctorController - DoctorController deleting Doctor record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorController - DoctorController deleting Doctor record");
		
		//logger.info("DoctorController deleting Doctor record");
		doctorService.deleteDoctor(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}


}
