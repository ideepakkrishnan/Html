package com.neu.html;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    	assertEquals(
    			b.textualRepresentation(), 
    			"<b><div class=bar id=second>b</div></b>");        
    }
    
    public void testBWithValidConstructor() {
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = new B(bAtts, new Div());
    	assertEquals(
    			b.textualRepresentation(), 
    			"<b class=highlight><div></div></b>");
    }
    
    public void testBWithInvalidConstructor() {
    	Map<String,String> bAtts = new HashMap<String,String>();
    	B b = new B(bAtts, "Northeastern University");
    	assertEquals("<b></b>", b.textualRepresentation());
    }
    
    public void testBWithDefaultConstructor() {
    	B b = new B();
    	assertEquals("<b></b>", b.textualRepresentation());
    }
    
    public void testBodyWithValidConstructor() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = new Div(divAtts, "b");
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(div);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	Body body = new Body(bodyAtts, children);
    	assertEquals(
    			"<body id=content><div class=bar id=second>b</div></body>", 
    			body.textualRepresentation());
    }
    
    public void testBodyWithInvalidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Body body = new Body(noAttributes, "Northeastern University");
    	assertEquals("<body></body>", body.textualRepresentation());
    }
    
    public void testBodyWithDefaultConstructor() {
    	Body b = new Body();
    	assertEquals("<body></body>", b.textualRepresentation());
    }
    
    public void testDivWithDefaultConstructor() {
    	Div div = new Div();
    	assertEquals("<div></div>", div.textualRepresentation());
    }
    
    public void testDivWithValidConstructor() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = new Div(divAtts, "b");
    	assertEquals(
    			"<div class=bar id=second>b</div>", 
    			div.textualRepresentation());
    }
    
    public void testDivWithInvalidConstructor() {
    	B b = new B();
    	List<Node> children = new LinkedList<Node>();
    	children.add(b);
    	
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Div div = new Div(noAttributes, children);
    	assertEquals(div.textualRepresentation(), "<div></div>");
    }
    
    public void testHeadWithDefaultConstructor() {
    	Head head = new Head();
    	assertEquals("<head></head>", head.textualRepresentation());
    }
    
    public void testHeadWithValidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Title title = new Title(noAttributes, "Northeastern University");
    	List<Node> children = new LinkedList<Node>();
    	children.add(title);
    	
    	Map<String,String> headAtts = new HashMap<String,String>();
    	headAtts.put("class", "header");
    	Head head = new Head(headAtts, children);
    	assertEquals(
    			"<head class=header><title>Northeastern University</title></head>", 
    			head.textualRepresentation());
    }
    
    public void testHeadWithInvalidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Head head = new Head(noAttributes, "Northeastern University");
    	assertEquals("<head></head>", head.textualRepresentation());
    }
    
    public void testHtmlWithDefaultConstructor() {
    	HTML html = new HTML();
    	assertEquals("<html></html>", html.textualRepresentation());
    }
    
    public void testHtmlWithValidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	
    	Title title = new Title(noAttributes, "Northeastern University");
    	List<Node> headChildren = new LinkedList<Node>();
    	headChildren.add(title);
    	Head head = new Head(noAttributes, headChildren);
    	
    	Body body = new Body();
    	
    	List<Node> htmlChildren = new LinkedList<Node>();
    	htmlChildren.add(head);
    	htmlChildren.add(body);
    	
    	Map<String,String> htmlAtts = new HashMap<String,String>();
    	htmlAtts.put("id", "container");
    	HTML html = new HTML(htmlAtts, htmlChildren);
    	assertEquals(
    			"<html id=container><head><title>Northeastern University"
    			+ "</title></head><body></body></html>", 
    			html.textualRepresentation());
    }
    
    public void testHtmlWithInvalidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	HTML html = new HTML(noAttributes, "Northeastern University");
    	assertEquals("<html></html>", html.textualRepresentation());
    }
    
    public void testTitleWithValidConstructor()
    {
    	Map<String,String> titleAtts = new HashMap<String,String>();
    	titleAtts.put("class", "titleStyle");
    	Title title = new Title(titleAtts, "Northeastern University");
    	assertEquals(
    			title.textualRepresentation(), 
    			"<title class=titleStyle>Northeastern University</title>");        
    }
    
    public void testTitleWithInvalidConstructor() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	
    	Body body = new Body();    	
    	List<Node> titleChildren = new LinkedList<Node>();
    	titleChildren.add(body);
    	
    	Title title = new Title(noAttributes, titleChildren);
    	assertEquals("<title></title>", title.textualRepresentation());
    }
    
    public void testTitleWithDefaultConstructor() {
    	Title title = new Title();
    	assertEquals("<title></title>", title.textualRepresentation());
    }
}
