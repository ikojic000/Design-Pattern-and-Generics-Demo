package com.ikojic.commandPattern.commandAndGUI;


public class DeleteRowCommand implements DeleteCommand {
	
	private CustomTableModel tableModel;
	private int rowID;
	private Object[] rowData;
	
	public DeleteRowCommand( CustomTableModel tableModel , int rowID , Object[] rowData ) {
		
		this.tableModel = tableModel;
		this.rowID = rowID;
		this.rowData = rowData;
		
	}
	
	
	@Override
	public void executeDeleteCMD() {
		
		System.out.println( "Execute DeleteRowCommand" );
//		Pozivanje deleteRow funkcije
		tableModel.deleteRow( rowID );
		
	}
	
	
	@Override
	public void undoDeleteCMD() {
		
		System.out.println( "Undo DeleteRowCommand" );
//		rowID i rowData tog reda su spremljeni u objektu pa ih koristimo kako bi ubacili red s tim istim ID-jem i podacima
		tableModel.insertRow( rowID , rowData );
		
	}
	
	
	@Override
	public void redoDeleteCMD() {
		
		System.out.println( "Redo DeleteRowCommand" );
//		Pozivanje deleteRow funkcije
//		Isto kao i executeDeleteCMD()
		tableModel.deleteRow( rowID );
		
	}
	
}
