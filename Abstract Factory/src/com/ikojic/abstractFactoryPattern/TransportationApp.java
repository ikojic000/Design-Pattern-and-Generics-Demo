package com.ikojic.abstractFactoryPattern;


import java.util.HashMap;


/**
 * A class representing a transportation application that allows creating
 * different types of transportation objects based on the available factories.
 */
public class TransportationApp {
	
	// All Creators/Factories are in HashMap and can be accessed by a String
	private HashMap<String , TransportationFactoryInterface> allFactories;
	
	/**
	 * Constructs a new instance of the TransportationApp class. Initializes a
	 * HashMap to store all available factories. Populates the HashMap with default
	 * factories.
	 */
	public TransportationApp() {
		
		allFactories = new HashMap<>();
		allFactories.put( "AirPlaneTransportation" , new AirplaneTransportationFactory() );
		allFactories.put( "BoatTransportation" , new BoatTransportationFactory() );
		allFactories.put( "TruckTransportation" , new TruckTransportationFactory() );
		allFactories.put( "VanTransportation" , new VanTransportationFactory() );
		
	}
	
	
	/**
	 * Adds a new factory to the application.
	 * 
	 * @param factoryName The name of the factory.
	 * @param factory     The factory to add.
	 */
	public void addFactory( String factoryName , TransportationFactoryInterface factory ) {
		
		allFactories.put( factoryName , factory );
		
	}
	
	
	/**
	 * Creates a new transportation object based on the given name.
	 * 
	 * @param name The name of the transportation object to create.
	 * @return The created transportation object, or null if the specified
	 *         transportation type doesn't exist.
	 */
	public TransportationType createTransportation( String name ) {
		
		TransportationFactoryInterface factory = allFactories.get( name );
		
		if ( factory != null ) {
			
			TransportationType transportType = factory.createTransportationType();
			System.out.println( "Created: " + transportType.toString() );
			return transportType;
			
		} else {
			
			System.out.println( "Transportation type " + name + " doesn't exist" );
			return null;
			
		}
		
	}
	
}
