/**
 * 
 */
package educative;

import java.util.ArrayList;

/**
 * @author TriptiAshishUpadhyay
 *
 */
public class Triplets {

	public void findTriplets(int[] arr){
		//assumption: arr is sorted, if not change method to sort in ascending order
		if(arr == null || arr.length < 3) 
			return;

		int len = arr.length;
		ArrayList<int[]> list = new ArrayList<>();

		for(int i=0; i<len; i++){
			if(arr[i] == 0) continue;

			int c = arr[i];

			int start = 0;
			int end = len-1;

			while(start <= end){
				if(start == i || arr[start] == 0){
					start++;
					continue;
				}
				if(end == i || arr[end] == 0){
					end--;
					continue;
				}

				int a = arr[start];
				int b = arr[end];

				int diff = a*a + b*b - c*c;
				if(diff == 0){
					list.add(new int[]{a,b,c});
					break;
				}
				else if(diff > 0)
					end--;
				else
					start++;
			}
		}
		System.out.println("done");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triplets obj = new Triplets();
		obj.findTriplets(new int[]{4,5,6,8,10,25});
	}

}
