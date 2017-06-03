/**
 * 
 */
package educative;

import java.util.HashSet;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RemoveDuplicates {

	public LinkedListNode remove(LinkedListNode head){
		if(head == null || head.next == null)
			return head;
		HashSet<Integer> hash = new HashSet<>();
		LinkedListNode curr = head.next;
		LinkedListNode prev = head;
		hash.add(prev.data);
		while(curr != null){
			if(! hash.contains(curr.data)){
				hash.add(curr.data);
				prev = prev.next;
				curr = curr.next;
			}
			else{
				prev.next = curr.next;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		LinkedListNode list = new LinkedListNode(14);
		list.next = new LinkedListNode(14);
		list.next.next = new LinkedListNode(7);
		list.next.next.next = new LinkedListNode(7);
		list.next.next.next.next = null;
		LinkedListNode out = obj.remove(list);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}
}
