package com.MedAccess.Dao;

import java.util.List;
import com.MedAccess.Models.Feedback;

public interface IFeedbackDAO {
	List<Feedback> getAllFeedbacks();
	List<Feedback> getFeedbackById(String feedback_id);
	void addFeedback(Feedback feedback);
	void updateFeedback(Feedback feedback);
	void deleteFeedback(String feedback_id);

}