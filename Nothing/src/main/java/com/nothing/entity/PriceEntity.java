package com.nothing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_price_details")
public class PriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int price_id;
	private String description;
	private String currencyType;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private PhoneEntity phoneEntity;
	
	public PriceEntity() {
		
	}

	public PriceEntity(int price_id, String description, String currencyType, PhoneEntity phoneEntity) {
		super();
		this.price_id = price_id;
		this.description = description;
		this.currencyType = currencyType;
		this.phoneEntity = phoneEntity;
	}

	public int getPrice_id() {
		return price_id;
	}

	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public PhoneEntity getPhoneEntity() {
		return phoneEntity;
	}

	public void setPhoneEntity(PhoneEntity phoneEntity) {
		this.phoneEntity = phoneEntity;
	}
	

	

	
}
