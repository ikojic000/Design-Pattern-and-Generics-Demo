package com.ikojic.strategyPattern;


public class DIV_CLS {
	
	private Div_Strategy<Number> div_Strategy;
	
	public void setDiv_Strategy( Div_Strategy div_Strategy ) {
		
		this.div_Strategy = div_Strategy;
		
	}
	
	
	public <T> void performCalculation( Number prviBroj , Number drugiBroj ) {
		
		div_Strategy.division( prviBroj , drugiBroj );
		
	}
	
}
