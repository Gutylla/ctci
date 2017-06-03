/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ReverseLinkedList {

	public LinkedListNode rverese(LinkedListNode head){
		if(null == head || head.next == null) return head;
		LinkedListNode curr = head.next;
		LinkedListNode out = head;
		out.next = null;
		while(null != curr){
			LinkedListNode temp = curr;
			curr = curr.next;
			temp.next = out;
			out = temp;
		}
		return out;
	}

	public LinkedListNode recurRev(LinkedListNode head){
		if(head == null || head.next == null)
			return head;
		LinkedListNode rev = recurRev(head.next);
		head.next.next = head;
		return rev;
	}

	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		LinkedListNode list = new LinkedListNode(7);
		list.next = new LinkedListNode(14);
		list.next.next = new LinkedListNode(28);
		list.next.next.next = new LinkedListNode(80);
		list.next.next.next.next = null;
		LinkedListNode out = obj.rverese(list);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}

class LinkedListNode{
	int data;
	LinkedListNode next;

	public LinkedListNode(int data){
		this.data = data;
		this.next = null;
	}
}
