package com.ikojic.decoratorPattern;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


/**
 * The CompressionDecorator class is a concrete decorator that extends the
 * DataSourceDecorator abstract class to add compression functionality to the
 * readData() and writeData() methods of a DataSource object. It compresses the
 * data passed to writeData() using Deflater and encodes the compressed data
 * using Base64. It then passes the encoded data to the wrapped DataSource
 * object's writeData() method to write the data to a file. The readData()
 * method reads the encoded data from a file using the wrapped DataSource
 * object's readData() method. It then decodes the encoded data using Base64 and
 * decompresses it using Inflater before returning the original data string.
 * This class overrides the writeData() and readData() methods of the DataSource
 * interface and delegates the call to the same method of the wrapped DataSource
 * object.
 */
public class CompressionDecorator extends DataSourceDecorator {
	
	/**
	 * Constructs a new CompressionDecorator object with the specified DataSource
	 * object to be wrapped.
	 * 
	 * @param dataSource the DataSource object to be wrapped by this decorator
	 */
	public CompressionDecorator( DataSource dataSource ) {
		
		super( dataSource );
		
	}
	
	
	/**
	 * Compresses the data using Deflater, encodes the compressed data using Base64
	 * and passes the encoded data to the writeData() method of the wrapped
	 * DataSource object to write the data to a file.
	 * 
	 * @param data the data string to be written to the file
	 * @param file the file to which the data should be written
	 */
	@Override
	public void writeData( String data , File file ) {
		
//		Create a new Deflater object to compress the data
		Deflater deflater = new Deflater();
		
//		Set the input for the Deflater object to be the data in bytes
		deflater.setInput( data.getBytes() );
		
//		Indicate that we have finished adding input to the Deflater object
		deflater.finish();
		
//		Create a new ByteArrayOutputStream to hold the compressed data
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream( data.length() );
		
//		Create a buffer to hold the compressed data as it is generated
		byte[] buffer = new byte[1024];
		
//		Compress the data using the Deflater object
		while ( !deflater.finished() ) {
			
//			Compress some data and put it into the buffer
			int count = deflater.deflate( buffer );
			
//			Write the compressed data from the buffer to the ByteArrayOutputStream
			outputStream.write( buffer , 0 , count );
			
		}
		
//		Clean up the Deflater object
		deflater.end();
		
//		Get the compressed data as a byte array
		byte[] compressedData = outputStream.toByteArray();
		
//		Encode the compressed data using Base64
		String encodedData = Base64.getEncoder().encodeToString( compressedData );
		
//		Output a message indicating that we are writing compressed data to the file
		System.out.println( "Writing compressed data to " + file.getPath() );
		
//		Pass the encoded data to the writeData() method of the wrapped DataSource object to write the compressed data to a file
		dataSource.writeData( encodedData , file );
		
	}
	
	
	/**
	 * Reads the encoded data from a file using the readData() method of the wrapped
	 * DataSource object. It then decodes the encoded data using Base64 and
	 * decompresses it using Inflater before returning the original data string.
	 * 
	 * @param file the file from which the data should be read
	 * @return the original data string
	 */
	@Override
	public String readData( File file ) {
		
		try {
			
//			Read the encoded data from the file using the wrapped data source
			String encodedData = dataSource.readData( file );
			
//			Decode the base64-encoded data into a byte array
			byte[] compressedData = Base64.getDecoder().decode( encodedData );
			
//			Create an output stream to hold the decompressed data
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
//			Create a new Inflater to decompress the data
			Inflater inflater = new Inflater();
			inflater.setInput( compressedData );
			
//			Create a buffer to hold decompressed data and read data into it
			byte[] buffer = new byte[1024];
			int count;
			
			while ( (count = inflater.inflate( buffer )) > 0 ) {
				
				bos.write( buffer , 0 , count );
				
			}
			
//			End the decompression process and convert the decompressed data to a string
			inflater.end();
			byte[] decompressedData = bos.toByteArray();
			String decompressedDataString = new String( decompressedData , "UTF-8" );
			
			System.out.println( "Reading/Decompressing compressed data from " + file.getPath() );
			
//			Return the decompressed data as a string
			return decompressedDataString;
			
		} catch ( IOException | DataFormatException e ) {
			
//			If an error occurs during reading or decompression, print an error message
//			and return null
			System.out.println( "Error: " + e.getMessage() );
			
		}
		
		return null;
		
	}
	
}
