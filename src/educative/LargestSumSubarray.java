/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class LargestSumSubarray {

	public int method(int[] a){
		if(a.length < 1) return -1;

		int globalMax = a[0];
		ArrayList<Integer> globalIndex = new ArrayList<>();
		globalIndex.add(0);

		int currentMax = a[0];
		ArrayList<Integer> currentIndex = new ArrayList<>();
		currentIndex.add(0);

		for(int i=1; i<a.length; i++){
			if(currentMax < 0){
				currentMax = a[i];
				currentIndex.clear();
				currentIndex.add(i);
			}
			else{
				currentMax += a[i];
				currentIndex.add(i);
			}
			if(globalMax < currentMax){
				globalMax = currentMax;
				globalIndex.clear();
				globalIndex.addAll(currentIndex);
			}
		}

		return globalMax;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSumSubarray obj = new LargestSumSubarray();
		System.out.println(obj.method(new int[]{4,-1,3,2,-2}));
	}

}
