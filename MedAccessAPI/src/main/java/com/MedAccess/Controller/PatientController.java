package com.MedAccess.Controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MedAccess.Dao.PatientDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Patient;
import com.MedAccess.service.IPatientService;

@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class PatientController {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();

	final static Logger logger = Logger.getLogger(PatientDAO.class);

	@Autowired
	private IPatientService patientService;

	 @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id) {

		 loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController calling Patient record by Id");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController calling Patient record by Id");
		Patient patient = patientService.getPatientById(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	 @RequestMapping(value = "/patient/mail/{mail}", method = RequestMethod.GET)
		public ResponseEntity<Patient> getPatientByMail(@PathVariable("mail") String mail) {

		 loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController calling Patient record by Email");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController calling Patient record by Email");
		
			//logger.info("PatientController calling Patient record by Email");
			Patient patient = patientService.getPatientByMail(mail);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}


	@GetMapping("patient")
	public ResponseEntity<List<Patient>> getAllPatients() {
		
		loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController calling all Patient records");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController calling all Patient records");
		
		//logger.info("PatientController calling all Patient records");
		List<Patient> list = patientService.getAllPatients();
		return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
	}


	@RequestMapping(value = "patient", method = RequestMethod.POST)
	public ResponseEntity<Void> addPatient(@RequestBody Patient patient) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController adding Patient record");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController adding Patient record");
		
		//logger.info("PatientController adding Patient record");
		patientService.addPatient(patient);
		//if (false == flag) {
		//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		//}
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/patient/{id}").buildAndExpand(patient.getPatient_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("updatepatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient updatepatient) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController updating Patient record");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController updating Patient record");
		
		//logger.info("PatientController updating Patient record");
		patientService.updatePatient(updatepatient);
		return new ResponseEntity<Patient>(updatepatient, HttpStatus.OK);
	}
	
	@DeleteMapping("deletepatient/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable("id") String id) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "PatientController - PatientController deleting Patient record");
		 loggerChain.logMessage(AbstractLogger.DEBUG, "PatientController - PatientController deleting Patient record");
		
		//logger.info("PatientController deleting Patient record");
		patientService.deletePatient(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
