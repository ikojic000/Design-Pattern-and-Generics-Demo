package com.ikojic.abstractFactoryPattern;


public class BoatTransportationFactory implements TransportationFactoryInterface {
	
	@Override
	public TransportationType createTransportationType() {
		
		return new BoatTransportation();
		
	}
	
}
