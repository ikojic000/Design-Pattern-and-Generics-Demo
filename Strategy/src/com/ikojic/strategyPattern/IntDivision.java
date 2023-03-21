package com.ikojic.strategyPattern;


public class IntDivision implements Div_Strategy<Integer> {
	
	@Override
	public void division( Integer prviBroj , Integer drugiBroj ) {
		
		int solution = prviBroj / drugiBroj;
		
		System.out.println( "INT DIV - Rezultat: " + solution );
		
	}
	
}
