package com.ikojic.decoratorPattern;


import java.io.File;


public class App {
	
	public static void main( String[] args ) {
		
		DataProvider txtProvider = new FileDataProvider( new FileDataSource() );
		
		DataSource txtData = new CompressionDecorator( new EncryptionDecorator( new FileDataSource() ) );
		
//		Path to original data file 
		String originalDataPath = "txtFiles/test.txt";
		
//		Path to decorated data file 
		String decoratedDataPath = "txtFiles/testDecorated.txt";
		
		txtData.writeData( txtProvider.provideDataFromSource( originalDataPath ) , new File( decoratedDataPath ) );
		
		System.out.println( "\nOriginal Data:\n" + txtData.readData( new File( decoratedDataPath ) ) );
		
		CompressedSizeComparison.test();
		
	}
	
}
