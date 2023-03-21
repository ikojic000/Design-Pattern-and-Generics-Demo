package com.ikojic.commandPattern.commandAndGUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;


public class PopUpMenu extends JPopupMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6964107261578324392L;
	private JMenuItem clearTablePopupItem;
	private JMenuItem importPopItem;
	private JMenuItem savePopItem;
	private JSeparator separator_1;
	private JMenuItem undoPopItem;
	private JMenuItem redoPopItem;
	
	public PopUpMenu() {
		
		clearTablePopupItem = new JMenuItem( "Clear table" );
		clearTablePopupItem.setBackground( new Color( 244 , 244 , 249 ) );
		clearTablePopupItem.setPreferredSize( new Dimension( 120 , 35 ) );
		clearTablePopupItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		
		importPopItem = new JMenuItem( "Import data from CSV" );
		importPopItem.setBackground( new Color( 244 , 244 , 249 ) );
		importPopItem.setPreferredSize( new Dimension( 200 , 35 ) );
		importPopItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		
		savePopItem = new JMenuItem( "Save data to CSV" );
		savePopItem.setBackground( new Color( 244 , 244 , 249 ) );
		savePopItem.setPreferredSize( new Dimension( 200 , 35 ) );
		savePopItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		
		separator_1 = new JSeparator();
		
		undoPopItem = new JMenuItem( "Undo" );
		undoPopItem.setBackground( new Color( 244 , 244 , 249 ) );
		undoPopItem.setPreferredSize( new Dimension( 120 , 35 ) );
		undoPopItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		
		redoPopItem = new JMenuItem( "Redo" );
		redoPopItem.setBackground( new Color( 244 , 244 , 249 ) );
		redoPopItem.setPreferredSize( new Dimension( 120 , 35 ) );
		redoPopItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		
		initPopUp();
		
	}
	
	
	private void initPopUp() {
		
		add( clearTablePopupItem );
		add( importPopItem );
		add( savePopItem );
		add( separator_1 );
		add( undoPopItem );
		add( redoPopItem );
		
	}
	
	
	public JMenuItem getClearTablePopupItem() {
		
		return clearTablePopupItem;
		
	}
	
	
	public JMenuItem getImportPopItem() {
		
		return importPopItem;
		
	}
	
	
	public JMenuItem getSavePopItem() {
		
		return savePopItem;
		
	}
	
	
	public JMenuItem getUndoPopItem() {
		
		return undoPopItem;
		
	}
	
	
	public JMenuItem getRedoPopItem() {
		
		return redoPopItem;
		
	}
	
}
