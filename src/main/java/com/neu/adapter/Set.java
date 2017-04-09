package com.neu.adapter;

import com.neu.iterators.Iterator;

public interface Set<T> {
	/**
	 * Add an element to the set
	 * @param t
	 */
	void add(T t); 

	/**
	 * Add all elements in the argument set
	 * @param s
	 */
	void addAll(Set<T> s);

	/**
	 * Remove an element from the set
	 * @param t
	 */
	void remove(T t);

	/**
	 * Return the number of arguments in the set
	 * @return
	 */
	int size();

	/**
	 * Return an iterator over the set
	 * @return
	 */
	Iterator<T> iterator();
}
