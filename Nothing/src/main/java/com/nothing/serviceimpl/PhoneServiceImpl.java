package com.nothing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nothing.dto.PhoneRequest;
import com.nothing.dto.PhoneResponse;
import com.nothing.entity.PhoneEntity;
import com.nothing.entity.PriceEntity;
import com.nothing.repository.PhoneRepository;
import com.nothing.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public PhoneResponse createPhone(PhoneRequest phoneRequest) {

		String name = phoneRequest.getPhoneName();
		String description = phoneRequest.getPhoneDescription();
		int price = phoneRequest.getPrice();
		int qty = phoneRequest.getQty();
		String type = phoneRequest.getCurrencyType();
		
		
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setCurrencyType(type);
		priceEntity.setDescription(description);
		
		
		PhoneEntity phoneEntity = new PhoneEntity();
		phoneEntity.setPrice(price);
		phoneEntity.setQty(qty);
		phoneEntity.setPhoneName(name);
		
		priceEntity.setPhoneEntity(phoneEntity);
		phoneEntity.setPriceEntity(priceEntity);
		
		PhoneEntity phoneEntity2 = phoneRepository.save(phoneEntity);
		Long productID =phoneEntity2.getId();
		PhoneResponse response = new PhoneResponse();
		
		if (productID!= null) {
			
			response.setId(productID);
			response.setConfirmmsg("Your Product was uploaded please wait for review from team");
		} else {
			response.setId(productID);
			response.setConfirmmsg("Unable to upload the product");
		}

		return response;
	}
}
