package com.ikojic.decoratorPattern;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLDataProvider implements DataProvider {
	
	private DataSource dataSource;
	
	public URLDataProvider( DataSource dataSource ) {
		
		this.dataSource = dataSource;
		
	}
	
	
	@Override
	public String provideDataFromSource( String source ) {
		
		try {
			
			URL url = new URL( source );
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod( "GET" );
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			File file = File.createTempFile( "data" , null );
			FileOutputStream outputStream = new FileOutputStream( file );
			byte[] buffer = new byte[1024];
			int bytesRead;
			
			while ( (bytesRead = inputStream.read( buffer )) != -1 ) {
				
				outputStream.write( buffer , 0 , bytesRead );
				
			}
			
			outputStream.close();
			inputStream.close();
			
			return dataSource.readData( file );
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
