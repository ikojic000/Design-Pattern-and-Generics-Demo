package com.ikojic.abstractFactoryPattern;


import java.util.HashMap;


public class TransportationApp {
	
//	All Creators/Factories are in HashMap and can be accest by a String
	private HashMap<String , TransportationFactoryInterface> allFactories;
	
	public TransportationApp() {
		
		allFactories = new HashMap<>();
		allFactories.put( "AeroplaneTransportation" , new AeroplaneTransportationFactory() );
		allFactories.put( "BoatTransportation" , new BoatTransportationFactory() );
		allFactories.put( "TruckTransportation" , new TruckTransportationFactory() );
		allFactories.put( "VanTransportation" , new VanTransportationFactory() );
		
	}
	
	
	public void addFactory( String factoryName , TransportationFactoryInterface factory ) {
		
		allFactories.put( factoryName , factory );
		
	}
	
	
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
