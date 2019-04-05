import { Component, OnInit } from '@angular/core';
import { Validators, FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {FormBuilder} from '@angular/forms';
import { RegistrationValidator } from '../doctor-register/doctor-register.validator';
import { RESTService } from '../restservice.service';
import { LogService } from '../log.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-doctor-register',
  templateUrl: './doctor-register.component.html',
  styleUrls: ['./doctor-register.component.css']
})


export class DoctorRegisterComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private  restService:  RESTService, private logger: LogService,private router: Router){
    this.logger.info("Register Component activated");
}

//registerForm: FormGroup; 

registerForm: FormGroup;
passwordGroup: FormGroup;
form: FormGroup;
  

  ngOnInit() {

    this.logger.info("Validating Register Form");
    
    
    this.passwordGroup = this.formBuilder.group({

      password:  ['', [Validators.required,  Validators.pattern(this.restService.passwordPattern) ]],
      reenterpassword:   ['',  Validators.required],
      selectUser: ['', Validators.required],

    }, {
      validator: RegistrationValidator.validate.bind(this)
    });


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


    var doctor = {

      doctor_firstname: this.registerForm.get('firstname').value,
      doctor_lastname: this.registerForm.get('lastname').value,
      doctor_password: this.passwordGroup.get('password').value,
      doctor_email: this.registerForm.get('emailid').value,
      doctor_phone: this.registerForm.get('phone').value,
      doctor_suite: this.registerForm.get('suite').value,
      doctor_street: this.registerForm.get('street').value,
      doctor_city: this.registerForm.get('city').value,
      doctor_state: this.registerForm.get('state').value,
      doctor_country: this.registerForm.get('country').value,
      doctor_zip: this.registerForm.get('zip').value,
      doctor_reg_id: this.registerForm.get('number').value,
      doctor_speciality: this.registerForm.get('hospital').value


      }

      this.restService.createDoctor(doctor).subscribe((response) => {
        console.log(response);
        alert("Doctor registered");

    });

    this.router.navigate(['/login'], { preserveQueryParams: true });

  }

}
