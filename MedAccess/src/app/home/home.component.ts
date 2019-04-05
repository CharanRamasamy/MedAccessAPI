import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { RESTService } from '../restservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items: Array<any> =[];
  listPattern: any;

  constructor(private localStorageService: LocalStorageService, private logger: LogService, private  restService:  RESTService) {
    console.log(this.localStorageService.get('key'));
    this.items = [
      {name: '/assets/images/Doctor_carousel1.jpg' },
      {name: '/assets/images/black-and-white-blood-pressure-blood-pressure-monitor-208556.jpg' },
      {name: '/assets/images/Doctor_carousel3.jpg' },
      {name: '/assets/images/Doctor_carousel2.jpg' }
    ]
   }

  //setEmailPattern(value: string){
    //this.restService.email_pattern = value;
  //}

   onLoadGetBusinessLogic()
   {
   
    //var value: string;
    //private value: String ="";
     this.restService.getBusinessLogic().subscribe((response: Response) => {
   
       this.listPattern = response;
       console.log(this.listPattern[0].email_pattern);
       this.restService.emailPattern = this.listPattern[0].email_pattern;
       this.restService.passwordPattern = this.listPattern[0].password_pattern;
       this.restService.phonePattern = this.listPattern[0].phone_pattern;
       this.restService.suitePattern = this.listPattern[0].suite_pattern;
       this.restService.zipcodePattern = this.listPattern[0].zipcode_pattern;

       //console.log(value);
   });
   
     
   
   }

  ngOnInit() {
    this.onLoadGetBusinessLogic();
  }

}
