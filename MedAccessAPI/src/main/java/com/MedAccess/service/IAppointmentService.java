package com.MedAccess.service;

import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Patient;

import java.util.List;

public interface IAppointmentService {

    List<Appointment> getAllAppointments();
    Appointment getAppointmentByID(String appointmentId);
    boolean addAppointment(Appointment appointment);
    void deleteAppointment(String appointmentID);
    Doctor getDoctorById(String doctorId);
    Patient getPatientById(String patientID);
    public List<Appointment> getAppointmentbypatientId(String patientID);

}
