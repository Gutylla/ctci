/**
 * 
 */
package test;

/**
 * @author triptibishnoi
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();

		list.insertFirst(2);
		list.insertFirst(4);
		list.insertFirst(3);
		list.insertFirst(8);
		list.insertFirst(9);

		list.displayList();

		System.out.println("------starting sort.....--------------");

		list.selectionSort(list);
		System.out.println("--------sort done------------");
		list.displayList();
		System.out.println("-----------ding ding---------");

		System.out.println(list.isEmpty());

		System.out.println("--------------------");
		System.out.println(list.find(3));

		System.out.println("--------------------");
		System.out.println(list.delete(4));
		list.displayList();
	}


}

class Link {
	public Link next;
	public int data;

	public Link(int s) {
		data = s;
	}

	public void displayLink() {
		System.out.println("data: "+data);
	}
}

class LinkList {
	Link first;

	public void LinkList(){ //not necessary, default is set to null
		first = null;
	}

	public boolean isEmpty(){
		return (null==first);
	}

	public void insertFirst(int data){
		Link newLink = new Link(data);
		newLink.next = first;
		first = newLink;
	}

	public void deleteFirst() {
		first = first.next;
	}

	public void displayList() {
		Link current = first;
		while(null != current) {
			current.displayLink();
			current = current.next;
		}
	}

	public Link find(int s){
		Link current = first;
		while(null != current){
			if(s == current.data){
				System.out.println("found "+ s);
				return current;
			}
			else{
				current = current.next;
			}
		}
		return null;
	}

	public String delete(int s){
		Link prev = first;
		Link current = first;
		while(null != current){
			if(s == current.data){
				prev.next = current.next;
				return "deleted";
			}
			else{
				prev = current;
				current = current.next;
			}
		}
		return "not found";
	}

	public String selectionSort(LinkList var){
		Link current = first;
		Link minLink;
		int minValue;
		while(null != current){
			minValue = current.data;
			minLink = current;
			Link newLink = current.next;
			while( newLink != null){
				if(newLink.data < minValue) {
					minLink = newLink;
					minValue = minLink.data;
				}
				newLink = newLink.next;
			}
			int temp = current.data;
			current.data = minValue;
			minLink.data = temp;
			current = current.next;
		}
		return "done";
	}

}