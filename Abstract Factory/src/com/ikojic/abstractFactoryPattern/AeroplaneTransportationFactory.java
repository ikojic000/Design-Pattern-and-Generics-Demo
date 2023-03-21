package com.ikojic.abstractFactoryPattern;


public class AeroplaneTransportationFactory implements TransportationFactoryInterface {
	
	@Override
	public TransportationType createTransportationType() {
		
		return new AeroPlaneTransportation();
		
	}
	
}
