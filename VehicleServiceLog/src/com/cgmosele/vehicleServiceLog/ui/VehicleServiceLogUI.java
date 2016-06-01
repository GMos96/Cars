package com.cgmosele.vehicleServiceLog.ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

import com.cgmosele.vehicleServiceLog.util.Car;

public class VehicleServiceLogUI {

	Car[] cars = new Car[ 25 ];
	
	public VehicleServiceLogUI() {
		
	}
	
	public void save() {

		// do later
		// www.tutorialspoint.com/java/java_serialization.htm
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void changeOil( Car c, int mileage ) {
		switch( c.getOilType() ) {
			case ( 'S' ):
				c.setMileage( mileage + 3000 );
				break;
			case ( 'Y' ):
				c.setMileage( mileage + 5000 );
				break;
			default:
				break;
		}
		
		c.getOilLog().setLastChange( new Date( Calendar.YEAR + 1900, Calendar.MONTH + 1, Calendar.DATE ) );
	}
	
	
}
