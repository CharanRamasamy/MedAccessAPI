package com.MedAccess.Dao;


import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.BusinessLogic;
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
public class BusinessLogicDAO implements IBusinessLogicDAO{

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
    final static Logger logger = Logger.getLogger(DoctorDAO.class);

    @Autowired
    DataSource dataSource;


    @Override
    public List<BusinessLogic> getBusinessLogic() {


        List<BusinessLogic> list = new ArrayList<BusinessLogic>();

        //String query= "SELECT logic_id, email_pattern, password_pattern, phone_pattern, zipcode_pattern, suite_pattern FROM BusinessLogic";
        String query= "CALL spSelectBusinessLogic()";
        /*RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);*/


        try {

            Connection connection = dataSource.getConnection();
            loggerChain.logMessage(AbstractLogger.INFO, "BusinessLogicDAO - Connected to the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "BusinessLogicDAO - Connected to the database");
    		
            //logger.info("Connection done!");
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){

                list.add(new BusinessLogic(resultSet.getString("logic_id"),resultSet.getString("email_pattern"), resultSet.getString("password_pattern"),resultSet.getString("phone_pattern"),resultSet.getString("zipcode_pattern"),resultSet.getString("suite_pattern")));
            }

            loggerChain.logMessage(AbstractLogger.INFO, "BusinessLogicDAO - All records retrieved from the database");
    		loggerChain.logMessage(AbstractLogger.DEBUG, "BusinessLogicDAO - All records retrieved from the database");
    		
            //logger.info("All records retrieved from the database");
            connection.close();
        }

        catch (SQLException e) {
        	
        	loggerChain.logMessage(AbstractLogger.ERROR, "SQLException handled - details");
            logger.info("SQLException handled - details " + e);

        }

        catch (Exception e){
        	
        	loggerChain.logMessage(AbstractLogger.ERROR, "Exception handled - details");
            logger.info("Exception handled - details " + e);
            
        }

        return list;


    }
}
