import { Injectable } from '@angular/core';
import { HttpClient} from  '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
  
})
export class RESTService {

  constructor(private  httpClient:  HttpClient) { }

   emailPattern: string = '';
   passwordPattern: string = '';
   phonePattern: string = '';
   suitePattern: string = '';
   zipcodePattern: string = '';
 
  
  createPatientURL  =  environment.createPatientURL;
  getPatientByMailURL = environment.getPatientByMailURL;
  getDoctorByMailURL = environment.getDoctorByMailURL;
  getDoctorByIdUrl  =  environment.getDoctorByIdUrl;
  addAppointmentURL = environment.addAppointmentURL;
  App_URL = environment.appointmentURL;
  addDoctorURL = environment.addDoctorURL;
  apiUrlFeedback = environment.apiUrlFeedback;
  appointmentURL = environment.appointmentURL;
  getDoctorByNameURL = environment.getDoctorByNameURL;
  apiUrlAppointmentNotification = environment.apiUrlAppointmentNotification;
  apiUrlDeleteAppointment = environment.apiUrlDeleteAppointment;
  getAppointmentByPatientIdURL = environment.getAppointmentByPatientIdURL;
  getBusinessLogicURL = environment.getBusinessLogicURL;
  getFeedbackById = environment.getFeedbackById;

  

  createPatient(patient){

    return  this.httpClient.post(`${this.createPatientURL}`,patient);

  }

  getPatientById(id){
    return  this.httpClient.get(`${this.createPatientURL}/${id}`);
  }

  getPatientByMail(mail){
    return  this.httpClient.get(`${this.getPatientByMailURL}/${mail}`);
  }


 /*  getPatient(patient){

      return  this.httpClient.post(`${this.API_URL}`,patient);
      
} */

createDoctor(doctor){

  return this.httpClient.post(`${this.addDoctorURL}`, doctor);

}


getDoctorById(id){

  return this.httpClient.get(`${this.getDoctorByIdUrl}/${id}`);

} 

getDoctorByName(searchterm){

  return this.httpClient.get(`${this.getDoctorByNameURL}/${searchterm}`);

}

getDoctorByMail(mail){
  return  this.httpClient.get(`${this.getDoctorByMailURL}/${mail}`);
}

addAppointment(appointment)
{
  return this.httpClient.post(`${this.addAppointmentURL}`, appointment);
}

getAppointmentNotification(id){

  return  this.httpClient.get(`${this.apiUrlAppointmentNotification}/${id}`);

}

getAppointmentById(id){
  return this.httpClient.get(`${this.getFeedbackById}/${id}`);
}

createFeedback(feedback){

  return  this.httpClient.post(`${this.apiUrlFeedback}`,feedback);

}

getFeedbackByID(id){

  return  this.httpClient.get(`${this.getFeedbackById}/${id}`);

}

getAppointmentByPatientID(id)
{
  return  this.httpClient.get(`${this.getAppointmentByPatientIdURL}/${id}`);
}

deleteAppointment(id)
{
  return  this.httpClient.delete(`${this.apiUrlDeleteAppointment}/${id}`);
}

getBusinessLogic()
{
  return this.httpClient.get(`${this.getBusinessLogicURL}`);
}

}
