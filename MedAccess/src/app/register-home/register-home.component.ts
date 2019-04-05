import { Component, OnInit } from '@angular/core';


import { Validators, FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';

import {FormBuilder} from '@angular/forms';
import { RegistrationValidator } from '../register/register.validator';
import { RESTService } from '../restservice.service';
import { LogService } from '../log.service';
import { Router } from '@angular/router';



export interface User{

  value: string;
  viewValue: string;

}



@Component({
  selector: 'app-register-home',
  templateUrl: './register-home.component.html',
  styleUrls: ['./register-home.component.css']
})
export class RegisterHomeComponent implements OnInit {


  constructor(private formBuilder: FormBuilder, private logger: LogService, private router: Router) {

    
    this.logger.info("Select User Type activated");


   }


   // Type of user selection
 

  usersType: User[] = [
    {value: null, viewValue: 'None'},
    {value: 'doctor', viewValue: 'Doctor'},
    {value: 'patient', viewValue: 'Patient'}
  ];


  UserTypeCheck: FormGroup;


  ngOnInit() {


    this.logger.info("Validating the Form");


    this.UserTypeCheck = this.formBuilder.group({

      selectUser : ['',Validators.required]

    });

  }


  onSubmit(){


    this.logger.info("User selects the type of user in Register Home Component");


    if(this.UserTypeCheck.get('selectUser').value == 'patient')
    {

      this.router.navigate(['/register'], { preserveQueryParams: true });

    }  

    else if(this.UserTypeCheck.get('selectUser').value == 'doctor') 
    {

      this.router.navigate(['/doctor-register'], { preserveQueryParams: true });

    }
  


  }

}
