package com.ikojic.decoratorPattern;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class EncryptionDecorator extends DataSourceDecorator {
	
	public EncryptionDecorator( DataSource dataSource ) {
		
		super( dataSource );
		
	}
	
	
	@Override
	public void writeData( String data , File file ) {
		
		byte[] encryptedData = Base64.getEncoder().encode( data.getBytes( StandardCharsets.UTF_8 ) );
		
		String encryptedDataString = new String( encryptedData , StandardCharsets.UTF_8 );
		
		System.out.println( "Writing encrypted data to " + file.getPath() );
		
		dataSource.writeData( encryptedDataString , file );
		
	}
	
	
	@Override
	public String readData( File file ) {
		
		String encryptedData = dataSource.readData( file );
		
		byte[] decryptedData = Base64.getDecoder().decode( encryptedData.getBytes( StandardCharsets.UTF_8 ) );
		
		String decryptedDataString = new String( decryptedData , StandardCharsets.UTF_8 );
		
		System.out.println( "Reading/Decrypting encrypted data from " + file.getPath() );
		
		return decryptedDataString;
		
	}
	
}
