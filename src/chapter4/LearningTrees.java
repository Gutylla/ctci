/**
 * 
 */
package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.sun.org.apache.xpath.internal.operations.Lt;

/**
 * @author TriptiAshishUpadhyay implementation of BST
 *
 */
public class LearningTrees {

	Node root;

	public LearningTrees() {
		root = null;
	}

	public void insert(int data) {
		Node temp = new Node(data);
		if (null == root) {
			temp.parent = null;
			root = temp;
		} else {
			Node current = root;
			Node parentVar = null;
			while (true) {
				parentVar = current;
				if (data < current.data) {
					current = parentVar.leftChild;
					if (current == null) {
						temp.parent = parentVar;
						parentVar.leftChild = temp;
						return;
					}
				} else {
					current = parentVar.rightChild;
					if (current == null) {
						temp.parent = parentVar;
						parentVar.rightChild = temp;
						return;
					}
				}
			}
		}
	}

	// Problem 4.5 4th Edition
	public int findNextNode(Node node) {
		if (node.rightChild != null) {
			Node current = node.rightChild;
			Node par = null;
			while (current != null) {
				par = current;
				current = current.leftChild;
			}
			return par.data;
		} else {
			if (node.parent != null) {
				if (node.parent.leftChild == node) {
					return node.parent.data;
				} else {
					if (node.rightChild != null)
						return findNextNode(node);
					else {
						Node current = node;
						Node grandPar = node.parent;
						while (grandPar != null && grandPar.rightChild == current) {
							current = grandPar;
							if (grandPar.parent == null)
								return -1;
							else
								grandPar = grandPar.parent;
						}
						return grandPar.data;
					}
				}
			} else
				return -1;
		}
	}

	// Problem 4.3 4th Edition
	public Node createBST(int[] data, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node tempNode = new Node(data[mid]);
		tempNode.leftChild = createBST(data, start, mid - 1);
		tempNode.rightChild = createBST(data, mid + 1, end);
		return tempNode;
	}

	public Node search(int data) {
		Node current = root;
		while (null != current) {
			if (current.data == data)
				return current;
			else {
				if (current.data > data)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
		}
		return null;
	}

	// root, left tree, right tree
	public void preorderTraversal(Node current) {
		if (null != current) {
			// visit root
			System.out.println(current.data);
			// visit left child
			preorderTraversal(current.leftChild);
			// visit right child
			preorderTraversal(current.rightChild);
		}
	}

	// output will be sorted keys
	// left tree, root, right tree
	public void inorderTraversal(Node current) {
		if (null != current) {
			// visit left child
			inorderTraversal(current.leftChild);
			// visit root
			System.out.println(current.data);
			// visit right child
			inorderTraversal(current.rightChild);
		}
	}

	public void inorderIterative(Node root) {
		Node current = root;
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || current != null) {
			if (root != null) {
				stack.push(current);
				current = current.leftChild;
				continue;
			}
			System.out.println(stack.peek().data);
			current = stack.pop().rightChild;
		}
	}

	// left tree, right tree, root
	public void postorderTraversal(Node current) {
		if (null != current) {
			// visit left child
			postorderTraversal(current.leftChild);
			// visit right child
			postorderTraversal(current.rightChild);
			// visit root
			System.out.println(current.data);
		}
	}

	public int min() {
		Node current = root;
		Node parent = current;
		while (current != null) {
			parent = current;
			current = current.leftChild;
		}
		return parent != null ? parent.data : -1;
	}

	public int max() {
		Node current = root;
		Node parent = current;
		while (current != null) {
			parent = current;
			current = current.rightChild;
		}
		return parent != null ? parent.data : -1;
	}

