import { FormGroup } from '@angular/forms';

 

export class RegistrationValidator {

    static validate(registrationFormGroup: FormGroup) {

        let password = registrationFormGroup.controls.password.value;
        let repeatPassword = registrationFormGroup.controls.reenterpassword.value;
        
 
        if (repeatPassword.length <= 0) {
            
            return null;
        }
 
        if (repeatPassword !== password) {

            return {
                doesNotMatchPassword: true
            };
        }
         
        return null;
 
    }    

}