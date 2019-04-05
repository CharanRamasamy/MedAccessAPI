package com.MedAccess.Controller.Test;

import com.MedAccess.Controller.AppointmentController;
import com.MedAccess.Controller.FeedbackController;
import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Feedback;
import com.MedAccess.service.AppointmentService;
import com.MedAccess.service.FeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({AppointmentControllerTest.class,AppointmentController.class,AppointmentService.class})
public class AppointmentControllerTest {

    @Spy
    private AppointmentService mockAppointmentService;

    @InjectMocks
    private AppointmentController AppointmentController;

    @Test
    public void getAppointmentById(){

        //mockAppointment object
        Appointment mockAppointment = new Appointment();
        mockAppointment.setApp_date("06/06/2018");
        mockAppointment.setApp_time("1200");
        mockAppointment.setAppointment_id("21");
        mockAppointment.setPatient_id("2");
        mockAppointment.setDoctor_firstname("Leo");
        mockAppointment.setDoctor_id("45");
        mockAppointment.setDoctor_phone("19028765675");

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(mockAppointment).when(mockAppointmentService).getAppointmentByID(Mockito.anyString());

        //Method call
        ResponseEntity<Appointment> response = AppointmentController.getAppointmentbyId("21");
        Appointment result = response.getBody();

        //check for null values
        assertNotNull(result);
        assertNotNull(result.getApp_date());
        assertNotNull(result.getApp_time());
        assertNotNull(result.getDoctor_firstname());
        assertNotNull(result.getDoctor_id());
        assertNotNull(result.getDoctor_phone());
        assertNotNull(result.getPatient_id());
        assertNotNull(result.getAppointment_id());

        //check whether the values are same
        assertEquals(result.getApp_date(),mockAppointment.getApp_date());
        assertEquals(result.getApp_time(),mockAppointment.getApp_time());
        assertEquals(result.getDoctor_firstname(),mockAppointment.getDoctor_firstname());
        assertEquals(result.getDoctor_id(),mockAppointment.getDoctor_id());
        assertEquals(result.getDoctor_phone(),mockAppointment.getDoctor_phone());
        assertEquals(result.getPatient_id(),mockAppointment.getPatient_id());
        assertEquals(result.getAppointment_id(),mockAppointment.getAppointment_id());

    }

    @Test
    public void getAppointmentbyPatientID(){

        //mockAppointment object  1
        Appointment mockAppointment1 = new Appointment();
        mockAppointment1.setApp_date("03/04/2018");
        mockAppointment1.setApp_time("0400");
        mockAppointment1.setAppointment_id("11");
        mockAppointment1.setPatient_id("5");
        mockAppointment1.setDoctor_firstname("Mbappe");
        mockAppointment1.setDoctor_id("4");
        mockAppointment1.setDoctor_phone("14028456388");

        //mockAppointment object 2
        Appointment mockAppointment2 = new Appointment();
        mockAppointment2.setApp_date("06/06/2018");
        mockAppointment2.setApp_time("1200");
        mockAppointment2.setAppointment_id("21");
        mockAppointment2.setPatient_id("2");
        mockAppointment2.setDoctor_firstname("Leo");
        mockAppointment2.setDoctor_id("45");
        mockAppointment2.setDoctor_phone("19028765675");


        //List of mock objects
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(mockAppointment1);
        appointmentList.add(mockAppointment2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(appointmentList).when(mockAppointmentService).getAppointmentbypatientId(Mockito.anyString());

        //Method call
        ResponseEntity<List<Appointment>> response = AppointmentController.getAppointmentbyPatientID("21");
        List<Appointment> resultList = response.getBody();

        //Getting objects from result
        Appointment result1 = resultList.get(0);
        Appointment result2 = resultList.get(1);

        //check for null values
        assertNotNull(result1);
        assertNotNull(result1.getApp_date());
        assertNotNull(result1.getApp_time());
        assertNotNull(result1.getDoctor_firstname());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_phone());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getAppointment_id());

