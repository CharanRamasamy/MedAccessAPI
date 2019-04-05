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
import com.MedAccess.Models.Feedback;
import org.springframework.web.bind.annotation.PathVariable;

@Transactional
@Repository
@ImportResource("classpath:dbconfig.xml")
public class FeedbackDAO implements IFeedbackDAO {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(FeedbackDAO.class);

	@Autowired
	DataSource dataSource;

    @Override
    public List<Feedback> getFeedbackById(@PathVariable("id") String id) {

        List<Feedback> list = new ArrayList<Feedback>();

        String query= "SELECT feedback_id,doctor_id, patient_id, email, patient_name, doctor_name, description, posteddate FROM Feedback where doctor_id=?";
        /*RowMapper<Feedback> rowMapper = new BeanPropertyRowMapper<Feedback>(Feedback.class);*/
System.out.println(id);
        try {
            Connection connection = dataSource.getConnection();
            loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
            loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");

            logger.info("Connection done!");
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){

                list.add(new Feedback(resultSet.getString("feedback_id"),resultSet.getString("doctor_id"), resultSet.getString("patient_id"),resultSet.getString("email"),resultSet.getString("patient_name"),resultSet.getString("doctor_name"),resultSet.getString("description"),resultSet.getString("posteddate")));
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
            loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - All records retrieved from the database");
            loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - All records retrieved from the database");

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
	public List<Feedback> getAllFeedbacks() {

		List<Feedback> list = new ArrayList<Feedback>();

		String query= "CALL spgetAllFeedbacks()";
		/*RowMapper<Feedback> rowMapper = new BeanPropertyRowMapper<Feedback>(Feedback.class);*/


		try {
			Connection connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");
    		
			logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet resultSet=statement.executeQuery();

			while(resultSet.next()){

				list.add(new Feedback(resultSet.getString("feedback_id"),resultSet.getString("doctor_id"), resultSet.getString("patient_id"),resultSet.getString("email"),resultSet.getString("patient_name"),resultSet.getString("doctor_name"),resultSet.getString("description"),resultSet.getString("posteddate")));
				//System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
			}
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - All records retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - All records retrieved from the database");
    		
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
	public void addFeedback(Feedback feedback) {
		String query= "INSERT into Feedback (doctor_id,patient_id,email,patient_name,"
				+ "doctor_name,description,posteddate) values(?,?,?,?,?,?,?)";

		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, feedback.getDoctor_id());
			statement.setString(2, feedback.getPatient_id());
			statement.setString(3, feedback.getEmail());
			statement.setString(4, feedback.getPatient_name());
			statement.setString(5, feedback.getDoctor_name());
			statement.setString(6, feedback.getDescription());
			statement.setString(7, feedback.getPosteddate());

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");
    		
			//logger.info(num+" record(s) inserted into Feedback table");
			logger.info(num+" Connection closed");
			connection.close();
		}
		catch (SQLException e) {
			logger.info("SQLException handled - details " + e);
		}
		catch (Exception e){
			logger.info("Exception handled - details " + e);
		}

	}

	@Override
	public void updateFeedback(Feedback feedback) {
		String query = "UPDATE Feedback Set doctor_id=?,patient_id=?,email=?,patient_name=?,doctor_name=?,"
				+ "description=?,posteddate=?";

		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");
    		
			logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, feedback.getDoctor_id());
			statement.setString(2, feedback.getPatient_id());
			statement.setString(3, feedback.getEmail());
			statement.setString(4, feedback.getPatient_name());
			statement.setString(5, feedback.getDoctor_name());
			statement.setString(6, feedback.getDescription());
			statement.setString(7, feedback.getPosteddate());

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - record(s) updated in the Feedback table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - record(s) updated in the Feedback table");
    		
			//logger.info(num+" record(s) updated in the Feedback table");
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
	public void deleteFeedback(String feedback_id) {
		String query = "CALL spDeleteFeedBack(?)";


		Connection connection;
		try {
			connection = dataSource.getConnection();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - Connected to the database");
    		
			//logger.info("Connection done!");
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, feedback_id);

			int num = statement.executeUpdate();
			loggerChain.logMessage(AbstractLogger.INFO, "FeedbackDAO - record(s) deleted in the Feedback table");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackDAO - record(s) deleted in the Feedback table");
    		
			//logger.info(num+" record(s) deleted in the Feedback table");
		}
		catch (SQLException e) {
			//logger.info("SQLException handled - details " + e);
			loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
		}
		catch (Exception e){
			//logger.info("Exception handled - details " + e);
			loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
		}

	}

}
