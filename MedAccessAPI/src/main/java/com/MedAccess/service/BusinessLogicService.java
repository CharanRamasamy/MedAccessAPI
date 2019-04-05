package com.MedAccess.service;

import com.MedAccess.Dao.*;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.BusinessLogic;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessLogicService implements IBusinessLogicService {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
    final static Logger logger = Logger.getLogger(BusinessLogicService.class);

    @Autowired
    private IBusinessLogicDAO businessLogicDAO;



    @Override
    public List<BusinessLogic> getBusinessLogic() {
        List<BusinessLogic> list = new ArrayList<BusinessLogic>();
        loggerChain.logMessage(AbstractLogger.INFO, "BusinessLogicService - BusinessLogicService calling all Appointment records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "BusinessLogicService - BusinessLogicService calling all Appointment records");
		
        //logger.info("AppointmentService calling all Appointment records");
        list = businessLogicDAO.getBusinessLogic();
        return list;
    }
}
