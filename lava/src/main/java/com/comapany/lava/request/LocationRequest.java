package com.comapany.lava.request;

public class LocationRequest {

	private String user;
	private String deviceID;
	private String latitude;
	private String longitude;
	
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
