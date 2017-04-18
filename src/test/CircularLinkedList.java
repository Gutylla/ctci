/**
 * 
 */
package test;

/**
 * @author triptibishnoi
 *
 */
public class CircularLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularList cList = new CircularList();
		cList.append(1);
		cList.append(2);
		cList.append(3);
		cList.append(4);
		System.out.println("circular list>>");
		cList.displayData();


		SinglyList sList = new SinglyList();
		sList.addData(5);
		sList.addData(6);
		sList.addData(7);
		sList.addData(8);
		sList.addData(9);
		System.out.println("singly list>>");
		sList.displayData();

		sList = cList.mergeTwoLists(sList);
		//Problem 2.5
		System.out.println("---------2.5--------");
		cList.getFirstNodeOfLoop();

		System.out.println("---------ding ding");
		sList.getFirstNodeOfLoop();
	}
}

class Node{
	Node next;
	int data;

	public Node(int n){
		this.data = n;
	}
}

class CircularList{
	Node first;

	public void append(int n){
		Node current = new Node(n);
		if(null == first) {
			first = current;
			first.next = first;
		}
		else {
			Node last = first;
			while(last.next != first){
				last = last.next;
			}
			current.next = first;
			last.next = current;
		}
	}

	public void displayData(){
		Node current = first;
		do{
			System.out.println(current.data);
			current = current.next;
		}while(current != first);
	}

	//Problem 2.5
	public void getFirstNodeOfLoop(){
		Node keepTrack = first;
		Node keepMove;
		while(keepTrack != null){
			keepMove = keepTrack.next;
			while(keepMove != null){
				if(keepMove == keepTrack){
					System.out.println("starting node of loop: " + keepMove.data);
					return;
				}
				keepMove = keepMove.next;
			}
			keepTrack = keepTrack.next;
		}
	}

	public SinglyList mergeTwoLists(SinglyList sl){
		Node slLast = sl.first;
		while(slLast.next != null){
			slLast = slLast.next;
		}
		slLast.next = first;
		return sl;
	}
}

class SinglyList{
	Node first;

	public void addData(int n){
		Node curr = new Node(n);
		curr.next = first;
		first = curr;
	}

	public void displayData(){
		Node curr = first;
		while(curr != null){
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public void getFirstNodeOfLoop(){
		//get inside the loop
		Node fast = first.next;
		Node slow = first;
		while(slow != null && fast != null & fast.next != null){
			if(slow == fast){
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.data);
		//finding the start of loop
		Node keepTrack = first;
		Node keepMove;
		while(keepTrack != null){
			keepMove = slow;
			do{
				if(keepMove == keepTrack){
					System.out.println("starting node of loop: " + keepMove.data);
					return;
				}
				keepMove = keepMove.next;
			}while(keepMove != slow);
			keepTrack = keepTrack.next;
		}
	}
}