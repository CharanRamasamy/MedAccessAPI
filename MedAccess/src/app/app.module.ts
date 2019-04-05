import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { FlexLayoutModule } from "@angular/flex-layout";
import { AppRoutingModule } from './/app-routing.module';
import { FeedbackComponent } from './feedback/feedback.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { ErrorComponent } from './error/error.component';
import { Ng2CarouselamosModule } from 'node_modules/ng2-carouselamos';
import { HttpClientModule} from '@angular/common/http';
import {InterceptorModule} from './interceptor.module';
import { MatInputModule } from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatChipsModule} from '@angular/material/chips';
import { SearchbarcomponentComponent } from './searchbarcomponent/searchbarcomponent.component';
import { SearchresultComponent } from './searchresult/searchresult.component';
import {MatSelectModule} from '@angular/material/select';
import {MatExpansionModule} from '@angular/material/expansion';
import { LocalStorageModule } from 'angular-2-local-storage';
import { BarRatingModule } from "ngx-bar-rating";

import { DoctorHomeComponent } from './doctor-home/doctor-home.component';

import { BookappointmentComponent } from './bookappointment/bookappointment.component';
import {MatRadioModule} from '@angular/material/radio';
import { RegisterHomeComponent } from './register-home/register-home.component';
import { DoctorRegisterComponent } from './doctor-register/doctor-register.component';
import { DummyComponent } from './dummy/dummy.component';
import { FeedbackHomeComponent } from './feedback-home/feedback-home.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FeedbackComponent,
    RegisterComponent,
    LoginComponent,
    LogoutComponent,
    HistoryComponent,
    HomeComponent,
    ErrorComponent,
    DoctorHomeComponent,
    SearchbarcomponentComponent,
    SearchresultComponent,
    BookappointmentComponent,
    RegisterHomeComponent,
    DoctorRegisterComponent,
    DummyComponent,
    FeedbackHomeComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,
    AppRoutingModule,
    Ng2CarouselamosModule,
    HttpClientModule,
    InterceptorModule,
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatChipsModule,
    MatSelectModule,
    MatExpansionModule,
    BarRatingModule,
    MatInputModule,
    MatRadioModule,

    LocalStorageModule.withConfig({
      prefix: 'first-app',
      storageType: 'localStorage'
  }),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
