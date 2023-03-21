package com.ikojic.generics;


import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * This class is used to test the functionality of various generic methods and
 * data structures. It contains a list of User objects, which can be shuffled
 * using the "shuffleList" method. The class also includes methods to generate
 * combinations of indices for the shuffled list, and to compare all pairs of
 * Users in the shuffled list using the "CompareTwo" class. The class includes
 * several private helper methods, which are used to generate and manipulate the
 * data.
 */
public class TestGens_1 {
	
	/**
	 * An ArrayList containing a list of User objects.
	 */
	public static ArrayList<User> userList = new ArrayList<>();
	/**
	 * An ArrayList containing a shuffled version of the "userList".
	 */
	public static ArrayList<User> shuffleUserList = new ArrayList<>();
	
	/**
	 * This method is the entry point of the class and is used to initialize the
	 * userList, shuffle the userList, and then compare all pairs of Users in the
	 * shuffled list.
	 * 
	 * @param args A string array containing the command-line arguments.
	 */
	public static void main( String[] args ) {
		
		popListOfUsers( 7 );
		shuffleUserList = shuffleList( userList );
		
		printLists( userList , shuffleUserList );
		
		compareAllPairsAndPrint( shuffleUserList );
		
	}
	
	
	/**
	 * This method is a private helper method that is used to print the contents of
	 * the "userList" and "shuffleUserList" to the console.
	 * 
	 * @param userList        An ArrayList containing the "userList" objects.
	 * @param shuffleUserList An ArrayList containing the "shuffleUserList" objects.
	 */
	private static void printLists( ArrayList<User> userList , ArrayList<User> shuffleUserList ) {
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<<<<< User List >>>>>>>>>>>>>>>>>>>>>>>" );
		
		for ( User user : userList ) {
			
			System.out.println( user );
			
		}
		
		System.out.println( "\n\n\n " );
		
		System.out.println( "<<<<<<<<<<<<<<<<<<<<< User Shuffle List >>>>>>>>>>>>>>>>>>>>>>>" );
		
		for ( User user : shuffleUserList ) {
			
			System.out.println( user );
			
		}
		
		System.out.println( "\n\n\n " );
		
	}
	
	
	/**
	 * A private helper method used to populate the userList with a specified number
	 * of User objects.
	 * 
	 * @param n The number of User objects to be added to the userList.
	 */
	private static void popListOfUsers( int n ) {
		
		for ( int i = 0; i < n; i++ ) {
			
			userList.add( new User() );
			
		}
		
	}
	
	
	/**
	 * This method takes an ArrayList of any type as input and returns a new
	 * ArrayList containing the same elements but in a random order.
	 * 
	 * @param list the ArrayList to be shuffled
	 * @return a new ArrayList containing the same elements as the input ArrayList
	 *         but in a random order
	 */
	private static <E> ArrayList<E> shuffleList( ArrayList<E> list ) {
		
		ArrayList<E> shuffledList = new ArrayList<>();
		
		for ( E obj : list ) {
			
			shuffledList.add( obj );
			
		}
		
		Collections.shuffle( shuffledList );
		
		return shuffledList;
		
	}
	
	
	/**
	 * This method takes an integer representing the size of a list and returns an
	 * ArrayList of all possible pairs of indices in that list.
	 * 
	 * @param listSize the size of the list
	 * @return an ArrayList of ArrayLists representing all possible pairs of indices
	 *         in the list
	 */
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
	
	
	/**
	 * This method takes an ArrayList of ArrayLists of integers as input and prints
	 * it to the console.
	 * 
	 * @param combList the ArrayList of ArrayLists of integers to be printed
	 */
	private static void printCombList( ArrayList<ArrayList<Integer>> combList ) {
		
		System.out.println( "---------------------------- Combinations List ----------------------------\n" );
		System.out.println( combList );
		System.out.println( "\n---------------------------------------------------------------------------" );
		System.out.println( "\n\n\n" );
		
	}
	
	
	/**
	 * This method takes an ArrayList of User objects as input, generates all
	 * possible pairs of User objects, and then performs a comparison operation on
	 * each pair.
	 * 
	 * @param shuffleUserList the ArrayList of User objects on which to perform the
	 *                        comparisons
	 */
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
