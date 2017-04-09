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
import com.neu.html_visitor.AttributeSearchVisitor;
import com.neu.html_visitor.NodeCountVisitor;
import com.neu.html_visitor.NodeVisitor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author ideepakkrishnan
 *
 */
public class HTMLVisitorTests extends TestCase {
	
	private AbstractHTMLNodeFactory factory = new LoggingHTMLFactory();
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HTMLVisitorTests( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HTMLVisitorTests.class );
    }
    
    public void testBWithContent() {
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = factory.makeB();
    	b.set(bAtts, new Div());
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	b.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 0);
    	assertEquals(visitor.getTitleCount(), 0);
    	assertEquals(visitor.getbCount(), 1);
    	assertEquals(visitor.getDivCount(), 1);
    }
    
    public void testBodyWithContent() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = factory.makeB();
    	b.set(bAtts, div);
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(b);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	body.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 1);
    	assertEquals(visitor.getTitleCount(), 0);
    	assertEquals(visitor.getbCount(), 1);
    	assertEquals(visitor.getDivCount(), 1);
    }
    
    public void testDivWithContent() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	div.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 0);
    	assertEquals(visitor.getTitleCount(), 0);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 1);
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
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	head.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 1);
    	assertEquals(visitor.getBodyCount(), 0);
    	assertEquals(visitor.getTitleCount(), 1);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 0);
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
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	html.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 1);
    	assertEquals(visitor.getHeadCount(), 1);
    	assertEquals(visitor.getBodyCount(), 1);
    	assertEquals(visitor.getTitleCount(), 1);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 0);
    	
    }
    
    public void testTitleWithContent()
    {
    	Map<String,String> titleAtts = new HashMap<String,String>();
    	titleAtts.put("class", "titleStyle");
    	
    	Title title = factory.makeTitle();
    	title.set(titleAtts, "Northeastern University");
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	
    	title.accept(visitor);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 0);
    	assertEquals(visitor.getTitleCount(), 1);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 0);
    }
    
    public void testDivWithAttributes() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String, String> searchOptions 
    			= new HashMap<String, String>();
    	
    	searchOptions.put("id", "second");
    	
    	AttributeSearchVisitor visitor = 
    			new AttributeSearchVisitor(searchOptions);
    	
    	div.accept(visitor);
    	
    	visitor.report();
    	
    	assertTrue(visitor.getResult()
    					  .iterator()
    					  .hasAnotherElement());
    }
    
    public void testDivWithoutAttributes() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String, String> searchOptions 
    			= new HashMap<String, String>();
    	
    	searchOptions.put("style", "none");
    	
    	AttributeSearchVisitor visitor = 
    			new AttributeSearchVisitor(searchOptions);
    	
    	div.accept(visitor);
    	
    	assertFalse(visitor.getResult()
    					   .iterator()
    					   .hasAnotherElement());
    }
    
    public void testBWithAttributes() {
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = factory.makeB();
    	b.set(bAtts, new Div());
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "highlight");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		b.accept(visitor);
		
		assertTrue(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testBWithoutAttributes() {
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("class", "highlight");
    	B b = factory.makeB();
    	b.set(bAtts, new Div());
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("style", "none");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		b.accept(visitor);
		
		assertFalse(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testBodyWithAttributes() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(div);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	bodyAtts.put("class", "bar");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "bar");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		body.accept(visitor);
		
		assertTrue(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testBodyWithoutAttributes() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("id", "third");
    	bAtts.put("class", "foo");
    	B b = factory.makeB();
    	b.set(divAtts, div);
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(b);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	bodyAtts.put("class", "bar");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("id", "fourth");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		body.accept(visitor);
		
		assertFalse(visitor.getResult()
						   .iterator()
						   .hasAnotherElement());
    }
    
    public void testTitleWithAttributes()
    {
    	Map<String,String> titleAtts = new HashMap<String,String>();
    	titleAtts.put("class", "titleStyle");
    	
    	Title title = factory.makeTitle();
    	title.set(titleAtts, "Northeastern University");
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "titleStyle");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		title.accept(visitor);
    	
		assertTrue(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testTitleWithoutAttributes()
    {
    	Map<String,String> titleAtts = new HashMap<String,String>();
    	titleAtts.put("class", "titleStyle");
    	
    	Title title = factory.makeTitle();
    	title.set(titleAtts, "Northeastern University");
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "bodyStyle");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		title.accept(visitor);
    	
		assertFalse(visitor.getResult()
						   .iterator()
						   .hasAnotherElement());
    }
    
    public void testHeadWithAttributes() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	List<Node> children = new LinkedList<Node>();
    	children.add(title);
    	
    	Map<String,String> headAtts = new HashMap<String,String>();
    	headAtts.put("class", "header");
    	Head head = factory.makeHead();
    	head.set(headAtts, children);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "header");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		head.accept(visitor);
    	
		assertTrue(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testHeadWithoutAttributes() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	List<Node> children = new LinkedList<Node>();
    	children.add(title);
    	
    	Map<String,String> headAtts = new HashMap<String,String>();
    	headAtts.put("class", "header");
    	Head head = factory.makeHead();
    	head.set(headAtts, children);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "body");
		
		AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
		head.accept(visitor);
    	
		assertFalse(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    }
    
    public void testHtmlWithAttributes() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	
    	List<Node> headChildren = new LinkedList<Node>();
    	headChildren.add(title);
    	Head head = factory.makeHead();
    	head.set(noAttributes, headChildren);
    	
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("id", "third");
    	bAtts.put("class", "foo");
    	B b = factory.makeB();
    	b.set(divAtts, div);
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(b);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	bodyAtts.put("class", "bar");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	List<Node> htmlChildren = new LinkedList<Node>();
    	htmlChildren.add(head);
    	htmlChildren.add(body);
    	
    	Map<String,String> htmlAtts = new HashMap<String,String>();
    	htmlAtts.put("id", "container");
    	HTML html = factory.makeHtml();
    	html.set(htmlAtts, htmlChildren);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("class", "bar");
    	
    	AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
    	html.accept(visitor);
    	
		assertTrue(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    	
    }
    
    public void testHtmlWithoutAttributes() {
    	Map<String,String> noAttributes = new HashMap<String,String>();
    	
    	Title title = factory.makeTitle();
    	title.set(noAttributes, "Northeastern University");
    	
    	List<Node> headChildren = new LinkedList<Node>();
    	headChildren.add(title);
    	Head head = factory.makeHead();
    	head.set(noAttributes, headChildren);
    	
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	Map<String,String> bAtts = new HashMap<String,String>();
    	bAtts.put("id", "third");
    	bAtts.put("class", "foo");
    	B b = factory.makeB();
    	b.set(divAtts, div);
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(b);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	bodyAtts.put("class", "bar");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	List<Node> htmlChildren = new LinkedList<Node>();
    	htmlChildren.add(head);
    	htmlChildren.add(body);
    	
    	Map<String,String> htmlAtts = new HashMap<String,String>();
    	htmlAtts.put("id", "container");
    	HTML html = factory.makeHtml();
    	html.set(htmlAtts, htmlChildren);
    	
    	Map<String, String> searchOptions = 
    			new HashMap<String, String>();

		searchOptions.put("id", "fourth");
    	
    	AttributeSearchVisitor visitor = 
				new AttributeSearchVisitor(searchOptions);
		
    	html.accept(visitor);
    	
		assertFalse(visitor.getResult()
						  .iterator()
						  .hasAnotherElement());
    	
    }

}
