import { Injectable } from '@angular/core';
import { GlobalConstants } from 'src/app/models/GlobalConstants';
import { UtilService } from '../util/util.service';
import { UserModel } from 'src/app/models/UserModel';
import { LoginService } from '../login/login.service';
import { BehaviorSubject } from 'rxjs';

declare var RazorpayCheckout:any;

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  public paymentId : BehaviorSubject<string> = new BehaviorSubject<string>('');
  public paymentError : BehaviorSubject<any> = new BehaviorSubject<any>('');

  constructor(private util: UtilService, private ls : LoginService) { }

  getPaymentId() : BehaviorSubject<string>{
    return this.paymentId;
  }

  getPaymentError() : BehaviorSubject<any>{
    return this.paymentError;
  }

  payWithRazorpay(amount : string, desc : string) {
    var options = {
      description: desc,
      image: 'https://i.imgur.com/3g7nmJC.png',
      currency: "INR", // your 3 letter currency code
      key: GlobalConstants.razorPkey, // your Key Id from Razorpay dashboard
      amount: amount, // Payment amount in smallest denomiation e.g. cents for USD
      name: 'Razorpay',
      prefill: {
        email: 'test@razorpay.com',
        contact: '9990009991',
        name: 'Razorpay'
      },
      theme: {
        color: '#3880ff'
      },
      modal: {
        ondismiss: () => {
          this.util.success('Payment has been Cancelled.');
        }
      }
    };

    var successCallback = (payment_id) => {
      this.util.success('Processing the payment in our system. Please save the order ID for future reference : ' + payment_id);
      console.log("payment_id -->", payment_id);
      this.getPaymentId().next(payment_id);
    };

    var cancelCallback = (error) => {
      this.util.errorMsg('Error occured while processing your payment. PLease try again after some time.');
      console.log('error in payment --> ', error, error.description + ' (Error ' + error.code + ')');
      this.getPaymentError().next(error);
    };

    RazorpayCheckout.open(options, successCallback, cancelCallback);
  }
}
