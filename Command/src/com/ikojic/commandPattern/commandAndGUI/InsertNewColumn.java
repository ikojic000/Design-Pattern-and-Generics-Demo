package com.ikojic.commandPattern.commandAndGUI;


public class InsertNewColumn implements DeleteCommand {
	
	private CustomTableModel tableModel;
	private int columnID;
	private String columnName;
	private Object[] columnData = {};
	
	public InsertNewColumn( CustomTableModel tableModel , int columnID , String columnName ) {
		
		this.tableModel = tableModel;
		this.columnID = columnID;
		this.columnName = columnName;
		
	}
	
	
	@Override
	public void executeDeleteCMD() {
		
		System.out.println( "Insert new Column" );
		tableModel.insertColumn( columnID + 1 , columnName , columnData );
		
	}
	
	
	@Override
	public void undoDeleteCMD() {
		
		System.out.println( "Undo Insert new Column" );
		tableModel.deleteColumn( columnID + 1 );
		
	}
	
	
	@Override
	public void redoDeleteCMD() {
		
		System.out.println( "Redo Insert new Column" );
		tableModel.insertColumn( columnID + 1 , columnName , columnData );
		
	}
	
}
