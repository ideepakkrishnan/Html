package com.neu.adapter;

import java.util.HashMap;
import java.util.Map;

import com.neu.iterators.BitVector;
import com.neu.iterators.Iterator;

public class StringSet implements Set<String>{

	// Map to store the Strings
	private Map<String, Integer> store;
	
	// Tracks the next unique number that
	// can be assigned to a string being
	// added to the store
	private int counter = 0;
	
	// Maximum number of entries possible
	private int length = 0;

	private BitVector vector;

	/**
	 * Overloaded constructor
	 * @param length The maximum number of possible entries
	 */
	public StringSet(int length) {
		this.vector = new BitVector(length);
		this.store = new HashMap<String, Integer>();
		this.length = length;
	}

	/**
	 * Add a value to this StringSet
	 * @param t 
	 */
	public void add(String value) {
		this.vector.set(addToStore(value));
	}

	/**
	 * Add a list of values to this StringSet
	 * @param values A list of String-s
	 */
	public void addAll(Set<String> values) {
		Iterator<String> it = values.iterator();
		while (it.hasAnotherElement()) {
			this.add(it.nextElement());
		}
	}

	/**
	 * Remove a value from this StringSet
	 * @param value The string to be removed
	 */
	public void remove(String value) {
		this.vector.clear(store.get(value));
		this.store.remove(value);
	}

	/**
	 * Returns the number of elements in this
	 * StringSet
	 * @return the number of elements
	 */
	public int size() {
		return this.length;
	}

	/**
	 * Get an iterator to this StringSet
	 * @return an iterator
	 */
	public Iterator<String> iterator() {
		return new StringSetIterator();
	}

	/**
	 * Adds the string passed in as argument
	 * to the store and generates a unique
	 * number for this new entry
	 * @param s
	 * @return
	 */
	public int addToStore(String value) {
		// Check if the string already exists
		Integer pos = this.store.get(value);
		
		if (pos == null) {
			// Since the string was not found,
			// add it to the store with a
			// unique integer mapped to it
			this.store.put(value, this.counter);
			pos = this.counter;
			
			// Increment the counter so that
			// it can be used for the next
			// string being entered into the
			// store
			++this.counter;
		}
		
		return pos;
	}

	/**
	 * Defines the iterator for this StringSet
	 * @author ideepakkrishnan
	 */
	private class StringSetIterator implements Iterator<String> {

		Iterator<Integer> storeIterator;
		
		/**
		 * Default Constructor
		 */
		public StringSetIterator() {
			this.storeIterator = vector.iterator();
		}

		/**
		 * Checks whether this StringSet has at least
		 * one value after the current position of
		 * the iterator
		 * @return true iff an element exists
		 */
		public boolean hasAnotherElement() {
			return this.storeIterator.hasAnotherElement();
		}

		/**
		 * Returns the next element stored in this
		 * StringSet
		 * @return the next element
		 */
		public String nextElement() {
			String nextVal = "";
			
			int nextBit = this.storeIterator.nextElement();
			
			for (Map.Entry<String, Integer> entry
					: store.entrySet()) {
				if(entry.getValue().equals(nextBit)){
					nextVal = entry.getKey();
					return nextVal;
				}				
			}
			
			return this.nextElement();
		}

	}

}
