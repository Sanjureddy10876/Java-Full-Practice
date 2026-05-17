package com.lenovo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "price_info")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceID;

	@Column
	private int price;
	@Column
	private String currencyCode;

	@Column
	private String status;

	@Column
	@CreationTimestamp
	private LocalDateTime createdDateandTime;
	@Column
	@CreationTimestamp
	private LocalDateTime timestap;

	@OneToOne
	@JoinColumn(name = "productID")
	private ProductEntity productEntity;

	public PriceEntity() {

	}

	public PriceEntity(int priceID, ProductEntity productEntity, int price, String currencyCode, String status,
			LocalDateTime createdDateandTime, LocalDateTime timestap) {
		super();
		this.priceID = priceID;
		this.productEntity = productEntity;
		this.price = price;
		this.currencyCode = currencyCode;
		this.status = status;
		this.createdDateandTime = createdDateandTime;
		this.timestap = timestap;
	}

	public int getPriceID() {
		return priceID;
	}

	public void setPriceID(int priceID) {
		this.priceID = priceID;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDateandTime() {
		return createdDateandTime;
	}

	public void setCreatedDateandTime(LocalDateTime createdDateandTime) {
		this.createdDateandTime = createdDateandTime;
	}

	public LocalDateTime getTimestap() {
		return timestap;
	}

	public void setTimestap(LocalDateTime timestap) {
		this.timestap = timestap;
	}

}
