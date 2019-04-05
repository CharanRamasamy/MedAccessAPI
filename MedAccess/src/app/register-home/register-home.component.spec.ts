import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterHomeComponent } from './register-home.component';

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


describe('RegisterHomeComponent', () => {

  let component: RegisterHomeComponent;
  let fixture: ComponentFixture<RegisterHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({

      imports: [HttpClientModule , MatFormFieldModule, MatInputModule, MatButtonModule, BrowserAnimationsModule, MatCardModule, FormsModule , ReactiveFormsModule, MatSelectChange, MatExpansionModule ],
      declarations: [ RegisterHomeComponent ]
    
    })
    .compileComponents();
  }));

  beforeEach(() => {

    fixture = TestBed.createComponent(RegisterHomeComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();
  
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('form invalid when empty', () => {
    expect(component.UserTypeCheck.valid).toBeFalsy();
  });


  it('User type field validatity', () => {
    let selectUser = component.UserTypeCheck.controls['selectUser']
    expect(selectUser.valid).toBeFalsy();
  });


  it('Select User field check', () => {
    let errors = {};
    let selectUser = component.UserTypeCheck.controls['selectUser'] 
 
    errors = selectUser.errors || {}
    expect(errors['required']).toBeTruthy();

    selectUser.setValue("Test")
    errors = selectUser.errors || {}
    expect(errors['required']).toBeFalsy();

   });


});
