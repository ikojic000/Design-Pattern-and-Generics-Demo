package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a truck transportation type. This class implements
 * the TransportationType interface and provides a concrete implementation for
 * the performTransportation method.
 */
public class TruckTransportation implements TransportationType {
	
	/**
	 * Performs the truck transportation operation. This method prints a message
	 * indicating that truck transportation is being performed.
	 */
	@Override
	public void performTranportation() {
		
		System.out.println( getClass().getSimpleName() + " performs transportation..." );
		
	}
	
	
	/**
	 * Returns the string representation of this class. This method returns the name
	 * of the class as a string.
	 * 
	 * @return The string representation of this class.
	 */
	@Override
	public String toString() {
		
		return "TruckTransportation";
		
	}
	
}
