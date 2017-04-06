/**
 * 
 */
package com.neu.html_factory;

import com.neu.html.B;
import com.neu.html.Body;
import com.neu.html.Div;
import com.neu.html.HTML;
import com.neu.html.Head;
import com.neu.html.Title;

/**
 * @author ideepakkrishnan
 *
 */
public abstract class AbstractHTMLNodeFactory {
	
	public abstract B makeB();
	
	public abstract Body makeBody();
	
	public abstract Div makeDiv();
	
	public abstract Head makeHead();
	
	public abstract HTML makeHtml();
	
	public abstract Title makeTitle();

}
