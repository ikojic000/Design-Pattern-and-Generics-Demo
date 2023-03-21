package com.ikojic.decoratorPattern;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;


/**
 * A class representing a data source that can write and read data to/from a
 * URL.
 */
public class URLDataSource implements DataSource {
	
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
		
		StringBuilder sb = new StringBuilder();
		
		try {
			
			try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
				
				String line;
				
				while ( (line = reader.readLine()) != null ) {
					
					sb.append( line ).append( "\n" );
					
				}
				
			}
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
		return sb.toString();
		
	}
	
}
