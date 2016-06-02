package com.cgmosele.vehicleServiceLog.error;

import javax.swing.JDialog;
import javax.swing.JTextField;

public class CarNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CarNotFoundException() {
		JDialog error = new JDialog();
		error.setTitle( "Car Not Found" );
		error.setVisible( true );
		error.add( new JTextField( "The car was not found in our records. Please try again" ) );
	}

}
