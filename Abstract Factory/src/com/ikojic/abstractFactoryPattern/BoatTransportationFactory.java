package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a boat transportation factory. This class implements
 * the TransportationFactoryInterface and provides a concrete implementation for
 * the createTransportationType method.
 */
public class BoatTransportationFactory implements TransportationFactoryInterface {
	
	/**
	 * Creates a new BoatTransportation object. This method returns a new instance
	 * of the BoatTransportation class.
	 * 
	 * @return The newly created BoatTransportation object.
	 */
	@Override
	public TransportationType createTransportationType() {
		
		return new BoatTransportation();
		
	}
	
}
