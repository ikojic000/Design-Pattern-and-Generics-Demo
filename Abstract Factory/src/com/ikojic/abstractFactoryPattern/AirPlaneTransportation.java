package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a airplane transportation type. This class implements
 * the TransportationType interface and provides a concrete implementation for
 * the performTransportation method.
 */
public class AirPlaneTransportation implements TransportationType {
	
	/**
	 * Performs the airplane transportation operation. This method prints a message
	 * indicating that airplane transportation is being performed.
	 */
	@Override
	public void performTranportation() {
		
		System.out.println( getClass().getSimpleName() + " performs tranportation..." );
		
	}
	
	
	/**
	 * Returns the string representation of this class. This method returns the name
	 * of the class as a string.
	 * 
	 * @return The string representation of this class.
	 */
	@Override
	public String toString() {
		
		return "AeroPlaneTransportation";
		
	}
	
}
