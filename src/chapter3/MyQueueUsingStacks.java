/**
 * 
 */
package chapter3;

import java.util.Stack;

/**
 * @author Tripti Ashiish Upadhyay
 *
 */
public class MyQueueUsingStacks {

	Stack<Integer> s1;
	Stack<Integer> s2;

	public MyQueueUsingStacks(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public void push(int item){
		s1.push(item);
	}

	public int pop(){
		if(!s2.empty()) return s2.pop();
		else{
			while(!s1.empty()) s2.push(s1.pop());
			return s2.pop();
		}
	}

	public int peek(){
		if(!s2.empty()) return s2.peek();
		else{
			while(!s1.empty()) s2.push(s1.pop());
			return s2.peek();
		}
	}

	public static void main(String[] args) {
		MyQueueUsingStacks obj = new MyQueueUsingStacks();

		int[] a = {10, 29, 38, 47,56,19,27,40,58,37, 23,45,27,46,35,12};
		for(int i =0; i<a.length; i++)
			obj.push(a[i]);

		System.out.println("----------------------");

		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.peek());
	}

}
