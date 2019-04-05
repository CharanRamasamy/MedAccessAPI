package com.MedAccess.Dao.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.MedAccess.Dao.AppointmentDAO;
import com.MedAccess.Dao.DoctorDAO;
import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({AppointmentDAOTest.class, AppointmentDAO.class})
public class AppointmentDAOTest {
	
	@Mock
    private DataSource mockDataSource;

    @Mock
    Logger logger;

    @InjectMocks
    private AppointmentDAO appointmentDAO;
    
    @Test
    public void testGetAppointmentById() throws SQLException {

        //Mockito to mock the control from going to service class
        //Mocking Connection call
        Connection mockConnection = Mockito.mock(Connection.class);
        Mockito.doReturn(mockConnection).when(mockDataSource).getConnection();

        //Mocking PreparedStatement call
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(mockPreparedStatement).when(mockConnection).prepareStatement(Mockito.anyString());

        //Logger mocks

        Mockito.doNothing().when(logger).info(Mockito.any());

        
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        
        
        Mockito.when(resultSet.getString("app_date")).thenReturn("06/06/2018");
        Mockito.when(resultSet.getString("app_time")).thenReturn("1200");
        Mockito.when(resultSet.getString("appointment_id")).thenReturn("21");
        Mockito.when(resultSet.getString("patient_id")).thenReturn("2");
      //  Mockito.when(resultSet.getString("doctor_firstname")).thenReturn("Leo");
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("45");
      //  Mockito.when(resultSet.getString("doctor_phone")).thenReturn("19028765675");
        

        
      //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        Appointment result1 = appointmentDAO.getAppointmentByID("21");
        
      //NotNull assertion for Doctor1
        assertNotNull(result1);
        assertNotNull(result1.getApp_date());
        assertNotNull(result1.getApp_time());
        assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getAppointment_id());


        //Equal assertion of Input and Output for Doctor1
        assertEquals(result1.getApp_date(),"06/06/2018");
        assertEquals(result1.getApp_time(),"1200");
        assertEquals(result1.getDoctor_id(),"45");
        assertEquals(result1.getPatient_id(),"2");
        assertEquals(result1.getAppointment_id(),"21");

		
    }
    
    
    @Test
    public void testAddAppointment() throws SQLException {

        //mocking Doctor response
    	Appointment mockAppointment = new Appointment();
        
    	mockAppointment.setApp_date("06/06/2018");
        mockAppointment.setApp_time("1200");
        mockAppointment.setAppointment_id("21");
        mockAppointment.setPatient_id("2");
        mockAppointment.setDoctor_firstname("Leo");
        mockAppointment.setDoctor_id("45");
        mockAppointment.setDoctor_phone("19028765675");

		
		
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

        appointmentDAO.addAppointment(mockAppointment);
        
    }
    
    
    @Test
    public void testDeleteAppointment() throws SQLException {

        //mocking Doctor response
    	Appointment mockAppointment = new Appointment();
		
		
    	mockAppointment.setApp_date("06/06/2018");
        mockAppointment.setApp_time("1200");
        mockAppointment.setAppointment_id("21");
        mockAppointment.setPatient_id("2");
        mockAppointment.setDoctor_firstname("Leo");
        mockAppointment.setDoctor_id("45");
        mockAppointment.setDoctor_phone("19028765675");
		

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

        appointmentDAO.deleteAppointment("21");
        
    }
    
    
    /*@Test
    public void testGetAppointmentByPatientId() throws SQLException {

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
        
        
        Mockito.when(resultSet.getString("app_date")).thenReturn("06/06/2018").thenReturn("05/06/2018");
        Mockito.when(resultSet.getString("app_time")).thenReturn("1200").thenReturn("1100");
        Mockito.when(resultSet.getString("appointment_id")).thenReturn("21").thenReturn("21");
        Mockito.when(resultSet.getString("patient_id")).thenReturn("2").thenReturn("1");
        Mockito.when(resultSet.getString("doctor_firstname")).thenReturn("Leo").thenReturn("Vidhya");
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("45").thenReturn("35");
        Mockito.when(resultSet.getString("doctor_phone")).thenReturn("19028765675").thenReturn("19028765674");
        
        
        
        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<Appointment> resultList = appointmentDAO.getAppointmentbypatientId("21");
        Appointment result1 = resultList.get(0);
       // Appointment result2 = resultList.get(1);

        
        //NotNull assertion for Doctor1
        assertNotNull(result1);
        assertNotNull(result1.getApp_date());
        assertNotNull(result1.getApp_time());
        assertNotNull(result1.getDoctor_firstname());
       // assertNotNull(result1.getDoctor_id());
        assertNotNull(result1.getDoctor_phone());
        assertNotNull(result1.getPatient_id());
        assertNotNull(result1.getAppointment_id());

        
        //Equal assertion of Input and Output for Doctor1
        assertEquals(result1.getApp_date(),"05/06/2018");
        assertEquals(result1.getApp_time(),"1100");
        assertEquals(result1.getDoctor_firstname(),"Leo");
       // assertEquals(result1.getDoctor_id(),"45");
        assertEquals(result1.getDoctor_phone(),"19028765675");
        assertEquals(result1.getPatient_id(),"1");
        assertEquals(result1.getAppointment_id(),"21");


//        //NotNull assertion for Doctor1
//        assertNotNull(result2);
//        assertNotNull(result2.getApp_date());
//        assertNotNull(result2.getApp_time());
//        assertNotNull(result2.getDoctor_firstname());
//        assertNotNull(result2.getDoctor_id());
//        assertNotNull(result2.getDoctor_phone());
//        assertNotNull(result2.getPatient_id());
//        assertNotNull(result2.getAppointment_id());
//
//        
//        //Equal assertion of Input and Output for Doctor1
//        assertEquals(result2.getApp_date(),"05/06/2018");
//        assertEquals(result2.getApp_time(),"1100");
//        assertEquals(result2.getDoctor_firstname(),"Vidhya");
//        assertEquals(result2.getDoctor_id(),"35");
//        assertEquals(result2.getDoctor_phone(),"19028765674");
//        assertEquals(result2.getPatient_id(),"1");
//        assertEquals(result2.getAppointment_id(),"11");
        

    }*/


}
