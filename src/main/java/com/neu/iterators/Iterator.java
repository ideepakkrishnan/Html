package com.neu.iterators;

/**
 * @author ideepakkrishnan
 *
 */
public interface Iterator<T> {
	
	boolean hasAnotherElement();

	T nextElement();
}
