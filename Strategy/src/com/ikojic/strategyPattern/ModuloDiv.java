package com.ikojic.strategyPattern;


public class ModuloDiv implements Div_Strategy<Double> {
	
	@Override
	public void division( Double prviBroj , Double drugiBroj ) {
		
		Double solution = prviBroj % drugiBroj;
		
		System.out.println( "MODULO DIV - Rezultat: " + solution.intValue() );
		
	}
	
}
