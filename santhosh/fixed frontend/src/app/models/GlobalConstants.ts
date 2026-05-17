import { environment } from 'src/environments/environment';

export class GlobalConstants{
    static blankString : string = '';
    static protocol : string = environment.protocol;
    static context : string = environment.context;
    static host : string = environment.host;
    static port : string = environment.port;
    static forwardSlash : string = '/';
    static doubleForwardSlash : string = GlobalConstants.forwardSlash + GlobalConstants.forwardSlash;
    static colon : string = ":";
    static baseUrl : string = GlobalConstants.protocol + 
                                GlobalConstants.colon + 
                                GlobalConstants.doubleForwardSlash +
                                GlobalConstants.host + 
                                GlobalConstants.colon + 
                                GlobalConstants.port + 
                                (GlobalConstants.context == '' ? GlobalConstants.forwardSlash : GlobalConstants.forwardSlash + GlobalConstants.context + GlobalConstants.forwardSlash);
    static oauthClientUser : string = 'mobile';
    static oauthClientSecret : string = 'pin';
    static razorPkey = 'rzp_test_Y6IESq2FkbMn5H';
}