package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCarDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel main = new JPanel();
	private JPanel buttons = new JPanel();
	
	private JButton ok = new JButton( "Okay" );
	private JButton cancel = new JButton( "Cancel" );
	
	private JTextField year = new JTextField( "Year" );
	private JTextField make = new JTextField( "Make" );
	private JTextField model = new JTextField( "Model" );
	private JTextField mileage = new JTextField( "Current Mileage" );
	
	private JTextField brand = new JTextField( "Brand of Oil" );
	private JTextField type = new JTextField( "Type of Oil (Ex. 5W-30)" );
	private JTextField cap = new JTextField( "Oil Capacity (Quarts)" );
	
	private JRadioButton tires = new JRadioButton( "Tire Rotation" );
	
	private JRadioButton standard = new JRadioButton( "Standard" );
	private JRadioButton synthetic = new JRadioButton( "Synthetic" );
	

	public AddCarDialog( JFrame parent, boolean modal ) {
		super( parent, modal );
		
		main.setLayout( new BoxLayout( main, BoxLayout.PAGE_AXIS) );
		
		addToContainer();
		
		setSize( 400, 800 );
		setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		addToContainer();
	}

	private void addToContainer() {
		
		main.add( year);
		main.add( make );
		main.add( model );
		main.add( mileage );
		main.add( brand );
		main.add( type );
		main.add( cap );
		main.add( tires );
		main.add( standard );
		main.add( synthetic );
		
		this.add( main );
		this.add( buttons, BorderLayout.SOUTH);
		
		buttons.add( ok );
		buttons.add( cancel );
		
	}

}
