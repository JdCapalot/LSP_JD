package org.howard.edu.hw5;

import org.howard.edu.hw5.IntegerSet.IntegerSetException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

class IntegerSetTest {
	
	IntegerSet new_set;

	@BeforeEach
	void setUp() throws Exception {
		new_set = new IntegerSet();
	}

	@AfterEach
	void tearDown() throws Exception {
		new_set = null;
	}
		
	@Test
	@DisplayName("Test case for clear")
	void testClear() {
		new_set.add(1);
		new_set.clear();
		assertEquals(new_set.integer_set.size(), 0);
	}
	
	@Test
	@DisplayName("Test case for length")
	void testLength() {
		new_set.add(5);
		new_set.add(10);
		new_set.add(15);
		new_set.add(20);
		assertTrue(new_set.length() == 4);
	}
	
	@Test
	@DisplayName("Test case for equals")
	void testEquals() {
		IntegerSet that_set = new IntegerSet();
		that_set.add(1);
		new_set.add(1);
		assertTrue(new_set.equals(that_set));
	}
	
	@Test
	@DisplayName("Test case for contains")
	void testContains() {
		new_set.add(35);
		assertTrue(new_set.contains(35));
	}
	
	@Test
	@DisplayName("Test case for largest")
	void testLargest() throws IntegerSetException {
		new_set.add(10);
		new_set.add(20);
		new_set.add(30);
		new_set.add(40);
		new_set.add(50);
		assertTrue(new_set.largest() == 50);
	}
	
	@Test
	@DisplayName("Test case for largest exception")
	void testLargestException() {
		assertThrows(IntegerSetException.class, () -> new_set.largest());
	}
	
	@Test
	@DisplayName("Test case for smallest")
	void testSmallest() throws IntegerSetException {
		new_set.add(20);
		new_set.add(40);
		new_set.add(60);
		new_set.add(80);
		assertTrue(new_set.smallest() == 20);
	}
	
	@Test
	@DisplayName("Test case for smallest exception")
	void testSmallestException() {
		assertThrows(IntegerSetException.class, () -> new_set.smallest());
	}
	
	@Test
	@DisplayName("Test case for add")
	void testAdd() {
		IntegerSet that_set = new IntegerSet();
		that_set.add(2);
		that_set.add(4);
		that_set.add(6);
		
		new_set.add(2);
		new_set.add(4);
		new_set.add(6);
		
		assertTrue(that_set.equals(new_set));
	}
	
	@Test
	@DisplayName("Test case for remove")
	void testRemove() {
		new_set.add(50);
		new_set.add(100);
		new_set.add(150);
		new_set.remove(150);
		
		assertFalse(new_set.contains(150));
	}
	
	@Test
	@DisplayName("Test case for union")
	void testUnion() {
		IntegerSet that_set = new IntegerSet();
		new_set.add(1);
		new_set.add(2);
		new_set.add(3);
		new_set.add(4);
		
		that_set.add(5);
		that_set.add(6);
		
		new_set.union(that_set);
		assertEquals(new_set.integer_set, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}
	
	@Test
	@DisplayName("Test case for intersect")
	void testIntersect() {
		IntegerSet that_set = new IntegerSet();
		new_set.add(5);
		new_set.add(10);
		new_set.add(15);
		new_set.add(20);
		
		that_set.add(10);
		that_set.add(20);
		that_set.add(30);
		that_set.add(40);
		
		new_set.intersect(that_set);
		assertEquals(new_set.integer_set, new ArrayList<Integer>(Arrays.asList(10, 20)));
	}
	
	@Test
	@DisplayName("Test case for difference")
	void testDifference() {
		IntegerSet that_set = new IntegerSet();
		new_set.add(20);
		new_set.add(40);
		new_set.add(60);
		
		that_set.add(30);
		that_set.add(40);
		that_set.add(50);
		
		new_set.diff(that_set);
		assertEquals(new_set.integer_set, new ArrayList<Integer>(Arrays.asList(20, 60)));
	}
	
	@Test
	@DisplayName("Test case for isEmpty")
	void testEmpty() {
		assertTrue(new_set.isEmpty());
	}
	
	@Test
	@DisplayName("Test case for toString")
	void testString() {
		new_set.add(1);
		new_set.add(2);
		new_set.add(3);
		new_set.add(4);
		new_set.add(5);
		
		assertEquals(new_set.toString(), "1, 2, 3, 4, 5, ");
	}
}