/**
 * 
 */
package com.neu.html;

import java.util.ArrayList;
import java.util.HashMap;
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
		this.content = new String();
		this.atts = new HashMap<String, String>();
		this.children = new ArrayList<Node>();
	}
	
	public Node(Map<String, String> atts, String content) {
		this.atts = atts;
		this.content = content;
	}
	
	public Node(Map<String, String> atts, List<Node> children) {
		this.atts = atts;
		this.children = children;
	}
	
	public abstract String textualRepresentation();

}
