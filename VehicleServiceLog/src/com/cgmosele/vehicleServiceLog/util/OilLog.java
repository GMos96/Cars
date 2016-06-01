package com.cgmosele.vehicleServiceLog.util;

import java.util.Date;

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
	private Date lastChange;
	
	public OilLog( int capacity, String brand, String type, Date lastChange ) {
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

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
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
		return "Oil Brand: " + brand + "\nOil Type: " + type + "\n Capacity: " + capacity +
				"Date of Last Oil Change" + lastChange.toString();
	}
	
	
	
}