	// pending
	public void delete(int data) {
		Node current = root;
		Node node = root;
		Node parent = null;
		while (null != current) {
			if (current.data == data) {
				if (current.leftChild == null && current.rightChild == null) {
					parent = null;
				}
				return;
			} else {
				parent = current;
				if (current.data > data)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
		}
		if (node.leftChild == null && node.rightChild == null) {
			parent = null;
		} else if (node.leftChild == null && node.rightChild != null) {
			parent = node.rightChild;
		} else if (node.leftChild != null && node.rightChild == null) {
			parent = node.leftChild;
		} else {

		}
	}

	public int findHeight(Node node) {
		if (node == null)
			return 0;

		int leftHeight = findHeight(node.leftChild);
		int rightHeight = findHeight(node.rightChild);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public void balancingFactor() {
		int balanceFactor = 0;
		if (null != root)
			balanceFactor = Math.abs(findHeight(root.leftChild) - findHeight(root.rightChild));
		if (balanceFactor != 1)
			System.out.println("not balanced");
		else
			System.out.println("balanced !! ");
		return;
	}

	// Problem 4.4 4th Edition
	HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();

	public HashMap<Integer, ArrayList<Integer>> nodesAtLevels(Node node, int level) {
		if (null != node) {
			ArrayList<Integer> list = hash.get(level);
			if (list != null)
				list.add(node.data);
			else {
				list = new ArrayList<Integer>();
				list.add(node.data);
			}
			hash.put(level, list);
			if (level > 1) {
				nodesAtLevels(node.leftChild, level - 1);
				nodesAtLevels(node.rightChild, level - 1);
			}
		}
		return hash;
	}

	// Problem 4.9 6th edition
	public void printPossibleInputs() {
		int height = findHeight(root);
		HashMap<Integer, ArrayList<Integer>> myhash = nodesAtLevels(root, height);
		ArrayList<Integer> arr = new ArrayList<Integer>();

		while (height > 0) {
			arr.addAll(myhash.get(height));
			height -= 1;
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	public void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> curr = new ArrayDeque<Node>();
		Queue<Node> next = new ArrayDeque<Node>();

		curr.add(root);

		while (!curr.isEmpty()) {
			Node temp = curr.poll();
			if (temp.leftChild != null)
				next.add(temp.leftChild);
			if (temp.rightChild != null)
				next.add(temp.rightChild);
			System.out.println(temp.data);
			if (curr.isEmpty()) {
				curr = next;
				next = new ArrayDeque<Node>();
			}
		}
	}
	
	
	//--------------------------------vertical order traversal
	
    public List<Integer> verticalOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        verticalOrder(root, queue, map);
        return null;
    }
    
    public void verticalOrder(Node root, Queue<Node> queue, HashMap<Integer, List<Integer>> map){
        if(root == null)
            return;
        
        queue.add(root);
        int hd = 0;
        List<Integer> list = new ArrayList<>();
        list.add(root.data);
        map.put(hd, list);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll(); 
            if(curr.leftChild != null){
                queue.add(curr.leftChild);
                List<Integer> tempList = map.containsKey(hd-1) ? map.get(hd-1) : new ArrayList<>();
                tempList.add(curr.leftChild.data);
                map.put(hd-1, tempList);
            }
            if(curr.rightChild != null){
                queue.add(curr.rightChild);
                List<Integer> tempList = map.containsKey(hd+1) ? map.get(hd+1) : new ArrayList<>();
                tempList.add(curr.rightChild.data);
                map.put(hd+1, tempList);
            }
        }
    }
	//--------------------------------------------------------

	public static void main(String[] args) {
		
		LearningTrees lt = new LearningTrees();
		
		lt.insert(9);
		lt.insert(1);
		lt.insert(2);
		lt.insert(3);
		lt.insert(5);
		lt.insert(20);
		lt.insert(12);
		lt.insert(15);
		lt.insert(30);
		
		
		lt.verticalOrderTraversal(lt.root);
		System.out.println("done");
		
		// lt.insert(10);
		// lt.insert(20);
		// lt.insert(30);

		// int[] arr = {1,2,3,4,5,6,7};
		// lt.root = lt.createBST(arr, 0, arr.length-1);
		// lt.inorderTraversal(lt.root);
		// System.out.println("--------------");
		// lt.levelOrder(lt.root);

//		int[] input = { 20, 14, 50, 12, 17, 48 };
//		for (int i = 0; i < input.length; i++)
//			lt.insert(input[i]);
//
//		lt.printTree(lt.root);
		// lt.printPossibleInputs();

		// for(int i=0; i<input.length; i++)
		// System.out.println(input[i]+": "+
		// lt.findNextNode(lt.search(input[i])));
		// lt.nodesAtLevels(lt.root, lt.findHeight(lt.root));
		// System.out.println(lt.search(30));
		// System.out.println("-----------------");
		// lt.inorderTraversal(lt.root);
		// System.out.println("-----------------");
		// lt.preorderTraversal(lt.root);
		// System.out.println("-----------------");
		// lt.postorderTraversal(lt.root);
		// System.out.println("-----------------");
		// System.out.println("min value: " + lt.min());
		// System.out.println("-----------------");
		// System.out.println("max value: " + lt.max());
		// System.out.println("-----------------");
		// lt.inorderTraversal(lt.root);

		// lt.balancingFactor();
	}

	public List<List<String>> printTree(Node root) {
		List<int[]> order = new ArrayList<>();
		if (root != null)
			levelOrder(root, 0, order);

		int rows = height(root);
		int cols = power(2, rows)-1;
		String[][] matrix = new String[rows][cols];
		return null;
	}
	
	public int height(Node root){
        if(root==null)
            return 0;
        int left = height(root.leftChild);
        int right = height(root.rightChild);
        if(left>right)
            return left+1;
        else
            return right+1;
    }

	public void levelOrder(Node root, int depth, List<int[]> order) {
		order.add(new int[] { depth, root.data });
		if (root.leftChild != null)
			levelOrder(root.leftChild, depth + 1, order);
		if (root.rightChild != null)
			levelOrder(root.rightChild, depth + 1, order);

	}

	public int power(int n, int p) {
		if (n == 0 || n == 1 || p == 1)
			return n;
		if (p == 0)
			return 1;
		int pow = power(n, p / 2);
		if (p % 2 == 0)
			return pow * pow;
		else
			return n * pow * pow;
	}

}

class Node {
	int data;
	Node leftChild;
	Node rightChild;
	Node parent;

	public Node(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node() {
		this.data = 0;
		this.leftChild = null;
		this.rightChild = null;
	}
}
