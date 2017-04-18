/**
 * 
 */
package chapter3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MyStackUsingsQueues {

	Queue<Integer> q1;
	Queue<Integer> q2;
	
	public MyStackUsingsQueues(){
		q1 = new ArrayDeque<Integer>();
		q2 = new ArrayDeque<Integer>();
	}
	
	public void push(int data){
		q1.add(data);
	}
	
	public Integer pop(){
		int output = 0;
		//1. get the data from q1 to q2, except last record
		while(q1.size() > 1) {
			q2.add(q1.remove());
		}
		//2. store the last record
		output = q1.remove();
		//3. swap the queues q1 and q2
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		//return the saved record
		return output;
	}
	
	public static void main(String[] args) {
		MyStackUsingsQueues obj = new MyStackUsingsQueues();
		obj.push(2);
		obj.push(5);
		obj.push(10);
		System.out.println(obj.pop());
	}

}
