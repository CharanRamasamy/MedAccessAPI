import { Injectable, NgModule} from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse, HttpErrorResponse} from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/observable/of';
import { Router } from '@angular/router';
import { LogService } from './log.service';

@Injectable()
export class HttpsRequestInterceptor implements HttpInterceptor {

  constructor(
    private router: Router,
    private logger: LogService
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const dupReq = req.clone({ headers: req.headers.set('Access-Control-Allow-Origin','https://medaccessapi.herokuapp.com/MedAccess/') });
    
    return next.handle(dupReq)
  
    .do((ev: HttpEvent<any>) => {
      if (ev instanceof HttpResponse) {
        console.log('ev in the do: ', ev);
      }
    })
    .catch((response: any) => {
      if (response instanceof HttpErrorResponse) {
        //console.log('response in the catch: ', response);
        this.logger.error('response in the catch: ', response);
        //toaster.error('Unexpected Error', response.message);
        this.router.navigate(['/error']);
      }
  
      this.logger.info('Error in Register Component handled successfully');
      return Observable.of(response);
    });
  }
};
    
@NgModule({
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpsRequestInterceptor, multi: true }
  ]
})
export class InterceptorModule { } 