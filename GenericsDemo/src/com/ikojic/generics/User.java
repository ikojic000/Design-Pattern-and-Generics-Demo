package com.ikojic.generics;


import java.util.UUID;


/**
 * 
 * The User class represents a user in the system. Each user has a unique
 * identifier and a name.
 * 
 * Users can be compared based on their ID values.
 */
public class User implements Comparable<User> {
	
// Class variable to keep track of the next available ID number.
	private static int cntrID = 300;
	
// Instance variables for user ID and name.
	private int id;
	private String name;
	
	/**
	 * 
	 * Constructs a new User object with a unique ID and a randomly generated name.
	 */
	public User() {
		
		// Generate a unique name using a portion of a UUID and the current ID counter.
		this.name = UUID.randomUUID().toString().substring( 28 ) + "_" + cntrID;
		
		// Assign the current ID counter value to this user's ID and increment the
		// counter.
		this.id = cntrID;
		cntrID++;
		
	}
	
	
	/**
	 * 
	 * Returns the ID of this user.
	 * 
	 * @return the ID of this user
	 */
	public int getID() {
		
		return id;
		
	}
	
	
	/**
	 * 
	 * Returns a string representation of this user, including their ID and name.
	 * 
	 * @return a string representation of this user
	 */
	@Override
	public String toString() {
		
		return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
		
	}
	
	
	/**
	 * 
	 * Compares this user to another user based on their ID values.
	 * 
	 * @param user the user to compare to
	 * @return a negative integer, zero, or a positive integer as this user is less
	 *         than, equal to, or greater than the specified user
	 * 		
	 */
	@Override
	public int compareTo( User user ) {
		
		return Integer.compare( this.getID() , user.getID() );
		
	}
	
}
