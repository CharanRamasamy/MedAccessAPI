package com.MedAccess.service.Test;

import com.MedAccess.Dao.FeedbackDAO;
import com.MedAccess.Dao.PatientDAO;
import com.MedAccess.Models.Feedback;
import com.MedAccess.service.FeedbackService;
import com.MedAccess.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({PatientServiceTest.class, PatientService.class, PatientDAO.class})
public class FeedbackServiceTest {

    @Spy
    private FeedbackDAO mockFeedbackDAO;

    @InjectMocks
    private FeedbackService feedbackService;

    @Test
    public void testGetAllFeedbacks()
    {
        //mocking Feedback response
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPosteddate("06/06/2018");
        mockFeedback1.setDescription("Description");
        mockFeedback1.setEmail("Messi@gmail.com");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setDoctor_id("10");
        mockFeedback1.setFeedback_id("21");
        mockFeedback1.setPatient_name("RoNaldo");
        mockFeedback1.setPatient_id("7");

        //mocking Feedback response
        Feedback mockFeedback2 = new Feedback();
        mockFeedback2.setPosteddate("05/05/2018");
        mockFeedback2.setDescription("Detailed Description");
        mockFeedback2.setEmail("Lionel@gmail.com");
        mockFeedback2.setDoctor_name("Tiago");
        mockFeedback2.setDoctor_id("11");
        mockFeedback2.setFeedback_id("22");
        mockFeedback2.setPatient_name("cristiano");
        mockFeedback2.setPatient_id("77");

        List<Feedback> mockFeedbackList = new ArrayList<Feedback>();
        mockFeedbackList.add(mockFeedback1);
        mockFeedbackList.add(mockFeedback2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(mockFeedbackList).when(mockFeedbackDAO).getAllFeedbacks();

        //Method call
        List<Feedback> resultFeedbackList = feedbackService.getAllFeedbacks();
        Feedback result1 = resultFeedbackList.get(0);
        Feedback result2 = resultFeedbackList.get(1);

        //NotNull assertion for Feedback1
        assertNotNull(result1);
        assertNotNull(result1.getFeedback_id());
        assertNotNull(result1.getPosteddate());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDescription());

        //Equal assertion of Input and Output for Feedback1
        assertEquals(result1.getDescription(),mockFeedback1.getDescription());
        assertEquals(result1.getDoctor_id(),mockFeedback1.getDoctor_id());
        assertEquals(result1.getDoctor_name(),mockFeedback1.getDoctor_name());
        assertEquals(result1.getEmail(),mockFeedback1.getEmail());
        assertEquals(result1.getPatient_id(),mockFeedback1.getPatient_id());
        assertEquals(result1.getPatient_name(),mockFeedback1.getPatient_name());
        assertEquals(result1.getPosteddate(),mockFeedback1.getPosteddate());
        assertEquals(result1.getFeedback_id(),mockFeedback1.getFeedback_id());

        //NotNull assertion for Feedback2
        assertNotNull(result2);
        assertNotNull(result2.getFeedback_id());
        assertNotNull(result2.getPosteddate());
        assertNotNull(result2.getPatient_name());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getEmail());
        assertNotNull(result2.getDoctor_name());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDescription());

        //Equal assertion of Input and Output for Feedback2
        assertEquals(result2.getDescription(),mockFeedback2.getDescription());
        assertEquals(result2.getDoctor_id(),mockFeedback2.getDoctor_id());
        assertEquals(result2.getDoctor_name(),mockFeedback2.getDoctor_name());
        assertEquals(result2.getEmail(),mockFeedback2.getEmail());
        assertEquals(result2.getPatient_id(),mockFeedback2.getPatient_id());
        assertEquals(result2.getPatient_name(),mockFeedback2.getPatient_name());
        assertEquals(result2.getPosteddate(),mockFeedback2.getPosteddate());
        assertEquals(result2.getFeedback_id(),mockFeedback2.getFeedback_id());

    }

    @Test
    public void getFeedbackById(){

         //mocking Feedback response
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPosteddate("06/06/2018");
        mockFeedback1.setDescription("Description");
        mockFeedback1.setEmail("Messi@gmail.com");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setDoctor_id("10");
        mockFeedback1.setFeedback_id("21");
        mockFeedback1.setPatient_name("RoNaldo");
        mockFeedback1.setPatient_id("7");

        //mocking Feedback response
        Feedback mockFeedback2 = new Feedback();
        mockFeedback2.setPosteddate("05/05/2018");
        mockFeedback2.setDescription("Detailed Description");
        mockFeedback2.setEmail("Lionel@gmail.com");
        mockFeedback2.setDoctor_name("Tiago");
        mockFeedback2.setDoctor_id("11");
        mockFeedback2.setFeedback_id("22");
        mockFeedback2.setPatient_name("cristiano");
        mockFeedback2.setPatient_id("77");

        List<Feedback> mockFeedbackList = new ArrayList<Feedback>();
        mockFeedbackList.add(mockFeedback1);
        mockFeedbackList.add(mockFeedback2);

        //Mockito to mock the control from going to service class
        //Mocking FeedbackService object
        //FeedbackService mockFeedbackService = spy(FeedbackService.class);
        Mockito.doReturn(mockFeedbackList).when(mockFeedbackDAO).getFeedbackById("10");

        //Method call
        List<Feedback> resultFeedbackList = feedbackService.getFeedbackById("10");
        Feedback result1 = resultFeedbackList.get(0);

        //NotNull assertion for Feedback1
        assertNotNull(result1);
        assertNotNull(result1.getFeedback_id());
        assertNotNull(result1.getPosteddate());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDescription());

        //Equal assertion of Input and Output for Feedback1
        assertEquals(result1.getDescription(),mockFeedback1.getDescription());
        assertEquals(result1.getDoctor_id(),mockFeedback1.getDoctor_id());
        assertEquals(result1.getDoctor_name(),mockFeedback1.getDoctor_name());
        assertEquals(result1.getEmail(),mockFeedback1.getEmail());
        assertEquals(result1.getPatient_id(),mockFeedback1.getPatient_id());
        assertEquals(result1.getPatient_name(),mockFeedback1.getPatient_name());
        assertEquals(result1.getPosteddate(),mockFeedback1.getPosteddate());
        assertEquals(result1.getFeedback_id(),mockFeedback1.getFeedback_id());
    }


    @Test
    public void addPatient(){

        //mocking Feedback response
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPosteddate("06/06/2018");
        mockFeedback1.setDescription("Description");
        mockFeedback1.setEmail("Messi@gmail.com");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setDoctor_id("10");
        mockFeedback1.setFeedback_id("21");
        mockFeedback1.setPatient_name("RoNaldo");
        mockFeedback1.setPatient_id("7");

        Mockito.doNothing().when(mockFeedbackDAO).addFeedback(mockFeedback1);

        boolean result = feedbackService.addFeedback(mockFeedback1);

        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void updatePatient(){

        //mocking Feedback response
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPosteddate("06/06/2018");
        mockFeedback1.setDescription("Description");
        mockFeedback1.setEmail("Messi@gmail.com");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setDoctor_id("10");
        mockFeedback1.setFeedback_id("21");
        mockFeedback1.setPatient_name("RoNaldo");
        mockFeedback1.setPatient_id("7");

        Mockito.doNothing().when(mockFeedbackDAO).updateFeedback(mockFeedback1);

    }

    @Test
    public void deletePatient(){

        //mocking Feedback response
        Feedback mockFeedback1 = new Feedback();
        mockFeedback1.setPosteddate("06/06/2018");
        mockFeedback1.setDescription("Description");
        mockFeedback1.setEmail("Messi@gmail.com");
        mockFeedback1.setDoctor_name("Leo");
        mockFeedback1.setDoctor_id("10");
        mockFeedback1.setFeedback_id("21");
        mockFeedback1.setPatient_name("RoNaldo");
        mockFeedback1.setPatient_id("7");

        Mockito.doNothing().when(mockFeedbackDAO).deleteFeedback("10");

    }
}
