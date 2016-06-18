package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChangeOilDialog extends JDialog {

	private JPanel main = new JPanel();
	private JPanel buttons = new JPanel();
	
	private JButton ok = new JButton( "Okay" );
	private JButton cancel = new JButton( "Cancel" );
	
	private JTextField mileageField = new JTextField( "Mileage" );
	
	private JRadioButton tires = new JRadioButton( "Tire Rotation?" );
	private Integer mileage = null;
	private String specialCode = "-";
	
	ArrayList<Object> info = new ArrayList<>();
	
	public ChangeOilDialog( JFrame frame, boolean modal ) {
		super( frame, modal );
		
		setSize( new Dimension( 300, 150 ) );
		setLocationRelativeTo( frame );
		
		main.setLayout( new BoxLayout( main, BoxLayout.PAGE_AXIS) );
		main.add( mileageField );
		
		main.add( tires );
				
		buttons.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		buttons.add( ok );
		ok.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mileage = Integer.parseInt( mileageField.getText() );
				if ( tires.isSelected() ) {
					specialCode = "R";
				}
				setVisible( false );
				info.add( mileage );
				info.add( specialCode );
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
	
	public ArrayList<Object> getMileage() {
		return info;
	}

}
