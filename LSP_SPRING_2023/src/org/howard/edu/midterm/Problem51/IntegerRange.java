package org.howard.edu.midterm.Problem51;

public class IntegerRange implements Range {
	private int lower;
	private int upper; 
	
	IntegerRange(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	public int get_lower() {
		return lower;
	}
	
	public int get_upper() {
		return upper;
	}
	
	public boolean contains(int value) {
		if (get_lower() <= value && value <= get_upper()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean overlaps(Range other) throws EmptyRangeException {
		if (other == null) {
			throw new EmptyRangeException("The range is empty");
		}
		else {
			if (get_lower() >= other.get_lower() && (get_upper() <= other.get_upper() || get_upper() >= other.get_upper())) {
				if (get_lower() > other.get_upper()) {
					return false;
				}
				return true;
			}
			else if (get_lower() <= other.get_lower() && (get_upper() <= other.get_upper() || get_upper() >= other.get_upper())) {
				if (other.get_lower() > get_upper()) {
					return false;
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public int size() {
		return get_upper() - get_lower();
	}
}