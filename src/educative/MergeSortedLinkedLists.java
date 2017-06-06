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
		LinkedListNode mergedHead = null;
		while(head1 != null && head2 != null){
			if(head1.data <= head2.data){
				mergedHead = head1;
				head1 = head1.next;
			}
			else{
				mergedHead = head2;
				head2 = head2.next;
			}
			mergedHead = mergedHead.next;
		}
		LinkedListNode mergedTail = mergedHead;
		return mergedHead;
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
