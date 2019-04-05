package com.MedAccess.Controller.Test;

import static org.junit.Assert.*;

import com.MedAccess.Controller.PatientController;
import com.MedAccess.Models.Patient;
import com.MedAccess.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({PatientControllerTest.class,PatientController.class,PatientService.class})
public class PatientControllerTest {

	@Spy
	private PatientService mockPatientService;

	@InjectMocks
	private PatientController patientController;

	@Test
	public void testGetPatientById() {

		//mocking Patient response
		Patient mockPatient = new Patient();
		mockPatient.setPatient_city("Halifax");
		mockPatient.setPatient_country("Canada");
		mockPatient.setPatient_email("Messi@gmail.com");
		mockPatient.setPatient_firstname("Lionel");
		mockPatient.setPatient_lastname("Messi");
		mockPatient.setPatient_password("Tiago@Barca!");
		mockPatient.setPatient_phone("19029993456");
		mockPatient.setPatient_state("NS");
		mockPatient.setPatient_street("South park st");
		mockPatient.setPatient_suite("444");
		mockPatient.setPatient_zip("B5J 2K5");
		mockPatient.setPatient_id("10");

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doReturn(mockPatient).when(mockPatientService).getPatientById(Mockito.anyString());

		//Method call
		ResponseEntity<Patient> response = patientController.getPatientById("31");
		Patient result = response.getBody();

		//NotNull assertion
		assertNotNull(result);
		assertNotNull(result.getPatient_city());
		assertNotNull(result.getPatient_country());
		assertNotNull(result.getPatient_email());
		assertNotNull(result.getPatient_firstname());
		assertNotNull(result.getPatient_lastname());
		assertNotNull(result.getPatient_password());
		assertNotNull(result.getPatient_phone());
		assertNotNull(result.getPatient_state());
		assertNotNull(result.getPatient_street());
		assertNotNull(result.getPatient_suite());
		assertNotNull(result.getPatient_zip());
		assertNotNull(result.getPatient_id());

		//Equal assertion of Input and Output
		assertEquals(result.getPatient_city(),mockPatient.getPatient_city());
		assertEquals(result.getPatient_id(),mockPatient.getPatient_id());
		assertEquals(result.getPatient_country(),mockPatient.getPatient_country());
		assertEquals(result.getPatient_email(),mockPatient.getPatient_email());
		assertEquals(result.getPatient_firstname(),mockPatient.getPatient_firstname());
		assertEquals(result.getPatient_lastname(),mockPatient.getPatient_lastname());
		assertEquals(result.getPatient_password(),mockPatient.getPatient_password());
		assertEquals(result.getPatient_phone(),mockPatient.getPatient_phone());
		assertEquals(result.getPatient_state(),mockPatient.getPatient_state());
		assertEquals(result.getPatient_street(),mockPatient.getPatient_street());
		assertEquals(result.getPatient_suite(),mockPatient.getPatient_suite());
		assertEquals(result.getPatient_zip(),mockPatient.getPatient_zip());
	}

	@Test
	public void testGetPatientByMail() {

		//mocking Patient response
		Patient mockPatient = new Patient();
		mockPatient.setPatient_city("Halifax");
		mockPatient.setPatient_country("Canada");
		mockPatient.setPatient_email("Messi@gmail.com");
		mockPatient.setPatient_firstname("Lionel");
		mockPatient.setPatient_lastname("Messi");
		mockPatient.setPatient_password("Tiago@Barca!");
		mockPatient.setPatient_phone("19029993456");
		mockPatient.setPatient_state("NS");
		mockPatient.setPatient_street("South park st");
		mockPatient.setPatient_suite("444");
		mockPatient.setPatient_zip("B5J 2K5");
		mockPatient.setPatient_id("10");

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doReturn(mockPatient).when(mockPatientService).getPatientByMail(Mockito.anyString());

		//Method call
		ResponseEntity<Patient> response = patientController.getPatientByMail("Messi@gmail.com");
		Patient result = response.getBody();

		//NotNull assertion
		assertNotNull(result);
		assertNotNull(result.getPatient_city());
		assertNotNull(result.getPatient_country());
		assertNotNull(result.getPatient_email());
		assertNotNull(result.getPatient_firstname());
		assertNotNull(result.getPatient_lastname());
		assertNotNull(result.getPatient_password());
		assertNotNull(result.getPatient_phone());
		assertNotNull(result.getPatient_state());
		assertNotNull(result.getPatient_street());
		assertNotNull(result.getPatient_suite());
		assertNotNull(result.getPatient_zip());
		assertNotNull(result.getPatient_id());

		//Equal assertion of Input and Output
		assertEquals(result.getPatient_city(),mockPatient.getPatient_city());
		assertEquals(result.getPatient_id(),mockPatient.getPatient_id());
		assertEquals(result.getPatient_country(),mockPatient.getPatient_country());
		assertEquals(result.getPatient_email(),mockPatient.getPatient_email());
		assertEquals(result.getPatient_firstname(),mockPatient.getPatient_firstname());
		assertEquals(result.getPatient_lastname(),mockPatient.getPatient_lastname());
		assertEquals(result.getPatient_password(),mockPatient.getPatient_password());
		assertEquals(result.getPatient_phone(),mockPatient.getPatient_phone());
		assertEquals(result.getPatient_state(),mockPatient.getPatient_state());
		assertEquals(result.getPatient_street(),mockPatient.getPatient_street());
		assertEquals(result.getPatient_suite(),mockPatient.getPatient_suite());
		assertEquals(result.getPatient_zip(),mockPatient.getPatient_zip());
	}

