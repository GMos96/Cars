package com.cgmosele.vehicleServiceLog.util;

public class Car implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int year;
	private String make;
	private String model;
	private int mileage;
	private char oilType;
	private char specCode;
	private OilLog oilLog;
	
	public Car( int year, String make, String model, int mileage, char oilType ) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.oilType = oilType;
	}
	
	public Car( int year, String make, String model, int mileage, char oilType, char specCode ) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.oilType = oilType;
		this.specCode = specCode;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public char getSpecCode() {
		return specCode;
	}

	public void setSpecCode(char specCode) {
		this.specCode = specCode;
	}

	public OilLog getOilLog() {
		return oilLog;
	}

	public void setOilLog(OilLog oilLog) {
		this.oilLog = oilLog;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public char getOilType() {
		return oilType;
	}
	
		
}
