package com.ikojic.decoratorPattern;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


public class CompressionDecorator extends DataSourceDecorator {
	
	public CompressionDecorator( DataSource dataSource ) {
		
		super( dataSource );
		
	}
	
	
	@Override
	public void writeData( String data , File file ) {
		
		Deflater deflater = new Deflater();
		deflater.setInput( data.getBytes() );
		deflater.finish();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream( data.length() );
		byte[] buffer = new byte[1024];
		
		while ( !deflater.finished() ) {
			
			int count = deflater.deflate( buffer );
			outputStream.write( buffer , 0 , count );
			
		}
		
		deflater.end();
		
		byte[] compressedData = outputStream.toByteArray();
		String encodedData = Base64.getEncoder().encodeToString( compressedData );
		
		System.out.println( "Writing compressed data to " + file.getPath() );
		
		dataSource.writeData( encodedData , file );
		
	}
	
	
	@Override
	public String readData( File file ) {
		
		try {
			
			String encodedData = dataSource.readData( file );
			byte[] compressedData = Base64.getDecoder().decode( encodedData );
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			Inflater inflater = new Inflater();
			inflater.setInput( compressedData );
			byte[] buffer = new byte[1024];
			int count;
			
			while ( (count = inflater.inflate( buffer )) > 0 ) {
				
				bos.write( buffer , 0 , count );
				
			}
			
			inflater.end();
			byte[] decompressedData = bos.toByteArray();
			String decompressedDataString = new String( decompressedData , "UTF-8" );
			
			System.out.println( "Reading/Decompressing compressed data from " + file.getPath() );
			
			return decompressedDataString;
			
		} catch ( IOException | DataFormatException e ) {
			
			System.out.println( "Error: " + e.getMessage() );
			
		}
		
		return null;
		
	}
	
}
