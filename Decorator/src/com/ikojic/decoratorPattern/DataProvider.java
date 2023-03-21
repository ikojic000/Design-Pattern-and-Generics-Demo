package com.ikojic.decoratorPattern;


/**
 * A interface that defines the contract for providing data from a source.
 */
public interface DataProvider {
	
	/**
	 * Provides data from a specified source.
	 *
	 * @param source the source of the data.
	 * @return the data from the specified source.
	 */
	String provideDataFromSource( String source );
	
}