	@Test
	public void testGetAllPatients() {

		//mocking Patient response
		Patient mockPatient1 = new Patient();
		mockPatient1.setPatient_city("Halifax");
		mockPatient1.setPatient_country("Canada");
		mockPatient1.setPatient_email("Messi@gmail.com");
		mockPatient1.setPatient_firstname("Lionel");
		mockPatient1.setPatient_lastname("Messi");
		mockPatient1.setPatient_password("Tiago@Barca!");
		mockPatient1.setPatient_phone("19029993456");
		mockPatient1.setPatient_state("NS");
		mockPatient1.setPatient_street("South park st");
		mockPatient1.setPatient_suite("444");
		mockPatient1.setPatient_zip("B5J 2K5");
		mockPatient1.setPatient_id("10");

		//mocking Patient response
		Patient mockPatient2 = new Patient();
		mockPatient2.setPatient_city("Toronto");
		mockPatient2.setPatient_country("Canada");
		mockPatient2.setPatient_email("Mbappe@gmail.com");
		mockPatient2.setPatient_firstname("Kylion");
		mockPatient2.setPatient_lastname("Mbappe");
		mockPatient2.setPatient_password("Golden@Psg!");
		mockPatient2.setPatient_phone("19023445546");
		mockPatient2.setPatient_state("NS");
		mockPatient2.setPatient_street("Scotia square Rd");
		mockPatient2.setPatient_suite("421");
		mockPatient2.setPatient_zip("B4K 3K4");
		mockPatient2.setPatient_id("21");

		List<Patient> mockPatientList = new ArrayList<Patient>();
		mockPatientList.add(mockPatient1);
		mockPatientList.add(mockPatient2);

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doReturn(mockPatientList).when(mockPatientService).getAllPatients();

		//Method call
		ResponseEntity<List<Patient>> response = patientController.getAllPatients();
		List<Patient> resultPatientList = response.getBody();
		Patient result1 = resultPatientList.get(0);
		Patient result2 = resultPatientList.get(1);

		//NotNull assertion for Patient1
		assertNotNull(result1);
		assertNotNull(result1.getPatient_city());
		assertNotNull(result1.getPatient_country());
		assertNotNull(result1.getPatient_email());
		assertNotNull(result1.getPatient_firstname());
		assertNotNull(result1.getPatient_lastname());
		assertNotNull(result1.getPatient_password());
		assertNotNull(result1.getPatient_phone());
		assertNotNull(result1.getPatient_state());
		assertNotNull(result1.getPatient_street());
		assertNotNull(result1.getPatient_suite());
		assertNotNull(result1.getPatient_zip());
		assertNotNull(result1.getPatient_id());

		//Equal assertion of Input and Output for Patient1
		assertEquals(result1.getPatient_city(),mockPatient1.getPatient_city());
		assertEquals(result1.getPatient_id(),mockPatient1.getPatient_id());
		assertEquals(result1.getPatient_country(),mockPatient1.getPatient_country());
		assertEquals(result1.getPatient_email(),mockPatient1.getPatient_email());
		assertEquals(result1.getPatient_firstname(),mockPatient1.getPatient_firstname());
		assertEquals(result1.getPatient_lastname(),mockPatient1.getPatient_lastname());
		assertEquals(result1.getPatient_password(),mockPatient1.getPatient_password());
		assertEquals(result1.getPatient_phone(),mockPatient1.getPatient_phone());
		assertEquals(result1.getPatient_state(),mockPatient1.getPatient_state());
		assertEquals(result1.getPatient_street(),mockPatient1.getPatient_street());
		assertEquals(result1.getPatient_suite(),mockPatient1.getPatient_suite());
		assertEquals(result1.getPatient_zip(),mockPatient1.getPatient_zip());

		//NotNull assertion for Patient1
		assertNotNull(result2);
		assertNotNull(result2.getPatient_city());
		assertNotNull(result2.getPatient_country());
		assertNotNull(result2.getPatient_email());
		assertNotNull(result2.getPatient_firstname());
		assertNotNull(result2.getPatient_lastname());
		assertNotNull(result2.getPatient_password());
		assertNotNull(result2.getPatient_phone());
		assertNotNull(result2.getPatient_state());
		assertNotNull(result2.getPatient_street());
		assertNotNull(result2.getPatient_suite());
		assertNotNull(result2.getPatient_zip());
		assertNotNull(result2.getPatient_id());

		//Equal assertion of Input and Output for Patient1
		assertEquals(result2.getPatient_city(),mockPatient2.getPatient_city());
		assertEquals(result2.getPatient_id(),mockPatient2.getPatient_id());
		assertEquals(result2.getPatient_country(),mockPatient2.getPatient_country());
		assertEquals(result2.getPatient_email(),mockPatient2.getPatient_email());
		assertEquals(result2.getPatient_firstname(),mockPatient2.getPatient_firstname());
		assertEquals(result2.getPatient_lastname(),mockPatient2.getPatient_lastname());
		assertEquals(result2.getPatient_password(),mockPatient2.getPatient_password());
		assertEquals(result2.getPatient_phone(),mockPatient2.getPatient_phone());
		assertEquals(result2.getPatient_state(),mockPatient2.getPatient_state());
		assertEquals(result2.getPatient_street(),mockPatient2.getPatient_street());
		assertEquals(result2.getPatient_suite(),mockPatient2.getPatient_suite());
		assertEquals(result2.getPatient_zip(),mockPatient2.getPatient_zip());
	}

