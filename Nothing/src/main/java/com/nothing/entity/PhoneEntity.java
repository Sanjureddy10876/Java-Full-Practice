package com.nothing.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone_nothing")
public class PhoneEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String phoneName;
	private String phoneDescription;
	private String phoneModel;
	private int price;
	private int qty;



	@OneToOne(mappedBy = "phoneEntity",cascade = CascadeType.ALL)
	private PriceEntity priceEntity;


	public PhoneEntity() {
		
	}
	
	

	public PhoneEntity(Long id, String phoneName, String phoneDescription, String phoneModel, int price, int qty,
			PriceEntity priceEntity) {
		super();
		this.id = id;
		this.phoneName = phoneName;
		this.phoneDescription = phoneDescription;
		this.phoneModel = phoneModel;
		this.price = price;
		this.qty = qty;
		this.priceEntity = priceEntity;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPhoneName() {
		return phoneName;
	}



	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}



	public String getPhoneDescription() {
		return phoneDescription;
	}



	public void setPhoneDescription(String phoneDescription) {
		this.phoneDescription = phoneDescription;
	}



	public String getPhoneModel() {
		return phoneModel;
	}



	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public PriceEntity getPriceEntity() {
		return priceEntity;
	}



	public void setPriceEntity(PriceEntity priceEntity) {
		this.priceEntity = priceEntity;
	}



}
