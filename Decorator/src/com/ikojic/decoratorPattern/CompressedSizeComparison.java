package com.ikojic.decoratorPattern;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;


public class CompressedSizeComparison {
	
	public static void test() {
		
		File originalFile = new File( "txtFiles/testNew.txt" );
		
		File compressedFile = createFile( "txtFiles/compressedTest.txt" );
		
		DataProvider txtProvider = new FileDataProvider( new FileDataSource() );
		DataSource txtData = new CompressionDecorator( new FileDataSource() );
		txtData.writeData( txtProvider.provideDataFromSource( originalFile.getPath() ) , compressedFile );
		
		calculateCompression( originalFile , compressedFile );
		
		System.out.println( "\nOriginal Data:\n" + txtData.readData( compressedFile ) );
		
	}
	
	
	/**
	 * Used for creating new File. If a file with given path does not exist, new
	 * file is created.
	 * 
	 * @param path - path to the file that needs to be created
	 * @return file - File object created with given path
	 */
	private static File createFile( String path ) {
		
		File file = new File( path );
		
		try {
			
			if ( !file.exists() ) {
				
				System.out.println( "Creating new file " + path );
				file.createNewFile();
				
			}
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
		return file;
		
	}
	
	
	/**
	 * Used for comparing sizes of original and compressed file, calculates the
	 * percentage and prints out that information.
	 * 
	 * @param originalFile   - original file that will be decorated(compressed in
	 *                       this case)
	 * @param compressedFile - decorated(compressed) file
	 */
	private static void calculateCompression( File originalFile , File compressedFile ) {
		
		try {
			
			long originalSize = Files.size( originalFile.toPath() );
			long compressedSize = Files.size( compressedFile.toPath() );
			System.out.println( "Original File Size - " + originalSize );
			System.out.println( "Compressed File Size - " + compressedSize );
			double compressionRatio = (double) compressedSize / originalSize * 100;
			DecimalFormat df = new DecimalFormat( "#.##" );
			System.out.println( "Compressed size comparison - " + df.format( compressionRatio ) + "%" );
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
