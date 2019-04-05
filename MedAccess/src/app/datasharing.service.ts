import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatasharingService {
  public isUserLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isDoctorLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isPatientLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor() { }
}
