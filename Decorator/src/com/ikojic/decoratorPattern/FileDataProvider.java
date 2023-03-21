package com.ikojic.decoratorPattern;


import java.io.File;


public class FileDataProvider implements DataProvider {
	
	private DataSource dataSource;
	
	public FileDataProvider( DataSource dataSource ) {
		
		this.dataSource = dataSource;
		
	}
	
	
	@Override
	public String provideDataFromSource( String source ) {
		
		return dataSource.readData( new File( source ) );
		
	}
	
}
