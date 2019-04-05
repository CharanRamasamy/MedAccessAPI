import { Observable } from 'rxjs/Observable';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { DatasharingService } from '../datasharing.service';


@Component({
  selector: 'app-searchbarcomponent',
  templateUrl: './searchbarcomponent.component.html',
  styleUrls: ['./searchbarcomponent.component.css']
})
export class SearchbarcomponentComponent implements OnInit {

 // patient_authenticated$: Observable<boolean>;
  patient_authenticated: boolean;
  isUserLoggedIn: boolean;
  isDoctorLoggedIn: boolean;
  isPatientLoggedIn: boolean;
  searchterm: string = "";

  constructor(private router: Router,private localStorageService: LocalStorageService, private logger: LogService, private dataSharingService: DatasharingService) {
    this.dataSharingService.isUserLoggedIn.subscribe( value => {
      this.isUserLoggedIn = value;
  });
  this.dataSharingService.isDoctorLoggedIn.subscribe( value => {
    this.isDoctorLoggedIn = value;
});
this.dataSharingService.isPatientLoggedIn.subscribe( value => {
  this.isPatientLoggedIn = value;
});
    
    if(this.localStorageService.get('key') == 'patient_logged_in')
    {
      console.log("111111");
      this.patient_authenticated = true;
      //this.patient_authenticated$ = this.authService.isLoggedIn;
     // console.log(this.patient_authenticated);
    }
    else
    {
      console.log("222222");
      this.patient_authenticated = false;
      //console.log(this.patient_authenticated);
    }
  }

  ngOnInit() {
    if(this.localStorageService.get('key') == 'patient_logged_in')
    {
      console.log("111111");
      this.patient_authenticated = true;
      //this.patient_authenticated$ = this.authService.isLoggedIn;
     // console.log(this.patient_authenticated);
    }
    else
    {
      console.log("222222");
      this.patient_authenticated = false;
      //this.patient_authenticated$ = Observable.of(false);
      //console.log(this.patient_authenticated$);
    }
  }

  doSearch() {
    this.router.navigate(['searchresult', {searchterm: this.searchterm}]);
  }

}
