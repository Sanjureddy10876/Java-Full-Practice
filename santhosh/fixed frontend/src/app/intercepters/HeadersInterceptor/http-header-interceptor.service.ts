import { Injectable } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserModel } from 'src/app/models/UserModel';
import { UtilService } from 'src/app/services/util/util.service';

@Injectable({
  providedIn: 'root'
})
export class HttpHeaderInterceptorService implements HttpInterceptor{

  constructor(public loginService : LoginService, public util: UtilService) { 

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with jwt token if available
    console.log('[HttpHeaderInterceptor] Inside Interceptor before --> ', request);
    //this.util.showLoader();
    let currentUser : UserModel = this.loginService.getUser();
    if (currentUser && !(request.url.includes("/oauth/token") || request.url.includes('/check_token'))) {
      request = request.clone({
        headers: request.headers.append('Authorization', `Bearer ${currentUser.access_token}`)
      });
    }
    if(!(currentUser && currentUser.username) && (request.url.includes("/oauth/token") || request.url.includes('/check_token')) ){
      if(!request.headers.get('Authorization')){
        request = request.clone({
          withCredentials: false,
          headers: request.headers.append('Authorization', `Basic ` + btoa(`mobile:pin`))
        });
      }
    }
    return next.handle(request);
  }
}
