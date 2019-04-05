package com.MedAccess.Controller.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.MedAccess.Controller.DoctorController;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Doctor;
import com.MedAccess.service.DoctorService;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({DoctorControllerTest.class,DoctorController.class,DoctorService.class})
public class DoctorControllerTest {

	
	@Spy
	private DoctorService mockDoctorService;
	
	@InjectMocks
	private DoctorController doctorController;
	
	@Test
	public void testGetDoctorById() {

		//mocking Doctor response
		
		Doctor mockDoctor = new Doctor();
		
		
		mockDoctor.setDoctor_city("HALIFAX");
		mockDoctor.setDoctor_country("Canada");
		mockDoctor.setDoctor_email("vidhyashree1992@gmail.com");
		mockDoctor.setDoctor_firstname("VIDHYASHREE");
		mockDoctor.setDoctor_lastname("BOOPATHY");
		mockDoctor.setDoctor_password("vidhu@123");
		mockDoctor.setDoctor_phone("9024129698");
		mockDoctor.setDoctor_state("Nova Scotia");
		mockDoctor.setDoctor_street("110");
		mockDoctor.setDoctor_suite("123");
		mockDoctor.setDoctor_zip("B3L4R1");
		mockDoctor.setDoctor_id("2");
		mockDoctor.setDoctor_reg_id("1234");
		mockDoctor.setDoctor_speciality("apollo");
		
		
		
		//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doReturn(mockDoctor).when(mockDoctorService).getDoctorById(Mockito.anyString());

				
				
				//Method call
				ResponseEntity<Doctor> response = doctorController.getDoctorById("2");
				Doctor result = response.getBody();

				
				//NotNull assertion
				assertNotNull(result);
				assertNotNull(result.getDoctor_city());
				assertNotNull(result.getDoctor_country());
				assertNotNull(result.getDoctor_email());
				assertNotNull(result.getDoctor_firstname());
				assertNotNull(result.getDoctor_lastname());
				assertNotNull(result.getDoctor_password());
				assertNotNull(result.getDoctor_phone());
				assertNotNull(result.getDoctor_state());
				assertNotNull(result.getDoctor_street());
				assertNotNull(result.getDoctor_suite());
				assertNotNull(result.getDoctor_zip());
				assertNotNull(result.getDoctor_id());
				assertNotNull(result.getDoctor_reg_id());
				assertNotNull(result.getDoctor_speciality());
				
				

				//Equal assertion of Input and Output
				assertEquals(result.getDoctor_city(),mockDoctor.getDoctor_city());
				assertEquals(result.getDoctor_id(),mockDoctor.getDoctor_id());
				assertEquals(result.getDoctor_country(),mockDoctor.getDoctor_country());
				assertEquals(result.getDoctor_email(),mockDoctor.getDoctor_email());
				assertEquals(result.getDoctor_firstname(),mockDoctor.getDoctor_firstname());
				assertEquals(result.getDoctor_lastname(),mockDoctor.getDoctor_lastname());
				assertEquals(result.getDoctor_password(),mockDoctor.getDoctor_password());
				assertEquals(result.getDoctor_phone(),mockDoctor.getDoctor_phone());
				assertEquals(result.getDoctor_state(),mockDoctor.getDoctor_state());
				assertEquals(result.getDoctor_street(),mockDoctor.getDoctor_street());
				assertEquals(result.getDoctor_suite(),mockDoctor.getDoctor_suite());
				assertEquals(result.getDoctor_zip(),mockDoctor.getDoctor_zip());
				assertEquals(result.getDoctor_reg_id(),mockDoctor.getDoctor_reg_id());
				assertEquals(result.getDoctor_speciality(),mockDoctor.getDoctor_speciality());
				
				
			}

