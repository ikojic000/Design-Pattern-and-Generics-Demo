package com.ikojic.abstractFactoryPattern;


public class App {
	
	public static void main( String[] args ) {
		
		TransportationApp app = new TransportationApp();
		TransportationType transport = app.createTransportation( "AeroplaneTransportation" );
		
		if ( transport != null ) {
			
			transport.performTranportation();
			
		}
		
	}
	
}
