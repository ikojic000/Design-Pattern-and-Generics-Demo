package com.ikojic.decoratorPattern;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


/**
 * This class is a concrete implementation of the DataSourceDecorator class and
 * provides data encryption capabilities. It takes a DataSource object and uses
 * its writeData() and readData() methods to write and read data respectively,
 * while also encrypting and decrypting the data using Base64 encoding.
 */
public class EncryptionDecorator extends DataSourceDecorator {
	
	/**
	 * Constructs an EncryptionDecorator object with the given DataSource object.
	 * 
	 * @param dataSource the DataSource object to be decorated
	 */
	public EncryptionDecorator( DataSource dataSource ) {
		
		super( dataSource );
		
	}
	
	
	/**
	 * Encodes the data string using Base64 encoding and passes the encoded data to
	 * the writeData() method of the wrapped DataSource object to write the data to
	 * a file.
	 * 
	 * @param data the data string to be written to the file
	 * @param file the file to which the data should be written
	 */
	@Override
	public void writeData( String data , File file ) {
		
//		Encode the data string using Base64 encoding
		byte[] encryptedData = Base64.getEncoder().encode( data.getBytes( StandardCharsets.UTF_8 ) );
		
//		Convert the byte array to a string using UTF-8 encoding
		String encryptedDataString = new String( encryptedData , StandardCharsets.UTF_8 );
		
//		Print a message indicating that encrypted data is being written to the file
		System.out.println( "Writing encrypted data to " + file.getPath() );
		
//		Pass the encoded data string to the writeData() method of the wrapped DataSource object to write the data to a file
		dataSource.writeData( encryptedDataString , file );
		
	}
	
	
	/**
	 * Reads the data from the file using the readData() method of the wrapped
	 * DataSource object, decodes the data using Base64 encoding, and returns the
	 * decrypted data string.
	 * 
	 * @param file the file from which the data should be read
	 * @return the decrypted data string
	 */
	@Override
	public String readData( File file ) {
		
//		Read the encrypted data from the file using the readData() method of the wrapped DataSource object
		String encryptedData = dataSource.readData( file );
		
//		Decode the encrypted data using Base64 encoding
		byte[] decryptedData = Base64.getDecoder().decode( encryptedData.getBytes( StandardCharsets.UTF_8 ) );
		
//		Convert the decrypted byte array to a string using UTF-8 encoding
		String decryptedDataString = new String( decryptedData , StandardCharsets.UTF_8 );
		
		System.out.println( "Reading/Decrypting encrypted data from " + file.getPath() );
		
//		Return the decompressed data as a string
		return decryptedDataString;
		
	}
	
}
