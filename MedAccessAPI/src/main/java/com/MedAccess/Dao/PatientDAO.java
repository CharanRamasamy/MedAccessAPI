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
import com.MedAccess.Models.Patient;

@Transactional
@Repository
@ImportResource("classpath:dbconfig.xml")
public class PatientDAO implements IPatientDAO {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(PatientDAO.class);

	@Autowired
	DataSource dataSource;

	@Override
	public Patient getPatientById(String patient_id) {
		String query= "CALL spgetPatientById(?)";
		/*RowMapper<Patient> rowMapper = new BeanPropertyRowMapper<Patient>(Patient.class);*/


		try {
			Connection connection = dataSource.getConnection();
			
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connected to the database");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1,patient_id);


			ResultSet resultSet=statement.executeQuery();
			Patient patient = new Patient();

			while ( resultSet.next() ) {
				// Read the next item
				patient.setPatient_id(resultSet.getString("patient_id"));
				patient.setPatient_firstname(resultSet.getString("patient_firstname"));
				patient.setPatient_lastname(resultSet.getString("patient_lastname"));
				patient.setPatient_password(resultSet.getString("patient_password"));
				patient.setPatient_email(resultSet.getString("patient_email"));
				patient.setPatient_phone(resultSet.getString("patient_phone"));
				patient.setPatient_suite(resultSet.getString("patient_suite"));
				patient.setPatient_street(resultSet.getString("patient_street"));
				patient.setPatient_city(resultSet.getString("patient_city"));
				patient.setPatient_state(resultSet.getString("patient_state"));
				patient.setPatient_country(resultSet.getString("patient_country"));
				patient.setPatient_zip(resultSet.getString("patient_zip"));

			}


			//while(resultSet.next()){
			//	System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			//}


			System.out.println("1 record(s) retrieved from the database");
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - 1 record retrieved from the database");
    		
			//logger.info("1 record retrieved from the database");
			connection.close();

			return patient;

		}



		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);

		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

		return null;
	}

	
	@Override
	public Patient getPatientByMail(String patient_email) {
		String query= "CALL spgetPatientByMail(?)";
		String email = patient_email.replaceAll(",",".");

		try {
			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connected to the database");
			logger.info(patient_email);
			logger.info(email+"---------");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1,email);

			ResultSet resultSet=statement.executeQuery();
			Patient patient = new Patient();

			while ( resultSet.next() ) {
				// Read the next item
				patient.setPatient_id(resultSet.getString("patient_id"));
				patient.setPatient_firstname(resultSet.getString("patient_firstname"));
				patient.setPatient_lastname(resultSet.getString("patient_lastname"));
				patient.setPatient_password(resultSet.getString("patient_password"));
				patient.setPatient_email(resultSet.getString("patient_email"));
				patient.setPatient_phone(resultSet.getString("patient_phone"));
				patient.setPatient_suite(resultSet.getString("patient_suite"));
				patient.setPatient_street(resultSet.getString("patient_street"));
				patient.setPatient_city(resultSet.getString("patient_city"));
				patient.setPatient_state(resultSet.getString("patient_state"));
				patient.setPatient_country(resultSet.getString("patient_country"));
				patient.setPatient_zip(resultSet.getString("patient_zip"));

			}


			//while(resultSet.next()){
			//	System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			//}


			System.out.println("1 record(s) retrieved from the database");
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - 1 record retrieved from the database");
    		
			//logger.info("1 record retrieved from the database");
			connection.close();

			return patient;

		}



		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);

		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

		return null;
	}
	
	
	@Override
	public List<Patient> getAllPatients() {

		List<Patient> list = new ArrayList<Patient>();

		String query= "CALL spgetAllPatients()";
		/*RowMapper<Patient> rowMapper = new BeanPropertyRowMapper<Patient>(Patient.class);*/


		try {
			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet resultSet=statement.executeQuery();

			while(resultSet.next()){

				list.add(new Patient(resultSet.getString("patient_id"),resultSet.getString("patient_firstname"), resultSet.getString("patient_lastname"),resultSet.getString("patient_password"),resultSet.getString("patient_email"),resultSet.getString("patient_phone"),resultSet.getString("patient_suite"),resultSet.getString("patient_street"),resultSet.getString("patient_city"),resultSet.getString("patient_state"),resultSet.getString("patient_country"),resultSet.getString("patient_zip")));
				//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			}

			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - All records retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - All records retrieved from the database");
    		
			//logger.info("All records retrieved from the database");
			connection.close();
		}

		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);

		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

		return list;
	}

	@Override
	public void addPatient(Patient patient) {
		String query= "CALL spInsertPatient(?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, patient.getPatient_firstname());
			statement.setString(2, patient.getPatient_lastname());
			statement.setString(3, patient.getPatient_password());
			statement.setString(4, patient.getPatient_email());
			statement.setString(5, patient.getPatient_phone());
			statement.setString(6, patient.getPatient_suite());
			statement.setString(7, patient.getPatient_street());
			statement.setString(8, patient.getPatient_city());
			statement.setString(9, patient.getPatient_state());
			statement.setString(10, patient.getPatient_country());
			statement.setString(11, patient.getPatient_zip());

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - record(s) inserted into Patient table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - record(s) inserted into Patient table");
    		
			//logger.info(num+" record(s) inserted into Patient table");
			logger.info(num+" Connection closed");
			connection.close();
		}
		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);
		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

	}

	@Override
	public void updatePatient(Patient patient) {
		String query = "UPDATE Patient Set patient_firstname=?,patient_lastname=?,patient_password=?,patient_email=?,"
				+ "patient_phone=?,patient_suite=?,patient_street=?,patient_city=?,patient_state=?,patient_country=?,"
				+ "patient_zip=? where patient_id=?";

		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, patient.getPatient_firstname());
			statement.setString(2, patient.getPatient_lastname());
			statement.setString(3, patient.getPatient_password());
			statement.setString(4, patient.getPatient_email());
			statement.setString(5, patient.getPatient_phone());
			statement.setString(6, patient.getPatient_suite());
			statement.setString(7, patient.getPatient_street());
			statement.setString(8, patient.getPatient_city());
			statement.setString(9, patient.getPatient_state());
			statement.setString(10, patient.getPatient_country());
			statement.setString(11, patient.getPatient_zip());
			statement.setString(12, patient.getPatient_id());

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - record(s) updated in the Patient table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - record(s) updated in the Patient table");
    		
			//logger.info(num+" record(s) updated in the Patient table");
		}
		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);
		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

	}

	@Override
	public void deletePatient(String patient_id) {
		String query = "CALL spdeletePatient(?)";


		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, patient_id);

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "PatientDAO - record(s) deleted in the Patient table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "PatientDAO - record(s) deleted in the Patient table");
    		
			//logger.info(num+" record(s) deleted in the Patient table");
		}
		catch (SQLException e) {
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
			//logger.info("SQLException handled - details " + e);
		}
		catch (Exception e){
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
			//logger.info("Exception handled - details " + e);
		}

	}

}
