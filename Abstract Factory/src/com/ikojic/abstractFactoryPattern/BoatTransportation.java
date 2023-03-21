package com.ikojic.abstractFactoryPattern;


/**
 * A class that represents a boat transportation type. This class implements the
 * TransportationType interface and provides a concrete implementation for the
 * performTransportation method.
 */
public class BoatTransportation implements TransportationType {
	
	/**
	 * Performs the boat transportation operation. This method prints a message
	 * indicating that boat transportation is being performed.
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
		
		return "BoatTransportation";
		
	}
	
}
