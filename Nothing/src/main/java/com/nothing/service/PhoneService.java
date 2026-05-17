package com.nothing.service;

import com.nothing.dto.PhoneRequest;
import com.nothing.dto.PhoneResponse;

public interface PhoneService {

	public PhoneResponse createPhone(PhoneRequest phoneRequest);
}
