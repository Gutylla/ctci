/**
 * 
 */
package chapter4;

/**
 * @author TriptiAshishUpadhyay
 *	implementation of BST
 *
 */
public class LearningTrees {

	Node root;

	public LearningTrees(){
		root = null;
	}

	public void insert(int data){
		Node temp = new Node();
		temp.data = data;
		temp.leftChild = null;
		temp.rightChild = null;
		if(null == root){
			root = temp;
		}
		else{
			Node current = root;
			Node parent = null;
			while(true){
				parent = current;
				if(data < current.data){
					current = parent.leftChild;
					if(current == null){
						parent.leftChild = temp;
						return;
					}
				}
				else {
					current = parent.rightChild;
					if(current == null){
						parent.rightChild = temp;
						return;
					}
				}
			}
		}
	}

	//Problem 4.3
	public Node createBST(int[] data, int start, int end){
		if(start > end)
			return null; 
		int mid = (start+end)/2;
		Node tempNode = new Node(data[mid]);
		tempNode.leftChild = createBST(data, start, mid-1);
		tempNode.rightChild = createBST(data, mid+1, end);
		return tempNode;

	}

	public void leftRotation(){
		Node curr = root;
		if( null != curr ) {
			int b = Math.abs(findHeight(curr.leftChild) - findHeight(curr.rightChild));
			if(b > 1) {
				curr.leftChild = curr;
				curr = curr.rightChild;
				return;
			}
			curr = curr.rightChild;
		}
	}

	public Node search(int data){
		Node current = root;
		while(null != current){
			if(current.data == data) return current;
			else{
				if(current.data > data) current = current.leftChild;
				else current = current.rightChild;
			}
		}
		return null;
	}

	//root, left tree, right tree
	public void preorderTraversal(Node current){
		if(null!= current){
			//visit root
			System.out.println(current.data);
			//visit left child
			preorderTraversal(current.leftChild);
			//visit right child
			preorderTraversal(current.rightChild);
		}
	}

	//output will be sorted keys
	//left tree, root, right tree
	public void inorderTraversal(Node current){
		if(null!= current){
			//visit left child
			inorderTraversal(current.leftChild);
			//visit root
			System.out.println(current.data);
			//visit right child
			inorderTraversal(current.rightChild);
		}
	}

	//left tree, right tree, root
	public void postorderTraversal(Node current){
		if(null!= current){
			//visit left child
			postorderTraversal(current.leftChild);
			//visit right child
			postorderTraversal(current.rightChild);
			//visit root
			System.out.println(current.data);
		}
	}

	public int min(){
		Node current = root;
		Node parent = current;
		while(current != null){
			parent = current;
			current = current.leftChild;
		}
		return parent!=null ? parent.data : -1;
	}

	public int max(){
		Node current = root;
		Node parent = current;
		while(current != null){
			parent = current;
			current = current.rightChild;
		}
		return parent!=null ? parent.data : -1;
	}

	//pending
	public void delete(int data){
		Node current = root;
		Node node = root;
		Node parent = null;
		while(null != current){
			if(current.data == data) {
				if(current.leftChild == null && current.rightChild == null){
					parent = null;
				}
				return;
			}
			else{
				parent = current;
				if(current.data > data) current = current.leftChild;
				else current = current.rightChild;
			}
		}
		if(node.leftChild == null && node.rightChild == null){
			parent = null;
		}
		else if(node.leftChild == null && node.rightChild != null){
			parent = node.rightChild;
		}
		else if(node.leftChild != null && node.rightChild == null){
			parent = node.leftChild;
		}
		else{

		}
	}

	public int findHeight(Node node){
		if (node == null) return 0;

		int leftHeight = findHeight(node.leftChild);
		int rightHeight = findHeight(node.rightChild);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public void balancingFactor(){
		int balanceFactor = 0;
		if(null != root)
			balanceFactor = Math.abs(findHeight(root.leftChild) - findHeight(root.rightChild));
		if(balanceFactor != 1)
			System.out.println("not balanced");
		else
			System.out.println("balanced !! ");
		return;
	}

	public static void main(String[] args) {
		LearningTrees lt = new LearningTrees();

		int[] arr = {1,2,3,4,5,6,7};
		lt.root = lt.createBST(arr, 0, arr.length-1);
		lt.inorderTraversal(lt.root);
		//		lt.insert(50);
		//		lt.insert(35);
		//		lt.insert(38);
		//		lt.insert(90);
		//		lt.insert(91);
		//		lt.insert(92);
		//		lt.insert(94);
		//		lt.insert(95);
		//		lt.insert(40);
		//		lt.insert(45);
		/*
		 *					50
		 *			35					90
		 *				38 					91
		 *					40					92
		 *						45					94
		 *												95
		 */

		//		System.out.println(lt.search(30));
		//		System.out.println("-----------------");
		//		lt.inorderTraversal(lt.root);
		//		System.out.println("-----------------");
		//		lt.preorderTraversal(lt.root);
		//		System.out.println("-----------------");
		//		lt.postorderTraversal(lt.root);
		//		System.out.println("-----------------");
		//		System.out.println("min value: " + lt.min());
		//		System.out.println("-----------------");
		//		System.out.println("max value: " + lt.max());
		//		System.out.println("-----------------");
		//		lt.inorderTraversal(lt.root);

		//		lt.balancingFactor();
	}

}

class Node{
	int data;
	Node leftChild;
	Node rightChild;

	public Node(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node(){
		this.data = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
}
