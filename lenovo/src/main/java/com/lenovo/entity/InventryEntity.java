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
@Table(name = "inventry_info")
public class InventryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventryID;
	
	@Column
	private int avaliable_qty;
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
	
	public InventryEntity() {
		
	}

	public InventryEntity(int inventryID, ProductEntity productEntity, int avaliable_qty, String status,
			LocalDateTime createdDateandTime, LocalDateTime timestap) {
		super();
		this.inventryID = inventryID;
		this.productEntity = productEntity;
		this.avaliable_qty = avaliable_qty;
		this.status = status;
		this.createdDateandTime = createdDateandTime;
		this.timestap = timestap;
	}

	public int getInventryID() {
		return inventryID;
	}

	public void setInventryID(int inventryID) {
		this.inventryID = inventryID;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public int getAvaliable_qty() {
		return avaliable_qty;
	}

	public void setAvaliable_qty(int avaliable_qty) {
		this.avaliable_qty = avaliable_qty;
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