        assertNotNull(result2);
        assertNotNull(result2.getApp_date());
        assertNotNull(result2.getApp_time());
        assertNotNull(result2.getDoctor_firstname());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDoctor_phone());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getAppointment_id());

        //check whether the values are same for both objects
        assertEquals(result1.getApp_date(),mockAppointment1.getApp_date());
        assertEquals(result1.getApp_time(),mockAppointment1.getApp_time());
        assertEquals(result1.getDoctor_firstname(),mockAppointment1.getDoctor_firstname());
        assertEquals(result1.getDoctor_id(),mockAppointment1.getDoctor_id());
        assertEquals(result1.getDoctor_phone(),mockAppointment1.getDoctor_phone());
        assertEquals(result1.getPatient_id(),mockAppointment1.getPatient_id());
        assertEquals(result1.getAppointment_id(),mockAppointment1.getAppointment_id());

        assertEquals(result2.getApp_date(),mockAppointment2.getApp_date());
        assertEquals(result2.getApp_time(),mockAppointment2.getApp_time());
        assertEquals(result2.getDoctor_firstname(),mockAppointment2.getDoctor_firstname());
        assertEquals(result2.getDoctor_id(),mockAppointment2.getDoctor_id());
        assertEquals(result2.getDoctor_phone(),mockAppointment2.getDoctor_phone());
        assertEquals(result2.getPatient_id(),mockAppointment2.getPatient_id());
        assertEquals(result2.getAppointment_id(),mockAppointment2.getAppointment_id());

    }

    @Test
    public void getAllAppointments(){

        //mockAppointment object  1
        Appointment mockAppointment1 = new Appointment();
        mockAppointment1.setApp_date("03/04/2018");
        mockAppointment1.setApp_time("0400");
        mockAppointment1.setAppointment_id("11");
        mockAppointment1.setPatient_id("5");
        mockAppointment1.setDoctor_firstname("Mbappe");
        mockAppointment1.setDoctor_id("4");
        mockAppointment1.setDoctor_phone("14028456388");

        //mockAppointment object 2
        Appointment mockAppointment2 = new Appointment();
        mockAppointment2.setApp_date("06/06/2018");
        mockAppointment2.setApp_time("1200");
        mockAppointment2.setAppointment_id("21");
        mockAppointment2.setPatient_id("2");
        mockAppointment2.setDoctor_firstname("Leo");
        mockAppointment2.setDoctor_id("45");
        mockAppointment2.setDoctor_phone("19028765675");


        //List of mock objects
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(mockAppointment1);
        appointmentList.add(mockAppointment2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(appointmentList).when(mockAppointmentService).getAllAppointments();

        //Method call
        ResponseEntity<List<Appointment>> response = AppointmentController.getAllAppointments();
        List<Appointment> resultList = response.getBody();

        //Getting objects from result
        Appointment result1 = resultList.get(0);
        Appointment result2 = resultList.get(1);

        //check for null values
        assertNotNull(result1);
        assertNotNull(result1.getApp_date());
        assertNotNull(result1.getApp_time());
        assertNotNull(result1.getDoctor_firstname());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_phone());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getAppointment_id());

        assertNotNull(result2);
        assertNotNull(result2.getApp_date());
        assertNotNull(result2.getApp_time());
        assertNotNull(result2.getDoctor_firstname());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDoctor_phone());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getAppointment_id());

        //check whether the values are same for both objects
        assertEquals(result1.getApp_date(),mockAppointment1.getApp_date());
        assertEquals(result1.getApp_time(),mockAppointment1.getApp_time());
        assertEquals(result1.getDoctor_firstname(),mockAppointment1.getDoctor_firstname());
        assertEquals(result1.getDoctor_id(),mockAppointment1.getDoctor_id());
        assertEquals(result1.getDoctor_phone(),mockAppointment1.getDoctor_phone());
        assertEquals(result1.getPatient_id(),mockAppointment1.getPatient_id());
        assertEquals(result1.getAppointment_id(),mockAppointment1.getAppointment_id());

        assertEquals(result2.getApp_date(),mockAppointment2.getApp_date());
        assertEquals(result2.getApp_time(),mockAppointment2.getApp_time());
        assertEquals(result2.getDoctor_firstname(),mockAppointment2.getDoctor_firstname());
        assertEquals(result2.getDoctor_id(),mockAppointment2.getDoctor_id());
        assertEquals(result2.getDoctor_phone(),mockAppointment2.getDoctor_phone());
        assertEquals(result2.getPatient_id(),mockAppointment2.getPatient_id());
        assertEquals(result2.getAppointment_id(),mockAppointment2.getAppointment_id());

    }

    @Test
    public void addAppointment(){

        //mockAppointment object
        Appointment mockAppointment = new Appointment();
        mockAppointment.setApp_date("06/06/2018");
        mockAppointment.setApp_time("1200");
        mockAppointment.setAppointment_id("21");
        mockAppointment.setPatient_id("2");
        mockAppointment.setDoctor_firstname("Leo");
        mockAppointment.setDoctor_id("45");
        mockAppointment.setDoctor_phone("19028765675");

        //Mockito to mock the control from going to service class
        //Mocking AppointmentService object
        //AppointmentService mockFeedbackService = spy(AppointmentService.class);
        Mockito.doReturn(true).when(mockAppointmentService).addAppointment(mockAppointment);

        //Method call
        ResponseEntity<Void> response = AppointmentController.addAppointment(mockAppointment);

        //Check for Valid response
        assertNotNull(response);

        //check for value in response
        assertEquals(201,response.getStatusCodeValue());
        assertEquals(HttpStatus.CREATED,response.getStatusCode());

    }

    @Test
    public void deleteAppointment(){

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //AppointmentService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doNothing().when(mockAppointmentService).deleteAppointment("21");

        //Method call
        ResponseEntity<Void> response = AppointmentController.deleteAppointment("21");

        //Check for Valid response
        assertNotNull(response);

        //check for value in response
        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

    }
}