			@Test
			public void testGetDoctorByName() {

				//mocking Doctor response
				Doctor mockDoctor1 = new Doctor();
				Doctor mockDoctor2 = new Doctor();
				
				mockDoctor1.setDoctor_city("HALIFAX");
				mockDoctor1.setDoctor_country("Canada");
				mockDoctor1.setDoctor_email("vidhyashree1992@gmail.com");
				mockDoctor1.setDoctor_firstname("VIDHYASHREE");
				mockDoctor1.setDoctor_lastname("BOOPATHY");
				mockDoctor1.setDoctor_password("vidhu@123");
				mockDoctor1.setDoctor_phone("9024129698");
				mockDoctor1.setDoctor_state("Nova Scotia");
				mockDoctor1.setDoctor_street("110");
				mockDoctor1.setDoctor_suite("123");
				mockDoctor1.setDoctor_zip("B3L4R1");
				mockDoctor1.setDoctor_id("2");
				mockDoctor1.setDoctor_reg_id("1234");
				mockDoctor1.setDoctor_speciality("apollo");
				
				
				
				mockDoctor2.setDoctor_city("Halifax");
				mockDoctor2.setDoctor_country("Canada");
				mockDoctor2.setDoctor_email("kr536074@dal.ca");
				mockDoctor2.setDoctor_firstname("Karthik");
				mockDoctor2.setDoctor_lastname("Rammoorthy");
				mockDoctor2.setDoctor_password("12345");
				mockDoctor2.setDoctor_phone("9027894476");
				mockDoctor2.setDoctor_state("Nova Scotia");
				mockDoctor2.setDoctor_street("Brunswick Street");
				mockDoctor2.setDoctor_suite("501");
				mockDoctor2.setDoctor_zip("B3J 3J7");
				mockDoctor2.setDoctor_id("1");
				mockDoctor2.setDoctor_reg_id("B56JRTY5");
				mockDoctor2.setDoctor_speciality("Physiotherapy");
				
				
				List<Doctor> mockDoctorList = new ArrayList<Doctor>();
				mockDoctorList.add(mockDoctor1);
				mockDoctorList.add(mockDoctor2);
				
				
				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doReturn(mockDoctorList).when(mockDoctorService).getDoctorByName(Mockito.anyString());

				
				//Method call
				ResponseEntity<List<Doctor>> response = doctorController.getDoctorByName("VIDHYASHREE");
				
				List<Doctor> resultDoctorList = response.getBody();
				Doctor result1 = resultDoctorList.get(0);
				Doctor result2 = resultDoctorList.get(1);
				
				
				//NotNull assertion
				assertNotNull(result1);
				assertNotNull(result1.getDoctor_city());
				assertNotNull(result1.getDoctor_country());
				assertNotNull(result1.getDoctor_email());
				assertNotNull(result1.getDoctor_firstname());
				assertNotNull(result1.getDoctor_lastname());
				assertNotNull(result1.getDoctor_password());
				assertNotNull(result1.getDoctor_phone());
				assertNotNull(result1.getDoctor_state());
				assertNotNull(result1.getDoctor_street());
				assertNotNull(result1.getDoctor_suite());
				assertNotNull(result1.getDoctor_zip());
				assertNotNull(result1.getDoctor_id());
				assertNotNull(result1.getDoctor_reg_id());
				assertNotNull(result1.getDoctor_speciality());

				
				//Equal assertion of Input and Output
				assertEquals(result1.getDoctor_city(),mockDoctor1.getDoctor_city());
				assertEquals(result1.getDoctor_id(),mockDoctor1.getDoctor_id());
				assertEquals(result1.getDoctor_country(),mockDoctor1.getDoctor_country());
				assertEquals(result1.getDoctor_email(),mockDoctor1.getDoctor_email());
				assertEquals(result1.getDoctor_firstname(),mockDoctor1.getDoctor_firstname());
				assertEquals(result1.getDoctor_lastname(),mockDoctor1.getDoctor_lastname());
				assertEquals(result1.getDoctor_password(),mockDoctor1.getDoctor_password());
				assertEquals(result1.getDoctor_phone(),mockDoctor1.getDoctor_phone());
				assertEquals(result1.getDoctor_state(),mockDoctor1.getDoctor_state());
				assertEquals(result1.getDoctor_street(),mockDoctor1.getDoctor_street());
				assertEquals(result1.getDoctor_suite(),mockDoctor1.getDoctor_suite());
				assertEquals(result1.getDoctor_zip(),mockDoctor1.getDoctor_zip());
				assertEquals(result1.getDoctor_reg_id(), mockDoctor1.getDoctor_reg_id());
				assertEquals(result1.getDoctor_speciality(), mockDoctor1.getDoctor_speciality());
				
				
			}

