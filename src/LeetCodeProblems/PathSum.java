/**
 * 
 */
package LeetCodeProblems;

import java.util.Stack;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class PathSum {

	Stack<Stack<Integer>> stack;

	public boolean hasPathSum(TreeNode root, int sum) {
		stack = new Stack<Stack<Integer>>();
		getPath(root, sum, new Stack<Integer>());
		return true;
	}

	private void getPath(TreeNode root, int sum, Stack<Integer> array) {
		array.add(root.val);

		if((root.left == null) && (root.right == null)) {
			Stack<Integer> arr = array;
			stack.add(arr);
		} else {
			if(root.left != null)
				getPath(root.left, sum, array);
			if(root.right != null)
				getPath(root.right, sum, array);
		}
		array.pop();
	}


	public static void main(String[] args) {
		PathSum obj = new PathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		obj.hasPathSum(root, 22);
		System.out.println("done");
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
