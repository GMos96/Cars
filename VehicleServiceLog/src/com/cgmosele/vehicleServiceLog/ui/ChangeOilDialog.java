package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cgmosele.vehicleServiceLog.util.Car;

public class ChangeOilDialog extends JDialog {

	private JPanel main = new JPanel();
	private JPanel buttons = new JPanel();
	
	private JButton ok = new JButton( "Okay" );
	private JButton cancel = new JButton( "Cancel" );
	
	private JTextField mileageField = new JTextField( "Mileage" );
	private int mileage;
	
	public ChangeOilDialog( JFrame frame, boolean modal ) {
		super( frame, modal );
		
		setSize( new Dimension( 300, 150 ) );
		setLocationRelativeTo( frame );
		
		main.setLayout( new BoxLayout( main, BoxLayout.PAGE_AXIS) );
		main.add( mileageField );
				
		buttons.add( ok );
		ok.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mileage = Integer.parseInt( mileageField.getText() );
				setVisible( false );
			}
		});
		
		buttons.add( cancel );
		cancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.add( main );
		this.add( buttons, BorderLayout.SOUTH );
		
		setVisible( true );

	}
	
	public int getMileage() {
		return mileage;
	}

}
