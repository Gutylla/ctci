/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class FindKthPermutation {

	public void kthPermutation(ArrayList<Integer> arr, int k, ArrayList<Integer> result){
		if(arr.size() < 1){
			System.out.println("---------");
			for(int i=0; i<result.size(); i++)
				System.out.println(result.get(i));
			return;
		}
		
		int blockSize = fact(arr.size()-1);
		int selectedBlock = (k-1)/blockSize;
		
		result.add(arr.get(selectedBlock));
		arr.remove(selectedBlock);
		
		kthPermutation(arr,k-(blockSize*selectedBlock),result);
	}
	
	private int fact(int n){
		if(n==1 || n==0)
			return 1;
		else
			return (n * fact(n-1));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKthPermutation obj = new FindKthPermutation();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		obj.kthPermutation(arr, 7, new ArrayList<Integer>());
	}

}
