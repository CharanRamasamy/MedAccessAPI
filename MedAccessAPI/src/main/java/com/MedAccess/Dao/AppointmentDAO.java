package com.MedAccess.Dao;

import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Patient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Repository
@ImportResource("classpath:dbconfig.xml")
public class AppointmentDAO implements IAppointmentDAO {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
    final static Logger logger = Logger.getLogger(AppointmentDAO.class);

    @Autowired
    DataSource dataSource;


    @Override
    public List<Appointment> getAllAppointments() {
        // TODO Auto-generated method stub
        return null;

    }

    @Override
    public Appointment getAppointmentByID(String appointmentId) {
        String query = "CALL spgetAppointmentById(?)";

        try {

            Connection connection = dataSource.getConnection();
            
            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - Connected to the database");
    		
            //logger.info("Connected to the database");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, appointmentId);

            ResultSet resultSet = statement.executeQuery();
            Appointment appointment = new Appointment();


            while (resultSet.next()) {

                appointment.setAppointment_id(resultSet.getString("appointment_id"));
                appointment.setDoctor_id(resultSet.getString("doctor_id"));
                appointment.setPatient_id(resultSet.getString("patient_id"));
                appointment.setApp_date(resultSet.getString("app_date"));
                appointment.setApp_time(resultSet.getString("app_time"));
            }

            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - 1 record retrieved from the database");
    		

            //logger.info("1 record retrieved from the database");
            connection.close();

            return appointment;

        } catch (SQLException e) {
        	
        	loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
    		
           // logger.info("SQLException handled - details " + e);

        } catch (Exception e) {
        	
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details ");
    		
           // logger.info("Exception handled - details " + e);
        }

        return null;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        String query = "CALL spInsertAppointment(?,?,?,?)";

        Connection connection;

        try {
            connection = dataSource.getConnection();
            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - Connection done!");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - Connection done!");
    		
            logger.info("Connection done!");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, appointment.getDoctor_id());
            statement.setString(2, appointment.getPatient_id());
            statement.setString(3, appointment.getApp_date());
            statement.setString(4, appointment.getApp_time());

            int num = statement.executeUpdate();
            logger.info(num + " record(s) inserted into Appointment table");
            logger.info(num + " Connection closed");
            
            connection.close();
        } catch (SQLException e) {
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details ");
    		
            //logger.info("SQLException handled - details " + e);
        } catch (Exception e) {
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details ");
    		
            //logger.info("Exception handled - details " + e);
        }
    }

    @Override
    public void deleteAppointment(String appointmentID) {

        String query = "CALL spDeleteAppointment(?)";

        Connection connection;
        try {
            connection = dataSource.getConnection();
            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - Connection done!");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - Connection done!");
    		
            //logger.info("Connection done!");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, appointmentID);

            int num = statement.executeUpdate();
            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - record(s) deleted in the Patient table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - record(s) deleted in the Patient table");
    		
            //logger.info(num + " record(s) deleted in the Patient table");
        } catch (SQLException e) {
        	loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details  ");
    		
            //logger.info("SQLException handled - details " + e);
        } catch (Exception e) {
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details ");
    		
            //logger.info("Exception handled - details " + e);
        }

    }

    @Override
    public Doctor getDoctorById(String doctorId) {
        return null;
    }

    @Override
    public Patient getPatientById(String patientID) {
        return null;
    }

    @Override
    public List<Appointment> getAppointmentbypatientId(String patientID) {

        List<Appointment> list = new ArrayList<Appointment>();

        String query="SELECT appointment_id, doctor_id, patient_id, app_date, app_time FROM Appointment WHERE patient_id = ?";
        String querydoc = "SELECT doctor_id, doctor_firstname, doctor_lastname, doctor_password, doctor_email, doctor_phone, doctor_suite, doctor_street, doctor_city, doctor_state, doctor_country, doctor_zip, doctor_reg_id, doctor_speciality FROM Doctor WHERE doctor_id = ?";

        try {

            Connection connection = dataSource.getConnection();
            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - Connected to the database");
    		
            //logger.info("Connected to the database");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,patientID);

            ResultSet resultSet=statement.executeQuery();

            Appointment appointment = new Appointment();


            while ( resultSet.next() ) {


                // Read the next item
                //appointment.setAppointment_id(resultSet.getString("appointment_id"));
                appointment.setPatient_id(resultSet.getString("patient_id"));
                appointment.setAppointment_id(resultSet.getString("appointment_id"));

                PreparedStatement statement1=connection.prepareStatement(querydoc);
                statement1.setString(1,resultSet.getString("doctor_id"));
                ResultSet resultSet1=statement1.executeQuery();

                while(resultSet1.next()){

                	loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - inside nested while");
            		
                    appointment.setDoctor_firstname(resultSet1.getString("doctor_firstname"));
                    appointment.setDoctor_phone(resultSet1.getString("doctor_phone"));


                }

                appointment.setApp_date(resultSet.getString("app_date"));
                appointment.setApp_time(resultSet.getString("app_time"));


                list.add(new Appointment(resultSet.getString("appointment_id"),resultSet.getString("patient_id"), appointment.getDoctor_firstname(), resultSet.getString("app_date"), resultSet.getString("app_time"), appointment.getDoctor_phone()));



            }

            loggerChain.logMessage(AbstractLogger.INFO, "AppointmentDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "AppointmentDAO - 1 record retrieved from the database");
    		
            //logger.info("1 record retrieved from the database");
            connection.close();

            return list;
        }

        catch (SQLException e) {
        	loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details ");
    		
            //logger.info("SQLException handled - details " + e);

        }
        catch (Exception e){
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details ");
    		
            //logger.info("Exception handled - details " + e);
        }

        return null;
    }


}
