/**
 * 
 */
package chapter3;

/**
 * @author triptibishnoi
 *
 */
public class LearningQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue q = new MyQueue(5);
		q.insert(5);
		q.insert(4);
		q.insert(3);
		q.insert(2);
		q.insert(1);
		
		q.remove();
		q.remove();
	}

}

class MyQueue{
	int front;
	int rear = 0;
	int maxSize;
	int[] queueArray;
	
	public MyQueue(int s){
		maxSize = s;
		queueArray = new int[s];
		front = -1;
		rear = 0;
	}
	
	public void insert(int data){
		queueArray[++front] = data;
	}
	
	public int remove(){
		return queueArray[rear++];
	}
	
	public boolean isEmpty(){
		return front < rear;
	}
	
	public boolean isFull(){
		return (rear == 0 && front == maxSize);
	}
}