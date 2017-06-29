/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class AddTwoLinkedLists {

	public LinkedListNode add(LinkedListNode h1, LinkedListNode h2){
		LinkedListNode head = null;
		LinkedListNode tail = null;

		int carry = 0;

		while(h1 != null || h2 != null || carry > 0){
			int sum = (h1 != null ? h1.data : 0) + (h2 != null ? h2.data : 0) + carry;
			int mod = sum % 10;
			carry = sum / 10;

			LinkedListNode temp = new LinkedListNode(mod);
			if(head == null)
				head = temp;
			else
				tail.next = temp;
			
			tail = temp;
			
			if(h1 != null)
				h1 = h1.next;
			if(h2 != null)
				h2 = h2.next;
		} 

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoLinkedLists obj = new AddTwoLinkedLists();

		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(0);
		head.next.next = new LinkedListNode(9);
		head.next.next.next = new LinkedListNode(9);
		head.next.next.next.next = null;

		LinkedListNode head2 = new LinkedListNode(8);
		head2.next = new LinkedListNode(3);
		head2.next.next = new LinkedListNode(2);
		head2.next.next.next = null;

		LinkedListNode out = obj.add(head, head2);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}
