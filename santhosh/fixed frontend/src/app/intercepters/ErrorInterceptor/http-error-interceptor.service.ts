import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from "rxjs";
import { catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ErrorModel } from 'src/app/models/ErrorModel';
import { UtilService } from 'src/app/services/util/util.service';
import { LoginService } from 'src/app/services/login/login.service';
import { Storage } from '@ionic/storage';
import { NavController } from '@ionic/angular';

@Injectable({
    providedIn: 'root'
})
export class HttpErrorInterceptorService implements HttpInterceptor {
    public retryCount = 0;
    constructor(public router: Router, private util: UtilService, private storage: Storage, private ls: LoginService, private nav: NavController) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(
            tap(evt => {
                if (evt instanceof HttpResponse) {
                    console.log('[HttpErrorInterceptor] response ->', evt);
                    if (evt.status >= 200 && evt.status < 300) {
                        //this.util.hideLoader();
                    }
                }
            }),
            catchError((error) => {
                let errorModel: ErrorModel = new ErrorModel();
                errorModel.msg = 'An error occured while processing your request. Please check your network connection or try again.';
                errorModel.timestamp = new Date().toDateString();
                console.error('[HttpErrorInterceptor] Error occured', error);
                if (error instanceof HttpErrorResponse) {
                    if ((error.error instanceof ErrorEvent) || (error.error instanceof ProgressEvent)) {
                        console.error("[HttpErrorInterceptor] Error Event", error);
                    } else {
                        console.error(`[HttpErrorInterceptor] error status : ${error.status} ${error.statusText}`);
                        switch (error.status) {
                            case 401:      //login
                                errorModel = error.error;
                                this.nav.navigateRoot("login").then(
                                    () => {
                                        if (errorModel.msg == 'unauthorized'
                                            || errorModel.msg == 'invalid_token'
                                            || errorModel.msg == 'token_expired'
                                            || errorModel['error'] == 'invalid_token'
                                            || errorModel['error'] == 'token_expired') {
                                            errorModel.msg = 'Session Expired. Please login again.';
                                        }
                                        this.ls.logout();
                                        this.util.errorHandler(errorModel);
                                    }
                                );
                                break;
                            case 403:     //forbidden
                                this.util.errorHandler(errorModel);
                                this.nav.navigateRoot("unauthorized");
                                break;
                            case 404:     //Not Found
                            case 422:     //Unprocessable Entity
                                errorModel = error.error;
                                break;
                            default:
                                errorModel = error.error ? error.error : errorModel;
                                break;
                        }
                    }
                } else {
                    console.error("[HttpErrorInterceptor] some thing else happened", error);
                }
                //this.util.hideLoader();
                return throwError(errorModel);
            })
        );
    }

    refreshTokenAndRetryFailedRequest(req: HttpRequest<any>, next: HttpHandler) {
        let errorModel: ErrorModel = new ErrorModel();
        errorModel.msg = 'Session Expired. Please login again.';
        errorModel.timestamp = new Date().toDateString();
        /*console.error('Error occured');
        let authToken = await this.storage.get('access_token');
        let refreshToken = await this.storage.get('refresh_token');
        if(this.retryCount > 1){
            return throwError(errorModel);
        }
        this.retryCount++;
        let isTokenRefreshed = await this.ls.refreshToken(refreshToken)
                                             .then(async res => {
                                                let user : any = this.ls.getUser();
                                                user.access_token = res.access_token;
                                                user.refresh_token = res.refresh_token;
                                                console.log('Before Values -->', authToken, refreshToken);
                                                await this.ls.setUser(user).then(res => res);
                                                console.log('After Values -->', this.ls.getUser().access_token, this.ls.getUser().refresh_token);
                                                this.retryCount = 0;
                                                return true;
                                             })
                                             .catch(err => {
                                                console.log('Error occurred while refreshing the token', err);
                                                return false;
                                             });
        if(isTokenRefreshed){
            req = req.clone();
            return next.handle(req);
        }*/



        return errorModel;
    }
}