			@Test
			public void testGetAllDoctors() {

				//mocking Doctor response
				Doctor mockDoctor1 = new Doctor();
                Doctor mockDoctor2 = new Doctor();
				
                
				mockDoctor1.setDoctor_city("HALIFAX");
				mockDoctor1.setDoctor_country("Canada");
				mockDoctor1.setDoctor_email("vidhyashree1992@gmail.com");
				mockDoctor1.setDoctor_firstname("VIDHYASHREE");
				mockDoctor1.setDoctor_lastname("BOOPATHY");
				mockDoctor1.setDoctor_password("vidhu@123");
				mockDoctor1.setDoctor_phone("9024129698");
				mockDoctor1.setDoctor_state("Nova Scotia");
				mockDoctor1.setDoctor_street("110");
				mockDoctor1.setDoctor_suite("123");
				mockDoctor1.setDoctor_zip("B3L4R1");
				mockDoctor1.setDoctor_id("2");
				mockDoctor1.setDoctor_reg_id("1234");
				mockDoctor1.setDoctor_speciality("apollo");

				
				//mocking Doctor response
				mockDoctor2.setDoctor_city("Halifax");
				mockDoctor2.setDoctor_country("Canada");
				mockDoctor2.setDoctor_email("kr536074@dal.ca");
				mockDoctor2.setDoctor_firstname("Karthik");
				mockDoctor2.setDoctor_lastname("Rammoorthy");
				mockDoctor2.setDoctor_password("12345");
				mockDoctor2.setDoctor_phone("9027894476");
				mockDoctor2.setDoctor_state("Nova Scotia");
				mockDoctor2.setDoctor_street("Brunswick Street");
				mockDoctor2.setDoctor_suite("501");
				mockDoctor2.setDoctor_zip("B3J 3J7");
				mockDoctor2.setDoctor_id("1");
				mockDoctor2.setDoctor_reg_id("B56JRTY5");
				mockDoctor2.setDoctor_speciality("Physiotherapy");
				

				List<Doctor> mockDoctorList = new ArrayList<Doctor>();
				mockDoctorList.add(mockDoctor1);
				mockDoctorList.add(mockDoctor2);

				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doReturn(mockDoctorList).when(mockDoctorService).getAllDoctors();

				//Method call
				
				ResponseEntity<List<Doctor>> response = doctorController.getAllDoctors();
				List<Doctor> resultDoctorList = response.getBody();
				Doctor result1 = resultDoctorList.get(0);
				Doctor result2 = resultDoctorList.get(1);

				//NotNull assertion for Doctor1
				
				assertNotNull(result1);
				assertNotNull(result1.getDoctor_city());
				assertNotNull(result1.getDoctor_country());
				assertNotNull(result1.getDoctor_email());
				assertNotNull(result1.getDoctor_firstname());
				assertNotNull(result1.getDoctor_lastname());
				assertNotNull(result1.getDoctor_password());
				assertNotNull(result1.getDoctor_phone());
				assertNotNull(result1.getDoctor_state());
				assertNotNull(result1.getDoctor_street());
				assertNotNull(result1.getDoctor_suite());
				assertNotNull(result1.getDoctor_zip());
				assertNotNull(result1.getDoctor_id());
				assertNotNull(result1.getDoctor_reg_id());
				assertNotNull(result1.getDoctor_speciality());
				

				//Equal assertion of Input and Output for Doctor1
				
				assertEquals(result1.getDoctor_city(),mockDoctor1.getDoctor_city());
				assertEquals(result1.getDoctor_id(),mockDoctor1.getDoctor_id());
				assertEquals(result1.getDoctor_country(),mockDoctor1.getDoctor_country());
				assertEquals(result1.getDoctor_email(),mockDoctor1.getDoctor_email());
				assertEquals(result1.getDoctor_firstname(),mockDoctor1.getDoctor_firstname());
				assertEquals(result1.getDoctor_lastname(),mockDoctor1.getDoctor_lastname());
				assertEquals(result1.getDoctor_password(),mockDoctor1.getDoctor_password());
				assertEquals(result1.getDoctor_phone(),mockDoctor1.getDoctor_phone());
				assertEquals(result1.getDoctor_state(),mockDoctor1.getDoctor_state());
				assertEquals(result1.getDoctor_street(),mockDoctor1.getDoctor_street());
				assertEquals(result1.getDoctor_suite(),mockDoctor1.getDoctor_suite());
				assertEquals(result1.getDoctor_zip(),mockDoctor1.getDoctor_zip());
				assertEquals(result1.getDoctor_reg_id(), mockDoctor1.getDoctor_reg_id());
				assertEquals(result1.getDoctor_speciality(), mockDoctor1.getDoctor_speciality());
				
				
				//NotNull assertion for Doctor2
				
				assertNotNull(result2);
				assertNotNull(result2.getDoctor_city());
				assertNotNull(result2.getDoctor_country());
				assertNotNull(result2.getDoctor_email());
				assertNotNull(result2.getDoctor_firstname());
				assertNotNull(result2.getDoctor_lastname());
				assertNotNull(result2.getDoctor_password());
				assertNotNull(result2.getDoctor_phone());
				assertNotNull(result2.getDoctor_state());
				assertNotNull(result2.getDoctor_street());
				assertNotNull(result2.getDoctor_suite());
				assertNotNull(result2.getDoctor_zip());
				assertNotNull(result2.getDoctor_id());
				assertNotNull(result2.getDoctor_reg_id());
				assertNotNull(result2.getDoctor_speciality());
				

				//Equal assertion of Input and Output for Doctor2
				
				assertEquals(result2.getDoctor_city(),mockDoctor2.getDoctor_city());
				assertEquals(result2.getDoctor_id(),mockDoctor2.getDoctor_id());
				assertEquals(result2.getDoctor_country(),mockDoctor2.getDoctor_country());
				assertEquals(result2.getDoctor_email(),mockDoctor2.getDoctor_email());
				assertEquals(result2.getDoctor_firstname(),mockDoctor2.getDoctor_firstname());
				assertEquals(result2.getDoctor_lastname(),mockDoctor2.getDoctor_lastname());
				assertEquals(result2.getDoctor_password(),mockDoctor2.getDoctor_password());
				assertEquals(result2.getDoctor_phone(),mockDoctor2.getDoctor_phone());
				assertEquals(result2.getDoctor_state(),mockDoctor2.getDoctor_state());
				assertEquals(result2.getDoctor_street(),mockDoctor2.getDoctor_street());
				assertEquals(result2.getDoctor_suite(),mockDoctor2.getDoctor_suite());
				assertEquals(result2.getDoctor_zip(),mockDoctor2.getDoctor_zip());
				assertEquals(result2.getDoctor_reg_id(), mockDoctor2.getDoctor_reg_id());
				assertEquals(result2.getDoctor_speciality(), mockDoctor2.getDoctor_speciality());
				
				
			}

