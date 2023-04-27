package org.howard.edu.hw5;

import java.util.*; //for ArrayList<>()

/**
 * creating a data structure
 * with functions and an error
 * 
 * @author Justin
 *
 */
public class IntegerSet {

	List<Integer> integer_set;
	
	/**
	 * class constructor
	 * initializes integer_set
	 */
	public IntegerSet() {
		integer_set = new ArrayList<Integer>();
	}
	
	/**
	 * creating an error that prints out the string that is passed to it
	 * 
	 * @author Justin
	 *
	 */
	@SuppressWarnings("serial")
	public class IntegerSetException extends Exception {
		/**
		 */
		public IntegerSetException(String error) {
			super(error);
		}
	}
	
	
	/**
	 * @return ArrayList containing all integers in the set
	 */
	public List<Integer> get_set() {
		return integer_set;
	}
	
	
	/**
	newest_set List instance to declare to
	 */
	public void set_set(List<Integer> newest_set) {
		integer_set = newest_set;
	}
	
	
	public void clear() {
		integer_set.clear();
	}
	
	
	/**
	 * returns the size of the array list
	 */
	public int length() {
		return integer_set.size();
	}
	
	
	/**
	 * checks if IntegerSet a is the exact same 
	 */
	public boolean equals(IntegerSet a) {
		if (integer_set.size() != a.length()) {
			return false;
		}
		else {
			return integer_set.containsAll(a.integer_set);
		}
	}
	
	
	/**
	 * check if the IntegerSet contains a value
	 */
	public boolean contains(int value) {
		return integer_set.contains(value);
	}
	
	
	/**
	 * returns the largest number in the set
	 */
	public int largest() throws IntegerSetException {
		if (integer_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		else {
			int largest = integer_set.get(0);
			for (int i = 0; i < integer_set.size(); i++) {
				if (integer_set.get(i) > largest) {
					largest = integer_set.get(i);
				}
			}
			return largest;
		}
	}
	
	
	/**
	 * returns the smallest integer in the set
	 */
	public int smallest() throws IntegerSetException {
		if (integer_set.isEmpty()) {
			throw new IntegerSetException("The Set is Empty.");
		}
		else { 
			int smallest = integer_set.get(0);
			for (int i = 0; i < integer_set.size(); i++) {
				if (integer_set.get(i) < smallest) {
					smallest = integer_set.get(i);
				}
			}
			return smallest;
		}
	}
	
	/**
	 * adds an integer to the set if it is not present
	 */
	public void add(int object) {
		if (integer_set.contains(object) == false) {
			integer_set.add(object);
		}
	}
	
	
	/**
	 * removes an integer from the set if it is present
	 */
	public void remove(int object) {
		if (integer_set.contains(object) == true) {
			integer_set.remove(integer_set.indexOf(object));
		}
	}
	
	
	/**
	 * calculates the union of two sets
	 * 
	 */
	public void union(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (integer_set.contains(b.integer_set.get(i)) == false) {
				integer_set.add(b.integer_set.get(i));
			}
		}
	} 
	
	
	/**
	 * calculates the intersection of two sets
	 */
	public void intersect(IntegerSet b) {
		integer_set.retainAll(b.integer_set);
	}
	
	
	/**
	 * calculates the difference of two sets
	 */
	public void diff(IntegerSet b) {
		for (int i = 0; i < b.length(); i++) {
			if (integer_set.contains(b.integer_set.get(i)) == true) {
				integer_set.remove(b.integer_set.get(i));
			}
		}
	}
	
	
	/**
	 * checks if the set is empty
	 * 
	 * @return true if empty, otherwise false
	 */
	public boolean isEmpty() {
		return integer_set.isEmpty();
	}
	
	
	/**
	 * prints every integer in the set
	 * 
	 * 
	 */
	public String toString() {
		String list = "";
		for (int i = 0; i < integer_set.size(); i++) {
			list += integer_set.get(i).toString() + ", ";
		}
		return list;
	}
}