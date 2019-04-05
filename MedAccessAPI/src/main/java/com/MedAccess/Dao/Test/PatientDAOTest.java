package com.MedAccess.Dao.Test;

import com.MedAccess.Dao.PatientDAO;
import com.MedAccess.Models.Patient;
import com.MedAccess.service.PatientService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({PatientDAOTest.class, PatientDAO.class})
public class PatientDAOTest {
    @Mock
    private DataSource mockDataSource;

    @Mock
    Logger logger;

    @InjectMocks
    private PatientDAO patientDAO;

    @Test
    public void testGetPatientById() throws SQLException {

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
        Mockito.when(resultSet.getString("patient_id")).thenReturn("10");
        Mockito.when(resultSet.getString("patient_city")).thenReturn("Halifax");
        Mockito.when(resultSet.getString("patient_country")).thenReturn("Canada");
        Mockito.when(resultSet.getString("patient_email")).thenReturn("Messi@gmail.com");
        Mockito.when(resultSet.getString("patient_firstname")).thenReturn("Lionel");
        Mockito.when(resultSet.getString("patient_lastname")).thenReturn("Messi");
        Mockito.when(resultSet.getString("patient_password")).thenReturn("Tiago@Barca!");
        Mockito.when(resultSet.getString("patient_phone")).thenReturn("19029993456");
        Mockito.when(resultSet.getString("patient_state")).thenReturn("NS");
        Mockito.when(resultSet.getString("patient_street")).thenReturn("South park st");
        Mockito.when(resultSet.getString("patient_suite")).thenReturn("444");
        Mockito.when(resultSet.getString("patient_zip")).thenReturn("B3J 2K5");

        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        Patient result1 = patientDAO.getPatientById("10");

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
        assertEquals("Halifax",result1.getPatient_city());
        assertEquals("10",result1.getPatient_id());
        assertEquals("Canada",result1.getPatient_country());
        assertEquals("Messi@gmail.com",result1.getPatient_email());
        assertEquals("Lionel",result1.getPatient_firstname());
        assertEquals("Messi",result1.getPatient_lastname());
        assertEquals("Tiago@Barca!",result1.getPatient_password());
        assertEquals("19029993456",result1.getPatient_phone());
        assertEquals("NS",result1.getPatient_state());
        assertEquals("South park st",result1.getPatient_street());
        assertEquals("444",result1.getPatient_suite());
        assertEquals("B3J 2K5",result1.getPatient_zip());

    }

    @Test
    public void testGetPatientByMail() throws SQLException {

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
        Mockito.when(resultSet.getString("patient_id")).thenReturn("10");
        Mockito.when(resultSet.getString("patient_city")).thenReturn("Halifax");
        Mockito.when(resultSet.getString("patient_country")).thenReturn("Canada");
        Mockito.when(resultSet.getString("patient_email")).thenReturn("Messi@gmail.com");
        Mockito.when(resultSet.getString("patient_firstname")).thenReturn("Lionel");
        Mockito.when(resultSet.getString("patient_lastname")).thenReturn("Messi");
        Mockito.when(resultSet.getString("patient_password")).thenReturn("Tiago@Barca!");
        Mockito.when(resultSet.getString("patient_phone")).thenReturn("19029993456");
        Mockito.when(resultSet.getString("patient_state")).thenReturn("NS");
        Mockito.when(resultSet.getString("patient_street")).thenReturn("South park st");
        Mockito.when(resultSet.getString("patient_suite")).thenReturn("444");
        Mockito.when(resultSet.getString("patient_zip")).thenReturn("B3J 2K5");

        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        Patient result1 = patientDAO.getPatientByMail("Messi@gmail.com");

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
        assertEquals("Halifax",result1.getPatient_city());
        assertEquals("10",result1.getPatient_id());
        assertEquals("Canada",result1.getPatient_country());
        assertEquals("Messi@gmail.com",result1.getPatient_email());
        assertEquals("Lionel",result1.getPatient_firstname());
        assertEquals("Messi",result1.getPatient_lastname());
        assertEquals("Tiago@Barca!",result1.getPatient_password());
        assertEquals("19029993456",result1.getPatient_phone());
        assertEquals("NS",result1.getPatient_state());
        assertEquals("South park st",result1.getPatient_street());
        assertEquals("444",result1.getPatient_suite());
        assertEquals("B3J 2K5",result1.getPatient_zip());

    }

