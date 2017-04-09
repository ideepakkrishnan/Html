/**
 * 
 */
package com.neu.html_visitor;

import com.neu.html.B;
import com.neu.html.Body;
import com.neu.html.Div;
import com.neu.html.HTML;
import com.neu.html.Head;
import com.neu.html.Node;
import com.neu.html.Title;

/**
 * @author ideepakkrishnan
 *
 */
public class NodeCountVisitor implements NodeVisitor {
	
	private int bCount;
	private int bodyCount;
	private int divCount;
	private int headCount;
	private int htmlCount;
	private int titleCount;
	
	/**
	 * @return the bCount
	 */
	public int getbCount() {
		return bCount;
	}	

	/**
	 * @return the bodyCount
	 */
	public int getBodyCount() {
		return bodyCount;
	}

	/**
	 * @return the divCount
	 */
	public int getDivCount() {
		return divCount;
	}

	/**
	 * @return the headCount
	 */
	public int getHeadCount() {
		return headCount;
	}

	/**
	 * @return the htmlCount
	 */
	public int getHtmlCount() {
		return htmlCount;
	}

	/**
	 * @return the titleCount
	 */
	public int getTitleCount() {
		return titleCount;
	}

	public NodeCountVisitor() {		
		bCount = 0;
		bodyCount = 0;
		divCount = 0;
		headCount = 0;
		htmlCount = 0;
		titleCount = 0;
	}
	
	private void count(Node n) {
		for (Node child : n.getChildren()) {
			if (child instanceof B) {
				visitB((B) child);
			} else if (child instanceof Body) {
				visitBody((Body) child);
			} else if (child instanceof Div) {
				visitDiv((Div) child);
			} else if (child instanceof Head) {
				visitHead((Head) child);
			} else if (child instanceof HTML) {
				visitHTML((HTML) child);
			} else if (child instanceof Title) {
				visitTitle((Title) child);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitHTML(com.neu.html.HTML)
	 */
	public void visitHTML(HTML h) {
		this.htmlCount++;
		count(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitHead(com.neu.html.Head)
	 */
	public void visitHead(Head h) {
		this.headCount++;
		count(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitBody(com.neu.html.Body)
	 */
	public void visitBody(Body b) {
		this.bodyCount++;
		count(b);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitTitle(com.neu.html.Title)
	 */
	public void visitTitle(Title t) {
		this.titleCount++;
		count(t);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitDiv(com.neu.html.Div)
	 */
	public void visitDiv(Div d) {
		this.divCount++;
		count(d);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitB(com.neu.html.B)
	 */
	public void visitB(B b) {
		this.bCount++;
		count(b);
	}
	
	public void report() {
		System.out.print("Instance counts: ");
		System.out.print("html - " + htmlCount + ", ");
		System.out.print("head - " + headCount + ", ");
		System.out.print("title - " + titleCount + ", ");
		System.out.print("body - " + bodyCount + ", ");
		System.out.print("b - " + bCount + ", ");
		System.out.print("div - " + divCount);
	}

}
