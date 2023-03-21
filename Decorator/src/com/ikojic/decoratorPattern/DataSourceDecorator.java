package com.ikojic.decoratorPattern;


public abstract class DataSourceDecorator implements DataSource {
	
	protected DataSource dataSource;
	
	protected DataSourceDecorator( DataSource dataSource ) {
		
		this.dataSource = dataSource;
		
	}
	
}
