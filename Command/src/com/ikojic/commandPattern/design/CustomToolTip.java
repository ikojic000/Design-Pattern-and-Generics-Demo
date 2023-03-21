package com.ikojic.commandPattern.design;


import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolTip;


public class CustomToolTip extends JToolTip {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5033579918214807559L;
	
	public CustomToolTip( JComponent component ) {
		
		super();
		
		setComponent( component );
		setBackground( new Color( 71 , 70 , 70 ) );
		setForeground( Color.white );
		setFont( new Font( "Corbel" , Font.PLAIN , 16 ) );
		setBorder( BorderFactory.createLineBorder( Color.black , 1 ) );
		
	}
	
}
