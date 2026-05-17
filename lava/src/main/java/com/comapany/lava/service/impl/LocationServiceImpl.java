package com.comapany.lava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comapany.lava.entity.LocationEntity;
import com.comapany.lava.exceptions.UserNotFoundException;
import com.comapany.lava.repository.LocationRepository;
import com.comapany.lava.request.LocationRequest;
import com.comapany.lava.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public boolean locationService(LocationRequest locationRequest) throws UserNotFoundException {
		boolean status = false;
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setDeviceID(locationRequest.getDeviceID());
		locationEntity.setUser(locationRequest.getUser());
		locationEntity.setLatitude(locationRequest.getLatitude());
		locationEntity.setLongitude(locationRequest.getLongitude());

		LocationEntity response = locationRepository.save(locationEntity);
		if (response.getId() > 0) {
			status = true;
			throw new UserNotFoundException("User not found");
		}
		return status;
	}

}
