package com.ikojic.adapterPattern;


import java.util.ArrayList;


/**
 * @author ikojic000
 *
 */
public class App {
	
	public static <E> void main( String[] args ) {
		
//		Creating ArrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for ( int i = 1; i < 10; i++ ) {
			
			arrayList.add( i );
			
		}
		
//		creating Array from ArrayList
		Integer[] list = arrayList.toArray( new Integer[arrayList.size()] );
		
//		Creating ArrayListLikeSequentialDataStructure
		SeqDataStructureOperations<Integer> arrayListDataStructure = new ArrayListLikeSequentalDataStructure<Integer>(
				arrayList );
		
//		Calling methods for testing. First one tests all methods declared in
//		SeqDataStructureOperations interface. Second one tests all methods from
//		OperationCLS class.
		
		testDataStructure( arrayListDataStructure , 5 , 2 , 2 );
//		testOperationCLS( arrayListDataStructure, 5);
		
//		Creating ArrayLikeSeqDataStructure using Adapter
		SeqDataStructureOperations<Integer> arrayDataStructure = new ArrayLikeSeqDataStructureAdapter<>( list );
		
//		Calling methods for testing. First one tests all methods declared in
//		SeqDataStructureOperations interface. Second one tests all methods from
//		OperationCLS class.
		
		testDataStructure( arrayDataStructure , 5 , 2 , 2 );
//		testOperationCLS( arrayDataStructure, 5 );
		
	}
	
	
	/**
	 * 
	 * Method for testing all SeqDataStructureOperations methods.
	 * 
	 * @param <E>
	 * @param dataStructure
	 * @param element
	 */
	private static <E> void testDataStructure( SeqDataStructureOperations<E> dataStructure , E element ,
											   Integer positionToCheck , Integer positionToRemove ) {
		
		System.out.println( dataStructure.toString() );
		
		dataStructure.structureIsEmpty();
		dataStructure.sizeOfStructure();
		dataStructure.containElement( element );
		dataStructure.getElementFromPosition( positionToCheck );
		dataStructure.removeFromPosition( positionToRemove );
		dataStructure.deleteAllElements();
		
		System.out.println( "\n" );
		
	}
	
	
	/**
	 * 
	 * Method for testing all OperationCLS methods.
	 * 
	 * @param <E>
	 * @param dataStructure
	 * @param element
	 */
	@SuppressWarnings( { "static-access" , "unused" } )
	private static <E> void testOperationCLS( SeqDataStructureOperations<E> dataStructure , E element ,
											  Integer positionToCheck , Integer positionToRemove ) {
		
		System.out.println( "\n******************** OperationCLS ********************\n" );
		
		System.out.println( dataStructure.toString() );
		
		OperationCLS operationCLS = new OperationCLS();
		
		operationCLS.getSize( dataStructure );
		operationCLS.elementInStructure( dataStructure , element );
		operationCLS.getElementFromPosition( dataStructure , positionToCheck );
		operationCLS.removeElement( dataStructure , positionToRemove );
		operationCLS.performClearAllOperation( dataStructure );
		
		System.out.println( "\n" );
		
	}
	
}