			@Test
			public void testAddDoctor() {

				//mocking Doctor response
				Doctor mockDoctor = new Doctor();
				
				mockDoctor.setDoctor_city("HALIFAX");
				mockDoctor.setDoctor_country("Canada");
				mockDoctor.setDoctor_email("vidhyashree1992@gmail.com");
				mockDoctor.setDoctor_firstname("VIDHYASHREE");
				mockDoctor.setDoctor_lastname("BOOPATHY");
				mockDoctor.setDoctor_password("vidhu@123");
				mockDoctor.setDoctor_phone("9024129698");
				mockDoctor.setDoctor_state("Nova Scotia");
				mockDoctor.setDoctor_street("110");
				mockDoctor.setDoctor_suite("123");
				mockDoctor.setDoctor_zip("B3L4R1");
				mockDoctor.setDoctor_id("2");
				mockDoctor.setDoctor_reg_id("1234");
				mockDoctor.setDoctor_speciality("apollo");
				
				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doReturn(true).when(mockDoctorService).addDoctor(mockDoctor);

				//Method call
				ResponseEntity<Void> response = doctorController.addDoctor(mockDoctor);

				//Check for Valid response
				assertNotNull(response);

				//check for value in response
				assertEquals(201,response.getStatusCodeValue());
				assertEquals(HttpStatus.CREATED,response.getStatusCode());
				

			}

