/**
 * 
 */
package LeetCodeProblems;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class ReorderList {
	
	public ListNode reorder(ListNode head){
		int k = 3;
		
		ListNode h1 = head;
		
		ListNode h2 = head;
		for(int i=0; i<k; i++)
			h2 = h2.next;
		h2 = helper(h2, k);
		
		while(k > 1){
			ListNode nexth1 = h1.next;
			ListNode nexth2 = h2.next;
			h2.next = h1.next;
			h1.next = h2;
			h1 = nexth1;
			h2 = nexth2;
			k--;
		}
		
		return head;
	}

	public ListNode helper(ListNode h2, int k) {
		ListNode prev = null;
		while(k > 0){
			ListNode nextHead = h2.next;
			h2.next = prev;
			prev = h2;
			h2 = nextHead;
			k--;
		}
		return prev;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReorderList obj = new ReorderList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = null;

		ListNode out = obj.reorder(head);

		while(out != null){
			System.out.println(out.val);
			out = out.next;
		}
	}

}
