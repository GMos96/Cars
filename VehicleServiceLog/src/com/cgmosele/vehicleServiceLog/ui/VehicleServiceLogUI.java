package com.cgmosele.vehicleServiceLog.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.cgmosele.vehicleServiceLog.error.CarNotFoundException;
import com.cgmosele.vehicleServiceLog.util.Car;

public class VehicleServiceLogUI {

	Car[] cars = new Car[ 10 ];
	String[][] carTable = new String[ 10 ][ 4 ];
	
	public VehicleServiceLogUI() throws FileNotFoundException {
		read();
	}
	
	public void save() {
	      try {
	    	 File f = new File( "C:\\Vehicle Service Log\\cars.ser" );
	         FileOutputStream fileOut =
	         new FileOutputStream( f );
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject( cars );
	         out.close();
	         fileOut.close();
	      } catch(IOException i) {
	          i.printStackTrace();
	      }
	}
	
	private void read() {
	      try {
	         FileInputStream fileIn = new FileInputStream( "C:\\Vehicle Service Log\\cars.ser" );
	         ObjectInputStream in = new ObjectInputStream( fileIn );
	         cars = ( Car[] ) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch(IOException i) {
	         i.printStackTrace();
	         return;
	      } catch(ClassNotFoundException c) {
	         System.out.println("Vehicle Array Not Found. Starting Blank.");
	         return;
	      }
	      
	      if ( cars[ 0 ] == null ) {
	    	  return;
	      }
	      for ( int i = 0; i < cars.length; i++ ) {
	    	  if ( cars[ i ] == null ) {
	    		  return;
	    	  }
	    	  carTable[ i ][ 0 ] = cars[ i ].getCarName();
	    	  carTable[ i ][ 1 ] = new Integer( cars[ i ].getMileage() ).toString();
	    	  carTable[ i ][ 2 ] = cars[ i ].getNextMileage().toString();
	    	  carTable[ i ][ 3 ] = cars[ i ].getSpecCode();
	      }
	      
	}
	
	
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
		
		c.getOilLog().setLastChange( new SimpleDateFormat( "MM/dd/yyyy").format( Calendar.getInstance().getTime() ) );
	}
	
	public Car find( String make, String model ) throws CarNotFoundException {
		for ( int i = 0; i < cars.length; i++ ) {
			if ( make.equals( cars[ i ].getMake() ) )
				if ( model.equals( cars[ i ].getModel() ) )
					return cars[ i ];
		}
		
		throw new CarNotFoundException();
	}
	
	public Car[] getCars() {
		return cars;
	}
	
	public String[][] getTable() {
		return carTable;
	}
	
	
}
