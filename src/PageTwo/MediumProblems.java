/**
 * 
 */
package PageTwo;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class MediumProblems {

	//98
	int[] a = new int[10];
	int index = 0;
	public boolean isValidBST(TreeNode root) {
		boolean flag = true;
		if(root == null) return (flag && true);
		if(null != root.left){
			if(root.val > root.left.val)
				flag = flag && isValidBST(root.left);
			else
				flag = false;
		}
		if(null != root.right){
			if(root.val < root.right.val)
				flag = flag && isValidBST(root.right);
			else
				flag = false;
		}
		return flag;
	}

	public static void main(String[] args) {
		MediumProblems obj = new MediumProblems();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
//		input [10,5,15,null,null,6,20] failed
		System.out.println(obj.isValidBST(root));
	}
}
