package com.MedAccess.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedAccess.Dao.IFeedbackDAO;
import com.MedAccess.Logger.AbstractLogger;
import com.MedAccess.Logger.ChainOfRespDesignPattern;
import com.MedAccess.Dao.FeedbackDAO;
import com.MedAccess.Models.Feedback;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FeedbackService implements IFeedbackService {

	AbstractLogger loggerChain = ChainOfRespDesignPattern.setChainOfLoggers();
	final static Logger logger = Logger.getLogger(FeedbackDAO.class);

	@Autowired
	private IFeedbackDAO feedbackDAO;

	@Override
	public List<Feedback> getFeedbackById(@PathVariable("id") String id) {
		List<Feedback> list = new ArrayList<Feedback>();
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackService - FeedbackService calling all Feedback records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackService - FeedbackService calling all Feedback records");
		
		//logger.info("FeedbackService calling all Feedback records");
		list = feedbackDAO.getFeedbackById(id);

		return list;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> list = new ArrayList<Feedback>();
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackService - FeedbackService calling all Feedback records");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackService - FeedbackService calling all Feedback records");

		//logger.info("FeedbackService calling all Feedback records");
		list = feedbackDAO.getAllFeedbacks();

		return list;
	}
	
	@Override
	public synchronized boolean addFeedback(Feedback feedback) {

		//if (feedbackDAO.articleExists(feedback.getTitle(), article.getCategory())) {
		//      return false;
		//  } else {
		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackService - FeedbackService adding Feedback record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackService - FeedbackService adding Feedback record");
		
		//logger.info("FeedbackService adding Feedback record");
		feedbackDAO.addFeedback(feedback);
		//      return true;
		//  }

		return false;
	}

	@Override
	public void updateFeedback(Feedback feedback) {

		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackService - FeedbackService updating Feedback record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackService - FeedbackService updating Feedback record");
		
		//logger.info("FeedbackService updating Feedback record");
		feedbackDAO.updateFeedback(feedback);

	}

	@Override
	public void deleteFeedback(String feedbackId) {

		loggerChain.logMessage(AbstractLogger.INFO, "FeedbackService - FeedbackService deleting Feedback record");
		loggerChain.logMessage(AbstractLogger.DEBUG, "FeedbackService - FeedbackService deleting Feedback record");
		
		//logger.info("FeedbackService deleting Feedback record");
		feedbackDAO.deleteFeedback(feedbackId);

	}
}
