import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';
import { RESTService } from '../restservice.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  listPatients: any;
  appointments : any;


  constructor(private localStorageService: LocalStorageService, private logger: LogService, private router: Router , private  restService:  RESTService ) { 
    var key = this.localStorageService.get('key');
    if(key == 'patient_logged_in')
    {
      this.getPatientDetails();
      this.getAppointmentbyPatientID(this.listPatients.patient_id)
    }
    else
    {
      alert("Please Login");
      this.router.navigate(['/login']);
    }
  }

  ngOnInit() {
  }

  getPatientDetails(){
    this.listPatients = this.localStorageService.get('patient_object');
  }

  getAppointmentbyPatientID(patient_id : string)
  {
    this.restService.getAppointmentByPatientID(patient_id).subscribe((response:Response) => {
     this.appointments = response;
    });

  }

  clickMethod(appointment:any) {
    if(confirm("Are you sure to delete this appointment?")) {
        
      this.restService.deleteAppointment(appointment.appointment_id).subscribe((response:Response) => {
        alert("Appointment successfully deleted")
        this.localStorageService.set('action','delete');
        this.router.navigate(['/dummy']);
       });
   

    }
  }

  
  
 

}
