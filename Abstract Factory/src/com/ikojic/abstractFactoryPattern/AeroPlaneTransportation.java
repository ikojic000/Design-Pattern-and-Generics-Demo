package com.ikojic.abstractFactoryPattern;


public class AeroPlaneTransportation implements TransportationType {
	
	@Override
	public void performTranportation() {
		
		System.out.println( getClass().getSimpleName() + " performs tranportation..." );
		
	}
	
	
	@Override
	public String toString() {
		
		return "AeroPlaneTransportation";
		
	}
	
}
