package com.ikojic.strategyPattern;


/**
 * This class represents a DIV_CLS, which has a div_Strategy object to perform
 * division operations
 */
public class DIV_CLS {
	
	private Div_Strategy<Number> div_Strategy;
	
	/**
	 * Sets the division strategy to be used
	 * 
	 * @param div_Strategy a Div_Strategy object
	 */
	public void setDiv_Strategy( Div_Strategy div_Strategy ) {
		
		this.div_Strategy = div_Strategy;
		
	}
	
	
	/**
	 * Performs a division calculation using the currently set division strategy
	 * 
	 * @param prviBroj  the first number to be divided
	 * @param drugiBroj the second number to be divided
	 */
	public <T> void performCalculation( Number prviBroj , Number drugiBroj ) {
		
		div_Strategy.division( prviBroj , drugiBroj );
		
	}
	
}
