package com.ikojic.strategyPattern;


/**
 * A class that implements the Div_Strategy interface for Double numbers.
 */
public class ModuloDiv implements Div_Strategy<Double> {
	
	/**
	 * Performs the division operation on two Double numbers and prints the result
	 * to the console.
	 * 
	 * @param prviBroj  the first Double number
	 * @param drugiBroj the second Double number
	 */
	@Override
	public void division( Double prviBroj , Double drugiBroj ) {
		
		Double solution = prviBroj % drugiBroj;
		
		System.out.println( "MODULO DIV - Rezultat: " + solution.intValue() );
		
	}
	
}
