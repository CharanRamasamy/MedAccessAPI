import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookappointmentComponent } from './bookappointment.component';
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
import {MatRadioModule} from '@angular/material/radio';


describe('BookappointmentComponent', () => {
  let component: BookappointmentComponent;
  let fixture: ComponentFixture<BookappointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule , MatFormFieldModule, MatInputModule, MatButtonModule, BrowserAnimationsModule, MatCardModule, FormsModule , ReactiveFormsModule, MatSelectChange, MatExpansionModule, MatRadioModule ],
      declarations: [ BookappointmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookappointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
