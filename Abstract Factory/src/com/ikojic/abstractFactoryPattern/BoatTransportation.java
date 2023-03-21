package com.ikojic.abstractFactoryPattern;


public class BoatTransportation implements TransportationType {
	
	@Override
	public void performTranportation() {
		
		System.out.println( getClass().getSimpleName() + " performs tranportation..." );
		
	}
	
	
	@Override
	public String toString() {
		
		return "BoatTransportation";
		
	}
	
}
