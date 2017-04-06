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
	
	public void set(Map<String, String> atts, List<Node> children) {
		this.setAtts(atts);
		this.setChildren(children);
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<html");
		
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
			// <html> tag cannot have another <html>
			// tag as child
			if (n instanceof Head || n instanceof Body) {
				sb.append(n.textualRepresentation());
			}
		}
		sb.append("</html>");
		return sb.toString();
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visitHTML(this);
	}

}
