package com.neu.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.neu.iterators.Iterator;

public class StringSetTests {

	@Test
	public void testAdd() {
		Set<String> store = new StringSet(32);
		store.add("First");
		Iterator<String> it = store.iterator();
		while(it.hasAnotherElement()){
			assertEquals(true, it.nextElement().equals("First"));
		}
	}
	
	@Test
	public void testAddMultipleStrings() {
		Set<String> store = new StringSet(32);
		store.add("First");
		store.add("Second");
		store.add("Third");
		
		Iterator<String> itr = store.iterator();
		int length = 0;
		while(itr.hasAnotherElement()){
			itr.nextElement();
			length++;
		}
		
		assertEquals(3, length);
	}

	@Test
	public void testAddAll() {
		Set<String> store = new StringSet(32);
		store.add("First");
		store.add("Second");
		store.add("Third");
		
		Set<String> testSet = new StringSet(3);
		testSet.addAll(store);
		
		Iterator<String> it = testSet.iterator();
		int length = 0;
		while(it.hasAnotherElement()){
			it.nextElement();
			length++;
		}
		
		assertEquals(3, length);
		
	}

	@Test
	public void testRemove() {
		Set<String> store = new StringSet(32);
		store.add("First");
		store.add("Second");
		store.add("Third");
		
		Iterator<String> it = store.iterator();
		int length = 0;
		while(it.hasAnotherElement()){
			it.nextElement();
			length++;
		}
		assertEquals(3, length);
		
		store.remove("Second");
		
		length = 0;
		while(it.hasAnotherElement()){
			it.nextElement();
			length++;
		}
		
		assertEquals(2, length);
		
	}

	@Test
	public void testSize() {
		Set<String> store = new StringSet(32);
		assertEquals(32, store.size());
	}

	@Test
	public void testIterator() {
		Set<String> store = new StringSet(30);
		store.add("First");
		store.add("Second");
		store.add("Third");
		
		Iterator<String> it = store.iterator();
		int length = 0;
		while(it.hasAnotherElement()){
			it.nextElement();
			length++;
		}
		
		assertEquals(3, length);
	}

}
