package com.ikojic.decoratorPattern;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * A class representing a data source that can write and read data to/from a
 * file on the local file system.
 */
public class FileDataSource implements DataSource {
	
	@Override
	public void writeData( String data , File file ) {
		
		System.out.println( "Writing data... " );
		
		try {
			
			Files.writeString( file.toPath() , data );
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	@Override
	public String readData( File file ) {
		
		System.out.println( "Reading data... " );
		
		try {
			
			Path path = Paths.get( file.getAbsolutePath() );
			return Files.readString( path );
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
