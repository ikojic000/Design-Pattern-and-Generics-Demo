package com.ikojic.commandPattern.commandAndGUI;


public class SaveToCSV implements CSVCommand {
	
	private CustomTableModel tableModel;
	private String filePath;
	
	public SaveToCSV( CustomTableModel tableModel , String filePath ) {
		
		this.tableModel = tableModel;
		this.filePath = filePath;
		
	}
	
	
	@Override
	public void executeCSV() {
		
		tableModel.saveToCSV( filePath );
		
	}
	
}
