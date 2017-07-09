/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LearningHeap {

	public void maxInSlidingWindow(int[] input, int window){
		Heap heap = new Heap(window);
		if(input.length < window) return;
		for(int i=0; i<window; i++){
			heap.insert(input[i]);
		}
		System.out.println(heap.remove().data);
		for(int i=window; i< input.length; i++){
			heap.insert(input[i]);
			System.out.println(heap.remove().data);
		}
	}

	public static void main(String[] args) {
//		Heap myheap = new Heap(10);
//		int[] a = {30,60,29,50,68,79};
//		for(int i=0; i<a.length; i++)
//		myheap.insert(a[i]);
//		for(int i =0; i<6; i++){
//			System.out.println(myheap.remove().data);
//		}
		int[] input = {1,3,-1,-3,5,3,6,7};
		int window = 3;
		LearningHeap obj = new LearningHeap();
		obj.maxInSlidingWindow(input, window);
	}

}

class Heap{
	Node[] heapArray;
	int size;
	int index;

	public Heap(int n){
		heapArray = new Node[n];
		size = n;
		index = 0;
	}

	public boolean insert(int key){
		if(index > size) return false;
		Node nd = new Node(key);
		heapArray[index] = nd;
		trickleUp(index++);
		return true;
	}

	public Node remove(){
		Node root = heapArray[0];
		heapArray[0] = heapArray[--index];
		trickleDown(0);
		return root;
	}

	private void trickleUp(int i){
		int iParent = (i-1)/2;
		Node bottom = heapArray[i];
		while(i>0 && bottom.data > heapArray[iParent].data){
			heapArray[i] = heapArray[iParent];
			i = iParent;
			iParent = (i-1)/2;
		}
		heapArray[i] = bottom;
	}

	private void trickleDown(int i){
		int largerChild;
		Node old = heapArray[i];
		while(i < size/2){ // while node has atleast one child
			int iLeft = 2*i + 1;
			int iRight = 2*i + 2;
			if(iRight < size && heapArray[iRight].data > heapArray[iLeft].data)
				largerChild = iRight;
			else
				largerChild = iLeft;
			if(heapArray[i].data >= heapArray[largerChild].data)
				break;
			heapArray[i] = heapArray[largerChild];
			i = largerChild;
		}
		heapArray[i] = old;
	}
}

class Node{
	int data;

	public Node(int n){
		data = n;
	}
}