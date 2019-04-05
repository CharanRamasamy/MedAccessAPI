package com.MedAccess.Controller;

import com.MedAccess.Dao.FeedbackDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.BusinessLogic;
import com.MedAccess.service.IBusinessLogicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class BusinessLogicController {
	
	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();

    final static Logger logger = Logger.getLogger(FeedbackDAO.class);

    @Autowired
    private IBusinessLogicService businessLogicService;

    @GetMapping("businesslogic")
    public ResponseEntity<List<BusinessLogic>> getBusinessLogic() {
    	
    	loggerChain.logMessage(AbstractLogger.INFO, "BusinessLogicController - FeedbackController calling all Feedback records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "BusinessLogicController - FeedbackController calling all Feedback records");
        List<BusinessLogic> list = businessLogicService.getBusinessLogic();
        return new ResponseEntity<List<BusinessLogic>>(list, HttpStatus.OK);
    }


}
