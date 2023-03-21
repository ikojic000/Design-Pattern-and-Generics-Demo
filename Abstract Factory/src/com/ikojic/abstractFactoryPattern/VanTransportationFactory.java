package com.ikojic.abstractFactoryPattern;


public class VanTransportationFactory implements TransportationFactoryInterface {
	
	@Override
	public TransportationType createTransportationType() {
		
		return new VanTransportation();
		
	}
	
}
