package com.ikojic.decoratorPattern;


import java.io.File;


public interface DataSource {
	
	void writeData( String data , File file );
	
	String readData( File file );
	
}
