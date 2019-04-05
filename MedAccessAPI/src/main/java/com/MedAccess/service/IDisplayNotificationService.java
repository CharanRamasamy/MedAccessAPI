package com.MedAccess.service;

import java.util.List;


import com.MedAccess.Models.DoctorNotification;

public interface IDisplayNotificationService {
	
	public List<DoctorNotification> getDoctorAppointment(String doctorId);

}
