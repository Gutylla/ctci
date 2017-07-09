/**
 * 
 */
package LeetCodeProblems;

import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		return 1;
	}
	
	public int histogram(int[] input){
		Stack<Integer> pos = new Stack<>();
		Stack<Integer> val = new Stack<>();

		int max = input[0];
		pos.push(0);
		val.push(input[0]);

		int i = 1; 
		int tempMax = 0;
		while(i<input.length && !val.isEmpty()){
			int num = input[i];
			if(num > val.peek()){
				pos.push(i);
				val.push(num);
			}
			else{
				while(!val.isEmpty()){
					tempMax = val.pop() * (i - pos.peek());
					if(max < tempMax)
						max = tempMax;
					if(!val.isEmpty()){
						if(num == val.peek()){
							pos.pop();
							break;
						}
						else if(num < val.peek()){
							pos.pop();
							continue;
						}
					}
					val.push(num);
					break;
				}

			}
			i++;
		}

		while(!val.isEmpty()){
			tempMax = val.pop() * (i - pos.pop());
			if(max < tempMax)
				max = tempMax;
		}

		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle obj = new MaximalRectangle();
		System.out.println(obj.histogram(new int[]{2,3,4,2}));
	}

}
