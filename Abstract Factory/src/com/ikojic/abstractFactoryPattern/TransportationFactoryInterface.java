package com.ikojic.abstractFactoryPattern;


/**
 * An interface that defines the behavior of a transportation factory.
 * Implementing classes must provide an implementation for the
 * createTransportationType method.
 */
public interface TransportationFactoryInterface {
	
	/**
	 * Creates a new TransportationType object. Implementing classes must define the
	 * logic for creating the TransportationType object.
	 * 
	 * @return The newly created TransportationType object.
	 */
	TransportationType createTransportationType();
	
}
