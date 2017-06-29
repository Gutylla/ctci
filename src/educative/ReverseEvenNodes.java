/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ReverseEvenNodes {

	public LinkedListNode reverseEven(LinkedListNode head){
		LinkedListNode curr = head;
		LinkedListNode even = head.next;
		LinkedListNode temp = null;
		while(curr != null){
			curr.next = even.next;
			even.next = temp;
			temp = even;
			curr = curr.next;
			if(curr != null)
				even = curr.next;
		}
		LinkedListNode odd = head;
		even = temp;
		while(even != null && odd != null){
			LinkedListNode nEven = even.next;
			LinkedListNode nOdd = odd.next;
			even.next = odd.next;
			odd.next = even;
			even = nEven;
			odd = nOdd;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseEvenNodes obj = new ReverseEvenNodes();

		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		head.next.next.next.next.next = new LinkedListNode(6);
		head.next.next.next.next.next.next = null;

		LinkedListNode out = obj.reverseEven(head);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}
