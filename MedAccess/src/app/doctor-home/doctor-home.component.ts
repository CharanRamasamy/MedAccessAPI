import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RESTService } from '../restservice.service';
import { LocalStorageService } from 'angular-2-local-storage';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Location } from '@angular/common';


@Component({
  selector: 'app-doctor-home',
  templateUrl: './doctor-home.component.html',
  styleUrls: ['./doctor-home.component.css']
})

export class DoctorHomeComponent implements OnInit {


  private doctor_id: string = "";
  listAppointments: any;
  profile: any;
  appointmentForm: FormGroup;
  listDoctors: any;
  //router: any;

  constructor(private location: Location, private router: Router, private localStorageService: LocalStorageService, private activatedroute: ActivatedRoute, private restService: RESTService) {

    this.listDoctors = this.localStorageService.get('doctor_object');
    this.doctor_id = this.listDoctors.doctor_id;
    this.restService.getDoctorById(this.doctor_id).subscribe((response: Response) => {

      this.profile = response;
      this.router = router;

    });

    this.displayAppointmentNotification(this.doctor_id);

  }


  ngOnInit() {


  }

  displayAppointmentNotification(doctor_id: string) {

    this.restService.getAppointmentNotification(doctor_id).subscribe((response: Response) => {

      this.listAppointments = response;

    });

  }



  onSubmit(appointment: any) {


    this.restService.deleteAppointment(appointment.appointment_id).subscribe((response: Response) => {
      this.localStorageService.set('action','cancel');
      this.router.navigate(['dummy']);

    });

  }

}
