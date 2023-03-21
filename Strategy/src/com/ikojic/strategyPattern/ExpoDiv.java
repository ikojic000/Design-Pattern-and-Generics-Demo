package com.ikojic.strategyPattern;


public class ExpoDiv implements Div_Strategy<Exponent> {
	
	@Override
	public void division( Exponent prviExpBroj , Exponent drugiExpBroj ) {
		
		Double prviBroj = prviExpBroj.doubleValue();
		Double drugiBroj = drugiExpBroj.doubleValue();
		
		Exponent solution = new Exponent( prviBroj / drugiBroj , 1 );
		
		System.out.println( "EXPO DIV - Rezultat: " + solution.getBase() );
		
	}
	
}
