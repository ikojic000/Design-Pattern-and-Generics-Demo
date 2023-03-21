package com.ikojic.generics;


import java.util.ArrayList;
import java.util.Collections;


public class TestGens_1 {
	
	public static ArrayList<User> userList = new ArrayList<>();
	public static ArrayList<User> shuffleUserList = new ArrayList<>();
	
	public static void main( String[] args ) {
		
		popListOfUsers( 7 );
		shuffleUserList = shuffleList( userList );
		
		printLists( userList , shuffleUserList );
		
		compareAllPairsAndPrint( shuffleUserList );
		
	}
	
	
//	Printanje userList i shuffleUserList
	private static void printLists( ArrayList<User> userList , ArrayList<User> shuffleUserList ) {
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<<<<< User List >>>>>>>>>>>>>>>>>>>>>>>" );
		
		for ( User user : userList ) {
			
			System.out.println( user );
			
		}
		
		System.out.println( " " );
		System.out.println( " " );
		System.out.println( " " );
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<<< User Shuffle List >>>>>>>>>>>>>>>>>>>>>>>" );
		
		for ( User user : shuffleUserList ) {
			
			System.out.println( user );
			
		}
		
		System.out.println( " " );
		System.out.println( " " );
		System.out.println( " " );
		
	}
	
	
//	Funkcija za popunjavanje n clanova klase User
	private static void popListOfUsers( int n ) {
		
		for ( int i = 0; i < n; i++ ) {
			
			userList.add( new User() );
			
		}
		
	}
	
	
//	Funkcija koja izmjesa danu listu
	private static <E> ArrayList<E> shuffleList( ArrayList<E> list ) {
		
		ArrayList<E> novaLista = new ArrayList<>();
		
		for ( E obj : list ) {
			
			novaLista.add( obj );
			
		}
		
		Collections.shuffle( novaLista );
		
		return novaLista;
		
	}
	
	
//	Rekurzivna funkcija koja vrati listu svih mogucih kombinacija parova indexa zadane liste
	private static ArrayList<ArrayList<Integer>> getCombinations( int listSize ) {
		
		ArrayList<ArrayList<Integer>> combList = new ArrayList<ArrayList<Integer>>();
		
		if ( listSize <= 1 ) {
			
			return combList;
			
		} else {
			
			for ( int i = 1; i < listSize; i++ ) {
				
				ArrayList<Integer> singleComb = new ArrayList<Integer>();
				singleComb.add( i - 1 );
				singleComb.add( listSize - 1 );
				
				if ( !combList.contains( singleComb ) ) {
					
					combList.add( singleComb );
					
				}
				
			}
			
			combList.addAll( getCombinations( listSize - 1 ) );
			
			return combList;
			
		}
		
	}
	
	
//	Funkcija za printanje kombinacija
	private static void printCombList( ArrayList<ArrayList<Integer>> combList ) {
		
		System.out.println( "---------------------------- Lista Kombinacija ----------------------------" );
		System.out.println( "" );
		System.out.println( combList );
		System.out.println( "" );
		System.out.println( "---------------------------------------------------------------------------" );
		System.out.println( "" );
		System.out.println( "" );
		System.out.println( "" );
		
	}
	
	
//	Funkcija koja koristi CompareTwo i usporeduje objekte klase User iz dane liste
	private static void compareAllPairsAndPrint( ArrayList<User> shuffleUserList ) {
		
		ArrayList<ArrayList<Integer>> combinations = getCombinations( shuffleUserList.size() );
		
		printCombList( combinations );
		
		for ( ArrayList<Integer> comb : combinations ) {
			
			User user = shuffleUserList.get( comb.get( 0 ) );
			User user2 = shuffleUserList.get( comb.get( 1 ) );
			
			CompareTwo<User> compare_two = new CompareTwo<User>( user , user2 );
			compare_two.compareAndPerform();
			
		}
		
	}
	
}
