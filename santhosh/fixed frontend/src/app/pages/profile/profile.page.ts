import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { UtilService } from 'src/app/services/util/util.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserModel } from 'src/app/models/UserModel';
import { MstStateModel } from 'src/app/models/MstStateModel';
import { MasterDataService } from 'src/app/services/master/master-data.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.page.html',
  styleUrls: ['./profile.page.scss'],
})
export class ProfilePage implements OnInit {

  public userDetailsForm : FormGroup;
  public pregDetailsForm : FormGroup;
  public userPersonalForm : FormGroup;
  public doctorForm : FormGroup;
  public displayPregDtls : boolean = false;
  public displayUsrPersonalDtls : boolean = false;
  public displayDoctorDtls : boolean = false;
  public userType;
  public states : MstStateModel[] = [];

  constructor(public fb : FormBuilder, public loginService : LoginService, public router : Router, public util : UtilService, public mstSrvc : MasterDataService) { }

  ngOnInit() {
    this.initilizeUserDetailsForm();
    this.mstSrvc.getState().subscribe(data => this.states = data);
  }

  

  initilizeUserDetailsForm(){
    let user : UserModel = this.loginService.getUser();
    console.log('User Dtls', user)
    this.userDetailsForm = this.fb.group({
      'fname' : [user.firstName, Validators.required],
      'mname' : [user.middleName],
      'lname' : [user.lastName, Validators.required],
      'gender' : [user.gender, Validators.required],
      'dob' : [user.dob, Validators.required],
      'status' : [user.isActive],
      'profilePhoto' : [user.profilePicture],
      'profileVideo' : [user.profileVideo],
      'profileDescription' : [user.profileDescription],
      'country' : [user.country,Validators.required],
      'state' : [user.state,Validators.required],
      'city' : [user.city,Validators.required]
    });
  }

  get city(){
    return this.userDetailsForm.get('city');
  }

  get state(){
    return this.userDetailsForm.get('state');
  }

  get country(){
    return this.userDetailsForm.get('country');
  }

  get profilePhoto(){
    return this.userDetailsForm.get('profilePhoto');
  }

  get fname(){
    return this.userDetailsForm.get('fname');
  }

  get mname(){
    return this.userDetailsForm.get('mname');
  }

  get lname(){
    return this.userDetailsForm.get('lname');
  }

  get gender(){
    return this.userDetailsForm.get('gender');
  }

  get dob(){
    return this.userDetailsForm.get('dob');
  }

  get status(){
    return this.userDetailsForm.get('status');
  }

  get profileVideo(){
    return this.userDetailsForm.get('profileVideo');
  }

  get profileDescription(){
    return this.userDetailsForm.get('profileDescription');
  }



  updateUser(){
    let user : UserModel = this.loginService.getUser()
    user.firstName = this.fname.value;
    user.middleName = this.mname.value;
    user.lastName = this.lname.value;
    user.gender = this.gender.value;
    user.city = this.city.value;
    user.state = this.state.value;
    user.country = this.country.value;
    user.profilePicture = this.profilePhoto.value;
    user.profileVideo = this.profileVideo.value;
    user.profileDescription = this.profileDescription.value;
    user.userType = this.loginService.getUser().userType;

    this.loginService.updateProfile(user).subscribe(
      (res) => {
        this.util.success('Your Profile Updated Successfully.');
        this.loginService.setUser(user);
      },
      this.util.errorHandler
    );
  }
}
