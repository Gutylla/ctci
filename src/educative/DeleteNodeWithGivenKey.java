/**
 * 
 */
package educative;


/**
 * @author TriptiAshishUpadhyay
 *
 */
public class DeleteNodeWithGivenKey {
	
	public LinkedListNode delete(LinkedListNode head, int key){
		LinkedListNode curr = head;
		LinkedListNode prev = head;
		while(curr != null){
			if(curr.data == key)
				prev.next = curr.next;
			else
				prev = curr;
			curr = curr.next;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteNodeWithGivenKey obj = new DeleteNodeWithGivenKey();

		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		head.next.next.next.next.next = new LinkedListNode(6);
		head.next.next.next.next.next.next = null;

		LinkedListNode out = obj.delete(head, 3);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}
