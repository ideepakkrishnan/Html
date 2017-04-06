/**
 * 
 */
package com.neu.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neu.html_visitor.NodeVisitor;

/**
 * @author ideepakkrishnan
 *
 */
public abstract class Node {
	
	private String content;
	private Map<String, String> atts;
	private List<Node> children;
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the atts
	 */
	public Map<String, String> getAtts() {
		return atts;
	}

	/**
	 * @param atts the atts to set
	 */
	public void setAtts(Map<String, String> atts) {
		this.atts = atts;
	}

	/**
	 * @return the children
	 */
	public List<Node> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Node> children) {
		this.children = children;
	}

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
	
	public abstract void accept(NodeVisitor v);

}
