/**
 * 
 */
package educative;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class NthFromLastNode {
	
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

	}

}
