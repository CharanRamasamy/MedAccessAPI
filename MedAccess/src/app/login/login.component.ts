import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { RESTService } from '../restservice.service'
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LocalStorageService } from 'angular-2-local-storage';
import { DatasharingService } from '../datasharing.service';

export interface User{
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  //private loggedIn = new BehaviorSubject<boolean>(false);

  listPatients: any;
  listDoctors: any;
  result: any;

  constructor(private fb:FormBuilder, private  restService:  RESTService , private logger: LogService, private router: Router, private localStorageService: LocalStorageService, private dataSharingService: DatasharingService) { }

 // Type of user selection
 

 usersType: User[] = [
  {value: null, viewValue: 'None'},
  {value: 'doctor', viewValue: 'Doctor'},
  {value: 'patient', viewValue: 'Patient'}
];

  ngOnInit() {

    this.loginForm = this.fb.group({
      userName: ['',[
        Validators.required
      ]],
      password: ['',[
        Validators.required
      ]],
      selectUser : ['',[
        Validators.required
      ]], 
      agree: [false, [
        Validators.requiredTrue
      ]]
  });
}
get userName(){
  return this.loginForm.get('userName');
}
get password(){
  return this.loginForm.get('password');
}

/*get isLoggedIn() {
  return this.loggedIn.asObservable(); // {2}
}*/

onClickLogin(){

  this.logger.info("User clicks on Log in button of Login Component");

  var user = this.loginForm.get('userName').value;
  var tempUser = user.replace('.',',');
  var password = this.loginForm.get('password').value;
  var userType = this.loginForm.get('selectUser').value;

  if(user!="" && password!="" && userType=="patient")
  {
  this.restService.getPatientByMail(tempUser).subscribe((response:Response) => {
    
    console.log(response);
    this.listPatients = response;
    console.log(this.listPatients.patient_firstname);
    if(user == this.listPatients.patient_email && password == this.listPatients.patient_password)
    {
      this.dataSharingService.isUserLoggedIn.next(true);
      this.dataSharingService.isPatientLoggedIn.next(true);
      this.localStorageService.set('key','patient_logged_in');
      //this.loggedIn.next(true);
      this.localStorageService.set('patient_object',this.listPatients);
      console.log(this.localStorageService.get('key'));
      if(this.localStorageService.get('nextPage') == 'feedback')
      {
        this.localStorageService.set('nextPage','')
        this.router.navigate(['feedback']);
      }
      else if(this.localStorageService.get('nextPage') == 'bookappointment'){
        this.localStorageService.set('nextPage','')
        this.router.navigate(['bookappointment']);
      }
      else
      {
        this.router.navigate(['history']);
      }
    }
    else
    {
      alert("Invalid Credentials...Please try again");
      this.loginForm.reset();
    }
});
  }
  else if(user!="" && password!="" && userType=="doctor")
  {
    this.restService.getDoctorByMail(tempUser).subscribe((response:Response) => {
    
      console.log(response);
      this.listDoctors = response;
      console.log(this.listDoctors.doctor_firstname);
      if(user == this.listDoctors.doctor_email && password == this.listDoctors.doctor_password)
      {
        this.dataSharingService.isDoctorLoggedIn.next(true);
        this.dataSharingService.isUserLoggedIn.next(true);
        this.localStorageService.set('key','doctor_logged_in');
        this.localStorageService.set('doctor_object',this.listDoctors);
        console.log(this.localStorageService.get('key'));
        if(this.localStorageService.get('nextPage') == 'feedback')
        {
          alert("Hello Doctor! You have to open a patient account for yourself to provide a Feedback :)");
          this.localStorageService.set('nextPage','')
          this.router.navigate(['feedback']);
        }
        else if(this.localStorageService.get('nextPage') == 'bookappointment'){
          alert("Hello Doctor! You have to open a patient account for yourself to book an Appointment :)");
          this.localStorageService.set('nextPage','')
          this.router.navigate(['doctor-home']);
        }
        else
        {
          this.router.navigate(['doctor-home']);
        }
      }
      else
      {
        alert("Invalid Credentials...Please try again");
        this.loginForm.reset();
      }
  });
  }

}



}

