package com.ikojic.commandPattern.commandAndGUI;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


public class MenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2403438767334735323L;
	private JMenu fileMenu;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JSeparator separator;
	private JMenuItem exitMenuItem;
	private JMenu editMenu;
	private JMenuItem undoMenuItem;
	private JMenuItem redoMenuItem;
	private JSeparator separator2;
	private JMenuItem deleteRowMenuItem;
	private JMenuItem deleteColumnMenuItem;
	private JMenuItem clearAllMenuItem;
	private JMenuItem newColumnMenuItem;
	private JSeparator separator3;
	
	public MenuBar() {
		
		setOpaque( false );
		setMargin( new Insets( 20 , 0 , 10 , 0 ) );
		setBackground( new Color( 244 , 244 , 249 ) );
		setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		
		fileMenu = new JMenu( "File" );
		fileMenu.setFont( new Font( "Corbel" , Font.BOLD , 15 ) );
		fileMenu.setBackground( new Color( 244 , 244 , 249 ) );
		
		openMenuItem = new JMenuItem( "Open" );
		openMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		openMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		openMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		openMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		openMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		openMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'O' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		saveMenuItem = new JMenuItem( "Save" );
		saveMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		saveMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		saveMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		saveMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		saveMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		saveMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'S' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		separator = new JSeparator();
		
		exitMenuItem = new JMenuItem( "Exit" );
		exitMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		exitMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		exitMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		exitMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		exitMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		exitMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'X' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		editMenu = new JMenu( "Edit" );
		editMenu.setFont( new Font( "Corbel" , Font.BOLD , 15 ) );
		editMenu.setBackground( new Color( 244 , 244 , 249 ) );
		
		undoMenuItem = new JMenuItem( "Undo" );
		undoMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		undoMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		undoMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		undoMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		undoMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		undoMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'Z' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		redoMenuItem = new JMenuItem( "Redo" );
		redoMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		redoMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		redoMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		redoMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		redoMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		redoMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'Y' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		separator2 = new JSeparator();
		
		deleteRowMenuItem = new JMenuItem( "Delete row" );
		deleteRowMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		deleteRowMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		deleteRowMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		deleteRowMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		deleteRowMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		deleteRowMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'R' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		deleteColumnMenuItem = new JMenuItem( "Delete column" );
		deleteColumnMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		deleteColumnMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		deleteColumnMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		deleteColumnMenuItem.setPreferredSize( new Dimension( 150 , 30 ) );
		deleteColumnMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		deleteColumnMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'C' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		clearAllMenuItem = new JMenuItem( "Clear all" );
		clearAllMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		clearAllMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		clearAllMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		clearAllMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		clearAllMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		clearAllMenuItem.setAccelerator(
				KeyStroke.getKeyStroke( 'A' , Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx() ) );
		
		separator3 = new JSeparator();
		
		newColumnMenuItem = new JMenuItem( "New Column" );
		newColumnMenuItem.setFont( new Font( "Corbel" , Font.PLAIN , 15 ) );
		newColumnMenuItem.setHorizontalTextPosition( SwingConstants.LEADING );
		newColumnMenuItem.setBackground( new Color( 244 , 244 , 249 ) );
		newColumnMenuItem.setPreferredSize( new Dimension( 120 , 30 ) );
		newColumnMenuItem.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		
		initMenuLayout();
		
	}
	
	
	private void initMenuLayout() {
		
		add( fileMenu );
		fileMenu.add( openMenuItem );
		fileMenu.add( saveMenuItem );
		fileMenu.add( separator );
		fileMenu.add( exitMenuItem );
		add( editMenu );
		editMenu.add( undoMenuItem );
		editMenu.add( redoMenuItem );
		editMenu.add( separator2 );
		editMenu.add( deleteRowMenuItem );
		editMenu.add( deleteColumnMenuItem );
		editMenu.add( clearAllMenuItem );
		editMenu.add( separator3 );
		editMenu.add( newColumnMenuItem );
		
	}
	
	
	public JMenu getFileMenu() {
		
		return fileMenu;
		
	}
	
	
	public JMenuItem getOpenMenuItem() {
		
		return openMenuItem;
		
	}
	
	
	public JMenuItem getSaveMenuItem() {
		
		return saveMenuItem;
		
	}
	
	
	public JMenuItem getExitMenuItem() {
		
		return exitMenuItem;
		
	}
	
	
	public JMenu getEditMenu() {
		
		return editMenu;
		
	}
	
	
	public JMenuItem getUndoMenuItem() {
		
		return undoMenuItem;
		
	}
	
	
	public JMenuItem getRedoMenuItem() {
		
		return redoMenuItem;
		
	}
	
	
	public JMenuItem getDeleteRowMenuItem() {
		
		return deleteRowMenuItem;
		
	}
	
	
	public JMenuItem getDeleteColumnMenuItem() {
		
		return deleteColumnMenuItem;
		
	}
	
	
	public JMenuItem getClearAllMenuItem() {
		
		return clearAllMenuItem;
		
	}
	
	
	public JMenuItem getNewColumnMenuItem() {
		
		return newColumnMenuItem;
		
	}
	
}
