package com.ikojic.abstractFactoryPattern;


/**
 * A class representing the main entry point of the application.
 */
public class App {
	
	/**
	 * The main method of the application. Creates an instance of TransportationApp
	 * and uses it to create a new transportation object of type
	 * AeroplaneTransportation. Calls the performTranportation method on the created
	 * transportation object if it's not null.
	 * 
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main( String[] args ) {
		
		TransportationApp app = new TransportationApp();
		TransportationType transport = app.createTransportation( "AirPlaneTransportation" );
		
		if ( transport != null ) {
			
			transport.performTranportation();
			
		}
		
	}
	
}
