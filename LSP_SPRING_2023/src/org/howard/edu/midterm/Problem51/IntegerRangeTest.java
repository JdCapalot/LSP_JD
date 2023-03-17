package org.howard.edu.midterm.Problem51;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.howard.edu.midterm.Problem51.Range.EmptyRangeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class IntegerRangeTest {

	IntegerRange first_range;
	
	@BeforeEach
	void setUp() throws Exception {
		first_range = new IntegerRange(0, 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		first_range = null;
	}

	@Test
	@DisplayName("Test for get_lower")
	void testGetLower() {
		assertEquals(first_range.get_lower(), 0);
	}
	
	@Test
	@DisplayName("Test for get_upper")
	void testGetUpper() {
		assertEquals(first_range.get_upper(), 100);
	}
	
	@Test
	@DisplayName("Test for contains")
	void testContains() {
		assertTrue(first_range.contains(56));
		assertFalse(first_range.contains(789));
		assertFalse(first_range.contains(-34));
		assertTrue(first_range.contains(100));
	}
	
	@Test
	@DisplayName("Test for overlaps")
	void testOverlaps() throws EmptyStackException, EmptyRangeException {
		IntegerRange other_range;
		
		other_range = new IntegerRange(50, 75);
		assertTrue(first_range.overlaps(other_range));
		assertTrue(other_range.overlaps(first_range));
		
		other_range = new IntegerRange(89, 143);
		assertTrue(first_range.overlaps(other_range));
		assertTrue(other_range.overlaps(first_range));
		
		other_range = new IntegerRange(-10, 5);
		assertTrue(first_range.overlaps(other_range));
		assertTrue(other_range.overlaps(first_range));
		
		other_range = new IntegerRange(101, 456);
		assertFalse(first_range.overlaps(other_range));
		assertFalse(other_range.overlaps(first_range));
	}
	
	@Test
	@DisplayName("Test for EmptyRangeException")
	void testOverlapsException() {
		IntegerRange other_range = null;
		
		assertThrows(EmptyStackException.class, () -> first_range.overlaps(other_range));
	}
	
	@Test
	@DisplayName("Test for size")
	void testSize() {
		IntegerRange other_range;
		
		other_range = new IntegerRange(25, 50);
		assertEquals(other_range.size(), 25);
		
		other_range = new IntegerRange(78, 143);
		assertEquals(other_range.size(), 65);
		
		other_range = new IntegerRange(-10, 10);
		assertEquals(other_range.size(), 20);
		
		assertEquals(first_range.size(), 100);
	}
}