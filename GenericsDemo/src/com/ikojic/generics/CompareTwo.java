package com.ikojic.generics;


/**
 * 
 * The CompareTwo class is a generic class that compares two objects of a type
 * that implements the Comparable interface.
 * 
 * It contains two private instance variables of the generic type T that
 * represent the first and second objects to be compared.
 */
public class CompareTwo<T extends Comparable<T>> {
	
	private T first; // The first object to be compared.
	private T second; // The second object to be compared.
	
	/**
	 * 
	 * Constructs a CompareTwo object with the given first and second objects to be
	 * compared.
	 * 
	 * @param first  the first object to be compared.
	 * @param second the second object to be compared.
	 */
	public CompareTwo( T first , T second ) {
		
		this.first = first;
		this.second = second;
		
	}
	
	
	/**
	 * 
	 * Compares the first and second objects and performs an action based on the
	 * comparison. If the first object is greater than the second, the first object
	 * is selected to perform something. If the first object is less than the
	 * second, the second object is selected to perform something. If the first and
	 * second objects are equal, nothing is performed.
	 */
	public void compareAndPerform() {
		
		System.out.println( "First: " + first );
		System.out.println( "Second: " + second );
		
		if ( first.compareTo( second ) > 0 ) {
			
			System.out.println( "First is selected to perform something...." );
			System.out.println( first );
			
		} else if ( first.compareTo( second ) < 0 ) {
			
			System.out.println( "Second is selected to perform something...." );
			System.out.println( second );
			
		} else {
			
			System.out.println( "Both are equals!!!" );
			System.out.println( "Nothing to perform..." );
			
		}
		
		System.out.println( "------------------------------------------------------" );
		System.out.println( "" );
		
	}
	
}
