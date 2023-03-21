package com.ikojic.commandPattern.design;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class CustomTable extends JTable {
	
	public CustomTable() {
		
		setBackground( new Color( 244 , 244 , 249 ) );
		setRowHeight( 40 );
		setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		getTableHeader().setDefaultRenderer( new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent( JTable jtable , Object o , boolean bln , boolean bln1 ,
															int i , int i1 ) {
				
				return new TableCell( o );
				
			}
			
		} );
		
		getTableHeader().addMouseListener( new MouseAdapter() {
			
			public void mouseClicked( MouseEvent e ) {
				
				int col = tableHeader.columnAtPoint( e.getPoint() );
				
				if ( tableHeader.getCursor().getType() == Cursor.E_RESIZE_CURSOR )
					e.consume();
				else {
					
					setColumnSelectionAllowed( true );
					setRowSelectionAllowed( false );
					clearSelection();
					setColumnSelectionInterval( col , col );
					
				}
				
			}
			
		} );
		
		addMouseListener( new MouseAdapter() {
			
			public void mouseClicked( MouseEvent e ) {
				
				setColumnSelectionAllowed( false );
				setRowSelectionAllowed( true );
				
			}
			
		} );
		
	}
	
	
	@Override
	public Component prepareRenderer( TableCellRenderer tcr , int i , int i1 ) {
		
		TableCell.CellType celLType = TableCell.CellType.CENTER;
		
		if ( i1 == 0 ) {
			
			celLType = TableCell.CellType.LEFT;
			
		} else if ( i1 == getColumnCount() - 1 ) {
			
			celLType = TableCell.CellType.RIGHT;
			
		}
		
		return new TableCell( getValueAt( i , i1 ) , isCellSelected( i , i1 ) , celLType );
		
	}
	
}
