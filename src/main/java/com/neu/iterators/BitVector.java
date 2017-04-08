package com.neu.iterators;

/**
 * @author ideepakkrishnan
 *
 */
public class BitVector {

	private int[] store;
	private int length;
	
	/**
	 * Overloaded constructor used to set the
	 * maximum number of digits that could be
	 * possible stored in this object
	 * @param length The maximum length possible
	 */
	public BitVector(int length) {
		this.store = new int[(length >> 5) + 1];
		this.length = length;
    }	

	/**
	 * Determine if the bit at specified position
	 * is set.
	 * @param i The bit position which needs to be
	 * checked
	 * @return true iff the bit is set
	 */
	public boolean get(int i) {
		if (i >= 0 && i < this.length) {
			int iBitPos  = i & 0x1F;
	        int iStorePos = i >> 5;
	        return (this.store[iStorePos] & (1 << iBitPos)) != 0;
		} else {
			throw new IndexOutOfBoundsException(
					"Available memory: " + this.length + " bits");
		}
	}

	/**
	 * Sets the bit at specified position
	 * @param i The bit position which is to be set
	 */
	public void set(int i) {
		if (i >= 0 && i < this.length) {
			int iBitPos  = i & 0x1F;
	        int iStorePos = i >> 5;
			this.store[iStorePos] = this.store[iStorePos] | (1 << iBitPos);
		} else {
			throw new IndexOutOfBoundsException(
					"Available memory: " + this.length + " bits");
		}
	}

	/**
	 * Clears the bit at specified position
	 * @param i The bit position to be cleared
	 */
	public void clear(int i) {
		if (i >= 0 && i < this.length) {
			int iBitPos  = i & 0x1F;
	        int iStorePos = i >> 5;
			this.store[iStorePos] = this.store[iStorePos] & (~ (1 << iBitPos));
		} else {
			throw new IndexOutOfBoundsException(
					"Available memory: " + this.length + " bits");
		}
	}

	/**
	 * Add the bits set in argument BitVector to
	 * this instance
	 * @param b Specifies the bits to be set
	 */
	public void addAll(BitVector b) {
		if (this.length == b.size()) {
			for (int i = 0; i < b.size(); i++) {
				if (b.get(i)) {
					this.set(i);
				}
			}
		} else {
			throw new IndexOutOfBoundsException(
					"Available memory: " + this.length + " bits");
		}
	}

	/**
	 * Creates a new iterator for this BitVector
	 * and returns it to the caller
	 * @return The iterator
	 */
	public Iterator<Integer> iterator() {
		return new BitVectorIterator();
	}

	/**
	 * Gets the memory allocation for this
	 * instance of BitVector
	 * @return the size
	 */
	public int size() {
		return this.length;
	}
	
	private class BitVectorIterator implements Iterator<Integer> {
		int[] bits = new int[size()];
		int length;
		int currIndex = 0;
		
		public BitVectorIterator(){
			for (int i = 0; i < size(); i++){
				if(get(i)){
					this.bits[this.currIndex] = i;
					++this.currIndex;
				}
			}
			
			this.length = this.currIndex;
			this.currIndex = 0;
		}

		public boolean hasAnotherElement() {
			boolean result = this.currIndex < this.length;
			
			if (!result) {
				this.currIndex = 0;
			}
			
			return result;
		}

		public Integer nextElement() {
			if (this.currIndex < this.length) {
				int value = this.bits[this.currIndex];
				++this.currIndex;
				return value;
			} else {
				throw new IndexOutOfBoundsException(
						"Exceeded allocated memory of: " + 
						this.length + " bits");
			}
		}
		
	}
	
}
