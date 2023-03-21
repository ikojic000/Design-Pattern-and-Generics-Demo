package com.ikojic.strategyPattern;


/**
 * A strategy interface for performing division operation on numbers of type T.
 * 
 * @param <T> the type of number on which the division operation is to be
 *            performed.
 */
public interface Div_Strategy<T extends Number> {
	
	/**
	 * Performs the division operation on two numbers of type T.
	 * 
	 * @param prviBroj  the first number of type T
	 * @param drugiBroj the second number of type T
	 */
	void division( T prviBroj , T drugiBroj );
	
}
