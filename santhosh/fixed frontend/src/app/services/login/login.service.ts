import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GlobalConstants } from 'src/app/models/GlobalConstants';
import { OtpAuthModel } from 'src/app/models/OtpAuthModel';
import { UtilService } from '../util/util.service';
import { UserModel } from 'src/app/models/UserModel';
import { UserDetailsModel } from 'src/app/models/UserDetailsModel';
import { Observable } from 'rxjs';
import { Storage } from '@ionic/storage';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  options = {};

  private user : UserModel;

  getUser() : UserModel{
    return this.user;
  }

  async setUser(res : UserModel){
    let user = new UserModel();
    user.firstName = res.firstName;
    user.lastName = res.lastName;
    user.username = res['user_name'];
    user.middleName = res.middleName;
    user.isActive = res.isActive
    user.roles = res.roles;
    user.functions = res.functions;
    user.dob = res.dob;
    user.city = res.city;
    user.country = res.country;
    user.state = res.state;
    user.profileDescription = res.profileDescription;
    user.profilePicture = res.profilePicture;
    user.profileVideo = res.profileVideo;
    user.gender = res.gender;
    if(res.access_token && res.refresh_token){
      user.access_token = res.access_token;
      user.refresh_token = res.refresh_token;
      await this.storage.set('access_token', res.access_token);
      await this.storage.set('refresh_token', res.refresh_token);
    }else{
      user.access_token = this.user.access_token;
      user.refresh_token = this.user.refresh_token;
      await this.storage.set('access_token', this.user.access_token);
      await this.storage.set('refresh_token', this.user.refresh_token);
    }
    this.user = user;
  }

  getFullName(){
    return this.getUser().firstName + (this.getUser().middleName != null ? ' ' + this.getUser().middleName : '') + ' ' + this.getUser().lastName;
  }

  getIsUserProfileComplete(){
      return this.getUser().userProfileComplete;
  }

  constructor(public util : UtilService, private storage: Storage) { 
    
  }

  getUserPersonalDetails() : Observable<UserDetailsModel>{
    return this.util.get<UserDetailsModel>('user/details/' + this.user.username);
  }

  generateOtp(mobileNo : string){
    return this.util.get('auth/otp/' + mobileNo);
  }

  login(auth : OtpAuthModel){
    let headers = new HttpHeaders({
      //"Accept" : "application/x-www-form-urlencoded"
    });
    this.options = { headers: headers };

    let authData : FormData = new FormData();
    authData.set('grant_type', 'password');
    authData.set('username', auth.userId);
    authData.set('password', auth.password);

    return this.util.postFormData<UserModel>('oauth/token', authData,this.options);
  }

  async refreshToken(refreshToken){
    let headers = new HttpHeaders({
      "Accept" : "application/x-www-form-urlencoded"
    });
    this.options = { headers: headers };

    let authData : FormData = new FormData();
    authData.set('grant_type', 'refresh_token');
    authData.set('client_id', GlobalConstants.oauthClientUser);
    authData.set('refresh_token', refreshToken);

    return this.util.postFormData<UserModel>(`oauth/token`, authData, this.options).toPromise();
  }

  async loadUserInfo(){
      let headers = new HttpHeaders({
        "Accept" : "application/x-www-form-urlencoded"
      });
      this.options = { headers: headers };
      let authToken = await this.getStoredAccessTopen();
      return this.util.get<UserModel>(`oauth/check_token?token=${authToken}`).toPromise();
  }

  async getStoredAccessTopen(){
    let accessToken = await this.storage.get('access_token').then(res => res);
    return accessToken;
  }

  generateOtpUnregistered(mobileNo : string){
    return this.util.get('auth/otp/newuser/' + mobileNo);
  }

  signUp(userModel : UserModel){
    return this.util.post('user', userModel);
  }

  updatePersonalDetails(usrDtls : UserDetailsModel){
    return this.util.post('user/details', usrDtls);
  }

  reset(){
    this.user = null;
    this.storage.remove('access_token');
    this.storage.remove('refresh_token');
  }

  logout(){
    this.reset();
  }

  updateProfile(user : UserModel){
    return this.util.post('user/profile', user);
  }

  hasRole(roleName : string) : boolean{
    return this.user && this.user.roles && this.user.roles.includes(roleName);
  }

  hasFunction(functionName : string) : boolean{
    return this.user && this.user.functions && this.user.functions.includes(functionName);
  }
}
