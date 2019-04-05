package com.MedAccess.Dao.Test;

import com.MedAccess.Dao.FeedbackDAO;
import com.MedAccess.Models.Feedback;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({FeedbackDAOTest.class, FeedbackDAO.class})
public class FeedbackDAOTest {

    @Mock
    private DataSource mockDataSource;

    @Mock
    Logger logger;

    @InjectMocks
    private FeedbackDAO feedbackDAO;

    @Test
    public void testGetFeedbackById() throws SQLException {

         //Mockito to mock the control from going to service class
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Logger mocks
        Mockito.doNothing().when(logger).info(Mockito.any());

        //Mocking ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getString("patient_id")).thenReturn("10").thenReturn("11");
        Mockito.when(resultSet.getString("patient_name")).thenReturn("Messi").thenReturn("Mbappe");
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("24").thenReturn("25");
        Mockito.when(resultSet.getString("doctor_name")).thenReturn("Lionel").thenReturn("Kylian");
        Mockito.when(resultSet.getString("email")).thenReturn("Messi@gmail.com").thenReturn("Mbappe@psg.com");
        Mockito.when(resultSet.getString("description")).thenReturn("Description").thenReturn("Description");
        Mockito.when(resultSet.getString("posteddate")).thenReturn("22/03/2017").thenReturn("11/03/2017");

        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<Feedback> resultList = feedbackDAO.getFeedbackById("24");
        Feedback result1 = resultList.get(0);

        //Check for Null value assertion
        assertNotNull(result1);
        assertNotNull(result1.getDescription());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPosteddate());

        //Check whether the values returned are same
        assertEquals("22/03/2017",result1.getPosteddate());
        assertEquals("Messi",result1.getPatient_name());
        assertEquals("10",result1.getPatient_id());
        assertEquals("Messi@gmail.com",result1.getEmail());
        assertEquals("Lionel",result1.getDoctor_name());
        assertEquals("24",result1.getDoctor_id());
        assertEquals("Description",result1.getDescription());


    }
    @Test
    public void testGetAllFeedbacks() throws SQLException {

        //Mockito to mock the control from going to service class
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Logger mocks
        Mockito.doNothing().when(logger).info(Mockito.any());

        //Mocking ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getString("patient_id")).thenReturn("10").thenReturn("11");
        Mockito.when(resultSet.getString("patient_name")).thenReturn("Messi").thenReturn("Mbappe");
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("24").thenReturn("25");
        Mockito.when(resultSet.getString("doctor_name")).thenReturn("Lionel").thenReturn("Kylian");
        Mockito.when(resultSet.getString("email")).thenReturn("Messi@gmail.com").thenReturn("Mbappe@psg.com");
        Mockito.when(resultSet.getString("description")).thenReturn("Description").thenReturn("Description");
        Mockito.when(resultSet.getString("posteddate")).thenReturn("22/03/2017").thenReturn("11/03/2017");

        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<Feedback> resultList = feedbackDAO.getAllFeedbacks();
        Feedback result1 = resultList.get(0);
        Feedback result2 = resultList.get(1);

        //Check for Null value assertion
        assertNotNull(result1);
        assertNotNull(result1.getDescription());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_name());
        assertNotNull(result1.getEmail());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getPatient_name());
        assertNotNull(result1.getPosteddate());

        //Check whether the values returned are same
        assertEquals("22/03/2017",result1.getPosteddate());
        assertEquals("Messi",result1.getPatient_name());
        assertEquals("10",result1.getPatient_id());
        assertEquals("Messi@gmail.com",result1.getEmail());
        assertEquals("Lionel",result1.getDoctor_name());
        assertEquals("24",result1.getDoctor_id());
        assertEquals("Description",result1.getDescription());

        //Check for Null value assertion
        assertNotNull(result2);
        assertNotNull(result2.getDescription());
        assertNotNull(result2.getDoctor_id());
        assertNotNull(result2.getDoctor_name());
        assertNotNull(result2.getEmail());
        assertNotNull(result2.getPatient_id());
        assertNotNull(result2.getPatient_name());
        assertNotNull(result2.getPosteddate());

        //Check whether the values returned are same
        assertEquals("11/03/2017",result2.getPosteddate());
        assertEquals("Mbappe",result2.getPatient_name());
        assertEquals("11",result2.getPatient_id());
        assertEquals("Mbappe@psg.com",result2.getEmail());
        assertEquals("Kylian",result2.getDoctor_name());
        assertEquals("25",result2.getDoctor_id());
        assertEquals("Description",result2.getDescription());

    }

    @Test
    public void testAddFeedback() throws SQLException {

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
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Mocking Execution of query
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockPreparedStatement).setString(Mockito.anyInt(), Mockito.anyString());

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        feedbackDAO.addFeedback(mockFeedback);
    }

    @Test
    public void testUpdateFeedback() throws SQLException {

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
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Mocking Execution of query
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockPreparedStatement).setString(Mockito.anyInt(), Mockito.anyString());

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        feedbackDAO.updateFeedback(mockFeedback);
    }

    @Test
    public void testDeleteFeedback() throws SQLException {

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
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Mocking Execution of query
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        Mockito.doNothing().when(mockPreparedStatement).setString(Mockito.anyInt(), Mockito.anyString());

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        feedbackDAO.deleteFeedback("10");
    }


}
