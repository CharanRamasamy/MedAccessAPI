import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DatasharingService } from '../datasharing.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private localStorageService: LocalStorageService, private logger: LogService, private router: Router, private dataSharingService: DatasharingService) {
    this.localStorageService.clearAll();
    this.dataSharingService.isUserLoggedIn.next(false);
    this.dataSharingService.isDoctorLoggedIn.next(false);
    this.dataSharingService.isPatientLoggedIn.next(false);
    this.logger.info("Logged out");
    this.logger.info("The Local Storage values are cleared");
    this.router.navigateByUrl("/searchbar", {skipLocationChange: false}).then(()=>
    this.router.navigate(["home"]));
   }

  ngOnInit() {

  }

}
