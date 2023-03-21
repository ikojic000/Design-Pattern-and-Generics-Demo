package com.ikojic.adapterPattern;


import java.util.ArrayList;
import java.util.HashSet;


/**
 * @author ikojic000
 *
 *         Class that uses HashSet as DataStructure. Class implements
 *         SeqDataStructureOperations interface.
 *
 * @param <E>
 */
public class HashSetLikeSeqDataStructureAdapter<E> implements SeqDataStructureOperations<E> {
	
	private HashSet<E> hashSet;
	
	public HashSetLikeSeqDataStructureAdapter( HashSet<E> hashSet ) {
		
		this.hashSet = hashSet;
		
	}
	
	
	/**
	 * delete all elements from data structure
	 */
	@Override
	public void deleteAllElements() {
		
		hashSet.removeAll( hashSet );
		
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
		
		return hashSet.contains( element );
		
	}
	
	
	/**
	 * Check if data structure is empty.
	 * 
	 * @return true if it is empty
	 */
	@Override
	public boolean structureIsEmpty() {
		
		return hashSet.isEmpty();
		
	}
	
	
	/**
	 * Gets element from defined index position.
	 * 
	 * @param position
	 * @return element
	 */
	@Override
	public E getElementFromPosition( int position ) {
		
		ArrayList<E> hashToList = new ArrayList<>( hashSet );
		
		return hashToList.get( position );
		
	}
	
	
	/**
	 * Provides number of elements in the structure.
	 * 
	 * @return number of elements
	 */
	@Override
	public int sizeOfStructure() {
		
		return hashSet.size();
		
	}
	
	
	/**
	 * Removes an element from defined position.
	 * 
	 * @param position - index position
	 * @return E - element from defined index position
	 */
	@Override
	public E removeFromPosition( int position ) {
		
		E object = getElementFromPosition( position );
		hashSet.remove( object );
		
		return object;
		
	}
	
}
