package com.cgmosele.vehicleServiceLog.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import com.cgmosele.vehicleServiceLog.util.Car;

public class OilLogDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable carTable;
	private String[][] carTab = new String[ 10 ][ 5 ];
	
	private JScrollPane scroll = new JScrollPane();

	/**
	 * Create the dialog.
	 */
	public OilLogDialog( JFrame parent, boolean mod, Car[] cars ) {
		super ( parent, mod );
		setSize( new Dimension( 800, 500 ) );
		setLocationRelativeTo( parent );
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setUpTable();
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void setUpTable() {
		String[] col = { "Vehicle", 
				 "Brand of Oil",
				 "Type of Oil",
				 "Oil Capacity",
				 "Date of Last Service" };
		
		carTable = new JTable( carTab, col );
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		carTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		carTable.setDefaultEditor(Object.class, null);
		
		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
		    column = carTable.getColumnModel().getColumn(i);
		    if (i == 0) {
		        column.setPreferredWidth(200); //third column is bigger
		    } else {
		        column.setPreferredWidth(50);
		    }
		}
		
		carTable.setRowHeight( 500 / carTable.getRowCount() );
		
		scroll = new JScrollPane( carTable );
		contentPanel.add( scroll );
		
		
	}

}
