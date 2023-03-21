package com.ikojic.decoratorPattern;


import java.io.File;


/**
 * A class that provides data from a file using the DataSource instance.
 */
public class FileDataProvider implements DataProvider {
	
	private DataSource dataSource;
	
	/**
	 * Constructs a FileDataProvider with the specified DataSource instance.
	 *
	 * @param dataSource the DataSource instance used to read data.
	 */
	public FileDataProvider( DataSource dataSource ) {
		
		this.dataSource = dataSource;
		
	}
	
	
	@Override
	public String provideDataFromSource( String source ) {
		
//		read data from the specified file using the DataSource instance
		return dataSource.readData( new File( source ) );
		
	}
	
}
