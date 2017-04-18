/**
 * 
 */
package chapter3;

import java.util.LinkedList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class QueueUsingLinkedList {

	LinkedList<Integer> l;
	
	public QueueUsingLinkedList(){
		l = new LinkedList<Integer>();
	}
	
	public void push(int data){
		l.add(data);
	}
	
	public int pop(){
		return l.removeFirst();
	}
	
	public int peek(){
		return l.getFirst();
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList obj = new QueueUsingLinkedList();
		obj.push(10);
		obj.push(29);
		obj.push(37);
		obj.push(45);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
	}

}
