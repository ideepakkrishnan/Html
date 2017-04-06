/**
 * 
 */
package com.neu.html;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.neu.html_visitor.NodeVisitor;

/**
 * @author ideepakkrishnan
 *
 */
public class Head extends Node {
	
	public Head() {
		super();
	}
	
	public Head(Map<String, String> atts, String content) {
		// Do Nothing since <head> does not allow any contents
		super();
	}
	
	public Head(Map<String, String> atts, List<Node> children) {
		super(atts, children);
	}
	
	public void set(Map<String, String> atts, List<Node> children) {
		this.setAtts(atts);
		this.setChildren(children);
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<head");
		SortedSet<String> attKeys = new TreeSet<String>();
		for (Map.Entry<String, String> entry : this.getAtts().entrySet()) {
			attKeys.add(entry.getKey());
		}
		
		for (String key : attKeys) {
			sb.append(" ");
			sb.append(key + "=" + this.getAtts().get(key));
		}
		sb.append(">");
		
		for (Node n : getChildren()) {
			if (n instanceof Title) {
				sb.append(n.textualRepresentation());
			}
		}
		sb.append("</head>");
		return sb.toString();
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visitHead(this);
	}

}
