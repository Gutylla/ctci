/**
 * 
 */
package chapter2;


/**
 * @author triptibishnoi
 *
 */
public class LinkedLists1 {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.setData(9);
		list1.setData(9);
		list1.displayList();
		System.out.println("------");

		LinkedList list2 = new LinkedList();
		list2.setData(1);
		list2.displayList();
		System.out.println("------");

		LinkedList output = list1.addLists(list1, list2);
		output.displayList();
		//		list.setData('p');
		//		list.setData('u');
		//		list.setData('s');

		//		System.out.println("----------2.1-----------");
		//list.removeDuplicates()
		//list.displayList();

		//		System.out.println("----------2.2-----------");
		//		int n = 0;
		//		System.out.println(n + "th Last element");
		//System.out.println(list.nLastElement(n));

		//		System.out.println("-----------2.3-----------");
		//list.deleteLink();
		//		list.displayList();

		//		System.out.println("-----------2.4-----------");
		//		LinkedList a = new LinkedList();
		//		a.setData(9);
		//		a.setData(9);
		//		a.setData(9);
		//		
		//		LinkedList b = new LinkedList();
		//		b.setData(1);
		//		b.setData(1);
		//		b.setData(1);
		//		
		//		a.displayList();
		//		System.out.println("-----------");
		//		b.displayList();
		//		System.out.println("-----------");
		//		addLists(a,b).displayList();
		//		System.out.println("-----------");

		//		System.out.println("---------2.5--------------");
		//		System.out.println("Problem 2.5 is in Test Package>>> CircularLinkedList.java");
	}

	//	public static LinkedList addLists(LinkedList listA, LinkedList listB) {
	//		LinkedList outList = new LinkedList();
	//		Link currA = listA.first;
	//		Link currB = listB.first;
	//		int a, b, div = 0;
	//		if(listA.listLength() == listB.listLength()) {
	//			while(null!=currA && null!=currB) {
	//				a = currA.data;
	//				b = currB.data;
	//				outList.setData((a + b) % 10 + div);
	//				div = (a + b)/10;
	//				currA = currA.next;
	//				currB = currB.next;
	//			}
	//		}
	//		return outList;
	//	}


}

class Link {
	Link next;
	int data;

	public Link(int n) {
		data = n;
	}

	public void displayLink() {
		System.out.println(data);
	}
}

class LinkedList{
	Link first;

	public void setData(int i) {
		Link newLink = new Link(i);
		newLink.next = first;
		first = newLink;
	}

	public boolean isEmpty(){
		return (first == null);
	}

	public void displayList() {
		Link current = first;
		while(null != current) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	//Problem 2.1
	//	public void removeDuplicates(){
	//		Link current = first;
	//		while(null != current){
	//			char currValue = current.data;
	//			Link nextLink = current.next;
	//			Link prevLink = current;
	//			while(null != nextLink) {
	//				if(currValue == nextLink.data){
	//					prevLink.next = nextLink.next;
	//				}
	//				else{
	//					prevLink = prevLink.next;
	//				}
	//				nextLink = nextLink.next;
	//			}
	//			current = current.next;
	//		}
	//	}

	public int listLength(){
		Link current = first;
		int count = 0;
		while(null != current) {
			count += 1;
			current = current.next;
		}
		return count;
	}

	//Problem 2.2
	//	public char nLastElement(int n){
	//		Link current = first;
	//		Link newLink = first;
	//		if(current == null || n<1){
	//			System.out.println("list is empty!");
	//			return ' ';
	//		}
	//		for(int i=0; i<n-1; i++){
	//			newLink = newLink.next;
	//			if(null == newLink){
	//				System.out.println("not found, list size is less than asked!");
	//				return ' ';
	//			}
	//		}
	//		while(newLink.next != null) {
	//			current = current.next;
	//			newLink = newLink.next;
	//		}
	//		return current.data;
	//	}


	//Problem 2.3
	public void deleteLink(Link l) {
		//Link l = first;
		Link nextLink = l.next;
		if(null!= l || null != nextLink) {
			l.data = nextLink.data;
			l.next = nextLink.next;
		}
	}

	//Problem 2.4
	public LinkedList addLists(LinkedList listA, LinkedList listB) {
		LinkedList outList = new LinkedList();
		Link currA = listA.first;
		Link currB = listB.first;
		int a, b, div = 0;
		while(null!=currA || null!=currB) {
			a = currA != null ? currA.data : 0;
			b = currB != null ? currB.data : 0;
			outList.setData((a + b + div) % 10);
			div = (a + b + div)/10;
			currA = currA != null ? currA.next : currA;
			currB = currB != null ? currB.next : currB;
		}
		if(div > 0) outList.setData(div);
		return outList;
	}

}