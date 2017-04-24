/**
 * 
 */
package chapter4;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class BinaryTree {

	Link root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	public void insert(int data){
		Link current = root;
		Link tempLink = new Link(data);
		if(null == root){
			root = tempLink;
			return;
		}
		while(null != current){
			if(null == current.leftChild){
				current.leftChild = tempLink;
				return;
			}
			else if(null == current.rightChild){
				current.rightChild = tempLink;
				return;
			}
			else
				current = current.leftChild;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Link{
	int data;
	Link leftChild;
	Link rightChild;
	
	public Link(int data){
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}