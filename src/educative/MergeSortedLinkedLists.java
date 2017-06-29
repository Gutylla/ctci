/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MergeSortedLinkedLists {

	public LinkedListNode performMerge(LinkedListNode head1, LinkedListNode head2){
		LinkedListNode head = null;
		LinkedListNode tail = null;

		while(head1 != null || head2 != null){
			int val1 = (head1 != null ? head1.data : Integer.MAX_VALUE);
			int val2 = (head2 != null ? head2.data : Integer.MAX_VALUE);

			LinkedListNode temp = null;
			if(val1 < val2){
				temp = new LinkedListNode(val1);
				if(head1 != null)
					head1 = head1.next;
			}
			else{
				temp = new LinkedListNode(val2);
				if(head2 != null)
					head2 = head2.next;
			}

			if(head == null)
				head = temp;
			else
				tail.next = temp;
			tail = temp;
		}

		return head;


		//		if(head1 == null && head2 == null) return null;
		//		if(head1 == null) return head2;
		//		if(head2 == null) return head1;
		//		
		//		LinkedListNode mergedHead = null;
		//		if(head1.data <= head2.data){
		//			mergedHead = head1;
		//			head1 = head1.next;
		//		}
		//		else{
		//			mergedHead = head2;
		//			head2 = head2.next;
		//		}
		//		
		//		LinkedListNode mergedTail = mergedHead;
		//		while(head1 != null && head2 != null){
		//			LinkedListNode temp = null;
		//			if(head1.data <= head2.data){
		//				temp = head1;
		//				head1 = head1.next;
		//			}
		//			else{
		//				temp = head2;
		//				head2 = head2.next;
		//			}
		//			mergedTail.next = temp;
		//			mergedTail = mergedTail.next;
		//		}
		//		
		//		return mergedHead;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSortedLinkedLists obj = new MergeSortedLinkedLists();
		LinkedListNode list = new LinkedListNode(7);
		list.next = new LinkedListNode(14);
		list.next.next = new LinkedListNode(28);
		list.next.next.next = new LinkedListNode(80);
		list.next.next.next.next = null;

		LinkedListNode list2 = new LinkedListNode(5);
		list2.next = new LinkedListNode(15);
		list2.next.next = new LinkedListNode(30);
		list2.next.next.next = new LinkedListNode(82);
		list2.next.next.next.next = null;
		LinkedListNode out = obj.performMerge(list, list2);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}
