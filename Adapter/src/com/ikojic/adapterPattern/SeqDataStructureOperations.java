package com.ikojic.adapterPattern;


interface SeqDataStructureOperations<E> {
	
	/**
	 * delete all elements from data structure
	 */
	void deleteAllElements();
	
	/**
	 * Test if an element is in data structure. Returns true if is in, and contrary
	 * false
	 * 
	 * @param element - some good define element
	 * @return true or false
	 */
	boolean containElement( E element );
	
	/**
	 * Check if data structure is empty.
	 * 
	 * @return true if it is empty
	 */
	boolean structureIsEmpty();
	
	/**
	 * Gets element from defined index position.
	 * 
	 * @param position
	 * @return element
	 */
	E getElementFromPosition( int position );
	
	/**
	 * Provides number of elements in the structure.
	 * 
	 * @return number of elements
	 */
	int sizeOfStructure();
	
	/**
	 * Removes an element from defined position.
	 * 
	 * @param position - index position
	 * @return E - element from defined index position
	 */
	E removeFromPosition( int position );
	
}
