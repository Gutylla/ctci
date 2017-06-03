/**
 * 
 */
package educative;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class SumOfTwoValues {

	public boolean findSumOfTwo(int[] in, int val){
		if(in.length >= 2){
			HashSet<Integer> hash = new HashSet<Integer>();
			for(int i=0; i<in.length; i++){
				hash.add(in[i]);
				if(hash.contains(val - in[i]))
					return true;
			}
		}
		return false;
	}

	public boolean findSumOfTwoSortedVersion(int[] in, int val){ // assuming array is sorted
		if(in.length >= 3){
			HashMap<Integer, Integer> hash = new HashMap<>();
			int start = 0;
			int end = in.length-2;
			hash.put(in[in.length-1], 1);
			while(start < end){
				int diff = val - (in[start] + in[end]);
				if(hash.containsKey(diff) && (hash.get(diff) * diff + in[start] + in[end]) == val){
					System.out.println("(" + diff + ", " + in[start] + ", " + in[end] + ")");
				}
				if(in[start] + in[end] >= val){
					if(hash.containsKey(in[end])){
						int mult = hash.get(in[end])+1;
						hash.put(in[end], mult);
					}
					else
						hash.put(in[end], 1);
					end--;
				}
				else if(in[start] + in[end] < val){
					if(hash.containsKey(in[start])){
						int mult = hash.get(in[start])+1;
						hash.put(in[start], mult);
					}
					else
						hash.put(in[start], 1);
					start++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SumOfTwoValues obj = new SumOfTwoValues();
		int[] in = {1,2,2,2,3,4,5,7,7,7,14,15};
		int val = 21;
		obj.findSumOfTwoSortedVersion(in, val);
	}

}
