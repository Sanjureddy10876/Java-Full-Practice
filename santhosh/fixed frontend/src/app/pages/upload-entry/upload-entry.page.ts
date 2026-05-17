import { Component, OnInit, NgZone } from '@angular/core';
import { ContestModel } from 'src/app/models/ContestModel';
import { CompetitionService } from 'src/app/services/competition/competition.service';
import { UtilService } from 'src/app/services/util/util.service';
import { ActivatedRoute } from '@angular/router';
import { EnrollmentsModels } from 'src/app/models/EnrollmentsModels';
import { PaymentService } from 'src/app/services/payment/payment.service';
import { GlobalConstants } from 'src/app/models/GlobalConstants';
import { MasterDataService } from 'src/app/services/master/master-data.service';
import { PopoverController, IonItemSliding, AlertController, Platform } from '@ionic/angular';
import { ViewVideoPage } from '../popovers/view-video/view-video.page';
import { LoginService } from 'src/app/services/login/login.service';
import { SubmittedEntriesModel } from 'src/app/models/SubmittedEntriesModel';

declare var RazorpayCheckout:any;
declare var Razorpay:any;
@Component({
  selector: 'app-upload-entry',
  templateUrl: './upload-entry.page.html',
  styleUrls: ['./upload-entry.page.scss'],
})
export class UploadEntryPage implements OnInit {
  display = false;
  videoToPlay = null;
  winnerList : SubmittedEntriesModel[] = [];
  opt = "all";
  items = [];
  compId;
  competition : ContestModel;
  enrollments : EnrollmentsModels[] = [];
  fileId;
  submittedEntryId;
  entries : SubmittedEntriesModel[] = [];
  isSearchInProgress = false;
  showError=false;
  isShortlistingInProgress = false;
  constructor(private compSrvs : CompetitionService, public util: UtilService, private activatedRoute: ActivatedRoute, 
    private platform : Platform, private zone : NgZone, public mst : MasterDataService, public popup: PopoverController,
    public ls: LoginService, public alertController: AlertController) { 
    //this.setupPayment();
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.compId = params['compId'];
      this.compSrvs
          .getCompetitionDetails(this.compId)
          .subscribe(
            res => {
              this.competition = res;
              this.getAllEnrollments();

              if(this.ls.hasFunction('FUNC_VIEW_ADMIN_MENU') && this.competition && this.competition.isWinnerAnnounced != '1'){
                this.getAllEntries(this.competition.competitionId);
              }
            },
            err => this.util.errorHandler(err)
          );
    });
  }

  updateEnrollmentStatus(enrollment : EnrollmentsModels){
    if(this.competition.competitionId == enrollment.competitionId){
      this.competition.isUserEnrolled = true;
      this.submittedEntryId = enrollment.submittedEntryId;
    }
  }

  getAllEnrollments(){
    this.compSrvs
        .getAllEnrolments()
        .subscribe(
          res => {
            this.enrollments = res;
            if(res){
              res.forEach(e => this.updateEnrollmentStatus(e))
            }
          },
          err => this.util.errorHandler(err))
  }

  enroll(comp : ContestModel){
    if(comp.isSubscriptionRequired == '0'){
      this.compSrvs
        .enrollInComp(comp.competitionId)
        .subscribe(
          res => {
            this.getAllEnrollments();
            this.util.success('You successfully enrolled into the competition. Now upload your singing video.');
          },
          err => this.util.errorHandler(err)
        )
    }else if(comp.isSubscriptionRequired == '1'){
      this.createSubscriptionOrder(comp);
    }
    
  }

  isEntrySubmitted(compId : string){
    let enrolments : EnrollmentsModels[] = this.enrollments.filter(e => e.competitionId == compId);
    if(enrolments != undefined && enrolments.length > 0){
      let er = enrolments[0];
      if(er.fileUploaded && er.fileId != null){
        return true;
      }
    }
    return false;
  }

  getFileId(compId : string){
    let enrolments : EnrollmentsModels[] = this.enrollments.filter(e => e.competitionId == compId);
    if(enrolments != undefined && enrolments.length > 0){
      let er = enrolments[0];
      if(er.fileUploaded && er.fileId != null){
        return er.fileId;
      }
    }
    return '';
  }

  uploadEntry(){
    if(this.fileId){
      this.compSrvs
          .attachFileToEnrolledCompetition(this.submittedEntryId, this.fileId)
          .subscribe(
            res => {
              this.util.success('Your entry has been uploaded successfully.');
              this.getAllEnrollments();
              this.fileId = null;
            },
            err => this.util.errorHandler(err)
          )
    }
  }

  getAllEntries(compId){
    this.winnerList = [];
    this.showError=false;
    this.entries = [];
    this.isSearchInProgress = true;
    this.compSrvs
        .getAllSubmittedEntries(compId)
        .subscribe(
          res => {
            this.entries = res;
            this.isSearchInProgress = false; 
          },
          err => {
            this.isSearchInProgress = false
            this.showError=true;
          }
        )
  }

  getShortlistedEntries(compId){
    this.winnerList = [];
    this.showError=false;
    this.entries = [];
    this.isSearchInProgress = true;
    this.compSrvs
        .getShortlistedEntries(compId)
        .subscribe(
          res => {
            this.entries = res;
            this.isSearchInProgress = false; 
          },
          err => {
            this.isSearchInProgress = false;
            this.showError=true;
          }
        )
  }

  getWinners(compId){
    this.winnerList = [];
    this.showError=false;
    this.entries = [];
    this.isSearchInProgress = true;
    this.compSrvs
        .getCompetitionWinners(compId)
        .subscribe(
          res => {
            this.entries = res[0].winners;
            this.isSearchInProgress = false; 
          },
          err => {
            this.isSearchInProgress = false;
            this.showError=true;
          }
        )
  }

  markShortlisted(submittedEntryId, item : IonItemSliding){
    this.isShortlistingInProgress = true;
    this.compSrvs
        .markShortlisted(submittedEntryId)
        .subscribe(
          res => {
            this.isShortlistingInProgress = false;
            this.markEntryShortlisted(submittedEntryId);
            item.close();
          },
          err => {
            this.util.errorMsg('Error occurred while processing your request. Please try again later.');
            this.isShortlistingInProgress = false;
          }
        );
  }

  markEntryShortlisted(submittedEntryId){
    let entry : SubmittedEntriesModel = this.entries.filter(e => e.submittedEntriesId + '' == submittedEntryId + '')[0];
    entry.isShortlisted = '1';
  }

  createSubscriptionOrder(comp: ContestModel){
    this.util.showLoader();
    this.compSrvs
        .createSubscriptionOrder(comp)
        .subscribe(
          res => {
            this.payWithRazorpay(comp, res['orderId']);
            this.util.hideLoader();
          },
          err => {
            //this.util.errorMsg('Error occurred while processing your request. PLease try again later.');
            this.util.errorHandler(err);
            this.util.hideLoader();
          }
        )
  }

  payWithRazorpay(comp: ContestModel, orderId) {
    var options = {
      description: `Payment For : ${comp.competitionId}. Order Id: ${orderId}`,
      image: 'https://i.imgur.com/3g7nmJC.png',
      currency: "INR", // your 3 letter currency code
      key: GlobalConstants.razorPkey, // your Key Id from Razorpay dashboard
      amount: (parseFloat(comp.subscriptionPrice)), // Payment amount in smallest denomiation e.g. cents for USD
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
          this.compSrvs
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
            this.compSrvs
            .processPayment(orderId, response.payment_id)
            .subscribe(
                res => {
                  this.util.success('Thank You! We have successfully received your Payment.');
                  this.getAllEnrollments();
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
          this.compSrvs
          .processPayment(orderId, payment_id)
          .subscribe(
              res => {
                this.util.success('Thank You! We have successfully received your Payment.');
                this.getAllEnrollments();
              },
              err => this.util.errorHandler(err)
          )
        }
      );
    };
    var cancelCallback = (error) => {
      this.util.errorMsg('Error occured while processing your payment. PLease try again after some time.');
      console.log('error in payment --> ', error, error.description + ' (Error ' + error.code + ')');
      this.compSrvs
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


  async viewVideo(event, id) {
    this.videoToPlay = id;
    this.display = true;
  }

  expandItem(item): void {
    if (item.expanded) {
      item.expanded = false;
    } else {
      this.entries.map(f=> {
        if (item == f) {
          f.expanded = !f.expanded;
        } else {
          f.expanded = false;
        }
        return f;
      });
    }
  }

  setPosition(event, entry : SubmittedEntriesModel){
    entry.winningPosition = event.target.value;
    entry.winnerDesc = entry.winningPosition;
  }

  setDesc(event, entry : SubmittedEntriesModel){
    entry.winnerDesc = event.target.value;
  }

  setAmount(event, entry : SubmittedEntriesModel){
    entry.priceWon = event.target.value;
  }

  saveWinner(entry : SubmittedEntriesModel){
    if(!entry.winningPosition){
      this.util.errorMsg('Select Winning Position before marking Winner!');
      return;
    }else if(entry.winningPosition == 'O' && (entry.winnerDesc == 'O'  || entry.winnerDesc.trim() == '')){
      this.util.errorMsg('Enter Winning Position before marking Winner!');
      return;
    }
    entry.winnerMarked = true;
    this.winnerList.push(entry);
  }

  getPositionDescription(entry : SubmittedEntriesModel){
    if(entry.winnerDesc == '1'){
      return 'First Position';
    }else if(entry.winnerDesc == '2'){
      return 'Second Position';
    }else if(entry.winnerDesc == '3'){
      return 'Third Position';
    }else{
      return entry.winnerDesc;
    }
  }

  announceWinner(){
    if(this.winnerList.length < 1){
      this.util.errorMsg('Please select winners');
      return;
    }else{
      this.compSrvs
          .markWinners(this.winnerList)
          .subscribe(
            res => {
              this.util.success('Winners declared successfully.');
              this.winnerList = [];
              this.entries = [];
              this.competition.isWinnerAnnounced = '1';
            },
            err => {
              this.util.errorHandler(err);
            }
          );
    }
  }

  async confirmWinner() {
    const alert = await this.alertController.create({
      header: 'Confirm!',
      message: 'Are you sure you want to announce the winner???',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: (blah) => {
            ///cancle
          }
        }, {
          text: 'Okay',
          handler: () => {
            this.announceWinner();
          }
        }
      ]
    });
    await alert.present();
  }
}
