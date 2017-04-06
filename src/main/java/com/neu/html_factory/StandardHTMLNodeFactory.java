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
public class StandardHTMLNodeFactory 
	extends AbstractHTMLNodeFactory {
	
	@Override
	public B makeB() {
		return new B();
	}
	
	@Override
	public Body makeBody() {
		return new Body();
	}
	
	@Override
	public Div makeDiv() {
		return new Div();
	}
	
	@Override
	public Head makeHead() {
		return new Head();
	}
	
	@Override
	public HTML makeHtml() {
		return new HTML();
	}
	
	@Override
	public Title makeTitle() {
		return new Title();
	}

}
