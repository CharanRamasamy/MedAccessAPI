package com.MedAccess.Dao;

import java.util.List;
import com.MedAccess.Models.DoctorNotification;


public interface IDisplayNotificationDAO {
	
	
	List<DoctorNotification> getDoctorAppointment(String doctor_id);

}
