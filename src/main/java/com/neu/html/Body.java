/**
 * 
 */
package com.neu.html;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author ideepakkrishnan
 *
 */
public class Body extends Node {
	
	public Body() {
		super();
	}
	
	public Body(Map<String, String> atts, String content) {
		// Do nothing since only Node objects are considered
		// to be valid children for Body
		super();
	}
	
	public Body(Map<String, String> atts, List<Node> children) {
		super(atts, children);
	}
	
	public void set(Map<String, String> atts, List<Node> children) {
		this.atts = atts;
		this.children = children;
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<body");
		SortedSet<String> attKeys = new TreeSet<String>();
		for (Map.Entry<String, String> entry : this.atts.entrySet()) {
			attKeys.add(entry.getKey());
		}
		
		for (String key : attKeys) {
			sb.append(" ");
			sb.append(key + "=" + this.atts.get(key));
		}
		sb.append(">");
		
		for (Node n : children) {
			sb.append(n.textualRepresentation());
		}
		sb.append("</body>");
		return sb.toString();
	}

}
