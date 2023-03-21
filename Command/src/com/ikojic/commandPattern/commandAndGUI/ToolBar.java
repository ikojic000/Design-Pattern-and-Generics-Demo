package com.ikojic.commandPattern.commandAndGUI;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import com.ikojic.commandPattern.design.ButtonToolBar;


public class ToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1835435995331356939L;
	private ButtonToolBar btnOpen;
	private ButtonToolBar btnSave;
	private ButtonToolBar btnDeleteRow;
	private ButtonToolBar btnDeleteColumn;
	private ButtonToolBar btnClearAll;
	private ButtonToolBar btnUndo;
	private ButtonToolBar btnRedo;
	private ButtonToolBar btnNewColumn;
	
	public ToolBar() {
		
		setBackground( new Color( 244 , 244 , 249 ) );
		setFloatable( false );
		
		Dimension toolBarBtnDims = new Dimension();
		toolBarBtnDims.width = 50;
		toolBarBtnDims.height = 50;
		
		btnOpen = new ButtonToolBar();
		btnOpen.setFocusPainted( false );
		btnOpen.setMinimumSize( toolBarBtnDims );
		btnOpen.setMaximumSize( toolBarBtnDims );
		btnOpen.setPreferredSize( toolBarBtnDims );
		btnOpen.setToolTipText( "Import new data from CSV File" );
		btnOpen.setIcon( new ImageIcon( this.getClass().getResource( "/open.png" ) ) );
		
		btnSave = new ButtonToolBar();
		btnSave.setFocusPainted( false );
		btnSave.setMinimumSize( toolBarBtnDims );
		btnSave.setMaximumSize( toolBarBtnDims );
		btnSave.setPreferredSize( toolBarBtnDims );
		btnSave.setToolTipText( "Save data to new CSV File" );
		btnSave.setIcon( new ImageIcon( this.getClass().getResource( "/save.png" ) ) );
		
		btnDeleteRow = new ButtonToolBar();
		btnDeleteRow.setFocusPainted( false );
		btnDeleteRow.setMinimumSize( toolBarBtnDims );
		btnDeleteRow.setMaximumSize( toolBarBtnDims );
		btnDeleteRow.setPreferredSize( toolBarBtnDims );
		btnDeleteRow.setToolTipText( "Delete row from the Table" );
		btnDeleteRow.setIcon( new ImageIcon( this.getClass().getResource( "/deleteRow.png" ) ) );
		
		btnDeleteColumn = new ButtonToolBar();
		btnDeleteColumn.setFocusPainted( false );
		btnDeleteColumn.setMinimumSize( toolBarBtnDims );
		btnDeleteColumn.setMaximumSize( toolBarBtnDims );
		btnDeleteColumn.setPreferredSize( toolBarBtnDims );
		btnDeleteColumn.setToolTipText( "Delete column from the Table" );
		btnDeleteColumn.setIcon( new ImageIcon( this.getClass().getResource( "/deleteColumn.png" ) ) );
		
		btnClearAll = new ButtonToolBar();
		btnClearAll.setFocusPainted( false );
		btnClearAll.setMinimumSize( toolBarBtnDims );
		btnClearAll.setMaximumSize( toolBarBtnDims );
		btnClearAll.setPreferredSize( toolBarBtnDims );
		btnClearAll.setToolTipText( "Remove all data from the Table" );
		btnClearAll.setIcon( new ImageIcon( this.getClass().getResource( "/clearAll.png" ) ) );
		
		btnUndo = new ButtonToolBar();
		btnUndo.setFocusPainted( false );
		btnUndo.setMinimumSize( toolBarBtnDims );
		btnUndo.setMaximumSize( toolBarBtnDims );
		btnUndo.setPreferredSize( toolBarBtnDims );
		btnUndo.setToolTipText( "Undo the last change" );
		btnUndo.setIcon( new ImageIcon( this.getClass().getResource( "/undo.png" ) ) );
		
		btnRedo = new ButtonToolBar();
		btnRedo.setFocusPainted( false );
		btnRedo.setMinimumSize( toolBarBtnDims );
		btnRedo.setMaximumSize( toolBarBtnDims );
		btnRedo.setPreferredSize( toolBarBtnDims );
		btnRedo.setToolTipText( "Redo the last action" );
		btnRedo.setIcon( new ImageIcon( this.getClass().getResource( "/redo.png" ) ) );
		
		btnNewColumn = new ButtonToolBar();
		btnNewColumn.setFocusPainted( false );
		btnNewColumn.setMinimumSize( toolBarBtnDims );
		btnNewColumn.setMaximumSize( toolBarBtnDims );
		btnNewColumn.setPreferredSize( toolBarBtnDims );
		btnNewColumn.setToolTipText( "Redo the last action" );
		btnNewColumn.setIcon( new ImageIcon( this.getClass().getResource( "/addColumn.png" ) ) );
		
		initToolBarLayout();
		
	}
	
	
	private void initToolBarLayout() {
		
		add( btnOpen );
		add( btnSave );
		add( btnDeleteRow );
		add( btnDeleteColumn );
		add( btnClearAll );
		add( btnUndo );
		add( btnRedo );
		add( btnNewColumn );
		
	}
	
	
	public ButtonToolBar getBtnOpen() {
		
		return btnOpen;
		
	}
	
	
	public ButtonToolBar getBtnSave() {
		
		return btnSave;
		
	}
	
	
	public ButtonToolBar getBtnDeleteRow() {
		
		return btnDeleteRow;
		
	}
	
	
	public ButtonToolBar getBtnDeleteColumn() {
		
		return btnDeleteColumn;
		
	}
	
	
	public ButtonToolBar getBtnClearAll() {
		
		return btnClearAll;
		
	}
	
	
	public ButtonToolBar getBtnUndo() {
		
		return btnUndo;
		
	}
	
	
	public ButtonToolBar getBtnRedo() {
		
		return btnRedo;
		
	}
	
	
	public ButtonToolBar getBtnNewColumn() {
		
		return btnNewColumn;
		
	}
	
}
