import { Component, OnInit, NgZone } from '@angular/core';
import { TrainingService } from 'src/app/services/training/training.service';
import { UtilService } from 'src/app/services/util/util.service';
import { NavController, Platform } from '@ionic/angular';
import { TrainingModel } from 'src/app/models/TrainingModel';
import { GlobalConstants } from 'src/app/models/GlobalConstants';
import { LoginService } from 'src/app/services/login/login.service';

declare var RazorpayCheckout:any;
declare var Razorpay:any;
@Component({
  selector: 'app-learn-music',
  templateUrl: './learn-music.page.html',
  styleUrls: ['./learn-music.page.scss'],
})
export class LearnMusicPage implements OnInit {

  public tab = 'inst';
  

  constructor(public ts : TrainingService, public util : UtilService, private nav : NavController, public ls: LoginService, 
              private zone : NgZone, private platform : Platform) { }

  ngOnInit() {
    this.loadAllTrainings();
  }

  private loadAllTrainings() {
    this.util
      .showLoader()
      .then(() => {
        this.ts
          .getAllTrainings()
          .subscribe(
            res => {
              this.ts.trainings.next(res);
              this.util.hideLoader();
            },
            err => {
              this.util.hideLoader();
            }
          );
      });
  }

  subscribeCourse(course : TrainingModel){
    this.createSubscriptionOrder(course);
  }

  open(course : TrainingModel){
    this.nav.navigateForward(`/view-playlist/${course.trainingId}`);
  }

  createSubscriptionOrder(training: TrainingModel){
    this.util.showLoader().then(() => {
      this.ts
          .createSubscriptionOrder(training)
          .subscribe(
            res => {
              this.payWithRazorpay(training, res['orderId']);
              this.util.hideLoader();
            },
            err => {
              this.util.errorMsg('Error occurred while processing your request. PLease try again later.');
              this.util.hideLoader();
            }
          )
    });
  }

  loadTrainings(event){}

  payWithRazorpay(training: TrainingModel, orderId) {
    var options = {
      description: `Payment For : ${training.trainingId}. Order Id: ${orderId}`,
      image: 'https://i.imgur.com/3g7nmJC.png',
      currency: "INR", // your 3 letter currency code
      key: GlobalConstants.razorPkey, // your Key Id from Razorpay dashboard
      amount: (parseFloat(training.subscriptionAmount)), // Payment amount in smallest denomiation e.g. cents for USD
      name: 'Razorpay',
      order_id: orderId,
      prefill: {
        contact: this.ls.getUser().username,
        name: this.ls.getFullName()
      },
      theme: {
        color: '#3880ff'
      },
      modal: {
        ondismiss: () => {
          this.util.success('Subscription payment has been Cancelled.');
          this.ts
              .processPaymentError(orderId, 'user.cancelled', 'User cancelled the payment')
              .subscribe(
                  res => {
                    console.log('error logged successfully');
                  },
                  err => this.util.errorHandler(err)
              )
        }
      },
      handler : response => {
        this.zone.run(
          () => {
            this.ts
            .processPayment(orderId, response.payment_id)
            .subscribe(
                res => {
                  this.util.success('Thank You! We have successfully received your Payment.');
                  this.nav.navigateForward(`/view-playlist/${training.trainingId}`);
                  this.loadAllTrainings();
                },
                err => this.util.errorHandler(err)
            )
          }
        );
      }
    };

    var successCallback = (payment_id) => {
      this.zone.run(
        () => {
          this.ts
          .processPayment(orderId, payment_id)
          .subscribe(
              res => {
                this.util.success('Thank You! We have successfully received your Payment.');
                this.nav.navigateForward(`/view-playlist/${training.trainingId}`);
                this.loadAllTrainings();
              },
              err => this.util.errorHandler(err)
          )
        }
      )
    };
    var cancelCallback = (error) => {
      this.util.errorMsg('Error occured while processing your payment. PLease try again after some time.');
      console.log('error in payment --> ', error, error.description + ' (Error ' + error.code + ')');
      this.ts
          .processPaymentError(orderId, error.code, error.description)
          .subscribe(
              res => {
                console.log('error logged successfully');
              },
              err => this.util.errorHandler(err)
          )
        }
    
    if(this.platform.is('cordova')){
      RazorpayCheckout.open(options, successCallback, cancelCallback);
    } else{
      var rzp1 = new Razorpay(options);
      rzp1.on('payment.failed', cancelCallback);
      rzp1.on('payment.success', successCallback);
      rzp1.open();
    }
  }

  getSubscribedTrainings(){
    return this.ts.trainings.getValue().filter(t => t.isSubscribed);
  }

  getTrainingsByCategoty(category : string){
    return this.ts.trainings.getValue().filter(t => t.category == category);
  }

}
