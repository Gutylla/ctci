/**
 * 
 */
package educative;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LevelOrderTraversal {

	public void levelOrder(TreeNode root){
		Queue<TreeNode> curr = new ArrayDeque<TreeNode>();
		Queue<TreeNode> next = new ArrayDeque<TreeNode>();

		while(!curr.isEmpty() || root!=null){
			if(root != null){
				curr.add(root);
				if(root.leftchild != null)
					next.add(root.leftchild);
				if(root.rightchild != null)
					next.add(root.rightchild);
				continue;
			}
			while(!curr.isEmpty())
				System.out.println(curr.poll());
			curr = next;
			next.clear();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
