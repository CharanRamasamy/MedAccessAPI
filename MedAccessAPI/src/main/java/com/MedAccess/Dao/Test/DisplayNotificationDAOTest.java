/*
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

import com.MedAccess.Dao.DisplayNotificationDAO;
import com.MedAccess.Dao.DoctorDAO;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.DoctorNotification;


@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({DisplayNotificationDAOTest.class, DisplayNotificationDAO.class})
public class DisplayNotificationDAOTest {
	
	
	@Mock
    private DataSource mockDataSource;

    @Mock
    Logger logger;

    @InjectMocks
    private DisplayNotificationDAO displayNotificationDAO;
	
	
	
	@Test
    public void testGetDoctorAppointment() throws SQLException {

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
        Mockito.when(resultSet.getString("appointment_id")).thenReturn("21").thenReturn("20");
        Mockito.when(resultSet.getString("patient_id")).thenReturn("31").thenReturn("31");
        Mockito.when(resultSet.getString("patient_firstname")).thenReturn("Vidhyashree").thenReturn("Vidhyashree").thenReturn("Vidhyashree").thenReturn("Vidhyashree");
        Mockito.when(resultSet.getString("patient_phone")).thenReturn("vidhyashree1992@gmail.com").thenReturn("vidhyashree1992@gmail.com");
        Mockito.when(resultSet.getString("app_date")).thenReturn("2018-07-26").thenReturn("2018-07-26");
        Mockito.when(resultSet.getString("app_time")).thenReturn("7pm").thenReturn("7pm");
        
        
        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<DoctorNotification> resultList = displayNotificationDAO.getDoctorAppointment("1");
        DoctorNotification result1 = resultList.get(0);
      //  DoctorNotification result2 = resultList.get(1);

        //NotNull assertion for Doctor1
        assertNotNull(result1);
		assertNotNull(result1.getAppointment_id());
		assertNotNull(result1.getPatient_id());
		assertNotNull(result1.getPatient_firstname());
		assertNotNull(result1.getPatient_phone());
		assertNotNull(result1.getApp_date());
		assertNotNull(result1.getApp_time());
		
		
		
        //Equal assertion of Input and Output for Doctor1
		assertEquals(result1.getAppointment_id(),result1.getAppointment_id());
		assertEquals(result1.getPatient_id(),result1.getPatient_id());
		assertEquals(result1.getPatient_firstname(),result1.getPatient_firstname());
		assertEquals(result1.getPatient_phone(),result1.getPatient_phone());
		assertEquals(result1.getApp_date(),result1.getApp_date());
		assertEquals(result1.getApp_time(),result1.getApp_time());
		
		
        
        //NotNull assertion for Doctor1
//		assertNotNull(result2);
//		assertNotNull(result2.getAppointment_id());
//		assertNotNull(result2.getPatient_id());
//		assertNotNull(result2.getPatient_firstname());
//		assertNotNull(result2.getPatient_phone());
//		assertNotNull(result2.getApp_date());
//		assertNotNull(result2.getApp_time());
//		
//		
//		
//		//Equal assertion of Input and Output
//		assertEquals(result2.getAppointment_id(),result2.getAppointment_id());
//		assertEquals(result2.getPatient_id(),result2.getPatient_id());
//		assertEquals(result2.getPatient_firstname(),result2.getPatient_firstname());
//		assertEquals(result2.getPatient_phone(),result2.getPatient_phone());
//		assertEquals(result2.getApp_date(),result2.getApp_date());
//		assertEquals(result2.getApp_time(),result2.getApp_time());
		
		

    }

}
*/
