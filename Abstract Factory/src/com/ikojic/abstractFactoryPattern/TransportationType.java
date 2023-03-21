package com.ikojic.abstractFactoryPattern;


/**
 * An interface that defines the behavior of a transportation type. Implementing
 * classes must provide an implementation for the performTransportation method.
 */
public interface TransportationType {
	
	/**
	 * Performs the transportation operation for this transportation type.
	 */
	void performTranportation();
	
}
