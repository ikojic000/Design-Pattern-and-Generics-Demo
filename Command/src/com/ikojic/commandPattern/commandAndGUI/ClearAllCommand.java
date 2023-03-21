package com.ikojic.commandPattern.commandAndGUI;


public class ClearAllCommand implements DeleteCommand {
	
	private CustomTableModel tableModel;
	private String[] defaultColumnNames;
	private Object[][] defaultTableData;
	private String[] columnNames;
	private Object[][] tableData;
	
	public ClearAllCommand( CustomTableModel tableModel , String[] columnNames , Object[][] tableData ) {
		
		this.tableModel = tableModel;
		this.columnNames = columnNames;
		this.tableData = tableData;
		
	}
	
	
	public ClearAllCommand( CustomTableModel tableModel , String[] defaultColumnNames , Object[][] defaultTableData ,
							String[] columnNames , Object[][] tableData ) {
		
		this.tableModel = tableModel;
		this.defaultColumnNames = defaultColumnNames;
		this.defaultTableData = defaultTableData;
		this.columnNames = columnNames;
		this.tableData = tableData;
		
	}
	
	
	@Override
	public void executeDeleteCMD() {
		
		System.out.println( "Executing ClearAllCommand" );
//		Pozivanje setTableData s praznim listama za columnNames i tableData
//		tableModel.setTableData( new String[0] , new Object[0][0] );
		
//		Pozivanje setTableData s listama defaultColumnNames i defaultTableData (od pocetno zadanje tablice)
		tableModel.setTableData( defaultColumnNames , defaultTableData );
		
	}
	
	
	@Override
	public void undoDeleteCMD() {
		
		System.out.println( "Undo ClearAllCommand" );
//		ColumnNames i tableData prije brisanja su spremljeni u objektu pa ih koristimo u setTableData da bi se vratilo prijasnje stanje 
		tableModel.setTableData( columnNames , tableData );
		
	}
	
	
	@Override
	public void redoDeleteCMD() {
		
		System.out.println( "Redo ClearAllCommand" );
//		Isto kao i executeDeleteCMD()
//		Pozivanje setTableData s praznim listama za columnNames i tableData
//		tableModel.setTableData( new String[0] , new Object[0][0] );
		
//		Pozivanje setTableData s listama defaultColumnNames i defaultTableData (od pocetno zadanje tablice)
		tableModel.setTableData( defaultColumnNames , defaultTableData );
		
	}
	
}
