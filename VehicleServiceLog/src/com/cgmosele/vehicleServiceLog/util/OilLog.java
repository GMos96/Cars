package com.cgmosele.vehicleServiceLog.util;

public class OilLog implements java.io.Serializable {

	/** Default ID */
	private static final long serialVersionUID = 1L;
	/** IN QUARTS */
	private int capacity;
	/** EX FORD MOTORCRAFT */
	private String brand;
	/** XW-YY */
	private String type;
	/** date of last oil change */
	private String lastChange;
	
	public OilLog( int capacity, String brand, String type, String lastChange ) {
		this.capacity = capacity;
		this.brand = brand;
		this.type = type;
		this.lastChange = lastChange;
	}
	
	public OilLog( int capacity, String brand, String type ) {
		this.capacity = capacity;
		this.brand = brand;
		this.type = type;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getBrand() {
		return brand;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Oil Brand: " + brand + "\nOil Type: " + type + "\nCapacity: " + capacity +
				"\nDate of Last Oil Change:" + lastChange;
	}
	
	
	
}
