package com.ikojic.commandPattern.commandAndGUI;


public class DeleteColumnCommand implements DeleteCommand {
	
	private CustomTableModel tableModel;
	private int columnID;
	private String columnName;
	private Object[] columnData;
	
	public DeleteColumnCommand( CustomTableModel tableModel , int columnID , String columnName , Object[] columnData ) {
		
		this.tableModel = tableModel;
		this.columnID = columnID;
		this.columnName = columnName;
		this.columnData = columnData;
		
	}
	
	
	@Override
	public void executeDeleteCMD() {
		
		System.out.println( "Execute DeleteColumnCommand" );
//		Pozivanje deleteColumn funkcije
		tableModel.deleteColumn( columnID );
		
	}
	
	
	@Override
	public void undoDeleteCMD() {
		
		System.out.println( "Undo DeleteColumnCommand" );
//		columnID, columnName i columnData tog reda su spremljeni u objektu pa ih koristimo kako bi ubacili red s tim istim ID-jem i podacima
		tableModel.insertColumn( columnID , columnName , columnData );
		
	}
	
	
	@Override
	public void redoDeleteCMD() {
		
		System.out.println( "Redo DeleteColumnCommand" );
//		Pozivanje deleteColumn funkcije
//		Isto kao i executeDeleteCMD()
		tableModel.deleteColumn( columnID );
		
	}
	
}
