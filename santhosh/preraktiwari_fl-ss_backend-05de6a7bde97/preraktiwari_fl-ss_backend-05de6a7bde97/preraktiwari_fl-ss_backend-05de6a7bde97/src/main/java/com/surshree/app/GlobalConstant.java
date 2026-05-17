package com.surshree.app;

public interface GlobalConstant {

    public static String DB_YES = "1";
    public static String DB_NO = "0";
    public static String BLANK = "";
    public static String ONE_SPACE = " ";
    public static String rpKey = "rzp_test_Y6IESq2FkbMn5H";
    public static String rpSecret = "JyUZo2QJVJ2Od5zse5yz3caZ";
    public static String SMA_AUTH_KEY = "226886ATglHRDk5ecbe4d0P1";
    public static String SMS_API_URL_OTP = "http://sms.abinfotech.net/api/otp.php?";
    public static String SMS_API_URL_VERIFY_OTP = "http://sms.abinfotech.net/api/verifyRequestOTP.php?";
    public static Integer OTP_EXPIRY = 5; //Expiry of OTP to verify, in minutes
    public static Integer OTP_LENGTH = 6; //Number of digits in OTP
    public static String SMS_SENDER_NAME = "SURSRI";
}
