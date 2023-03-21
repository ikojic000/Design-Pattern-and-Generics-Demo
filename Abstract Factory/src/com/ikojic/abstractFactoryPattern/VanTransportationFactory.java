package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a van transportation factory. This class implements
 * the TransportationFactoryInterface and provides a concrete implementation for
 * the createTransportationType method.
 */
public class VanTransportationFactory implements TransportationFactoryInterface {
	
	/**
	 * Creates a new VanTransportation object. This method returns a new instance of
	 * the VanTransportation class.
	 * 
	 * @return The newly created VanTransportation object.
	 */
	@Override
	public TransportationType createTransportationType() {
		
		return new VanTransportation();
		
	}
	
}
