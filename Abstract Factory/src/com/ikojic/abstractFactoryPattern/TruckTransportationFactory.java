package com.ikojic.abstractFactoryPattern;


public class TruckTransportationFactory implements TransportationFactoryInterface {
	
	@Override
	public TransportationType createTransportationType() {
		
		return new TruckTransportation();
		
	}
	
}
