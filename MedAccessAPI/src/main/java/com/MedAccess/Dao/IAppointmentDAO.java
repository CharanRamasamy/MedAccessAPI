package com.MedAccess.Dao;

import com.MedAccess.Models.Appointment;
import com.MedAccess.Models.Doctor;
import com.MedAccess.Models.Patient;

import java.util.List;

public interface IAppointmentDAO {

    List<Appointment> getAllAppointments();
    Appointment getAppointmentByID(String appointmentId);
    void addAppointment(Appointment appointment);
    void deleteAppointment(String appointmentID);
    Doctor getDoctorById(String doctorId);
    Patient getPatientById(String patientID);
    List<Appointment> getAppointmentbypatientId(String patientID);
}
