package com.comapany.lava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "location_details")
public class LocationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String user;
	@Transient
	private String deviceID;
	private String latitude;
	private String longitude;
	
	public Long getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

	

}
