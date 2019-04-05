import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {FormBuilder} from '@angular/forms';
import { RESTService } from '../restservice.service';
import { LogService } from '../log.service';
import { MatRadioGroup } from '@angular/material';
import { LocalStorageService } from 'angular-2-local-storage';
import { Router, ActivatedRoute } from '@angular/router';

export interface Appointment {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-bookappointment',
  templateUrl: './bookappointment.component.html',
  styleUrls: ['./bookappointment.component.css']
})
export class BookappointmentComponent implements OnInit {

  appointmentform: FormGroup;
  listPatients: any;
  listDoctors: any;

  
  foods: Appointment[] = [
    {value: '6pm', viewValue: '6 pm'},
    {value: '7pm', viewValue: '7 pm'},
    {value: '8pm', viewValue: '8 pm'}
  ];

  constructor(private formBuilder: FormBuilder, private router: Router, private  restService:  RESTService, private logger: LogService, private localStorageService: LocalStorageService) {

    this.logger.info("Appointment Component activated");
    var key = this.localStorageService.get('key');
    if(key == 'patient_logged_in')
    {
      this.getPatientDetails();
      this.getDoctorDetails();
    }

  }

  ngOnInit() {
    this.appointmentform = this.formBuilder.group({
    
      dateOfApp : '',
      time : ''

    });    
  }

  onClickAddAppointment()
  {
    var appointment =  {
      
      patient_id : this.listPatients.patient_id,
      doctor_id : this.listDoctors.doctor_id,
      app_date : this.appointmentform.get('dateOfApp').value,
      app_time : this.appointmentform.get('time').value
    }
    this.restService.addAppointment(appointment).subscribe((response) => {
      console.log(response);
      alert("Appointment Booked");
      this.router.navigate(['history']);

  });
}

getPatientDetails(){
  this.listPatients = this.localStorageService.get('patient_object');
}

getDoctorDetails(){
 this.listDoctors = this.localStorageService.get('doctor_object');
}


}
