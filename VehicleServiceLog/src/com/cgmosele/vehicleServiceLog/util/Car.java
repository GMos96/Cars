package com.cgmosele.vehicleServiceLog.util;

public class Car implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int year;
	private String make;
	private String model;
	private int mileage;
	private char oilType;
	private String specCode;
	private OilLog oilLog;
	
	private String[] carArray = new String[ 4 ];
	
	public Car( int year, String make, String model, int mileage, char oilType ) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.oilType = oilType;
		
		carArray[ 0 ] = new Integer( year ).toString() + " " + make + " " + model;
		carArray[ 1 ] = new Integer( mileage ).toString();
		carArray[ 2 ] = oilType == 'S' ? new Integer( mileage + 3000 ).toString() : new Integer( mileage + 5000 ).toString();
		carArray[ 3 ] = "";
		
	}
	
	public Car( int year, String make, String model, int mileage, char oilType, String specCode ) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.oilType = oilType;
		this.specCode = specCode;
		
		carArray[ 0 ] = new Integer( year ).toString() + " " + make + " " + model;
		carArray[ 1 ] = new Integer( mileage ).toString();
		carArray[ 2 ] = oilType == 'S' ? new Integer( mileage + 3000 ).toString() : new Integer( mileage + 5000 ).toString();
		carArray[ 3 ] = specCode;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getSpecCode() {
		return specCode;
	}

	public void setSpecCode(String specCode) {
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
	
	public String[] toStringArray() {
		return carArray;
	}
	
		
}
