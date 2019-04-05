package com.MedAccess.Controller.Test;

import com.MedAccess.Controller.FeedbackController;
import com.MedAccess.Models.Feedback;
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
@PrepareForTest({FeedbackControllerTest.class,FeedbackController.class,FeedbackService.class})
public class FeedbackControllerTest {

    @Spy
    private FeedbackService mockFeedbackService;

    @InjectMocks
    private FeedbackController FeedbackController;

    @Test
    public void testGetFeedbackById() {

        //Creating first mock object for Feedback
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPatient_id("10");
        mockFeedback1.setPatient_name("Messi");
        mockFeedback1.setFeedback_id("1");
        mockFeedback1.setDoctor_id("22");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setEmail("Lionel@gmail.com");
        mockFeedback1.setDescription("Feedback Description");
        mockFeedback1.setPosteddate("06/06/2018");

        //Creating Second mock object for Feedback
        Feedback mockFeedback2 = new Feedback();
        mockFeedback2.setPatient_id("11");
        mockFeedback2.setPatient_name("Neymar");
        mockFeedback2.setFeedback_id("12");
        mockFeedback2.setDoctor_id("22");
        mockFeedback2.setDoctor_name("Mbappe");
        mockFeedback2.setEmail("Mbappe@gmail.com");
        mockFeedback2.setDescription("Feedback Description");
        mockFeedback2.setPosteddate("06/06/2018");

        //List of Feedback objects
        List<Feedback> mockFeedbackList = new ArrayList<Feedback>();
        mockFeedbackList.add(mockFeedback1);
        mockFeedbackList.add(mockFeedback2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(mockFeedbackList).when(mockFeedbackService).getFeedbackById("22");

        //Method call
        ResponseEntity<List<Feedback>> response = FeedbackController.getFeedbackById("22");
        List<Feedback> resultList = response.getBody();
        Feedback result1 = resultList.get(0);
        Feedback result2 = resultList.get(1);

        //NotNull assertion
        assertNotNull(result1);
        assertNotNull(result1.getDescription());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPosteddate());
        assertNotNull(result1.getFeedback_id());

        assertNotNull(result2);
        assertNotNull(result2.getDescription());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDoctor_name());
        assertNotNull(result2.getEmail());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getPatient_name());
        assertNotNull(result2.getPosteddate());
        assertNotNull(result2.getFeedback_id());

        //Check whether the values returned are same
        assertEquals(mockFeedback1.getFeedback_id(),result1.getFeedback_id());
        assertEquals(mockFeedback1.getPosteddate(),result1.getPosteddate());
        assertEquals(mockFeedback1.getPatient_name(),result1.getPatient_name());
        assertEquals(mockFeedback1.getPatient_id(),result1.getPatient_id());
        assertEquals(mockFeedback1.getEmail(),result1.getEmail());
        assertEquals(mockFeedback1.getDoctor_name(),result1.getDoctor_name());
        assertEquals(mockFeedback1.getDoctor_id(),result1.getDoctor_id());
        assertEquals(mockFeedback1.getDescription(),result1.getDescription());

        assertEquals(mockFeedback2.getFeedback_id(),result2.getFeedback_id());
        assertEquals(mockFeedback2.getPosteddate(),result2.getPosteddate());
        assertEquals(mockFeedback2.getPatient_name(),result2.getPatient_name());
        assertEquals(mockFeedback2.getPatient_id(),result2.getPatient_id());
        assertEquals(mockFeedback2.getEmail(),result2.getEmail());
        assertEquals(mockFeedback2.getDoctor_name(),result2.getDoctor_name());
        assertEquals(mockFeedback2.getDoctor_id(),result2.getDoctor_id());
        assertEquals(mockFeedback2.getDescription(),result2.getDescription());
    }
    @Test
    public void testGetAllFeedbacks() {
        //Creating first mock object for Feedback
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPatient_id("10");
        mockFeedback1.setPatient_name("Messi");
        mockFeedback1.setFeedback_id("1");
        mockFeedback1.setDoctor_id("2");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setEmail("Lionel@gmail.com");
        mockFeedback1.setDescription("Feedback Description");
        mockFeedback1.setPosteddate("06/06/2018");

        //Creating Second mock object for Feedback
        Feedback mockFeedback2 = new Feedback();
        mockFeedback2.setPatient_id("11");
        mockFeedback2.setPatient_name("Neymar");
        mockFeedback2.setFeedback_id("12");
        mockFeedback2.setDoctor_id("22");
        mockFeedback2.setDoctor_name("Mbappe");
        mockFeedback2.setEmail("Mbappe@gmail.com");
        mockFeedback2.setDescription("Feedback Description");
        mockFeedback2.setPosteddate("06/06/2018");

        //List of Feedback objects
        List<Feedback> mockFeedbackList = new ArrayList<Feedback>();
        mockFeedbackList.add(mockFeedback1);
        mockFeedbackList.add(mockFeedback2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(mockFeedbackList).when(mockFeedbackService).getAllFeedbacks();

        //Method call
        ResponseEntity<List<Feedback>> response = FeedbackController.getAllFeedbacks();
        List<Feedback> resultList = response.getBody();
        Feedback result1 = resultList.get(0);
        Feedback result2 = resultList.get(1);

        //NotNull assertion
        assertNotNull(result1);
        assertNotNull(result1.getDescription());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPosteddate());
        assertNotNull(result1.getFeedback_id());

        assertNotNull(result2);
        assertNotNull(result2.getDescription());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDoctor_name());
        assertNotNull(result2.getEmail());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getPatient_name());
        assertNotNull(result2.getPosteddate());
        assertNotNull(result2.getFeedback_id());

        //Check whether the values returned are same
        assertEquals(mockFeedback1.getFeedback_id(),result1.getFeedback_id());
        assertEquals(mockFeedback1.getPosteddate(),result1.getPosteddate());
        assertEquals(mockFeedback1.getPatient_name(),result1.getPatient_name());
        assertEquals(mockFeedback1.getPatient_id(),result1.getPatient_id());
        assertEquals(mockFeedback1.getEmail(),result1.getEmail());
        assertEquals(mockFeedback1.getDoctor_name(),result1.getDoctor_name());
        assertEquals(mockFeedback1.getDoctor_id(),result1.getDoctor_id());
        assertEquals(mockFeedback1.getDescription(),result1.getDescription());

        assertEquals(mockFeedback2.getFeedback_id(),result2.getFeedback_id());
        assertEquals(mockFeedback2.getPosteddate(),result2.getPosteddate());
        assertEquals(mockFeedback2.getPatient_name(),result2.getPatient_name());
        assertEquals(mockFeedback2.getPatient_id(),result2.getPatient_id());
        assertEquals(mockFeedback2.getEmail(),result2.getEmail());
        assertEquals(mockFeedback2.getDoctor_name(),result2.getDoctor_name());
        assertEquals(mockFeedback2.getDoctor_id(),result2.getDoctor_id());
        assertEquals(mockFeedback2.getDescription(),result2.getDescription());

    }

    @Test
    public void testAddFeedback() {

        //Creating mock object for Feedback
        Feedback mockFeedback = new Feedback();
        mockFeedback.setPatient_id("10");
        mockFeedback.setPatient_name("Messi");
        mockFeedback.setFeedback_id("1");
        mockFeedback.setDoctor_id("2");
        mockFeedback.setDoctor_name("Leo");
        mockFeedback.setEmail("Lionel@gmail.com");
        mockFeedback.setDescription("Feedback Description");
        mockFeedback.setPosteddate("06/06/2018");

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(true).when(mockFeedbackService).addFeedback(mockFeedback);

        //Method call
        ResponseEntity<Void> response = FeedbackController.addFeedback(mockFeedback);

        //Check for Valid response
        assertNotNull(response);

        //check for value in response
        assertEquals(201,response.getStatusCodeValue());
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    public void testUpdateFeedback() {

        //Creating mock object for Feedback
        Feedback mockFeedback = new Feedback();
        mockFeedback.setPatient_id("10");
        mockFeedback.setPatient_name("Messi");
        mockFeedback.setFeedback_id("1");
        mockFeedback.setDoctor_id("2");
        mockFeedback.setDoctor_name("Leo");
        mockFeedback.setEmail("Lionel@gmail.com");
        mockFeedback.setDescription("Feedback Description");
        mockFeedback.setPosteddate("06/06/2018");

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doNothing().when(mockFeedbackService).updateFeedback(mockFeedback);

        //Method call
        ResponseEntity<Feedback> response = FeedbackController.updateFeedback(mockFeedback);

        //Check for Valid response
        assertNotNull(response);

        //check for value in response
        assertEquals(HttpStatus.OK,response.getStatusCode());

        //Get Feedback object which is returned from the method
        Feedback result = response.getBody();

        //Check for Null value assertion
        assertNotNull(result);
        assertNotNull(result.getDescription());
        assertNotNull(result.getDoctor_id());
        assertNotNull(result.getDoctor_name());
        assertNotNull(result.getEmail());
        assertNotNull(result.getPatient_id());
        assertNotNull(result.getPatient_name());
        assertNotNull(result.getPosteddate());
        assertNotNull(result.getFeedback_id());

        //Check whether the values returned are same
        assertEquals(mockFeedback.getFeedback_id(),result.getFeedback_id());
        assertEquals(mockFeedback.getPosteddate(),result.getPosteddate());
        assertEquals(mockFeedback.getPatient_name(),result.getPatient_name());
        assertEquals(mockFeedback.getPatient_id(),result.getPatient_id());
        assertEquals(mockFeedback.getEmail(),result.getEmail());
        assertEquals(mockFeedback.getDoctor_name(),result.getDoctor_name());
        assertEquals(mockFeedback.getDoctor_id(),result.getDoctor_id());
        assertEquals(mockFeedback.getDescription(),result.getDescription());

    }

    @Test
    public void testDeleteFeedback() {

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doNothing().when(mockFeedbackService).deleteFeedback("21");

        //Method call
        ResponseEntity<Void> response = FeedbackController.deleteFeedback("21");

        //Check for Valid response
        assertNotNull(response);

        //check for value in response
        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

    }

}
