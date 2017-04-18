/**
 * 
 */
package chapter3;

import java.util.LinkedList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class StackUsingLinkedList {

	LinkedList<Integer> l;
	
	public StackUsingLinkedList(){
		l = new LinkedList<Integer>();
	}
	
	public void push(int data){
		l.add(data);
	}
	
	public int pop(){
		return l.removeLast();
	}
	
	public int peek(){
		return l.getLast();
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList obj = new StackUsingLinkedList();
		obj.push(10);
		obj.push(29);
		obj.push(37);
		obj.push(45);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
	}

}
