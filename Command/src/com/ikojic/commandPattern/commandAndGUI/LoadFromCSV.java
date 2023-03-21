package com.ikojic.commandPattern.commandAndGUI;


public class LoadFromCSV implements CSVCommand {
	
	private CustomTableModel tableModel;
	private String filePath;
	
	public LoadFromCSV( CustomTableModel tableModel , String filePath ) {
		
		this.tableModel = tableModel;
		this.filePath = filePath;
		
	}
	
	
	@Override
	public void executeCSV() {
		
		tableModel.loadFromCSV( filePath );
		
	}
	
}
