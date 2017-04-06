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
public class LoggingHTMLFactory 
	extends AbstractHTMLNodeFactory {
	
	@Override
	public B makeB() {
		B b = new B();
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	@Override
	public Body makeBody() {
		Body body = new Body();
		System.out.println(body.textualRepresentation());
		return body;
	}
	
	@Override
	public Div makeDiv() {
		Div div = new Div();
		System.out.println(div.textualRepresentation());
		return div;
	}
	
	@Override
	public Head makeHead() {
		Head head = new Head();
		System.out.println(head.textualRepresentation());
		return head;
	}
	
	@Override
	public HTML makeHtml() {
		HTML html = new HTML();
		System.out.println(html.textualRepresentation());
		return html;
	}
	
	@Override
	public Title makeTitle() {
		Title title = new Title();
		System.out.println(title.textualRepresentation());
		return title;
	}

}
