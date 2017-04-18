/**
 * 
 */
package chapter3;

import java.util.Stack;

/**
 * @author triptibishnoi
 *
 */
public class TowerOfHanoi {

	Stack<Integer> a;
	Stack<Integer> b;
	Stack<Integer> c;

	public TowerOfHanoi(){
		a = new Stack<Integer>();
		b = new Stack<Integer>();
		c = new Stack<Integer>();
	}

	public void push(int data, Stack<Integer> name){
		name.push(data);
	}

	public int pop(Stack<Integer> name){
		return (int) name.pop();
	}

	public void TOH(int size, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C){
		if(size>0){
			TOH(size-1, A, C, B);
			push((int) A.pop(), C);
			TOH(size-1, B, A, C);
		}
	}

	public static void main(String[] args) {
		TowerOfHanoi tower = new TowerOfHanoi();

		int[] input = {99,85,73,62,32,22,11,9,1};

		for(int i=0; i<input.length; i++)
			tower.push(input[i], tower.a);

		tower.TOH(input.length, tower.a, tower.b, tower.c);
		
		for(int i=0; i<input.length; i++)
			System.out.println(tower.pop(tower.c));
	}

}
