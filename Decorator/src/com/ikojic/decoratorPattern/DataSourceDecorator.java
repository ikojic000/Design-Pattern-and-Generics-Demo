package com.ikojic.decoratorPattern;


/**
 * 
 * An abstract decorator for the {@link DataSource} interface. This class serves
 * as a base class for other decorators that may be created to add functionality
 * to a data source object. It provides a reference to the original data source
 * object and ensures that it adheres to the contract of the DataSource
 * interface.
 */
public abstract class DataSourceDecorator implements DataSource {
	
	/**
	 * The original data source object to which the decorator will add
	 * functionality.
	 */
	protected DataSource dataSource;
	
	/**
	 * Constructs a new {@code DataSourceDecorator} object with the given
	 * DataSource.
	 * 
	 * @param dataSource the original data source object to which the decorator will
	 *                   add functionality
	 */
	protected DataSourceDecorator( DataSource dataSource ) {
		
		this.dataSource = dataSource;
		
	}
	
}
