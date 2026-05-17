import { Component, OnInit } from '@angular/core';
import { UtilService } from 'src/app/services/util/util.service';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit {

  constructor(public util : UtilService, public ls : LoginService, public r : Router) { }

  ngOnInit() {}

  openHomePage(){
    if(this.ls.getUser()){
      this.r.navigateByUrl('/welcome');
    }else{
      this.r.navigateByUrl('/login');
    }
  }

  openDonationPage(){
    this.r.navigateByUrl('/donation');
  }

  openProfilePage(){
    this.r.navigateByUrl('/profile');
  }

  openSignupPage(){
    this.r.navigateByUrl('/signup');
  }

}
