package com.kodewala.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
	
	@RequestMapping("showPage")
	public ModelAndView showSignUpPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("sign-up");
		return mv;
	}
	
		@RequestMapping("signup")
		@ResponseBody
		public String signup(@RequestParam("mobile") String mobile,@RequestParam("email") String email,@RequestParam("location") String location,@RequestParam("otp") String otp) {
			
			System.out.println("request recevied and data recevied as a part of request : mobile :"+mobile+"email :"+email+"location :"+location+"otp :"+otp);
			String data = mobile + email;
			String uniqueKey = java.util.UUID.nameUUIDFromBytes(data.getBytes()).toString();
			return "Registration successful and it is Id pending for verification and ref id is "+uniqueKey;
		}

}
