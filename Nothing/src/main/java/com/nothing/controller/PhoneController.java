package com.nothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nothing.dto.PhoneRequest;
import com.nothing.dto.PhoneResponse;
import com.nothing.service.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;

	@PostMapping("addPhone")
	@ResponseBody
	public String createPhone(@ModelAttribute PhoneRequest phoneRequest, Model model ) {
	PhoneResponse response	= phoneService.createPhone(phoneRequest);
	model.addAttribute("response", response);
		return "phone-confirm";
	}
	
	
	

	
	
}
