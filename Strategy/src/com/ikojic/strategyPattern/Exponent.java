package com.ikojic.strategyPattern;


@SuppressWarnings( "serial" )
public class Exponent extends Number {
	
	double base;
	double expo;
	
	public Exponent( double base , double expo ) {
		
		super();
		this.base = base;
		this.expo = expo;
		
	}
	
	
	public double getBase() {
		
		return base;
		
	}
	
	
	public double getExpo() {
		
		return expo;
		
	}
	
	
	@Override
	public int intValue() {
		
		Double broj = Math.pow( this.getBase() , this.getExpo() );
		return broj.intValue();
		
	}
	
	
	@Override
	public long longValue() {
		
		Double broj = Math.pow( this.getBase() , this.getExpo() );
		return broj.longValue();
		
	}
	
	
	@Override
	public float floatValue() {
		
		Double broj = Math.pow( this.getBase() , this.getExpo() );
		return broj.floatValue();
		
	}
	
	
	@Override
	public double doubleValue() {
		
		Double broj = Math.pow( this.getBase() , this.getExpo() );
		return broj;
		
	}
	
}
