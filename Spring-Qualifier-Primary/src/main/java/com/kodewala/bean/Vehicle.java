package com.kodewala.bean;

public class Vehicle {
	
	private int id;
	private String vehicleName;
	private String VehicleEngine;
	
	
	public Vehicle(int id, String vehicleName, String vehicleEngine) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
		VehicleEngine = vehicleEngine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleEngine() {
		return VehicleEngine;
	}
	public void setVehicleEngine(String vehicleEngine) {
		VehicleEngine = vehicleEngine;
	}
	

}
