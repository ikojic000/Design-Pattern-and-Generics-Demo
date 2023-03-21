package com.ikojic.commandPattern.commandAndGUI;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class CustomTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504509394586352421L;
	private Object[][] tableData;
	private String[] columnNames;
	
	public CustomTableModel( String tableData[][] , String columnNames[] ) {
		
		this.tableData = tableData;
		this.columnNames = columnNames;
		
	}
	
	
	@Override
	public int getRowCount() {
		
		return tableData.length;
		
	}
	
	
	@Override
	public int getColumnCount() {
		
		return columnNames.length;
		
	}
	
	
	@Override
	public String getColumnName( int column ) {
		
		return columnNames[column];
		
	}
	
	
	@Override
	public Object getValueAt( int rowIndex , int columnIndex ) {
		
		return tableData[rowIndex][columnIndex];
		
	}
	
	
	public String[] getColumnNames() {
		
		return columnNames;
		
	}
	
	
	public Object[][] getTableData() {
		
		return tableData;
		
	};
	
	
	public Object[] getRowData( int rowID ) {
		
		return tableData[rowID];
		
	}
	
	
	public Object[] getColumnData( int columnID ) {
		
		int rowCount = getRowCount();
		Object[] column = new Object[rowCount];
		
		for ( int i = 0; i < rowCount; i++ ) {
			
			column[i] = tableData[i][columnID];
			
		}
		
		return column;
		
	}
	
	
	public void setTableData( String[] columnNames , Object[][] tableData ) {
		
		this.columnNames = columnNames;
		this.tableData = tableData;
		fireTableStructureChanged();
		
	}
	
	
	public void loadFromCSV( String filePath ) {
		
		ArrayList<Object[]> rows = new ArrayList<>();
		
		try ( BufferedReader br = new BufferedReader( new FileReader( filePath ) ) ) {
			
			String line;
			boolean firstLine = true;
			
			while ( (line = br.readLine()) != null ) {
				
				String[] values = line.split( "," );
				
				if ( firstLine ) {
					
					columnNames = values;
					firstLine = false;
					
				} else {
					
					rows.add( values );
					
				}
				
			}
			
			tableData = rows.toArray( new Object[rows.size()][] );
			
		} catch ( IOException e ) {
			
			System.out.println( e );
			
		}
		
		setTableData( columnNames , tableData );
		fireTableStructureChanged();
		
	}
	
	
	public void saveToCSV( String filePath ) {
		
		try ( BufferedWriter bw = new BufferedWriter( new FileWriter( filePath ) ) ) {
			
//			ColumnNames - Naslov stupaca u prvi red
			for ( int i = 0; i < columnNames.length; i++ ) {
				
				bw.write( columnNames[i] );
				
				if ( i < columnNames.length - 1 ) {
					
					bw.write( "," );
					
				}
				
			}
			
			bw.newLine();
			
//			*** TableData ***
//			Prva For petlja (i) vrti redove tablice
			for ( int i = 0; i < tableData.length; i++ ) {
				
//				Druga For petlja (j) vrti stupce tablice
				for ( int j = 0; j < tableData[i].length; j++ ) {
					
					bw.write( String.valueOf( tableData[i][j] ) );
					
					if ( j < tableData[i].length - 1 ) {
						
						bw.write( "," );
						
					}
					
				}
				
				bw.newLine();
				
			}
			
		} catch ( Exception e ) {
			
			System.out.println( e );
			
		}
		
	}
	
	
	public void deleteRow( int rowID ) {
		
		if ( getRowCount() != 0 ) {
			
//			Novi row data za 1 manji od starog jer smo izbrisali jedan i istog broja stupaca
			Object[][] newTableData = new Object[getRowCount() - 1][getColumnCount()];
			
			for ( int i = 0; i < getRowCount(); i++ ) {
				
				if ( i < rowID ) {
					
//					Ako je red kojeg brisemo veci od trenutacne for petlje onda redovi ostaju na svom mjestu
					newTableData[i] = tableData[i];
					
				} else if ( i > rowID ) {
					
//					Ako je red kojeg brisemo manji od for petlje onda se svi pomicu za 1 gore, odnosno i - 1
					newTableData[i - 1] = tableData[i];
					
				}
				
			}
			
			tableData = newTableData;
			fireTableDataChanged();
			
		}
		
	}
	
	
	public void insertRow( int rowID , Object[] rowData ) {
		
		int rowCount = getRowCount();
		Object[][] newTableData = new Object[rowCount + 1][getColumnCount()];
		
		for ( int i = 0; i < rowCount; i++ ) {
			
			if ( i < rowID ) {
				
//				Ako je red kojeg ubacujemo manji od trenutacne for petlje onda redovi ostaju na svom mjestu
				newTableData[i] = tableData[i];
				
			} else if ( i >= rowID ) {
				
//				Ako je red kojeg brisemo veci od trenutacne for petlje onda se svi pomicu za 1 dolje, odnosno i + 1
				newTableData[i + 1] = tableData[i];
				
			}
			
		}
		
		newTableData[rowID] = rowData;
		tableData = newTableData;
		fireTableDataChanged();
		
	}
	
	
	public void deleteColumn( int columnID ) {
		
		if ( getColumnCount() != 0 ) {
			
			String[] newColumnNames = new String[getColumnCount() - 1];
			Object[][] newTableData = new Object[getRowCount()][getColumnCount() - 1];
			
			for ( int i = 0; i < getColumnCount(); i++ ) {
				
				if ( i < columnID ) {
					
					newColumnNames[i] = columnNames[i];
					
					for ( int j = 0; j < getRowCount(); j++ ) {
						
						newTableData[j][i] = tableData[j][i];
						
					}
					
				} else if ( i > columnID ) {
					
					newColumnNames[i - 1] = columnNames[i];
					
					for ( int j = 0; j < getRowCount(); j++ ) {
						
						newTableData[j][i - 1] = tableData[j][i];
						
					}
					
				}
				
			}
			
			columnNames = newColumnNames;
			tableData = newTableData;
			fireTableStructureChanged();
			
		}
		
	}
	
	
	public void insertColumn( int columnID , String columnName , Object[] columnData ) {
		
		int columnCount = getColumnCount();
		
		String[] newColumnNames = new String[columnCount + 1];
		Object[][] newTableData = new Object[getRowCount()][columnCount + 1];
		
		for ( int i = 0; i < columnCount; i++ ) {
			
			if ( i < columnID ) {
				
				newColumnNames[i] = columnNames[i];
				
				for ( int j = 0; j < getRowCount(); j++ ) {
					
					newTableData[j][i] = tableData[j][i];
					
				}
				
			} else if ( i >= columnID ) {
				
				newColumnNames[i + 1] = columnNames[i];
				
				for ( int j = 0; j < getRowCount(); j++ ) {
					
					newTableData[j][i + 1] = tableData[j][i];
					
				}
				
			}
			
		}
		
		newColumnNames[columnID] = columnName;
		
		if ( columnData != null && columnData.length != 0 ) {
			
			for ( int i = 0; i < getRowCount(); i++ ) {
				
				newTableData[i][columnID] = columnData[i];
				
			}
			
		} else {
			
			for ( int i = 0; i < getRowCount(); i++ ) {
				
				newTableData[i][columnID] = null;
				
			}
			
		}
		
		columnNames = newColumnNames;
		tableData = newTableData;
		fireTableStructureChanged();
		
	}
	
}
