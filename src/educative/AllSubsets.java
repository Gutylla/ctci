/**
 * 
 */
package educative;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class AllSubsets {

	public void getSubsets(ArrayList<Integer> arr, ArrayList<HashSet<Integer>> sets){
		int setsCount = (int) Math.pow((double)2, (double)arr.size());
		for(int i=0; i<=setsCount; i++){
			HashSet<Integer> set = new HashSet<>();
			for(int j=0; j<arr.size(); j++){
				if(getBit(j,i))
					set.add(arr.get(j));
			}
			sets.add(set);
		}
	}
	
	private boolean getBit(int index, int binary){
		//1- true, 0- false
		int temp = (1 << index);
		temp = temp & binary;
		return (temp == 0) ? false : true; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
