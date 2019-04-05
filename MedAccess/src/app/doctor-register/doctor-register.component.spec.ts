import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorRegisterComponent } from './doctor-register.component';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { validateBasis } from '@angular/flex-layout';
import {MatSelectChange} from '@angular/material';
import {MatExpansionModule} from '@angular/material/expansion';


fdescribe('DoctorRegisterComponent', () => {

  let component: DoctorRegisterComponent;
  let fixture: ComponentFixture<DoctorRegisterComponent>;


  beforeEach(async(() => {

    TestBed.configureTestingModule({

      imports: [HttpClientModule , MatFormFieldModule, MatInputModule, MatButtonModule, BrowserAnimationsModule, MatCardModule, FormsModule , ReactiveFormsModule, MatSelectChange, MatExpansionModule ],
      declarations: [ DoctorRegisterComponent ]
    
    })
    .compileComponents();
  }));

  beforeEach(() => {

    fixture = TestBed.createComponent(DoctorRegisterComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('form invalid when empty', () => {
    expect(component.registerForm.valid).toBeFalsy();
  });


  it('First Name field validatity', () => {
    let firstname = component.registerForm.controls['firstname']
    expect(firstname.valid).toBeFalsy();
  });


  it('EmailID field validatity', () => {
    let EmailID = component.registerForm.controls['emailid']
    expect(EmailID.valid).toBeFalsy();
  });


  it('Phone field validatity', () => {
    let phone = component.registerForm.controls['phone']
    expect(phone.valid).toBeFalsy();
  });


  it('Suite field validatity', () => {
    let suite = component.registerForm.controls['suite']
    expect(suite.valid).toBeFalsy();
  });


  it('License field validatity', () => {
    let number = component.registerForm.controls['number']
    expect(number.valid).toBeFalsy();
  });


  
  it('Hospital field validatity', () => {
    let hospital = component.registerForm.controls['hospital']
    expect(hospital.valid).toBeFalsy();
  });


  it('Password validatity', () => {
    let Password = component.passwordGroup.controls['password']
    expect(Password.valid).toBeFalsy();
  });


  it('Re Enter password field validatity', () => {
    let reenterpassword = component.passwordGroup.controls['reenterpassword']
    expect(reenterpassword.valid).toBeFalsy();
  });


  it('Street field validatity', () => {
    let Street = component.registerForm.controls['street']
    expect(Street.valid).toBeFalsy();
  });


  it('City field validatity', () => {
    let city = component.registerForm.controls['city']
    expect(city.valid).toBeFalsy();
  });


  it('Country field validatity', () => {
    let country = component.registerForm.controls['country']
    expect(country.valid ).toBeFalsy();
  });


  it('State field validatity', () => {
    let state = component.registerForm.controls['state']
    expect(state.valid).toBeFalsy();
  });


  it('Zipcode field validatity', () => {
    let zip = component.registerForm.controls['zip']
    expect(zip.valid).toBeFalsy();
  });


  it('First Name field check', () => {
    let errors = {};
    let firstname = component.registerForm.controls['firstname'] 
 
    errors = firstname.errors || {}
    expect(errors['required']).toBeTruthy();

    firstname.setValue("Priya")
    errors = firstname.errors || {}
    expect(errors['required']).toBeFalsy();

   });

   

   it('Last Name field check', () => {
    let errors = {};
    let lastname = component.registerForm.controls['lastname'] 
 
    errors = lastname.errors || {}
    expect(errors['required']).toBeTruthy();

    lastname.setValue("Priya")
    errors = lastname.errors || {}
    expect(errors['required']).toBeFalsy();

   });



   it('License field check', () => {
    let errors = {};
    let number = component.registerForm.controls['number'] 
 
    errors = number.errors || {}
    expect(errors['required']).toBeTruthy();

    number.setValue("Test")
    errors = number.errors || {}
    expect(errors['required']).toBeFalsy();

   });


   
   it('Hospital field check', () => {
    let errors = {};
    let hospital = component.registerForm.controls['hospital'] 
 
    errors = hospital.errors || {}
    expect(errors['required']).toBeTruthy();

    hospital.setValue("Test")
    errors = hospital.errors || {}
    expect(errors['required']).toBeFalsy();

   });


  it('EmailID field check', () => {
   let errors = {};
   let emailid = component.registerForm.controls['emailid'] 

   errors = emailid.errors || {}
   expect(errors['required']).toBeTruthy();

   emailid.setValue("priya")
   errors = emailid.errors || {}
   expect(errors['pattern']).toBeTruthy();

   emailid.setValue("priya@dal.ca")
   errors = emailid.errors || {}
   expect(errors['pattern']).toBeFalsy();

  });


  it('password field check', () => {
    let errors = {};
    let password = component.passwordGroup.controls['password'] 
 
    errors = password.errors || {}
    expect(errors['required']).toBeTruthy();

    password.setValue("priya");
    errors = password.errors || {}
    expect(errors['pattern']).toBeTruthy();

    password.setValue("12345");
    errors = password.errors || {}
    expect(errors['pattern']).toBeTruthy();

    password.setValue("sampathSelvi");
    errors = password.errors || {}
    expect(errors['pattern']).toBeTruthy();

    password.setValue("PriyaSampath123!");
    errors = password.errors || {}
    expect(errors['pattern']).toBeFalsy();

   });


   it('confirm password field check', () => {
    let errors = {};
    let cpassword = component.passwordGroup.controls['reenterpassword'] 
 
    errors = cpassword.errors || {}
    expect(errors['required']).toBeTruthy();

    cpassword.setValue("priya");
    errors = cpassword.errors || {}
    expect(errors['required']).toBeFalsy();


   });

   fit('Password matches check', () => {
    let errors = {};
    let doesNotMatchPassword: false;
    let password = component.passwordGroup.controls['password'] 
    let cpassword = component.passwordGroup.controls['reenterpassword'] 
 
    password.setValue("PriyaSampath123!");
    cpassword.setValue("priya!")
    expect(errors['doesNotMatchPassword']).toBeTruthy();

    password.setValue("PriyaSampath!12");
    cpassword.setValue("PriyaSampath!12")
    expect(errors['doesNotMatchPassword']).toBeFalsy();


   });


   it('Phone number check', () => {
    let errors = {};
    let phone = component.registerForm.controls['phone'] 
 
    errors = phone.errors || {}
    expect(errors['required']).toBeTruthy();

    phone.setValue("Priya")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeTruthy();

    phone.setValue("123")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeTruthy();

    phone.setValue("1234567891")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeFalsy();

   });


   it('Suite number check', () => {
    let errors = {};
    let phone = component.registerForm.controls['suite'] 
 
    errors = phone.errors || {}
    expect(errors['required']).toBeTruthy();

    phone.setValue("Priya")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeTruthy();

    phone.setValue("123")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeFalsy(); 

   });


   it('Suite number check', () => {
    let errors = {};
    let phone = component.registerForm.controls['suite'] 
 
    errors = phone.errors || {}
    expect(errors['required']).toBeTruthy();

    phone.setValue("Priya")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeTruthy();

    phone.setValue("123")
    errors = phone.errors || {}
    expect(errors['pattern']).toBeFalsy(); 

   });


   it('Street check', () => {
    let errors = {};
    let street = component.registerForm.controls['street'] 
 
    errors = street.errors || {}
    expect(errors['required']).toBeTruthy();

    street.setValue("Monastery Lane")
    errors = street.errors || {}
    expect(errors['required']).toBeFalsy();

   });


   it('State check', () => {
    let errors = {};
    let state = component.registerForm.controls['state'] 
 
    errors = state.errors || {}
    expect(errors['required']).toBeTruthy();

    state.setValue("Monastery Lane")
    errors = state.errors || {}
    expect(errors['required']).toBeFalsy();

   });


   it('City check', () => {
    let errors = {};
    let city = component.registerForm.controls['city'] 
 
    errors = city.errors || {}
    expect(errors['required']).toBeTruthy();

    city.setValue("Halifax")
    errors = city.errors || {}
    expect(errors['required']).toBeFalsy();

   });


   it('Country check', () => {
    let errors = {};
    let country = component.registerForm.controls['country'] 
 
    errors = country.errors || {}
    expect(errors['required']).toBeTruthy();

    country.setValue("Halifax")
    errors = country.errors || {}
    expect(errors['required']).toBeFalsy();

   });


   it('Zipcode check', () => {
    let errors = {};
    let zip = component.registerForm.controls['zip'] 
 
    errors = zip.errors || {}
    expect(errors['required']).toBeTruthy();

    zip.setValue("Halifax")
    errors = zip.errors || {}
    expect(errors['pattern']).toBeTruthy();

    zip.setValue("BL31E9")
    errors = zip.errors || {}
    expect(errors['pattern']).toBeFalsy();

   });

});

