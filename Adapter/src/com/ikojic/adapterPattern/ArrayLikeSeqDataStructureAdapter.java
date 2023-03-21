package com.ikojic.adapterPattern;


import java.util.Arrays;


/**
 * @author ikojic000
 *
 *         Adater Class. Class that uses Array as DataStructure. Class
 *         implements SeqDataStructureOperations interface.
 * 		
 * @param <E>
 */
public class ArrayLikeSeqDataStructureAdapter<E> implements SeqDataStructureOperations<E> {
	
	private E[] array;
	
	public ArrayLikeSeqDataStructureAdapter( E[] array ) {
		
		this.array = array;
		
	}
	
	
	/**
	 * delete all elements from data structure
	 */
	@Override
	public void deleteAllElements() {
		
		System.out.println( "Data structure before deleting: " + Arrays.toString( array ) );
		System.out.println( "Deleting all elements from data structure..." );
		Arrays.fill( array , null );
		System.out.println( "Data structure after deleting: " + Arrays.toString( array ) );
		
	}
	
	
	/**
	 * Test if an element is in data structure. Returns true if is in, and contrary
	 * false
	 * 
	 * @param element - some good define element
	 * @return true or false
	 */
	@Override
	public boolean containElement( E element ) {
		
		for ( E elementInArray : array ) {
			
			if ( elementInArray.equals( element ) ) {
				
				System.out.println( "Data structure contains element :'" + element.toString() + "'" );
				return true;
				
			}
			
		}
		
		System.out.println( "Data structure doesn't contain element :'" + element.toString() + "'" );
		return false;
		
	}
	
	
	/**
	 * Check if data structure is empty.
	 * 
	 * @return true if it is empty
	 */
	@Override
	public boolean structureIsEmpty() {
		
		if ( array.length > 0 ) {
			
			System.out.println( "Data structure is not empty..." );
			return false;
			
		} else {
			
			System.out.println( "Data structure is empty..." );
			return true;
			
		}
		
	}
	
	
	/**
	 * Gets element from defined index position.
	 * 
	 * @param position
	 * @return element
	 */
	@Override
	public E getElementFromPosition( int position ) {
		
		if ( position < 0 && position > array.length ) {
			
			System.out.println( "Entered number is not valid ..." );
			
		}
		
		System.out.println( "Element at position " + position + ":" + array[position] );
		return array[position];
		
	}
	
	
	/**
	 * Provides number of elements in the structure.
	 * 
	 * @return number of elements
	 */
	@Override
	public int sizeOfStructure() {
		
		System.out.println( "Data structure size: " + array.length );
		return array.length;
		
	}
	
	
	/**
	 * Removes an element from defined position.
	 * 
	 * @param position - index position
	 * @return E - element from defined index position
	 */
	@Override
	public E removeFromPosition( int position ) {
		
		System.out.println( "Element removed from position: " + position + " : " + array[position] );
		
		E elementAtPosition = array[position];
		array[position] = null;
		
		return elementAtPosition;
		
	}
	
	
	@Override
	public String toString() {
		
		return "ArrayLikeSeqDataStructureAdapter - array = " + Arrays.toString( array ) + "";
		
	}
	
}
