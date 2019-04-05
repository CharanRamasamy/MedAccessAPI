import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { LogService } from '../log.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dummy',
  templateUrl: './dummy.component.html',
  styleUrls: ['./dummy.component.css']
})
export class DummyComponent implements OnInit {

  constructor(private localStorageService: LocalStorageService,private router: Router) { 
    if(this.localStorageService.get('action') == 'delete'){
      console.log("IN dummy");
      this.router.navigate(['/history']);
    } else if(this.localStorageService.get('action') == 'cancel'){
      console.log("IN dummy");
      this.router.navigate(['/doctor-home']);
    }
  }

  ngOnInit() {
  }

}
