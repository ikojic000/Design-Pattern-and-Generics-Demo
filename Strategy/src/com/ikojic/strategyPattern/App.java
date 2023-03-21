package com.ikojic.strategyPattern;


/**
 * This class represents an App that demonstrates the use of different division
 * strategies
 */
public class App {
	
	public static void main( String[] args ) {
		
		System.out.println( "" );
		
		DIV_CLS divCls = new DIV_CLS();
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<< INT DIVISION >>>>>>>>>>>>>>>>>>>>" );
		divCls.setDiv_Strategy( new IntDivision() );
		divCls.performCalculation( 12 , 5 );
		
		System.out.println( "" );
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<< MODULO DIVISION >>>>>>>>>>>>>>>>>>>>" );
		divCls.setDiv_Strategy( new ModuloDiv() );
		divCls.performCalculation( 5.0 , 3.0 );
		
		System.out.println( "" );
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<< EXPO DIVISION >>>>>>>>>>>>>>>>>>>>" );
		divCls.setDiv_Strategy( new ExpoDiv() );
		
		Exponent exp1 = new Exponent( 3 , 5 );
		Exponent exp2 = new Exponent( 3 , 2 );
		
		divCls.performCalculation( exp1 , exp2 );
		
	}
	
}
