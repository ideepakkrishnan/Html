/**
 * 
 */
package com.neu.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.neu.html_visitor.NodeVisitor;

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
		super();
	}
	
	public B(Map<String, String> atts, Node child) {
		set(atts, child);
	}
	
	public B(Map<String, String> atts, List<Node> child) {
		super();
	}
	
	public void set(Map<String, String> atts, Node child) {
		List<Node> children = new ArrayList<Node>();
		children.add(child);
		
		this.setAtts(atts);
		this.setChildren(children);
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<b");
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
			// There is no point of <b> tag inside
			// another <b> tag
			if (!(n instanceof B)) {
				sb.append(n.textualRepresentation());
			}
		}
		sb.append("</b>");
		return sb.toString();
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visitB(this);
	}

}
