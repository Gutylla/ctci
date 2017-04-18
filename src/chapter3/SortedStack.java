/**
 * 
 */
package chapter3;

import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SortedStack {

	Stack<Integer> s;

	public SortedStack(){
		s = new Stack<Integer>();
	}

	public Stack<Integer> sort(){
		Stack<Integer> temp = new Stack<Integer>();
		while(!s.isEmpty()) {
			int min = s.pop();
			while(!temp.empty() && temp.peek() > min){
				s.push(temp.pop());
			}
			temp.push(min);
		}
		return temp;
	}

	public static void main(String[] args) {
		SortedStack obj = new SortedStack();
		int[] a = {10, 29, 38, 47,56,19,27};
		for(int i =0; i<a.length; i++)
			obj.s.push(a[i]);

		Stack<Integer> output = obj.sort();

		for(int i =0; i<a.length; i++)
			System.out.println(output.pop());
	}

}