			@Test
			public void testUpdateDoctor() {

				//mocking Doctor response
				Doctor mockDoctor = new Doctor();
				
				mockDoctor.setDoctor_city("HALIFAX");
				mockDoctor.setDoctor_country("Canada");
				mockDoctor.setDoctor_email("vidhyashree1992@gmail.com");
				mockDoctor.setDoctor_firstname("VIDHYASHREE");
				mockDoctor.setDoctor_lastname("BOOPATHY");
				mockDoctor.setDoctor_password("vidhu@123");
				mockDoctor.setDoctor_phone("9024129698");
				mockDoctor.setDoctor_state("Nova Scotia");
				mockDoctor.setDoctor_street("110");
				mockDoctor.setDoctor_suite("123");
				mockDoctor.setDoctor_zip("B3L4R1");
				mockDoctor.setDoctor_id("2");
				mockDoctor.setDoctor_reg_id("1234");
				mockDoctor.setDoctor_speciality("apollo");

				
				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doNothing().when(mockDoctorService).updateDoctor(mockDoctor);

				//Method call
				ResponseEntity<Doctor> response = doctorController.updateDoctor(mockDoctor);

				//Check for Valid response
				assertNotNull(response);

				//check for value in response
				assertEquals(HttpStatus.OK,response.getStatusCode());

				//Get response object as Doctor object
				Doctor result = response.getBody();

				//NotNull assertion
				assertNotNull(result);
				assertNotNull(result.getDoctor_city());
				assertNotNull(result.getDoctor_country());
				assertNotNull(result.getDoctor_email());
				assertNotNull(result.getDoctor_firstname());
				assertNotNull(result.getDoctor_lastname());
				assertNotNull(result.getDoctor_password());
				assertNotNull(result.getDoctor_phone());
				assertNotNull(result.getDoctor_state());
				assertNotNull(result.getDoctor_street());
				assertNotNull(result.getDoctor_suite());
				assertNotNull(result.getDoctor_zip());
				assertNotNull(result.getDoctor_id());
				assertNotNull(result.getDoctor_reg_id());
				assertNotNull(result.getDoctor_speciality());

				//Equal assertion of Input and Output
				assertEquals(result.getDoctor_city(),mockDoctor.getDoctor_city());
				assertEquals(result.getDoctor_id(),mockDoctor.getDoctor_id());
				assertEquals(result.getDoctor_country(),mockDoctor.getDoctor_country());
				assertEquals(result.getDoctor_email(),mockDoctor.getDoctor_email());
				assertEquals(result.getDoctor_firstname(),mockDoctor.getDoctor_firstname());
				assertEquals(result.getDoctor_lastname(),mockDoctor.getDoctor_lastname());
				assertEquals(result.getDoctor_password(),mockDoctor.getDoctor_password());
				assertEquals(result.getDoctor_phone(),mockDoctor.getDoctor_phone());
				assertEquals(result.getDoctor_state(),mockDoctor.getDoctor_state());
				assertEquals(result.getDoctor_street(),mockDoctor.getDoctor_street());
				assertEquals(result.getDoctor_suite(),mockDoctor.getDoctor_suite());
				assertEquals(result.getDoctor_zip(),mockDoctor.getDoctor_zip());
				assertEquals(result.getDoctor_reg_id(), mockDoctor.getDoctor_reg_id());
				assertEquals(result.getDoctor_speciality(), mockDoctor.getDoctor_speciality());
				
				
			}

