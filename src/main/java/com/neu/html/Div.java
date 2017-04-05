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
public class Div extends Node {
	
	public Div() {
		super();
	}
	
	public Div(Map<String, String> atts, String content) {
		super(atts, content);
	}
	
	public Div(Map<String, String> atts, List<Node> children) {
		// Do nothing since <div> doesn't allow Node
		// objects as children
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<div");
		SortedSet<String> attKeys = new TreeSet<String>();
		for (Map.Entry<String, String> entry : this.atts.entrySet()) {
			attKeys.add(entry.getKey());
		}
		
		for (String key : attKeys) {
			sb.append(" ");
			sb.append(key + "=" + this.atts.get(key));
		}
		sb.append(">" + this.content + "</div>");
		return sb.toString();
	}

}
