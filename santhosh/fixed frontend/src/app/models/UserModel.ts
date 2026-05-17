export class UserModel{
    username : string;

    password : string;

    userType : string;

    firstName : string;

    middleName : string;

    lastName : string;

    gender : string;

    dob : Date;

    access_token : string;

    refresh_token : string;

    isUserRegistered : boolean = false;

    roles : string[];

    functions : string[];

    isApproved : string;

    isActive : string;

    userProfileComplete : boolean;

    city : string;

    country : string;

    state : string;

    aadharNo : string;

    aadharPhoto : string;

    otp : string;

    profilePicture : string;

    profileVideo : string;

    profileDescription : string;
  jwt?: string;

}