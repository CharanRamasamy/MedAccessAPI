import { Component, OnInit } from '@angular/core';
import { Validators, FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {FormBuilder} from '@angular/forms';
import { RegistrationValidator } from '../register/register.validator';
import { RESTService } from '../restservice.service';
import { LogService } from '../log.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private restService: RESTService, private logger: LogService,private router: Router){
    this.logger.info("Register Component activated");

  }

  //registerForm: FormGroup; 

  registerForm: FormGroup;
  passwordGroup: FormGroup;
  formRadio: FormGroup;



 

  //@Input() onLoadGetBusinessLogic();


  

  //emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  //passwordPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
  //passwordPattern = "^[a-zA-Z0-9?=.*?[#?!@$%^&*-]{8,}$$";
  //phonePattern = "^[0-9]{10}$";
  //suitePattern = "^[0-9]{1,5}$";
  //zipcodePattern = "[ABCEGHJKLMNPRSTVXY abceghjklmnprstvxy][0-9][ABCEGHJKLMNPRSTVWXYZ abceghjklmnprstvxy] ?[0-9][ABCEGHJKLMNPRSTVWXYZ abceghjklmnprstvxy][0-9]"

  


  ngOnInit() {

    this.logger.info("Validating Register Form");    
    this.passwordGroup = this.formBuilder.group({
      password:  ['', [Validators.required,  Validators.pattern(this.restService.passwordPattern) ]],
      reenterpassword:   ['',  Validators.required],
      selectUser: ['', Validators.required],
    }, {
      validator: RegistrationValidator.validate.bind(this)
    });
    //console.log(this.emailPattern);

    /* this.form = this.formBuilder.group({
      selectUser: new FormControl({value: 'Patient', disabled: true}, Validators.required)
    }); */

    this.registerForm = this.formBuilder.group({
      firstname : ['',Validators.required],
      lastname : ['',Validators.required],
      emailid : ['',[Validators.required , Validators.pattern(this.restService.emailPattern)]],   
      phone : ['',[Validators.required , Validators.pattern(this.restService.phonePattern)]],
      suite : ['',[Validators.required , Validators.pattern(this.restService.suitePattern)]],
      street : ['',Validators.required],
      number : ['',Validators.required],
      hospital : ['', Validators.required],
      city : ['',Validators.required],
      state : ['',Validators.required],
      country : ['',Validators.required],
      zip : ['',[Validators.required , Validators.pattern(this.restService.zipcodePattern)]],
      passwordGroup: this.passwordGroup
    });
    

  }    
    

  
  onClickRegister(){

    this.logger.info("User clicks on Sign up button of Register Component");

    var patient = {
      patient_firstname: this.registerForm.get('firstname').value,
      patient_lastname: this.registerForm.get('lastname').value,
      patient_password: this.passwordGroup.get('password').value,
      patient_email: this.registerForm.get('emailid').value,
      patient_phone: this.registerForm.get('phone').value,
      patient_suite: this.registerForm.get('suite').value,
      patient_street: this.registerForm.get('street').value,
      patient_city: this.registerForm.get('city').value,
      patient_state: this.registerForm.get('state').value,
      patient_country: this.registerForm.get('country').value,
      patient_zip: this.registerForm.get('zip').value
    }
    this.restService.createPatient(patient).subscribe((response) => {
      console.log(response);
      alert("Patient registered");

  });

  this.router.navigate(['/login'], { preserveQueryParams: true });

    

      

    }

  }

    
    

 

