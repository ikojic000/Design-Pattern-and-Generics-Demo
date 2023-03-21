package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a truck transportation factory. This class implements
 * the TransportationFactoryInterface and provides a concrete implementation for
 * the createTransportationType method.
 */
public class TruckTransportationFactory implements TransportationFactoryInterface {
	
	/**
	 * Creates a new TruckTransportation object. This method returns a new instance
	 * of the TruckTransportation class.
	 * 
	 * @return The newly created TruckTransportation object.
	 */
	@Override
	public TransportationType createTransportationType() {
		
		return new TruckTransportation();
		
	}
	
}
