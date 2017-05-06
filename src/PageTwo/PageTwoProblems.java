/**
 * 
 */
package PageTwo;

/**
 * @author TriptiAshishUpadhyay
 * --*--*--*--*----*--*--*--*----*--*--*--*--
 * --*--*--*--*-- EASY PROBLEMS--*--*--*--*--
 * --*--*--*--*----*--*--*--*----*--*--*--*--
 */
public class PageTwoProblems {

	//100.
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(null == p && null == q) return true;
		if(null ==p || null == q) return false;
		if(p.val == q.val){
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}

	//88
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1, j=n-1;
		int index = nums1.length-1;
		while(i>=0 && j>=0){
			if(nums1[i] > nums2[j])
				nums1[index--] = nums1[i--];
			else if(nums1[i] < nums2[j])
				nums1[index--] = nums2[j--];
			else{
				nums1[index--] = nums1[i--];
				nums1[index--] = nums2[j--];
			}
		}
		while(j>=0){
			nums1[index--] = nums2[j--];
		}
	}

	//83
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while(null != current && null != current.next){
			if(current.val == current.next.val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return head;
	}

	//70
	public int climbStairs(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
	}

	public static void main(String[] args) {
		System.out.println("100------------");
		TreeNode p = new TreeNode(10);
		p.left = new TreeNode(8);
		p.right = new TreeNode(15);
		p.left.right = new TreeNode(9);
		p.right.left = new TreeNode(13);
		p.right.right = new TreeNode(20);
		TreeNode q = new TreeNode(10);
		q.left = new TreeNode(8);
		q.right = new TreeNode(15);
		q.left.right = new TreeNode(9);
		q.right.left = new TreeNode(13);
		q.right.right = new TreeNode(20);

		PageTwoProblems obj = new PageTwoProblems();

		System.out.println(obj.isSameTree(p, q));

		System.out.println("88------------");
		int[] nums1 = new int[13]; 
		nums1[0] = 0;
		nums1[1] = 4;
		nums1[2] = 5;
		nums1[3] = 7;
		nums1[4] = 7;
		nums1[5] = 9;
		int[] nums2 = {2,3,4,5,6,12,12};
		obj.merge(nums1, 0, nums2, 7);

		System.out.println("83------------");
		ListNode head = new ListNode(1);
		head.next = null;//new ListNode(1);
		//		head.next.next = new ListNode(2);
		//		head.next.next.next = new ListNode(2);
		//		head.next.next.next.next = new ListNode(2);
		//		head.next.next.next.next.next = new ListNode(2);
		//		head.next.next.next.next.next.next = null;
		System.out.println(obj.deleteDuplicates(head));
		
		System.out.println("70------------");
		System.out.println(obj.climbStairs(44));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}