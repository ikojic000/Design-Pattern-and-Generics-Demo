package com.ikojic.strategyPattern;


/**
 * A class that implements the Div_Strategy interface for Exponent numbers.
 */
public class ExpoDiv implements Div_Strategy<Exponent> {
	
	/**
	 * Performs the division operation on two Exponent numbers and prints the result
	 * to the console.
	 * 
	 * @param prviExpBroj  the first Exponent number
	 * @param drugiExpBroj the second Exponent number
	 */
	@Override
	public void division( Exponent prviExpBroj , Exponent drugiExpBroj ) {
		
		Double prviBroj = prviExpBroj.doubleValue();
		Double drugiBroj = drugiExpBroj.doubleValue();
		
		Exponent solution = new Exponent( prviBroj / drugiBroj , 1 );
		
		System.out.println( "EXPO DIV - Rezultat: " + solution.getBase() );
		
	}
	
}
