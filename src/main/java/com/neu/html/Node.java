/**
 * 
 */
package com.neu.html;

import java.util.List;
import java.util.Map;

/**
 * @author ideepakkrishnan
 *
 */
public abstract class Node {
	
	String content;
	Map<String, String> atts;
	List<Node> children;
	
	public Node() {
		// Do nothing
	}
	
	public Node(Map<String, String> atts, String content) {
		this.atts = atts;
		this.content = content;
	}
	
	public Node(Map<String, String> atts, List<Node> children) {
		this.atts = atts;
		this.children = children;
	}
	
	public String textualRepresentation() {
		return content;
	}

}
