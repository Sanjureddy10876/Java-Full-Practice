package com.snapdeal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_info")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	
	@Column
	private String productName;
	
	@Column
	private String productDescription;
	
	@Column
	private String status;
	
	@Column
	@CreationTimestamp
	private LocalDateTime createdDateandTime;
	
	@Column
	@CreationTimestamp
	private LocalDateTime timestap;

	@OneToOne(mappedBy = "productEntity",cascade = CascadeType.ALL)
	private InventryEntity inventryEntity;
	
	@OneToOne(mappedBy = "productEntity", cascade = CascadeType.ALL)
	private PriceEntity priceEntity;
	
	public ProductEntity() {
		
	}

	public ProductEntity(int productID, String productName, String productDescription, String status,
			LocalDateTime createdDateandTime, LocalDateTime timestap, InventryEntity inventryEntity,
			PriceEntity priceEntity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.status = status;
		this.createdDateandTime = createdDateandTime;
		this.timestap = timestap;
		this.inventryEntity = inventryEntity;
		this.priceEntity = priceEntity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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

	public InventryEntity getInventryEntity() {
		return inventryEntity;
	}

	public void setInventryEntity(InventryEntity inventryEntity) {
		this.inventryEntity = inventryEntity;
	}

	public PriceEntity getPriceEntity() {
		return priceEntity;
	}

	public void setPriceEntity(PriceEntity priceEntity) {
		this.priceEntity = priceEntity;
	}
	
	
}
