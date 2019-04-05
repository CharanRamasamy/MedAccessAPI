import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RESTService } from '../restservice.service';
import { LogService } from '../log.service';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-searchresult',
  templateUrl: './searchresult.component.html',
  styleUrls: ['./searchresult.component.css']
})
export class SearchresultComponent implements OnInit {

  private searchterm: string = "";
  listDoctors: any;

/*   getdata() {
    return this.restService.serviceData;
}
setdata(value: string) {
    this.restService.serviceData = value;
} */

  constructor(private router: Router, private activatedroute: ActivatedRoute, private  restService:  RESTService, private localStorageService: LocalStorageService) { 
    this.activatedroute.params.subscribe(params =>{
      this.searchterm = params['searchterm'];
      this.displaySearchResult(this.searchterm);

    });
  }

  ngOnInit() {
  }

  displaySearchResult(searchterm: string) {
    this.restService.getDoctorByName(searchterm).subscribe((response:Response) => {

      this.listDoctors = response;
      if(!this.listDoctors[0]) {
    
     
      this.router.navigate(['home']);
      alert("No Results found.");
      }

  });

    

  }

  giveFeedback(doctor: any){
    if(this.localStorageService.get('key') == "patient_logged_in")
    {
      this.localStorageService.set('doctor_object',doctor);
      console.log(doctor.doctor_id+"----");
      this.router.navigate(['feedback']);
    }
    else if(this.localStorageService.get('key') == "doctor_logged_in")
    {
      alert("Hello Doctor! You have to open a patient account for yourself to provide a Feedback :)");
    }
    else{
      alert("Please Login to provide Feedback");
      this.localStorageService.set('doctor_object',doctor);
      this.localStorageService.set('nextPage','feedback');
      this.router.navigate(['login']);
    }
  }
  
  bookAppointment(doctor: any){
    if(this.localStorageService.get('key') == "patient_logged_in")
    {
      this.localStorageService.set('doctor_object',doctor);
      this.router.navigate(['bookappointment']);
    }
    else if(this.localStorageService.get('key') == "doctor_logged_in"){
      alert("Hello Doctor! You have to open a patient account for yourself to book an Appointment :)");
    }
    else{
      alert("Please Login to book appointment");
      this.localStorageService.set('nextPage','bookappointment');
      this.router.navigate(['login']);
    }
  }
}
