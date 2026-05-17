package com.comapany.lava.service;

import com.comapany.lava.exceptions.UserNotFoundException;
import com.comapany.lava.request.LocationRequest;

public interface LocationService {
	
	boolean locationService(LocationRequest locationRequest) throws UserNotFoundException;

}
