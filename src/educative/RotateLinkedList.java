/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class RotateLinkedList {
	
	public LinkedListNode rotate(LinkedListNode head, int n){
		LinkedListNode nextLast = nthLastNode(head, n+1);
		LinkedListNode temp = nthLastNode(head, n);
		LinkedListNode nextHead = temp;
		while(temp.next != null)
			temp = temp.next;
		temp.next = head;
		head = nextHead;
		nextLast.next = null;
		return head;
	}
	
	public LinkedListNode nthLastNode(LinkedListNode head, int n){
		if(head == null || n<1) return null;
		
		LinkedListNode node = head;
		while(n>0 && node!= null){
			node = node.next;
			n--;
		}
		
		if(n!=0) return null;
		
		while(node!=null){
			head = head.next;
			node = node.next;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateLinkedList obj = new RotateLinkedList();

		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		head.next.next.next.next.next = new LinkedListNode(6);
		head.next.next.next.next.next.next = null;

		LinkedListNode out = obj.rotate(head, 4);

		while(out != null){
			System.out.println(out.data);
			out = out.next;
		}
	}

}
