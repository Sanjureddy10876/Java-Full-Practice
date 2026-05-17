package com.comapany.lava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comapany.lava.exceptions.UserNotFoundException;
import com.comapany.lava.request.LocationRequest;
import com.comapany.lava.response.LocationResponse;
import com.comapany.lava.service.LocationService;

@RestController
@RequestMapping("/api/user/")
public class LocationController {

	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("update")
	public ResponseEntity<LocationResponse> updateLocation(@RequestBody LocationRequest locationRequest) throws UserNotFoundException {
	boolean status	=locationService.locationService(locationRequest);
		LocationResponse locationResponse = new LocationResponse();
		locationResponse.setStatus(""+status);
		locationResponse.setMessage("Location updated");
		return ResponseEntity.ok(locationResponse);
	}
	
}
