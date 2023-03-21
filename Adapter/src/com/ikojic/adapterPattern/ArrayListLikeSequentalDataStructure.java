package com.ikojic.adapterPattern;


import java.util.ArrayList;


/**
 * @author ikojic000
 *
 *         Class that uses ArrayList as DataStructure. Class implements
 *         SeqDataStructureOperations interface.
 *
 * @param <E>
 */
public class ArrayListLikeSequentalDataStructure<E> implements SeqDataStructureOperations<E> {
	
	private ArrayList<E> arrayList;
	
	public ArrayListLikeSequentalDataStructure( ArrayList<E> arrayList ) {
		
		this.arrayList = arrayList;
		
	}
	
	
	/**
	 * delete all elements from data structure
	 */
	@Override
	public void deleteAllElements() {
		
		System.out.println( "Data structure before deleting: " + arrayList );
		System.out.println( "Deleting all elements from data structure..." );
		arrayList.clear();
		System.out.println( "Data structure after deleting: " + arrayList );
		
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
		
		System.out.println( "Data structure contains element '" + element + "': " + arrayList.contains( element ) );
		return arrayList.contains( element );
		
	}
	
	
	/**
	 * Check if data structure is empty.
	 * 
	 * @return true if it is empty
	 */
	@Override
	public boolean structureIsEmpty() {
		
		System.out.println( "Data structure is empty: " + arrayList.isEmpty() );
		return arrayList.isEmpty();
		
	}
	
	
	/**
	 * Gets element from defined index position.
	 * 
	 * @param position
	 * @return element
	 */
	@Override
	public E getElementFromPosition( int position ) {
		
		System.out.println( "Element at position " + position + ": " + arrayList.get( position ) );
		return arrayList.get( position );
		
	}
	
	
	/**
	 * Provides number of elements in the structure.
	 * 
	 * @return number of elements
	 */
	@Override
	public int sizeOfStructure() {
		
		System.out.println( "Data structure size: " + arrayList.size() );
		return arrayList.size();
		
	}
	
	
	/**
	 * Removes an element from defined position.
	 * 
	 * @param position - index position
	 * @return E - element from defined index position
	 */
	@Override
	public E removeFromPosition( int position ) {
		
		System.out.println( "Element removed from position: " + position + " : " + arrayList.remove( position ) );
		return arrayList.remove( position );
		
	}
	
	
	@Override
	public String toString() {
		
		return "ArrayListLikeSequentalDataStructure - arrayList = " + arrayList + "";
		
	}
	
}
