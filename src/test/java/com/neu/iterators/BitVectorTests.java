/**
 * 
 */
package com.neu.iterators;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ideepakkrishnan
 *
 */
public class BitVectorTests {
	
	private BitVector bv;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bv = new BitVector(32);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bv = null;		
	}

	@Test
	public void testOverloadedConstructor() {
    	Assert.assertEquals(32, bv.size());
    }
	
	@Test
	public void testGet() {
		Assert.assertFalse(bv.get(12));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetNegativePosition() {
		Assert.assertFalse(bv.get(-1));
	}
    
	@Test (expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
    	bv.get(57);
    }
    
	@Test
    public void testSet() {
    	bv.set(25);
    	Assert.assertTrue(bv.get(25));
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetNegativePosition() {
		bv.set(-1);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetOutOfBounds() {
		bv.set(33);
	}
	
	@Test
	public void testClearUnsetPosition() {
		bv.clear(10);
	}
	
	@Test
	public void testClearSetPosition() {
		bv.clear(25);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testClearNegativePosition() {
		bv.clear(-1);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testClearOutOfBounds() {
		bv.clear(32);
	}
	
	@Test
	public void testMergeBitVectorOfSameSize() {
		BitVector secondary = new BitVector(32);
		secondary.set(5);
		secondary.set(11);
		secondary.set(27);
		
		bv.addAll(secondary);
		
		Assert.assertTrue(bv.get(5));
		Assert.assertTrue(bv.get(11));
		Assert.assertTrue(bv.get(27));
		Assert.assertFalse(bv.get(0));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testMergeBitVectorOfDifferentSize() {
		BitVector secondary = new BitVector(64);
		secondary.set(15);
		secondary.set(21);
		secondary.set(30);
		
		bv.addAll(secondary);
	}
	
	@Test
	public void testIteratorWithEmptyBitVector() {
		Iterator<Integer> bv_iterator = bv.iterator();
		Assert.assertFalse(bv_iterator.hasAnotherElement());
	}
	
	@Test
	public void testIteratorWithNonEmptyBitVector() {
		bv.set(11);
		Iterator<Integer> bv_iterator = bv.iterator();
		Assert.assertTrue(bv_iterator.hasAnotherElement());
	}
	
	@Test
	public void testNextElement() {
		bv.set(1);
		Iterator<Integer> bv_iterator = bv.iterator();
		Assert.assertEquals(1, bv_iterator.nextElement().intValue());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testNextElementOutOfBounds() {
		bv.set(11);
		System.out.println("Length: " + bv.size());
		Iterator<Integer> bv_iterator = bv.iterator();
		for (int i = 0; i < 33; i++) {
			bv_iterator.nextElement();
		}		
	}

}