    @Test
    public void testGetAllPatients() throws SQLException {

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
        Mockito.when(resultSet.getString("patient_city")).thenReturn("Halifax").thenReturn("Toronto");
        Mockito.when(resultSet.getString("patient_country")).thenReturn("Canada").thenReturn("Canada");
        Mockito.when(resultSet.getString("patient_email")).thenReturn("Messi@gmail.com").thenReturn("Mbappe@yahoo.in");
        Mockito.when(resultSet.getString("patient_firstname")).thenReturn("Lionel").thenReturn("Kylian");
        Mockito.when(resultSet.getString("patient_lastname")).thenReturn("Messi").thenReturn("Mbappe");
        Mockito.when(resultSet.getString("patient_password")).thenReturn("Tiago@Barca!").thenReturn("Kylian@Psg!");
        Mockito.when(resultSet.getString("patient_phone")).thenReturn("19029993456").thenReturn("19065647876");
        Mockito.when(resultSet.getString("patient_state")).thenReturn("NS").thenReturn("ON");
        Mockito.when(resultSet.getString("patient_street")).thenReturn("South park st").thenReturn("North st");
        Mockito.when(resultSet.getString("patient_suite")).thenReturn("444").thenReturn("704");
        Mockito.when(resultSet.getString("patient_zip")).thenReturn("B3J 2K5").thenReturn("B3Y 2KY");

        //Mocking Statement call
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(resultSet);

        //Mocking resultset.next()
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        //Mocking Closing connection
        Mockito.doNothing().when(mockConnection).close();

        //Method call
        List<Patient> resultList = patientDAO.getAllPatients();
        Patient result1 = resultList.get(0);
        Patient result2 = resultList.get(1);

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
        assertEquals("Halifax",result1.getPatient_city());
        assertEquals("10",result1.getPatient_id());
        assertEquals("Canada",result1.getPatient_country());
        assertEquals("Messi@gmail.com",result1.getPatient_email());
        assertEquals("Lionel",result1.getPatient_firstname());
        assertEquals("Messi",result1.getPatient_lastname());
        assertEquals("Tiago@Barca!",result1.getPatient_password());
        assertEquals("19029993456",result1.getPatient_phone());
        assertEquals("NS",result1.getPatient_state());
        assertEquals("South park st",result1.getPatient_street());
        assertEquals("444",result1.getPatient_suite());
        assertEquals("B3J 2K5",result1.getPatient_zip());

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
        assertEquals("Toronto",result2.getPatient_city());
        assertEquals("11",result2.getPatient_id());
        assertEquals("Canada",result2.getPatient_country());
        assertEquals("Mbappe@yahoo.in",result2.getPatient_email());
        assertEquals("Kylian",result2.getPatient_firstname());
        assertEquals("Mbappe",result2.getPatient_lastname());
        assertEquals("Kylian@Psg!",result2.getPatient_password());
        assertEquals("19065647876",result2.getPatient_phone());
        assertEquals("ON",result2.getPatient_state());
        assertEquals("North st",result2.getPatient_street());
        assertEquals("704",result2.getPatient_suite());
        assertEquals("B3Y 2KY",result2.getPatient_zip());

    }

    @Test
    public void testAddPatient() throws SQLException {

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

        patientDAO.addPatient(mockPatient1);
    }

    @Test
    public void testUpdatePatient() throws SQLException {

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

        patientDAO.updatePatient(mockPatient1);
    }

    @Test
    public void testDeletePatient() throws SQLException {

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

        patientDAO.deletePatient("10");
    }


}
