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
public class Title extends Node {
	
	public Title() {
		super();
	}
	
	public Title(Map<String, String> atts, String content) {
		super(atts, content);
	}
	
	public Title(Map<String, String> atts, List<Node> children) {
		// Do nothing since <title> does not allow 
		// Node objects as children
	}
	
	public void set(Map<String, String> atts, String content) {
		this.setAtts(atts);
		this.setContent(content);
	}
	
	@Override
	public String textualRepresentation() {
		StringBuilder sb = new StringBuilder("<title");
		SortedSet<String> attKeys = new TreeSet<String>();
		for (Map.Entry<String, String> entry : this.getAtts().entrySet()) {
			attKeys.add(entry.getKey());
		}
		
		for (String key : attKeys) {
			sb.append(" ");
			sb.append(key + "=" + this.getAtts().get(key));
		}
		sb.append(">");
		
		sb.append(this.getContent());
		sb.append("</title>");
		return sb.toString();
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visitTitle(this);
	}

}
