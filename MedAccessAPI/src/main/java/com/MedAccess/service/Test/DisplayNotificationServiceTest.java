package com.MedAccess.service.Test;

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
import org.springframework.http.ResponseEntity;

import com.MedAccess.Controller.DisplayNotificationController;
import com.MedAccess.Controller.Test.DisplayNotificationControllerTest;
import com.MedAccess.Dao.DisplayNotificationDAO;
import com.MedAccess.Models.DoctorNotification;
import com.MedAccess.service.DisplayNotificationService;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({DisplayNotificationServiceTest.class,DisplayNotificationService.class,DisplayNotificationDAO.class})
public class DisplayNotificationServiceTest {
	
	

	@Spy
	private DisplayNotificationDAO mockDisplayNotificationDAO;
	
	@InjectMocks
	private DisplayNotificationService displayNotificationService;
	
	
	@Test
	public void testGetDoctorAppointment()
	{
		
		//mocking Doctor response
				DoctorNotification mockDoctorNotification1 = new DoctorNotification();
				DoctorNotification mockDoctorNotification2 = new DoctorNotification();
				
				
				mockDoctorNotification1.setAppointment_id("17");
				mockDoctorNotification1.setPatient_id("31");
				mockDoctorNotification1.setPatient_firstname("Ronaldooo");
				mockDoctorNotification1.setPatient_phone("9090909090");
				mockDoctorNotification1.setApp_date("2018-07-28");
				mockDoctorNotification1.setApp_time("8pm");
				
				
				mockDoctorNotification2.setAppointment_id("16");
				mockDoctorNotification2.setPatient_id("31");
				mockDoctorNotification2.setPatient_firstname("Ronaldooo");
				mockDoctorNotification2.setPatient_phone("9090909090");
				mockDoctorNotification2.setApp_date("2018-07-25");
				mockDoctorNotification2.setApp_time("7pm");
				
				
				List<DoctorNotification> mockDoctorNotificationList = new ArrayList<DoctorNotification>();
				mockDoctorNotificationList.add(mockDoctorNotification1);
				mockDoctorNotificationList.add(mockDoctorNotification2);
				
				
				//Mockito to mock the control from going to service class
				//Mocking DisplayNotificationService object
				//DisplayNotificationService mockDisplayNotificationService = spy(DisplayNotificationService.class);
				Mockito.doReturn(mockDoctorNotificationList).when(mockDisplayNotificationDAO).getDoctorAppointment(Mockito.anyString());

				
				//Method call
				List<DoctorNotification> resultDoctorNotification = displayNotificationService.getDoctorAppointment("1");
				
				
				DoctorNotification result1 = resultDoctorNotification.get(0);
				DoctorNotification result2 = resultDoctorNotification.get(1);
				
				
				//NotNull assertion
				assertNotNull(result1);
				assertNotNull(result1.getAppointment_id());
				assertNotNull(result1.getPatient_id());
				assertNotNull(result1.getPatient_firstname());
				assertNotNull(result1.getPatient_phone());
				assertNotNull(result1.getApp_date());
				assertNotNull(result1.getApp_time());
				
				
				//Equal assertion of Input and Output
				assertEquals(result1.getAppointment_id(),mockDoctorNotification1.getAppointment_id());
				assertEquals(result1.getPatient_id(),mockDoctorNotification1.getPatient_id());
				assertEquals(result1.getPatient_firstname(),mockDoctorNotification1.getPatient_firstname());
				assertEquals(result1.getPatient_phone(),mockDoctorNotification1.getPatient_phone());
				assertEquals(result1.getApp_date(),mockDoctorNotification1.getApp_date());
				assertEquals(result1.getApp_time(),mockDoctorNotification1.getApp_time());
				
				
				//NotNull assertion
						assertNotNull(result2);
						assertNotNull(result2.getAppointment_id());
						assertNotNull(result2.getPatient_id());
						assertNotNull(result2.getPatient_firstname());
						assertNotNull(result2.getPatient_phone());
						assertNotNull(result2.getApp_date());
						assertNotNull(result2.getApp_time());
						
						
				//Equal assertion of Input and Output
						assertEquals(result2.getAppointment_id(),mockDoctorNotification2.getAppointment_id());
						assertEquals(result2.getPatient_id(),mockDoctorNotification2.getPatient_id());
						assertEquals(result2.getPatient_firstname(),mockDoctorNotification2.getPatient_firstname());
						assertEquals(result2.getPatient_phone(),mockDoctorNotification2.getPatient_phone());
						assertEquals(result2.getApp_date(),mockDoctorNotification2.getApp_date());
						assertEquals(result2.getApp_time(),mockDoctorNotification2.getApp_time());
						
			
				
	}
		
		
	
}
