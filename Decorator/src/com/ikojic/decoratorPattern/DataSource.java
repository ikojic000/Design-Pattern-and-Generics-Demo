package com.ikojic.decoratorPattern;


import java.io.File;


/**
 * An interface representing a data source that can write and read data to/from
 * a file.
 */
public interface DataSource {
	
	/**
	 * Writes the provided data to the specified file.
	 * 
	 * @param data The data to write.
	 * @param file The file to write the data to.
	 */
	void writeData( String data , File file );
	
	/**
	 * Reads data from the specified file and returns it as a string.
	 * 
	 * @param file The file to read the data from.
	 * @return The data read from the file as a string.
	 */
	String readData( File file );
	
}
