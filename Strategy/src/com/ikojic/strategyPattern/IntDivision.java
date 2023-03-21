package com.ikojic.strategyPattern;


/**
 * A class that implements the Div_Strategy interface for Integer numbers.
 */
public class IntDivision implements Div_Strategy<Integer> {
	
	/**
	 * Performs the division operation on two Integer numbers and prints the result
	 * to the console.
	 * 
	 * @param prviBroj  the first Integer number
	 * @param drugiBroj the second Integer number
	 */
	@Override
	public void division( Integer prviBroj , Integer drugiBroj ) {
		
		int solution = prviBroj / drugiBroj;
		
		System.out.println( "INT DIV - Rezultat: " + solution );
		
	}
	
}
