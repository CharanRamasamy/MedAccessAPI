package com.MedAccess.Controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.MedAccess.Dao.FeedbackDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Models.Feedback;
import com.MedAccess.service.IFeedbackService;

@RestController
@RequestMapping("/MedAccess")
@CrossOrigin
public class FeedbackController {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(FeedbackDAO.class);

	@Autowired
	private IFeedbackService feedbackService;

	@RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Feedback>> getFeedbackById(@PathVariable("id") String id) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackController - FeedbackController calling Feedback record by Id");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackController - FeedbackController calling Feedback record by Id");
		System.out.println(id+"----");
		//logger.info("FeedbackController calling Feedback record by Id");
        List<Feedback> list = feedbackService.getFeedbackById(id);
		return new ResponseEntity<List<Feedback>>(list, HttpStatus.OK);
	}

	@GetMapping("feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackController - FeedbackController calling all Feedback records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackController - FeedbackController calling all Feedback records");
		
		//logger.info("FeedbackController calling all Feedback records");
		List<Feedback> list = feedbackService.getAllFeedbacks();
		return new ResponseEntity<List<Feedback>>(list, HttpStatus.OK);
	}


	@RequestMapping(value = "feedback", method = RequestMethod.POST)
	public ResponseEntity<Void> addFeedback(@RequestBody Feedback feedback) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackController - FeedbackController calling all Feedback records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackController - FeedbackController calling all Feedback records");
		
		//logger.info("FeedbackController adding Feedback record");
		feedbackService.addFeedback(feedback);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("updatefeedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback updatefeedback) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackController - FeedbackController updating Feedback record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackController - FeedbackController updating Feedback record");
		
		logger.info("FeedbackController updating Feedback record");
		feedbackService.updateFeedback(updatefeedback);
		return new ResponseEntity<Feedback>(updatefeedback, HttpStatus.OK);
	}

	@DeleteMapping("deletefeedback/{id}")
	public ResponseEntity<Void> deleteFeedback(@PathVariable("id") String id) {
		
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackController - FeedbackController deleting Feedback record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackController - FeedbackController deleting Feedback record");
		
		logger.info("FeedbackController deleting Feedback record");
		feedbackService.deleteFeedback(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
