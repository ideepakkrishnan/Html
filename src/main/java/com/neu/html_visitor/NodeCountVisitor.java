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
	 * @param bCount the bCount to set
	 */
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	/**
	 * @return the bodyCount
	 */
	public int getBodyCount() {
		return bodyCount;
	}

	/**
	 * @param bodyCount the bodyCount to set
	 */
	public void setBodyCount(int bodyCount) {
		this.bodyCount = bodyCount;
	}

	/**
	 * @return the divCount
	 */
	public int getDivCount() {
		return divCount;
	}

	/**
	 * @param divCount the divCount to set
	 */
	public void setDivCount(int divCount) {
		this.divCount = divCount;
	}

	/**
	 * @return the headCount
	 */
	public int getHeadCount() {
		return headCount;
	}

	/**
	 * @param headCount the headCount to set
	 */
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	/**
	 * @return the htmlCount
	 */
	public int getHtmlCount() {
		return htmlCount;
	}

	/**
	 * @param htmlCount the htmlCount to set
	 */
	public void setHtmlCount(int htmlCount) {
		this.htmlCount = htmlCount;
	}

	/**
	 * @return the titleCount
	 */
	public int getTitleCount() {
		return titleCount;
	}

	/**
	 * @param titleCount the titleCount to set
	 */
	public void setTitleCount(int titleCount) {
		this.titleCount = titleCount;
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
		if (n instanceof B) {
			bCount++;
		} else if (n instanceof Body) {
			bodyCount++;
		} else if (n instanceof Div) {
			divCount++;
		} else if (n instanceof Head) {
			headCount++;
		} else if (n instanceof HTML) {
			htmlCount++;
		} else if (n instanceof Title) {
			titleCount++;
		}
		
		for (Node child : n.getChildren()) {
			count(child);
		}
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitHTML(com.neu.html.HTML)
	 */
	public void visitHTML(HTML h) {
		count(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitHead(com.neu.html.Head)
	 */
	public void visitHead(Head h) {
		count(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitBody(com.neu.html.Body)
	 */
	public void visitBody(Body b) {
		count(b);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitTitle(com.neu.html.Title)
	 */
	public void visitTitle(Title t) {
		count(t);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitDiv(com.neu.html.Div)
	 */
	public void visitDiv(Div d) {
		count(d);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitB(com.neu.html.B)
	 */
	public void visitB(B b) {
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
