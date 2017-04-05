package com.neu.html;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test1()
    {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = new Div(divAtts, "b");
    	
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	B b = new B(noAttributes, div);
    	assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");        
    }
}
