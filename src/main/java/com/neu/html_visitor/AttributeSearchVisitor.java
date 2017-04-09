/**
 * 
 */
package com.neu.html_visitor;

import java.util.Map;

import com.neu.adapter.StringSet;
import com.neu.html.B;
import com.neu.html.Body;
import com.neu.html.Div;
import com.neu.html.HTML;
import com.neu.html.Head;
import com.neu.html.Node;
import com.neu.html.Title;
import com.neu.iterators.Iterator;

/**
 * @author ideepakkrishnan
 *
 */
public class AttributeSearchVisitor implements NodeVisitor {
	
	private StringSet result;
	private Map<String, String> searchOptions;
	
	/**
	 * @return the result
	 */
	public StringSet getResult() {
		return result;
	}
	
	public AttributeSearchVisitor(
			Map<String, String> searchOptions) {
		this.result = new StringSet(50);
		this.searchOptions = searchOptions;
	}
	
	private void findAttributes(Node n) {
		// Get hold of the attributes for this node
		Map<String, String> atts = n.getAtts();
		
		for (Map.Entry<String, String> entry 
				: searchOptions.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			for (Map.Entry<String, String> att 
					: atts.entrySet()) {
				String attKey = att.getKey();
				String attVal = att.getValue();
				
				if (key.equals(attKey) &&
						value.equals(attVal)) {
					result.add(n.textualRepresentation());
				}
			}
		}
		
		// Go down into the children and search for
		// the specified filters
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
		findAttributes(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitHead(com.neu.html.Head)
	 */
	public void visitHead(Head h) {
		findAttributes(h);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitBody(com.neu.html.Body)
	 */
	public void visitBody(Body b) {
		findAttributes(b);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitTitle(com.neu.html.Title)
	 */
	public void visitTitle(Title t) {
		findAttributes(t);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitDiv(com.neu.html.Div)
	 */
	public void visitDiv(Div d) {
		findAttributes(d);
	}

	/* (non-Javadoc)
	 * @see com.neu.html_visitor.NodeVisitor#visitB(com.neu.html.B)
	 */
	public void visitB(B b) {
		findAttributes(b);
	}
	
	public void report() {
		System.out.print("Search Results:");
		
		Iterator<String> resultIterator = result.iterator();
		while(resultIterator.hasAnotherElement()) {
			System.out.println(resultIterator.nextElement());
		}
	}

}
