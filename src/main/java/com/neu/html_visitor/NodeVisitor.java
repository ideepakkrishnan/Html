/**
 * 
 */
package com.neu.html_visitor;

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
public interface NodeVisitor {
	
	void visitHTML(HTML h);
	void visitHead(Head h);
	void visitBody(Body b);
	void visitTitle(Title t);
	void visitDiv(Div d);
	void visitB(B b);

}
