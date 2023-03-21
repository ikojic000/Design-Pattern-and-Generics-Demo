package com.ikojic.commandPattern.design;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class TableCell extends JLabel {
	
	private final CellType cellType;
	private boolean selected;
	
	public TableCell( Object obj ) {
		
		// This for column header jtable
		setFont( new Font( "Century Gothic" , Font.BOLD , 15 ) );
		this.cellType = CellType.EMPTY;
		
		if ( obj != null ) {
			
			setText( obj.toString() );
			
		}
		
		setBorder( new EmptyBorder( 10 , 10 , 10 , 10 ) );
		setForeground( new Color( 121 , 118 , 118 ) );
		
	}
	
	
	public TableCell( Object obj , boolean selected , CellType cellType ) {
		
		// This for cell jtable
		this.selected = selected;
		this.cellType = cellType;
		
		if ( obj != null ) {
			
			setText( obj.toString() );
			
		}
		
		setFont( new Font( "Century Gothic" , Font.PLAIN , 13 ) );
		setBorder( new EmptyBorder( 10 , 10 , 10 , 10 ) );
		setForeground( new Color( 80 , 80 , 80 ) );
		
	}
	
	
	@Override
	protected void paintComponent( Graphics grphcs ) {
		
		int width = getWidth() + 5;
		int height = getHeight() - 4;
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON );
		g2.setColor( Color.WHITE );
		
		if ( cellType == CellType.LEFT ) {
			
			g2.fillRoundRect( 0 , 2 , width , height , 6 , 6 );
			
			if ( selected ) {
				
				g2.setColor( new Color( 61 , 154 , 226 ) );
				g2.setStroke( new BasicStroke( 2f ) );
				g2.drawRoundRect( 1 , 2 , width , height , 6 , 6 );
				
			}
			
		} else if ( cellType == CellType.RIGHT ) {
			
			g2.fillRoundRect( -5 , 2 , width , height , 6 , 6 );
			
			if ( selected ) {
				
				g2.setColor( new Color( 61 , 154 , 226 ) );
				g2.setStroke( new BasicStroke( 2f ) );
				g2.drawRoundRect( -5 , 2 , width - 2 , height , 6 , 6 );
				
			}
			
		} else if ( cellType == CellType.CENTER ) {
			
			g2.fillRect( 0 , 2 , width , height );
			
			if ( selected ) {
				
				g2.setColor( new Color( 61 , 154 , 226 ) );
				g2.setStroke( new BasicStroke( 2f ) );
				g2.drawRect( -5 , 2 , width + 2 , height );
				
			}
			
		} else {
			
			g2.setColor( new Color( 244 , 244 , 249 ) );
			g2.fillRect( 0 , 0 , getWidth() , getHeight() );
			
		}
		
		super.paintComponent( grphcs );
		
	}
	
	public static enum CellType {
								 LEFT , RIGHT , CENTER , EMPTY
	}
	
}
