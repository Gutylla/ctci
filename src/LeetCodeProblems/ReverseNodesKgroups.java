/**
 * 
 */
package LeetCodeProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ReverseNodesKgroups {

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)
			return head;
		ListNode out = head;
		ListNode curr = head;
		ListNode prev = null;
		int counter = k;
		while(counter > 0){
			ListNode nextHead = head.next;
			head.next = prev;
			prev = head;
			head = nextHead;
			counter--;
		}
		curr.next = reverseKGroup(head, k);
		out = prev;
		return out;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseNodesKgroups obj = new ReverseNodesKgroups();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = null;

		ListNode out = obj.reverseKGroup(head, 3);

		while(out != null){
			System.out.println(out.val);
			out = out.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
