import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';
import { RESTService } from '../restservice.service';

@Component({
  selector: 'app-feedback-home',
  templateUrl: './feedback-home.component.html',
  styleUrls: ['./feedback-home.component.css']
})
export class FeedbackHomeComponent implements OnInit {

  listFeedback: any;
  doctorDetails: any;
  doctor_id: any;
  feedbacks: any;

  constructor(private localStorageService: LocalStorageService, private logger: LogService, private router: Router , private  restService:  RESTService ) { 
    this.getDoctorDetails();
    this.doctor_id = this.doctorDetails.doctor_id;
    this.restService.getFeedbackByID(this.doctor_id).subscribe((response:Response) => {
      this.listFeedback = response;
     });
  }

  ngOnInit() {
  }

  getDoctorDetails(){
    this.doctorDetails = this.localStorageService.get('doctor_object');
  }

}
