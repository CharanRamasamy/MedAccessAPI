import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FeedbackComponent } from './feedback/feedback.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { ErrorComponent } from './error/error.component';
import {SearchresultComponent} from './searchresult/searchresult.component';
import { LogoutComponent } from './logout/logout.component';
import { SearchbarcomponentComponent } from './searchbarcomponent/searchbarcomponent.component';
import { DummyComponent } from './dummy/dummy.component';
import {DoctorHomeComponent} from './doctor-home/doctor-home.component';
import {RegisterHomeComponent} from './register-home/register-home.component';
import {DoctorRegisterComponent} from './doctor-register/doctor-register.component';
import { FeedbackHomeComponent } from './feedback-home/feedback-home.component';

import { BookappointmentComponent } from './bookappointment/bookappointment.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'history', component: HistoryComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'feedback-home', component: FeedbackHomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'error', component: ErrorComponent },
  { path: 'searchresult', component: SearchresultComponent },
  { path: 'error', component: ErrorComponent },
  {path: 'doctor-home', component: DoctorHomeComponent},
  { path: 'bookappointment', component: BookappointmentComponent },
  { path: 'register-home', component: RegisterHomeComponent },
  { path: 'doctor-register', component: DoctorRegisterComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'searchbar', component: SearchbarcomponentComponent },
  { path: 'dummy', component: DummyComponent }

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }

