/**
 * 
 */
package chapter3;

import java.util.ArrayList;
import java.util.Stack;


/**
 * @author TriptiAshishUpadhyay #TAU
 *
 */
public class LearningStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackOfPlates meraKitchen = new StackOfPlates();
		int[] elements = { 23, 12, 44, 54, 12, 44, 90, 45, 89, 36, 40, 92, 73, 85, 19, 28, 37, 46 };
		for(int i = 0; i < elements.length; i++){
			meraKitchen.push(elements[i]);
		}
		
		System.out.println(meraKitchen.pop(0));
	}
}

class StackOfPlates {
	ArrayList<Stack> sets;
	int current_top;
	int capacity;
	Stack<Integer> stack;

	public StackOfPlates() {
		sets = new ArrayList<Stack>();
		current_top = 0;
		capacity = 5;
	}

	public void push(int item) {
		if((current_top == capacity) || (current_top == 0)){
			stack = new Stack<Integer>();
			current_top = 0;
			sets.add(stack);
		}
		current_top++;
		stack.push(item);
	}

	public int pop() {
		if(current_top == 0){
			current_top = capacity;
		} else {
			current_top--;
		}
		Stack<Integer> stack = sets.get(sets.size() - 1);
		if(stack.size() > 0){
			return (int) stack.pop();
		} else {
			if(sets.size()-1 > 0){
				sets.remove(sets.size() - 1);
				return (int) sets.get(sets.size() - 1).pop();
			} else
				return 0;

		}
	}

	public int pop(int index){
		Stack<Integer> stack = sets.get(index);
		Stack<Integer> temp = new Stack<Integer>();
		int item = (int) stack.pop();
		int top = stack.size();
		if(current_top == capacity || current_top ==0){
			index = index + 1;
		}
		if(stack.size() > 0){
			 item = (int) stack.pop();
		}
		temp.push(pop(index));
		return item;
	}
}

