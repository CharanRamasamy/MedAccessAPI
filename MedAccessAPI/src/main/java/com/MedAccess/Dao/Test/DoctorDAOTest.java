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

import com.MedAccess.Dao.DoctorDAO;
import com.MedAccess.Models.Doctor;



@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({DoctorDAOTest.class, DoctorDAO.class})
public class DoctorDAOTest 
{

	@Mock
    private DataSource mockDataSource;

    @Mock
    Logger logger;

    @InjectMocks
    private DoctorDAO doctorDAO;
    
    @Test
    public void testGetDoctorById() throws SQLException {

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
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("2");
        Mockito.when(resultSet.getString("doctor_city")).thenReturn("HALIFAX");
        Mockito.when(resultSet.getString("doctor_country")).thenReturn("Canada");
        Mockito.when(resultSet.getString("doctor_email")).thenReturn("vidhyashree1992@gmail.com");
        Mockito.when(resultSet.getString("doctor_firstname")).thenReturn("VIDHYASHREE");
        Mockito.when(resultSet.getString("doctor_lastname")).thenReturn("BOOPATHY");
        Mockito.when(resultSet.getString("doctor_password")).thenReturn("vidhu@123");
        Mockito.when(resultSet.getString("doctor_phone")).thenReturn("9024129698");
        Mockito.when(resultSet.getString("doctor_state")).thenReturn("Nova Scotia");
        Mockito.when(resultSet.getString("doctor_street")).thenReturn("110");
        Mockito.when(resultSet.getString("doctor_suite")).thenReturn("123");
        Mockito.when(resultSet.getString("doctor_zip")).thenReturn("B3L4R1");
        Mockito.when(resultSet.getString("doctor_reg_id")).thenReturn("1234");
        Mockito.when(resultSet.getString("doctor_speciality")).thenReturn("apollo");
        

        
      //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        Doctor result1 = doctorDAO.getDoctorById("2");
        
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
        assertEquals("HALIFAX",result1.getDoctor_city());
        assertEquals("2",result1.getDoctor_id());
        assertEquals("Canada",result1.getDoctor_country());
        assertEquals("vidhyashree1992@gmail.com",result1.getDoctor_email());
        assertEquals("VIDHYASHREE",result1.getDoctor_firstname());
        assertEquals("BOOPATHY",result1.getDoctor_lastname());
        assertEquals("vidhu@123",result1.getDoctor_password());
        assertEquals("9024129698",result1.getDoctor_phone());
        assertEquals("Nova Scotia",result1.getDoctor_state());
        assertEquals("110",result1.getDoctor_street());
        assertEquals("123",result1.getDoctor_suite());
        assertEquals("B3L4R1",result1.getDoctor_zip());
        assertEquals("1234",result1.getDoctor_reg_id());
		assertEquals("apollo",result1.getDoctor_speciality());
		
    }
    
