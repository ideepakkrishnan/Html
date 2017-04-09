package com.neu.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.neu.iterators.Iterator;

public class StringSetTests {

	@Test
	public void testAdd() {
		Set<String> set = new StringSet(30);
		set.add("Add Test");
		Iterator<String> itr = set.iterator();
		while(itr.hasAnotherElement()){
			assertEquals(true, itr.nextElement().equalsIgnoreCase("Add Test"));
		}
	}
	
	@Test
	public void testAddMultipleStrings() {
		Set<String> set = new StringSet(30);
		set.add("Add Test 1");
		set.add("Add Test 2");
		set.add("Add Test 3");
		set.add("Add Test 4");
		Iterator<String> itr = set.iterator();
		int count = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			count++;
		}
		assertEquals(4, count);
	}

	@Test
	public void testAddAll() {
		Set<String> set = new StringSet(30);
		set.add("Add Test 1");
		set.add("Add Test 2");
		set.add("Add Test 3");
		set.add("Add Test 4");
		
		Set<String> testSet = new StringSet(4);
		testSet.addAll(set);
		
		Iterator<String> itr = testSet.iterator();
		int count = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			count++;
		}
		assertEquals(4, count);
		
	}

	@Test
	public void testRemove() {
		Set<String> set = new StringSet(30);
		set.add("Add Test 1");
		set.add("Add Test 2");
		set.add("Add Test 3");
		set.add("Add Test 4");
		
		Iterator<String> itr = set.iterator();
		int count = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			count++;
		}
		assertEquals(4, count);
		
		set.remove("Add Test 1");
		
		count = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			count++;
		}
		
		assertEquals(3, count);
		
	}

	@Test
	public void testSize() {
		Set<String> set = new StringSet(30);
		assertEquals(30, set.size());
	}

	@Test
	public void testIterator() {
		Set<String> set = new StringSet(30);
		set.add("Add Test 1");
		set.add("Add Test 2");
		set.add("Add Test 3");
		set.add("Add Test 4");
		Iterator<String> itr = set.iterator();
		int count = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			count++;
		}
		assertEquals(4, count);
	}

}
