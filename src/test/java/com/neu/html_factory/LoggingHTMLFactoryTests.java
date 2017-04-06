/**
 * 
 */
package com.neu.html_factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.neu.html.B;
import com.neu.html.Body;
import com.neu.html.Div;
import com.neu.html.HTML;
import com.neu.html.Head;
import com.neu.html.Node;
import com.neu.html.Title;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author ideepakkrishnan
 *
 */
public class LoggingHTMLFactoryTests extends TestCase {
	
	private AbstractHTMLNodeFactory factory = new LoggingHTMLFactory();
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoggingHTMLFactoryTests( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LoggingHTMLFactoryTests.class );
    }
    
    public void testBWithContent() {    	
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = factory.makeB();
    	b.set(bAtts, new Div());
    	assertEquals(
    			b.textualRepresentation(), 
    			"<b class=highlight><div></div></b>");
    }
    
    public void testBodyWithContent() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(div);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	assertEquals(
    			"<body id=content><div class=bar id=second>b</div></body>", 
    			body.textualRepresentation());
    }
    
    public void testDivWithNoContent() {
    	Div div = factory.makeDiv();
    	assertEquals("<div></div>", div.textualRepresentation());
    }
    
    public void testDivWithContent() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	assertEquals(
    			"<div class=bar id=second>b</div>", 
    			div.textualRepresentation());
    }
    
    public void testHeadWithNoContent() {
    	Head head = factory.makeHead();
    	assertEquals("<head></head>", head.textualRepresentation());
    }
    
    public void testHeadWithContent() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	List<Node> children = new LinkedList<Node>();
    	children.add(title);
    	
    	Map<String,String> headAtts = new HashMap<String,String>();
    	headAtts.put("class", "header");
    	Head head = factory.makeHead();
    	head.set(headAtts, children);
    	assertEquals(
    			"<head class=header><title>Northeastern University</title></head>", 
    			head.textualRepresentation());
    }
    
    public void testHtmlWithNoContent() {
    	HTML html = factory.makeHtml();
    	assertEquals("<html></html>", html.textualRepresentation());
    }
    
    public void testHtmlWithContent() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	
    	List<Node> headChildren = new LinkedList<Node>();
    	headChildren.add(title);
    	Head head = factory.makeHead();
    	head.set(noAttributes, headChildren);
    	
    	Body body = new Body();
    	
    	List<Node> htmlChildren = new LinkedList<Node>();
    	htmlChildren.add(head);
    	htmlChildren.add(body);
    	
    	Map<String,String> htmlAtts = new HashMap<String,String>();
    	htmlAtts.put("id", "container");
    	HTML html = factory.makeHtml();
    	html.set(htmlAtts, htmlChildren);
    	assertEquals(
    			"<html id=container><head><title>Northeastern University"
    			+ "</title></head><body></body></html>", 
    			html.textualRepresentation());
    }
    
    public void testTitleWithContent()
    {
    	Map<String,String> titleAtts = new HashMap<String,String>();
    	titleAtts.put("class", "titleStyle");
    	
    	Title title = factory.makeTitle();
    	title.set(titleAtts, "Northeastern University");
    	assertEquals(
    			title.textualRepresentation(), 
    			"<title class=titleStyle>Northeastern University</title>");        
    }
    
    public void testTitleWithNoContent() {
    	Title title = factory.makeTitle();
    	assertEquals("<title></title>", title.textualRepresentation());
    }

}