    @Test
    public void testGetDoctorByMail() throws SQLException {

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
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("2");
        Mockito.when(resultSet.getString("doctor_city")).thenReturn("HALIFAX");
        Mockito.when(resultSet.getString("doctor_country")).thenReturn("Canada");
        Mockito.when(resultSet.getString("doctor_email")).thenReturn("vidhyashree1992@gmail.com");
        Mockito.when(resultSet.getString("doctor_firstname")).thenReturn("VIDHYASHREE");
        Mockito.when(resultSet.getString("doctor_lastname")).thenReturn("BOOPATHY");
        Mockito.when(resultSet.getString("doctor_password")).thenReturn("vidhu@123");
        Mockito.when(resultSet.getString("doctor_phone")).thenReturn("9024129698");
        Mockito.when(resultSet.getString("doctor_state")).thenReturn("Nova Scotia");
        Mockito.when(resultSet.getString("doctor_street")).thenReturn("110");
        Mockito.when(resultSet.getString("doctor_suite")).thenReturn("123");
        Mockito.when(resultSet.getString("doctor_zip")).thenReturn("B3L4R1");
        Mockito.when(resultSet.getString("doctor_reg_id")).thenReturn("1234");
        Mockito.when(resultSet.getString("doctor_speciality")).thenReturn("apollo");
        

        
        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        Doctor result1 = doctorDAO.getDoctorByMail("vidhyashree1992@gmail.com");

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
		assertEquals("HALIFAX",result1.getDoctor_city());
        assertEquals("2",result1.getDoctor_id());
        assertEquals("Canada",result1.getDoctor_country());
        assertEquals("vidhyashree1992@gmail.com",result1.getDoctor_email());
        assertEquals("VIDHYASHREE",result1.getDoctor_firstname());
        assertEquals("BOOPATHY",result1.getDoctor_lastname());
        assertEquals("vidhu@123",result1.getDoctor_password());
        assertEquals("9024129698",result1.getDoctor_phone());
        assertEquals("Nova Scotia",result1.getDoctor_state());
        assertEquals("110",result1.getDoctor_street());
        assertEquals("123",result1.getDoctor_suite());
        assertEquals("B3L4R1",result1.getDoctor_zip());
        assertEquals("1234",result1.getDoctor_reg_id());
		assertEquals("apollo",result1.getDoctor_speciality());
		
    }
    
    
   /* @Test
    public void testGetAllDoctors() throws SQLException {

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
        Mockito.when(resultSet.getString("doctor_id")).thenReturn("2").thenReturn("1");
        Mockito.when(resultSet.getString("doctor_city")).thenReturn("Halifax").thenReturn("Toronto");
        Mockito.when(resultSet.getString("doctor_country")).thenReturn("Canada").thenReturn("Canada");
        Mockito.when(resultSet.getString("doctor_email")).thenReturn("Messi@gmail.com").thenReturn("Mbappe@yahoo.in");
        Mockito.when(resultSet.getString("doctor_firstname")).thenReturn("Lionel").thenReturn("Kylian");
        Mockito.when(resultSet.getString("doctor_lastname")).thenReturn("Messi").thenReturn("Mbappe");
        Mockito.when(resultSet.getString("doctor_password")).thenReturn("Tiago@Barca!").thenReturn("Kylian@Psg!");
        Mockito.when(resultSet.getString("doctor_phone")).thenReturn("19029993456").thenReturn("19065647876");
        Mockito.when(resultSet.getString("doctor_state")).thenReturn("NS").thenReturn("ON");
        Mockito.when(resultSet.getString("doctor_street")).thenReturn("South park st").thenReturn("North st");
        Mockito.when(resultSet.getString("doctor_suite")).thenReturn("444").thenReturn("704");
        Mockito.when(resultSet.getString("doctor_zip")).thenReturn("B3J 2K5").thenReturn("B3Y 2KY");
        Mockito.when(resultSet.getString("doctor_reg_id")).thenReturn("1234").thenReturn("2324");
        Mockito.when(resultSet.getString("doctor_speciality")).thenReturn("apollo").thenReturn("cardio");
        
        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<Doctor> resultList = doctorDAO.getAllDoctors();
        Doctor result1 = resultList.get(0);
        Doctor result2 = resultList.get(1);

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
        assertEquals("Halifax",result1.getDoctor_city());
        assertEquals("2",result1.getDoctor_id());
        assertEquals("Canada",result1.getDoctor_country());
        assertEquals("Messi@gmail.com",result1.getDoctor_email());
        assertEquals("Lionel",result1.getDoctor_firstname());
        assertEquals("Messi",result1.getDoctor_lastname());
        assertEquals("Tiago@Barca!",result1.getDoctor_password());
        assertEquals("19029993456",result1.getDoctor_phone());
        assertEquals("NS",result1.getDoctor_state());
        assertEquals("South park st",result1.getDoctor_street());
        assertEquals("444",result1.getDoctor_suite());
        assertEquals("B3J 2K5",result1.getDoctor_zip());
        assertEquals("1234",result1.getDoctor_reg_id());
		assertEquals("apollo",result1.getDoctor_speciality());

        //NotNull assertion for Doctor1
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
        

        //Equal assertion of Input and Output for Doctor1
        assertEquals("Toronto",result2.getDoctor_city());
        assertEquals("1",result2.getDoctor_id());
        assertEquals("Canada",result2.getDoctor_country());
        assertEquals("Mbappe@yahoo.in",result2.getDoctor_email());
        assertEquals("Kylian",result2.getDoctor_firstname());
        assertEquals("Mbappe",result2.getDoctor_lastname());
        assertEquals("Kylian@Psg!",result2.getDoctor_password());
        assertEquals("19065647876",result2.getDoctor_phone());
        assertEquals("ON",result2.getDoctor_state());
        assertEquals("North st",result2.getDoctor_street());
        assertEquals("704",result2.getDoctor_suite());
        assertEquals("B3Y 2KY",result2.getDoctor_zip());
        assertEquals("1234",result1.getDoctor_reg_id());
		assertEquals("apollo",result1.getDoctor_speciality());

    }*/
    
    @Test
    public void testAddDoctor() throws SQLException {

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

        doctorDAO.addDoctor(mockDoctor);
        
    }
    
    @Test
    public void testUpdateDoctor() throws SQLException {

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

        doctorDAO.updateDoctor(mockDoctor);
    }
    
    @Test
    public void testDeleteDoctor() throws SQLException {

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

        doctorDAO.deleteDoctor("2");
    }



}
