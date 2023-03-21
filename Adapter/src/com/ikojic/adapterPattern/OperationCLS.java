package com.ikojic.adapterPattern;


public class OperationCLS {
	
	public static <E> void performClearAllOperation( SeqDataStructureOperations<E> dataStructure ) {
		
		dataStructure.deleteAllElements();
		
	}
	
	
	public static <E> boolean elementInStructure( SeqDataStructureOperations<E> dataStructure , E element ) {
		
		return dataStructure.containElement( element );
		
	}
	
	
	public static <E> Object getElementFromPosition( SeqDataStructureOperations<E> dataStructure , int position ) {
		
		return dataStructure.getElementFromPosition( position );
		
	}
	
	
	public static <E> int getSize( SeqDataStructureOperations<E> dataStructure ) {
		
		return dataStructure.sizeOfStructure();
		
	}
	
	
	public static <E> Object removeElement( SeqDataStructureOperations<E> dataStructure , int position ) {
		
		return dataStructure.removeFromPosition( position );
		
	}
	
}
