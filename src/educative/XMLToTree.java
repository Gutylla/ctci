/**
 * 
 */
package educative;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class XMLToTree {

	public TreeNode method(String xml) throws XMLStreamException{
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(is);
		Stack<TreeNode> stack = new Stack<>();

		int eventType = reader.next();
		TreeNode out = null;
		if(eventType == XMLStreamReader.START_ELEMENT){
			stack.push(new TreeNode(reader.getText()));
			out = stack.peek();
		}

		while(reader.hasNext()){
			eventType = reader.next();
			switch(eventType){
			case XMLStreamReader.START_ELEMENT:
				stack.push(new TreeNode(reader.getText()));
				out.child = stack.peek();
				out = out.child;
				break;
			case XMLStreamReader.END_ELEMENT:
				stack.peek();
			}
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	TreeNode child;
	String data;

	/**
	 * 
	 */
	public TreeNode(String data) {
		// TODO Auto-generated constructor stub
		child = null;
		this.data = data;
	}
}