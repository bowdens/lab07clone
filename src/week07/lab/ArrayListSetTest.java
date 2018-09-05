package week07.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ArrayListSetTest {
	
	private ArrayListSet<Integer> integerSet;
	private ArrayListSet<Integer> otherIntegerSet;
	private ArrayListSet<String> stringSet;
	
	@BeforeEach
	void setUp() throws Exception {
		this.integerSet = new ArrayListSet<>();
		this.otherIntegerSet = new ArrayListSet<>();
		this.stringSet = new ArrayListSet<>();
	}
	
	@Test
	void testSingleAdd() {
		int expected = 5;
		int expectedSize = 1;
		
		integerSet.add(expected);
		
		assertTrue(integerSet.contains(expected));
		assertEquals(expectedSize, integerSet.size());
	}
	
	@Test
	void testMultipleSameAdd() {
		int expected = 2;
		int expectedSize = 1;
		
		for(int i = 0; i < 5; i++) {
			integerSet.add(expected);
		}
		
		assertTrue(integerSet.contains(expected));
		assertEquals(expectedSize, integerSet.size());
	}
	
	@Test
	void testMultipleDifferentAdd() {
		int start = 0;
		int end = 100;
		int expectedSize = 100;
		
		for(int i = start; i < end; i++) {
			integerSet.add(i);
		}
		
		assertEquals(integerSet.size(), expectedSize);
		for(int i = start; i < end; i++) {
			assertTrue(integerSet.contains(i));
		}
		
	}
	
	@Test
	void testRemoveItem() {
		integerSet.add(1);
		integerSet.remove(1);
		assertFalse(integerSet.contains(1));
		assertEquals(integerSet.size(), 0);
	}
	
	@Test void testRemoveNonExistantItem() {
		integerSet.add(1);
		integerSet.remove(2);
		assertTrue(integerSet.contains(1));
		assertFalse(integerSet.contains(2));
		assertEquals(integerSet.size(), 1);
	}
	
	
	@Test
	void testEmptySetEquality() {
		assertEquals(integerSet.size(), 0);
		assertEquals(otherIntegerSet.size(), 0);
		assertTrue(integerSet.equals(otherIntegerSet));
		assertTrue(otherIntegerSet.equals(integerSet));
	}
	
	@Test
	void testNonEmptySetEquality() {
		for(int i = 0; i < 100; i++) {
			integerSet.add(i);
			otherIntegerSet.add(i);
		}
		
		assertTrue(integerSet.equals(otherIntegerSet));
		assertTrue(otherIntegerSet.equals(integerSet));
	}
	
	@Test
	void testSameTypeSetInequality() {
		integerSet.add(1);
		integerSet.add(2);
		otherIntegerSet.add(2);
		
		assertFalse(integerSet.equals(otherIntegerSet));
		assertFalse(otherIntegerSet.equals(integerSet));
	}
	
	@Test
	void testDifferentTypeSetInequality() {
		integerSet.add(1);
		stringSet.add("1");
		
		assertFalse(integerSet.equals(stringSet));
		assertFalse(stringSet.equals(integerSet));
	}
	
	@Test
	void testDifferentTypeEmptySetEquality() {
		assertTrue(integerSet.equals(stringSet));
	}
	
	@Test
	void testDifferentObjectInequality() {
		String otherObject = "randomString";
		assertFalse(integerSet.equals(otherObject));
	}
	
	@Test
	void testEmptySetsAreSubsets() {
		assertTrue(otherIntegerSet.subset(integerSet));
		assertTrue(integerSet.subset(otherIntegerSet));
	}
	
	@Test
	void testEmptySetIsSubset() {
		integerSet.add(1);
		assertTrue(otherIntegerSet.subset(integerSet));
		assertFalse(integerSet.subset(otherIntegerSet));
	}
	
	@Test 
	void testEquivalentSetIsSubset() {
		for (int i = 0; i < 100; i++) {
			integerSet.add(i);
			otherIntegerSet.add(i);
		}
		assertTrue(otherIntegerSet.subset(integerSet));
		assertTrue(integerSet.subset(otherIntegerSet));
	}
	
	@Test
	void testSubsetIsSubset() {
		for (int i = 0; i < 100; i++) {
			integerSet.add(i);
		}
		for (int i = 0; i < 99; i++) {
			otherIntegerSet.add(i);
		}
		
		assertTrue(otherIntegerSet.subset(integerSet));
		assertFalse(integerSet.subset(otherIntegerSet));
	}
	
	@Test
	void testEmptyIntersection() {
		Set<?> expectedIntersection = new ArrayListSet<>();
		Set<?> intersection = integerSet.intersection(otherIntegerSet);
		assertEquals(intersection.size(), 0);
		assertTrue(intersection.equals(expectedIntersection));
	}
	
	@Test
	void testEqualIntersection() {
		Set<Integer> expectedIntersection = new ArrayListSet<>();
		for(int i = 0; i < 100; i++) {
			integerSet.add(i);
			otherIntegerSet.add(i);
			expectedIntersection.add(i);
		}
		
		Set<?> intersection = integerSet.intersection(otherIntegerSet);
		assertTrue(intersection.equals(expectedIntersection));
	}
	
	@Test
	void testOverlappingIntersection() {
		Set<Integer> expectedIntersection = new ArrayListSet<>();
		
		for(int i = 0; i < 70; i++) {
			integerSet.add(i);
		}
		for(int i = 50; i < 100; i++) {
			otherIntegerSet.add(i);
		}
		for(int i = 50; i < 70; i++) {
			expectedIntersection.add(i);
		}
		
		Set<Integer> intersection1 = integerSet.intersection(otherIntegerSet);
		Set<Integer> intersection2 = otherIntegerSet.intersection(integerSet);
		assertTrue(intersection1.equals(expectedIntersection));
		assertTrue(intersection2.equals(expectedIntersection));
	}
	
	@Test
	void testDisjointIntersection() {
		Set<Integer> expectedIntersection = new ArrayListSet<>();
		
		for(int i = 0; i < 50; i++) {
			integerSet.add(i);
		}
		for(int i = 50; i < 100; i++) {
			otherIntegerSet.add(i);
		}
		
		Set<Integer> intersection1 = integerSet.intersection(otherIntegerSet);
		Set<Integer> intersection2 = otherIntegerSet.intersection(integerSet);
		assertTrue(intersection1.equals(expectedIntersection));
		assertTrue(intersection2.equals(expectedIntersection));
	}
	
	@Test
	void testEmptyUnion() {
		Set<Integer> expectedUnion = new ArrayListSet<>();
		
		for(int i = 0; i < 100; i++) {
			integerSet.add(i);
			expectedUnion.add(i);
		}
		
		Set<Integer> union1 = integerSet.union(otherIntegerSet);
		Set<Integer> union2 = otherIntegerSet.union(integerSet);
		assertTrue(union1.equals(expectedUnion));
		assertTrue(union2.equals(expectedUnion));
	}
	
	@Test
	void testEqualUnion() {
		Set<Integer> expectedUnion = new ArrayListSet<>();
		
		for(int i = 0; i < 100; i++) {
			integerSet.add(i);
			otherIntegerSet.add(i);
			expectedUnion.add(i);
		}
		
		Set<Integer> union1 = integerSet.union(otherIntegerSet);
		Set<Integer> union2 = otherIntegerSet.union(integerSet);
		assertTrue(union1.equals(expectedUnion));
		assertTrue(union2.equals(expectedUnion));
	}
	
	@Test
	void testOverlappingUnion() {
		Set<Integer> expectedUnion = new ArrayListSet<>();
		
		for (int i = 0; i < 70; i++) {
			integerSet.add(i);
		}
		
		for (int i = 50; i < 100; i++) {
			otherIntegerSet.add(i);
		}
		
		for (int i = 0; i < 100; i++) {
			expectedUnion.add(i);
		}
		
		Set<Integer> union1 = integerSet.union(otherIntegerSet);
		Set<Integer> union2 = otherIntegerSet.union(integerSet);
		assertTrue(union1.equals(expectedUnion));
		assertTrue(union2.equals(expectedUnion));
	}
	
	@Test
	void testDisjointUnion() {
		Set<Integer> expectedUnion = new ArrayListSet<>();
		
		for (int i = 0; i < 50; i++) {
			integerSet.add(i);
		}
		
		for (int i = 50; i < 100; i++) {
			otherIntegerSet.add(i);
		}
		
		for (int i = 0; i < 100; i++) {
			expectedUnion.add(i);
		}
		
		Set<Integer> union1 = integerSet.union(otherIntegerSet);
		Set<Integer> union2 = otherIntegerSet.union(integerSet);
		assertTrue(union1.equals(expectedUnion));
		assertTrue(union2.equals(expectedUnion));
	}
}
