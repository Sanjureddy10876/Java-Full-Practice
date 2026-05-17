import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PopoverController, NavParams } from '@ionic/angular';
import { LoginService } from 'src/app/services/login/login.service';
import { UtilService } from 'src/app/services/util/util.service';
import { OtpAuthModel } from 'src/app/models/OtpAuthModel';
import { UserModel } from 'src/app/models/UserModel';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.page.html',
  styleUrls: ['./otp.page.scss'],
})
export class OtpPage implements OnInit {
  public otpForm : FormGroup;

  constructor(public fb : FormBuilder, public popup: PopoverController, public loginService : LoginService, public util: UtilService, public navParams:NavParams) { }

  ngOnInit() {
    this.otpForm = this.fb.group({
      'otp' : ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }
   
  get otp(){
    return this.otpForm.controls['otp'];
  }

  validateOtp(){
    this.popup.dismiss(this.otp.value);
  }

  close(){
    this.popup.dismiss(null);
  }

}
