import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import { RESTService } from '../restservice.service'
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  feedbackForm: FormGroup;
  patientDetails: any;
  doctorDetails: any;

  today: any;
  dd:any;
  mm:any;
  yyyy:any;
  
  constructor(private fb:FormBuilder, private  restService:  RESTService , private logger: LogService, private router: Router, private localStorageService: LocalStorageService) {
    var key = this.localStorageService.get('key');
    if(key == 'patient_logged_in')
    {
      this.getPatientDetails();
      this.getDoctorDetails();
    }
   }

  ngOnInit() {

    var keyIntial = this.localStorageService.get('key');
    if(keyIntial == 'patient_logged_in')
    {
      this.getPatientDetails();
      this.getDoctorDetails();
    }

    this.feedbackForm = this.fb.group({
      username: ['',[
        Validators.required
      ]],
      email: ['',[
        Validators.required
      ]],
      docname: ['',[
        Validators.required
      ]],
      description: ['',[
        Validators.required
      ]],
      agree: [false, [
        Validators.requiredTrue
      ]]
  });

  this.feedbackForm = this.fb.group({
    username: new FormControl({ value: '', disabled: true },Validators.required),
    email: new FormControl({ value: '', disabled: true }),
    docname: new FormControl({ value: '', disabled: true }),
    description: new FormControl({ value: '', disabled: false })
});
    
  }

  onClickSubmit() {
    console.log(this.doctorDetails.doctor_id+"---");
    this.today = new Date();
    this.dd = this.today.getDate();
    this.mm = this.today.getMonth()+1;
    this.yyyy = this.today.getFullYear();
    
    if(this.dd<10) {
        this.dd = '0'+this.dd
    } 
    
    if(this.mm<10) {
        this.mm = '0'+this.mm
    } 
    
    this.today = this.mm + '/' + this.dd + '/' + this.yyyy;
    console.log(this.today);

    var feedback = {
      doctor_id: this.doctorDetails.doctor_id,
      patient_id: this.patientDetails.patient_id,
      email: this.patientDetails.patient_email,
      patient_name: this.patientDetails.patient_firstname,
      doctor_name: this.doctorDetails.doctor_firstname,
      description: this.feedbackForm.get('description').value,
      posteddate: this.today
    }

    this.restService.createFeedback(feedback).subscribe((response) => {
      console.log(response);
      alert("Feedback submitted Successfully");
  });
  }

  provideFeedback(){
    this.router.navigate(['/feedback-home']);
  }

  getPatientDetails(){
    this.patientDetails = this.localStorageService.get('patient_object');
  }

  getDoctorDetails(){
    this.doctorDetails = this.localStorageService.get('doctor_object');
  }
}
