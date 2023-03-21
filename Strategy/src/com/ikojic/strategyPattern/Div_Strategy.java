package com.ikojic.strategyPattern;


public interface Div_Strategy<T extends Number> {
	
	void division( T prviBroj , T drugiBroj );
	
}
