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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import com.cgmosele.vehicleServiceLog.util.Car;

public class VehicleServiceLogGUI extends JFrame {

	static final long serialVersionUID = -1991087826556056121L;

	private JScrollPane mainPanel = new JScrollPane();
	private JPanel buttonPanel = new JPanel();
	private JButton addCar = new JButton( "Add Car" );
	private JButton changeOil = new JButton( "Change Oil" );
	private JButton help = new JButton( "Help" );
	private JButton info = new JButton( "Oil Information");

	private JTable carTable;
	
	private VehicleServiceLogUI garage;
	private Car[] cars;
	
	private String[][] carTab;
	
	public VehicleServiceLogGUI() {
		
		String[] col = { "Vehicle", 
				 "Current Mileage",
				 "Next Mileage",
				 "Special Codes" };
		
		try {
			cars = garage.getCars();
			carTab = garage.getTable();
		} catch ( NullPointerException e ) {
			cars = new Car[ 10 ];
			carTab = new String[ 10 ][ 4 ];
		}

		carTable = new JTable( carTab, col );
		
		TableColumn column = null;
		for (int i = 0; i < 4; i++) {
		    column = carTable.getColumnModel().getColumn(i);
		    if (i == 0) {
		        column.setPreferredWidth(200); //third column is bigger
		    } else {
		        column.setPreferredWidth(50);
		    }
		}
		
		carTable.setRowHeight( 500 / carTable.getRowCount() );
		
	}
	
	private void startFrame() {
		this.setVisible( true );
		this.setMinimumSize( new Dimension( 800, 500 ) );
		this.setTitle( "Vehicle Service Log" );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	private void addComponents() {
		this.setLayout( new BorderLayout() );
		
		
		// Add components to main panel
		mainPanel = new JScrollPane( carTable );
		carTable.setFillsViewportHeight( true );
		
		//Add components to button panel ( just buttons )
		buttonPanel.add( addCar );
		buttonPanel.add( changeOil );
		buttonPanel.add( help );
		buttonPanel.add( info );
		
		//activate the buttons with action listeners and assign actions
		activateButtons();
		
		this.add( mainPanel );
		this.add( buttonPanel, BorderLayout.SOUTH );
		
	}
	
	private void activateButtons() {
		addCar.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				AddCarDialog ad = new AddCarDialog( new JFrame(), true );
				Car c;
				if ( ( c = ad.onReturn() ) == null ){
					return;
				}
				int l = getLength();
				cars[ l ] = c;
				carTab[ l ][ 0 ] = c.getYear() + " " + c.getMake() + " " + c.getModel();
				carTab[l ][ 1 ] = c.getMileage() + "";
				carTab[ l ][ 2 ] = c.getOilType() == 'S' ? c.getMileage() + 3000 + " " : c.getMileage() + 5000 + " ";
				carTab[ l ][ 3 ] = c.getSpecCode();
				
			}
		});
		
		changeOil.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				int i = carTable.getSelectedRow();
				if ( i == -1 ) {
					JOptionPane.showMessageDialog( VehicleServiceLogGUI.this, "Please select a vehicle before attempting to change the oil", 
							"Error: No Vehicle Selected", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				ChangeOilDialog cd = new ChangeOilDialog( VehicleServiceLogGUI.this, true );
				int mileage = cd.getMileage();
				System.out.println( i );
				Car c = cars[ i ];
				System.out.println( c.toString() );
				c.setMileage( mileage );
				carTab[ i ][ 1 ] = c.getMileage() + "";
				carTab[ i ][ 2 ] = c.getOilType() == 'S' ? c.getMileage() + 3000 + " " : c.getMileage() + 5000 + " ";
				
			}
		});
		
		help.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				String url = "C:\\Vehicle Service Log\\help.html";
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
	
	public int getLength() {
		int count = 0;
		for ( int i = 0; i < cars.length ; i++ ) {
			if( cars[ i ] != null )
				count++;
		}
		return count;
	}
	
}
