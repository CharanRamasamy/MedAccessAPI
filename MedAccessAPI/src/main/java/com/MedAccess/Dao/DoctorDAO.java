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
import com.MedAccess.Models.Doctor;


@Transactional
@Repository
@ImportResource("classpath:dbconfig.xml")
public class DoctorDAO implements IDoctorDao{

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(DoctorDAO.class);
	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	public List<Doctor> getAllDoctors() {
		

			List<Doctor> list = new ArrayList<Doctor>();

			String query= "CALL spgetAllDoctors()";
			/*RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);*/


			try {
				
				Connection connection = dataSource.getConnection();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
	    		
				logger.info("Connection done!");
				PreparedStatement statement=connection.prepareStatement(query);
				ResultSet resultSet=statement.executeQuery();

				while(resultSet.next()){

					list.add(new Doctor(resultSet.getString("doctor_id"),resultSet.getString("doctor_firstname"), resultSet.getString("doctor_lastname"),resultSet.getString("doctor_password"),resultSet.getString("doctor_email"),resultSet.getString("doctor_phone"),resultSet.getString("doctor_suite"),resultSet.getString("doctor_street"),resultSet.getString("doctor_city"),resultSet.getString("doctor_state"),resultSet.getString("doctor_country"),resultSet.getString("doctor_zip"),resultSet.getString("doctor_reg_id"),resultSet.getString("doctor_speciality")));
					//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
				}
				
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - All records retrieved from the database");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - All records retrieved from the database");
	    		
				logger.info("All records retrieved from the database");
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
	public Doctor getDoctorById(String doctor_id) {
		
		String query= "CALL spgetDoctorById(?)";
		
		
		try {
					
			Connection connection = dataSource.getConnection();
			
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
    		
			logger.info("Connected to the database");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1,doctor_id);
			
			ResultSet resultSet=statement.executeQuery();
			Doctor doctor = new Doctor();
			
			
			while ( resultSet.next() ) {
				
				// Read the next item
				doctor.setDoctor_id(resultSet.getString("doctor_id"));
				doctor.setDoctor_firstname(resultSet.getString("doctor_firstname"));
				doctor.setDoctor_lastname(resultSet.getString("doctor_lastname"));
				doctor.setDoctor_password(resultSet.getString("doctor_password"));
				doctor.setDoctor_email(resultSet.getString("doctor_email"));
				doctor.setDoctor_phone(resultSet.getString("doctor_phone"));
				doctor.setDoctor_suite(resultSet.getString("doctor_suite"));
				doctor.setDoctor_street(resultSet.getString("doctor_street"));
				doctor.setDoctor_city(resultSet.getString("doctor_city"));
				doctor.setDoctor_state(resultSet.getString("doctor_state"));
				doctor.setDoctor_country(resultSet.getString("doctor_country"));
				doctor.setDoctor_zip(resultSet.getString("doctor_zip"));
				doctor.setDoctor_reg_id(resultSet.getString("doctor_reg_id"));
				doctor.setDoctor_speciality(resultSet.getString("doctor_speciality"));
				

			}
			
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - 1 record retrieved from the database");
    		
			//logger.info("1 record retrieved from the database");
			connection.close();

			return doctor;

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
	public Doctor getDoctorByMail(String doctor_email) {
		String query= "CALL spgetDoctorByMail(?)";
		String email = doctor_email.replaceAll(",",".");

		try {
			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
    		
			//logger.info("Connected to the database");
			logger.info(doctor_email);
			logger.info(email+"---------");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1,email);

			ResultSet resultSet=statement.executeQuery();
			Doctor doctor = new Doctor();

			while ( resultSet.next() ) {
				// Read the next item
				doctor.setDoctor_id(resultSet.getString("doctor_id"));
				doctor.setDoctor_firstname(resultSet.getString("doctor_firstname"));
				doctor.setDoctor_lastname(resultSet.getString("doctor_lastname"));
				doctor.setDoctor_password(resultSet.getString("doctor_password"));
				doctor.setDoctor_email(resultSet.getString("doctor_email"));
				doctor.setDoctor_phone(resultSet.getString("doctor_phone"));
				doctor.setDoctor_suite(resultSet.getString("doctor_suite"));
				doctor.setDoctor_street(resultSet.getString("doctor_street"));
				doctor.setDoctor_city(resultSet.getString("doctor_city"));
				doctor.setDoctor_state(resultSet.getString("doctor_state"));
				doctor.setDoctor_country(resultSet.getString("doctor_country"));
				doctor.setDoctor_zip(resultSet.getString("doctor_zip"));
				doctor.setDoctor_reg_id(resultSet.getString("doctor_reg_id"));
				doctor.setDoctor_speciality(resultSet.getString("doctor_speciality"));
			}


			//while(resultSet.next()){
			//	System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			//}


			System.out.println("1 record(s) retrieved from the database");
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - 1 record retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - 1 record retrieved from the database");
    		
			//logger.info("1 record retrieved from the database");
			connection.close();

			return doctor;

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
	public List<Doctor> getDoctorByName(String doctor_name) {

		List<Doctor> list = new ArrayList<Doctor>();
		String query= "CALL spgetDoctorByName()";
		//String query= "SELECT * FROM Doctor";

		try {

			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
    		
			logger.info("Connected to the database");
			PreparedStatement statement=connection.prepareStatement(query);
			//statement.setString(1,doctor_name);

			ResultSet resultSet=statement.executeQuery();
			//Doctor doctor = new Doctor();
			//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

			while(resultSet.next()){
				//System.out.println(resultSet.getString("doctor_firstname")+" "+resultSet.getString("doctor_lastname"));

				if ((resultSet.getString("doctor_firstname").toLowerCase().contains(doctor_name.toLowerCase())) || (resultSet.getString("doctor_lastname").toLowerCase().contains(doctor_name.toLowerCase()) )) {
					//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

					list.add(new Doctor(resultSet.getString("doctor_id"), resultSet.getString("doctor_firstname"), resultSet.getString("doctor_lastname"), resultSet.getString("doctor_password"), resultSet.getString("doctor_email"), resultSet.getString("doctor_phone"), resultSet.getString("doctor_suite"), resultSet.getString("doctor_street"), resultSet.getString("doctor_city"), resultSet.getString("doctor_state"), resultSet.getString("doctor_country"), resultSet.getString("doctor_zip"), resultSet.getString("doctor_reg_id"), resultSet.getString("doctor_speciality")));
					logger.info(resultSet);
				}
				//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			}
			loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - records retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - records retrieved from the database");
    		
			//logger.info("records retrieved from the database");
			connection.close();

			return list;

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
	public void addDoctor(Doctor doctor) {
		
			String query= "CALL spInsertDoctor(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Connection connection;
			try {
				connection = dataSource.getConnection();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
	    		
				logger.info("Connection done!");
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, doctor.getDoctor_firstname());
				statement.setString(2, doctor.getDoctor_lastname());
				statement.setString(3, doctor.getDoctor_password());
				statement.setString(4, doctor.getDoctor_email());
				statement.setString(5, doctor.getDoctor_phone());
				statement.setString(6, doctor.getDoctor_suite());
				statement.setString(7, doctor.getDoctor_street());
				statement.setString(8, doctor.getDoctor_city());
				statement.setString(9, doctor.getDoctor_state());
				statement.setString(10, doctor.getDoctor_country());
				statement.setString(11, doctor.getDoctor_zip());
				statement.setString(12, doctor.getDoctor_reg_id());
				statement.setString(13, doctor.getDoctor_speciality());
				

				int num = statement.executeUpdate();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - record(s) inserted into Doctor table");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - record(s) inserted into Doctor table");
	    		
				//logger.info(num+" record(s) inserted into Doctor table");
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
	public void updateDoctor(Doctor doctor) {
		
			String query = "UPDATE Doctor Set doctor_firstname=?,doctor_lastname=?,doctor_password=?,doctor_email=?,"
					+ "doctor_phone=?,doctor_suite=?,doctor_street=?,doctor_city=?,doctor_state=?,doctor_country=?,"
					+ "doctor_zip=?,doctor_reg_id=?,doctor_speciality=? where doctor_id=?";

			Connection connection;
			
			try {
				
				connection = dataSource.getConnection();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
	    		
				//logger.info("Connection done!");
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, doctor.getDoctor_firstname());
				statement.setString(2, doctor.getDoctor_lastname());
				statement.setString(3, doctor.getDoctor_password());
				statement.setString(4, doctor.getDoctor_email());
				statement.setString(5, doctor.getDoctor_phone());
				statement.setString(6, doctor.getDoctor_suite());
				statement.setString(7, doctor.getDoctor_street());
				statement.setString(8, doctor.getDoctor_city());
				statement.setString(9, doctor.getDoctor_state());
				statement.setString(10, doctor.getDoctor_country());
				statement.setString(11, doctor.getDoctor_zip());
				statement.setString(12, doctor.getDoctor_reg_id());
				statement.setString(13, doctor.getDoctor_speciality());
				statement.setString(14, doctor.getDoctor_id());

				int num = statement.executeUpdate();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - record(s) updated in the Doctor table");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - record(s) updated in the Doctor table");
	    		
				//logger.info(num+" record(s) updated in the Doctor table");
				
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
	public void deleteDoctor(String doctor_id) {
		
			String query = "CALL spdeleteDoctor(?)";


			Connection connection;
			try {
				
				connection = dataSource.getConnection();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - Connected to the database");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - Connected to the database");
	    		
				//logger.info("Connection done!");
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, doctor_id);

				int num = statement.executeUpdate();
				loggerChain.logMessage(AbstractLogger.INFO, "DoctorDAO - record(s) deleted in the Doctor table");
	    		loggerChain.logMessage(AbstractLogger.DEBUG, "DoctorDAO - record(s) deleted in the Doctor table");
	    		
				//logger.info(num+" record(s) deleted in the Doctor table");
				
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
