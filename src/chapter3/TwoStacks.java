/**
 * 
 */
package chapter3;

/**
 * @author triptibishnoi
 *
 */
public class TwoStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TwoStack ts = new TwoStack();

		push1(1,ts);
		push1(2,ts);
		push1(3,ts);
		push2(4,ts);
		push2(5,ts);
		push1(1,ts);
		push1(2,ts);
		push1(3,ts);
		push2(4,ts);
		push2(5,ts);
		push1(1,ts);
		push1(2,ts);
		push1(3,ts);
		push2(4,ts);
		push2(5,ts);
	}

	/* The method push to push element into the stack 1 */
	static void push1(int x, TwoStack sq)
	{
		if(sq.top1 < sq.top2 -1)
			sq.arr[++sq.top1] = x;
	}

	/* The method push to push element into the stack 2*/
	static void push2(int x, TwoStack sq)
	{
		if(sq.top2 > sq.top1 +1)
			sq.arr[--sq.top2] = x;
	}

	/* The method pop to pop element from the stack 1 */
	static int pop1(TwoStack sq)
	{
		if(sq.top1 != -1) return sq.arr[sq.top1--];
		else return -1;
	}

	/* The method pop to pop element from the stack 2 */
	static int pop2(TwoStack sq)
	{
		if(sq.top2 != sq.size) return sq.arr[sq.top2++];
		else return -1;
	}
}

//
//	public int singleNonDuplicate() {
//		int[] dim = {1,2,2,4,4};
//		int len = dim.length;
//		for(int i =0; i<len;){
//			if(i+1 < len && dim[i] == dim[i+1]) i += 2;
//			else return dim[i];
//		}
//		System.out.println("no non duplicates");
//		return 0;
//	}

class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[10];

	TwoStack()
	{
		size = 10;
		top1 = -1;
		top2 = size;
	}
}