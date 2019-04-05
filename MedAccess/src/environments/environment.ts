// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  "production": false,


  "createPatientURL": 'https://medaccessapi.herokuapp.com/MedAccess/patient',
  "getPatientByMailURL": 'https://medaccessapi.herokuapp.com/MedAccess/patient/mail',
  "getDoctorByMailURL": 'https://medaccessapi.herokuapp.com/MedAccess/doctor/mail',
  "getDoctorByNameURL": 'https://medaccessapi.herokuapp.com/MedAccess/doctorsearch',
  "getDoctorByIdUrl": 'https://medaccessapi.herokuapp.com/MedAccess/doctor',
  //"Url":'https://medaccessapi.herokuapp.com/MedAccess',
  "apiUrlAppointmentNotification":'https://medaccessapi.herokuapp.com/MedAccess/appointmentnotification',
  "apiUrlDeleteAppointment":'https://medaccessapi.herokuapp.com/MedAccess/deleteappointment',
   "addDoctorURL":'https://medaccessapi.herokuapp.com/MedAccess/doctor',
  "apiUrlFeedback":'https://medaccessapi.herokuapp.com/MedAccess/feedback',
  "getFeedbackById": 'https://medaccessapi.herokuapp.com/MedAccess/feedback',
  //"apiUrl": 'https://medaccessapi.herokuapp.com/
  "addAppointmentURL" : 'https://medaccessapi.herokuapp.com/MedAccess/appointment',
  "appointmentURL" : 'https://medaccessapi.herokuapp.com/MedAccess/appointment',
  "getAppointmentByPatientIdURL" : 'https://medaccessapi.herokuapp.com/MedAccess/appointmentbypatient',
  //"getBusinessLogicURL" : 'https://medaccessapi.herokuapp.com/MedAccess/businesslogic'
  "getBusinessLogicURL" : 'https://medaccessapi.herokuapp.com/MedAccess/businesslogic'
  //"appointmenthistoryURL":'http://medaccessapi.herokuapp.com/MedAccess/appointment'

};

/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
