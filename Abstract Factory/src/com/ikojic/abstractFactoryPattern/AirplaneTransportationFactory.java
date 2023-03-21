package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents an airplane transportation factory. This class
 * implements the TransportationFactoryInterface and provides a concrete
 * implementation for the createTransportationType method.
 */
public class AirplaneTransportationFactory implements TransportationFactoryInterface {
	
	/**
	 * Creates a new AirPlaneTransportation object. This method returns a new
	 * instance of the AirPlaneTransportation class.
	 * 
	 * @return The newly created AirPlaneTransportation object.
	 */
	@Override
	public TransportationType createTransportationType() {
		
		return new AirPlaneTransportation();
		
	}
	
}
