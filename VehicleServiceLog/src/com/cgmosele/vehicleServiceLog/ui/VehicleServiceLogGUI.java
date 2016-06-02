package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import com.cgmosele.vehicleServiceLog.util.Car;

public class VehicleServiceLogGUI extends JFrame {

	static final long serialVersionUID = -1991087826556056121L;

	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton addCar = new JButton( "Add Car" );
	private JButton changeOil = new JButton( "Change Oil" );
	private JButton help = new JButton( "Help" );
	private JButton info = new JButton( "Oil Information");

	private JList<Car> carList = new JList<Car>();
	
	private VehicleServiceLogUI garage;
	private Car[] cars;
	
	public VehicleServiceLogGUI() {
		try {
			cars = garage.getCars();
		} catch ( NullPointerException e ) {
			cars = new Car[ 25 ];
		}
	}
	
	private void startFrame() {
		this.setVisible( true );
		this.setExtendedState( JFrame.MAXIMIZED_BOTH );
		this.setMinimumSize( new Dimension( 800, 500 ) );
		this.setTitle( "Vehicle Service Log" );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	private void addComponents() {
		this.setLayout( new BorderLayout() );
		this.add( mainPanel );
		this.add( buttonPanel, BorderLayout.SOUTH );
		
		// Add components to main panel
		mainPanel.add( carList );
		
		//Add components to button panel ( just buttons )
		buttonPanel.add( addCar );
		buttonPanel.add( changeOil );
		buttonPanel.add( help );
		buttonPanel.add( info );
		
		//activate the buttons with action listeners and assign actions
		activateButtons();
	
		carList.setListData( cars );
	}
	
	private void activateButtons() {
		addCar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				// TODO Auto-generated method stub
				
			}
		});
		
		changeOil.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				// TODO Auto-generated method stub
				
			}
		});
		
		help.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				String url = "C:\\VehicleServiceLog\\help.html";
				File htmlFile = new File(url);
				try {
					Desktop.getDesktop().browse( htmlFile.toURI() );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		info.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	public static void main( String[] args ) {
		VehicleServiceLogGUI gui = new VehicleServiceLogGUI();
		gui.startFrame();
		gui.addComponents();
	}
	
}
