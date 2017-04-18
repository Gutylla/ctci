/**
 * 
 */
package chapter3;

/**
 * @author triptibishnoi
 *
 */
public class Stacktest<T> {
	
	public static class Node{
		private int data;
		private Node prev;
		private Node(int data){
			this.data = data;
		}
	}

	public static Node top;
	public static void push(int n){
		Node node = new Node(n);
			node.prev = top;
			top = node;
	}
	
	public static int pop(){
		int data = top.data;
		top = top.prev;
		return data;
	}
	
	public static boolean isEmpty(){
		return top == null;
	}
	
	public static int peek(){
		return top.data;
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(peek());
	}

}
