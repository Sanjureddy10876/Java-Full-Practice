import { Injectable } from '@angular/core';
import { GlobalConstants } from 'src/app/models/GlobalConstants';
import { AlertController, LoadingController, ToastController } from '@ionic/angular';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AbstractControl, ValidatorFn, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  options = {};

  loading  = null;
  
  constructor(public alertController: AlertController, public httpClient: HttpClient, public lc : LoadingController, public toastController: ToastController) { 
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
      "Accept": 'application/json'});
    this.options = { headers: headers };
  }

  async presentToast(msg : string) {
    const toast = await this.toastController.create({
      message: msg,
      duration: 1000,
      position: 'middle'
    });
    toast.present();
  }

  baseUrl() : string{
    return GlobalConstants.baseUrl;
  }

  async presentAlert(header, subMsg, errDtl) {
    const alert = await this.alertController.create({
      header: header,
      subHeader: subMsg,
      message: errDtl,
      buttons: ['OK']
    });

    await alert.present();
  }

  error(header, subMsg, errDtl){
    this.presentAlert(header, subMsg, errDtl);
  }

  errorMsg(errDtl){
    this.presentAlert('Error', '', errDtl);
  }

  success(msg){
    this.presentAlert('Success', '', msg);
  }

  info(msg){
    this.presentAlert('Info', '', msg);
  }

  get<T>(endPoint : string, options?: {
      headers?: HttpHeaders | {
          [header: string]: string | string[];
      };
      observe?: 'body';
      params?: HttpParams | {
          [param: string]: string | string[];
      };
      reportProgress?: boolean;
      responseType?: 'json';
      withCredentials?: boolean;
  }): Observable<T>{
    return this.httpClient.get<T>(this.getFullUrl(endPoint), options != null ? options : this.options);
  }

  post<T>(url: string, body: any | null, options?: {
      headers?: HttpHeaders | {
          [header: string]: string | string[];
      };
      observe?: 'body';
      params?: HttpParams | {
          [param: string]: string | string[];
      };
      reportProgress?: boolean;
      responseType?: 'json';
      withCredentials?: boolean;
    }): Observable<T> {
    return this.httpClient.post<T>(this.getFullUrl(url), JSON.stringify(body), options != null ? options : this.options);
  }

  postFormData<T>(url: string, body: any | null, options?: {
    headers?: HttpHeaders | {
        [header: string]: string | string[];
    };
    observe?: 'body';
    params?: HttpParams | {
        [param: string]: string | string[];
    };
    reportProgress?: boolean;
    responseType?: 'json';
    withCredentials?: boolean;
  }): Observable<T> {
    return this.httpClient.post<T>(this.getFullUrl(url), body, options);
  }

  delete<T>(url: string, options?: {
    headers?: HttpHeaders | {
        [header: string]: string | string[];
    };
    observe?: 'body';
    params?: HttpParams | {
        [param: string]: string | string[];
    };
    reportProgress?: boolean;
    responseType?: 'json';
    withCredentials?: boolean;
  }): Observable<T> {
    return this.httpClient.delete<T>(this.getFullUrl(url), options != null ? options : this.options);
  }

  errorHandler(error){
    console.error('error ---->', error);
    if(error.msg){
      this.errorMsg(error.msg);
    }else if(error.message){
      this.errorMsg(error.message);
    }
    //this.hideLoader();
  }

  getFullUrl(endPoint : string){
    return this.baseUrl() + endPoint;
  }

async showLoader() {
    this.loading = await this.lc.create({
      message: 'Please wait...'
    });

    this.loading.onDidDismiss((data) => {
      this.loading = null;
    });

    await this.loading.present();
  }

  async hideLoader(){
    this.lc.dismiss();
  }

  /**
   * @decription This method will find difference of dates by specified interval
   * @author Prerak Tiwari
   * @version 1.0
   * @param fromDate in miliseconds
   * @param todate in miliseconds
   * @param interval : valid values are --> "years", "months", "weeks", "days", "hours", "minutes", "seconds"
   * @returns difference of date as per interval specified.
   **/
  findDifferenceIndate(fromDate,todate,interval){
    let second=1000, minute=second*60, hour=minute*60, day=hour*24, week=day*7;
    let timediff = todate - fromDate;
    
    if (isNaN(timediff)) 
      return NaN;
    
    switch (interval) {
        case "years": return todate.getFullYear() - fromDate.getFullYear();
        case "months": return (
            ( todate.getFullYear() * 12 + todate.getMonth() )
            -
            ( fromDate.getFullYear() * 12 + fromDate.getMonth() )
        );
        case "weeks"  : return Math.round(timediff / week);
        case "days"   : return Math.round(timediff / day); 
        case "hours"  : return Math.round(timediff / hour); 
        case "minutes": return Math.round(timediff / minute);
        case "seconds": return Math.round(timediff / second);
        default: return undefined;
    }
  }

  /**
   * @decription This method will return date in ddMMyyyy format.
   * @author Prerak Tiwari
   * @version 1.0
   * @returns string
   **/
  getDateInDDMMYYYYFormat(date : Date){
    let dd = date.getDate();
    let MM = date.getMonth() + 1;
    let yyyy = date.getFullYear();
    
    let dateToReturn = dd + '/' + MM + '/' + yyyy;
    return dateToReturn;
  }

  /**
   * @decription This method will return Date object.
   * @author Prerak Tiwari
   * @version 1.0
   * @param value : date separated with '-'
   * @returns Date
   **/
  getEnteredDate(value){
    var dateArray = value.split("-");
    var dd = parseInt(this.prepedZeroIfSingleDigit(dateArray[2]));
    var MM = parseInt(this.prepedZeroIfSingleDigit(dateArray[1])) - 1;
    var yyyy = parseInt(this.prepedZeroIfSingleDigit(dateArray[0]));
    return new Date(yyyy,MM,dd);
  }

  getEnteredDateDDMMYYYY(value){
    var dateArray = value.split("-");
    var dd = parseInt(this.prepedZeroIfSingleDigit(dateArray[2]));
    var MM = parseInt(this.prepedZeroIfSingleDigit(dateArray[1]));
    var yyyy = parseInt(this.prepedZeroIfSingleDigit(dateArray[0]));

    let dateToReturn = dd + '/' + MM + '/' + yyyy;
    return dateToReturn;
  }

  prepedZeroIfSingleDigit(number){
    number = number + GlobalConstants.blankString;
    if(number.length < 2){
      number = "0" + number;
    }
    return number;
  }

  /**
  * @decription This method check if entered number is valid or not.
  * @author Prerak Tiwari
  * @version 1.0
  * @returns true : number is valid </br> false : number is invalid
  */
  validateNumber(number) {
    var reg = new RegExp("^[0-9]*$"); 
    return reg.test(number);
  }

  /**
  * @decription This method check if entered number is valid or not.
  * @author Prerak Tiwari
  * @version 1.0
  * @returns true : number is valid </br> false : number is invalid
  */
  validateEmail(email) {
    var reg = new RegExp('/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/'); 
    return reg.test(email);
  }

  setValidation(control : AbstractControl, newValidator : ValidatorFn  | ValidatorFn[] | null){
    control.setValidators(newValidator);
    control.updateValueAndValidity();
  }

  clearValidation(control : AbstractControl){
    control.clearValidators();
    control.updateValueAndValidity();
  }

  setRequiredValidator(control : AbstractControl){
    this.setValidation(control, Validators.required);
  }

}
