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
import com.neu.html_visitor.NodeCountVisitor;

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
    	visitor.visitB(b);
    	
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
    	
    	List<Node> children = new LinkedList<Node>();
    	children.add(div);
    	
    	Map<String,String> bodyAtts = new HashMap<String,String>();
    	bodyAtts.put("id", "content");
    	Body body = factory.makeBody();
    	body.set(bodyAtts, children);
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	visitor.visitBody(body);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 1);
    	assertEquals(visitor.getTitleCount(), 0);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 1);
    }
    
    public void testDivWithContent() {
    	Map<String,String> divAtts = new HashMap<String,String>();
    	divAtts.put("id", "second");
    	divAtts.put("class", "bar");
    	Div div = factory.makeDiv();
    	div.set(divAtts, "b");
    	
    	NodeCountVisitor visitor = new NodeCountVisitor();
    	visitor.visitDiv(div);
    	
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
    	visitor.visitHead(head);
    	
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
    	visitor.visitHTML(html);
    	
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
    	visitor.visitTitle(title);
    	
    	assertEquals(visitor.getHtmlCount(), 0);
    	assertEquals(visitor.getHeadCount(), 0);
    	assertEquals(visitor.getBodyCount(), 0);
    	assertEquals(visitor.getTitleCount(), 1);
    	assertEquals(visitor.getbCount(), 0);
    	assertEquals(visitor.getDivCount(), 0);
    }

}
