package com.ikojic.strategyPattern;


/**
 * A class representing a number in exponential notation. The number is
 * represented as the product of a base and an exponent.
 */
public class Exponent extends Number {
	
	private static final long serialVersionUID = -7873979076254883725L;
	/**
	 * The base of the exponential number.
	 */
	double base;
	/**
	 * The exponent of the exponential number.
	 */
	double expo;
	
	/**
	 * Constructs a new `Exponent` object with the specified base and exponent.
	 *
	 * @param base the base of the exponential number
	 * @param expo the exponent of the exponential number
	 */
	public Exponent( double base , double expo ) {
		
		super();
		this.base = base;
		this.expo = expo;
		
	}
	
	
	/**
	 * Returns the base of the exponential number.
	 *
	 * @return the base of the exponential number
	 */
	public double getBase() {
		
		return base;
		
	}
	
	
	/**
	 * Returns the exponent of the exponential number.
	 *
	 * @return the exponent of the exponential number
	 */
	public double getExpo() {
		
		return expo;
		
	}
	
	
	/**
	 * Returns the integer value of the exponential number. The value is obtained by
	 * raising the base to the exponent and rounding to the nearest integer.
	 *
	 * @return the integer value of the exponential number
	 */
	@Override
	public int intValue() {
		
		Double number = Math.pow( this.getBase() , this.getExpo() );
		return number.intValue();
		
	}
	
	
	/**
	 * Returns the long value of the exponential number. The value is obtained by
	 * raising the base to the exponent and rounding to the nearest long.
	 *
	 * @return the long value of the exponential number
	 */
	@Override
	public long longValue() {
		
		Double number = Math.pow( this.getBase() , this.getExpo() );
		return number.longValue();
		
	}
	
	
	/**
	 * Returns the float value of the exponential number. The value is obtained by
	 * raising the base to the exponent and returning a float value.
	 *
	 * @return the float value of the exponential number
	 */
	@Override
	public float floatValue() {
		
		Double number = Math.pow( this.getBase() , this.getExpo() );
		return number.floatValue();
		
	}
	
	
	/**
	 * Returns the double value of the exponential number. The value is obtained by
	 * raising the base to the exponent and returning a double value.
	 *
	 * @return the double value of the exponential number
	 */
	@Override
	public double doubleValue() {
		
		Double number = Math.pow( this.getBase() , this.getExpo() );
		return number;
		
	}
	
}
