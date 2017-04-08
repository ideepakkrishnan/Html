package com.neu.adapter;

import java.util.HashMap;
import java.util.Map;

import com.neu.iterators.BitVector;
import com.neu.iterators.Iterator;

public class StringSet implements Set<String>{

	private Map<String, Integer> setMap;
	private int counter = 0;
	private int size = 0;

	private BitVector vector;

	public StringSet(int i) {
		vector = new BitVector(i);
		setMap = new HashMap<String, Integer>();
		size = i;
	}

	public void add(String t) {
		vector.set(toInt(t));
	}

	public void addAll(Set<String> s) {
		Iterator<String> itr = s.iterator();
		while (itr.hasAnotherElement()) {
			this.add(itr.nextElement());
		}
	}

	public void remove(String t) {
		vector.clear(setMap.get(t));
		setMap.remove(t);
	}

	public int size() {
		return size;
	}

	public Iterator<String> iterator() {
		return new StringSetIterator();
	}

	public int toInt(String s) {
		Integer i = setMap.get(s);
		if (i == null) {
			setMap.put(s, counter);
			i = counter;
			++counter;
		}
		return i;
	}

	private class StringSetIterator implements Iterator<String> {

		Iterator<Integer> bitIterator;
		public StringSetIterator() {
			bitIterator = vector.iterator();
		}

		public boolean hasAnotherElement() {
			return bitIterator.hasAnotherElement();
		}

		public String nextElement() {
			String nextElement = "";
			int nextBit = bitIterator.nextElement();			
			for (Map.Entry<String, Integer> e : setMap.entrySet()) {
				if(e.getValue().equals(nextBit)){
					nextElement = e.getKey();
					return nextElement;
				}				
			}
			return this.nextElement();
		}

	}

}
