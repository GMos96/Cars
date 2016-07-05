package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cgmosele.vehicleServiceLog.util.Car;
import com.cgmosele.vehicleServiceLog.util.OilLog;

public class AddCarDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel main = new JPanel();
	private JPanel buttons = new JPanel();
	
	private JButton ok = new JButton( "Okay" );
	private JButton cancel = new JButton( "Cancel" );
	
	private JTextField year = new JTextField( "Year" );
	private JPanel yearPanel = new JPanel();
	private JTextField make = new JTextField( "Make" );
	private JPanel makePanel = new JPanel();
	private JTextField model = new JTextField( "Model" );
	private JPanel modelPanel = new JPanel();
	private JTextField mileage = new JTextField( "Current Mileage" );
	private JPanel mileagePanel = new JPanel();
	private JTextField brand = new JTextField( "Brand of Oil" );
	private JPanel brandPanel = new JPanel();
	private JTextField type = new JTextField( "Type of Oil (Ex. 5W-30)" );
	private JPanel typePanel = new JPanel();
	private JTextField cap = new JTextField( "Oil Capacity (Quarts)" );
	private JPanel capacityPanel = new JPanel();
	
	//private JRadioButton tires = new JRadioButton( "Tire Rotation" );
	
	private JRadioButton standard = new JRadioButton( "Standard" );
	private JRadioButton synthetic = new JRadioButton( "Synthetic" );
	
	private Car car;
	
	public AddCarDialog( JFrame parent, boolean modal ) {
		super( parent, modal );
		
		main.setLayout( new BoxLayout( main, BoxLayout.PAGE_AXIS) );
		
		addToContainer();
		
		setSize( 400, 600 );
		setLocationRelativeTo( parent );
		setVisible( true );
		
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
	}

	private void addToContainer() {
		
		main.add( year);
		main.add( make );
		main.add( model );
		main.add( mileage );
		main.add( brand );
		main.add( type );
		main.add( cap );
		//main.add( tires );
		main.add( standard );
		main.add( synthetic );
		
		this.add( main );
		this.add( buttons, BorderLayout.SOUTH);
		
		buttons.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		buttons.add( ok );
		ok.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//assuming correct for now
				int year = Integer.parseInt( AddCarDialog.this.year.getText() );
				String make = AddCarDialog.this.make.getText();
				String model = AddCarDialog.this.model.getText();
				int mileage = Integer.parseInt( AddCarDialog.this.mileage.getText() );
				
				char oilType;
				if ( standard.isSelected() ) {
					oilType = 'S';
				} else {
					oilType = 'Y';
				}
				
				String specialCodes = "-";
				//if ( tires.isSelected() ) {
					//specialCodes = "R";
				//}
				
				int capacity = Integer.parseInt( cap.getText() );
				String brand = AddCarDialog.this.brand.getText();
				String type = AddCarDialog.this.type.getText();
				
				OilLog log = new OilLog(capacity, brand, type);
				
				car = new Car( year, make, model, mileage, oilType, specialCodes );
				car.setOilLog( log );
				
				setVisible( false );
			}
		} );
		
		buttons.add( cancel );
		cancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		make.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				make.setText( "" );
			}
		});
	}
	
	public Car onReturn() {
		return car;
	}

}
