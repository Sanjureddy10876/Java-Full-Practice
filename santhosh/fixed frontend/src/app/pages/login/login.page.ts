import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { LoginService } from 'src/app/services/login/login.service';
import { OtpAuthModel } from 'src/app/models/OtpAuthModel';
import { Router } from '@angular/router';
import { UtilService } from 'src/app/services/util/util.service';
import { PopoverController } from '@ionic/angular';
import { OtpPage } from '../popovers/otp/otp.page';
import { UserModel } from 'src/app/models/UserModel';
import { LanguagePage } from '../popovers/language/language.page';
import { MasterDataService } from 'src/app/services/master/master-data.service';
import { MstStateModel } from 'src/app/models/MstStateModel';



@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  private loginErrorString: string;
  public opt: string = 'signin';
  public showProgressBar = false;
  public loginForm : FormGroup;
  public signupForm : FormGroup;
  public enableOtp : boolean = false;
  public enablePassword : boolean = false;
  public enableSignin : boolean = false;
  public states : MstStateModel[] = [];
  userModel: UserModel;

  constructor(public fb : FormBuilder, public loginService : LoginService, public router : Router, public util : UtilService,
              public popup: PopoverController, public mstSrvc : MasterDataService) { 

  }

  enableOtpField(){
    if(!this.enableOtp){
      this.enableOtp = true;
      this.enablePassword = false;
      this.enableSignin = true;
      this.util.setValidation(this.otp, [Validators.required,Validators.minLength(6), Validators.maxLength(6)]);
      this.util.clearValidation(this.signInPassword);
      this.generateOtp(true);
    }
  }

  enablePasswordField(){
    if(!this.enablePassword){
      this.enableOtp = false;
      this.enablePassword = true;
      this.enableSignin = true;
      this.util.setValidation(this.signInPassword, [Validators.required,Validators.minLength(8), Validators.maxLength(15)]);
      this.util.clearValidation(this.otp);
    }
  }

  reset(){
    this.enableOtp = false;
    this.enablePassword = false;
    this.enableSignin = false;
    this.signInPassword.reset();
    this.showProgressBar = false;
    this.otp.reset();
  }

  ngOnInit() {
    this.initilizeLoginForm()
    this.mstSrvc.getState().subscribe(
      data => this.states = data
    )
  }
  
  initilizeLoginForm(){
    this.loginForm = this.fb.group({
      'userId' : ['',Validators.required],
      'otp' : ['',Validators.required],
      'signInPassword' : ['',Validators.required],
    });

    this.signupForm = this.fb.group({
      'signUpMobNo' : ['',Validators.required],
      'password' : ['',Validators.required],
      'firstName' : ['',Validators.required],
      'middleName' : [''],
      'lastName' : ['',Validators.required],
      'dob' : ['',Validators.required],
      'gender' : ['',Validators.required],
      'aadharNo' : ['',Validators.required],
      'aadharPhoto' : ['',Validators.required],
      'country' : ['',Validators.required],
      'state' : [null,Validators.required],
      'city' : ['',Validators.required]
    });
  }

  get signInPassword(){
    return this.loginForm.controls['signInPassword'];
  }

  get userId(){
    return this.loginForm.controls['userId'];
  }

  get otp(){
    return this.loginForm.controls['otp'];
  }

  get signUpMobNo(){
    return this.signupForm.controls['signUpMobNo'];
  }

  get gender(){
    return this.signupForm.controls['gender'];
  }

  get aadharNo(){
    return this.signupForm.controls['aadharNo'];
  }

  get aadharPhoto(){
    return this.signupForm.controls['aadharPhoto'];
  }

  get country(){
    return this.signupForm.controls['country'];
  }

  get state(){
    return this.signupForm.controls['state'];
  }

  get city(){
    return this.signupForm.controls['city'];
  }

  get password(){
    return this.signupForm.controls['password'];
  }

  get firstName(){
    return this.signupForm.controls['firstName'];
  }

  get middleName(){
    return this.signupForm.controls['middleName'];
  }

  get lastName(){
    return this.signupForm.controls['lastName'];
  }

  get dob(){
    return this.signupForm.controls['dob'];
  }


  generateOtp(isRegistered : boolean){
    if(isRegistered){
      this.util.showLoader();
      this.loginService
          .generateOtp(this.userId.value)
          .subscribe(res => {
            this.enableOtp = true;
            this.enablePassword = false;
            this.util.hideLoader();
          },
          (err => {
            this.util.errorHandler(err);
            this.enableOtp = false;
            this.enablePassword = false;
            this.util.hideLoader();
          }));
    }else{
      this.loginService
          .generateOtpUnregistered(this.signUpMobNo.value)
          .subscribe(res => {
            this.presentPopover();
          },
          (err => {
            this.util.errorHandler(err);
          }));
    }
  }

  async presentPopover() {
    const popover = await this.popup.create({
      component: OtpPage,
      translucent: true,
      backdropDismiss: false,
      cssClass: 'bottom-sheet-popover',
      componentProps: {mobileNo : this.signUpMobNo.value}
    });

    popover.onDidDismiss().then(data => {
      if(data.data != null){
        let otp = data.data;
        this.signUp(otp);
      }
    });

    return await popover.present();
  }

  async signIn(){
    this.showProgressBar = true;
    let auth = new OtpAuthModel();
    auth.userId = this.userId.value;
    if(this.enableOtp){
      auth.password = this.otp.value;
    }else if(this.enablePassword){
      auth.password = this.signInPassword.value;
    }
  
           this.showProgressBar = false;
              this.router.navigateByUrl('welcome')
              this.util.hideLoader();
    // let  userModel:any
    // this.util.showLoader().then(() => {
    //   this.loginService.login(auth)
    //   .subscribe(
    //     res => {

    //       console.log(res)
    //        this.userModel  = res;

        

          // this.loginService.setUser(userModel).then(
          //   res => {

              
              // this.loginService
              //     .loadUserInfo()
              //     .then(
              //       async res => {
              //         await this.loginService.setUser(res).then(res=>res);
              //         this.showProgressBar = false;
              //         this.router.navigateByUrl('welcome')
              //         this.util.hideLoader();
              //       }
              //     )
          //   }
          // );
    //     },
    //     err => {
    //       this.otp.setValue('');
    //       this.reset();
    //       this.showProgressBar = false;
    //       this.util.hideLoader();
    //       this.util.errorHandler(err);
    //   });
    // });
  }

  signUp(otp){

    if(otp == null || otp == undefined){
      this.util.errorMsg('OTP Verification Failed. Please verify again.');
    }

    let userModel : UserModel = new UserModel();
    userModel.firstName = this.firstName.value;
    userModel.middleName = this.middleName.value;
    userModel.lastName = this.lastName.value;
    userModel.dob = this.dob.value;
    userModel.username = this.signUpMobNo.value;
    userModel.password = this.password.value;
    userModel.userType = 'CONT';

    userModel.gender = this.gender.value;
    userModel.aadharNo = this.aadharNo.value;
    userModel.aadharPhoto = this.aadharPhoto.value;
    userModel.city = this.city.value;
    userModel.country = this.country.value;
    userModel.state = this.state.value;
    userModel.otp = otp;

    this.loginService.setUser(userModel);
    this.loginService.signUp(userModel).subscribe(
      res => {
        this.opt = 'signin';
        this.util.success('You have been successfully registered into the Sur Shree App. Please login to use to the features of the app.');
        this.signupForm.reset();
        this.loginService.reset();
      },
      err => {
        this.util.errorHandler(err);
        this.loginService.reset();
      }
    );
  }

  async changeLanguage(event) {
    const popover = await this.popup.create({
      component: LanguagePage,
      event: event,
      translucent: true,
      backdropDismiss: false,
      cssClass: 'bottom-sheet-popover'
    });

    return await popover.present();
  }

  
}