			@Test
			public void testDeleteDoctor() {

				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doNothing().when(mockDoctorService).deleteDoctor(Mockito.anyString());

				//Method call
				ResponseEntity<Void> response = doctorController.deleteDoctor("2");

				//Check for Valid response
				assertNotNull(response);

				//check for value in response
				assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

			}
			
			
			@Test
			public void testGetDoctorByMail() 
			{

				
				//mocking Doctor response
				Doctor mockDoctor = new Doctor();
				
				mockDoctor.setDoctor_city("HALIFAX");
				mockDoctor.setDoctor_country("Canada");
				mockDoctor.setDoctor_email("vidhyashree1992@gmail.com");
				mockDoctor.setDoctor_firstname("VIDHYASHREE");
				mockDoctor.setDoctor_lastname("BOOPATHY");
				mockDoctor.setDoctor_password("vidhu@123");
				mockDoctor.setDoctor_phone("9024129698");
				mockDoctor.setDoctor_state("Nova Scotia");
				mockDoctor.setDoctor_street("110");
				mockDoctor.setDoctor_suite("123");
				mockDoctor.setDoctor_zip("B3L4R1");
				mockDoctor.setDoctor_id("2");
				mockDoctor.setDoctor_reg_id("1234");
				mockDoctor.setDoctor_speciality("apollo");


				//Mockito to mock the control from going to service class
				//Mocking DoctorService object
				//DoctorService mockDoctorService = spy(DoctorService.class);
				Mockito.doReturn(mockDoctor).when(mockDoctorService).getDoctorByMail(Mockito.anyString());

				//Method call
				ResponseEntity<Doctor> response = doctorController.getDoctorByMail("vidhyashree1992@gmail.com");
				Doctor result = response.getBody();

				//NotNull assertion
				assertNotNull(result);
				assertNotNull(result.getDoctor_city());
				assertNotNull(result.getDoctor_country());
				assertNotNull(result.getDoctor_email());
				assertNotNull(result.getDoctor_firstname());
				assertNotNull(result.getDoctor_lastname());
				assertNotNull(result.getDoctor_password());
				assertNotNull(result.getDoctor_phone());
				assertNotNull(result.getDoctor_state());
				assertNotNull(result.getDoctor_street());
				assertNotNull(result.getDoctor_suite());
				assertNotNull(result.getDoctor_zip());
				assertNotNull(result.getDoctor_id());

				//Equal assertion of Input and Output
				assertEquals(result.getDoctor_city(),mockDoctor.getDoctor_city());
				assertEquals(result.getDoctor_id(),mockDoctor.getDoctor_id());
				assertEquals(result.getDoctor_country(),mockDoctor.getDoctor_country());
				assertEquals(result.getDoctor_email(),mockDoctor.getDoctor_email());
				assertEquals(result.getDoctor_firstname(),mockDoctor.getDoctor_firstname());
				assertEquals(result.getDoctor_lastname(),mockDoctor.getDoctor_lastname());
				assertEquals(result.getDoctor_password(),mockDoctor.getDoctor_password());
				assertEquals(result.getDoctor_phone(),mockDoctor.getDoctor_phone());
				assertEquals(result.getDoctor_state(),mockDoctor.getDoctor_state());
				assertEquals(result.getDoctor_street(),mockDoctor.getDoctor_street());
				assertEquals(result.getDoctor_suite(),mockDoctor.getDoctor_suite());
				assertEquals(result.getDoctor_zip(),mockDoctor.getDoctor_zip());
			
			
			}

		

}
