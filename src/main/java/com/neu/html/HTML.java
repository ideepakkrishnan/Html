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
public class HTML extends Node {
	
	public HTML() {
		super();
	}
	
	public HTML(Map<String, String> atts, String content) {
		// <html> is expected to have only Node
		// objects as children
	}
	
	public HTML(Map<String, String> atts, List<Node> children) {
		super(atts, children);
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<html");
		
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
			// <html> tag cannot have another <html>
			// tag as child
			if (!(n instanceof HTML)) {
				sb.append(n.textualRepresentation());
			}
		}
		sb.append("</html>");
		return sb.toString();
	}

}