	@Test
	public void testAddPatient() {

		//mocking Patient response
		Patient mockPatient = new Patient();
		mockPatient.setPatient_city("Halifax");
		mockPatient.setPatient_country("Canada");
		mockPatient.setPatient_email("Messi@gmail.com");
		mockPatient.setPatient_firstname("Lionel");
		mockPatient.setPatient_lastname("Messi");
		mockPatient.setPatient_password("Tiago@Barca!");
		mockPatient.setPatient_phone("19029993456");
		mockPatient.setPatient_state("NS");
		mockPatient.setPatient_street("South park st");
		mockPatient.setPatient_suite("444");
		mockPatient.setPatient_zip("B5J 2K5");
		mockPatient.setPatient_id("10");

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doReturn(true).when(mockPatientService).addPatient(mockPatient);

		//Method call
		ResponseEntity<Void> response = patientController.addPatient(mockPatient);

		//Check for Valid response
		assertNotNull(response);

		//check for value in response
		assertEquals(201,response.getStatusCodeValue());
		assertEquals(HttpStatus.CREATED,response.getStatusCode());

	}

	@Test
	public void testUpdatePatient() {

		//mocking Patient response
		Patient mockPatient = new Patient();
		mockPatient.setPatient_city("Halifax");
		mockPatient.setPatient_country("Canada");
		mockPatient.setPatient_email("Messi@gmail.com");
		mockPatient.setPatient_firstname("Lionel");
		mockPatient.setPatient_lastname("Messi");
		mockPatient.setPatient_password("Tiago@Barca!");
		mockPatient.setPatient_phone("19029993456");
		mockPatient.setPatient_state("NS");
		mockPatient.setPatient_street("South park st");
		mockPatient.setPatient_suite("444");
		mockPatient.setPatient_zip("B5J 2K5");
		mockPatient.setPatient_id("10");

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doNothing().when(mockPatientService).updatePatient(mockPatient);

		//Method call
		ResponseEntity<Patient> response = patientController.updatePatient(mockPatient);

		//Check for Valid response
		assertNotNull(response);

		//check for value in response
		assertEquals(HttpStatus.OK,response.getStatusCode());

		//Get response object as Patient object
		Patient result = response.getBody();

		//NotNull assertion
		assertNotNull(result);
		assertNotNull(result.getPatient_city());
		assertNotNull(result.getPatient_country());
		assertNotNull(result.getPatient_email());
		assertNotNull(result.getPatient_firstname());
		assertNotNull(result.getPatient_lastname());
		assertNotNull(result.getPatient_password());
		assertNotNull(result.getPatient_phone());
		assertNotNull(result.getPatient_state());
		assertNotNull(result.getPatient_street());
		assertNotNull(result.getPatient_suite());
		assertNotNull(result.getPatient_zip());
		assertNotNull(result.getPatient_id());

		//Equal assertion of Input and Output
		assertEquals(result.getPatient_city(),mockPatient.getPatient_city());
		assertEquals(result.getPatient_id(),mockPatient.getPatient_id());
		assertEquals(result.getPatient_country(),mockPatient.getPatient_country());
		assertEquals(result.getPatient_email(),mockPatient.getPatient_email());
		assertEquals(result.getPatient_firstname(),mockPatient.getPatient_firstname());
		assertEquals(result.getPatient_lastname(),mockPatient.getPatient_lastname());
		assertEquals(result.getPatient_password(),mockPatient.getPatient_password());
		assertEquals(result.getPatient_phone(),mockPatient.getPatient_phone());
		assertEquals(result.getPatient_state(),mockPatient.getPatient_state());
		assertEquals(result.getPatient_street(),mockPatient.getPatient_street());
		assertEquals(result.getPatient_suite(),mockPatient.getPatient_suite());
		assertEquals(result.getPatient_zip(),mockPatient.getPatient_zip());
	}

	@Test
	public void testDeletePatient() {

		//Mockito to mock the control from going to service class
		//Mocking PatientService object
		//PatientService mockPatientService = spy(PatientService.class);
		Mockito.doNothing().when(mockPatientService).deletePatient(Mockito.anyString());

		//Method call
		ResponseEntity<Void> response = patientController.deletePatient("21");

		//Check for Valid response
		assertNotNull(response);

		//check for value in response
		assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

	}

}
