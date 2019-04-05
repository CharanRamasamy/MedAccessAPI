package com.MedAccess.service;

import java.util.List;

import com.MedAccess.Models.Feedback;

public interface IFeedbackService {

	List<Feedback> getAllFeedbacks();
    List<Feedback> getFeedbackById(String feedbackId);
    boolean addFeedback(Feedback feedback);
    void updateFeedback(Feedback feedback);
    void deleteFeedback(String feedbackId);
    
}
