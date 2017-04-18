/**
 * 
 */
package chapter3;

//-----------------------------------Problem 2.3----------------------------------------
public class StackWithMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		stack.push(5);
		stack.push(2);
		stack.pop();
		stack.push(6);
		
		stack.push(3);
		stack.push(8);
		stack.pop();
		stack.push(9);

		stack.displayData();

		System.out.println(stack.min());
		System.out.println(stack.min);
	}

}

class MyStack{
	int maxSize;
	int topStack;
	int topMin;
	int[] stack;
	int[] minStack;
	int min;

	public MyStack(int s){
		maxSize = s;
		stack = new int[maxSize];
		minStack = new int[maxSize];
		topStack = -1;
		topMin = -1;
	}

	public void push(int data){
		if(topMin == -1){ 
			minStack[++topMin] = data;
			min = data;
		}
		else{
			if(data < min){
				minStack[++topMin] = data;
				min = data;
			}
		}
		stack[++topStack] = data;
	}

	public int pop(){
		int item = stack[topStack];
		if(item == min) min = minStack[--topMin];
		return item;
	}

	public int peek(){
		return stack[topStack];
	}

	public boolean isEmpty(){
		return (topStack == -1);
	}

	public boolean isFull(){
		return (topStack == maxSize-1);
	}

	public void displayData(){
		int i = topStack;
		while(i != -1){
			System.out.println("location: " + i + ", data: "+ stack[i--]);
		}
	}

	//Problem 3.1---------------------------------------------------------------

	//Time complexity is O(n)
	public int min(){
		int i = topStack;
		int min = stack[topStack];
		while(i != -1){
			if(stack[i] < min) min = stack[i];
			i -= 1;
		}
		return min;
	}

	//Time complexity is O(1)
	public int findMin(){
		return minStack[topMin--];
	}
}
