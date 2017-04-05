/**
 * 
 */
package com.neu.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author ideepakkrishnan
 *
 */
public class B extends Node {
	
	public B() {
		super();
	}
	
	public B(Map<String, String> atts, String content) {
		// Do nothing since <b> is expected to have
		// Node objects as children
	}
	
	public B(Map<String, String> atts, Node child) {
		List<Node> children = new ArrayList<Node>();
		children.add(child);
		
		this.atts = atts;
		this.children = children;
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<b");
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
			// There is no point of <b> tag inside
			// another <b> tag
			if (!(n instanceof B)) {
				sb.append(n.textualRepresentation());
			}
		}
		sb.append("</b>");
		return sb.toString();
	}

}
