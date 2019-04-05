package com.MedAccess.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.DoctorNotification;


@Transactional
@Repository
@ImportResource("classpath:dbconfig.xml")
public class DisplayNotificationDAO implements IDisplayNotificationDAO{
	
	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
final static Logger logger = Logger.getLogger(DoctorDAO.class);
	

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<DoctorNotification> getDoctorAppointment(String doctor_id) {
		
		List<DoctorNotification> list = new ArrayList<DoctorNotification>();
		
		String query="SELECT appointment_id, doctor_id, patient_id, app_date, app_time FROM Appointment WHERE doctor_id = ?";
	    String query1="SELECT patient_id, patient_firstname, patient_lastname, patient_password, patient_email, patient_phone, patient_suite, patient_street, patient_city, patient_state, patient_country, patient_zip FROM Patient WHERE patient_id = ?";
		
		try {
			
			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "DisplayNotificationDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DisplayNotificationDAO - Connected to the database");
    		
			//logger.info("Connected to the database");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1,doctor_id);
			
			ResultSet resultSet=statement.executeQuery();
			
			DoctorNotification appointment = new DoctorNotification();
			
			
			while ( resultSet.next() ) {
				
				
				// Read the next item
				appointment.setAppointment_id(resultSet.getString("appointment_id"));
				appointment.setPatient_id(resultSet.getString("patient_id"));
				
				PreparedStatement statement1=connection.prepareStatement(query1);
				statement1.setString(1,resultSet.getString("patient_id"));
				ResultSet resultSet1=statement1.executeQuery();
				
				while(resultSet1.next()){
					
				appointment.setPatient_firstname(resultSet1.getString("patient_firstname"));
				appointment.setPatient_phone(resultSet1.getString("patient_phone"));
				
				}
				
				appointment.setApp_date(resultSet.getString("app_date"));
				appointment.setApp_time(resultSet.getString("app_time"));
				
				
				list.add(new DoctorNotification(resultSet.getString("appointment_id"),resultSet.getString("patient_id"), appointment.getPatient_firstname(), appointment.getPatient_phone(), resultSet.getString("app_date"), resultSet.getString("app_time")));
				
				
				
		}
			
			loggerChain.logMessage(AbstractLogger.INFO, "DisplayNotificationDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DisplayNotificationDAO - 1 record retrieved from the database");
    		
			//logger.info("1 record retrieved from the database");
			connection.close();

			return list;
		}
		
		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
    		
			logger.info("SQLException handled - details " + e);

		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
    		
			logger.info("Exception handled - details " + e);
		}

		return null;
		
		
	}

}
